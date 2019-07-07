package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.MarcaController;
import Controller.ProdutoController;
import Model.Marca;
import Model.Produto;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GerProduto extends JFrame {

	private JPanel contentPane;
	private JTable tblProduto;
	private JTextField txtNome;
	private JTextField txtDescricao;
	private JTextField txtImagem;
	private JTextField txtPreco;
	private JTextField txtSaldo;
	private JTextField txtUnidademedida;
	private JTextField txtMarca;
	private JTextField txtCategoria;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerProduto frame = new GerProduto();
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
	public GerProduto() {
		setTitle("Produtos");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 988, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			
		});
		scrollPane.setBounds(10, 11, 795, 234);
		contentPane.add(scrollPane);
		
		tblProduto = new JTable();
		tblProduto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(tblProduto.getSelectedRow() != -1) {
					
					txtNome.setText(tblProduto.getValueAt(tblProduto.getSelectedRow(),1).toString());
					txtDescricao.setText(tblProduto.getValueAt(tblProduto.getSelectedRow(),2).toString());
					txtMarca.setText(tblProduto.getValueAt(tblProduto.getSelectedRow(),3).toString());
					txtCategoria.setText(tblProduto.getValueAt(tblProduto.getSelectedRow(),4).toString());
					txtPreco.setText(tblProduto.getValueAt(tblProduto.getSelectedRow(),5).toString());
					txtSaldo.setText(tblProduto.getValueAt(tblProduto.getSelectedRow(),6).toString());
					txtUnidademedida.setText(tblProduto.getValueAt(tblProduto.getSelectedRow(),7).toString());
					
			
				}	
				
			}
		});
		tblProduto.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nome", "Descri\u00E7\u00E3o", "Marca", "Categoria", "Pre\u00E7o", "Saldo", "U.M"
			}
		));
		scrollPane.setViewportView(tblProduto);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(815, 11, 132, 234);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarTabelaProduto();
			}
		});
		btnAtualizar.setBounds(20, 107, 89, 23);
		panel.add(btnAtualizar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tblProduto.getSelectedRow() != -1) {
					Produto produto = new Produto();
					ProdutoController produtoController = new ProdutoController();
					produto.setIdProduto((int) tblProduto.getValueAt(tblProduto.getSelectedRow(), 0));
					
					produtoController.excluirProdutoController(produto);
				}
				atualizarTabelaProduto();
			}
			
		});
		btnExcluir.setBounds(20, 151, 89, 23);
		panel.add(btnExcluir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(20, 200, 89, 23);
		panel.add(btnCancelar);
		
		JButton button = new JButton("Novo");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CadProduto cadProduto = new CadProduto();
				cadProduto.setVisible(true);
				cadProduto.setLocationRelativeTo(null);
				atualizarTabelaProduto();
			}
		});
		button.setBounds(20, 24, 89, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("Salvar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				alterarLinhaTabela();
			}
		});
		button_1.setBounds(20, 58, 89, 23);
		panel.add(button_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Editar Produto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 280, 795, 191);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 42, 344, 20);
		panel_1.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 25, 48, 14);
		panel_1.add(lblNome);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(10, 90, 344, 20);
		panel_1.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(10, 71, 79, 14);
		panel_1.add(lblDescrio);
		
		txtImagem = new JTextField();
		txtImagem.setBounds(10, 152, 344, 20);
		panel_1.add(txtImagem);
		txtImagem.setColumns(10);
		
		JLabel lblImagem = new JLabel("Imagem");
		lblImagem.setBounds(10, 131, 48, 14);
		panel_1.add(lblImagem);
		
		JButton btnBuscarImagem = new JButton("Buscar");
		btnBuscarImagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//pegando imagem novamente caso o usuario queira modificar ela
				
				try {
					JFileChooser caminhoImagem = new JFileChooser();
					FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif","png");//definindo um filtro de extensão
					caminhoImagem.setFileFilter(filtro);
					caminhoImagem.showOpenDialog(new Panel());
					txtImagem.setText(caminhoImagem.getSelectedFile().getAbsolutePath());
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "Não foi possivel Carregar a Imagem");
						
					}
			}
		});
		btnBuscarImagem.setBounds(364, 151, 89, 23);
		panel_1.add(btnBuscarImagem);
		
		txtPreco = new JTextField();
		txtPreco.setBounds(394, 42, 96, 20);
		panel_1.add(txtPreco);
		txtPreco.setColumns(10);
		
		txtSaldo = new JTextField();
		txtSaldo.setColumns(10);
		txtSaldo.setBounds(500, 42, 96, 20);
		panel_1.add(txtSaldo);
		
		txtUnidademedida = new JTextField();
		txtUnidademedida.setColumns(10);
		txtUnidademedida.setBounds(606, 42, 96, 20);
		panel_1.add(txtUnidademedida);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setBounds(394, 25, 48, 14);
		panel_1.add(lblPreo);
		
		JLabel lblSaldo = new JLabel("Saldo");
		lblSaldo.setBounds(500, 25, 48, 14);
		panel_1.add(lblSaldo);
		
		JLabel lblUm = new JLabel("U.M");
		lblUm.setBounds(606, 25, 48, 14);
		panel_1.add(lblUm);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(394, 71, 96, 14);
		panel_1.add(lblCategoria);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(558, 71, 48, 14);
		panel_1.add(lblMarca);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(558, 90, 144, 20);
		panel_1.add(txtMarca);
		txtMarca.setColumns(10);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(394, 90, 144, 20);
		panel_1.add(txtCategoria);
		txtCategoria.setColumns(10);
		atualizarTabelaProduto();
		dispose();
		this.setLocationRelativeTo(null);
	}
	
	
	public void alterarLinhaTabela() {

		if (tblProduto.getSelectedRow() != -1) {

			Produto produto = new Produto();
			ProdutoController produtoController = new ProdutoController();
			produto.setDescricaoProduto(txtDescricao.getText());
			produto.setIdProduto((int) tblProduto.getValueAt(tblProduto.getSelectedRow(), 0));
			produtoController.atualizarProdutoController(produto);
			txtDescricao.setText("");
			atualizarTabelaProduto();
		}

	}
	
	
public void atualizarTabelaProduto() {
		
		Object colunas [] = {"Codigo", "Nome","Descrição","Marca","Categoria","Preço","Saldo","U.M"};
		
		DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
		
		ProdutoController produtoController = new ProdutoController();
		
		for(Produto produto : produtoController.buscarProdutoController()) {
			
			Object linha[] = new Object[]{produto.getIdProduto(),produto.getNomeProduto(),produto.getDescricaoProduto(),
										 produto.getMarca(),produto.getCategoria(),
										 produto.getPrecoVenda(),produto.getEstoque(),produto.getUnidadeMedida()};
			
			modelo.addRow(linha);
		}
		tblProduto.setModel(modelo);
	}
}
