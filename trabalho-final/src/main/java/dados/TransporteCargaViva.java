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
	 * Inicializa um objeto {@link TransporteCargaViva}.
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
		return "{ %s, temperaturaMinima: %.1f, temperaturaMaxima: %.1f }".formatted(super.toString(),
			temperaturaMinima,
			temperaturaMaxima
		);
	}
}
