package dados;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransporteCargaInanimadaTest {
	@Test
	@DisplayName("Deve calcular corretamente o custo para carga perigosa")
	void calculaCusto1() {
		Transporte t =
			new TransporteCargaInanimada(4, "fulano", "desc", 150.2, -29.378867, -50.873611, -30.027190, -51.161572,
				true);
		Drone d = new DroneCargaInanimada(2, 20, 200, 200, true);
		t.setDrone(d);

		double custoEsperado = d.calculaCustoKm() * t.getDistancia() + 500;

		assertEquals(custoEsperado, t.calculaCusto());
	}

	@Test
	@DisplayName("Deve calcular corretamente o custo para carga não perigosa")
	void calculaCusto2() {
		Transporte t =
			new TransporteCargaInanimada(4, "fulano", "desc", 150.2, -29.378867, -50.873611, -30.027190, -51.161572,
				false);
		Drone d = new DroneCargaInanimada(2, 20, 200, 200, true);
		t.setDrone(d);

		double custoEsperado = d.calculaCustoKm() * t.getDistancia();

		assertEquals(custoEsperado, t.calculaCusto());
	}
}
