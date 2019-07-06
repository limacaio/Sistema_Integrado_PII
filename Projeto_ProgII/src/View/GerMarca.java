package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Controller.CategoriaController;
import Controller.MarcaController;
import Model.Categoria;
import Model.Marca;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ScrollPaneConstants;

public class GerMarca extends JFrame {

	private JPanel contentPane;
	private JTable tblMarca;
	private JTextField txtDescricao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerMarca frame = new GerMarca();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GerMarca() {
		setTitle("Visualiza Marcas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 582, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Marca", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 363, 181);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 23, 343, 147);
		panel.add(scrollPane);

		tblMarca = new JTable();
		tblMarca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (tblMarca.getSelectedRow() != -1) {

					txtDescricao.setText(tblMarca.getValueAt(tblMarca.getSelectedRow(), 1).toString());

				}

			}
		});
		tblMarca.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Codigo", "Descri\u00E7\u00E3o", "" }));
		scrollPane.setViewportView(tblMarca);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(408, 11, 148, 218);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnAtualizar = new JButton("Salvar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				alterarLinhaTabela();

			}

		});
		btnAtualizar.setBounds(32, 53, 89, 23);
		panel_1.add(btnAtualizar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(32, 184, 89, 23);
		panel_1.add(btnCancelar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tblMarca.getSelectedRow() != -1) {
					Marca marca = new Marca();
					MarcaController marcaController = new MarcaController();
					marca.setIdMarca((int) tblMarca.getValueAt(tblMarca.getSelectedRow(), 0));

					marcaController.excluirMarcaController(marca);
				}
				atualizarTabela();
			}
		});
		btnExcluir.setBounds(32, 143, 89, 23);
		panel_1.add(btnExcluir);

		JButton btnSalvar = new JButton("Novo");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CadMarca cadMarca = new CadMarca();
				cadMarca.setVisible(true);
				cadMarca.setLocationRelativeTo(null);
				atualizarTabela();
			}
		});
		btnSalvar.setBounds(32, 11, 89, 23);
		panel_1.add(btnSalvar);

		JButton btnAtualiza = new JButton("Atualizar");
		btnAtualiza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				atualizarTabela();
			}
		});
		btnAtualiza.setBounds(32, 99, 89, 23);
		panel_1.add(btnAtualiza);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Editar Marca", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 214, 363, 91);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		txtDescricao = new JTextField();
		txtDescricao.setBounds(10, 46, 258, 20);
		panel_2.add(txtDescricao);
		txtDescricao.setColumns(10);

		JLabel lblNewLabel = new JLabel("Descri\u00E7\u00E3o");
		lblNewLabel.setBounds(10, 26, 71, 14);
		panel_2.add(lblNewLabel);
	}

//ESSE METODO ERA PRA EDITAR A MARCA SELECIONADA NA TABELA :(

	public void alterarLinhaTabela() {

		if (tblMarca.getSelectedRow() != -1) {

			Marca marca = new Marca();
			MarcaController marcaController = new MarcaController();
			marca.setDescricaoMarca(txtDescricao.getText());
			marca.setIdMarca((int) tblMarca.getValueAt(tblMarca.getSelectedRow(), 0));
			marcaController.atualizarMarcaController(marca);
			txtDescricao.setText("");
			atualizarTabela();
		}

	}

	public void atualizarTabela() {

		Object colunas[] = { "Codigo", "Descricao" };
		DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

		MarcaController marcaController = new MarcaController();
		for (Marca marca : marcaController.buscarMarcaController()) {
			Object linha[] = new Object[] { marca.getIdMarca(), marca.getDescricaoMarca() };
			modelo.addRow(linha);
		}
		tblMarca.setModel(modelo);
	}
}
