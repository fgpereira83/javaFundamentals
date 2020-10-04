package classes;
import java.util.Scanner;

public class ProductTester {
	
	public static void main(String[] args) {
		int maxSize, menuChoice;
		Produto[] produtos;
		
		Scanner input = new Scanner(System.in);
		maxSize = getNumProducts(input);
		
		if(maxSize==0) {
			System.out.println("Não há produtos!");
		}else {
			produtos = new Produto[maxSize];
			addToInventory(produtos,input);
			do {
				menuChoice =getMenuOption(input);
				executeMenuChoice(menuChoice,produtos,input);
			}while (menuChoice !=0);
		}
	}

	
	public static void displayInvetory(Produto[] produtos) {
		for (Produto produto : produtos) {
			System.out.println(produto);
		}
		
	}
	
	public static void addToInventory(Produto[] produtos, Scanner input) {
		int stockChoice=-1;
		
		try {
			do {
				System.out.println("1: CD");
				System.out.println("2: DVD");
				System.out.println("Insira o tipo de produto:");
				stockChoice = input.nextInt();
			}while(stockChoice<1 ||stockChoice>2 );

			if (stockChoice ==1) {
				addCDToInventory(produtos, input);
			}else {
				addDVDToInventory(produtos, input);
			}
			
		} catch (Exception e) {
			System.out.println("Somente os números 1 ou 2 são permitidos!");
			input.nextLine();
		}
		
		
		
	}
	
	public static void addCDToInventory(Produto[] produtos, Scanner input) {
		int tempNumber,tempQty,tempNumeroMusica; 
		String tempName, tempArtista, tempSelo;
		double tempPrice;
		
		
		for(int i=0; i< produtos.length; i++) {
			input.nextLine();
			
			System.out.println("Insira o nome do CD:");
			tempName =input.nextLine();
			
			System.out.println("Insira o nome do artista:");
			tempArtista =input.nextLine();
			
			System.out.println("Insira o nome do selo de gravação:");
			tempSelo =input.nextLine();
			
			System.out.println("Insira o número de músicas:");
			tempNumeroMusica = input.nextInt();
			
			System.out.println("Insira a quantidade em estoque para este produto:");
			tempQty = input.nextInt();
			
			
			System.out.println("Insira o preço para este produto:");
			tempPrice = input.nextDouble();
			
			System.out.println("Insira o número do item:");
			tempNumber = input.nextInt();
			
			produtos[i] = new CD(tempName,tempPrice,tempQty, tempNumber,tempArtista, tempNumeroMusica, tempSelo);
		}
	}
	
	public static void addDVDToInventory(Produto[] produtos, Scanner input) {
		int tempNumber,tempQty,tempClassificacaoEtaria,tempDuracao; 
		String tempName, tempEstudio;
		double tempPrice;
		
		
		for(int i=0; i< produtos.length; i++) {
			input.nextLine();
			
			System.out.println("Insira o nome do DVD:");
			tempName =input.nextLine();
			
			System.out.println("Insira o nome do estúdio cinematográfico:");
			tempEstudio =input.nextLine();
			
			System.out.println("Insira a classificação etária:");
			tempClassificacaoEtaria = input.nextInt();
			
			System.out.println("Insira a duração em minutos:");
			tempDuracao = input.nextInt();
			
			System.out.println("Insira a quantidade em estoque para este produto:");
			tempQty = input.nextInt();
			
			System.out.println("Insira o preço para este produto:");
			tempPrice = input.nextDouble();

			System.out.println("Insira o número do item:");
			tempNumber = input.nextInt();
			
			
			produtos[i] = new DVD(tempName,tempPrice,tempQty, tempNumber,tempDuracao,tempClassificacaoEtaria,tempEstudio);
		}
	}
	
	public static int getNumProducts(Scanner input) {
		int maxSize=-1;
		
		do {
			try {
				System.out.println("Insira o número de produtos que gostaria de adicionar\r\n" + 
						"Insira 0 (zero) se não quiser adicionar produtos");
				maxSize = input.nextInt();
				
				if(maxSize<0)
					System.out.println("Valor incorreto inserido");
			} catch (Exception e) {
				System.out.println("Tipo incorreto de dados inserido!");
				input.nextLine();
			}
			
		} while(!(maxSize>=0));
		return maxSize;
	}
	
	private static int getMenuOption(Scanner input) {
		int opcao=-1;
		
		try {
			do {
				System.out.println("1. Exibir Inventário");
				System.out.println("2. Adicionar Estoque");
				System.out.println("3. Deduzir Estoque");
				System.out.println("4. Descontinuar Produto");
				System.out.println("0. Sair");
				System.out.println("Insira uma opção de menu:");
				opcao =input.nextInt();
				
			}while(!(opcao>=0 && opcao<=4));
			
		} catch (Exception e) {
			System.out.println("Opção inválida");
			input.nextLine();
		}
		return opcao;
	}
	
	
	private static int getProductNumber(Produto[] produtos,Scanner input) {
		int productChoice=-1;
		
		for(int i=0; i < produtos.length; i++) {
			System.out.println("index: "+ i+ " - " + produtos[i].getNome());
		}
		
		try {
			do {
				System.out.println("Qual o produto identificado pelo index deseja alterar");
				productChoice =input.nextInt();
			}while(!(productChoice>=0 && productChoice<=produtos.length-1));
			
		} catch (Exception e) {
			System.out.println("Index de produto inválido");
			input.nextLine();
		}
		
		return productChoice;
	} 
	
	
	
	private static void addInventory(Produto[] produtos, Scanner input) {
		int productChoice, updateValue=-1;
		
		productChoice=getProductNumber(produtos, input);
		try {
			do {
				System.out.println("Quantos produtos deseja adicionar?");
				updateValue =input.nextInt();
			}while(!(updateValue>0));
			
			produtos[productChoice].addToInventory(updateValue);

		} catch (Exception e) {
			System.out.println("A qtd precisa ser positiva e maior que zero");
			input.nextLine();
		}
	}
	
	private static void deductInventory(Produto[] produtos, Scanner input) {
		int productChoice, updateValue=-1;
		
		productChoice=getProductNumber(produtos, input);
		try {
			do {
				System.out.println("Quantos produtos deseja remover?");
				updateValue =input.nextInt();
			}while(!(updateValue>0));
			
			produtos[productChoice].deductFromInventory(updateValue);

		} catch (Exception e) {
			System.out.println("A qtd precisa ser positiva e maior que zero");
			input.nextLine();
		}
	}
	
	private static void discontinueInventory(Produto[] produtos, Scanner input) {
		int productChoice;
		
		productChoice=getProductNumber(produtos, input);
		produtos[productChoice].setAtivo(false);
	}
	
	public static void executeMenuChoice(int menuChoice,Produto[] produtos, Scanner input) {
		switch (menuChoice) {
		case 1: displayInvetory(produtos);
				break;
		case 2: addInventory(produtos, input);
				break;
		case 3: deductInventory(produtos, input);
				break;
		case 4: discontinueInventory(produtos, input);
				break;
		default:
			break;
		}
	}
}
