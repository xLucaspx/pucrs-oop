package dados;

import validacoes.ValidadorCargaPerigosa;
import validacoes.ValidadorDroneTransporte;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa {@link Drone drones} utilizados para a
 * realização de {@link TransporteCargaInanimada}.
 *
 * @author Lucas da Paz
 */
public class DroneCargaInanimada extends DroneCarga {
	private boolean protecao;

	/**
	 * Inicializa um objeto {@link DroneCargaInanimada}.
	 *
	 * @param codigo     O código do drone.
	 * @param custoFixo  O custo fixo (por KM) do drone.
	 * @param autonomia  A autonomia de voo (em KM) do drone.
	 * @param pesoMaximo O peso máximo (em KG) que o drone pode transportar.
	 * @param protecao   Se o drone possui proteção.
	 */
	public DroneCargaInanimada(int codigo, double custoFixo, double autonomia, double pesoMaximo, boolean protecao) {
		super(codigo, custoFixo, autonomia, pesoMaximo);
		this.protecao = protecao;
	}

	/**
	 * @return {@code true} se este {@link Drone} possui proteção à
	 * carga, {@code false} caso contrário.
	 */
	public boolean isProtegida() {
		return protecao;
	}

	@Override
	public boolean adicionaTransporte(Transporte t) {
		List<ValidadorDroneTransporte> validacoes = new ArrayList<>(List.of(new ValidadorCargaPerigosa()));
		for (var v : validacoes) {
			if (!v.valida(this, t)) {
				return false;
			}
		}
		return super.adicionaTransporte(t);
	}

	@Override
	public String toString() {
		return """
			Drone de Carga Inanimada:
			%s
			\t* Proteção: %s;""".formatted(super.toString(), protecao ? "Sim" : "Não");
	}

	/**
	 * {@inheritDoc} Para uma instância de {@link DroneCargaInanimada},
	 * o custo variável depende da proteção, i.e., drones com proteção
	 * possuem um acréscimo maior do que drones sem proteção.
	 *
	 * @return {@inheritDoc}
	 */
	@Override
	public double calculaCustoKm() {
		return getCustoFixo() + (protecao ? 10 : 5);
	}
}
