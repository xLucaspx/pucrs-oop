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
 * cadastrados no sistema. Utiliza o padrão Singleton.
 *
 * @author Lucas da Paz
 */
public class TransporteHandler {
	private static TransporteHandler handler;

	private final Set<Transporte> transportes;
	private final Queue<Transporte> pendentes;

	/**
	 * Inicializa um objeto {@link TransporteHandler}.
	 */
	private TransporteHandler() {
		transportes = new HashSet<>();
		pendentes = new LinkedList<>();
	}

	/**
	 * @return A instância de {@link TransporteHandler}
	 * utilizada pelo sistema.
	 */
	public static TransporteHandler getHandler() {
		if (handler == null) {
			handler = new TransporteHandler();
		}
		return handler;
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
	 * Busca um {@link Transporte} utilizando o número
	 * passado como argumento.
	 *
	 * @param numero O número do transporte buscado.
	 * @return A instância de transporte correspondente, ou
	 * {@code null} se não for encontrada correspondência.
	 */
	public Transporte buscaPorNumero(int numero) {
		return transportes.stream().filter(t -> t.getNumero() == numero).findFirst().orElse(null);
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

	/**
	 * @return O total de {@link Transporte transportes} com a
	 * situação {@link Estado#PENDENTE PENDENTE}.
	 */
	public int getTotalPendentes() {
		return pendentes.size();
	}

	/**
	 * Tenta alterar a situação do {@link Transporte} passado como
	 * argumento para o {@link Estado} informado; em caso de sucesso,
	 * verifica se o transporte estava na fila de transportes pendentes
	 * e, se afirmativo, remove-o da fila.
	 *
	 * @param t O transporte que terá a situação alterada.
	 * @param e A nova situação.
	 * @return {@code true} em caso de sucesso, {@code false} caso contrário.
	 */
	public boolean definirNovaSituacao(Transporte t, Estado e) {
		boolean pendente = t.getSituacao().equals(Estado.PENDENTE);
		boolean alterado = switch (e) {
			case TERMINADO -> t.terminar();
			case CANCELADO -> t.cancelar();
			default -> false;
		};

		if (pendente && alterado) {
			int totalPendentes = pendentes.size();
			for (int i = 0; i < totalPendentes; i++) {
				Transporte tp = pendentes.remove();
				if (tp.equals(t)) {
					continue;
				}
				pendentes.add(tp);
			}
		}

		return alterado;
	}
}
