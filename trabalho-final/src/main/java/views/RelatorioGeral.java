package views;

import dados.Drone;
import dados.Transporte;
import handlers.DroneHandler;
import handlers.TransporteHandler;

import javax.swing.JOptionPane;
import java.util.List;

public class RelatorioGeral extends Relatorio {
	private final DroneHandler droneHandler;
	private final TransporteHandler transporteHandler;

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
		return relatorio.toString();
	}
}
