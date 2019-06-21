package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.Usuario;

/**
 * Classe usuarioDAO 12-06-2019
 * 
 * fazer o metodod de verificação de senha e usuario
 * WINSTON IGOR
 * 
 *  * **/

public class UsuarioDAO {
	
	private Connection con = null;
	
	public UsuarioDAO() {
		con = ConnectionDB.getConnection();
	}
	
	public boolean verificarLogin(String email, String senha) {
		
		//con = ConnectionDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean check = false;
		
		String sql = "SELECT * FROM usuario WHERE email = ? and senha = ? ";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, email);
			stmt.setString(2, senha);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				
				check = true;
			}
						
		} catch (SQLException ex) {
			
			System.err.println("Erro buscarUsuarioDAO: " + ex);
		} finally {
			ConnectionDB.closeConnection(con, stmt);
		}
		
		return check;
		
	}
	
	public boolean inserirUsuarioDAO (Usuario usuario) {
		
		String sql = "INSERT INTO usuario (nome, email, senha, administrador) VALUES (?,?,?,?)";
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getSenha());
			stmt.setBoolean(4, usuario.getAdministrador());
			stmt.executeUpdate();
			
			return true;
			
		} catch (SQLException ex) {
			System.out.println("Erro SalvarUsuarioDAO" +ex);
			return false;
		}finally {
			ConnectionDB.closeConnection(con, stmt);
		}
		
	}
	
	public boolean excluirusuarioDAO(Usuario usuario) {
		String sql = "DELETE FROM usuario WHERE idUsuario = ?";
		
		PreparedStatement stmt =null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, usuario.getIdUsuario());
			stmt.executeUpdate();
			
			return true;
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "NÃO FOI POSSIVEL EXCLUIR" +ex, "Erro", 0 );
			return false;
		}finally {
			ConnectionDB.closeConnection(con, stmt);
		}
		
	}
	
	public ArrayList<Usuario> buscarUsuarioDAO(){
		
		String sql = "SELECT * FROM usuario ORDER BY IdUsuario ";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Usuario> usuarioList = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Usuario usuario = new Usuario();
				
				usuario.setIdUsuario(rs.getInt(usuario.USUARIO_ID));
				usuario.setNome(rs.getString(usuario.USUARIO_NOME));
				usuario.setEmail(rs.getString(usuario.USUARIO_EMAIL));
				usuario.setSenha(rs.getString(usuario.USUARIO_SENHA));
				//usuario.setAdministrador(rs.(usuario.getAdministrador()));
				usuarioList.add(usuario);
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao buscar UsuarioDAO" + ex);
		}finally {
			ConnectionDB.closeConnection(con, stmt, rs);
		}
		return usuarioList;
		
	}
	

}
