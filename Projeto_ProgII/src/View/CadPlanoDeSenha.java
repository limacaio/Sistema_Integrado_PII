package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadPlanoDeSenha extends JFrame {

	private JPanel contentPane;
	private JPasswordField pswNovaSenha;
	private JPasswordField pswConfSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadPlanoDeSenha frame = new CadPlanoDeSenha();
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
	public CadPlanoDeSenha() {
		setTitle("Plano de Senha");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNovaSenha = new JLabel("NOVA SENHA");
		lblNovaSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblNovaSenha.setBounds(138, 11, 132, 14);
		contentPane.add(lblNovaSenha);
		
		pswNovaSenha = new JPasswordField();
		pswNovaSenha.setBounds(75, 36, 265, 20);
		contentPane.add(pswNovaSenha);
		
		pswConfSenha = new JPasswordField();
		pswConfSenha.setBounds(75, 112, 265, 20);
		contentPane.add(pswConfSenha);
		
		JLabel lblConfirmarSenha = new JLabel("CONFIRMAR SENHA");
		lblConfirmarSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmarSenha.setBounds(75, 87, 265, 14);
		contentPane.add(lblConfirmarSenha);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			/***
			 * 
			 * 
			 * 
			 * Wisnton
			 * 
			 */
			
			public void actionPerformed(ActionEvent e) {
				
				if(pswNovaSenha.getText().equals(pswConfSenha.getText())) {
					JOptionPane.showMessageDialog(null,"Senha Atualizada");
				}else 
					JOptionPane.showMessageDialog(null,"A senhas não são iguais !");
				
				
			}
		});
		btnSalvar.setBounds(86, 198, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(226, 198, 89, 23);
		contentPane.add(btnCancelar);
	}
}
