package dados;

/**
 * Classe que representa um {@link Transporte} de carga inanimada.
 *
 * @author Lucas da Paz
 */
public class TransporteCargaInanimada extends Transporte {
	private boolean cargaPerigosa;

	/**
	 * Inicializa um objeto {@link TransporteCargaInanimada} com os
	 * valores informados e com a situação {@link Estado#PENDENTE PENDENTE}.
	 *
	 * @param numero           O número do transporte.
	 * @param nomeCliente      O nome do cliente associado ao transporte.
	 * @param descricao        A descrição do transporte.
	 * @param peso             O peso do transporte.
	 * @param latitudeOrigem   A latitude de origem do transporte.
	 * @param longitudeOrigem  A longitude de origem do transporte.
	 * @param latitudeDestino  A latitude de destino do transporte.
	 * @param longitudeDestino A longitude de destino do transporte.
	 * @param cargaPerigosa    Se a carga do transporte é perigosa.
	 */
	public TransporteCargaInanimada(int numero, String nomeCliente, String descricao, double peso, double latitudeOrigem,
		double longitudeOrigem, double latitudeDestino, double longitudeDestino, boolean cargaPerigosa) {
		super(numero, nomeCliente, descricao, peso, latitudeOrigem, longitudeOrigem, latitudeDestino, longitudeDestino);
		this.cargaPerigosa = cargaPerigosa;
	}

	/**
	 * @return {@code true} se a carga do transporte é perigosa,
	 * {@code false} caso contrário.
	 */
	public boolean isCargaPerigosa() {
		return cargaPerigosa;
	}

	/**
	 * {@inheritDoc} Para uma instância de {@link TransporteCargaInanimada},
	 * haverá um acréscimo no valor do transporte caso a carga seja perigosa.
	 *
	 * @return {@inheritDoc}
	 */
	@Override
	public double calculaCusto() {
		return getValorBase() + (cargaPerigosa ? 500 : 0);
	}

	@Override
	public String toString() {
		return """
			Transporte de Carga Inanimada:
			%s
			\t* Carga perigosa: %s""".formatted(super.toString(), cargaPerigosa ? "Sim" : "Não");
	}

	@Override
	public String toCSV() {
		return "2;%s;%b;%s;%d".formatted(super.toCSV(),
			cargaPerigosa,
			getSituacao(),
			getDrone() == null ? 0 : getDrone().getCodigo()
		);
	}

	@Override
	public String toJSON() {
		return """
			\t\t{
			\t\t\t"tipo": 2,
			%s,
			\t\t\t"cargaPerigosa": %b
			\t\t}""".formatted(super.toJSON(), cargaPerigosa);
	}

	@Override
	public String toXML() {
		return """
			\t\t<transporte>
			\t\t\t<tipo>2</tipo>
			%s
			\t\t\t<cargaPerigosa>%b</cargaPerigosa>
			\t\t</transporte>""".formatted(super.toXML(), cargaPerigosa);
	}
}
