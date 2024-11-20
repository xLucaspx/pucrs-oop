package aplicacao;

import views.App;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

/**
 * Classe responsável por realizar as configurações
 * necessárias e iniciar a aplicação.
 *
 * @author Lucas da Paz
 */
public class ACMEAirDrones {
	/**
	 * Realiza as configurações necessárias e inicia
	 * a aplicação.
	 */
	public void executar() {
		setErrorLogger();
		Locale.setDefault(Locale.ENGLISH);
		new App();
	}

	/**
	 * Define o logger de erros que será utilizado.
	 *
	 * @see System#setErr(PrintStream)
	 */
	private void setErrorLogger() {
		try {
			System.setErr(new PrintStream("logs/error-log.txt", StandardCharsets.UTF_8));
		} catch (IOException e) {
			e.printStackTrace(System.err);
		}
	}
}
