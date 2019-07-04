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

public class GerMarca extends JFrame {

	private JPanel contentPane;
	private JTable tblMarca;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 582, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Marca", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 363, 239);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 343, 205);
		panel.add(scrollPane);
		
		tblMarca = new JTable();
		tblMarca.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Descri\u00E7\u00E3o", ""
			}
		));
		scrollPane.setViewportView(tblMarca);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(408, 11, 148, 181);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//updateLinhaTabela();
			
				
			}
			
		});
		btnAtualizar.setBounds(32, 26, 89, 23);
		panel_1.add(btnAtualizar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(32, 133, 89, 23);
		panel_1.add(btnCancelar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tblMarca.getSelectedRow() != -1) {
					Marca marca = new Marca();
					MarcaController marcaController = new MarcaController();
					marca.setIdMarca((int) tblMarca.getValueAt(tblMarca.getSelectedRow(), 0));
					
					marcaController.excluirMarcaController(marca);
				}
				atualizarTabela();
			}
		});
		btnExcluir.setBounds(32, 80, 89, 23);
		panel_1.add(btnExcluir);
	}
	
public void atualizarTabela() {
		
		Object colunas [] = {"Codigo", "Descricao"};
		DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
		
		MarcaController marcaController = new MarcaController();
		for(Marca marca : marcaController.buscarMarcaController()) {
			Object linha[] = new Object[]{marca.getIdMarca(),marca.getDescricaoMarca()};
			modelo.addRow(linha);
		}
		tblMarca.setModel(modelo);
	}

//ESSE METODO ERA PRA EDITAR A MARCA SELECIONADA NA TABELA :(

/*public void updateLinhaTabela() {
	
	if(tblMarca.getSelectedRow()!= -1) {
		
		Marca m = new Marca();
		MarcaController marcaController = new MarcaController();
		m.setDescricaoMarca(tblMarca.getValueAt(tblMarca.getSelectedRow(),1).toString());
		
		JOptionPane.showInputDialog(null,"Insira Nova Marca",m.getDescricaoMarca());
		
		
		marcaController.atualizarMarcaController(m);
		
	}
	atualizarTabela();
	
}*/
}
