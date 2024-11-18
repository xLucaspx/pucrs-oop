package arquivo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Scanner;

/**
 * Classe de utilidades para ser estendida por classes
 * que trabalham com arquivos. Permite trabalhar com um
 * arquivo por vez realizando operações de entrada e saída
 *
 * @author Lucas da Paz
 */
abstract class ArquivoIO {
	private PrintStream out;
	private Scanner in;

	/**
	 * Se o arquivo de entrada estiver aberto e houver
	 * linhas para serem lidas, lê a próxima linha.
	 *
	 * @return A linha lida, ou {@code null} se o arquivo
	 * de entrada for inválido ou se não houverem mais linhas.
	 * @see #abreArquivoEntrada(String)
	 * @see Scanner#hasNextLine()
	 * @see Scanner#nextLine()
	 */
	protected String proximaLinha() {
		if (in == null || !in.hasNextLine()) {
			return null;
		}
		return in.nextLine();
	}

	/**
	 * Se o arquivo de saída estiver aberto, escreve o
	 * conteúdo passado como argumento em uma nova linha.
	 *
	 * @param linha O conteúdo para ser escrito no arquivo.
	 * @return {@code true} se o conteúdo foi escrito com sucesso,
	 * {@code false} caso contrário (e.g. se o arquivo de saída
	 * for inválido).
	 * @see #abreArquivoSaida(String)
	 * @see PrintStream#println(String)
	 */
	protected boolean escreve(String linha) {
		if (out == null) {
			return false;
		}
		out.println(linha);
		return true;
	}

	/**
	 * <p>Retorna um {@link Reader} para o arquivo especificado.</p>
	 * <p><strong>A responsabilidade de fechar o recurso é da classe
	 * que chamou este método.</strong></p>
	 *
	 * @param caminhoArquivo O camino do arquivo que será aberto.
	 * @return Interface {@code Reader} para o arquivo especificado.
	 * @throws RuntimeException Se ocorrer algo de errado ao tentar abrir
	 *                          o arquivo.
	 * @see Files#newBufferedReader(Path, Charset)
	 */
	protected Reader getReader(String caminhoArquivo) {
		try {
			return Files.newBufferedReader(Paths.get(caminhoArquivo), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace(System.err);
			throw new RuntimeException("Erro ao tentar abrir arquivo \"%s\"!".formatted(caminhoArquivo));
		}
	}

	/**
	 * Fecha o arquivo de entrada anterior (se existir) e tenta
	 * abrir um novo arquivo com o caminho passado como argumento.
	 * Utiliza {@link StandardCharsets#UTF_8} e {@link Locale#ENGLISH}.
	 *
	 * @param caminhoArquivo O caminho do arquivo de entrada que
	 *                       será aberto.
	 * @throws RuntimeException Se ocorrer algo de errado ao tentar abrir
	 *                          o arquivo.
	 * @see #fechaArquivoEntrada()
	 * @see Files#newBufferedReader(Path, Charset)
	 * @see Scanner#Scanner(Readable)
	 */
	protected void abreArquivoEntrada(String caminhoArquivo) {
		try {
			fechaArquivoEntrada();
			BufferedReader br = Files.newBufferedReader(Paths.get(caminhoArquivo), StandardCharsets.UTF_8);
			in = new Scanner(br);
			in.useLocale(Locale.ENGLISH);
		} catch (IOException e) {
			e.printStackTrace(System.err);
			throw new RuntimeException("Erro ao tentar abrir arquivo \"%s\"!".formatted(caminhoArquivo));
		}
	}

	/**
	 * Fecha o arquivo de saída anterior (se existir) e tenta
	 * abrir um novo arquivo com o caminho passado como argumento.
	 * Utiliza {@link StandardCharsets#UTF_8}.
	 *
	 * @param caminhoArquivo O caminho do arquivo de saída que
	 *                       será aberto.
	 * @throws RuntimeException Se ocorrer algo de errado ao tentar abrir
	 *                          o arquivo.
	 * @see #fechaArquivoSaida()
	 * @see PrintStream#PrintStream(String, Charset)
	 */
	protected void abreArquivoSaida(String caminhoArquivo) {
		try {
			fechaArquivoSaida();
			out = new PrintStream(Paths.get(caminhoArquivo).toString(), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace(System.err);
			throw new RuntimeException("Erro ao tentar abrir arquivo \"%s\"!".formatted(caminhoArquivo));
		}
	}

	/**
	 * Chama o método {@link Scanner#close() close()} do {@link Scanner}
	 * de entrada e define-o como {@code null} se o arquivo de entrada
	 * estiver aberto; se não estiver, nenhuma ação é realizada.
	 */
	protected void fechaArquivoEntrada() {
		if (in == null) {
			return;
		}
		in.close();
		in = null;
	}

	/**
	 * Chama o método {@link PrintStream#close() close()} do
	 * {@link PrintStream} de saída e define-o como {@code null}
	 * se o arquivo de saída estiver aberto; se não estiver, nenhuma
	 * ação é realizada.
	 */
	protected void fechaArquivoSaida() {
		if (out == null) {
			return;
		}
		out.close();
		out = null;
	}
}
