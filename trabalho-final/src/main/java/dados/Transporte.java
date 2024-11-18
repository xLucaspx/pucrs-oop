package dados;

import formatos.ObjetoCSV;
import formatos.ObjetoJSON;

import java.util.Objects;

/**
 * Classe que representa transportes que são
 * realizados por {@link Drone drones}.
 *
 * @author Lucas da Paz
 */
public abstract class Transporte implements ObjetoJSON, ObjetoCSV {
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
	}

	/**
	 * <p><strong>Este método deve ser utilizado apenas ao carregar
	 * transportes já existentes de um arquivo ou banco de dados.</strong></p>
	 * <p>Define a situação do {@link Transporte} com o valor de {@link Estado}
	 * passado como argumento e, se o {@link Drone} informado for válido,
	 * relaciona-o a este transporte e chama seu método
	 * {@link Drone#carregaTransporte(Transporte) carregaTransporte}.</p>
	 *
	 * @param situacao A situação do transporte.
	 * @param drone    O drone relacionado, se existir.
	 */
	public void carrega(Estado situacao, Drone drone) {
		this.situacao = situacao;
		this.drone = drone;

		if (drone != null) {
			drone.carregaTransporte(this);
		}
	}

	/**
	 * @return O número deste {@link Transporte}.
	 */
	public int getNumero() {
		return numero;
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
	 * Define a situação deste {@link Transporte} como
	 * {@link Estado#TERMINADO TERMINADO} e faz com que ele não possa
	 * mais ser alterado. Caso o transporte não esteja com a situação
	 * {@link Estado#ALOCADO ALOCADO}, nenhuma ação ocorrerá.
	 *
	 * @return {@code true} caso a situação tenha sido alterada,
	 * {@code false} caso contrário.
	 */
	public boolean terminar() {
		if (!situacao.equals(Estado.ALOCADO)) {
			return false;
		}
		situacao = Estado.TERMINADO;
		return true;
	}

	/**
	 * Define a situação deste {@link Transporte} como
	 * {@link Estado#CANCELADO CANCELADO} e faz com que ele não possa
	 * mais ser alterado. Caso o transporte já tenha sido finalizado —
	 * i.e., sua situação for {@link Estado#TERMINADO TERMINADO} ou
	 * {@link Estado#CANCELADO CANCELADO} — nenhuma ação ocorrerá.
	 *
	 * @return {@code true} caso a situação tenha sido alterada,
	 * {@code false} caso contrário.
	 */
	public boolean cancelar() {
		if (situacao.equals(Estado.TERMINADO) || situacao.equals(Estado.CANCELADO)) {
			return false;
		}
		situacao = Estado.CANCELADO;
		return true;
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
	 * Se nenhum drone foi alocado, o valor retornado será zero.
	 *
	 * @return O valor base deste transporte, sem a adição de acréscimos.
	 * @see #calculaCusto()
	 * @see #getDistancia()
	 */
	public double getValorBase() {
		if (drone == null) {
			return 0;
		}

		return getDistancia() * drone.calculaCustoKm();
	}

	/**
	 * @return O {@link Drone} relacionado com este {@link Transporte},
	 * ou {@code null} se o transporte não estiver relacionado com nenhum
	 * drone, i.e., se a situação for {@link Estado#PENDENTE PENDENTE}.
	 */
	public Drone getDrone() {
		return drone;
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
		return """
			\t* Número: %d;
			\t* Cliente: %s;
			\t* Descrição: %s;
			\t* Peso: %.1f Kg;
			\t* Coordenadas origem: { Latitude: %.6f, Longitude: %.6f };
			\t* Coordenadas destino: { Latitude: %.6f, Longitude: %.6f };
			\t* Distância: %.1f Km;
			\t* Situação: %s;
			\t* Valor base: %s;
			\t* Valor final: %s;
			\t* Acréscimos: R$ %.2f;""".formatted(numero,
			nomeCliente,
			descricao,
			peso,
			latitudeOrigem,
			longitudeOrigem,
			latitudeDestino,
			longitudeDestino,
			getDistancia(),
			situacao,
			drone == null ? "Não é possível calcular" : "R$ %.2f".formatted(getValorBase()),
			drone == null ? "Não é possível calcular" : "R$ %.2f".formatted(calculaCusto()),
			calculaCusto() - getValorBase()
		);
	}

	/**
	 * @return Representação deste {@link Transporte} no formato CSV.
	 */
	@Override
	public String toCSV() {
		return "%d;%s;%s;%f;%f;%f;%f;%f".formatted(numero,
			nomeCliente,
			descricao,
			peso,
			latitudeOrigem,
			longitudeOrigem,
			latitudeDestino,
			longitudeDestino
		);
	}

	/**
	 * @return Representação deste {@link Transporte} no formato JSON.
	 */
	@Override
	public String toJSON() {
		return """
			\t\t\t"numero": %d,
			\t\t\t"nomeCliente": "%s",
			\t\t\t"descricao": "%s",
			\t\t\t"peso": %f,
			\t\t\t"latitudeOrigem": %f,
			\t\t\t"longitudeOrigem": %f,
			\t\t\t"latitudeDestino": %f,
			\t\t\t"longitudeDestino": %f,
			\t\t\t"situacao": "%s",
			\t\t\t"codigoDrone": %d""".formatted(numero,
			nomeCliente,
			descricao,
			peso,
			latitudeOrigem,
			longitudeOrigem,
			latitudeDestino,
			longitudeDestino,
			situacao,
			drone == null ? 0 : drone.getCodigo()
		);
	}
}
