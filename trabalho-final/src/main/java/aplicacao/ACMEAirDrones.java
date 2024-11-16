package aplicacao;

import views.App;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class ACMEAirDrones {

	public void executar() {
		setErrorLogger();
		new App();
	}

	private void setErrorLogger() {
		try {
			System.setErr(new PrintStream("logs/error-log_%d.txt".formatted(System.currentTimeMillis()),
				StandardCharsets.UTF_8
			));
		} catch (IOException e) {
			e.printStackTrace(System.err);
		}
	}
}
