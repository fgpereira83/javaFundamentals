package classes;

public class DVD extends Produto{
	private int duracao;
	private int classificacaoEtaria;
	private String estudio;
	
	public DVD() {
		
	}
	
	public DVD(String nome, double preco, int qtdEstoque, int numeroItem, int duracao, int classificacaoEtaria, String estudio) {
		super(nome,preco, qtdEstoque, numeroItem);
		this.duracao = duracao;
		this.classificacaoEtaria = classificacaoEtaria;
		this.estudio = estudio;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public int getClassificacaoEtaria() {
		return classificacaoEtaria;
	}

	public void setClassificacaoEtaria(int classificacaoEtaria) {
		this.classificacaoEtaria = classificacaoEtaria;
	}

	public String getEstudio() {
		return estudio;
	}

	public void setEstudio(String estudio) {
		this.estudio = estudio;
	}
	
	@Override
	public double getInventoryValue() {
		return (super.getInventoryValue()) *1.05;
	}
	
	@Override
	public String toString() {
		String str = "N�mero do item\t\t: " + this.getNumeroItem() + "\n";
		str 	  += "Nome\t\t\t: " + this.getNome() + "\n";
		str 	  += "Dura��o\t\t\t: " + this.getDuracao() + "\n";
		str 	  += "Classifica��o Etaria\t: " + this.getClassificacaoEtaria() + "\n";
		str 	  += "Estudio cinematrografico\t: " + this.getEstudio() + "\n";
		str 	  += "Quantidade em estoque\t: " + this.getQtdEstoque() + "\n";
		str 	  += "Pre�o\t\t\t: " + this.getPreco() + "\n";
		str 	  += "Valor do Estoque\t: " + this.getInventoryValue()+ "\n";
		str 	  += "Status do Produto\t: " + (this.isAtivo()? "Ativo":"Descontinuado") + "\n";
				
		return str;
	}
	

}
