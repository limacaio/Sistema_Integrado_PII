package Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Model.Categoria;
import Model.Marca;
import DAO.CategoriaDAO;
import DAO.MarcaDAO;

//CAIO LIMA


public class MarcaController {
	
	public MarcaController() {
    }

    public void inserirMarcaController(Marca marca) {

        MarcaDAO marcaDAO = new MarcaDAO();

        if (marcaDAO.inserirMarcaDAO(marca)) {

            System.out.println("Controller: Marca inserida com sucesso: inserirMarcaController");

            JOptionPane.showMessageDialog(null, "Marca inserida com sucesso: inserirMarcaController");

        } else {
            System.err.println("Controller: Erro no Teste de insercao: inserirMarcaController");
        }
    }

    public List<Marca> buscarMarcaController() {

        MarcaDAO marcaDAO = new MarcaDAO();
        return marcaDAO.buscarMarcaDAO();

    }

    public void excluirMarcaController(Marca marca) {

    	MarcaDAO marcaDAO = new MarcaDAO();

        if (marcaDAO.excluirMarcaDAO(marca)) {

            System.out.println("Controller: Marca EXCLUIDA com sucesso: excluirMarcaController");

        } else {
            System.err.println("Controller: Erro na EXCLUSAO: excluirMarcaController");
        }
    }

    public void atualizarMarcaController(Marca marca) {

    	MarcaDAO marcaDAO = new MarcaDAO();

        if (marcaDAO.atualizarMarcaDAO(marca)) {

            System.out.println("Controller: Marca ATUALIZADA com sucesso: atualizarMarcaController");

        } else {
            System.err.println("Controller: Erro na ATUALIZACAO: atualizarMarcaController");
        }
    }
	


}
