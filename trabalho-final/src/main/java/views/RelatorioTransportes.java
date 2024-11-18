package views;

import dados.Transporte;
import handlers.TransporteHandler;

import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.util.List;

import static views.Constantes.FORMATO_DATA;

/**
 * Classe utilizada para gerar um relatório sobre os
 * {@link Transporte transportes} cadastrados no sistema.
 *
 * @author Lucas da Paz
 */
public class RelatorioTransportes extends Relatorio {
	private final TransporteHandler transporteHandler;

	/**
	 * Inicializa um novo frame {@link RelatorioTransportes}.
	 */
	public RelatorioTransportes() {
		super("Relatório de Transportes");
		transporteHandler = TransporteHandler.getHandler();
	}

	@Override
	protected String geraRelatorio() {
		List<Transporte> transportes = transporteHandler.buscaTodos();

		if (transportes.isEmpty()) {
			String mensagem = "Não há transportes cadastrados!";
			JOptionPane.showMessageDialog(this, mensagem, getTitle(), JOptionPane.INFORMATION_MESSAGE);
			return mensagem;
		}

		StringBuilder relatorio = new StringBuilder();
		String separador = "%75s".formatted(" ").replace(" ", "-");

		relatorio.append(separador).append("\n- Transportes -\n\n");
		relatorio.append("Total cadastrado: %d\n".formatted(transportes.size()));
		relatorio.append("Pendentes: %d\n\n".formatted(transporteHandler.getTotalPendentes()));
		transportes.forEach(t -> {
			relatorio.append(t);
			if (t.getDrone() != null) {
				relatorio.append("\n> Transportador -> ").append(t.getDrone());
			}
			relatorio.append("\n\n");
		});

		relatorio.append(separador).append("\n");
		relatorio.append("Relatório emitido em %s".formatted(LocalDateTime.now().format(FORMATO_DATA)));
		return relatorio.toString();
	}
}
