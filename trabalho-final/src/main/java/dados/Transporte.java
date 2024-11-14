package dados;

import java.util.Objects;

/**
 * Classe que representa transportes que são
 * realizados por {@link Drone drones}.
 *
 * @author Lucas da Paz
 */
public abstract class Transporte {
	private int numero;
	private String nomeCliente;
	private String descricao;
	private double peso;
	private double latitudeOrigem;
	private double longitudeOrigem;
	private double latitudeDestino;
	private double longitudeDestino;
	private Estado situacao;
	private Drone drone;

	/**
	 * Inicializa um objeto {@link Transporte} com os valores informados
	 * e com a situação {@link Estado#PENDENTE PENDENTE}.
	 *
	 * @param numero           O número do transporte.
	 * @param nomeCliente      O nome do cliente associado ao transporte.
	 * @param descricao        A descrição do transporte.
	 * @param peso             O peso do transporte.
	 * @param latitudeOrigem   A latitude de origem do transporte.
	 * @param longitudeOrigem  A longitude de origem do transporte.
	 * @param latitudeDestino  A latitude de destino do transporte.
	 * @param longitudeDestino A longitude de destino do transporte.
	 */
	public Transporte(int numero, String nomeCliente, String descricao, double peso, double latitudeOrigem,
		double longitudeOrigem, double latitudeDestino, double longitudeDestino) {
		this.numero = numero;
		this.nomeCliente = nomeCliente;
		this.descricao = descricao;
		this.peso = peso;
		this.latitudeOrigem = latitudeOrigem;
		this.longitudeOrigem = longitudeOrigem;
		this.latitudeDestino = latitudeDestino;
		this.longitudeDestino = longitudeDestino;
		this.situacao = Estado.PENDENTE;
	}

	/**
	 * @return A situação atual deste {@link Transporte}.
	 */
	public Estado getSituacao() {
		return situacao;
	}

	/**
	 * @return O peso deste {@link Transporte}.
	 */
	public double getPeso() {
		return peso;
	}

	/**
	 * Associa ao {@link Transporte} uma instância de {@link Drone}
	 * e altera sua situação para {@link Estado#ALOCADO ALOCADO}. Caso
	 * o transporte não esteja na situação {@link Estado#PENDENTE PENDENTE}
	 * — i.e., caso já possua um drone ou caso já tenha sido finalizado —
	 * nenhuma ação ocorrerá.
	 *
	 * @param drone O drone que será associado ao transporte.
	 */
	public void setDrone(Drone drone) {
		if (!situacao.equals(Estado.PENDENTE)) {
			return;
		}
		this.drone = drone;
		situacao = Estado.ALOCADO;
	}

	/**
	 * Define a situação deste {@link Transporte} como
	 * {@link Estado#TERMINADO TERMINADO} e faz com que ele não possa
	 * mais ser alterado. Caso o transporte não esteja com a situação
	 * {@link Estado#ALOCADO ALOCADO}, nenhuma ação ocorrerá.
	 */
	public void terminar() {
		if (!situacao.equals(Estado.ALOCADO)) {
			return;
		}
		situacao = Estado.TERMINADO;
	}

	/**
	 * Define a situação deste {@link Transporte} como
	 * {@link Estado#CANCELADO CANCELADO} e faz com que ele não possa
	 * mais ser alterado. Caso o transporte já tenha sido finalizado —
	 * i.e., sua situação for {@link Estado#TERMINADO TERMINADO} ou
	 * {@link Estado#CANCELADO CANCELADO} — nenhuma ação ocorrerá.
	 */
	public void cancelar() {
		if (situacao.equals(Estado.TERMINADO) || situacao.equals(Estado.CANCELADO)) {
			return;
		}
		situacao = Estado.CANCELADO;
	}

	/**
	 * Calcula o custo final deste {@link Transporte} somando o
	 * valor base do transporte (i.e. custo por KM do {@link Drone}
	 * multiplicado pela distância) com custos variáveis.
	 *
	 * @return O custo final deste transporte.
	 * @see #getValorBase()
	 * @see #getDistancia()
	 */
	public abstract double calculaCusto();

	/**
	 * Calcula o valor base deste {@link Transporte} multiplicando
	 * o custo por KM do {@link Drone} pela distância do transporte.
	 * Se o transporte estivar com a situação {@link Estado#PENDENTE PENDENTE},
	 * o valor retornado será zero (pois nenhum drone foi alocado).
	 *
	 * @return O valor base deste transporte, sem a adição de acréscimos.
	 * @see #calculaCusto()
	 * @see #getDistancia()
	 */
	public double getValorBase() {
		if (situacao.equals(Estado.PENDENTE)) {
			return 0;
		}

		return getDistancia() * drone.calculaCustoKm();
	}

	/**
	 * Calcula a distância em KM do transporte com base nas coordenadas
	 * de origem e de destino. Utiliza a fórmula de Haversine, que assume
	 * a Terra como uma esfera perfeita; sendo assim, para longas distâncias
	 * há uma margem de erro de, aproximadamente, 0.5%.
	 *
	 * @return A distância em KM do transporte.
	 */
	public double getDistancia() {
		double distLat = Math.toRadians(latitudeDestino - latitudeOrigem);
		double distLong = Math.toRadians(longitudeDestino - longitudeOrigem);
		double latOrigem = Math.toRadians(latitudeOrigem);
		double latDestino = Math.toRadians(latitudeDestino);
		double haversineDistLat = Math.pow(Math.sin(distLat / 2), 2);
		double haversineDistLong = Math.pow(Math.sin(distLong / 2), 2);
		double raioTerra = 6371;
		double a = haversineDistLat + Math.cos(latOrigem) * Math.cos(latDestino) * haversineDistLong;
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		return raioTerra * c;
	}

	/**
	 * @return Inteiro que representa esta instância de {@link Transporte},
	 * conforme a definição do método {@link #equals} desta classe.
	 * @see Objects#hashCode(Object)
	 */
	@Override
	public int hashCode() {
		return Objects.hashCode(numero);
	}

	/**
	 * Compara esta instância de {@link Transporte} com o objeto passado como argumento.
	 *
	 * @param o O objeto que será comparado.
	 * @return {@code true} caso o objeto passado como argumento seja uma instancia de
	 * {@code Transporte} e o número de ambos os objetos comparados seja igual, {@code false}
	 * caso contrario.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Transporte t)) return false;
		return numero == t.numero;
	}

	/**
	 * @return Representação deste {@link Transporte} em formato de string.
	 */
	@Override
	public String toString() {
		return "numero: %d, cliente: %s, descricao: %s, peso: %.2f KG, distancia: %.2f KM, custo: R$ %.2f, situacao: %s".formatted(
			numero,
			nomeCliente,
			descricao,
			peso,
			getDistancia(),
			calculaCusto(),
			situacao.toString()
		);
	}
}
