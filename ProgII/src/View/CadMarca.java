package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

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
		setTitle("Marca");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 582, 184);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtDescMarca = new JTextField();
		txtDescMarca.setColumns(10);
		txtDescMarca.setBounds(10, 50, 278, 20);
		contentPane.add(txtDescMarca);
		
		JLabel lblDescrioMarca = new JLabel("Descri\u00E7\u00E3o Marca");
		lblDescrioMarca.setBounds(10, 25, 131, 14);
		contentPane.add(lblDescrioMarca);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(359, 21, 89, 23);
		contentPane.add(btnNovo);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(359, 55, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnVisualizar = new JButton("Visualizar");
		btnVisualizar.setBounds(411, 93, 89, 23);
		contentPane.add(btnVisualizar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(458, 55, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(458, 21, 89, 23);
		contentPane.add(btnSalvar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(0, 11, 325, 123);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(340, 11, 216, 123);
		contentPane.add(panel_1);
	}
	
	
}
