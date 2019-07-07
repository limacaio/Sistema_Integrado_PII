package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.SituacaoController;
import Controller.UsuarioController;
import Model.Situacao;
import Model.Usuario;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GerSituacao extends JFrame {
	
	private JButton btnAtualizar;
	private JPanel contentPane;
	private JTable tblSituacao;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerSituacao frame = new GerSituacao();
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
	public GerSituacao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 532, 272);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 45, 477, 75);
		panel.add(scrollPane);
		
		tblSituacao = new JTable();
		tblSituacao.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				if(tblSituacao.getSelectedRow() != -1) {
					
			
				}
			}
		});
		scrollPane.setViewportView(tblSituacao);
		tblSituacao.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"IdSituacao", "Descricao", "IDVenda"
			}
		));
		
		JLabel lblInserirNovaSituao = new JLabel("Inserir nova situa\u00E7\u00E3o da venda");
		lblInserirNovaSituao.setBounds(20, 158, 168, 25);
		panel.add(lblInserirNovaSituao);
		
		textField = new JTextField();
		textField.setBounds(20, 183, 475, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblSelecioneAVenda = new JLabel("Selecione a venda");
		lblSelecioneAVenda.setBounds(20, 23, 135, 25);
		panel.add(lblSelecioneAVenda);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(119, 214, 89, 23);
		panel.add(btnCancelar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(218, 214, 89, 23);
		panel.add(btnVoltar);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					Situacao situacao = new Situacao();
					SituacaoController situacaoController = new SituacaoController();
					situacao.setIdSituacao((int) tblSituacao.getValueAt(tblSituacao.getSelectedRow(), 0));
					
					situacaoController.atualizaSituacaoDescricaoController(situacao);
					atualizarTabela();
				
			}
		});
		btnAtualizar.setBounds(18, 214, 89, 23);
		panel.add(btnAtualizar);
	}
public void atualizarTabela() {
		
		Object colunas [] = {"IdSituacao", "Descricao", "IDVenda"};
		DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
		
		SituacaoController situacaoController = new SituacaoController();
		for(Situacao situacao : situacaoController.buscarSituacaoController()) {
			Object linha[] = new Object[]{situacao.getIdSituacao(),situacao.getDescricao()};
			modelo.addRow(linha);
		}
		tblSituacao.setModel(modelo);
	}
}

