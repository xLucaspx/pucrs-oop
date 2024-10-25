package app;

import dados.Acervo;
import dados.Filme;
import dados.Seriado;
import dados.Video;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Scanner;

/**
 * <p>Classe de aplicação; possui apenas um método público, {@link #processar},
 * que é responsável pela lógica da aplicação.</p>
 * <p>A entrada e a saída de dados ocorrem via arquivos de texto, e apenas esta
 * classe manipula estes arquivos, i.e., apenas esta classe realiza as operações
 * de entrada e saída (I/O) do sistema.</p>
 *
 * @author Lucas da Paz
 */
public class ACMEVideos {
	/**
	 * Define o caminho do arquivo padrão de entrada de dados.
	 */
	private static final Path CAMINHO_ARQUIVO_ENTRADA = Paths.get("dadosentrada.txt");
	/**
	 * Define o caminho do arquivo padrão de sáida de dados.
	 */
	private static final Path CAMINHO_ARQUIVO_SAIDA = Paths.get("relatorio.txt");
	/**
	 * Define o caractere separador de campos no arquivo de entrada.
	 */
	private static final String SEPARADOR_CAMPOS = ";";
	/**
	 * Dígito que identifica um {@link Filme} no arquivo de entrada.
	 */
	private static final int DIGITO_FILME = 1;
	/**
	 * Dígito que identifica um {@link Seriado} no arquivo de entrada.
	 */
	private static final int DIGITO_SERIADO = 2;

	/**
	 * Objeto que gerencia os vídeos cadastrados.
	 */
	private final Acervo acervo;

	// Atributos de I/O
	private final PrintStream out = System.out;
	private Scanner in = new Scanner(System.in);

	/**
	 * Construtor da aplicação.
	 */
	public ACMEVideos() {
		acervo = new Acervo();
	}

	/**
	 * <p>Executa o funcionamento da aplicação. Redireciona a entrada e a saída para
	 * os arquivos definidos e restaura ao final da execução.</p>
	 * <p>Deve realizar a seguinte sequência de passos:</p>
	 * <ol>
	 *   <li>
	 *     <strong>Cadastrar vídeos</strong>: Lê os dados do arquivo de entrada e, para cada linha,
	 *     caso os campos seja válidos, cadastra o {@link Video} instanciado no sistema e imprime seus
	 *     dados no formato {@code 1:} seguido do texto gerado pelo método {@link Video#geraTexto geraTexto};
	 *     caso o código do vídeo já esteja cadastrado, imprime {@code 1:Erro - codigo de video repetido.};
	 *   </li>
	 *   <li>
	 * 		<strong>Mostrar dados do vídeo com título mais longo</strong>: Busca o vídeo com o título
	 * 		mais longo cadastrado no sistema e imprime seus dados no formato {@code 2:codigo,titulo}; se
	 * 		não houver vídeos cadastrados, imprime a mensagem de erro {@code 2:Erro - nenhum video cadastrado.};
	 *   </li>
	 *   <li>
	 *     <strong>Mostrar os dados do vídeo com cálculo de custo mais baixo</strong>: Busca o vídeo com
	 *     o menor custo calculado e imprime seus dados no formato {@code 3:codigo,titulo,custo}; se não
	 *     houver vídeos cadastrados, imprime a mensagem de erro {@code 3:Erro - nenhum video cadastrado.};
	 *   </li>
	 *   <li>
	 *     <strong>Mostrar os dados do seriado com maior período de exibição</strong>: Busca o {@link Seriado}
	 *     com o maior período de exibição calculado e imprime seus dados no formato
	 *     {@code 4:codigo,titulo,periodo-em-anos}; se não houver seriados cadastrados, imprime a mensagem de
	 *     erro {@code 4:Erro - nenhum seriado cadastrado.};
	 *   </li>
	 *   <li>
	 *     <strong>Mostrar o diretor com mais filmes</strong>: Busca o diretor que aparece com mais frequência
	 *     em instancias de {@link Filme} cadastradas no sistema e imprime seus dados no formato
	 *     {@code 5:diretor,quantidade-de-filmes}; se não houver filmes cadastrados, imprime a mensagem de erro
	 *     {@code 5:Erro - nenhum filme cadastrado.};
	 *   </li>
	 *   <li>
	 *     <strong>Mostrar os dados do vídeo com menor desvio padrão do calculo de custo</strong>: Calcula a
	 *     média dos cálculos de custo dos vídeos cadastrados e localiza o vídeo cujo cálculo de custo está mais
	 *     próximo deste valor; imprime os dados do vídeo encontrado no formato {@code 6:media-calculada,} seguido
	 *     do texto gerado pelo método {@link Video#geraTexto geraTexto}. Se não houver vídeos cadastrados, imprime
	 *     a mensagem de erro {@code 6:Erro - nenhum video cadastrado.}.
	 *   </li>
	 * </ol>
	 * 	<p>Para o primeiro passo, é imprescindível que cada linha do arquivo de entrada contenha um dígito na primeira
	 * 	posição, informando o típo de vídeo que deve ser cadastrado.</p>
	 *
	 * @param caminhosAquivos Caminhos dos arquivos que serão utilizados para a entrada e para a saída; se os valores
	 *                        forem {@code null}, serão utilizados os caminhos especificados nas constantes
	 *                        {@link #CAMINHO_ARQUIVO_ENTRADA} e {@link #CAMINHO_ARQUIVO_SAIDA}. Caso o arquivo de
	 *                        saída não exista, sera criado.
	 */
	public void processar(String... caminhosAquivos) {
		Path arquivoEntrada = caminhosAquivos.length > 0 ? Paths.get(caminhosAquivos[0]) : CAMINHO_ARQUIVO_ENTRADA;
		Path arquivoSaida = caminhosAquivos.length > 1 ? Paths.get(caminhosAquivos[1]) : CAMINHO_ARQUIVO_SAIDA;
		redirecionaEntrada(arquivoEntrada);
		redirecionaSaida(arquivoSaida);

		cadastrarDoArquivo();
		imprimeVideoComMaiorTitulo();
		imprimeVideoComMenorCusto();
		imprimeSeriadoComMaiorExibicao();
		imprimeDiretorComMaisFilmes();
		imprimeVideoMenorDesvioPadrao();

		restauraEntrada();
		restauraSaida();
	}

	/**
	 * <p>Lê as informações de um {@link Video}, instancia-o e cadastra-o no sistema.
	 * Em caso de sucesso, imprime {@code 1:} seguido do texto gerado pelo método
	 * {@link Video#geraTexto geraTexto}; caso o código do vídeo já esteja cadastrado no sistema,
	 * imprime {@code 1:Erro - codigo de video repetido.}. Em caso de falha ao ler os campos ou ao
	 * instanciar o objeto, pula para a próxima linha.</p>
	 * <p>A entrada de dados deve ocorrer por leitura de arquivo de texto estruturado.
	 * Os campos devem estar separados utilizando a string definida na constante {@link #SEPARADOR_CAMPOS}
	 * e cada linha do arquivo deve possuir um dígito no início, sendo que os dígitos que indicam instâncias
	 * de {@link Filme} e {@link Seriado} estão armazenados nas constantes {@link #DIGITO_FILME} e
	 * {@link #DIGITO_SERIADO}, respectivamente.</p>
	 */
	private void cadastrarDoArquivo() {
		while (in.hasNextLine()) {
			String linha = in.nextLine();

			if (!linha.contains(SEPARADOR_CAMPOS)) {
				continue;
			}

			String[] campos = linha.split(SEPARADOR_CAMPOS);
			int digito = Integer.parseInt(campos[0]); // se não informar o dígito, let it break!

			Video novo = switch (digito) {
				case DIGITO_FILME -> criarFilme(campos);
				case DIGITO_SERIADO -> criarSeriado(campos);
				default -> null;
			};

			if (novo == null) {
				continue;
			}

			if (!acervo.addVideo(novo)) {
				System.out.println("1:Erro - codigo de video repetido.");
				continue;
			}
			System.out.printf("1:%s%n", novo.geraTexto());
		}
	}

	/**
	 * Cria uma instância de {@link Filme} a partir dos campos lidos
	 * do arquivo de entrada.
	 *
	 * @param campos Os campos do filme a ser criado.
	 * @return O objeto criado, ou {@code null} caso algum dos campos seja
	 * inválido ou esteja faltando.
	 */
	private Filme criarFilme(String... campos) {
		try {
			int codigo = Integer.parseInt(campos[1]);
			String titulo = campos[2];
			String diretor = campos[3];
			double duracao = Double.parseDouble(campos[4]);
			return new Filme(codigo, titulo, diretor, duracao);
		} catch (IndexOutOfBoundsException | NumberFormatException e) {
			return null;
		}
	}

	/**
	 * Cria uma instância de {@link Seriado} a partir dos campos lidos
	 * do arquivo de entrada.
	 *
	 * @param campos Os campos do seriado a ser criado.
	 * @return O objeto criado, ou {@code null} caso algum dos campos seja
	 * inválido ou esteja faltando.
	 */
	private Seriado criarSeriado(String... campos) {
		try {
			int codigo = Integer.parseInt(campos[1]);
			String titulo = campos[2];
			int anoInicio = Integer.parseInt(campos[3]);
			int anoFim = Integer.parseInt(campos[4]);
			int numEpisodios = Integer.parseInt(campos[5]);
			return new Seriado(codigo, titulo, anoInicio, anoFim, numEpisodios);
		} catch (IndexOutOfBoundsException | NumberFormatException e) {
			return null;
		}
	}

	/**
	 * Imprime os dados do {@link Video} com título mais longo no formato
	 * {@code 2:codigo,titulo}; se não houver vídeos cadastrados, imprime a
	 * mensagem de erro {@code 2:Erro - nenhum video cadastrado.}.
	 *
	 * @see Acervo#getVideoComMaiorTitulo
	 */
	private void imprimeVideoComMaiorTitulo() {
		Video resultado = acervo.getVideoComMaiorTitulo();

		if (resultado == null) {
			System.out.println("2:Erro - nenhum video cadastrado.");
			return;
		}


		System.out.printf("2:%d,%s%n", resultado.getCodigo(), resultado.getTitulo());
	}

	/**
	 * Imprime os dados do {@link Video} com o menor custo no formato
	 * {@code 3:codigo,titulo,custo}; se não houver vídeos cadastrados, imprime
	 * a mensagem de erro {@code 3:Erro - nenhum video cadastrado.}.
	 *
	 * @see Acervo#getVideoComMenorCusto
	 */
	private void imprimeVideoComMenorCusto() {
		Video resultado = acervo.getVideoComMenorCusto();

		if (resultado == null) {
			System.out.println("3:Erro - nenhum video cadastrado.");
			return;
		}

		System.out.printf("3:%d,%s,%.2f%n", resultado.getCodigo(), resultado.getTitulo(), resultado.calculaCusto());
	}

	/**
	 * Imprime os dados do {@link Seriado} com maior período de exibição no formato
	 * {@code 4:codigo,titulo,periodo-em-anos}; se não houver seriados cadastrados,
	 * imprime a mensagem de erro {@code 4:Erro - nenhum seriado cadastrado.}.
	 *
	 * @see Acervo#getSeriadoComMaiorExibicao
	 */
	private void imprimeSeriadoComMaiorExibicao() {
		Seriado resultado = acervo.getSeriadoComMaiorExibicao();

		if (resultado == null) {
			System.out.println("4:Erro - nenhum seriado cadastrado.");
			return;
		}

		System.out.printf("4:%d,%s,%d%n", resultado.getCodigo(), resultado.getTitulo(), resultado.getPeriodoExibicao());
	}

	/**
	 * Imprime o diretor com maior quantidade de {@link Filme filmes} cadastrados no
	 * formato {@code 5:diretor,quantidade-de-filmes}; se não houver filmes cadastrados,
	 * imprime a mensagem de erro {@code 5:Erro - nenhum filme cadastrado.}.
	 *
	 * @see Acervo#getDiretorComMaisFilmes
	 */
	private void imprimeDiretorComMaisFilmes() {
		Acervo.DadosDiretor diretor = acervo.getDiretorComMaisFilmes();

		if (diretor == null) {
			System.out.println("5:Erro - nenhum filme cadastrado.");
			return;
		}

		System.out.printf("5:%s,%d%n", diretor.nome(), diretor.qtdFilmes());
	}

	/**
	 * Imprime os dados do {@link Video} com o menor desvio padrão do cálculo de custo
	 * no formato {@code 6:media-calculada,} seguido do texto gerado pelo método
	 * {@link Video#geraTexto() geraTexto}; se não houver vídeos cadastrados, imprime
	 * a mensagem de erro {@code 6:Erro - nenhum video cadastrado.}.
	 *
	 * @see Acervo#getVideoComMenorDesvioPadrao
	 */
	private void imprimeVideoMenorDesvioPadrao() {
		Acervo.MenorDesvioPadrao resultado = acervo.getVideoComMenorDesvioPadrao();

		if (resultado == null) {
			System.out.println("6:Erro - nenhum video cadastrado.");
			return;
		}

		System.out.printf("6:%.2f,%s%n", resultado.mediaCalculada(), resultado.video().geraTexto());
	}

	/**
	 * Redireciona a entrada de dados para o arquivo especificado, utilizando
	 * codificação {@link StandardCharsets#UTF_8 UTF-8}. Define o {@link Locale}
	 * padrão e o da entrada para {@link Locale#ENGLISH}.
	 *
	 * @param caminhoArquivo O caminho do arquivo que será utilizado para
	 *                       a entrada de dados
	 * @see Files#newBufferedReader(Path, Charset)
	 * @see Scanner#Scanner(InputStream)
	 * @see Locale#setDefault(Locale)
	 */
	private void redirecionaEntrada(Path caminhoArquivo) {
		try {
			BufferedReader inputStream = Files.newBufferedReader(caminhoArquivo, StandardCharsets.UTF_8);
			in = new Scanner(inputStream);
		} catch (IOException e) {
			System.err.printf("Erro de I/O -> %s%n", e);
		}

		Locale.setDefault(Locale.ENGLISH);
		in.useLocale(Locale.ENGLISH);
	}

	/**
	 * <p>Redireciona a saída de dados para o arquivo especificado, utilizando
	 * codificação {@link StandardCharsets#UTF_8 UTF-8}; se o arquivo não existir,
	 * será criado.</p>
	 * <p>Define o {@link Locale} padrão para {@link Locale#ENGLISH}.</p>
	 *
	 * @param caminhoArquivo O caminho do arquivo que será utilizado para
	 *                       a saída de dados.
	 * @see PrintStream#PrintStream(File, Charset)
	 * @see System#setOut(PrintStream)
	 * @see Locale#setDefault(Locale)
	 */
	private void redirecionaSaida(Path caminhoArquivo) {
		try {
			PrintStream outputStream = new PrintStream(caminhoArquivo.toString(), StandardCharsets.UTF_8);
			System.setOut(outputStream);
		} catch (IOException e) {
			System.err.printf("Erro de I/O -> %s%n", e);
		}
		Locale.setDefault(Locale.ENGLISH);
	}

	/**
	 * Fecha a entrada anterior e define a redireciona a
	 * entrada padrão para o teclado. Este método só deve ser
	 * chamado se a entrada padrão foi alterada.
	 *
	 * @see System#in
	 * @see Scanner#Scanner(InputStream)
	 * @see Scanner#close
	 */
	private void restauraEntrada() {
		in.close();
		in = new Scanner(System.in);
	}

	/**
	 * Fecha a saída anterior e restaura a saída padrão para
	 * a tela (console). Este método só deve ser chamado se a
	 * saída padrão foi alterada.
	 *
	 * @see System#out
	 * @see System#setOut(PrintStream)
	 * @see PrintStream#close
	 */
	private void restauraSaida() {
		System.out.close();
		System.setOut(out);
	}
}
