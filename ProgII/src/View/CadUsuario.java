package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadUsuario extends JFrame {

	private JPanel contentPane;
	private JLabel lblNome;
	private JLabel lblEmail;
	private JLabel lblSenha;
	private JTextField txtNomeCadUsuario;
	private JTextField txtEmailCadUsuario;
	private JPasswordField pswSenhaCadUsuario;
	private JPasswordField pswConfSenhaCadUsuario;
	private JLabel lblConfSenha;
	private JCheckBox chcAdministrador;
	private JCheckBox chcComum;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadUsuario frame = new CadUsuario();
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
	public CadUsuario() {
		setResizable(false);
		setTitle("Cadastro de Usuario");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Cadastro de Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 414, 240);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNome = new JLabel("NOME:");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setBounds(10, 24, 46, 14);
		panel.add(lblNome);
		
		lblEmail = new JLabel("E-MAIL:");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBounds(10, 49, 46, 14);
		panel.add(lblEmail);
		
		lblSenha = new JLabel("SENHA:");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setBounds(10, 74, 46, 14);
		panel.add(lblSenha);
		
		txtNomeCadUsuario = new JTextField();
		txtNomeCadUsuario.setBounds(66, 21, 338, 20);
		panel.add(txtNomeCadUsuario);
		txtNomeCadUsuario.setColumns(10);
		
		txtEmailCadUsuario = new JTextField();
		txtEmailCadUsuario.setBounds(66, 46, 338, 20);
		panel.add(txtEmailCadUsuario);
		txtEmailCadUsuario.setColumns(10);
		
		pswSenhaCadUsuario = new JPasswordField();
		pswSenhaCadUsuario.setBounds(66, 71, 338, 20);
		panel.add(pswSenhaCadUsuario);
		
		pswConfSenhaCadUsuario = new JPasswordField();
		pswConfSenhaCadUsuario.setBounds(99, 99, 305, 20);
		panel.add(pswConfSenhaCadUsuario);
		
		lblConfSenha = new JLabel("CONF SENHA:");
		lblConfSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfSenha.setBounds(10, 102, 79, 14);
		panel.add(lblConfSenha);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Tipo de Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(260, 130, 144, 99);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		chcAdministrador = new JCheckBox("Administardor");
		chcAdministrador.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(chcAdministrador.isSelected() == false && chcComum.isSelected() == false) {
					chcAdministrador.setEnabled(true);
					chcComum.setEnabled(true);
				}
				if(chcAdministrador.isSelected() == true && chcComum.isSelected() == false) {
					//chcAdministrador.setEnabled(false);
					chcComum.setEnabled(false);
				}
			}
				
		});
		chcAdministrador.setBounds(6, 24, 120, 23);
		panel_1.add(chcAdministrador);
		
		chcComum = new JCheckBox("Comum");
		chcComum.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				
				if(chcComum.isSelected() == true && chcAdministrador.isSelected() == false ) {
					chcAdministrador.setEnabled(false);
				} if(chcComum.isSelected()== false && chcAdministrador.isSelected()== false) {
					chcAdministrador.setEnabled(true);
					chcComum.setEnabled(true);
				}
			}
		});
		
		
		chcComum.setBounds(6, 54, 97, 23);
		panel_1.add(chcComum);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(43, 192, 89, 23);
		panel.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnCancelar.setBounds(150, 192, 89, 23);
		panel.add(btnCancelar);
	}
}
