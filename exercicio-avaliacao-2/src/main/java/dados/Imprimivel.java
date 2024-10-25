package dados;

/**
 * Encapsula o comportamento de objetos imprimíveis,
 * i.e., que permitem gerar texto e calcular custo a
 * partir de suas informações.
 *
 * @author Lucas da Paz
 */
public interface Imprimivel {

	/**
	 * @return String gerada a partir das informações do
	 * objeto, utilizando {@code -} como separador de campos.
	 */
	String geraTexto();

	/**
	 * @return Custo calculado em Reais do objeto.
	 */
	double calculaCusto();
}
