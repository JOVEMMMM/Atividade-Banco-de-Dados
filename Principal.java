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
		        String sql = "INSERT INTO cliente (nome, email) VALUES (?, ?)";

		        // Usamos try-with-resources para fechar a conexão automaticamente
		        try (Connection conn = ConexaoBanco.getConexao();
		             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

		            // Define os valores dos parâmetros (?)
		            pstmt.setString(1, produtos.getNome());
		            //pstmt.setString(2, produtos.getEmail());

		            // Executa o comando
		            int affectedRows = pstmt.executeUpdate();

		            if (affectedRows > 0) {
		                System.out.println("SUCESSO: Cliente salvo!");
		                
		                // Pega o ID que o banco gerou
		                try (ResultSet rs = pstmt.getGeneratedKeys()) {
		                    if (rs.next()) {
		                        int idGerado = rs.getInt(1);
		                        produtos.setId(idGerado); // Atualiza o ID no objeto cliente
		                    }
		                }
		            } else {
		                System.out.println("ERRO: Cliente não foi salvo.");
		            }

		        } catch (SQLException e) {
		            System.out.println("ERRO de SQL: " + e.getMessage());
		        }
		    }

		    // --- REQUISITO: Fazer a aplicação Alterar os dados do banco ---
		    public static void alterarCliente(Produto produtos) {
		        // Só podemos alterar se o cliente JÁ TIVER um ID
		        if (produtos.getId() == 0) {
		            System.out.println("ERRO: Cliente precisa ser salvo primeiro para ser alterado.");
		            return;
		        }

		        String sql = "UPDATE cliente SET nome = ?, email = ? WHERE id = ?";

		        try (Connection conn = Conexão.getConexao();
		             PreparedStatement pstmt = conn.prepareStatement(sql)) {

		            // Define os parâmetros (?)
		            pstmt.setString(1, produtos.getNome());
		            //pstmt.setString(2, produtos.getEmail());
		            pstmt.setInt(3, produtos.getId()); // O ID vai no WHERE

		            // Executa o comando
		            int affectedRows = pstmt.executeUpdate();

		            if (affectedRows > 0) {
		                System.out.println("SUCESSO: Cliente ID " + produtos.getId() + " alterado!");
		            } else {
		                System.out.println("AVISO: Nenhum cliente encontrado com o ID " + produtos.getId());
		            }

		        } catch (SQLException e) {
		            System.out.println("ERRO de SQL: " + e.getMessage());
		        }
		    }


		    // --- Ponto de entrada para "rodar" a aplicação ---
		    public static void main(String[] args) {
		        System.out.println("--- 1. Testando GRAVAR cliente ---");
		        
		        // 1. Cria um novo objeto Cliente
		        Produto novoProduto = new Produto("Maria Souza", "maria.souza@email.com");
		        System.out.println("Criando: " + novoProduto);

		        // 2. Chama a função de salvar
		        salvarCliente(novoProduto);
		        
		        System.out.println("Cliente salvo com ID: " + novoProduto.getId());
		        System.out.println("------------------------------------");

		        
		        System.out.println("\n--- 2. Testando ALTERAR cliente ---");
		        
		        // 3. Modifica o objeto
		        novoProduto.setNome("Maria Souza (Editado)");
		        //novoProduto.setEmail("maria.editada@email.com");
		        System.out.println("Alterando para: " + novoProduto);

		        // 4. Chama a função de alterar
		        alterarCliente(novoProduto);
		        
		        System.out.println("------------------------------------");
		        System.out.println("\nVerifique seu banco de dados MySQL para ver os resultados!");
	}
}
