package dados;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DroneTest {
	@Test
	@DisplayName("Deve retornar inteiro < 0 se o drone que chamou o método for menor")
	void compareTo1() {
		Drone d1 = new DronePessoal(1, 2.4, 10, 2);
		Drone d2 = new DroneCargaInanimada(10, 2.4, 10, 2, false);

		assertTrue(d1.compareTo(d2) < 0);
	}

	@Test
	@DisplayName("Deve retornar 0 se os objetos forem os mesmos")
	void compareTo2() {
		Drone d1 = new DronePessoal(1, 2.4, 10, 2);
		Drone d2 = d1;

		assertEquals(0, d1.compareTo(d2));
	}

	@Test
	@DisplayName("Deve retornar 0 se os drones possuírem o mesmo código")
	void compareTo3() {
		Drone d1 = new DronePessoal(1, 2.4, 10, 2);
		Drone d2 = new DroneCargaInanimada(1, 3.9, 8, 25, false);

		assertEquals(0, d1.compareTo(d2));
	}

	@Test
	@DisplayName("Deve retornar inteiro > 0 se o drone que chamou o método for maior")
	void compareTo4() {
		Drone d1 = new DronePessoal(1, 2.4, 10, 2);
		Drone d2 = new DroneCargaInanimada(10, 2.4, 10, 2, false);

		assertTrue(d2.compareTo(d1) > 0);
	}

	@Test
	@DisplayName("Deve retornar true se os objetos forem os mesmos")
	void testEquals1() {
		Drone d1 = new DronePessoal(1, 2.4, 10, 2);
		Drone d2 = d1;

		assertEquals(d1, d2);
	}

	@Test
	@DisplayName("Deve retornar true se os drones possuírem o mesmo código")
	void testEquals2() {
		Drone d1 = new DronePessoal(1, 2.4, 10, 2);
		Drone d2 = new DroneCargaInanimada(1, 3.9, 8, 25, false);

		assertEquals(d1, d2);
	}

	@Test
	@DisplayName("Deve retornar false se os drones possuírem códigos diferentes")
	void testEquals3() {
		Drone d1 = new DronePessoal(1, 2.4, 10, 2);
		Drone d2 = new DroneCargaInanimada(10, 2.4, 10, 2, false);

		assertNotEquals(d1, d2);
	}

	@Test
	@DisplayName("Deve retornar false se o objeto comparado for nulo")
	void testEquals4() {
		Drone d = new DroneCargaInanimada(10, 2.4, 10, 2, false);
		assertNotEquals(d, null);
	}
}
