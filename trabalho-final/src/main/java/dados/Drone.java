package dados;

import validacoes.ValidadorAutonomia;
import validacoes.ValidadorDroneTransporte;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Classe que representa drones utilizados para a
 * realização de {@link Transporte transportes}.
 *
 * @author Lucas da Paz
 */
public abstract class Drone implements Comparable<Drone> {
	private int codigo;
	private double custoFixo;
	private double autonomia;
	private Set<Transporte> transportes;

	/**
	 * Inicializa um objeto {@link Drone}.
	 *
	 * @param codigo    O código do drone.
	 * @param custoFixo O custo fixo (por KM) do drone.
	 * @param autonomia A autonomia de voo (em KM) do drone.
	 */
	public Drone(int codigo, double custoFixo, double autonomia) {
		this.codigo = codigo;
		this.custoFixo = custoFixo;
		this.autonomia = autonomia;
		transportes = new HashSet<>();
	}

	/**
	 * Calcula o custo do KM deste {@link Drone} somando
	 * o custo fixo com o custo variável.
	 *
	 * @return O custo do KM deste drone.
	 */
	public abstract double calculaCustoKm();

	/**
	 * @return O custo fixo (por KM) deste {@link Drone}.
	 */
	public double getCustoFixo() {
		return custoFixo;
	}

	/**
	 * @return A autonomia (em KM) deste {@link Drone}.
	 */
	public double getAutonomia() {
		return autonomia;
	}

	/**
	 * Realiza as validações necessárias e, caso seja possível, aloca o
	 * {@link Transporte} passado como argumento para este {@link Drone},
	 * chamando também o método {@link Transporte#setDrone} do transporte.
	 *
	 * @param t O transporte a ser adicionado.
	 * @return {@code true} caso o transporte seja adicionado com sucesso,
	 * {@code false} caso contrário.
	 */
	public boolean adicionaTransporte(Transporte t) {
		List<ValidadorDroneTransporte> validacoes = new ArrayList<>(List.of(new ValidadorAutonomia()));
		for (var v : validacoes) {
			if (!v.valida(this, t)) {
				return false;
			}
		}
		boolean adicionado = transportes.add(t);
		if (adicionado) {
			t.setDrone(this);
		}

		return adicionado;
	}

	/**
	 * Compara esta instância de {@link Drone} com o drone passado como
	 * argumento para ordem. Utiliza o código para realizar a comparação,
	 * portanto é válido que {@code (x.compareTo(y) == 0) == (x.equals(y))}.
	 *
	 * @param d O drone para ser comparado.
	 * @return Um inteiro negativo, zero ou um inteiro positivo se esta
	 * instância de drone é, respectivamente, menor, igual ou maior do que
	 * o drone passado como argumento.
	 * @throws NullPointerException Se o valor passado como argumento for nulo.
	 * @see Comparable#compareTo
	 */
	@Override
	public int compareTo(Drone d) {
		return codigo - d.codigo;
	}

	/**
	 * @return Inteiro que representa esta instância de {@link Drone}, conforme
	 * a definição do método {@link #equals} desta classe.
	 * @see Objects#hashCode(Object)
	 */
	@Override
	public int hashCode() {
		return Objects.hashCode(codigo);
	}

	/**
	 * Compara esta instância de {@link Drone} com o objeto passado como argumento.
	 *
	 * @param o O objeto que será comparado.
	 * @return {@code true} caso o objeto passado como argumento seja uma instancia de
	 * {@code Drone} e o código de ambos os objetos comparados seja igual, {@code false}
	 * caso contrario.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Drone d)) return false;
		return codigo == d.codigo;
	}

	/**
	 * @return Representação deste {@link Drone} em formato de string.
	 */
	@Override
	public String toString() {
		return "codigo: %d, custoFixo: R$ %.2f, autonomia: %.1f Km".formatted(codigo, custoFixo, autonomia);
	}
}