package dados;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DroneCargaVivaTest {
	@Test
	@DisplayName("Deve calcular custo corretamente para carga sem proteção")
	void calculaCustoKm1() {
		Drone d = new DroneCargaViva(1, 10, 9, 50, false);
		int adicional = 10;
		double custoEsperado = d.getCustoFixo() + adicional;

		assertEquals(custoEsperado, d.calculaCustoKm());
	}

	@Test
	@DisplayName("Deve calcular custo corretamente para carga com proteção")
	void calculaCustoKm2() {
		Drone d = new DroneCargaViva(1, 10, 9, 50, true);
		int adicional = 20;
		double custoEsperado = d.getCustoFixo() + adicional;

		assertEquals(custoEsperado, d.calculaCustoKm());
	}
}
