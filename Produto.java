package Encapsulamento;

public class Produto {
	//Atributos
	private int idProdutos;
	private String Nome;
	private Double Valor;
	private int Quantidade;
	

	//Construtores
	public Produto(int id, String Nome, Double Valor, int Quantidade) {
		this.idProdutos = idProdutos;
		this.Nome = Nome;
        this.Valor = Valor;
        this.Quantidade = Quantidade;
    }


	public Produto() {
		System.out.println("O produto será salvo no banco de dados.");
	}


	public int getIdProdutos() {
		return idProdutos;
	}


	public void setIdProdutos(int idProdutos) {
		this.idProdutos = idProdutos;
	}


	public String getNome() {
		return Nome;
	}


	public void setNome(String nome) {
		Nome = nome;
	}


	public Double getValor() {
		return Valor;
	}


	public void setValor(Double valor) {
		Valor = valor;
	}


	public int getQuantidade() {
		return Quantidade;
	}


	public void setQuantidade(int quantidade) {
		Quantidade = quantidade;
	}
	
	@Override
    public String toString() {
        return "Produto [id=" + idProdutos + ", nome=" + Nome + ", Valor=" + Valor + ", Quantidade=" + Quantidade + "]";
    }
}
