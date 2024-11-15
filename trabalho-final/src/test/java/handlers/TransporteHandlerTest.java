package handlers;

import dados.Drone;
import dados.DroneCargaInanimada;
import dados.DroneCargaViva;
import dados.DronePessoal;
import dados.Transporte;
import dados.TransporteCargaInanimada;
import dados.TransporteCargaViva;
import dados.TransportePessoal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TransporteHandlerTest {
	private final List<Drone> drones = List.of(new DronePessoal(1, 10, 100, 5),
		new DroneCargaInanimada(2, 20, 200, 200, true),
		new DroneCargaViva(3, 30, 400, 300, true)
	);
	private final Transporte t1 =
		new TransportePessoal(1, "fulano", "desc", 140.1, -30.027190, -51.161572, -30.061458, -51.173695, 2);
	private final Transporte t2 =
		new TransporteCargaInanimada(2, "fulano", "desc", 150.2, -29.378867, -50.873611, -30.027190, -51.161572, true);
	private final Transporte t3 =
		new TransporteCargaViva(3, "fulano", "desc", 250.3, -30.027593, -51.227884, -27.597393, -48.552890, 20.1, 30.9);
	private final Transporte t4 =
		new TransportePessoal(4, "fulano", "desc", 82.5, 40.714268, -74.005974, 34.0522, -118.2437, 1);

	@BeforeEach
	void resetTransporteHandler() throws NoSuchFieldException, IllegalAccessException {
		Field handler = TransporteHandler.class.getDeclaredField("handler");
		handler.setAccessible(true);
		handler.set(null, null);
	}

	@Test
	@DisplayName("Deve cadastrar novo transporte")
	void cadastra1() {
		TransporteHandler transporteHandler = TransporteHandler.getHandler();
		assertTrue(transporteHandler.cadastra(t1));
	}

	@Test
	@DisplayName("Não deve cadastrar drone repetido")
	void cadastra2() {
		TransporteHandler transporteHandler = TransporteHandler.getHandler();

		assertTrue(transporteHandler.cadastra(t1));
		assertFalse(transporteHandler.cadastra(t1));
	}

	@Test
	@DisplayName("Não deve cadastrar drone nulo")
	void cadastra3() {
		TransporteHandler transporteHandler = TransporteHandler.getHandler();
		assertFalse(transporteHandler.cadastra(null));
	}

	@Test
	@DisplayName("Deve retornar uma lista vazia")
	void buscaTodos1() {
		TransporteHandler transporteHandler = TransporteHandler.getHandler();
		List<Transporte> lista = transporteHandler.buscaTodos();

		assertTrue(lista.isEmpty());
	}

	@Test
	@DisplayName("Deve retornar os transportes cadastrados")
	void buscaTodos2() {
		TransporteHandler transporteHandler = TransporteHandler.getHandler();

		transporteHandler.cadastra(t1);
		transporteHandler.cadastra(t2);
		transporteHandler.cadastra(t3);
		transporteHandler.cadastra(t4);

		List<Transporte> lista = transporteHandler.buscaTodos();

		assertTrue(lista.containsAll(List.of(t1, t2, t3, t4)));
		assertEquals(4, transporteHandler.getTotalPendentes());
	}

	@Test
	@DisplayName("Deve retornar false se não existirem transportes pendentes")
	void processaPendentes1() {
		TransporteHandler transporteHandler = TransporteHandler.getHandler();
		assertFalse(transporteHandler.processaPendentes(drones));
		assertEquals(0, transporteHandler.getTotalPendentes());
	}

	@Test
	@DisplayName("Deve retornar true após processar transportes pendentes")
	void processaPendentes2() {
		TransporteHandler transporteHandler = TransporteHandler.getHandler();

		transporteHandler.cadastra(t1);
		transporteHandler.cadastra(t2);
		transporteHandler.cadastra(t3);
		transporteHandler.cadastra(t4);

		assertTrue(transporteHandler.processaPendentes(drones));
	}

	@Test
	@DisplayName("Deve processar todos os transportes")
	void processaPendentes3() {
		TransporteHandler transporteHandler = TransporteHandler.getHandler();

		transporteHandler.cadastra(t1);
		transporteHandler.cadastra(t2);
		transporteHandler.cadastra(t3);

		assertEquals(3, transporteHandler.getTotalPendentes());
		assertTrue(transporteHandler.processaPendentes(drones));
		assertEquals(0, transporteHandler.getTotalPendentes());
		assertFalse(transporteHandler.processaPendentes(drones));
	}

	@Test
	@DisplayName("Não deve processar todos os transportes")
	void processaPendentes4() {
		TransporteHandler transporteHandler = TransporteHandler.getHandler();

		transporteHandler.cadastra(t1);
		transporteHandler.cadastra(t2);
		transporteHandler.cadastra(t3);
		transporteHandler.cadastra(t4);

		assertEquals(4, transporteHandler.getTotalPendentes());
		assertTrue(transporteHandler.processaPendentes(drones));
		assertEquals(1, transporteHandler.getTotalPendentes());
		assertTrue(transporteHandler.processaPendentes(drones));
		assertEquals(1, transporteHandler.getTotalPendentes());
	}

	@Test
	@DisplayName("Deve retornar o transporte correspondente")
	void buscaPorNumero1() {
		TransporteHandler transporteHandler = TransporteHandler.getHandler();

		transporteHandler.cadastra(t1);
		transporteHandler.cadastra(t2);
		transporteHandler.cadastra(t3);

		assertEquals(t2, transporteHandler.buscaPorNumero(t2.getNumero()));
	}

	@Test
	@DisplayName("Deve retornar null se não houver correspondência")
	void buscaPorNumero2() {
		TransporteHandler transporteHandler = TransporteHandler.getHandler();

		transporteHandler.cadastra(t1);
		transporteHandler.cadastra(t2);

		assertNull(transporteHandler.buscaPorNumero(t4.getNumero()));
	}

	@Test
	@DisplayName("Deve retornar null se a lista estiver vazia")
	void buscaPorNumero3() {
		TransporteHandler transporteHandler = TransporteHandler.getHandler();
		assertNull(transporteHandler.buscaPorNumero(t4.getNumero()));
	}
}
