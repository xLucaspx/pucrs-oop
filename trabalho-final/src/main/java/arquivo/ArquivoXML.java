package arquivo;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import handlers.DroneHandler;
import handlers.TransporteHandler;

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
	 * {@inheritDoc} Utiliza o formato XML.
	 *
	 * @throws RuntimeException Se algo de errado ocorrer com o arquivo.
	 */
	@Override
	public void realizaEscrita() {
		abreArquivoSaida(getNomeArquivo());

		StringBuilder xml = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		xml.append("<dados>\n\t<drones>\n");
		DroneHandler.getHandler().buscaTodos().forEach(d -> xml.append(d.toXML()).append('\n'));
		xml.append("\t</drones>\n\t<transportes>\n");
		TransporteHandler.getHandler().buscaTodos().forEach(t -> xml.append(t.toXML()).append('\n'));
		xml.append("\t</transportes>\n</dados>");

		escreve(xml.toString());
		fechaArquivoSaida();
	}

	/**
	 * {@inheritDoc} Utiliza o formato XML.
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
		realizaLeitura(new XmlMapper());
	}
}
