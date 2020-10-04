package classes;



public class Produto {

	//Declarações de campo de instancia
	private String nome;
	private double preco;
	private int qtdEstoque;
	private int numeroItem;
	private boolean ativo = true;
	
	
	//redefinicao do construtor padrao - serve para instancia o objeto em memoria
	public Produto() {
	}

	//serve para instancia o objeto em memoria com suas propriedades ja inicilizadas
	public Produto(String nome, double preco, int qtdEstoque, int numeroItem) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.qtdEstoque = qtdEstoque;
		this.numeroItem = numeroItem;
	}

	public void addToInventory(int quantidade) {
		if(this.isAtivo())
			this.qtdEstoque +=quantidade;
	}
	
	public void deductFromInventory(int quantidade) {
		this.qtdEstoque -=quantidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public int getNumeroItem() {
		return numeroItem;
	}

	public void setNumeroItem(int numeroItem) {
		this.numeroItem = numeroItem;
	}

	
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		String str = "Número do item\t\t: " + this.getNumeroItem() + "\n";
		str 	  += "Nome\t\t\t: " + this.getNome() + "\n";
		str 	  += "Quantidade em estoque\t: " + this.getQtdEstoque() + "\n";
		str 	  += "Preço\t\t\t: " + this.getPreco() + "\n";
		str 	  += "Valor do Estoque\t: " + this.getInventoryValue()+ "\n";
		str 	  += "Status do Produto\t: " + (this.isAtivo()? "Ativo":"Descontinuado") + "\n";
				
		return str;
	}


	public double getInventoryValue() {
		return this.getQtdEstoque()*this.getPreco();
	}
	
	
	
}
