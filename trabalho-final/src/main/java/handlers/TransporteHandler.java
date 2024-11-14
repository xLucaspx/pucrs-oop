package handlers;

import dados.Drone;
import dados.Estado;
import dados.Transporte;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Classe que gerencia os {@link Transporte transportes}
 * cadastrados no sistema.
 *
 * @author Lucas da Paz Oliveira
 */
public class TransporteHandler {
	private final Set<Transporte> transportes;
	private final Queue<Transporte> pendentes;

	/**
	 * Inicializa um objeto {@link TransporteHandler}.
	 */
	public TransporteHandler() {
		transportes = new HashSet<>();
		pendentes = new LinkedList<>();
	}

	/**
	 * Cadastra um {@link Transporte} no sistema, caso
	 * ainda não tenha sido cadastrado.
	 *
	 * @param t O transporte que será cadastrado.
	 * @return {@code true} se o cadastro foi realizado
	 * com sucesso, {@code false} caso contrário.
	 */
	public boolean cadastra(Transporte t) {
		if (t == null) {
			return false;
		}

		boolean adicionado = transportes.add(t);
		if (adicionado && t.getSituacao().equals(Estado.PENDENTE)) {
			pendentes.add(t);
		}
		return adicionado;
	}

	/**
	 * @return Lista imutável contendo todos os
	 * {@link Transporte transportes} cadastrados no sistema.
	 */
	public List<Transporte> buscaTodos() {
		return List.copyOf(transportes);
	}

	/**
	 * Realiza, para cada {@link Transporte} com situação
	 * {@link Estado#PENDENTE PENDENTE}, a tentativa de alocar
	 * um {@link Drone} contido na lista passada como argumento.
	 *
	 * @param drones Lista de drones disponíveis para serem alocados.
	 * @return {@code true} caso o processamento tenha sido realizado
	 * com sucesso, {@code false} caso contrário (e.g. não existem
	 * transportes pendentes).
	 */
	public boolean processaPendentes(List<Drone> drones) {
		if (pendentes.isEmpty()) {
			return false;
		}

		int totalPendentes = pendentes.size();
		for (int i = 0; i < totalPendentes; i++) {
			Transporte t = pendentes.remove();
			boolean alocado = false;

			for (Drone d : drones) {
				if (d.adicionaTransporte(t)) {
					alocado = true;
					break;
				}
			}

			if (!alocado) {
				pendentes.add(t);
			}
		}
		return true;
	}
}
