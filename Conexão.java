package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexão {

	// --- Configure com seus dados do MySQL ---
    private static final String URL = "jdbc:mysql://localhost:3306/banco_de_dados";
    private static final String USER = "root"; // Coloque seu usuário
    private static final String PASSWORD = "14.03.2006@j"; // Coloque sua senha
	
    private static Connection conn;
    
	public static Connection getConexao() {
	
		try {
			if(conn == null) {
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				return conn;
			} else {
				return conn;
			}
		} catch (SQLException e) { 
	        e.printStackTrace();   
			System.out.println("Erro na conexão com o banco de dados! T-T");
	           return null;
	    }
		
	}
}
