package Banco;

public class Produto {
	//Atributos
	private int id;
	private String Nome;
	private Double Valor;
	private int Quantidade;
	

	//Construtores
	public Produto(int id, String Nome, Double Valor, int Quantidade) {
		this.id = id;
		this.Nome = Nome;
        this.Valor = Valor;
        this.Quantidade = Quantidade;
    }


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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
        return "Cliente [id=" + id + ", nome=" + Nome + ", Valor=" + Valor + ", Quantidade=" + Quantidade + "]";
    }
}
