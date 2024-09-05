import java.util.Locale;
import java.util.Scanner;

public class App {
	private Scanner entrada;
	private Vestuario vestuario;
	private CatalogoAluguel catalogoAluguel;

	public App() {
		entrada = new Scanner(System.in);
		entrada.useLocale(Locale.ENGLISH);
		vestuario = new Vestuario();
		catalogoAluguel = new CatalogoAluguel();
	}

	/**
	 * Executa a aplicacao
	 * Termina quando o usuario digitar a opcao 0
	 */
	public void executar() {
		System.out.println("Aplicacao de roupas executando...");
		int opcao = 0;
		do {
			menu();
			System.out.print("Digite a opcao desejada: ");
			opcao = Integer.parseInt(entrada.nextLine());
			switch (opcao) {
				case 1 -> {
					cadastrarRoupa();
				}
				case 2 -> {
					consultarRoupaPeloCodigo();
				}
				case 42 -> {
					easterEgg();
				}
				default -> System.out.println("Opcao invalida. Redigite.");
			}
		} while (opcao != 0);
	}

	/**
	 * Apresenta o menu de opcoes do sistema para o usuario
	 */
	private void menu() {
		System.out.println("============================");
		System.out.println("APLICACAO DE ROUPAS");
		System.out.println("Opcoes:");
		System.out.println("[0] Terminar.");
		System.out.println("[1] Cadastrar uma roupa.");
		System.out.println("[2] Consultar uma roupa pelo codigo.");
	}

	/**
	 * Cadastra uma nova roupa a partir dos dados
	 * digitados pelo usuario
	 */
	private void cadastrarRoupa() {
		int tamanho;
		String cor;
		int codigo;
		Roupa novaRoupa;

		System.out.println("============================");
		System.out.println("Cadastrar uma roupa");
		System.out.print("Digite o codigo da roupa: ");
		codigo = Integer.parseInt(entrada.nextLine());

		System.out.print("Digite o tamanho da roupa: ");
		tamanho = Integer.parseInt(entrada.nextLine());

		System.out.print("Digite a cor da roupa: ");
		cor = entrada.nextLine();

		novaRoupa = new Roupa(tamanho, cor, codigo);
		boolean ok = vestuario.adicionaRoupa(novaRoupa);
		String mensagem = ok ? "Nova roupa cadastrada!" : "Roupa invalida - codigo repetido.";
		System.out.println(mensagem);
	}

	/**
	 * Consulta uma roupa a partir de um codigo
	 * digitado pelo usuario
	 */
	private void consultarRoupaPeloCodigo() {
		int codigo;
		System.out.println("============================");
		System.out.println("Consultar uma roupa");
		System.out.print("Digite o codigo da roupa: ");
		codigo = Integer.parseInt(entrada.nextLine());

		Roupa c = vestuario.consultaRoupaPorCodigo(codigo);
		if (c == null) {
			System.out.println("Nao existe roupa com este codigo.");
			return;
		}

		System.out.println("Dados da roupa: ");
		System.out.println("Codigo: " + c.getCodigo());
		System.out.println("Tamanho: " + c.getTamanho());
		System.out.println("Cor: " + c.getCor());
	}

	/**
	 * Easter egg: adiciona algumas roupas no sistema
	 */
	public void easterEgg() {
		System.out.println("============================");
		vestuario.adicionaRoupa(new Roupa(20, "Azul", 22));
		vestuario.adicionaRoupa(new Roupa(30, "Vermelho", 33));
		vestuario.adicionaRoupa(new Roupa(40, "Amarelo", 44));
		System.out.println("Easter egg: algumas roupas cadastradas.");
	}
}
