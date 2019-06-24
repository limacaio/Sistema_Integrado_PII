package Controller;


import java.util.ArrayList;

import DAO.UsuarioDAO;
import Model.Usuario;

/**
 * 
 * Winston Igor 
 * Usuario Controller
 * 
 * 
 * **/

public class UsuarioController {
	
	public UsuarioController () {
		
	}
	
	public void inserirUsuarioController (Usuario usuario) {
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		if(usuarioDAO.inserirUsuarioDAO(usuario)) {
			System.out.println("Inserida com sucesso");
		}else {
			System.out.println("Erro na insercao");
		}		
		
	}
	
	public void excluirUsuarioController(Usuario usuario) {
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		if (usuarioDAO.excluirusuarioDAO(usuario)) {
			System.out.println("Controller: categoria EXLUIDA");
		} else {
			System.out.println("Controller: erro na exclusao");
		}
	}
	
	public ArrayList<Usuario> buscarUsuarioController(){
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		return usuarioDAO.buscarUsuarioDAO();
	}
	
public void atualizarUsuarioController(Usuario usuario){
        
        UsuarioDAO UsuarioDAO = new UsuarioDAO();
        
        if(UsuarioDAO.atualizarUsuarioDAO(usuario)){
            System.out.println("Controller: Usuario ATUALIZADA com sucesso ");
        } else{
            System.out.println("Controller: Erro na ATUALIZAÇÃO: atualizarCategriaController");
        }
    }
}
