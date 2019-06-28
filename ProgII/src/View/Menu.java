package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JLabel lblUsuario;
	public JMenu mnApoio, mnClientes,mnCadastro, mnUsuario ;
	

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
					//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					//frame.show();
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
	public Menu(String usuario) { // passando o usuario que que fez o login
		
		
		setResizable(false);
		setAutoRequestFocus(false);
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 615, 438);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnCadastro = new JMenu("Cadastro");
		mnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/***
				 * 
				 * 
				 * BLOCO DE PERMISÃO
				 * FALTA TERMINAR 
				 * WINSTON IGOR
				 * 
				 * 
				 
				UsuarioDAO usuarioDAO = new UsuarioDAO();			
				if(usuarioDAO.verificaUsuarioDAO("administrador")) {
					mnNewMenu.setEnabled(false);
				} else {
					JOptionPane.showMessageDialog(null, "O Usuario não consta cadastrado ou esta inativo !");
				}	*/
			}
		});
		menuBar.add(mnCadastro);
		
		JMenuItem mntmProduto = new JMenuItem("Produto");
		mntmProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CadProduto cadProduto = new CadProduto();
				cadProduto.setVisible(true);
				cadProduto.setLocationRelativeTo(null);
			}
		});
		mnCadastro.add(mntmProduto);
		
		JMenuItem mntmCategoria = new JMenuItem("Categoria");
		mntmCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CadCategoria cadCategoria = new CadCategoria();
				cadCategoria.setVisible(true);
				cadCategoria.setLocationRelativeTo(null);
			}
		});
		mnCadastro.add(mntmCategoria);
		
		JMenuItem mntmMarca = new JMenuItem("Marca");
		mntmMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CadMarca cadMarca= new CadMarca();
				cadMarca.setVisible(true);
				cadMarca.setLocationRelativeTo(null);
			}
		});
		mnCadastro.add(mntmMarca);
		
		mnUsuario = new JMenu("Usuario");
		menuBar.add(mnUsuario);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Novo Usuario");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CadUsuario cadUsuario = new CadUsuario();
				cadUsuario.setVisible(true);
				cadUsuario.setLocationRelativeTo(null);
			}
		});
		
		mnUsuario.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Gerenciar Usuario");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			/**
			 * 
			 * fazendo a chamada da tela quando o botão for acionado
			 * 
			 * WINSTON IGOR 08-06-2019
			 * 
			 * **/
			
			public void actionPerformed(ActionEvent arg0) {
				
				GerUsuario gerUsuario = new GerUsuario();
				gerUsuario.setVisible(true);
				gerUsuario.setLocationRelativeTo(null);
				gerUsuario.atualizarTabela();
				
				
			}
		});
		mnUsuario.add(mntmNewMenuItem_1);
		
		mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Gerenciar Cliente");
		mnClientes.add(mntmNewMenuItem_2);
		
		mnApoio = new JMenu("Apoio");
		mnApoio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		menuBar.add(mnApoio);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBounds(10, 174, 585, 186);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(10, 127, 565, 48);
		panel_2.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblSistemaGerenciadorDe = new JLabel("SISTEMA GERENCIADOR DE VENDAS");
		lblSistemaGerenciadorDe.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSistemaGerenciadorDe.setForeground(Color.RED);
		lblSistemaGerenciadorDe.setBounds(54, 11, 477, 14);
		panel_1.add(lblSistemaGerenciadorDe);
		lblSistemaGerenciadorDe.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblUsuarioN = new JLabel("Usuario Logado:");
		lblUsuarioN.setForeground(Color.BLUE);
		lblUsuarioN.setBounds(10, 23, 92, 14);
		panel_1.add(lblUsuarioN);
		
		lblUsuario = new JLabel("New label");
		lblUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsuario.setBounds(112, 23, 97, 14);
		panel_1.add(lblUsuario);
		//panel.setLayout(BorderLayout.NORTH);
		//panel.add(contentPane, BorderLayout.NORTH);
		lblUsuario.setText(usuario); // recebendo o usuario
	}
}
