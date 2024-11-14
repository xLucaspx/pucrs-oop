package validacoes;

import dados.Drone;
import dados.Transporte;

public class ValidadorAutonomia implements ValidadorDroneTransporte {
	/**
	 * {@inheritDoc} Retorna verdadeiro se a autonomia
	 * do drone é maior ou igual à distância do transporte.
	 *
	 * @param d {@inheritDoc}
	 * @param t {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@Override
	public boolean valida(Drone d, Transporte t) {
		return d.getAutonomia() >= t.getDistancia();
	}
}
