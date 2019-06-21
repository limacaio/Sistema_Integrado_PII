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
	
	public ArrayList<Usuario> buscarUsuarioController(){
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		return usuarioDAO.buscarUsuarioDAO();
	}
}
