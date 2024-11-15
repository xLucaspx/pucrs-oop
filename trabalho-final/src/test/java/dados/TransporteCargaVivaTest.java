package dados;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransporteCargaVivaTest {
	@Test
	@DisplayName("Deve calcular corretamente o custo para carga com intervalo de temperatura > 10")
	void calculaCusto1() {
		Transporte t =
			new TransporteCargaViva(3, "fulano", "desc", 250.3, -30.027593, -51.227884, -27.597393, -48.552890, 20.1,
				30.9);
		Drone d = new DroneCargaViva(3, 30, 400, 300, true);
		t.setDrone(d);

		double custoEsperado = d.calculaCustoKm() * t.getDistancia() + 1000;

		assertEquals(custoEsperado, t.calculaCusto());
	}

	@Test
	@DisplayName("Deve calcular corretamente o custo para carga com intervalo de temperatura = 10")
	void calculaCusto2() {
		Transporte t =
			new TransporteCargaViva(3, "fulano", "desc", 250.3, -30.027593, -51.227884, -27.597393, -48.552890, 20,
				30);
		Drone d = new DroneCargaViva(3, 30, 400, 300, false);
		t.setDrone(d);

		double custoEsperado = d.calculaCustoKm() * t.getDistancia();

		assertEquals(custoEsperado, t.calculaCusto());
	}

	@Test
	@DisplayName("Deve calcular corretamente o custo para carga com intervalo de temperatura < 10")
	void calculaCusto3() {
		Transporte t =
			new TransporteCargaViva(3, "fulano", "desc", 250.3, -30.027593, -51.227884, -27.597393, -48.552890, 25,
				30);
		Drone d = new DroneCargaViva(3, 30, 400, 300, false);
		t.setDrone(d);

		double custoEsperado = d.calculaCustoKm() * t.getDistancia();

		assertEquals(custoEsperado, t.calculaCusto());
	}
}
