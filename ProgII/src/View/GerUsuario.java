package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Controller.UsuarioController;
import Model.Usuario;
import javafx.scene.control.CheckBox;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GerUsuario extends JFrame {

	private JPanel contentPane;
	private JTable tblUsuario;
	private JPasswordField pswSenha;
	private JTextField txtUsuario;
	private JPasswordField pswConfSenha;
	private JTextField txtEmail;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JButton btnSalvar, btnAtualizar;
	private JButton btnCancelar, btnExcluir;
	private JButton btnConfirmar;
	private JButton button_1;
	
	private CheckBox chckbxDesativar;
	
	private String modo;

	
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerUsuario frame = new GerUsuario();
					frame.setVisible(true);
					frame.atualizarTabela();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public GerUsuario() {
		setTitle("Usuarios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1239, 743);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(437, 11, 633, 472);
		panel.setBorder(new TitledBorder(null, "Usuarios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {});
		scrollPane.setBounds(10, 23, 610, 438);
		panel.add(scrollPane);
		
		tblUsuario = new JTable();
		tblUsuario.addMouseListener(new MouseAdapter() {
			/***
			 * 
			 * 
			 * Winston Atualizar
			 * 
			 * 
			 * 
			 */
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(tblUsuario.getSelectedRow() != -1) {
					
					txtEmail.setText(tblUsuario.getValueAt(tblUsuario.getSelectedRow(), 2).toString());
					txtUsuario.setText(tblUsuario.getValueAt(tblUsuario.getSelectedRow(), 2).toString());
					pswConfSenha.setText(tblUsuario.getValueAt(tblUsuario.getSelectedRow(), 3).toString());
					pswSenha.setText(tblUsuario.getValueAt(tblUsuario.getSelectedRow(), 3).toString());
			}
		}
		});
		tblUsuario.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "NOME", "EMAIL", "SENHA", "TIPO"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblUsuario.getColumnModel().getColumn(0).setResizable(false);
		tblUsuario.getColumnModel().getColumn(1).setResizable(false);
		tblUsuario.getColumnModel().getColumn(2).setResizable(false);
		tblUsuario.getColumnModel().getColumn(3).setResizable(false);
		tblUsuario.getColumnModel().getColumn(4).setResizable(false);
		scrollPane.setViewportView(tblUsuario);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(10, 11, 417, 472);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setLayout(null);
		panel_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_4.setBounds(20, 28, 347, 157);
		panel_2.add(panel_4);
		
		JLabel label_4 = new JLabel("Nome: ");
		label_4.setBounds(31, 11, 46, 14);
		panel_4.add(label_4);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(91, 8, 246, 20);
		panel_4.add(textField_2);
		
		JLabel label_5 = new JLabel("Endere\u00E7o:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(10, 38, 67, 14);
		panel_4.add(label_5);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBounds(91, 39, 246, 20);
		panel_4.add(textField_3);
		
		JLabel label_6 = new JLabel("N\u00BA:");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setBounds(31, 73, 46, 14);
		panel_4.add(label_6);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setColumns(10);
		textField_4.setBounds(91, 70, 86, 20);
		panel_4.add(textField_4);
		
		JLabel label_7 = new JLabel("Bairro:");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setBounds(187, 73, 46, 14);
		panel_4.add(label_7);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setColumns(10);
		textField_5.setBounds(243, 70, 94, 20);
		panel_4.add(textField_5);
		
		JLabel label_8 = new JLabel("Telefone:");
		label_8.setBounds(31, 108, 46, 14);
		panel_4.add(label_8);
		
		textField_6 = new JTextField();
		textField_6.setEnabled(false);
		textField_6.setColumns(10);
		textField_6.setBounds(91, 105, 105, 20);
		panel_4.add(textField_6);
		
		JLabel label_9 = new JLabel("Celular:");
		label_9.setBounds(206, 108, 46, 14);
		panel_4.add(label_9);
		
		textField_7 = new JTextField();
		textField_7.setEnabled(false);
		textField_7.setColumns(10);
		textField_7.setBounds(253, 105, 84, 20);
		panel_4.add(textField_7);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(22, 214, 345, 209);
		panel_2.add(panel_3);
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setLayout(null);
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		JLabel label = new JLabel("SENHA:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(36, 82, 46, 14);
		panel_3.add(label);
		
		JLabel label_1 = new JLabel("USUARIO:");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(36, 21, 65, 14);
		panel_3.add(label_1);
		
		pswSenha = new JPasswordField();
		pswSenha.setEnabled(false);
		pswSenha.setBounds(102, 79, 152, 20);
		panel_3.add(pswSenha);
		
		txtUsuario = new JTextField();
		txtUsuario.setEnabled(false);
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(102, 18, 152, 20);
		panel_3.add(txtUsuario);
		
		JLabel label_2 = new JLabel("CONFIRMAR SENHA:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(80, 107, 142, 14);
		panel_3.add(label_2);
		
		JLabel label_3 = new JLabel("E-MAIL:");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(36, 46, 46, 14);
		panel_3.add(label_3);
		
		pswConfSenha = new JPasswordField();
		pswConfSenha.setEnabled(false);
		pswConfSenha.setBounds(102, 121, 152, 20);
		panel_3.add(pswConfSenha);
		
		txtEmail = new JTextField();
		txtEmail.setEnabled(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(102, 48, 152, 20);
		panel_3.add(txtEmail);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.LIGHT_GRAY);
		panel_5.setLayout(null);
		panel_5.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_5.setBounds(1080, 275, 133, 206);
		contentPane.add(panel_5);
		
		button_1 = new JButton("Cancelar");
		button_1.setEnabled(false);
		button_1.addActionListener(new ActionListener() {
			/**
			 * 
			 * Winston Atualizar tela
			 * 
			 */
			
			public void actionPerformed(ActionEvent e) {
				
				modo= "cancelar";
				
				manipulaView();
				
				
			}
		});
		button_1.setBounds(10, 90, 109, 23);
		panel_5.add(button_1);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * 
				 * ATUALIZAR USUARIO
				 * 
				 * WINSTON
				 * 
				 * */
				
				modo = "confirmar";
				
				if(tblUsuario.getSelectedRow() != -1) {
					
					Usuario usuario = new Usuario();
					UsuarioController usuarioController = new UsuarioController();
					usuario.setSenha(pswSenha.getText());
					usuario.setIdUsuario((int) tblUsuario.getValueAt(tblUsuario.getSelectedRow(), 0));
					
					usuarioController.atualizarUsuarioController(usuario);
					atualizarTabela();
					manipulaView();
				}
				
				
			}
		});
		btnConfirmar.setEnabled(false);
		btnConfirmar.setBounds(10, 51, 109, 23);
		panel_5.add(btnConfirmar);
		
		JLabel lblAtualizar = new JLabel("ATUALIZAR");
		lblAtualizar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtualizar.setBounds(10, 11, 109, 14);
		panel_5.add(lblAtualizar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(1080, 11, 133, 253);
		contentPane.add(panel_1);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setLayout(null);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * Exluir usuario
				 * 
				 * Winston Igor
				 * 
				 */
				
				
				if(tblUsuario.getSelectedRow() != -1) {
					Usuario usuario = new Usuario();
					UsuarioController usuarioController = new UsuarioController();
					usuario.setIdUsuario((int) tblUsuario.getValueAt(tblUsuario.getSelectedRow(), 0));
					
					usuarioController.excluirUsuarioController(usuario);
				}
				atualizarTabela();
			}
		});
		btnExcluir.setBounds(22, 157, 89, 23);
		panel_1.add(btnExcluir);
		
		JCheckBox chckbxDesativar = new JCheckBox("Desativar");
		chckbxDesativar.setBackground(Color.LIGHT_GRAY);
		chckbxDesativar.setBounds(22, 206, 97, 23);
		panel_1.add(chckbxDesativar);
		
		btnCancelar = new JButton("SAIR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
			}
		});
		btnCancelar.setBounds(22, 123, 89, 23);
		panel_1.add(btnCancelar);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				modo = "atualizar";
				manipulaView();
				
				/**
				 * Atualizar usuario cadastro
				 * 
				 * winston
				 * 
				 *
				
				if(tblUsuario.getSelectedRow() != -1) {
					Usuario usuario = new Usuario();
					UsuarioController usuarioController = new UsuarioController();
					usuario.setEmail(txtEmail.getText());
					usuario.setNome(txtUsuario.getText());
					usuario.setSenha(pswSenha.getText());
					usuario.setSenha(pswConfSenha.getText());
				}
				
			}
			*/
				
			}
				
				
		});
		btnAtualizar.setBounds(22, 89, 89, 23);
		panel_1.add(btnAtualizar);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			/**
			 * 
			 * Situacao do usuario 
			 * 
			 * winston
			 * 
			 */
			
			
			
			public void actionPerformed(ActionEvent e) {
				Usuario usuario = new Usuario();
				UsuarioController usuarioController = new UsuarioController();
				usuario.setSituacao(chckbxDesativar.isSelected()? true:false);
				usuario.setIdUsuario((int) tblUsuario.getValueAt(tblUsuario.getSelectedRow(), 0));
				
				usuarioController.atualizaUsuarioSituacaoController(usuario);
				atualizarTabela();
			}
		});
		btnSalvar.setBounds(22, 55, 89, 23);
		panel_1.add(btnSalvar);
	}
	/**
	 * 
	 * Metodo para atualiazar a tabela
	 * 
	 * winston igor 20-06-2019
	 */
	
	public void atualizarTabela() {
		
		Object colunas [] = {"ID", "Nome", "Email", "Senha", "Tipo", "Situacao"};
		DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
		
		UsuarioController usuarioController = new UsuarioController();
		for(Usuario usuario : usuarioController.buscarUsuarioController()) {
			Object linha[] = new Object[]{usuario.getIdUsuario(),usuario.getNome(),usuario.getEmail(),
				usuario.getSenha(), /*usuario.getAdministrador()*/ usuario.getTipo(), usuario.getSituacao()};
			modelo.addRow(linha);
		}
		tblUsuario.setModel(modelo);
	}
	
	public void manipulaView() {
		switch(modo) {
		case "atualizar":
			//txtUsuario.setEnabled(true);
			txtEmail.setEnabled(true);
			pswConfSenha.setEnabled(true);
			pswSenha.setEnabled(true);
			btnSalvar.setEnabled(true);
			btnAtualizar.setEnabled(false);
			//btnNovo.setEnabled(false);
			//cmbTipoUsuario.setEnabled(true);
			tblUsuario.setEnabled(false);
			btnExcluir.setEnabled(false);
			btnConfirmar.setEnabled(true);
			button_1.setEnabled(true);
			btnCancelar.setEnabled(false);
			btnSalvar.setEnabled(false);
			
			
			
			
			
			break;
			
		case "cancelar":
			txtUsuario.setEnabled(false);
			txtEmail.setEnabled(false);
			pswConfSenha.setEnabled(false);
			pswSenha.setEnabled(false);
			btnSalvar.setEnabled(false);
			//btnNovo.setEnabled(true);
			//cmbTipoUsuario.setEnabled(false);
			tblUsuario.setEnabled(true);
			btnAtualizar.setEnabled(true);
			btnCancelar.setEnabled(true);
			button_1.setEnabled(false);
			btnConfirmar.setEnabled(false);
			btnExcluir.setEnabled(true);
			btnSalvar.setEnabled(true);
			txtEmail.setText("");
			txtUsuario.setText("");
			pswConfSenha.setText("");
			pswSenha.setText("");
			
			break;
		
		case "confirmar":
			txtEmail.setText("");
			txtUsuario.setText("");
			pswConfSenha.setText("");
			pswSenha.setText("");
			txtUsuario.setEnabled(false);
			txtEmail.setEnabled(false);
			pswConfSenha.setEnabled(false);
			pswSenha.setEnabled(false);
			tblUsuario.setEnabled(true);
			btnAtualizar.setEnabled(true);
			btnCancelar.setEnabled(true);
			button_1.setEnabled(false);
			btnConfirmar.setEnabled(false);
			btnExcluir.setEnabled(true);
			btnSalvar.setEnabled(true);
			
			
			
		
			
		}
}
}
