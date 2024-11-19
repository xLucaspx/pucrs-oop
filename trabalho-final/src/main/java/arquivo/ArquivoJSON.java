package arquivo;

import com.fasterxml.jackson.databind.ObjectMapper;
import formatos.ObjetoJSON;
import handlers.DroneHandler;
import handlers.TransporteHandler;

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
	 * {@inheritDoc} Utiliza o formato JSON.
	 *
	 * @throws RuntimeException Se algo de errado ocorrer com o arquivo.
	 */
	@Override
	public void realizaEscrita() {
		abreArquivoSaida(getNomeArquivo());

		StringBuilder json = new StringBuilder("{\n");
		json.append("\t\"drones\": [\n");
		json.append(toJson(DroneHandler.getHandler().buscaTodos()));
		json.append("\t],\n");

		json.append("\t\"transportes\": [\n");
		json.append(toJson(TransporteHandler.getHandler().buscaTodos()));
		json.append("\t]\n}");

		escreve(json.toString());
		fechaArquivoSaida();
	}

	/**
	 * {@inheritDoc} Utiliza o formato JSON.
	 * <p>
	 * Se ocorrerem erros durante a leitura, a mesma é interrompida.
	 * Se quaisquer dos objetos já foram cadastrados previamente,
	 * após o fim da execução é lançada uma exceção que detalha em quais
	 * objetos houve problemas.
	 *
	 * @throws RuntimeException Se algo de errado ocorrer com os arquivos ou
	 *                          durante a leitura.
	 */
	@Override
	public void realizaLeitura() {
		realizaLeitura(new ObjectMapper());
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
