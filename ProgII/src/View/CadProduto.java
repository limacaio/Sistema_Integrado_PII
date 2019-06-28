package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class CadProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeProd;
	private JTextField txtValVenda;
	private JTextField txtDescProd;
	private JTextField txtSaldoEstoque;
	private JTable tableProduto;
	private JTextField txtImagem;
	private String modo;
	private JButton btnNovo;
	private JButton btnSalvar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadProduto frame = new CadProduto();
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
	public CadProduto() {
		setTitle("Cadastro Produto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 825, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeProdutos = new JLabel("Cadastro de Produtos ");
		lblCadastroDeProdutos.setFont(new Font("Arial", Font.BOLD, 16));
		lblCadastroDeProdutos.setBounds(323, 11, 235, 14);
		contentPane.add(lblCadastroDeProdutos);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Produto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 36, 789, 228);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNomeProduto = new JLabel("Nome Produto");
		lblNomeProduto.setBounds(10, 25, 96, 14);
		panel.add(lblNomeProduto);
		
		txtNomeProd = new JTextField();
		txtNomeProd.setBounds(10, 39, 305, 20);
		panel.add(txtNomeProd);
		txtNomeProd.setColumns(10);
		
		JLabel lblValorVenda = new JLabel("Valor Venda");
		lblValorVenda.setBounds(368, 25, 86, 14);
		panel.add(lblValorVenda);
		
		txtValVenda = new JTextField();
		txtValVenda.setBounds(368, 39, 86, 20);
		panel.add(txtValVenda);
		txtValVenda.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(587, 25, 74, 14);
		panel.add(lblCategoria);
		
		JComboBox cbCategoria = new JComboBox();
		cbCategoria.setBounds(587, 39, 192, 20);
		panel.add(cbCategoria);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(10, 70, 74, 14);
		panel.add(lblDescrio);
		
		txtDescProd = new JTextField();
		txtDescProd.setBounds(10, 84, 444, 20);
		panel.add(txtDescProd);
		txtDescProd.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(587, 70, 46, 14);
		panel.add(lblMarca);
		
		JComboBox cbMarca = new JComboBox();
		cbMarca.setBounds(587, 84, 192, 20);
		panel.add(cbMarca);
		
		JLabel lblEstoque = new JLabel("Saldo Estoque");
		lblEstoque.setBounds(479, 25, 86, 14);
		panel.add(lblEstoque);
		
		txtSaldoEstoque = new JTextField();
		txtSaldoEstoque.setBounds(479, 39, 86, 20);
		panel.add(txtSaldoEstoque);
		txtSaldoEstoque.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modo = "Salvar";
			}
		});
		btnSalvar.setBounds(671, 139, 89, 23);
		panel.add(btnSalvar);
		btnSalvar.setEnabled(false);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditar.setBounds(572, 173, 89, 23);
		panel.add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(671, 173, 89, 23);
		panel.add(btnExcluir);
		
		JLabel lblImagem = new JLabel("Imagem");
		lblImagem.setBounds(10, 115, 46, 14);
		panel.add(lblImagem);
		
		txtImagem = new JTextField();
		txtImagem.setColumns(10);
		txtImagem.setBounds(10, 140, 311, 20);
		panel.add(txtImagem);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setBounds(327, 139, 89, 23);
		panel.add(btnProcurar);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				modo = "novo";
				manipulaView();
			}
		});
		btnNovo.setBounds(572, 139, 89, 23);
		panel.add(btnNovo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(557, 126, 222, 91);
		panel.add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 275, 789, 245);
		contentPane.add(scrollPane);
		
		tableProduto = new JTable();
		tableProduto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tableProduto.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Produto", "Categoria", "Marca", "Pre\u00E7o", "Saldo Estoque"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Float.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(tableProduto);
		
		dispose();
	}
	
	public void limpaCampo() {
		txtNomeProd.setText("");
		txtDescProd.setText("");
		txtValVenda.setText("");
		txtSaldoEstoque.setText("");
		txtImagem.setText("");
	}
	
	public void manipulaView() {
		switch(modo) {
		case "novo":
			txtNomeProd.setEnabled(true);
			txtDescProd.setEnabled(true);
			txtValVenda.setEnabled(true);
			txtSaldoEstoque.setEnabled(true);
			txtImagem.setEnabled(true);
			btnSalvar.setEnabled(true);
			btnNovo.setEnabled(false);
			
			
			break;
			
		case "salvar":
			txtNomeProd.setEnabled(false);
			txtDescProd.setEnabled(false);
			txtValVenda.setEnabled(false);
			txtSaldoEstoque.setEnabled(false);
			txtImagem.setEnabled(false);
			btnSalvar.setEnabled(false);
			btnNovo.setEnabled(true);
			
			
		
			
		}
	}
}
