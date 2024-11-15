package dados;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransportePessoalTest {
	@Test
	@DisplayName("Deve calcular corretamente o custo para carga sem pessoas")
	void calculaCusto1() {
		Transporte t = new TransportePessoal(1, "fulano", "desc", 140.1, -30.027190, -51.161572, -30.061458,
			-51.173695, 0);
		Drone d = new DronePessoal(1, 10, 100, 1);
		t.setDrone(d);

		double custoEsperado = d.calculaCustoKm() * t.getDistancia();

		assertEquals(custoEsperado, t.calculaCusto());
	}

	@Test
	@DisplayName("Deve calcular corretamente o custo para carga com uma pessoa")
	void calculaCusto2() {
		Transporte t = new TransportePessoal(1, "fulano", "desc", 140.1, -30.027190, -51.161572, -30.061458,
			-51.173695, 1);
		Drone d = new DronePessoal(1, 10, 100, 2);
		t.setDrone(d);

		double custoEsperado = d.calculaCustoKm() * t.getDistancia() + 10;

		assertEquals(custoEsperado, t.calculaCusto());
	}

	@Test
	@DisplayName("Deve calcular corretamente o custo para carga com mais de uma pessoa")
	void calculaCusto3() {
		Transporte t = new TransportePessoal(1, "fulano", "desc", 140.1, -30.027190, -51.161572, -30.061458,
			-51.173695, 5);
		Drone d = new DronePessoal(1, 10, 100, 5);
		t.setDrone(d);

		double custoEsperado = d.calculaCustoKm() * t.getDistancia() + 10 * 5;

		assertEquals(custoEsperado, t.calculaCusto());
	}
}
