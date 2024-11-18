package views;

import dados.Drone;
import dados.Transporte;
import handlers.DroneHandler;
import handlers.TransporteHandler;

import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.util.List;

import static views.Constantes.FORMATO_DATA;

/**
 * Classe utilizada para gerar um relatório
 * geral sobre o sistema.
 *
 * @author Lucas da Paz
 */
public class RelatorioGeral extends Relatorio {
	private final DroneHandler droneHandler;
	private final TransporteHandler transporteHandler;

	/**
	 * Inicializa um novo frame {@link RelatorioGeral}.
	 */
	public RelatorioGeral() {
		super("Relatório Geral");
		droneHandler = DroneHandler.getHandler();
		transporteHandler = TransporteHandler.getHandler();
	}

	@Override
	protected String geraRelatorio() {
		List<Drone> drones = droneHandler.buscaTodos();
		List<Transporte> transportes = transporteHandler.buscaTodos();

		if (drones.isEmpty() && transportes.isEmpty()) {
			String mensagem = "Não há dados cadastrados!";
			JOptionPane.showMessageDialog(this, mensagem, getTitle(), JOptionPane.INFORMATION_MESSAGE);
			return mensagem;
		}

		StringBuilder relatorio = new StringBuilder();
		String separador = "%75s".formatted(" ").replace(" ", "-");

		relatorio.append(separador).append("\n- Drones -\n\n");
		relatorio.append("Total cadastrado: %d\n\n".formatted(drones.size()));
		droneHandler.buscaTodos().forEach(d -> relatorio.append(d).append("\n\n"));

		relatorio.append(separador).append("\n- Transportes -\n\n");
		relatorio.append("Total cadastrado: %d\n".formatted(transportes.size()));
		relatorio.append("Pendentes: %d\n\n".formatted(transporteHandler.getTotalPendentes()));
		transporteHandler.buscaTodos().forEach(t -> relatorio.append(t).append("\n\n"));

		relatorio.append(separador).append("\n");
		relatorio.append("Relatório emitido em %s".formatted(LocalDateTime.now().format(FORMATO_DATA)));
		return relatorio.toString();
	}
}
