package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe usuarioDAO 12-06-2019
 * 
 * fazer o metodod de verificação de senha e usuario
 * WINSTON IGOR
 * 
 *  * **/

public class UsuarioDAO {
	
	public boolean verificarLogin(String nome, String senha) {
		
		Connection con = ConnectionDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean check = false;
		
		String sql = "SELECT * FROM usuario WHERE email = ? and senha = ? ";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, nome);
			stmt.setString(2, senha);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				
				check = true;
			}
						
		} catch (SQLException ex) {
			
			System.err.println("Erro buscarUsuarioDAO: " + ex);
		} finally {
			ConnectionDB.closeConnection(con, stmt, rs);;
		}
		
		return check;
		
	}

}
