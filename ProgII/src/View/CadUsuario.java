package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Controller.UsuarioController;
import Model.Usuario;
import View.GerUsuario;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import java.awt.Dialog.ModalExclusionType;

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
	private JButton btnNovo, btnSalvar;
	private String modo; //

	
	 
	/**public static void main(String[] args) {
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
	}*/

	
	 
	public CadUsuario() {
		setResizable(false);
		setTitle("Cadastro de Usuario");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 777, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Cadastro de Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 751, 156);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNome = new JLabel("USUARIO:");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setBounds(10, 24, 65, 14);
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
		txtNomeCadUsuario.setEnabled(false);
		txtNomeCadUsuario.setBounds(104, 21, 300, 20);
		panel.add(txtNomeCadUsuario);
		txtNomeCadUsuario.setColumns(10);
		
		txtEmailCadUsuario = new JTextField();
		txtEmailCadUsuario.setEnabled(false);
		txtEmailCadUsuario.setBounds(104, 46, 300, 20);
		panel.add(txtEmailCadUsuario);
		txtEmailCadUsuario.setColumns(10);
		
		pswSenhaCadUsuario = new JPasswordField();
		pswSenhaCadUsuario.setEnabled(false);
		pswSenhaCadUsuario.setBounds(104, 71, 241, 20);
		panel.add(pswSenhaCadUsuario);
		
		pswConfSenhaCadUsuario = new JPasswordField();
		pswConfSenhaCadUsuario.setEnabled(false);
		pswConfSenhaCadUsuario.setBounds(104, 99, 241, 20);
		panel.add(pswConfSenhaCadUsuario);
		
		lblConfSenha = new JLabel("CONF SENHA:");
		lblConfSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfSenha.setBounds(10, 102, 79, 14);
		panel.add(lblConfSenha);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setEnabled(false);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * Mensagem para informar o cadastro realizado com sucesso!!
				 * 
				 * Winston
				 * **/				
				if ((txtNomeCadUsuario.getText() == null || txtNomeCadUsuario.getText().trim().isEmpty()) ||
						(txtEmailCadUsuario.getText() == null || txtEmailCadUsuario.getText().trim().isEmpty()) ||
						(pswSenhaCadUsuario.getText() == null || pswSenhaCadUsuario.getText().trim().isEmpty()) ||
						(pswConfSenhaCadUsuario.getText() == null || pswConfSenhaCadUsuario.getText().trim().isEmpty()))
				{
					JOptionPane.showMessageDialog(null,"Existem campos vazio, verifique !!");
				}else {			
				
				GerUsuario usu = new GerUsuario();
				Usuario usuario = new Usuario();
				UsuarioController usuarioController = new UsuarioController();
				usuario.setNome(txtNomeCadUsuario.getText());
				usuario.setEmail(txtEmailCadUsuario.getText());
				usuario.setSenha(pswSenhaCadUsuario.getText());
				usuario.setAdministrador(chcAdministrador.isSelected()? true:false);
				
				//inserindo o cadastro no banco 			
				usuarioController.inserirUsuarioController(usuario);
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso !!");
				//usuario.setSenha.String.ParseString((pswSenhaCadUsuario.getPassword()));
				usu.atualizarTabela();
				//dispose();
				
				
			}
		}
		});
		btnSalvar.setBounds(633, 54, 89, 23);
		panel.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnCancelar.setBounds(633, 88, 89, 23);
		panel.add(btnCancelar);
		
		JButton btnBuscar = new JButton("Visualizar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/***
				 * AÇÃO DO BPTÃO BUSCAR
				 * 
				 * WINSTON IGOR
				 * 20-06-2019
				 * 
				 */
				
				GerUsuario gerUsuario = new GerUsuario();
				gerUsuario.setVisible(true);
				gerUsuario.setLocationRelativeTo(null);
				gerUsuario.setUndecorated(true);
				gerUsuario.atualizarTabela();
				
			}
		});
		btnBuscar.setBounds(633, 122, 89, 23);
		panel.add(btnBuscar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(429, 11, 144, 112);
		panel.add(panel_1);
		panel_1.setBorder(new TitledBorder(null, "Tipo de Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(null);
		
		chcAdministrador = new JCheckBox("Administardor");
		chcAdministrador.setEnabled(false);
		chcAdministrador.addActionListener(new ActionListener() {
			
			
			/***
			 * 
			 * Procedimento para os Chc COMUM
			 * 
			 * WINSTON 08-06-2019
			 * 
			 * */
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
		chcAdministrador.setBounds(6, 56, 120, 23);
		panel_1.add(chcAdministrador);
		
		chcComum = new JCheckBox("Comum");
		chcComum.setEnabled(false);
		chcComum.addActionListener(new ActionListener() {
		
		/**
		 * PROCEDIMENTO PARA O CHC ADM
		 * 
		 * WINSTON 08-06-2019
		 * 
		 * **/
			public void actionPerformed(ActionEvent e) {
				
				if(chcComum.isSelected() == true && chcAdministrador.isSelected() == false ) {
					chcAdministrador.setEnabled(false);
				} if(chcComum.isSelected()== false && chcAdministrador.isSelected()== false) {
					chcAdministrador.setEnabled(true);
					chcComum.setEnabled(true);
				}
			}
		});
		
		
		chcComum.setBounds(6, 82, 97, 23);
		panel_1.add(chcComum);
		
		JComboBox cmbTipoUsuario = new JComboBox();
		cmbTipoUsuario.setEnabled(false);
		cmbTipoUsuario.setBounds(6, 22, 120, 20);
		panel_1.add(cmbTipoUsuario);
		
		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * 
				 * Manipulaão da tela
				 * 
				 * winston igor
				 */
				
				modo = "novo";
				manipulaView();
				
			}
		});
		btnNovo.setBounds(633, 20, 89, 23);
		panel.add(btnNovo);
	}
	
	public void limparTela() {
		
	}
	
	public void manipulaView() {
		switch(modo) {
		case "novo":
			txtNomeCadUsuario.setEnabled(true);
			txtEmailCadUsuario.setEnabled(true);
			pswConfSenhaCadUsuario.setEnabled(true);
			pswSenhaCadUsuario.setEnabled(true);
			btnSalvar.setEnabled(true);
			btnNovo.setEnabled(false);
			
		}
	}
}
