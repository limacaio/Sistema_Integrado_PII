package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

import Controller.UsuarioController;
import Model.Usuario;

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
	private JComboBox cmbTipoUsuario;
	private JPanel panel_4;
	private JLabel lblNome_1;
	private JTextField textField;
	private JLabel lblEndereo;
	private JTextField textField_1;
	private JLabel lblN;
	private JTextField textField_2;
	private JLabel lblNewLabel;
	private JTextField textField_3;
	private JLabel lblTelefone;
	private JTextField textField_4;
	private JLabel lblCelular;
	private JTextField textField_5;

	
	 
	/*public static void main(String[] args) {
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
		setBounds(100, 100, 777, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Cadastro de Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 751, 327);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBounds(628, 11, 113, 305);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(56, 7, 1, 1);
		panel_2.add(desktopPane);
		
		btnNovo = new JButton("Novo");
		btnNovo.setBounds(10, 7, 97, 23);
		panel_2.add(btnNovo);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 41, 97, 23);
		panel_2.add(btnSalvar);
		btnSalvar.setEnabled(false);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 75, 97, 23);
		panel_2.add(btnCancelar);
		
		JButton btnVisualizar = new JButton("Visualizar");
		btnVisualizar.setBounds(10, 109, 97, 23);
		panel_2.add(btnVisualizar);
		btnVisualizar.setVerticalAlignment(SwingConstants.BOTTOM);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setEnabled(false);
		btnAlterar.setBounds(10, 143, 97, 23);
		panel_2.add(btnAlterar);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_3.setBounds(13, 27, 605, 119);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		lblSenha = new JLabel("SENHA:");
		lblSenha.setBounds(46, 55, 46, 14);
		panel_3.add(lblSenha);
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNome = new JLabel("USUARIO:");
		lblNome.setBounds(36, 21, 65, 14);
		panel_3.add(lblNome);
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		
		pswSenhaCadUsuario = new JPasswordField();
		pswSenhaCadUsuario.setBounds(102, 52, 152, 20);
		panel_3.add(pswSenhaCadUsuario);
		pswSenhaCadUsuario.setEnabled(false);
		
		txtNomeCadUsuario = new JTextField();
		txtNomeCadUsuario.setBounds(102, 18, 152, 20);
		panel_3.add(txtNomeCadUsuario);
		txtNomeCadUsuario.setEnabled(false);
		txtNomeCadUsuario.setColumns(10);
		
		lblConfSenha = new JLabel("CONFIRMAR SENHA:");
		lblConfSenha.setBounds(243, 55, 142, 14);
		panel_3.add(lblConfSenha);
		lblConfSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lblEmail = new JLabel("E-MAIL:");
		lblEmail.setBounds(326, 21, 46, 14);
		panel_3.add(lblEmail);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		
		pswConfSenhaCadUsuario = new JPasswordField();
		pswConfSenhaCadUsuario.setBounds(395, 52, 171, 20);
		panel_3.add(pswConfSenhaCadUsuario);
		pswConfSenhaCadUsuario.setEnabled(false);
		
		txtEmailCadUsuario = new JTextField();
		txtEmailCadUsuario.setBounds(395, 18, 171, 20);
		panel_3.add(txtEmailCadUsuario);
		txtEmailCadUsuario.setEnabled(false);
		txtEmailCadUsuario.setColumns(10);
		
		panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo de usuario", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBounds(444, 157, 174, 159);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 17, 154, 131);
		panel_4.add(panel_1);
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
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
		chcAdministrador.setBounds(6, 38, 120, 23);
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
		
		
		chcComum.setBounds(6, 64, 97, 23);
		panel_1.add(chcComum);
		
		cmbTipoUsuario = new JComboBox();
		cmbTipoUsuario.setEnabled(false);
		cmbTipoUsuario.setModel(new DefaultComboBoxModel(new String[] {"comum", "administrador", "relatista"}));
		cmbTipoUsuario.setBounds(10, 11, 120, 20);
		panel_1.add(cmbTipoUsuario);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_5.setBounds(13, 159, 420, 157);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		lblNome_1 = new JLabel("Nome: ");
		lblNome_1.setBounds(31, 11, 46, 14);
		panel_5.add(lblNome_1);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(91, 8, 319, 20);
		panel_5.add(textField);
		textField.setColumns(10);
		
		lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndereo.setBounds(10, 38, 67, 14);
		panel_5.add(lblEndereo);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(91, 39, 319, 20);
		panel_5.add(textField_1);
		textField_1.setColumns(10);
		
		lblN = new JLabel("N\u00BA:");
		lblN.setHorizontalAlignment(SwingConstants.RIGHT);
		lblN.setBounds(31, 73, 46, 14);
		panel_5.add(lblN);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(91, 70, 86, 20);
		panel_5.add(textField_2);
		textField_2.setColumns(10);
		
		lblNewLabel = new JLabel("Bairro:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(187, 73, 46, 14);
		panel_5.add(lblNewLabel);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setBounds(243, 70, 167, 20);
		panel_5.add(textField_3);
		textField_3.setColumns(10);
		
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(31, 108, 46, 14);
		panel_5.add(lblTelefone);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setBounds(91, 105, 142, 20);
		panel_5.add(textField_4);
		textField_4.setColumns(10);
		
		lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(243, 108, 46, 14);
		panel_5.add(lblCelular);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setBounds(299, 105, 111, 20);
		panel_5.add(textField_5);
		textField_5.setColumns(10);
		btnVisualizar.addActionListener(new ActionListener() {
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
				gerUsuario.atualizarTabela();
				
			}
		});
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
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
					if(pswSenhaCadUsuario.getText().equals(pswConfSenhaCadUsuario.getText())){
				
					modo = "salvar";
					GerUsuario usu = new GerUsuario();
					Usuario usuario = new Usuario();
					UsuarioController usuarioController = new UsuarioController();
					usuario.setNome(txtNomeCadUsuario.getText());
					usuario.setEmail(txtEmailCadUsuario.getText());
					usuario.setSenha(pswSenhaCadUsuario.getText());
					//usuario.setAdministrador(chcAdministrador.isSelected()? true:false);
					usuario.setTipo((String)cmbTipoUsuario.getSelectedItem()); 
					
					//inserindo o cadastro no banco 			
					usuarioController.inserirUsuarioController(usuario);
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso !!");
					//usuario.setSenha.String.ParseString((pswSenhaCadUsuario.getPassword()));
					usu.atualizarTabela();
					//dispose();
					limpaCampo();
					manipulaView();
					
				}else {			
				
					JOptionPane.showMessageDialog(null,"As senhas nao sao iguais");
				
			}
		}
			}
		});
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
	}
	
	public void limparTela() {
		
	}
	
	
	public void limpaCampo() {
		txtEmailCadUsuario.setText("");
		txtNomeCadUsuario.setText("");
		pswConfSenhaCadUsuario.setText("");
		pswSenhaCadUsuario.setText("");
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
			cmbTipoUsuario.setEnabled(true);
			
			break;
			
		case "salvar":
			txtNomeCadUsuario.setEnabled(false);
			txtEmailCadUsuario.setEnabled(false);
			pswConfSenhaCadUsuario.setEnabled(false);
			pswSenhaCadUsuario.setEnabled(false);
			btnSalvar.setEnabled(false);
			btnNovo.setEnabled(true);
			cmbTipoUsuario.setEnabled(false);
			
		
			
		}
	}
	
}
