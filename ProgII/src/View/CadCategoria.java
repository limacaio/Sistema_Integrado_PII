package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

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
		setBounds(100, 100, 582, 184);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDescrioCategoria = new JLabel("Descri\u00E7\u00E3o Categoria");
		lblDescrioCategoria.setBounds(10, 25, 131, 14);
		contentPane.add(lblDescrioCategoria);
		
		txtDescCateg = new JTextField();
		txtDescCateg.setBounds(10, 50, 278, 20);
		contentPane.add(txtDescCateg);
		txtDescCateg.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(458, 21, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnEditar = new JButton("Alterar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditar.setBounds(359, 55, 89, 23);
		contentPane.add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(458, 55, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnNova = new JButton("Novo");
		btnNova.setBounds(359, 21, 89, 23);
		contentPane.add(btnNova);
		
		JButton btnVisualizar = new JButton("Visualizar");
		btnVisualizar.setBounds(411, 93, 89, 23);
		contentPane.add(btnVisualizar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(0, 11, 325, 123);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(346, 11, 216, 123);
		contentPane.add(panel_1);
	}
}
