package Controller;

import java.util.List;

import javax.swing.JOptionPane;

import DAO.ProdutoDAO;
import Model.Produto;

public class ProdutoController {
	
	 public ProdutoController() {
	    }

	 public void inserirProdutoController(Produto produto) {

	        ProdutoDAO produtoDAO = new ProdutoDAO();

	        if (produtoDAO.inserirProdutoDAO(produto)) {

	            System.out.println("Controller: Produto inserida com sucesso: inserirProdutoController");

	            JOptionPane.showMessageDialog(null, "Produto inserida com sucesso: inserirProdutoController");

	        } else {
	            System.err.println("Controller: Erro no Teste de insercao: inserirProdutoController");
	        }
	    }

	    public List<Produto> buscarProdutoController() {

	        ProdutoDAO produtoDAO = new ProdutoDAO();

	        // List<Produto> produtoLista = new ArrayList<>();         
	        // produtoLista = produtoDAO.buscarProdutosDAO();
	        return produtoDAO.buscarProdutosDAO();

	    }

	    public void excluirProdutoController(Produto produto) {

	        ProdutoDAO produtoDAO = new ProdutoDAO();

	        if (produtoDAO.excluirProdutoDAO(produto)) {

	            System.out.println("Controller: Produto EXCLUIDA com sucesso: excluirProdutoController");

	        } else {
	            System.err.println("Controller: Erro na EXCLUSAO: excluirProdutoController");
	        }
	    }

	    public void atualizarProdutoController(Produto produto) {

	        ProdutoDAO produtoDAO = new ProdutoDAO();

	        if (produtoDAO.atualizarProdutoDAO(produto)) {

	            System.out.println("Controller: Produto ATUALIZADA com sucesso: atualizarProdutoController");

	        } else {
	            System.err.println("Controller: Erro na ATUALIZACAO: atualizarProdutoController");
	        }
	    }

}
