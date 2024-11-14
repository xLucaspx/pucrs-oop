import aplicacao.ACMEAirDrones;
import dados.Drone;
import dados.DroneCargaInanimada;
import dados.DroneCargaViva;
import dados.DronePessoal;
import dados.Transporte;
import dados.TransporteCargaInanimada;
import dados.TransporteCargaViva;
import dados.TransportePessoal;
import handlers.DroneHandler;
import handlers.TransporteHandler;

public class Main {
	public static void main(String[] args) {
		new ACMEAirDrones().executar();

		Transporte t1 =
			new TransportePessoal(1, "fulano", "desc", 140.1, -30.027190, -51.161572, -30.061458, -51.173695, 2);
		Transporte t2 =
			new TransporteCargaInanimada(2, "fulano", "desc", 150.2, -29.378867, -50.873611, -30.027190, -51.161572, true);
		Transporte t3 =
			new TransporteCargaViva(3, "fulano", "desc", 250.3, -30.027593, -51.227884, -27.597393, -48.552890, 20.1, 30.9);
		Transporte t4 = new TransportePessoal(4, "fulano", "desc", 82.5, 40.714268, -74.005974, 34.0522, -118.2437, 1);

		Drone d1 = new DronePessoal(1, 10, 100, 5);
		Drone d2 = new DroneCargaInanimada(2, 20, 200, 200, true);
		Drone d3 = new DroneCargaViva(3, 30, 400, 300, true);

		var dh = new DroneHandler();
		var th = new TransporteHandler();

		dh.cadastra(d1);
		dh.cadastra(d3);
		dh.cadastra(d2);

		th.cadastra(t1);
		th.cadastra(t2);
		th.cadastra(t3);
		th.cadastra(t4);

		th.processaPendentes(dh.buscaTodos());
	}
}
