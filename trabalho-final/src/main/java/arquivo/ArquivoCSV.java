package arquivo;

import dados.Drone;
import dados.DroneCargaInanimada;
import dados.DroneCargaViva;
import dados.DronePessoal;
import dados.Estado;
import dados.Transporte;
import dados.TransporteCargaInanimada;
import dados.TransporteCargaViva;
import dados.TransportePessoal;
import handlers.DroneHandler;
import handlers.TransporteHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de utilidades que permite a leitura e
 * escrita de arquivos estruturados em formato CSV.
 *
 * @author Lucas da Paz
 */
public class ArquivoCSV extends ArquivoIO {
	private static final String SUFIXO_DRONES = "-drones.csv";
	private static final String SUFIXO_TRANSPORTES = "-transportes.csv";
	private static final String SEPARADOR = ";";

	private final DroneHandler droneHandler;
	private final TransporteHandler transporteHandler;
	private final String nomeArquivo;

	/**
	 * Inicializa um objeto {@link ArquivoCSV}.
	 *
	 * @param nomeArquivo O nome do arquivo que será utilizado
	 *                    por este objeto.
	 */
	public ArquivoCSV(String nomeArquivo) {
		droneHandler = DroneHandler.getHandler();
		transporteHandler = TransporteHandler.getHandler();
		this.nomeArquivo = nomeArquivo;
	}

	/**
	 * Abre arquivos de saída com o nome do arquivo indicado e
	 * com os sufixos previamente definidos; escreve, em formato
	 * CSV, todas as instâncias de {@link Drone} e {@link Transporte}
	 * salvas em memória durante a execução.
	 *
	 * @throws RuntimeException Se algo de errado ocorrer com os arquivos.
	 */
	public void realizaEscrita() {
		abreArquivoSaida("%s%s".formatted(nomeArquivo, SUFIXO_DRONES));
		StringBuilder droneCsv = new StringBuilder();
		droneCsv.append("tipo;");
		droneCsv.append("codigo;");
		droneCsv.append("custoFixo;");
		droneCsv.append("autonomia;");
		droneCsv.append("qtdMaxPessoas_pesoMaximo;");
		droneCsv.append("protecao_climatizado\n");

		droneHandler.buscaTodos().forEach(d -> droneCsv.append(d.toCSV()).append("\n"));
		boolean sucesso = escreve(droneCsv.toString());
		fechaArquivoSaida();

		if (!sucesso) {
			throw new RuntimeException("Erro ao tentar escrever no arquivo \"%s%s\"!".formatted(nomeArquivo, SUFIXO_DRONES));
		}

		abreArquivoSaida("%s%s".formatted(nomeArquivo, SUFIXO_TRANSPORTES));
		StringBuilder transporteCsv = new StringBuilder();
		transporteCsv.append("tipo;");
		transporteCsv.append("numero;");
		transporteCsv.append("cliente;");
		transporteCsv.append("descricao;");
		transporteCsv.append("peso;");
		transporteCsv.append("latOrigem;");
		transporteCsv.append("longOrigem;");
		transporteCsv.append("latDestino;");
		transporteCsv.append("longDestino;");
		transporteCsv.append("qtdPessoas_perigosa_tempMin;");
		transporteCsv.append("tempMax;");
		transporteCsv.append("situacao;");
		transporteCsv.append("codDrone\n");

		transporteHandler.buscaTodos().forEach(t -> transporteCsv.append(t.toCSV()).append("\n"));
		sucesso = escreve(transporteCsv.toString());
		fechaArquivoSaida();

		if (!sucesso) {
			throw new RuntimeException("Erro ao tentar escrever no arquivo \"%s%s\"!".formatted(nomeArquivo,
				SUFIXO_TRANSPORTES
			));
		}
	}

	/**
	 * Lê o conteúdo dos arquivos de entrada com o nome indicado e
	 * com os sufixos previamente definidos; tenta criar as instâncias
	 * de {@link Drone} e {@link Transporte} salvas em formato CSV no
	 * arquivo e salvá-las em memória. Se ocorrerem erros durante a leitura,
	 * após o fim da execução é lançada uma exceção que detalha em quais linhas
	 * de quais arquivos houve problemas.
	 *
	 * @throws RuntimeException Se algo de errado ocorrer com os arquivos.
	 */
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

	/**
	 * Lê o arquivo com o nome informado e o sufixo {@link #SUFIXO_DRONES},
	 * linha a linha; separa os campos utilizando o {@link #SEPARADOR}
	 * definido e tenta instânciar um {@link Drone} para cada linha. Em caso
	 * de sucesso, adiciona o drone instânciado ao sistema; se ocorrer algum
	 * erro, adiciona à lista de erros passada como argumento.
	 *
	 * @param erros Lista de erros; erros que ocorrerem durante a leitura
	 *              serão adicionados à lista.
	 * @throws RuntimeException Se algo de errado ocorrer com o arquivo.
	 */
	private void leDrones(List<String> erros) {
		abreArquivoEntrada("%s%s".formatted(nomeArquivo, SUFIXO_DRONES));
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
		fechaArquivoEntrada();
	}

	/**
	 * Lê o arquivo com o nome informado e o sufixo {@link #SUFIXO_TRANSPORTES},
	 * linha a linha; separa os campos utilizando o {@link #SEPARADOR}
	 * definido e tenta instânciar um {@link Transporte} para cada linha. Em caso
	 * de sucesso, adiciona o transporte instânciado ao sistema; se ocorrer algum
	 * erro, adiciona à lista de erros passada como argumento.
	 *
	 * @param erros Lista de erros; erros que ocorrerem durante a leitura
	 *              serão adicionados à lista.
	 * @throws RuntimeException Se algo de errado ocorrer com o arquivo.
	 */
	private void leTransportes(List<String> erros) {
		abreArquivoEntrada("%s%s".formatted(nomeArquivo, SUFIXO_TRANSPORTES));
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
		fechaArquivoEntrada();
	}

	/**
	 * Define o tipo de {@link Drone} a ser criado e instancia-o
	 * com os campos passados como argumento.
	 *
	 * @param tipo   O tipo de drone a ser criado, conforme especificado
	 *               no enunciado do trabalho.
	 * @param codigo O código do drone.
	 * @param campos Os campos contendo os dados do drone, conforme especificado
	 *               no enunciado do trabalho.
	 * @return O drone instanciado, ou {@code null} se o tipo for inválido.
	 */
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

	/**
	 * Define o tipo de {@link Transporte} a ser criado e instancia-o
	 * com os campos passados como argumento.
	 *
	 * @param tipo   O tipo de transporte a ser criado, conforme especificado
	 *               no enunciado do trabalho.
	 * @param numero O número do transporte.
	 * @param campos Os campos contendo os dados do transporte, conforme especificado
	 *               no enunciado do trabalho.
	 * @return O transporte instanciado, ou {@code null} se o tipo for inválido.
	 * @throws NumberFormatException    Se não for possível converter algum campo numérico.
	 * @throws IllegalArgumentException Se for informada uma situação sem valor correspondente
	 *                                  na enumeração {@link Estado}.
	 */
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
				Transporte t = new TransportePessoal(numero,
					cliente,
					descricao,
					peso,
					latOrigem,
					longOrigem,
					latDestino,
					longDestino,
					qtdPessoas
				);

				if (campos.length > 10) {
					Estado situacao = Estado.valueOf(campos[10]);
					Drone drone = droneHandler.buscaPorCodigo(Integer.parseInt(campos[11]));
					t.carrega(situacao, drone);
				}

				yield t;
			}
			case 2 -> {
				boolean perigosa = Boolean.parseBoolean(campos[9]);
				Transporte t = new TransporteCargaInanimada(numero,
					cliente,
					descricao,
					peso,
					latOrigem,
					longOrigem,
					latDestino,
					longDestino,
					perigosa
				);

				if (campos.length > 10) {
					Estado situacao = Estado.valueOf(campos[10]);
					Drone drone = droneHandler.buscaPorCodigo(Integer.parseInt(campos[11]));
					t.carrega(situacao, drone);
				}

				yield t;
			}
			case 3 -> {
				double temperaturaMin = Double.parseDouble(campos[9]);
				double temperaturaMax = Double.parseDouble(campos[10]);
				Transporte t = new TransporteCargaViva(numero,
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

				if (campos.length > 11) {
					Estado situacao = Estado.valueOf(campos[11]);
					Drone drone = droneHandler.buscaPorCodigo(Integer.parseInt(campos[12]));
					t.carrega(situacao, drone);
				}

				yield t;
			}
			default -> null;
		};
	}
}
