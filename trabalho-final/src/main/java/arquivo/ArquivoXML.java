package arquivo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import dados.Drone;
import dados.Transporte;

import java.io.IOException;
import java.io.Reader;

/**
 * Classe de utilidades que permite a leitura e
 * escrita de arquivos estruturados em formato XML.
 *
 * @author Lucas da Paz
 */
public class ArquivoXML extends ArquivoEstruturado {
	/**
	 * Inicializa um objeto {@link ArquivoXML}.
	 *
	 * @param nomeArquivo O nome do arquivo que será utilizado
	 *                    por este objeto.
	 */
	public ArquivoXML(String nomeArquivo) {
		super("%s.xml".formatted(nomeArquivo));
	}

	/**
	 * Abre o arquivo de saída com o nome indicado e escreve, em
	 * formato XML, todas as instâncias de {@link Drone} e
	 * {@link Transporte} salvas em memória durante a execução.
	 *
	 * @throws RuntimeException Se algo de errado ocorrer com o arquivo.
	 */
	public void realizaEscrita() {
		abreArquivoSaida(nomeArquivo);

		StringBuilder xml = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		xml.append("<dados>\n\t<drones>\n");
		droneHandler.buscaTodos().forEach(d -> xml.append(d.toXML()).append('\n'));
		xml.append("\t</drones>\n\t<transportes>\n");
		transporteHandler.buscaTodos().forEach(t -> xml.append(t.toXML()).append('\n'));
		xml.append("\t</transportes>\n</dados>");

		escreve(xml.toString());
		fechaArquivoSaida();
	}

	/**
	 * Lê o conteúdo do arquivo de entrada com o nome indicado e tenta criar
	 * as instâncias de {@link Drone} e {@link Transporte} declaradas em formato
	 * XML no arquivo e salvá-las em memória. Se ocorrerem erros durante a
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
		ObjectMapper mapeadorXml = new XmlMapper();
		realizaLeitura(mapeadorXml, leitorArquivo, erros);

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
}
