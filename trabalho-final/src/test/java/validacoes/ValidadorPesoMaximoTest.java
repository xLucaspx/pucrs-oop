package validacoes;

import dados.Drone;
import dados.DroneCargaInanimada;
import dados.DronePessoal;
import dados.Transporte;
import dados.TransporteCargaInanimada;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidadorPesoMaximoTest {
	private final ValidadorPesoMaximo v = new ValidadorPesoMaximo();

	@Test
	@DisplayName("Deve retornar false se o drone não for de carga")
	void valida1() {
		Transporte t =
			new TransporteCargaInanimada(2, "fulano", "desc", 150.2, -29.378867, -50.873611, -30.027190, -51.161572, true);
		Drone d = new DronePessoal(1, 10, 100, 5);

		assertFalse(v.valida(d, t));
	}

	@Test
	@DisplayName("Deve retornar true se o peso máximo do drone for maior do que o do transporte")
	void valida2() {
		Transporte t =
			new TransporteCargaInanimada(2, "fulano", "desc", 150.2, -29.378867, -50.873611, -30.027190, -51.161572, true);
		Drone d = new DroneCargaInanimada(2, 20, 200, t.getPeso() + 10, true);

		assertTrue(v.valida(d, t));
	}

	@Test
	@DisplayName("Deve retornar true se o peso máximo do drone for igual ao do transporte")
	void valida3() {
		Transporte t =
			new TransporteCargaInanimada(2, "fulano", "desc", 150.2, -29.378867, -50.873611, -30.027190, -51.161572, true);
		Drone d = new DroneCargaInanimada(2, 20, 200, t.getPeso(), true);

		assertTrue(v.valida(d, t));
	}

	@Test
	@DisplayName("Deve retornar false se o peso máximo do drone for menor do que o do transporte")
	void valida4() {
		Transporte t =
			new TransporteCargaInanimada(2, "fulano", "desc", 150.2, -29.378867, -50.873611, -30.027190, -51.161572, true);
		Drone d = new DroneCargaInanimada(2, 20, 200, t.getPeso() - 10, true);

		assertFalse(v.valida(d, t));
	}
}
