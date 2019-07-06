package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import Controller.CategoriaController;
import Model.Categoria;

public class CadCategoria extends JFrame {

	private JPanel contentPane;
	private JTextField txtDescCateg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadCategoria frame = new CadCategoria();
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
	public CadCategoria() {
		setTitle("Categoria");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 184);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDescrioCategoria = new JLabel("Descri\u00E7\u00E3o Categoria");
		lblDescrioCategoria.setBounds(10, 25, 131, 14);
		contentPane.add(lblDescrioCategoria);
		
		txtDescCateg = new JTextField();
		txtDescCateg.setBounds(10, 50, 326, 20);
		contentPane.add(txtDescCateg);
		txtDescCateg.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(0, 11, 354, 123);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(364, 11, 165, 123);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		//CHAMANDO A TABELA DE CATEGORIAS
		JButton btnVisualizar = new JButton("Visualizar");
		btnVisualizar.setBounds(34, 45, 99, 23);
		panel_1.add(btnVisualizar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(34, 11, 99, 23);
		panel_1.add(btnSalvar);
		
		JButton btnExcluir = new JButton("Cancelar");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnExcluir.setBounds(34, 79, 99, 23);
		panel_1.add(btnExcluir);
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GerCategoria categ = new GerCategoria();
				Categoria categoria = new Categoria();
		        CategoriaController categoriaController = new CategoriaController();
		        
		        categoria.setDescricao(txtDescCateg.getText());
		        
		        categoriaController.inserirCategoriaController(categoria);
		        txtDescCateg.setText("");
		        
		        categ.atualizarTabela();
		        
			}
		});
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GerCategoria categ = new GerCategoria();
				categ.setVisible(true);
				categ.setLocationRelativeTo(null);
				categ.atualizarTabela();
			}
		});
	}
}
