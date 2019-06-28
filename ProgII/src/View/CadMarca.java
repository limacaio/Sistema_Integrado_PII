package View;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import Controller.CategoriaController;
import Controller.MarcaController;
import Model.Marca;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadMarca extends JFrame {

	private JPanel contentPane;
	private JTextField txtDescMarca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadMarca frame = new CadMarca();
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
	public CadMarca() {
		setTitle("MARCA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 582, 184);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtDescMarca = new JTextField();
		txtDescMarca.setColumns(10);
		txtDescMarca.setBounds(10, 50, 328, 20);
		contentPane.add(txtDescMarca);
		
		JLabel lblDescrioMarca = new JLabel("Descri\u00E7\u00E3o Marca");
		lblDescrioMarca.setBounds(10, 25, 131, 14);
		contentPane.add(lblDescrioMarca);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(0, 11, 356, 123);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(366, 11, 176, 123);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		//salvando marca
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GerMarca gerMarca = new GerMarca();
				Marca marca = new Marca();
		        MarcaController marcaController = new MarcaController();
		        
		        marca.setDescricaoMarca(txtDescMarca.getText());
		        
		        marcaController.inserirMarcaController(marca);
		        txtDescMarca.setText("");
		        
		        gerMarca.atualizarTabela();
		        
			}
		});
		btnSalvar.setBounds(48, 11, 83, 23);
		panel_1.add(btnSalvar);
		
		JButton btnExcluir = new JButton("Cancelar");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		btnExcluir.setBounds(48, 89, 83, 23);
		panel_1.add(btnExcluir);
		
		JButton btnVisualizar = new JButton("Visualizar");
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GerMarca gerMarca = new GerMarca();
				gerMarca.setVisible(true);
				gerMarca.setLocationRelativeTo(null);
				gerMarca.atualizarTabela();
			}
		});
		btnVisualizar.setBounds(48, 55, 83, 23);
		panel_1.add(btnVisualizar);
	}
	
	
}
