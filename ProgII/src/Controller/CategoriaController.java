package Controller;

import java.util.List;

import javax.swing.JOptionPane;

import DAO.CategoriaDAO;
import Model.Categoria;

//CAIO LIMA

public class CategoriaController {
	
	public CategoriaController() {
    }

    public void inserirCategoriaController(Categoria categoria) {

        CategoriaDAO categoriaDAO = new CategoriaDAO();

        if (categoriaDAO.inserirCategoriaDAO(categoria)) {

            JOptionPane.showMessageDialog(null, "CATEGORIA CADASTRADA !!.");

        } else {
            System.err.println("ERRO AO CADASTRAR CATEGORIA");
        }
    }

    public List<Categoria> buscarCategoriasController() {

        CategoriaDAO categoriaDAO = new CategoriaDAO();
        return categoriaDAO.buscarCategoriaDAO();

    }

    public void excluirCategoriaController(Categoria categoria) {

        CategoriaDAO categoriaDAO = new CategoriaDAO();

        if (categoriaDAO.excluirCategoriaDAO(categoria)) {

            JOptionPane.showMessageDialog(null, "CATEGORIA EXCLUIDA.");

        } else {
        	JOptionPane.showMessageDialog(null, "ERRO AO EXCLUIR CATEGORIA");
        }
    }

    public void atualizarCategoriaController(Categoria categoria) {

        CategoriaDAO categoriaDAO = new CategoriaDAO();

        if (categoriaDAO.atualizarCategoriaDAO(categoria)) {

            System.out.println("Controller: Categoria ATUALIZADA com sucesso: atualizarCategoriaController");

        } else {
            System.err.println("Controller: Erro na ATUALIZACAO: atualizarCategoriaController");
        }
    }
	

}
