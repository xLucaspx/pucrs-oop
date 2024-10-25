package dados;

/**
 * Representa os seriados cadastrados no sistema.
 *
 * @author Lucas da Paz
 */
public class Seriado extends Video {
	private int anoInicio;
	private int anoFim;
	private int numEpisodios;

	/**
	 * Constrói um objeto do tipo {@link Seriado}.
	 *
	 * @param codigo       O código do seriado.
	 * @param titulo       O título do seriado
	 * @param anoInicio    O ano de estréia do seriado.
	 * @param anoFim       O ano do fim do seriado.
	 * @param numEpisodios O número de episódios do seriado.
	 */
	public Seriado(int codigo, String titulo, int anoInicio, int anoFim, int numEpisodios) {
		super(codigo, titulo);
		this.anoInicio = anoInicio;
		this.anoFim = anoFim;
		this.numEpisodios = numEpisodios;
	}

	/**
	 * Calcula o período de exibição do {@link Seriado} em anos com a
	 * fórmula {@code anoFim - anoInicio + 1}.
	 *
	 * @return O período de exibição calculado, em anos.
	 */
	public int getPeriodoExibicao() {
		return anoFim - anoInicio + 1;
	}

	@Override
	public String geraTexto() {
		return "%d-%s-%d-%d-%d-%.2f".formatted(getCodigo(), getTitulo(), anoInicio, anoFim, numEpisodios, calculaCusto());
	}

	/**
	 * Calcula o custo do seriado em R$ 0,50 por episódio.
	 *
	 * @return {@inheritDoc}
	 */
	@Override
	public double calculaCusto() {
		return numEpisodios * 0.5;
	}
}
