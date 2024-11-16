package arquivo;

import dados.Drone;
import dados.DroneCargaInanimada;
import dados.DroneCargaViva;
import dados.DronePessoal;
import dados.Transporte;
import dados.TransporteCargaInanimada;
import dados.TransporteCargaViva;
import dados.TransportePessoal;
import handlers.DroneHandler;
import handlers.TransporteHandler;

import java.util.ArrayList;
import java.util.List;

public class ArquivoSimulacao extends ArquivoIO {
	private static final String SUFIXO_DRONES = "-drones.csv";
	private static final String SUFIXO_TRANSPORTES = "-transportes.csv";
	private static final String SEPARADOR = ";";

	private final DroneHandler droneHandler;
	private final TransporteHandler transporteHandler;
	private final String nomeArquivo;

	public ArquivoSimulacao(String nomeArquivo) {
		droneHandler = DroneHandler.getHandler();
		transporteHandler = TransporteHandler.getHandler();
		this.nomeArquivo = nomeArquivo;
	}

	public void realizaLeitura() {
		List<String> errosDrones = new ArrayList<>();
		List<String> errosTransportes = new ArrayList<>();
		leDrones(errosDrones);
		leTransportes(errosTransportes);

		StringBuilder erros = new StringBuilder();

		if (!errosDrones.isEmpty()) {
			erros.append("Arquivo \"%s%s\":\n".formatted(nomeArquivo, SUFIXO_DRONES));
			errosDrones.forEach(e -> erros.append("\t- ").append(e).append("\n"));
		}

		if (!errosTransportes.isEmpty()) {
			erros.append("Arquivo \"%s%s\":\n".formatted(nomeArquivo, SUFIXO_TRANSPORTES));
			errosTransportes.forEach(e -> erros.append("\t- ").append(e).append("\n"));
		}

		if (!erros.isEmpty()) {
			throw new RuntimeException(erros.toString());
		}
	}

	private void leDrones(List<String> erros) {
		redirecionaEntrada("%s%s".formatted(nomeArquivo, SUFIXO_DRONES));
		String linha = proximaLinha(); // cabeçalho
		int cont = 0;
		while ((linha = proximaLinha()) != null) {
			try {
				cont++;

				if (linha.isEmpty()) {
					continue;
				}

				String[] campos = linha.split(SEPARADOR);

				int tipo = Integer.parseInt(campos[0]);
				int codigo = Integer.parseInt(campos[1]);
				Drone d = criaDrone(tipo, codigo, campos);

				if (d == null) {
					erros.add("Linha %d: Tipo de drone inválido".formatted(cont));
					continue;
				}

				boolean cadastrado = droneHandler.cadastra(d);
				if (!cadastrado) {
					erros.add("Linha %d: Já existe um drone cadastrado com o código %d".formatted(cont, codigo));
				}
			} catch (IndexOutOfBoundsException e) {
				erros.add("Linha %d: Número de campos não corresponde ao necessário para o cadastro (%s)".formatted(cont,
					e.getMessage()
				));
				e.printStackTrace(System.err);
			} catch (NumberFormatException e) {
				erros.add("Linha %d: Valor inválido inserido (%s)".formatted(cont, e.getMessage()));
				e.printStackTrace(System.err);
			} catch (Exception e) {
				erros.add("Linha %d: Erro inesperado (%s)".formatted(cont, e.getMessage()));
				e.printStackTrace(System.err);
			}
		}
		fechaEntrada();
	}

	private void leTransportes(List<String> erros) {
		redirecionaEntrada("%s%s".formatted(nomeArquivo, SUFIXO_TRANSPORTES));
		String linha = proximaLinha(); // cabeçalho
		int cont = 0;
		while ((linha = proximaLinha()) != null) {
			try {
				cont++;

				if (linha.isEmpty()) {
					continue;
				}

				String[] campos = linha.split(SEPARADOR);

				int tipo = Integer.parseInt(campos[0]);
				int numero = Integer.parseInt(campos[1]);
				Transporte t = criaTransporte(tipo, numero, campos);

				if (t == null) {
					erros.add("Linha %d: Tipo de transporte inválido".formatted(cont));
					continue;
				}

				boolean cadastrado = transporteHandler.cadastra(t);
				if (!cadastrado) {
					erros.add("Linha %d: Já existe um transporte cadastrado com o número %d".formatted(cont, numero));
				}
			} catch (IndexOutOfBoundsException e) {
				erros.add("Linha %d: Número de campos não corresponde ao necessário para o cadastro (%s)".formatted(cont,
					e.getMessage()
				));
				e.printStackTrace(System.err);
			} catch (NumberFormatException e) {
				erros.add("Linha %d: Valor inválido inserido (%s)".formatted(cont, e.getMessage()));
				e.printStackTrace(System.err);
			} catch (Exception e) {
				erros.add("Linha %d: Erro inesperado (%s)".formatted(cont, e.getMessage()));
				e.printStackTrace(System.err);
			}
		}
		fechaEntrada();
	}

	private Drone criaDrone(int tipo, int codigo, String[] campos) {
		double custoFixo = Double.parseDouble(campos[2]);
		double autonomia = Double.parseDouble(campos[3]);

		return switch (tipo) {
			case 1 -> {
				int maxPessoas = Integer.parseInt(campos[4]);
				yield new DronePessoal(codigo, custoFixo, autonomia, maxPessoas);
			}
			case 2 -> {
				double pesoMax = Double.parseDouble(campos[4]);
				boolean protecao = Boolean.parseBoolean(campos[5]);
				yield new DroneCargaInanimada(codigo, custoFixo, autonomia, pesoMax, protecao);
			}
			case 3 -> {
				double pesoMax = Double.parseDouble(campos[4]);
				boolean climatizacao = Boolean.parseBoolean(campos[5]);
				yield new DroneCargaViva(codigo, custoFixo, autonomia, pesoMax, climatizacao);
			}
			default -> null;
		};
	}

	private Transporte criaTransporte(int tipo, int numero, String[] campos) {
		String cliente = campos[2];
		String descricao = campos[3];
		double peso = Double.parseDouble(campos[4]);
		double latOrigem = Double.parseDouble(campos[5]);
		double longOrigem = Double.parseDouble(campos[6]);
		double latDestino = Double.parseDouble(campos[7]);
		double longDestino = Double.parseDouble(campos[8]);

		return switch (tipo) {
			case 1 -> {
				int qtdPessoas = Integer.parseInt(campos[9]);
				yield new TransportePessoal(numero,
					cliente,
					descricao,
					peso,
					latOrigem,
					longOrigem,
					latDestino,
					longDestino,
					qtdPessoas
				);
			}
			case 2 -> {
				boolean perigosa = Boolean.parseBoolean(campos[9]);
				yield new TransporteCargaInanimada(numero,
					cliente,
					descricao,
					peso,
					latOrigem,
					longOrigem,
					latDestino,
					longDestino,
					perigosa
				);
			}
			case 3 -> {
				double temperaturaMin = Double.parseDouble(campos[9]);
				double temperaturaMax = Double.parseDouble(campos[10]);
				yield new TransporteCargaViva(numero,
					cliente,
					descricao,
					peso,
					latOrigem,
					longOrigem,
					latDestino,
					longDestino,
					temperaturaMin,
					temperaturaMax
				);
			}
			default -> null;
		};
	}
}
