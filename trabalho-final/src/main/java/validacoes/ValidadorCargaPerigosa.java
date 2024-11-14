package validacoes;

import dados.Drone;
import dados.DroneCargaInanimada;
import dados.Transporte;
import dados.TransporteCargaInanimada;

public class ValidadorCargaPerigosa implements ValidadorDroneTransporte {
	/**
	 * {@inheritDoc} Valida se o drone informado é um
	 * {@link DroneCargaInanimada} e se o transporte é
	 * um {@link TransporteCargaInanimada}; neste caso,
	 * retorna falso apenas se a carga for perigosa e se
	 * o drone não possuir proteção
	 * ({@code cargaPerigosa -> proteção}).
	 *
	 * @param d {@inheritDoc}
	 * @param t {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@Override
	public boolean valida(Drone d, Transporte t) {
		if (!(d instanceof DroneCargaInanimada dc && t instanceof TransporteCargaInanimada tc)) {
			return false;
		}

		return dc.isProtegida() || !tc.isCargaPerigosa();
	}
}
