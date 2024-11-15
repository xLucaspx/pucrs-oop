package aplicacao;

import dados.DroneCargaInanimada;
import dados.DroneCargaViva;
import dados.DronePessoal;
import dados.TransporteCargaInanimada;
import dados.TransporteCargaViva;
import dados.TransportePessoal;
import handlers.DroneHandler;
import handlers.TransporteHandler;
import views.App;

public class ACMEAirDrones {

	public void executar() {
		var dh = DroneHandler.getHandler();
		dh.cadastra(new DronePessoal(1, 10, 100, 5));
		dh.cadastra(new DroneCargaInanimada(2, 20, 200, 200, true));
		dh.cadastra(new DroneCargaViva(3, 30, 400, 300, true));

		var th = TransporteHandler.getHandler();
		th.cadastra(new TransportePessoal(1, "fulano", "desc", 140.1, -30.027190, -51.161572, -30.061458, -51.173695, 2));
		th.cadastra(new TransporteCargaInanimada(2, "fulano", "desc", 150.2, -29.378867, -50.873611, -30.027190, -51.161572, true));
		th.cadastra(new TransporteCargaViva(3, "fulano", "desc", 250.3, -30.027593, -51.227884, -27.597393, -48.552890, 20.1, 30.9));
		th.cadastra(new TransportePessoal(4, "fulano", "desc", 82.5, 40.714268, -74.005974, 34.0522, -118.2437, 1));

		new App();
	}
}
