package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Marca;

public class MarcaDAO {
	
	private Connection con = null;

    public MarcaDAO() {

        con = ConnectionDB.getConnection();

    }
    
  //CAIO LIMA 
    //=======================INSERIR MARCA=======================================
    public boolean inserirMarcaDAO(Marca marca) {

        String sql = "INSERT INTO marca (descricao) values (?)";

        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, marca.getDescricaoMarca());
            stmt.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.err.println("Erro salvarMarcaDAO: " + ex);
            return false;

        } finally {

            ConnectionDB.closeConnection(con, stmt);
        }
    }
    
//=======================BUSCAR MARCA====================================
    
    public List<Marca> buscarMarcaDAO() {

        String sql = "SELECT * FROM marca ORDER BY descricao ";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Marca> marcaLista = new ArrayList<>();

        try {

            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {

               Marca marca = new Marca();
                marca.setIdMarca(rs.getInt(Marca.MARCA_ID));
                marca.setDescricaoMarca(rs.getString(Marca.MARCA_DESC));
                marcaLista.add(marca);

            }

        } catch (SQLException ex) {
            System.err.println("Erro buscarMarcaDAO: " + ex);

        } finally {
            ConnectionDB.closeConnection(con, stmt, rs);
        }

        return marcaLista;
    }
    
  //========================ATUALIZAR MARCA========================================
    public boolean atualizarMarcaDAO(Marca marca) {

        String sql = "UPDATE marca SET descricao = ? WHERE idMarca = ? ";

        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, marca.getDescricaoMarca());
            stmt.setInt(2, marca.getIdMarca());
            stmt.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.err.println("Erro atualizarMarcaDAO: " + ex);
            return false;

        } finally {

            ConnectionDB.closeConnection(con, stmt);

        }
    }
    
  //=========================EXCLUIR MARCA================================
    public boolean excluirMarcaDAO(Marca marca) {

        String sql = "DELETE FROM marca WHERE IdMarca = ?";
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setInt(1, marca.getIdMarca());
            stmt.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.err.println("Erro excluirMarcaDAO: " + ex);
            return false;

        } finally {

            ConnectionDB.closeConnection(con, stmt);
        }
    }
    
}
