package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexão {

	// --- Configure com seus dados do MySQL ---
    private static final String URL = "jdbc:mysql://localhost/Cadastro_Produto";
    private static final String USER = "João"; // Coloque seu usuário
    private static final String PASSWORD = "123"; // Coloque sua senha
	
	public static Connection getConexao() {
	
		try {
            // Carrega o driver do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection Conexão = DriverManager.getConnection("jdbc:mysql://localhost/Cadastro_Produto"); //Server=localhost\SQLEXPRESS;Database=master;Trusted_Connection=True;
            return DriverManager.getConnection(URL, USER, PASSWORD);
          
		} catch (ClassNotFoundException e) {
			System.out.println("Driver do banco de dados não localizado! T-T");
            
        } catch (SQLException e) { 
           System.out.println("Erro na conexão com o banco de dados! T-T");
        }
		return null; 
	}
}
