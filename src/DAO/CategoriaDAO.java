package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import Model.Categoria;

public class CategoriaDAO {

	private Connection con = null;

    public CategoriaDAO() {

        con = ConnectionDB.getConnection();
    }
    
    //CAIO LIMA 
    //=======================INSERIR CATEGORIA=======================================
    public boolean inserirCategoriaDAO(Categoria categoria) {

        String sql = "INSERT INTO categoria (descricao) values (?)";

        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, categoria.getDescricao() );
            stmt.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.err.println("Erro salvarCategoriaDAO: " + ex);
            return false;

        } finally {

            ConnectionDB.closeConnection(con, stmt);
        }
    }
  
    
    //=======================BUSCAR CATEGORIA====================================
    
    public List<Categoria> buscarCategoriaDAO() {

        String sql = "SELECT * FROM categoria ORDER BY idCategoria ";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Categoria> categoriaLista = new ArrayList<>();

        try {

            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {

                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt(Categoria.CATEGORIA_COD));
                categoria.setDescricao(rs.getString(Categoria.CATEGORIA_DESC));
                categoriaLista.add(categoria);

            }

        } catch (SQLException ex) {
            System.err.println("Erro buscarCategoriaDAO: " + ex);

        } finally {
            ConnectionDB.closeConnection(con, stmt, rs);
        }

        return categoriaLista;
    }
    
    //========================ATUALIZAR CATEGORIA========================================
    public boolean atualizarCategoriaDAO(Categoria categoria) {

        String sql = "UPDATE categoria SET descricao = ? WHERE idCategoria = ? ";

        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, categoria.getDescricao());
            stmt.setInt(2, categoria.getIdCategoria());
            stmt.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.err.println("Erro atualizarCategoriaDAO: " + ex);
            return false;

        } finally {

            ConnectionDB.closeConnection(con, stmt);

        }
    }
    
    //=========================EXCLUIR CATEGORIA================================
    public boolean excluirCategoriaDAO(Categoria categoria) {

        String sql = "DELETE FROM categoria WHERE IdCategoria = ?";
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setInt(1, categoria.getIdCategoria());
            stmt.executeUpdate();
            return true;

        } catch (SQLException ex) {
        	JOptionPane.showMessageDialog(null,"Impossivel Deletar essa Categoria, já exite um ou mais produtos cadastrados usando ela\\\n"
        			+ "exclua o produto antes ");
            System.err.println("Erro excluirCategoriaDAO: " + ex);
            return false;
        } 
        	
        finally {

            ConnectionDB.closeConnection(con, stmt);
        }
    }
    
}
