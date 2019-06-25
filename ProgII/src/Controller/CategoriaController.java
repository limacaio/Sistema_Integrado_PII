package Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Model.Categoria;
import DAO.CategoriaDAO;

//CAIO LIMA

public class CategoriaController {
	
	public CategoriaController() {
    }

    public void inserirCategoriaController(Categoria categoria) {

        CategoriaDAO categoriaDAO = new CategoriaDAO();

        if (categoriaDAO.inserirCategoriaDAO(categoria)) {

            System.out.println("Controller: Categoria inserida com sucesso: inserirCategoriaController");

            JOptionPane.showMessageDialog(null, "Categoria inserida com sucesso: inserirCategoriaController");

        } else {
            System.err.println("Controller: Erro no Teste de insercao: inserirCategoriaController");
        }
    }

    public List<Categoria> buscarCategoriasController() {

        CategoriaDAO categoriaDAO = new CategoriaDAO();
        return categoriaDAO.buscarCategoriaDAO();

    }

    public void excluirCategoriaController(Categoria categoria) {

        CategoriaDAO categoriaDAO = new CategoriaDAO();

        if (categoriaDAO.excluirCategoriaDAO(categoria)) {

            System.out.println("Controller: Categoria EXCLUIDA com sucesso: excluirCategoriaController");

        } else {
            System.err.println("Controller: Erro na EXCLUSAO: excluirCategoriaController");
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
