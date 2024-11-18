package arquivo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dados.Drone;
import dados.DroneCargaInanimada;
import dados.DroneCargaViva;
import dados.DronePessoal;
import dados.Estado;
import dados.Transporte;
import dados.TransporteCargaInanimada;
import dados.TransporteCargaViva;
import dados.TransportePessoal;
import formatos.ObjetoJSON;
import handlers.DroneHandler;
import handlers.TransporteHandler;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Classe de utilidades que permite a leitura e
 * escrita de arquivos estruturados em formato JSON.
 *
 * @author Lucas da Paz
 */
public class ArquivoJSON extends ArquivoIO {
	private final DroneHandler droneHandler;
	private final TransporteHandler transporteHandler;
	private final String nomeArquivo;

	/**
	 * Inicializa um objeto {@link ArquivoJSON}.
	 *
	 * @param nomeArquivo O nome do arquivo que será utilizado
	 *                    por este objeto.
	 */
	public ArquivoJSON(String nomeArquivo) {
		droneHandler = DroneHandler.getHandler();
		transporteHandler = TransporteHandler.getHandler();
		this.nomeArquivo = "%s.json".formatted(nomeArquivo);
	}

	/**
	 * Abre o arquivo de saída com o nome indicado e escreve, em
	 * formato JSON, todas as instâncias de {@link Drone} e
	 * {@link Transporte} salvas em memória durante a execução.
	 *
	 * @throws RuntimeException Se algo de errado ocorrer com o arquivo.
	 */
	public void realizaEscrita() {
		abreArquivoSaida(nomeArquivo);

		StringBuilder json = new StringBuilder("{\n");
		json.append("\t\"drones\": [\n");
		json.append(toJson(droneHandler.buscaTodos()));
		json.append("\t],\n");

		json.append("\t\"transportes\": [\n");
		json.append(toJson(transporteHandler.buscaTodos()));
		json.append("\t]\n}");

		escreve(json.toString());
		fechaArquivoSaida();
	}

	/**
	 * Lê o conteúdo do arquivo de entrada com o nome indicado e tenta criar
	 * as instâncias de {@link Drone} e {@link Transporte} salvas em formato
	 * JSON no arquivo e salvá-las em memória. Se ocorrerem erros durante a
	 * leitura, a mesma é interrompida. Se quaisquer dos objetos já foram
	 * cadastrados previamente, após o fim da execução é lançada uma exceção
	 * que detalha em quais objetos houve problemas.
	 *
	 * @throws RuntimeException Se algo de errado ocorrer com os arquivos ou
	 *                          durante a leitura.
	 */
	public void realizaLeitura() {
		Reader leitorArquivo = getReader(nomeArquivo);
		StringBuilder erros = new StringBuilder();
		try {
			ObjectMapper mapeadorJson = new ObjectMapper();

			JsonNode json = mapeadorJson.readTree(leitorArquivo);
			JsonNode drones = json.get("drones");
			JsonNode transportes = json.get("transportes");

			cadastraDrones(drones, erros);
			cadastraTransportes(transportes, erros);

			leitorArquivo.close();
		} catch (IOException e) {
			e.printStackTrace(System.err);
			throw new RuntimeException("Erro ao tentar ler o arquivo %s".formatted(nomeArquivo));
		} catch (NullPointerException e) {
			e.printStackTrace(System.err);
			throw new RuntimeException("Os campos do arquivo não correspondem ao formato esperado!");
		} catch (Exception e) {
			e.printStackTrace(System.err);
			throw new RuntimeException("Erro inesperado ao tentar realizar a importação dos dados!");
		}
		if (!erros.isEmpty()) {
			throw new RuntimeException(erros.toString());
		}
	}

	/**
	 * Lê o nodo JSON contendo os drones e tenta instânciar um {@link Drone}
	 * para cada objeto. Se ocorrer algum erro, interrompe a leitura; em caso
	 * de sucesso, tenta adicionar o drone instânciado ao sistema e, se não
	 * conseguir, atualiza os erros passados como argumento.
	 *
	 * @param erros String de erros; é atualizada se o objeto instânciado não
	 *              for adicionado ao sistema.
	 * @throws RuntimeException     Se o tipo de drone for inválido.
	 * @throws NullPointerException Se algum dos campos necessários não estiver
	 *                              presente no arquivo.
	 */
	private void cadastraDrones(JsonNode objetos, StringBuilder erros) {
		for (JsonNode campos : objetos) {
			int tipo = campos.get("tipo").asInt();
			int codigo = campos.get("codigo").asInt();
			double custoFixo = campos.get("custoFixo").asDouble();
			double autonomia = campos.get("autonomia").asDouble();

			Drone d = switch (tipo) {
				case 1 -> {
					int qtdMaxPessoas = campos.get("qtdMaxPessoas").asInt();
					yield new DronePessoal(codigo, custoFixo, autonomia, qtdMaxPessoas);
				}
				case 2 -> {
					double pesoMaximo = campos.get("pesoMaximo").asDouble();
					boolean protecao = campos.get("protecao").asBoolean();
					yield new DroneCargaInanimada(codigo, custoFixo, autonomia, pesoMaximo, protecao);
				}
				case 3 -> {
					double pesoMaximo = campos.get("pesoMaximo").asDouble();
					boolean climatizado = campos.get("climatizado").asBoolean();
					yield new DroneCargaViva(codigo, custoFixo, autonomia, pesoMaximo, climatizado);
				}
				default -> null;
			};

			if (d == null) {
				throw new RuntimeException("Tipo de drone inválido inserido: %d".formatted(tipo));
			}

			boolean cadastrado = droneHandler.cadastra(d);
			if (!cadastrado) {
				erros.append("- Já existe um drone com o código %d!\n".formatted(d.getCodigo()));
			}
		}
	}

	/**
	 * Lê o nodo JSON contendo os transportes e tenta instânciar um
	 * {@link Transporte} para cada objeto. Se ocorrer algum erro, interrompe
	 * a leitura; em caso de sucesso, tenta adicionar o transporte instânciado
	 * ao sistema e, se não conseguir, atualiza os erros passados como argumento.
	 *
	 * @param erros String de erros; é atualizada se o objeto instânciado não
	 *              for adicionado ao sistema.
	 * @throws RuntimeException         Se o tipo de transporte for inválido.
	 * @throws NullPointerException     Se algum dos campos necessários não estiver
	 *                                  presente no arquivo.
	 * @throws IllegalArgumentException Se a situação do transporte for inválida.
	 */
	private void cadastraTransportes(JsonNode objetos, StringBuilder erros) {
		for (JsonNode campos : objetos) {
			int tipo = campos.get("tipo").asInt();
			int numero = campos.get("numero").asInt();
			String nomeCliente = campos.get("nomeCliente").asText();
			String descricao = campos.get("peso").asText();
			double peso = campos.get("peso").asDouble();
			double latitudeOrigem = campos.get("latitudeOrigem").asDouble();
			double longitudeOrigem = campos.get("longitudeOrigem").asDouble();
			double latitudeDestino = campos.get("latitudeDestino").asDouble();
			double longitudeDestino = campos.get("longitudeDestino").asDouble();
			Estado situacao = Estado.valueOf(campos.get("situacao").asText());
			int codigoDrone = campos.get("codigoDrone").asInt();
			Drone drone = droneHandler.buscaPorCodigo(codigoDrone);

			Transporte t = switch (tipo) {
				case 1 -> {
					int qtdPessoas = campos.get("qtdPessoas").asInt();
					yield new TransportePessoal(numero,
						nomeCliente,
						descricao,
						peso,
						latitudeOrigem,
						longitudeOrigem,
						latitudeDestino,
						longitudeDestino,
						qtdPessoas
					);
				}
				case 2 -> {
					boolean cargaPerigosa = campos.get("cargaPerigosa").asBoolean();
					yield new TransporteCargaInanimada(numero,
						nomeCliente,
						descricao,
						peso,
						latitudeOrigem,
						longitudeOrigem,
						latitudeDestino,
						longitudeDestino,
						cargaPerigosa
					);
				}
				case 3 -> {
					double temperaturaMin = campos.get("temperaturaMinima").asDouble();
					double temperaturaMax = campos.get("temperaturaMaxima").asDouble();
					yield new TransporteCargaViva(numero,
						nomeCliente,
						descricao,
						peso,
						latitudeOrigem,
						longitudeOrigem,
						latitudeDestino,
						longitudeDestino,
						temperaturaMin,
						temperaturaMax
					);
				}
				default -> null;
			};

			if (t == null) {
				throw new RuntimeException("Tipo de transporte inválido inserido: %d".formatted(tipo));
			}
			t.carrega(situacao, drone);

			boolean cadastrado = transporteHandler.cadastra(t);
			if (!cadastrado) {
				erros.append("- Já existe um transporte com o número %d!\n".formatted(t.getNumero()));
			}
		}
	}

	/**
	 * Converte uma lista de {@link ObjetoJSON} para o
	 * formato JSON.
	 *
	 * @param lista A lista de objetos.
	 * @return Representação da lista em formato JSON.
	 */
	private String toJson(List<? extends ObjetoJSON> lista) {
		StringBuilder json = new StringBuilder();
		int tamanho = lista.size();
		for (int i = 0; i < tamanho; i++) {
			json.append(lista.get(i).toJSON());
			if (i < tamanho - 1) {
				json.append(",");
			}
			json.append("\n");
		}
		return json.toString();
	}
}
