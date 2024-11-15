package validacoes;

import dados.Drone;
import dados.DroneCargaInanimada;
import dados.DronePessoal;
import dados.Transporte;
import dados.TransporteCargaInanimada;
import dados.TransportePessoal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidadorMaximoPessoasTest {
	private final ValidadorMaximoPessoas v = new ValidadorMaximoPessoas();

	@Test
	@DisplayName("Deve retornar false se o drone não for pessoal")
	void valida1() {
		Transporte t = new TransportePessoal(1, "fulano", "desc", 140.1, -30.027190, -51.161572, -30.061458, -51.173695,
			2);
		Drone d = new DroneCargaInanimada(2, 20, 200, 200, true);

		assertFalse(v.valida(d, t));
	}

	@Test
	@DisplayName("Deve retornar false se o transporte não for pessoal")
	void valida2() {
		Transporte t =
			new TransporteCargaInanimada(2, "fulano", "desc", 150.2, -29.378867, -50.873611, -30.027190, -51.161572, true);
		Drone d = new DronePessoal(1, 10, 100, 5);

		assertFalse(v.valida(d, t));
	}

	@Test
	@DisplayName("Deve retornar true se a quantidade máxima de pessoas do drone for maior do que a do transporte")
	void valida3() {
		TransportePessoal t =
			new TransportePessoal(1, "fulano", "desc", 140.1, -30.027190, -51.161572, -30.061458, -51.173695, 2);
		Drone d = new DronePessoal(1, 10, 100, t.getQtdPessoas() + 10);

		assertTrue(v.valida(d, t));
	}

	@Test
	@DisplayName("Deve retornar true se a quantidade máxima de pessoas do drone for igual a do transporte")
	void valida4() {
		TransportePessoal t =
			new TransportePessoal(1, "fulano", "desc", 140.1, -30.027190, -51.161572, -30.061458, -51.173695, 2);
		Drone d = new DronePessoal(1, 10, 100, t.getQtdPessoas());

		assertTrue(v.valida(d, t));
	}

	@Test
	@DisplayName("Deve retornar false se a quantidade máxima de pessoas do drone for menor do que a do transporte")
	void valida5() {
		TransportePessoal t =
			new TransportePessoal(1, "fulano", "desc", 140.1, -30.027190, -51.161572, -30.061458, -51.173695, 2);
		Drone d = new DronePessoal(1, 10, 100, t.getQtdPessoas() - 10);

		assertFalse(v.valida(d, t));
	}
}
