package Controller;

import java.util.List;

import javax.swing.JOptionPane;

import DAO.MarcaDAO;
import Model.Marca;

//CAIO LIMA


public class MarcaController {
	
	public MarcaController() {
    }

    public void inserirMarcaController(Marca marca) {

        MarcaDAO marcaDAO = new MarcaDAO();

        if (marcaDAO.inserirMarcaDAO(marca)) {

            JOptionPane.showMessageDialog(null, "MARCA CADASTRADA !!");

        } else {
        	JOptionPane.showMessageDialog(null, "ERRO AO CADASTRAR MARCA!!");
        }
    }

    public List<Marca> buscarMarcaController() {

        MarcaDAO marcaDAO = new MarcaDAO();
        return marcaDAO.buscarMarcaDAO();

    }

    public void excluirMarcaController(Marca marca) {

    	MarcaDAO marcaDAO = new MarcaDAO();

        if (marcaDAO.excluirMarcaDAO(marca)) {

        	JOptionPane.showMessageDialog(null, "MARCA EXCLUIDA!!");
        	
        } else {
        	
        	JOptionPane.showMessageDialog(null, "ERRO AO EXCLUIR!!");
        }
    }

    public void atualizarMarcaController(Marca marca) {

    	MarcaDAO marcaDAO = new MarcaDAO();

        if (marcaDAO.atualizarMarcaDAO(marca)) {

        	JOptionPane.showMessageDialog(null, "MARCA ATUALIZADA!!");

        } else {
        	JOptionPane.showMessageDialog(null, "ERRO AO ATUALZIAR MARCA !!");
        }
    }
	


}
