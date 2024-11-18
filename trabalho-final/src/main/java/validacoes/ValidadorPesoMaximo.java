package validacoes;

import dados.Drone;
import dados.DroneCarga;
import dados.Transporte;

/**
 * Classe que implementa a validação do peso de um
 * {@link Transporte} com relação ao peso máximo de
 * um {@link DroneCarga}.
 *
 * @author Lucas da Paz
 */
public class ValidadorPesoMaximo implements ValidadorDroneTransporte {
	/**
	 * {@inheritDoc} Valida se o drone informado é um
	 * {@link DroneCarga}; neste caso, retorna verdadeiro se
	 * o peso máximo que o drone pode transportar for maior ou
	 * igual ao peso do transporte.
	 *
	 * @param d {@inheritDoc}
	 * @param t {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@Override
	public boolean valida(Drone d, Transporte t) {
		if (!(d instanceof DroneCarga dc)) {
			return false;
		}

		return dc.getPesoMaximo() >= t.getPeso();
	}
}
