package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexão {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            // Carrega o driver do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection Conexão = DriverManager.getConnection("jdbc:mysql://localhost/Cadastro_Produto"); //Server=localhost\SQLEXPRESS;Database=master;Trusted_Connection=True;
            ResultSet rsProduto = Produto.createStatement().executeQuery("select * from Produtos"); //jdbc:mysql://localhost/Cadastro_Produto
            while (rsProduto.next()) {
            	System.out.println("Nome: " + rsProduto.getString("nome"));
            }
           
		} catch (ClassNotFoundException e) {
			System.out.println("Driver do banco de dados não localizado! T-T");
            
        } catch (SQLException e) { 
           System.out.println("Erro na conexão com o banco de dados! T-T");
        } finally {
        	if (Conexão != null){
        		Conexão.close();
        	}
        }
	}

}
