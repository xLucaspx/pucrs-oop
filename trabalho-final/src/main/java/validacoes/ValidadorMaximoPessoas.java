package validacoes;

import dados.Drone;
import dados.DronePessoal;
import dados.Transporte;
import dados.TransportePessoal;

/**
 * Classe que implementa a validação do máximo de pessoas
 * de um {@link TransportePessoal} com relação à quantidade
 * máxima de pessoas de um {@link TransportePessoal}.
 *
 * @author Lucas da Paz
 */
public class ValidadorMaximoPessoas implements ValidadorDroneTransporte {
	/**
	 * {@inheritDoc} Valida se o drone informado é um
	 * {@link DronePessoal} e se o transporte é um
	 * {@link TransportePessoal}; neste caso, retorna verdadeiro
	 * se a quantidade máximas de pessoas que o drone pode transportar
	 * for maior ou igual à quantidade de pessoas do transporte.
	 *
	 * @param d {@inheritDoc}
	 * @param t {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@Override
	public boolean valida(Drone d, Transporte t) {
		if (!(d instanceof DronePessoal dp && t instanceof TransportePessoal tp)) {
			return false;
		}

		return dp.getQtdMaxPessoas() >= tp.getQtdPessoas();
	}
}
