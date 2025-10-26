package Banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Conexao.Conexão;
import Encapsulamento.Produto;

public class ClasseMetodos {

	public void salvarProduto(Produto produto) {
		
		String sql = "INSERT INTO PRODUTOS (idProdutos, Nome, Valor, Quantidade) VALUES (?, ?, ?, ?)";
		
		PreparedStatement ps = null;
		
		try {
			ps = Conexão.getConexao().prepareStatement(sql);
			ps.setInt(1, produto.getIdProdutos());
        	ps.setString(2, produto.getNome());
            ps.setDouble(3, produto.getValor());
            ps.setInt(4, produto.getQuantidade());
            
            ps.execute();
            ps.close();
            
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
