package dados;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class TransporteTest {
	@Test
	@DisplayName("Deve criar o transporte com a situação PENDENTE")
	void getSituacao1() {
		Transporte t = new TransportePessoal(1, "fulano", "desc", 82.5, 40.714268, -74.005974, 34.0522, -118.2437, 1);

		assertEquals(Estado.PENDENTE, t.getSituacao());
	}

	@Test
	@DisplayName("Deve alterar a situação para ALOCADO ao definir drone")
	void setDrone1() {
		Transporte t = new TransportePessoal(1, "fulano", "desc", 82.5, 40.714268, -74.005974, 34.0522, -118.2437, 1);
		Drone d = new DronePessoal(1, 10, 9.8, 2);
		t.setDrone(d);

		assertEquals(Estado.ALOCADO, t.getSituacao());
	}

	@Test
	@DisplayName("Deve alterar a situação de ALOCADO para TERMINADO")
	void terminar1() {
		Transporte t = new TransportePessoal(1, "fulano", "desc", 82.5, 40.714268, -74.005974, 34.0522, -118.2437, 1);
		Drone d = new DronePessoal(1, 10, 9.8, 2);
		t.setDrone(d);
		t.terminar();

		assertEquals(Estado.TERMINADO, t.getSituacao());
	}

	@Test
	@DisplayName("Não deve terminar transporte com a situação PENDENTE")
	void terminar2() {
		Transporte t = new TransportePessoal(1, "fulano", "desc", 82.5, 40.714268, -74.005974, 34.0522, -118.2437, 1);
		t.terminar();

		assertEquals(Estado.PENDENTE, t.getSituacao());
	}

	@Test
	@DisplayName("Não deve terminar transporte com a situação CANCELADO")
	void terminar3() {
		Transporte t = new TransportePessoal(1, "fulano", "desc", 82.5, 40.714268, -74.005974, 34.0522, -118.2437, 1);
		t.cancelar();
		t.terminar();

		assertEquals(Estado.CANCELADO, t.getSituacao());
	}

	@Test
	@DisplayName("Deve alterar a situação de PENDENTE para CANCELADO")
	void cancelar1() {
		Transporte t = new TransportePessoal(1, "fulano", "desc", 82.5, 40.714268, -74.005974, 34.0522, -118.2437, 1);
		t.cancelar();

		assertEquals(Estado.CANCELADO, t.getSituacao());
	}

	@Test
	@DisplayName("Deve alterar a situação de ALOCADO para CANCELADO")
	void cancelar2() {
		Transporte t = new TransportePessoal(1, "fulano", "desc", 82.5, 40.714268, -74.005974, 34.0522, -118.2437, 1);
		Drone d = new DronePessoal(1, 10, 9.8, 2);
		t.setDrone(d);
		t.cancelar();

		assertEquals(Estado.CANCELADO, t.getSituacao());
	}

	@Test
	@DisplayName("Não deve cancelar transporte finalizado")
	void cancelar3() {
		Transporte t = new TransportePessoal(1, "fulano", "desc", 82.5, 40.714268, -74.005974, 34.0522, -118.2437, 1);
		Drone d = new DronePessoal(1, 10, 9.8, 2);
		t.setDrone(d);
		t.terminar();
		t.cancelar();

		assertEquals(Estado.TERMINADO, t.getSituacao());
	}

	@Test
	@DisplayName("Deve calcular corretamente o valor base")
	void getValorBase1() {
		Transporte t1 = new TransportePessoal(1, "fulano", "desc", 140.1, -30.027190, -51.161572, -30.061458, -51.173695, 2);
		Transporte t2 =
			new TransporteCargaInanimada(2, "fulano", "desc", 150.2, -29.378867, -50.873611, -30.027190, -51.161572, true);
		Transporte t3 =
			new TransporteCargaViva(3, "fulano", "desc", 250.3, -30.027593, -51.227884, -27.597393, -48.552890, 20.1, 30.9);

		Drone d1 = new DronePessoal(1, 10, 100, 5);
		Drone d2 = new DroneCargaInanimada(2, 20, 200, 200, true);
		Drone d3 = new DroneCargaViva(3, 30, 400, 300, true);

		t1.setDrone(d1);
		t2.setDrone(d2);
		t3.setDrone(d3);

		double valorEsperado1 = d1.calculaCustoKm() * t1.getDistancia();
		double valorEsperado2 = d2.calculaCustoKm() * t2.getDistancia();
		double valorEsperado3 = d3.calculaCustoKm() * t3.getDistancia();

		assertEquals(valorEsperado1, t1.getValorBase());
		assertEquals(valorEsperado2, t2.getValorBase());
		assertEquals(valorEsperado3, t3.getValorBase());
	}

	@Test
	@DisplayName("Deve calcular o valor base como 0 se estiver PENDENTE")
	void getValorBase2() {
		Transporte t = new TransportePessoal(1, "fulano", "desc", 82.5, 40.714268, -74.005974, 34.0522, -118.2437, 1);
		assertEquals(0, t.getValorBase());
	}

	@Test
	@DisplayName("Deve calcular corretamente as distâncias com margem de erro de 0.5%")
	void getDistancia1() {
		Transporte t1 = new TransportePessoal(1, "fulano", "desc", 82.5, 40.714268, -74.005974, 34.0522, -118.2437, 1);
		Transporte t2 =
			new TransporteCargaViva(3, "fulano", "desc", 250.3, -30.027593, -51.227884, -27.597393, -48.552890, 20.1, 30.9);
		Transporte t3 =
			new TransportePessoal(1, "fulano", "desc", 140.1, -30.027190, -51.161572, -30.061458, -51.173695, 2);
		Transporte t4 =
			new TransporteCargaInanimada(2, "fulano", "desc", 150.2, -29.378867, -50.873611, -30.027190, -51.161572, true);

		double distanciaEsperada1 = 3944.4;
		double distanciaEsperada2 = 375.1;
		double distanciaEsperada3 = 3.98;
		double distanciaEsperada4 = 77.08;

		double toleranciaErro = 0.005; // 0.5%

		assertEquals(distanciaEsperada1, t1.getDistancia(), distanciaEsperada1 * toleranciaErro);
		assertEquals(distanciaEsperada2, t2.getDistancia(), distanciaEsperada2 * toleranciaErro);
		assertEquals(distanciaEsperada3, t3.getDistancia(), distanciaEsperada3 * toleranciaErro);
		assertEquals(distanciaEsperada4, t4.getDistancia(), distanciaEsperada4 * toleranciaErro);
	}

	@Test
	@DisplayName("Deve retornar true se os objetos forem os mesmos")
	void testEquals1() {
		Transporte t1 = new TransportePessoal(1, "fulano", "desc", 82.5, 40.714268, -74.005974, 34.0522, -118.2437, 1);
		Transporte t2 = t1;

		assertEquals(t1, t2);
	}

	@Test
	@DisplayName("Deve retornar true se os transportes possuírem o mesmo número")
	void testEquals2() {
		Transporte t1 = new TransportePessoal(1, "fulano", "desc", 82.5, 40.714268, -74.005974, 34.0522, -118.2437, 1);
		Transporte t2 =
			new TransporteCargaViva(1, "fulano", "desc", 250.3, -30.027593, -51.227884, -27.597393, -48.552890, 20.1, 30.9);

		assertEquals(t1, t2);
	}

	@Test
	@DisplayName("Deve retornar false se os transportes possuírem números diferentes")
	void testEquals3() {
		Transporte t1 =
			new TransporteCargaViva(1, "fulano", "desc", 250.3, -30.027593, -51.227884, -27.597393, -48.552890, 20.1, 30.9);
		Transporte t2 =
			new TransporteCargaViva(3, "fulano", "desc", 250.3, -30.027593, -51.227884, -27.597393, -48.552890, 20.1, 30.9);

		assertNotEquals(t1, t2);
	}

	@Test
	@DisplayName("Deve retornar false se o objeto comparado for nulo")
	void testEquals4() {
		Transporte t = new TransportePessoal(1, "fulano", "desc", 82.5, 40.714268, -74.005974, 34.0522, -118.2437, 1);
		assertNotEquals(t, null);
	}
}
