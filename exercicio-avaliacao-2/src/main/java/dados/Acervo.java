package dados;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Classe-catálogo que armazena a coleção de vídeos.
 *
 * @author Lucas da Paz
 */
public class Acervo {
	private final Set<Video> videos;

	/**
	 * Inicializa um objeto do tipo {@link Acervo}.
	 */
	public Acervo() {
		this.videos = new HashSet<>();
	}

	/**
	 * Adiciona uma instância de {@link Video} à coleção; se o vídeo
	 * já houver sido cadastrado, ele não será adicionado novamente.
	 *
	 * @param v O vídeo a ser adicionado.
	 * @return {@code true} caso o video seja adicionado com sucesso,
	 * {@code false} caso contrário, i.e., se o vídeo for {@code null}
	 * ou se o vídeo já pertence à coleção;
	 * @see Video#equals
	 */
	public boolean addVideo(Video v) {
		if (v == null) {
			return false;
		}
		return videos.add(v);
	}

	/**
	 * @return O {@link Video} cadastrado com o título mais longo, ou {@code null}
	 * caso não existam vídeos cadastrados; mesmo que mais de um vídeo possua
	 * título de mesmo tamanho que o maior encontrado, apenas um será retornado.
	 */
	public Video getVideoComMaiorTitulo() {
		return videos.stream().max(Comparator.comparingInt(v -> v.getTitulo().length())).orElse(null);
	}

	/**
	 * @return O {@link Video} cadastrado com menor custo calculado, ou {@code null}
	 * caso não existam vídeos cadastrados; mesmo que mais de um vídeo possua o mesmo
	 * custo que o menor encontrado, apenas um será retornado.
	 * @see Video#calculaCusto
	 * @see Filme#calculaCusto
	 * @see Seriado#calculaCusto
	 */
	public Video getVideoComMenorCusto() {
		return videos.stream().min(Comparator.comparingDouble(Video::calculaCusto)).orElse(null);
	}

	/**
	 * @return O {@link Seriado} cadastrado com o maior período de exibição, ou
	 * {@code null} caso não existam seriados cadastrados; mesmo que mais de um seriado
	 * possua o mesmo período de exibição que o maior encontrado, apenas um será retornado.
	 * @see Seriado#getPeriodoExibicao
	 */
	public Seriado getSeriadoComMaiorExibicao() {
		return videos.stream()
			.filter(v -> v instanceof Seriado)
			.map(Seriado.class::cast)
			.max(Comparator.comparing(Seriado::getPeriodoExibicao))
			.orElse(null);
	}

	/**
	 * @return Objeto que agrupa o nome do diretor que mais aparece nas ocorrências de
	 * {@link Filme} cadastradas e o número de filmes deste diretor, ou {@code null} caso
	 * não existam filmes cadastrados; mesmo que mais de um diretor possua a mesma quantidade
	 * de filmes que o maior encontrado, apenas um será retornado.
	 */
	public DadosDiretor getDiretorComMaisFilmes() {
		Map<String, Long> diretores = videos.stream()
			.filter(v -> v instanceof Filme)
			.map(v -> ((Filme) v).getDiretor())
			.collect(Collectors.groupingBy(d -> d, Collectors.counting()));

		if (diretores.isEmpty()) {
			return null;
		}

		Map.Entry<String, Long> resultado = Collections.max(diretores.entrySet(), Map.Entry.comparingByValue());
		return new DadosDiretor(resultado.getKey(), Math.toIntExact(resultado.getValue()));
	}

	/**
	 * Calcula a média do cálculo de custo dos vídeos cadastrados e busca o vídeo com
	 * o custo mais próximo deste valor.
	 *
	 * @return Objeto que agrupa a média calculada de custo dos vídeos com o {@link Video} cadastrado
	 * cujo custo está mais próximo desse valor, ou {@code null} caso não existam vídeos cadastrados;
	 * mesmo que mais de um vídeo possua custo igual ao custo encontrado mais próximo da média, apenas
	 * um será retornado.
	 * @see Video#calculaCusto
	 * @see Filme#calculaCusto
	 * @see Seriado#calculaCusto
	 */
	public MenorDesvioPadrao getVideoComMenorDesvioPadrao() {
		double media = videos.stream().mapToDouble(Video::calculaCusto).average().orElse(0);
		Video resultado =
			videos.stream().min(Comparator.comparingDouble(v -> Math.abs(v.calculaCusto() - media))).orElse(null);

		if (resultado == null) {
			return null;
		}

		return new MenorDesvioPadrao(media, resultado);
	}

	/**
	 * Objeto que agrupa os dados de um diretor com a quantidade de instâncias
	 * de {@link Filme} nas quais o mesmo aparece.
	 *
	 * @param nome      O nome do diretor.
	 * @param qtdFilmes Quantidade de filmes deste diretor que estão cadastradas no sistema.
	 * @see Acervo#getDiretorComMaisFilmes
	 */
	public record DadosDiretor(String nome, int qtdFilmes) {}

	/**
	 * Objeto que agrupa a média de preço dos vídeos cadastrados com o {@link Video}
	 * cujo cálculo de custo está mais próximo deste valor (menor desvio padrão).
	 *
	 * @param mediaCalculada A média do cálculo de custo dos vídeos cadastrados.
	 * @param video          O vídeo cujo cálculo de custo está mais próximo da média calculada.
	 * @see Acervo#getVideoComMenorDesvioPadrao
	 */
	public record MenorDesvioPadrao(double mediaCalculada, Video video) {}
}
