package views;

import dados.Estado;
import dados.Transporte;
import handlers.TransporteHandler;

import javax.swing.JOptionPane;
import java.util.List;

public class RelatorioTransportes extends Relatorio {
	private final TransporteHandler transporteHandler;

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
		transportes.forEach(t -> {
			relatorio.append(t);
			if (t.getSituacao() != Estado.PENDENTE) {
				relatorio.append("\n> Transportador -> ").append(t.getDrone());
			}
			relatorio.append("\n\n");
		});

		relatorio.append(separador).append("\n");
		return relatorio.toString();
	}
}
