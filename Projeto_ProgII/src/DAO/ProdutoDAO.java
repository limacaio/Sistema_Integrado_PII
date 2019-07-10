package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Categoria;
import Model.Marca;
import Model.Produto;

public class ProdutoDAO {

	private Connection con = null;

    public ProdutoDAO() {

        con = ConnectionDB.getConnection();
    }
    
    //caio lima 
    
    //==========================INSERIR PRODUTO======================================================
    
    public boolean inserirProdutoDAO(Produto produto) {

        String sql = "INSERT INTO produto (nome, descricao, valor, saldo,unidadeMedida, imagem, idMarca, idCategoria) "
        		   + "values (?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, produto.getNomeProduto());
            stmt.setString(2, produto.getDescricaoProduto());
            stmt.setFloat(3, (float) produto.getPrecoVenda());
            stmt.setFloat(4, (float) produto.getEstoque());
            stmt.setString(5,produto.getUnidadeMedida());
            stmt.setString(6,produto.getImagem());
            stmt.setInt(7, produto.getMarca().getIdMarca());
            stmt.setInt(8, produto.getCategoria().getIdCategoria());
            stmt.executeUpdate();
            
            return true;

        } catch (SQLException ex) {
            System.err.println("Erro salvarProdutoDAO: " + ex);
            return false;

        } finally {

            ConnectionDB.closeConnection(con, stmt);
        }
    }
    
    //===============BUSCAR PRODUTO=======================================================
    public List<Produto> buscarProdutosDAO() {

        String sql = "SELECT p.*, c.descricao AS categoria ,m.descricao as marca FROM produto p inner JOIN categoria c on c.idCategoria = p.idCategoria inner JOIN marca m on m.idMarca = p.idMarca ORDER BY idProduto ";

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Produto> produtoLista = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto();

                produto.setIdProduto(rs.getInt(Produto.PRODUTO_COD));
                produto.setNomeProduto(rs.getString(Produto.PRODUTO_NOME));
                produto.setDescricaoProduto(rs.getString(Produto.PRODUTO_DESC));
                produto.setPrecoVenda(rs.getFloat(Produto.PRODUTO_PRECO));
                produto.setEstoque(rs.getInt(Produto.PRODUTO_SALDO));
                produto.setUnidadeMedida(rs.getString(Produto.PRODUTO_U_M));
                
                Categoria categoria = new Categoria();
                categoria.setDescricao(rs.getString("categoria"));
                produto.setCategoria(categoria);
                
                Marca marca = new Marca();
                marca.setDescricaoMarca(rs.getString("marca"));
                produto.setMarca(marca);
                
                produto.setImagem(rs.getString(Produto.PRODUTO_IMAGEM));
                
                produtoLista.add(produto);

            }

        } catch (SQLException ex) {
            System.err.println("Erro buscarProdutoDAO: " + ex);

        } finally {
            ConnectionDB.closeConnection(con, stmt, rs);
        }

        return produtoLista;

    }
    //===========================ATUALIZA PRODUTO=========================================
    
    public boolean atualizarProdutoDAO(Produto produto) {

        String sql = "UPDATE produto SET descricao = ? WHERE idProduto = ? ";

        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, produto.getDescricaoProduto());
            stmt.setInt(2, produto.getIdProduto());
            stmt.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.err.println("Erro atualizarProdutoDAO: " + ex);
            return false;

        } finally {

            ConnectionDB.closeConnection(con, stmt);

        }

    }
    
  //==========================EXCLUIR PRODUTO======================================================
    
    public boolean excluirProdutoDAO(Produto produto) {

        String sql = "DELETE FROM produto WHERE idProduto = ?";

        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, produto.getIdProduto());
            stmt.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.err.println("Erro excluirProdutoDAO: " + ex);
            return false;

        } finally {

            ConnectionDB.closeConnection(con, stmt);
        }
    }
}
