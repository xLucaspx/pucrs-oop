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
}
