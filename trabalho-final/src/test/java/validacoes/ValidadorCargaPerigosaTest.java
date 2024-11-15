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

class ValidadorCargaPerigosaTest {
	private final ValidadorCargaPerigosa v = new ValidadorCargaPerigosa();

	@Test
	@DisplayName("Deve retornar false se o drone não for de carga inanimada")
	void valida1() {
		Transporte t =
			new TransporteCargaInanimada(2, "fulano", "desc", 150.2, -29.378867, -50.873611, -30.027190, -51.161572, true);
		Drone d = new DronePessoal(1, 10, 100, 5);

		assertFalse(v.valida(d, t));
	}

	@Test
	@DisplayName("Deve retornar false se o transporte não for de carga inanimada")
	void valida2() {
		Transporte t = new TransportePessoal(1, "fulano", "desc", 140.1, -30.027190, -51.161572, -30.061458, -51.173695,
			2);
		Drone d = new DroneCargaInanimada(2, 20, 200, 200, true);

		assertFalse(v.valida(d, t));
	}

	@Test
	@DisplayName("Deve retornar true se a carga não for perigosa e o drone não possuir proteção")
	void valida3() {
		Transporte t =
			new TransporteCargaInanimada(2, "fulano", "desc", 150.2, -29.378867, -50.873611, -30.027190, -51.161572, false);
		Drone d = new DroneCargaInanimada(2, 20, 200, 200, false);

		assertTrue(v.valida(d, t));
	}

	@Test
	@DisplayName("Deve retornar true se a carga não for perigosa e o drone possuir proteção")
	void valida4() {
		Transporte t =
			new TransporteCargaInanimada(2, "fulano", "desc", 150.2, -29.378867, -50.873611, -30.027190, -51.161572, false);
		Drone d = new DroneCargaInanimada(2, 20, 200, 200, true);

		assertTrue(v.valida(d, t));
	}

	@Test
	@DisplayName("Deve retornar true se a carga for perigosa e o drone possuir proteção")
	void valida5() {
		Transporte t =
			new TransporteCargaInanimada(2, "fulano", "desc", 150.2, -29.378867, -50.873611, -30.027190, -51.161572, true);
		Drone d = new DroneCargaInanimada(2, 20, 200, 200, true);

		assertTrue(v.valida(d, t));
	}

	@Test
	@DisplayName("Deve retornar false se a carga for perigosa e o drone não possuir proteção")
	void valida6() {
		Transporte t =
			new TransporteCargaInanimada(2, "fulano", "desc", 150.2, -29.378867, -50.873611, -30.027190, -51.161572, true);
		Drone d = new DroneCargaInanimada(2, 20, 200, 200, false);

		assertFalse(v.valida(d, t));
	}
}
