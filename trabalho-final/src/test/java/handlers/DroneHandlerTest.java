package handlers;

import dados.Drone;
import dados.DronePessoal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DroneHandlerTest {
	@BeforeEach
	void resetDroneHandler() throws NoSuchFieldException, IllegalAccessException {
		Field handler = DroneHandler.class.getDeclaredField("handler");
		handler.setAccessible(true);
		handler.set(null, null);
	}

	@Test
	@DisplayName("Deve cadastrar novo drone")
	void cadastra1() {
		DroneHandler droneHandler = DroneHandler.getHandler();
		Drone drone = new DronePessoal(1, 2.5, 12, 2);

		assertTrue(droneHandler.cadastra(drone));
	}

	@Test
	@DisplayName("Não deve cadastrar drone repetido")
	void cadastra2() {
		DroneHandler droneHandler = DroneHandler.getHandler();
		Drone drone = new DronePessoal(1, 2.5, 12, 2);

		assertTrue(droneHandler.cadastra(drone));
		assertFalse(droneHandler.cadastra(drone));
	}

	@Test
	@DisplayName("Não deve cadastrar drone nulo")
	void cadastra3() {
		DroneHandler droneHandler = DroneHandler.getHandler();
		assertFalse(droneHandler.cadastra(null));
	}

	@Test
	@DisplayName("Deve retornar uma lista vazia")
	void buscaTodos1() {
		DroneHandler droneHandler = DroneHandler.getHandler();
		List<Drone> lista = droneHandler.buscaTodos();

		assertTrue(lista.isEmpty());
	}

	@Test
	@DisplayName("Deve manter a ordenação por ID")
	void buscaTodos2() {
		DroneHandler droneHandler = DroneHandler.getHandler();
		Drone drone1 = new DronePessoal(1, 2.5, 12, 2);
		Drone drone21 = new DronePessoal(21, 3, 11.9, 1);
		Drone drone42 = new DronePessoal(42, 3.8, 10, 3);
		droneHandler.cadastra(drone42);
		droneHandler.cadastra(drone1);
		droneHandler.cadastra(drone21);

		List<Drone> lista = droneHandler.buscaTodos();

		assertEquals(3, lista.size());
		assertEquals(drone1, lista.get(0));
		assertEquals(drone21, lista.get(1));
		assertEquals(drone42, lista.get(2));
	}
}
