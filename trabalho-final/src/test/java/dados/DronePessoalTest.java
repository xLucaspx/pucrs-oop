package dados;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DronePessoalTest {
	@Test
	@DisplayName("Deve calcular custo corretamente para carga sem pessoas")
	void calculaCustoKm1() {
		Drone d = new DronePessoal(1, 10, 9, 0);
		double custoEsperado = d.getCustoFixo();

		assertEquals(custoEsperado, d.calculaCustoKm());
	}

	@Test
	@DisplayName("Deve calcular custo corretamente para carga com 1 pessoa")
	void calculaCustoKm2() {
		Drone d = new DronePessoal(1, 10, 9, 1);
		int adicional = 2;
		double custoEsperado = d.getCustoFixo() + adicional;

		assertEquals(custoEsperado, d.calculaCustoKm());
	}

	@Test
	@DisplayName("Deve calcular custo corretamente para carga com mais de 1 pessoa")
	void calculaCustoKm3() {
		Drone d = new DronePessoal(1, 10, 9, 5);
		int qtdPessoas = 5;
		int adicional = 2 * qtdPessoas;
		double custoEsperado = d.getCustoFixo() + adicional;

		assertEquals(custoEsperado, d.calculaCustoKm());
	}
}
