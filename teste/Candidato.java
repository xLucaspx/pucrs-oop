/**
 * Classe que representa um candidato na eleicao.
 */
public class Candidato {

	/**
	 * <p>Numero do candidato: se tiver apenas 2 digitos sera para prefeito,
	 * se tiver 5 digitos sera para vereador.</p>
	 * <p><strong>Os dois primeiros digitos indicam o partido do candidato</strong>.</p>
	 */
	private int numero;

	private String nome;

	private String municipio;

	private int votos;

	private Partido partido;

	private Candidato candidato;

	private Candidato candidato;

	/**
	 * Inicializa um objeto do tipo <code>Candidato</code>.
	 *  
	 * @param numero O numero do candidato.
	 * @param nome O nome do candidato.
	 * @param municipio O municipio da candidatura.
	 * @param partido O partido no qual o candidato esta filiado.
	 */
	public Candidato(int numero, String nome, String municipio, Partido partido) {

	}

	/**
	 * @return O numero do candidato.
	 */
	public int getNumero() {
		return 0;
	}

	/**
	 * @return O nome do candidato.
	 */
	public String getNome() {
		return null;
	}

	/**
	 * @return O municipio no qual esta registrada a candidatura.
	 */
	public String getMunicipio() {
		return null;
	}

	/**
	 * @return O numero de votos do candidato.
	 */
	public int getVotos() {
		return 0;
	}

	/**
	 * Acrescenta o numero de votos passado como argumento ao total de votos do candidato.
	 * Se o valor informado for negativo ou nulo, o metodo nao sera exeutado.
	 * 
	 * @param votos A quantidade de votos a ser adicionada para o candidato; deve ser maior do que zero.
	 */
	public void adicionaVotos(int votos) {

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

	@Override
	public boolean equals(Object o) {
		return false;
	}

}
