package Banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {
		    // --- REQUISITO: Fazer a aplicação gravar no banco ---
	public static void salvarCliente(Produto produtos) {
		        // Comando SQL de inserção
		        String sql = "INSERT INTO produto (id, Nome, Valor, Quantidade) VALUES (?, ?, ?, ?)";

		        // Usamos try-with-resources para fechar a conexão automaticamente
		        try (Connection conn = Conexão.getConexao();
		             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

		            // Define os valores dos parâmetros (?)
		        	pstmt.setInt(1, produtos.getId());
		        	pstmt.setString(2, produtos.getNome());
		            pstmt.setDouble(3, produtos.getValor());
		            pstmt.setInt(4, produtos.getQuantidade());

		            // Executa o comando
		            int affectedRows = pstmt.executeUpdate();

		            if (affectedRows > 0) {
		                System.out.println("SUCESSO: Produto salvo!");
		                
		                // Pega o ID que o banco gerou
		                try (ResultSet rs = pstmt.getGeneratedKeys()) {
		                    if (rs.next()) {
		                        int idGerado = rs.getInt(1);
		                        produtos.setId(idGerado); // Atualiza o ID no objeto produto
		                    }
		                }
		            } else {
		                System.out.println("ERRO: Produto não foi salvo.");
		            }

		        } catch (SQLException e) {
		            System.out.println("ERRO de SQL: " + e.getMessage());
		        }
		    }

		    // --- REQUISITO: Fazer a aplicação Alterar os dados do banco ---
		    public static void alterarProduto(Produto produtos) {
		        // Só podemos alterar se o cliente JÁ TIVER um ID
		        if (produtos.getId() == 0) {
		            System.out.println("ERRO: Produto precisa ser salvo primeiro para ser alterado.");
		            return;
		        }

		        String sql = "UPDATE produto SET Nome = ?, Valor = ?, Quantidade = ? WHERE id = ?";

		        try (Connection conn = Conexão.getConexao();
		             PreparedStatement pstmt = conn.prepareStatement(sql)) {

		            // Define os parâmetros
		        	pstmt.setString(2, produtos.getNome());
		            pstmt.setDouble(3, produtos.getValor());
		            pstmt.setInt(4, produtos.getQuantidade());
		            pstmt.setInt(3, produtos.getId()); // O ID vai no WHERE

		            // Executa o comando
		            int affectedRows = pstmt.executeUpdate();

		            if (affectedRows > 0) {
		                System.out.println("SUCESSO: Produto ID " + produtos.getId() + " alterado!");
		            } else {
		                System.out.println("AVISO: Nenhum produto encontrado com o ID " + produtos.getId());
		            }

		        } catch (SQLException e) {
		            System.out.println("ERRO de SQL: " + e.getMessage());
		        }
		    }


		    // Ponto de entrada para "rodar" a aplicação
		    public static void main(String[] args) {
		        System.out.println("--- 1. Testando GRAVAR produto ---");
		        
		        // Cria um novo objeto Produto
		        Produto novoProduto = new Produto(1, "Coberta", 50.00, 6);
		        System.out.println("Criando: " + novoProduto);

		        // Chama a função de salvar
		        alterarProduto(novoProduto);
		        
		        System.out.println("Produto salvo com ID: " + novoProduto.getId());
		        System.out.println("------------------------------------");

		        
		        System.out.println("\n Testando ALTERAR produto ");
		        
		        // Modifica o objeto
		        novoProduto.setNome("Toalha (Editado)");		        
		        System.out.println("Alterando para: " + novoProduto);

		        // Chama a função de alterar
		        alterarProduto(novoProduto);
		        
		        System.out.println("------------------------------------");
		        System.out.println("\nVerifique seu banco de dados MySQL para ver os resultados!");
	}
}
