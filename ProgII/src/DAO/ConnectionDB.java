package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionDB {
	/*
	 * Classe DAO padrão para a conexão com o Banco de Dados
	 * 
	 * Winston Igor
	 */


	    private static final String DRIVER = "com.mysql.jdbc.Driver";
	    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
	    private static final String USER = "root";
	    private static final String PASS = "";

	    public static Connection getConnection() {

	        try {
	            Class.forName(DRIVER);

	            return DriverManager.getConnection(URL, USER, PASS);

	        } catch (ClassNotFoundException | SQLException ex) {
	            throw new RuntimeException("Erro na Conexao ao BD.", ex);
	        }
	    }

	    //Metodos de Fechamento conforme documentaçao MySql
	    //Fecha conexao
	    public static void closeConnection(Connection con) {

	        if (con != null) {
	            try {
	                con.close();
	            } catch (SQLException ex) {
	                System.err.println("Erro ao fechar conexao: " + ex);
	            }
	        }

	    }

	    //Fecha conexao, e PreparedStatement
	    public static void closeConnection(Connection con, PreparedStatement stmt) {

	        if (stmt != null) {
	            try {
	                stmt.close();
	            } catch (SQLException ex) {
	                System.err.println("Erro ao fechar conexao e stmt: " + ex);
	            }
	        }

	        closeConnection(con);

	    }

	    //Fecha conexao, e PreparedStatement e ResultSet
	    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

	        if (rs != null) {
	            try {
	                rs.close();
	            } catch (SQLException ex) {
	                System.err.println("Erro ao fechar conexao, stmt e rs: " + ex);
	            }
	        }
	        closeConnection(con, stmt);

	    }

	}



