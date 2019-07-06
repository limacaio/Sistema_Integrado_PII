package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Controller.CategoriaController;
import Controller.MarcaController;
import Controller.UsuarioController;
import Model.Categoria;
import Model.Marca;
import Model.Usuario;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GerCategoria extends JFrame {

	private JPanel contentPane;
	private JTable tblCategoria;
	private JTextField txtDescricao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerCategoria frame = new GerCategoria();
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
	public GerCategoria() {
		setTitle("CATEGORIAS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 582, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Categoria",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 363, 208);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 23, 343, 174);
		panel.add(scrollPane);

		tblCategoria = new JTable();
		tblCategoria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (tblCategoria.getSelectedRow() != -1) {

					txtDescricao.setText(tblCategoria.getValueAt(tblCategoria.getSelectedRow(), 1).toString());

				}
			}
		});
		tblCategoria.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Codigo", "Descri\u00E7\u00E3o", "" }));
		scrollPane.setViewportView(tblCategoria);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(396, 11, 148, 208);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				atualizarTabela();
			}
		});
		btnAtualizar.setBounds(32, 57, 89, 23);
		panel_1.add(btnAtualizar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(32, 179, 89, 23);
		panel_1.add(btnCancelar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tblCategoria.getSelectedRow() != -1) {
					Categoria categoria = new Categoria();
					CategoriaController categoriaController = new CategoriaController();
					categoria.setIdCategoria((int) tblCategoria.getValueAt(tblCategoria.getSelectedRow(), 0));

					categoriaController.excluirCategoriaController(categoria);
				}
				atualizarTabela();
			}
		});
		btnExcluir.setBounds(32, 135, 89, 23);
		panel_1.add(btnExcluir);

		JButton button = new JButton("Novo");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CadCategoria cadCategoria = new CadCategoria();
				cadCategoria.setVisible(true);
				cadCategoria.setLocationRelativeTo(null);
				atualizarTabela();
			}
		});
		button.setBounds(32, 22, 89, 23);
		panel_1.add(button);

		JButton button_1 = new JButton("Salvar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				alterarLinhaTabela();
			}
		});
		button_1.setBounds(32, 101, 89, 23);
		panel_1.add(button_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Editar Categoria", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(10, 230, 363, 89);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		txtDescricao = new JTextField();
		txtDescricao.setBounds(10, 48, 269, 20);
		panel_2.add(txtDescricao);
		txtDescricao.setColumns(10);

		JLabel lblDescria = new JLabel("Descri\u00E7\u00E3o");
		lblDescria.setBounds(10, 29, 61, 14);
		panel_2.add(lblDescria);
	}

	public void alterarLinhaTabela() {

		if (tblCategoria.getSelectedRow() != -1) {

			Categoria categoria = new Categoria();
			CategoriaController categoriaController = new CategoriaController();
			categoria.setDescricao(txtDescricao.getText());
			categoria.setIdCategoria((int) tblCategoria.getValueAt(tblCategoria.getSelectedRow(), 0));
			categoriaController.atualizarCategoriaController(categoria);
			txtDescricao.setText("");
			atualizarTabela();
		}

	}

	public void atualizarTabela() {

		Object colunas[] = { "Codigo", "Descrição" };
		DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

		CategoriaController categoriaController = new CategoriaController();
		for (Categoria categoria : categoriaController.buscarCategoriasController()) {
			Object linha[] = new Object[] { categoria.getIdCategoria(), categoria.getDescricao() };
			modelo.addRow(linha);
		}
		tblCategoria.setModel(modelo);
	}
}
