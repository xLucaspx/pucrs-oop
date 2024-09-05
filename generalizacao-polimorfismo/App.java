import java.util.Scanner;

public class App {
	private Frota frota;
	private Scanner entrada;

	public App() {
		frota = new Frota();
		entrada = new Scanner(System.in);
	}

	/**
	 * Inclui alguns objetos para testes
	 */
	public void inicializa() {
		Veiculo v;
		v = new Veiculo("AAA-1A11", 50000.00);
		frota.addVeiculo(v);
		v = new Veiculo("BBB-2B22", 100000.00);
		frota.addVeiculo(v);
	}

	/**
	 * Execução da aplicação
	 */
	public void executa() {
		int op = 0;
		do {
			System.out.println("===================");
			System.out.println("Opções:");
			System.out.println("[0] Sair");
			System.out.println("[1] Consulta por placa");
			System.out.print("Digite a opção desejada: ");
			op = entrada.nextInt();
			entrada.nextLine();
			switch (op) {
				case 1:
					consultaPorPlaca();
					break;
				case 0:
					break;
				default:
					System.out.println("Opção inválida.");
			}
		} while (op != 0);
	}

	/**
	 * Consulta um veículo pela placa
	 */
	private void consultaPorPlaca() {
		System.out.println("===================");
		System.out.print("Digite a placa do veículo: ");
		String placa = entrada.nextLine();
		Veiculo f = frota.pesquisaPlaca(placa);
		if (f == null) {
			System.out.println("Erro. Nao há veículo com esta placa.");
		} else {
			System.out.println(f.toString());
		}
	}
}
