package dados;

import validacoes.ValidadorDroneTransporte;
import validacoes.ValidadorMaximoPessoas;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa {@link Drone drones} utilizados para a
 * realização de {@link TransportePessoal}.
 *
 * @author Lucas da Paz
 */
public class DronePessoal extends Drone {
	private int qtdMaxPessoas;

	/**
	 * Inicializa um objeto {@link DronePessoal}.
	 *
	 * @param codigo        O código do drone.
	 * @param custoFixo     O custo fixo (por KM) do drone.
	 * @param autonomia     A autonomia de voo (em KM) do drone.
	 * @param qtdMaxPessoas O máximo de pessoas que o drone pode transportar.
	 */
	public DronePessoal(int codigo, double custoFixo, double autonomia, int qtdMaxPessoas) {
		super(codigo, custoFixo, autonomia);
		this.qtdMaxPessoas = qtdMaxPessoas;
	}

	/**
	 * @return A quantidade máxima de pessoas que pode
	 * ser transportada por este {@link DronePessoal}.
	 */
	public int getQtdMaxPessoas() {
		return qtdMaxPessoas;
	}

	/**
	 * {@inheritDoc} Para uma instância de {@link DronePessoal}, o custo
	 * variável é calculado com base na quantidade máxima de pessoas, i.e.,
	 * quanto maior a quantidade de pessoas, maior o custo.
	 *
	 * @return {@inheritDoc}
	 */
	@Override
	public double calculaCustoKm() {
		return getCustoFixo() + (2 * qtdMaxPessoas);
	}

	@Override
	public boolean adicionaTransporte(Transporte t) {
		List<ValidadorDroneTransporte> validacoes = new ArrayList<>(List.of(new ValidadorMaximoPessoas()));
		for (var v : validacoes) {
			if (!v.valida(this, t)) {
				return false;
			}
		}
		return super.adicionaTransporte(t);
	}

	@Override
	public String toString() {
		return """
			Drone Pessoal:
			%s
			\t* Máximo de pessoas: %d;""".formatted(super.toString(), qtdMaxPessoas);
	}

	@Override
	public String toCSV() {
		return "1;%s;%d".formatted(super.toCSV(), qtdMaxPessoas);
	}

	@Override
	public String toJSON() {
		return """
			\t\t\t"%s": {
			%s,
			\t\t\t\t"qtdMaxPessoas": %d
			\t\t\t}""".formatted(this.getClass().getSimpleName(), super.toJSON(), qtdMaxPessoas);
	}
}
