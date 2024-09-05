public class Veiculo {
	public static final double TAXA = 0.3;
	private String placa;
	private double valor;

	public Veiculo(String placa, double valor) {
		this.placa = placa;
		this.valor = valor;
	}

	public String getPlaca() {
		return placa;
	}

	public double getValor() {
		return valor;
	}

	/**
	 * Calculo do valor do imposto IPVA
	 *
	 * @return valor do IPVA
	 */
	public double calculaIPVA() {
		return valor * TAXA;
	}

	/**
	 * Gera string com a descrição do veículo
	 *
	 * @return descrição do veículo
	 */
	@Override
	public String toString() {
		String desc = "";
		desc += "Placa: " + placa + "\n";
		desc += "Valor: " + valor + "\n";
		desc += "Imposto: " + calculaIPVA() + "\n";
		return desc;
	}
}
