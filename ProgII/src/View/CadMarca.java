package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CadMarca extends JFrame {

	private JPanel contentPane;
	private JTextField txtDescCateg;

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
		setTitle("Marca");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 541, 184);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDescrioCategoria = new JLabel("Descri\u00E7\u00E3o Marca");
		lblDescrioCategoria.setBounds(10, 25, 131, 14);
		contentPane.add(lblDescrioCategoria);
		
		txtDescCateg = new JTextField();
		txtDescCateg.setBounds(10, 50, 278, 20);
		contentPane.add(txtDescCateg);
		txtDescCateg.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(92, 110, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(220, 110, 89, 23);
		contentPane.add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(343, 110, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnNova = new JButton("Nova");
		btnNova.setBounds(343, 49, 89, 23);
		contentPane.add(btnNova);
	}
	
	
}
