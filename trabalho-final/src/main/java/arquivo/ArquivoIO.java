package arquivo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
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

	protected String proximaLinha() {
		if (in == null || !in.hasNextLine()) {
			return null;
		}
		return in.nextLine();
	}

	protected boolean escreve(String linha) {
		if (out == null) {
			return false;
		}
		out.println(linha);
		return true;
	}

	protected void redirecionaEntrada(String nomeArquivo) {
		try {
			fechaEntrada();
			BufferedReader br = Files.newBufferedReader(Paths.get(nomeArquivo), StandardCharsets.UTF_8);
			in = new Scanner(br);
			Locale.setDefault(Locale.ENGLISH);
			in.useLocale(Locale.ENGLISH);
		} catch (IOException e) {
			e.printStackTrace(System.err);
			throw new RuntimeException("Erro ao tentar abrir arquivo \"%s\"!".formatted(nomeArquivo));
		}
	}

	protected void redirecionaSaida(String nomeArquivo) {
		try {
			fechaSaida();
			PrintStream ps = new PrintStream(Paths.get(nomeArquivo).toString(), StandardCharsets.UTF_8);
			System.setOut(ps);
			Locale.setDefault(Locale.ENGLISH);
		} catch (IOException e) {
			e.printStackTrace(System.err);
			throw new RuntimeException("Erro ao tentar abrir arquivo \"%s\"!".formatted(nomeArquivo));
		}
	}

	protected void fechaEntrada() {
		if (in == null) {
			return;
		}
		in.close();
		in = null;
	}

	protected void fechaSaida() {
		if (out == null) {
			return;
		}
		out.close();
		out = null;
	}
}
