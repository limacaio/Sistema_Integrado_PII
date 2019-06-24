package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.UsuarioDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

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
					Login frame = new Login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("USUARIO ");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(184, 34, 82, 14);
		contentPane.add(lblUsuario);
		
		txtLoginUsuario = new JTextField();
		txtLoginUsuario.setBounds(78, 59, 300, 20);
		contentPane.add(txtLoginUsuario);
		txtLoginUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("SENHA");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setBounds(203, 99, 46, 14);
		contentPane.add(lblSenha);
		
		pwsLoginSenha = new JPasswordField();
		pwsLoginSenha.setBounds(78, 124, 300, 20);
		contentPane.add(pwsLoginSenha);
		
		JButton btnLoginEntrar = new JButton("ENTRAR");
		btnLoginEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * 
				 * chamando o menu assim que clikar no botão entrar
				 * 
				 * WINSTON 08-06-2019
				 * 
				 * 
				 * **/		
				//Login.this.setVisible(false);
				verificaCampo(); // procedimento de login
							
				
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
	
	/*
	 * METODO PARA VERIFICAR O LOGIN
	 * 
	 * WINSTON IGOR
	 * 
	 */
	
	public void verificaCampo() {
		
		if(txtLoginUsuario.getText() == null || txtLoginUsuario.getText().isEmpty() ||
				(pwsLoginSenha.getText() == null || pwsLoginSenha.getText().isEmpty())){			
			JOptionPane.showMessageDialog(null,"Existem campos nulos");
		}else {
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			
			if(usuarioDAO.verificarLogin(txtLoginUsuario.getText(), new String(pwsLoginSenha.getText()))) {
				//Menu menu = new Menu(txtLoginUsuario.getText());// passagem do parametro
				//menu.setVisible(true);
				//menu.setLocationRelativeTo(null);
			} else {
				JOptionPane.showMessageDialog(null, "O Usuario não consta cadastrado ou esta inativo !");
			}	
			
		}
	}
}
