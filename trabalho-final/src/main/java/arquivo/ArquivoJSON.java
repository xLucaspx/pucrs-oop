package arquivo;

import dados.Drone;
import dados.Transporte;
import handlers.DroneHandler;
import handlers.TransporteHandler;
import java.util.ArrayList;
import formatos.ObjetoJSON;

import java.util.List;
import java.util.Map;

public class ArquivoJSON extends ArquivoIO {
	private final DroneHandler droneHandler;
	private final TransporteHandler transporteHandler;
	private final String nomeArquivo;

	public ArquivoJSON(String nomeArquivo) {
		droneHandler = DroneHandler.getHandler();
		transporteHandler = TransporteHandler.getHandler();
		this.nomeArquivo = "%s.json".formatted(nomeArquivo);
	}

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

	private String toJson(List<? extends ObjetoJSON> lista) {
		StringBuilder json = new StringBuilder();
		int tamanho = lista.size();
		for (int i = 0; i < tamanho; i++) {
			json.append("\t\t{\n").append(lista.get(i).toJSON()).append("\n\t\t}");
			if (i < tamanho - 1) {
				json.append(",");
			}
			json.append("\n");
		}
		return json.toString();
	}
	
	public void realizaLeitura() {
		abreArquivoEntrada(nomeArquivo);
		
		fechaArquivoEntrada();
	}
}
