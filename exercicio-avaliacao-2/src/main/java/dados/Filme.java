package dados;

/**
 * Representa os filmes cadastrados no sistema.
 *
 * @author Lucas da Paz
 */
public class Filme extends Video {
	private String diretor;
	private double duracao;

	/**
	 * Constrói um objeto do tipo {@link Filme}.
	 *
	 * @param codigo  O código do filme.
	 * @param titulo  O título do filme
	 * @param diretor O nome do diretor do filme.
	 * @param duracao A duração do filme, em minutos.
	 */
	public Filme(int codigo, String titulo, String diretor, double duracao) {
		super(codigo, titulo);
		this.diretor = diretor;
		this.duracao = duracao;
	}

	/**
	 * @return O nome do diretor deste {@link Filme}.
	 */
	public String getDiretor() {
		return diretor;
	}

	@Override
	public String geraTexto() {
		return "%d-%s-%s-%.2f-%.2f".formatted(getCodigo(), getTitulo(), diretor, duracao, calculaCusto());
	}

	/**
	 * Calcula o custo do filme em R$ 0,30 por minuto de duração.
	 *
	 * @return {@inheritDoc}
	 */
	@Override
	public double calculaCusto() {
		return duracao * 0.3;
	}
}
