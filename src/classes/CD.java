package classes;

public class CD extends Produto{

	private String artista;
	private int numeroMusica;
	private String selo;
	
	public CD() {
		
	}
	public CD(String nome, double preco, int qtdEstoque, int numeroItem,String artista, int numeroMusica, String selo) {
		super(nome,preco, qtdEstoque, numeroItem);
		this.artista = artista;
		this.numeroMusica = numeroMusica;
		this.selo = selo;
	}
	public String getArtista() {
		return artista;
	}
	public void setArtista(String artista) {
		this.artista = artista;
	}
	public int getNumeroMusica() {
		return numeroMusica;
	}
	public void setNumeroMusica(int numeroMusica) {
		this.numeroMusica = numeroMusica;
	}
	public String getSelo() {
		return selo;
	}
	public void setSelo(String selo) {
		this.selo = selo;
	}
	
	@Override
	public String toString() {
		String str = "Número do item\t\t: " + this.getNumeroItem() + "\n";
		str 	  += "Nome\t\t\t: " + this.getNome() + "\n";
		str 	  += "Artista\t\t\t: " + this.getArtista() + "\n";
		str 	  += "Musicas do album\t: " + this.getNumeroMusica() + "\n";
		str 	  += "Selo\t\t\t: " + this.getSelo() + "\n";
		str 	  += "Quantidade em estoque\t: " + this.getQtdEstoque() + "\n";
		str 	  += "Preço\t\t\t: " + this.getPreco() + "\n";
		str 	  += "Valor do Estoque\t: " + this.getInventoryValue()+ "\n";
		str 	  += "Status do Produto\t: " + (this.isAtivo()? "Ativo":"Descontinuado") + "\n";
				
		return str;
	}
	
}
