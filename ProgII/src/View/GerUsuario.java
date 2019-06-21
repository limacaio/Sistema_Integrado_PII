package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.UsuarioController;
import Model.Usuario;

public class GerUsuario extends JFrame {

	private JPanel contentPane;
	private JTable tblUsuario;

	
	 
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
		setBounds(100, 100, 547, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Usuarios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 511, 258);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 491, 226);
		panel.add(scrollPane);
		
		tblUsuario = new JTable();
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
	}
	/**
	 * 
	 * Metodo para atualiazar a tabela
	 * 
	 * winston igor 20-06-2019
	 */
	
	public void atualizarTabela() {
		
		Object colunas [] = {"ID", "Nome", "Email", "Senha", "Tipo"};
		DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
		
		UsuarioController usuarioController = new UsuarioController();
		for(Usuario usuario : usuarioController.buscarUsuarioController()) {
			Object linha[] = new Object[]{usuario.getIdUsuario(),usuario.getNome(),usuario.getEmail(),
				usuario.getSenha(), usuario.getAdministrador()};
			modelo.addRow(linha);
		}
		tblUsuario.setModel(modelo);
	}
}
