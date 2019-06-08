package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela_login extends JFrame {

	private JPanel contentPane;
	private JTextField txtLoginUsuario;
	private JPasswordField pwsLoginSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_login frame = new Tela_login();
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
	public Tela_login() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("USUARIO ");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(160, 34, 82, 14);
		contentPane.add(lblUsuario);
		
		txtLoginUsuario = new JTextField();
		txtLoginUsuario.setBounds(78, 59, 300, 20);
		contentPane.add(txtLoginUsuario);
		txtLoginUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("SENHA");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setBounds(181, 99, 46, 14);
		contentPane.add(lblSenha);
		
		pwsLoginSenha = new JPasswordField();
		pwsLoginSenha.setBounds(78, 124, 300, 20);
		contentPane.add(pwsLoginSenha);
		
		JButton btnLoginEntrar = new JButton("ENTRAR");
		btnLoginEntrar.addActionListener(new ActionListener() {
			/**
			 * 
			 * chamando o menu assim que clikar no botão entrar
			 * 
			 * WINSTON 08-06-2019
			 * 
			 * 
			 * **/
			
			
			public void actionPerformed(ActionEvent e) {
				
				Tela_login.this.setVisible(false);
				Menu menu = new Menu();
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				
				
				
			}
		});
		btnLoginEntrar.setBounds(111, 195, 89, 23);
		contentPane.add(btnLoginEntrar);
		
		JButton btnLoginSair = new JButton("SAIR");
		btnLoginSair.addActionListener(new ActionListener() {
			/**
			 * SAIR 
			 * 
			 * WINSTON 08-06-2019
			 * 
			 * **/
			
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnLoginSair.setBounds(229, 195, 89, 23);
		contentPane.add(btnLoginSair);
	}
}
