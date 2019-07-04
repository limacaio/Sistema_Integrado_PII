package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.ProdutoController;
import Model.Marca;
import Model.Produto;

public class GerProduto extends JFrame {

	private JPanel contentPane;
	private JTable tblProduto;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 946, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 778, 496);
		contentPane.add(scrollPane);
		
		tblProduto = new JTable();
		tblProduto.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nome", "Descri\u00E7\u00E3o", "Marca", "Categoria", "Pre\u00E7o", "Saldo", "U.M"
			}
		));
		scrollPane.setViewportView(tblProduto);
		dispose();
		this.setLocationRelativeTo(null);
	}
	
	
public void atualizarTabelaProduto() {
		
		Object colunas [] = {"Codigo", "Nome","Descrição","Marca","Categoria","Preço","Saldo","U.M"};
		DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
		
		Marca marca =new Marca();
		ProdutoController produtoController = new ProdutoController();
		for(Produto produto : produtoController.buscarProdutoController()) {
			Object linha[] = new Object[]{produto.getIdProduto(),produto.getNomeProduto(),produto.getDescricaoProduto(),
										  produto.getMarca().getDescricaoMarca(),produto.getCategoria().getDescricao(),produto.getPrecoVenda(),produto.getEstoque(),
										  produto.getUnidadeMedida()};
			modelo.addRow(linha);
		}
		tblProduto.setModel(modelo);
	}
}
