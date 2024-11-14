package dados;

/**
 * Classe que representa um {@link Transporte} de pessoas.
 *
 * @author Lucas da Paz
 */
public class TransportePessoal extends Transporte {
	private int qtdPessoas;

	/**
	 * Inicializa um objeto {@link TransportePessoal}.
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
		return "{ %s, qtdPessoas: %d }".formatted(super.toString(), qtdPessoas);
	}
}