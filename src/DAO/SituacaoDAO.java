package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Situacao;


public class SituacaoDAO {
	private Connection con = null;
	
	public SituacaoDAO() {
		con = ConnectionDB.getConnection();
	}
	
public ArrayList<Situacao> buscarSituacaoDAO(){
		
		String sql = "SELECT * FROM situacao  ORDER BY IdSituacao ";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Situacao> situacaoList = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Situacao situacao = new Situacao();
				
				situacao.setIdSituacao(rs.getInt(situacao.SITUACAO_ID));
				situacao.setDescricao(rs.getString(situacao.DESCRICAO));
				
				
				
				situacaoList.add(situacao);
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao buscar SituacaoDAO" + ex);
		}finally {
			ConnectionDB.closeConnection(con, stmt, rs);
		}
		return situacaoList;
		
	}
public boolean atualizarDescricaoDAO(Situacao situacao) {
	String sql = "update usuario set descricao = ? where idSituacao = ? ";
	PreparedStatement stmt = null;
	
	try {
		stmt = con.prepareStatement(sql);
		stmt.setString(1, situacao.getDescricao());
		stmt.setInt(2, situacao.getIdSituacao());
		stmt.executeUpdate();
		
		return true;
		
	} catch (SQLException ex) {
		System.out.println("Erro na atualizaçãoDAO" + ex);
		return false;
	}finally {
		ConnectionDB.closeConnection(con, stmt);
	}
}
}
