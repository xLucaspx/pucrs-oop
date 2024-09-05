public class VeiculoEletrico extends Veiculo {

	private double cargaBateria;

	public VeiculoEletrico(String placa, double valor, double cargaBateria) {
		super(placa, valor);
		this.cargaBateria = cargaBateria;
	}

	public double getCargaBateria() {
		return cargaBateria;
	}

	@Override
	public double calculaIPVA() {
		return 0;
	}

	@Override
	public String toString() {
		var prev = super.toString();
		prev += "Carga da bateria %.1f%n".formatted(cargaBateria);
		return prev;
	}
}
