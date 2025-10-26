package ClassePrincipal;

import Encapsulamento.Produto;
import Banco.ClasseMetodos;

public class Principal {

	public static void main(String[] args) {

		Produto prod = new Produto();
		prod.setIdProdutos(1);
		prod.setNome("Camisa");
		prod.setValor(64.99);
		prod.setQuantidade(13);
		
		new ClasseMetodos().salvarProduto(prod);
		
	}

}
