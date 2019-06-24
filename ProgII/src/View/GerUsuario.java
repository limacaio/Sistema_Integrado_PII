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
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 688, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Usuarios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 652, 348);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 489, 316);
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(509, 21, 133, 185);
		panel.add(panel_1);
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setLayout(null);
		
		JButton btnExcluir = new JButton("Excluir");
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
		btnExcluir.setBounds(30, 102, 89, 23);
		panel_1.add(btnExcluir);
		
		JCheckBox chckbxDesativar = new JCheckBox("Desativar");
		chckbxDesativar.setBounds(30, 139, 97, 23);
		panel_1.add(chckbxDesativar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
			}
		});
		btnCancelar.setBounds(30, 68, 89, 23);
		panel_1.add(btnCancelar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(30, 38, 89, 23);
		panel_1.add(btnAtualizar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(30, 11, 89, 23);
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
}
