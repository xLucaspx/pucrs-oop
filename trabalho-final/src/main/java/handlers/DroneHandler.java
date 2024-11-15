package handlers;

import dados.Drone;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Classe que gerencia os {@link Drone drones}
 * cadastrados no sistema. Utiliza o padrão Singleton.
 *
 * @author Lucas da Paz
 */
public class DroneHandler {
	private static DroneHandler handler;

	private final Set<Drone> drones;

	/**
	 * Inicializa um objeto {@link DroneHandler}.
	 */
	private DroneHandler() {
		drones = new TreeSet<>();
	}

	/**
	 * @return A instância de {@link DroneHandler}
	 * utilizada pelo sistema.
	 */
	public static DroneHandler getHandler() {
		if (handler == null) {
			handler = new DroneHandler();
		}
		return handler;
	}

	/**
	 * Cadastra um {@link Drone} no sistema, caso
	 * ainda não tenha sido cadastrado.
	 *
	 * @param d O drone que será cadastrado.
	 * @return {@code true} se o cadastro foi realizado
	 * com sucesso, {@code false} caso contrário.
	 */
	public boolean cadastra(Drone d) {
		if (d == null) {
			return false;
		}
		return drones.add(d);
	}

	/**
	 * @return Lista imutável contendo todos os
	 * {@link Drone drones} cadastrados no sistema.
	 */
	public List<Drone> buscaTodos() {
		return List.copyOf(drones);
	}
}
