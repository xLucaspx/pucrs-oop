package dados;

/**
 * Representa a situação atual de um {@link Transporte}; quando
 * um transporte é criado deve ser definido como {@link #PENDENTE},
 * quando um {@link Drone} é locado para o transporte o mesmo torna-se
 * {@link #ALOCADO} e quando o transporte é finalizado a situação é
 * definida para {@link #TERMINADO}. A qualquer momento um transporte
 * pode ser {@link #CANCELADO}.
 *
 * @author Lucas da Paz
 */
public enum Estado {
	PENDENTE, ALOCADO, TERMINADO, CANCELADO;
}
