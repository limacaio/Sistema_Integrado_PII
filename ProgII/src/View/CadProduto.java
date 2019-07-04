package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
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


import Controller.CategoriaController;
import Controller.MarcaController;
import Controller.ProdutoController;
import Model.Categoria;
import Model.Marca;
import Model.Produto;

public class CadProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeProd;
	private JTextField txtValVenda;
	private JTextField txtDescProd;
	private JTextField txtSaldoEstoque;
	private JTextField txtImagem;
	private String modo;
	private JButton btnNovo;
	private JButton btnSalvar;
	private JComboBox cbCategoria;
	private JTextField txtUnidMedida;

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
		setBounds(100, 100, 825, 395);
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
		panel.setBounds(10, 36, 789, 314);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNomeProduto = new JLabel("Nome Produto");
		lblNomeProduto.setBounds(10, 25, 96, 14);
		panel.add(lblNomeProduto);
		
		txtNomeProd = new JTextField();
		txtNomeProd.setBounds(10, 39, 305, 20);
		panel.add(txtNomeProd);
		txtNomeProd.setColumns(10);
		
		JLabel lblValorVenda = new JLabel("Pre\u00E7o Venda");
		lblValorVenda.setBounds(341, 25, 86, 14);
		panel.add(lblValorVenda);
		
		txtValVenda = new JTextField();
		txtValVenda.setBounds(341, 39, 65, 20);
		panel.add(txtValVenda);
		txtValVenda.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(587, 25, 74, 14);
		panel.add(lblCategoria);
		//===============================================================================
		//PREENCHENDO O COMBO BOX
		JComboBox cbCategoria = new JComboBox();
		cbCategoria.addItem("");
		CategoriaController catControl = new CategoriaController();
		
		for(Categoria categoria: catControl.buscarCategoriasController()) {
			cbCategoria.addItem(categoria);
		}
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
		cbMarca.addItem("");
		MarcaController marcaControl = new MarcaController();
		
		for(Marca marca: marcaControl.buscarMarcaController()) {
			cbMarca.addItem(marca);
		}
		cbMarca.setBounds(587, 84, 192, 20);
		panel.add(cbMarca);
		
		JLabel lblEstoque = new JLabel("Saldo");
		lblEstoque.setBounds(488, 70, 86, 14);
		panel.add(lblEstoque);
		
		txtSaldoEstoque = new JTextField();
		txtSaldoEstoque.setBounds(488, 84, 51, 20);
		panel.add(txtSaldoEstoque);
		txtSaldoEstoque.setColumns(10);
		;
		
		JLabel lblImagem = new JLabel("Imagem");
		lblImagem.setBounds(10, 126, 46, 14);
		panel.add(lblImagem);
		
		txtImagem = new JTextField();
		txtImagem.setColumns(10);
		txtImagem.setBounds(10, 140, 311, 20);
		panel.add(txtImagem);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setBounds(327, 139, 89, 23);
		panel.add(btnProcurar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(557, 126, 222, 177);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnSalvar_1 = new JButton("Salvar");
		btnSalvar_1.setBounds(10, 11, 94, 23);
		panel_1.add(btnSalvar_1);
		
		JButton btnVisualizar = new JButton("Visualizar");
		btnVisualizar.setBounds(118, 11, 94, 23);
		panel_1.add(btnVisualizar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(10, 57, 89, 23);
		panel_1.add(btnExcluir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(118, 57, 94, 23);
		panel_1.add(btnCancelar);
		
		JLabel lblUm = new JLabel("U.M");
		lblUm.setBounds(453, 25, 35, 14);
		panel.add(lblUm);
		
		txtUnidMedida = new JTextField();
		txtUnidMedida.setColumns(10);
		txtUnidMedida.setBounds(453, 39, 46, 20);
		panel.add(txtUnidMedida);
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GerProduto gerProduto = new GerProduto();
				gerProduto.setVisible(true);
				gerProduto.setLocationRelativeTo(null);
				gerProduto.atualizarTabelaProduto();
			}
		});
		btnSalvar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Produto produto = new Produto();
				Categoria categ = new Categoria();
				Marca marca = new Marca();
		
				
				
		        ProdutoController produtoController = new ProdutoController();
		        //pegando o que foi inserido
		        
		        produto.setNomeProduto(txtNomeProd.getText());
		        produto.setDescricaoProduto(txtDescProd.getText());
		        produto.setImagem(txtImagem.getText());
		        produto.setPrecoVenda(Float.parseFloat(txtValVenda.getText()));
		        produto.setEstoque(Integer.parseInt (txtSaldoEstoque.getText()));
		        produto.setUnidadeMedida(txtUnidMedida.getText());
		        //LEITURA COMBO BOX
		        categ = (Categoria) cbCategoria.getSelectedItem();
		        produto.setCategoria(categ);
		        
		        marca = (Marca) cbMarca.getSelectedItem();
		        produto.setMarca(marca);
		        	
		        produtoController.inserirProdutoController(produto);  
		      
		        txtNomeProd.setText("");
		        txtDescProd.setText("");
		        cbCategoria.addItem("");
		        cbMarca.addItem("");
		        txtValVenda.setText("");
		        txtSaldoEstoque.setText("");
		        txtUnidMedida.setText("");
		        
				
			}
		});
		
		dispose();
		this.setLocationRelativeTo(null);
	}
	
	

}
