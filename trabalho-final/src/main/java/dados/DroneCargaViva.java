package dados;

/**
 * Classe que representa {@link Drone drones} utilizados para a
 * realização de {@link TransporteCargaViva}.
 *
 * @author Lucas da Paz
 */
public class DroneCargaViva extends DroneCarga {
	private boolean climatizado;

	/**
	 * Inicializa um objeto {@link DroneCargaViva}.
	 *
	 * @param codigo      O código do drone.
	 * @param custoFixo   O custo fixo (por KM) do drone.
	 * @param autonomia   A autonomia de voo (em KM) do drone.
	 * @param pesoMaximo  O peso máximo (em KG) que o drone pode transportar.
	 * @param climatizado Se o drone possui climatização.
	 */
	public DroneCargaViva(int codigo, double custoFixo, double autonomia, double pesoMaximo, boolean climatizado) {
		super(codigo, custoFixo, autonomia, pesoMaximo);
		this.climatizado = climatizado;
	}

	/**
	 * {@inheritDoc} Para uma instância de {@link DroneCargaViva},
	 * o custo variável depende da climatização, i.e., drones climatizados
	 * possuem um acréscimo maior do que drones não climatizados.
	 *
	 * @return {@inheritDoc}
	 */
	@Override
	public double calculaCustoKm() {
		return getCustoFixo() + (climatizado ? 20 : 10);
	}

	@Override
	public String toString() {
		return """
			Drone de Carga Viva:
			%s
			\t* Climatizado: %s;""".formatted(super.toString(), climatizado ? "Sim" : "Não");
	}

	@Override
	public String toCSV() {
		return "3;%s;%b".formatted(super.toCSV(), climatizado);
	}

	@Override
	public String toJSON() {
		return """
			\t\t{
			\t\t\t"tipo": 3,
			%s,
			\t\t\t"climatizado": %b
			\t\t}""".formatted(super.toJSON(), climatizado);
	}

	@Override
	public String toXML() {
		return """
			\t\t<drone>
			\t\t\t<tipo>3</tipo>
			%s
			\t\t\t<climatizado>%b</climatizado>
			\t\t</drone>""".formatted(super.toXML(), climatizado);
	}
}
