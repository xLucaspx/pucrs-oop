package arquivo;

import com.fasterxml.jackson.databind.ObjectMapper;
import dados.Drone;
import dados.Transporte;
import formatos.ObjetoJSON;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Classe de utilidades que permite a leitura e
 * escrita de arquivos estruturados em formato JSON.
 *
 * @author Lucas da Paz
 */
public class ArquivoJSON extends ArquivoEstruturado {
	/**
	 * Inicializa um objeto {@link ArquivoJSON}.
	 *
	 * @param nomeArquivo O nome do arquivo que será utilizado
	 *                    por este objeto.
	 */
	public ArquivoJSON(String nomeArquivo) {
		super("%s.json".formatted(nomeArquivo));
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
	 * as instâncias de {@link Drone} e {@link Transporte} declaradas em formato
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
		ObjectMapper mapeadorJson = new ObjectMapper();
		realizaLeitura(mapeadorJson, leitorArquivo, erros);

		try {
			leitorArquivo.close();
		} catch (IOException e) {
			e.printStackTrace(System.err);
			erros.append("Erro ao tentar fechar o arquivo \"%s\"!".formatted(nomeArquivo));
		}

		if (!erros.isEmpty()) {
			throw new RuntimeException(erros.toString());
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
