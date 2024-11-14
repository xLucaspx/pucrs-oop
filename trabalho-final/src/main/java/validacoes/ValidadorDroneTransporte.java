package validacoes;

import dados.Drone;
import dados.Transporte;

/**
 * Interface utilizada para validar se um determinado
 * {@link Drone} pode realizar determinado {@link Transporte}.
 *
 * @author Lucas da Paz
 */
public interface ValidadorDroneTransporte {
	/**
	 * Verifica se o {@link Drone} passado como argumento
	 * pode realizar o {@link Transporte} informado.
	 *
	 * @param d O drone que deverá realizar o transporte.
	 * @param t O transporte a ser realizado.
	 * @return {@code true} se o drone pode realizar o transporte,
	 * {@code false} caso contrário.
	 */
	boolean valida(Drone d, Transporte t);
}
