package aplicacao;

import views.App;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class ACMEAirDrones {

	public void executar() {
		setErrorLogger();
		Locale.setDefault(Locale.ENGLISH);
		new App();
	}

	private void setErrorLogger() {
		try {
			System.setErr(new PrintStream("logs/error-log.txt", StandardCharsets.UTF_8));
		} catch (IOException e) {
			e.printStackTrace(System.err);
		}
	}
}
