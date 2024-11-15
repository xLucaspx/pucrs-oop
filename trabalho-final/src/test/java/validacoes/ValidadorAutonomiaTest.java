package validacoes;

import dados.Drone;
import dados.DronePessoal;
import dados.Transporte;
import dados.TransportePessoal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidadorAutonomiaTest {
	private final ValidadorAutonomia v = new ValidadorAutonomia();

	@Test
	@DisplayName("Deve retornar true se a autonomia do drone for maior do que a distância")
	void valida1() {
		Transporte t = new TransportePessoal(1, "fulano", "desc", 140.1, -30.027190, -51.161572, -30.061458, -51.173695,
			2);
		Drone d = new DronePessoal(1, 10, t.getDistancia() + 10, 5);

		assertTrue(v.valida(d, t));
	}

	@Test
	@DisplayName("Deve retornar true se a autonomia do drone for igual a distância")
	void valida2() {
		Transporte t = new TransportePessoal(1, "fulano", "desc", 140.1, -30.027190, -51.161572, -30.061458, -51.173695,
			2);
		Drone d = new DronePessoal(1, 10, t.getDistancia(), 5);

		assertTrue(v.valida(d, t));
	}

	@Test
	@DisplayName("Deve retornar false se a autonomia do drone for menor do que a distância")
	void valida3() {
		Transporte t = new TransportePessoal(1, "fulano", "desc", 140.1, -30.027190, -51.161572, -30.061458, -51.173695,
			2);
		Drone d = new DronePessoal(1, 10, t.getDistancia() - 10, 5);

		assertFalse(v.valida(d, t));
	}
}
