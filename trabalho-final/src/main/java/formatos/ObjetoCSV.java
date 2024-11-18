package formatos;

/**
 * Interface para objetos que podem ser representados
 * no formato CSV.
 *
 * @author Lucas da Paz
 */
public interface ObjetoCSV {
	/**
	 * @return Representação do objeto em formato CSV.
	 */
	String toCSV();
}
