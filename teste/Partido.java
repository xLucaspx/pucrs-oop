import java.util.List;

/**
 * Classe que representa um partido na eleicao.
 */
public class Partido {

	private int numero;

	private String nome;

	private Candidato[] candidato;

	/**
	 * Inicializa um objeto do tipo <code>Partido</code>.
	 * 
	 * @param numero O numero do partido
	 * @param nome   O nome do partido
	 */
	public Partido(int numero, String nome) {

	}

	/**
	 * @return O numero do partido.
	 */
	public int getNumero() {
		return 0;
	}

	/**
	 * @return O nome do partido.
	 */
	public String getNome() {
		return null;
	}

	/**
	 * @return Lista nao modificavel contendo os candidatos a prefeito do partido.
	 */
	public List getPrefeitos() {
		return null;
	}

	/**
	 * @return Lista nao modificavel contendo os candidatos a vereador do partido.
	 */
	public List getVereadores() {
		return null;
	}

	/**
	 * @return A quantidade de candidatos do partido.
	 */
	public int getTotalCandidatos() {
		return 0;
	}

	/**
	 * Adiciona um novo candidato ao partido. Classifica-o
	 * em <code>prefeito</code> ou <code>vereador</code> com
	 * base no seu atributo <code>numero</code>.
	 * 
	 * @param c O candidato que sera adicionado.
	 */
	public void adicionaCandidato(Candidato c) {

	}

	/**
	 * Calcula um inteiro que representa a instancia atual da classe de acordo com a definicao
	 * de igualdade (<code>equals</code>).
	 * 
	 * @return Um inteiro representando a instancia atual da classe.
	 */
	@Override
	public int hashCode() {
		return 0;
	}

	/**
	 * Compara uma instancia de <code>Partido</code> com o objeto passado como argumento.
	 * 
	 * @param o O objeto a ser comparado com a instancia de <code>Partido</code> na qual o metodo foi chamado.
	 * @return <code>true</code> caso o objeto passado como argumento seja uma instancia de <code>Partido</code>
	 * e o numero de ambos os objetos comparados seja igual, <code>false</code> caso contrario.
	 */
	@Override
	public boolean equals(Object o) {
		return false;
	}

}
