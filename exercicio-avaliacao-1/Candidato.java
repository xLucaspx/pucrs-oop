import java.util.Objects;

/**
 * Classe abstrata que representa um candidato na eleicao.
 */
public abstract class Candidato {
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

	/**
	 * Inicializa um objeto do tipo <code>Candidato</code>. Define-o como <code>Prefeito</code>
	 * ou <code>Vereador</code> com base no numero, i.e.: numeros entre 10 e 99, inclusos, sao
	 * considerados para candidatos a prefeito e numeros entre 10000 e 99999, inclusos, sao
	 * considerados para candidatos a vereador.
	 *
	 * @param numero    O numero do candidato (2 digitos para prefeito, 5 para vereador).
	 * @param nome      O nome do candidato.
	 * @param municipio O municipio da candidatura.
	 * @param partido   O partido no qual o candidato esta filiado.
	 * @return O objeto <code>Candidato</code> instanciado, ou <code>null</code> caso o numero
	 * informado nao atenda aos criterios.
	 */
	public static Candidato criaCandidato(int numero, String nome, String municipio, Partido partido) {
		Candidato c = null;

		if (numero >= 10 && numero <= 100) { // 2 digitos -> prefeito
			c = new Prefeito();
		}

		if (numero >= 10000 && numero <= 100000) { // 5 digitos -> vereador
			c = new Vereador();
		}

		if (c == null) {
			return null;
		}

		c.numero = numero;
		c.nome = nome;
		c.municipio = municipio;
		c.partido = partido;
		return c;
	}

	/**
	 * @return O numero do candidato.
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @return O nome do candidato.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return O municipio no qual esta registrada a candidatura.
	 */
	public String getMunicipio() {
		return municipio;
	}

	/**
	 * @return O numero de votos do candidato.
	 */
	public int getVotos() {
		return votos;
	}

	/**
	 * Acrescenta o numero de votos passado como argumento ao total de votos do candidato.
	 * Se o valor informado for negativo ou nulo, o metodo nao sera exeutado.
	 *
	 * @param votos A quantidade de votos a ser adicionada para o candidato; deve ser maior
	 *              do que zero.
	 */
	public void adicionaVotos(int votos) {
		if (votos <= 0) {
			return;
		}

		this.votos += votos;
	}

	/**
	 * Calcula um inteiro que representa a instancia atual da classe de acordo com a definicao
	 * de igualdade (<code>equals</code>).
	 *
	 * @return Um inteiro representando a instancia atual da classe.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(numero, municipio);
	}

	/**
	 * Compara uma instancia de <code>Candidato</code> com o objeto passado como argumento.
	 *
	 * @param o O objeto a ser comparado com a instancia de <code>Candidato</code> na qual o metodo foi chamado.
	 * @return <code>true</code> caso o objeto passado como argumento seja uma instancia de <code>Candidato</code>
	 * e o numero e municipio de ambos os objetos comparados seja igual, <code>false</code> caso contrario.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (!(o instanceof Candidato c)) {
			return false;
		}

		return numero == c.numero && municipio.equals(c.municipio);
	}
}
