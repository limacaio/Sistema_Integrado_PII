package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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
	public Menu() {
		setResizable(false);
		setAutoRequestFocus(false);
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, 1037, 753);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Cadastro");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmProduto = new JMenuItem("Produto");
		mntmProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				//instanciando tela produto	
			CadProduto frame = new CadProduto();
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
			}
		});
		mnNewMenu.add(mntmProduto);
		
		
		JMenuItem mntmCategoria = new JMenuItem("Categoria");
		mntmCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadCategoria categ = new CadCategoria();
				categ.setVisible(true);
				categ.setLocationRelativeTo(null);
			}
		});
		mnNewMenu.add(mntmCategoria);
		
		JMenuItem mntmMarca = new JMenuItem("Marca");
		mntmMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadMarca categ = new CadMarca();
				categ.setVisible(true);
				categ.setLocationRelativeTo(null);
			}
		});
		mnNewMenu.add(mntmMarca);
		
		JMenu mnNewMenu_1 = new JMenu("Usuario");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Novo Usuario");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CadUsuario cadUsuario = new CadUsuario();
				cadUsuario.setVisible(true);
				cadUsuario.setLocationRelativeTo(null);
			}
		});
		
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Gerenciar Usuario");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Gerenciar Cliente");
		mnClientes.add(mntmNewMenuItem_2);
		
		JMenu mnApoio = new JMenu("Apoio");
		menuBar.add(mnApoio);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 631, 997, 48);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblSistemaGerenciadorDe = new JLabel("SISTEMA GERENCIADOR DE VENDAS");
		lblSistemaGerenciadorDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblSistemaGerenciadorDe.setBounds(242, 11, 559, 14);
		panel_1.add(lblSistemaGerenciadorDe);
		//panel.setLayout(BorderLayout.NORTH);
		//panel.add(contentPane, BorderLayout.NORTH);
		
	}
}
