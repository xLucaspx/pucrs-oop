package validacoes;

import dados.Drone;
import dados.Transporte;

/**
 * Classe que implementa a validação de autonomia
 * de um {@link Double} com relação à distância de
 * um {@link Transporte}.
 *
 * @author Lucas da Paz
 */
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
