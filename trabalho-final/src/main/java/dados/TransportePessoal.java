package dados;

/**
 * Classe que representa um {@link Transporte} de pessoas.
 *
 * @author Lucas da Paz
 */
public class TransportePessoal extends Transporte {
	private int qtdPessoas;

	/**
	 * Inicializa um objeto {@link TransportePessoal} com os
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
	 * @param qtdPessoas       A quantidade de pessoas que serão transportadas.
	 */
	public TransportePessoal(int numero, String nomeCliente, String descricao, double peso, double latitudeOrigem,
		double longitudeOrigem, double latitudeDestino, double longitudeDestino, int qtdPessoas) {
		super(numero, nomeCliente, descricao, peso, latitudeOrigem, longitudeOrigem, latitudeDestino, longitudeDestino);
		this.qtdPessoas = qtdPessoas;
	}

	/**
	 * @return A quantidade de pessoas deste {@link TransportePessoal}.
	 */
	public int getQtdPessoas() {
		return qtdPessoas;
	}

	/**
	 * {@inheritDoc} Para uma instância de {@link TransportePessoal}, o
	 * acréscimo é calculado com base na quantidade de pessoas, i.e.,
	 * quanto maior a quantidade de pessoas, maior o custo.
	 *
	 * @return {@inheritDoc}
	 */
	@Override
	public double calculaCusto() {
		return getValorBase() + (qtdPessoas * 10);
	}

	@Override
	public String toString() {
		return """
			Transporte Pessoal:
			%s
			\t* Quantidade de pessoas: %d""".formatted(super.toString(), qtdPessoas);
	}

	@Override
	public String toCSV() {
		return "1;%s;%d;%s;%d".formatted(super.toCSV(),
			qtdPessoas,
			getSituacao(),
			getDrone() == null ? 0 : getDrone().getCodigo()
		);
	}

	@Override
	public String toJSON() {
		return """
			\t\t{
			\t\t\t"tipo": 1,
			%s,
			\t\t\t"qtdPessoas": %d
			\t\t}""".formatted(super.toJSON(), qtdPessoas);
	}

	@Override
	public String toXML() {
		return """
			\t\t<transporte>
			\t\t\t<tipo>1</tipo>
			%s
			\t\t\t<qtdPessoas>%d</qtdPessoas>
			\t\t</transporte>""".formatted(super.toXML(), qtdPessoas);
	}
}
