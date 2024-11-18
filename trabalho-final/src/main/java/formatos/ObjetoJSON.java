package formatos;

/**
 * Interface para objetos que podem ser representados
 * no formato JSON.
 *
 * @author Lucas da Paz
 */
public interface ObjetoJSON {
	/**
	 * @return Representação do objeto em formato JSON.
	 */
	String toJSON();
}
