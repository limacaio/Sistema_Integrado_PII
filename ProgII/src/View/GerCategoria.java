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
import Controller.UsuarioController;
import Model.Categoria;
import Model.Usuario;

public class GerCategoria extends JFrame {

	private JPanel contentPane;
	private JTable tblCategoria;

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
	public GerCategoria() {
		setTitle("CATEGORIAS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Categoria", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 363, 239);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 343, 205);
		panel.add(scrollPane);
		
		tblCategoria = new JTable();
		tblCategoria.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Descri\u00E7\u00E3o", ""
			}
		));
		scrollPane.setViewportView(tblCategoria);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(396, 11, 148, 170);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*GerCategoria categ = new GerCategoria();
				categ.atualizarTabela();
				*/
			}
		});
		btnAtualizar.setBounds(32, 11, 89, 23);
		panel_1.add(btnAtualizar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(32, 129, 89, 23);
		panel_1.add(btnCancelar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tblCategoria.getSelectedRow() != -1) {
					Categoria categoria = new Categoria();
					CategoriaController categoriaController = new CategoriaController();
					categoria.setIdCategoria((int) tblCategoria.getValueAt(tblCategoria.getSelectedRow(), 0));
					
					categoriaController.excluirCategoriaController(categoria);
				}
				atualizarTabela();
			}
		});
		btnExcluir.setBounds(32, 66, 89, 23);
		panel_1.add(btnExcluir);
	}
	
public void atualizarTabela() {
		
		Object colunas [] = {"Codigo", "Descrição"};
		DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
		
		CategoriaController categoriaController = new CategoriaController();
		for(Categoria categoria : categoriaController.buscarCategoriasController()) {
			Object linha[] = new Object[]{categoria.getIdCategoria(),categoria.getDescricao()};
			modelo.addRow(linha);
		}
		tblCategoria.setModel(modelo);
	}
}
