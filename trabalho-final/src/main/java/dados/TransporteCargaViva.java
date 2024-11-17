package dados;

/**
 * Classe que representa um {@link Transporte} de carga viva.
 *
 * @author Lucas da Paz
 */
public class TransporteCargaViva extends Transporte {
	private double temperaturaMinima;
	private double temperaturaMaxima;

	/**
	 * Inicializa um objeto {@link TransporteCargaViva} com os
	 * valores informados e com a situação {@link Estado#PENDENTE PENDENTE}.
	 *
	 * @param numero            O número do transporte.
	 * @param nomeCliente       O nome do cliente associado ao transporte.
	 * @param descricao         A descrição do transporte.
	 * @param peso              O peso do transporte.
	 * @param latitudeOrigem    A latitude de origem do transporte.
	 * @param longitudeOrigem   A longitude de origem do transporte.
	 * @param latitudeDestino   A latitude de destino do transporte.
	 * @param longitudeDestino  A longitude de destino do transporte.
	 * @param temperaturaMinima A temperatura mínima do transporte.
	 * @param temperaturaMaxima A temperatura máxima do transporte.
	 */
	public TransporteCargaViva(int numero, String nomeCliente, String descricao, double peso, double latitudeOrigem,
		double longitudeOrigem, double latitudeDestino, double longitudeDestino, double temperaturaMinima,
		double temperaturaMaxima) {
		super(numero, nomeCliente, descricao, peso, latitudeOrigem, longitudeOrigem, latitudeDestino, longitudeDestino);
		this.temperaturaMinima = temperaturaMinima;
		this.temperaturaMaxima = temperaturaMaxima;
	}

	/**
	 * Inicializa um objeto {@link TransporteCargaViva} com os
	 * valores informados.
	 *
	 * @param numero            O número do transporte.
	 * @param nomeCliente       O nome do cliente associado ao transporte.
	 * @param descricao         A descrição do transporte.
	 * @param peso              O peso do transporte.
	 * @param latitudeOrigem    A latitude de origem do transporte.
	 * @param longitudeOrigem   A longitude de origem do transporte.
	 * @param latitudeDestino   A latitude de destino do transporte.
	 * @param longitudeDestino  A longitude de destino do transporte.
	 * @param temperaturaMinima A temperatura mínima do transporte.
	 * @param temperaturaMaxima A temperatura máxima do transporte.
	 * @param situacao          O {@link Estado} que representa a situação do drone.
	 * @param drone             O {@link Drone} responsável pelo transporte, se existir.
	 */
	public TransporteCargaViva(int numero, String nomeCliente, String descricao, double peso, double latitudeOrigem,
		double longitudeOrigem, double latitudeDestino, double longitudeDestino, double temperaturaMinima,
		double temperaturaMaxima, Estado situacao, Drone drone) {
		super(numero,
			nomeCliente,
			descricao,
			peso,
			latitudeOrigem,
			longitudeOrigem,
			latitudeDestino,
			longitudeDestino,
			situacao,
			drone
		);
		this.temperaturaMinima = temperaturaMinima;
		this.temperaturaMaxima = temperaturaMaxima;
	}

	/**
	 * {@inheritDoc} Para uma instância de {@link TransporteCargaViva},
	 * haverá um acréscimo no valor do transporte caso o intervalo entre
	 * as temperaturas mínima e máxima for maior do que 10 graus Celsius.
	 *
	 * @return {@inheritDoc}
	 */
	@Override
	public double calculaCusto() {
		double intervaloTemperaturas = temperaturaMaxima - temperaturaMinima;
		return getValorBase() + (intervaloTemperaturas > 10 ? 1000 : 0);
	}

	@Override
	public String toString() {
		return """
			Transporte de Carga Viva:
			%s
			\t* Temperatura mínima: %.1f ºC;
			\t* Temperatura máxima: %.1f ºC;
			\t* Intervalo entre temperaturas: %.1f ºC;""".formatted(super.toString(),
			temperaturaMinima,
			temperaturaMaxima,
			temperaturaMaxima - temperaturaMinima
		);
	}

	@Override
	public String toCSV() {
		return "3;%s;%f;%f;%s;%d".formatted(super.toCSV(),
			temperaturaMinima,
			temperaturaMaxima,
			getSituacao(),
			getDrone() == null ? -1 : getDrone().getCodigo()
		);
	}

	@Override
	public String toJSON() {
		return """
			\t\t\t"%s": {
			%s,
			\t\t\t\t"temperaturaMinima": %f,
			\t\t\t\t"temperaturaMaxima": %f
			\t\t\t}""".formatted(this.getClass().getSimpleName(), super.toJSON(), temperaturaMinima, temperaturaMaxima);
	}
}
