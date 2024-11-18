package dados;

import validacoes.ValidadorDroneTransporte;
import validacoes.ValidadorPesoMaximo;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa {@link Drone drones} utilizados para a
 * realização de {@link Transporte transportes} de carga (e.g.
 * {@link TransporteCargaInanimada} e {@link TransporteCargaViva}).
 *
 * @author Lucas da Paz
 */
public abstract class DroneCarga extends Drone {
	private double pesoMaximo;

	/**
	 * Inicializa um objeto {@link DroneCarga}.
	 *
	 * @param codigo     O código do drone.
	 * @param custoFixo  O custo fixo (por KM) do drone.
	 * @param autonomia  A autonomia de voo (em KM) do drone.
	 * @param pesoMaximo O peso máximo (em KG) que o drone pode transportar.
	 */
	public DroneCarga(int codigo, double custoFixo, double autonomia, double pesoMaximo) {
		super(codigo, custoFixo, autonomia);
		this.pesoMaximo = pesoMaximo;
	}

	/**
	 * @return A quantidade máxima de peso, em KG,
	 * que este {@link DroneCarga} pode transportar.
	 */
	public double getPesoMaximo() {
		return pesoMaximo;
	}

	@Override
	public boolean adicionaTransporte(Transporte t) {
		List<ValidadorDroneTransporte> validacoes = new ArrayList<>(List.of(new ValidadorPesoMaximo()));
		for (var v : validacoes) {
			if (!v.valida(this, t)) {
				return false;
			}
		}
		return super.adicionaTransporte(t);
	}

	@Override
	public String toString() {
		return "%s\n\t* Peso máximo: %.1f Kg".formatted(super.toString(), pesoMaximo);
	}

	@Override
	public String toCSV() {
		return "%s;%f".formatted(super.toCSV(), pesoMaximo);
	}

	@Override
	public String toJSON() {
		return """
			%s,
			\t\t\t"pesoMaximo": %f""".formatted(super.toJSON(), pesoMaximo);
	}

	@Override
	public String toXML() {
		return "%s\n\t\t\t<pesoMaximo>%f</pesoMaximo>".formatted(super.toXML(), pesoMaximo);
	}
}
