package dados;

public class DronePessoal extends Drone {
	private int qtdMaxPessoas;

	public DronePessoal(int codigo, double custoFixo, double autonomia, int qtdMaxPessoas) {
		super(codigo, custoFixo, autonomia);
		this.qtdMaxPessoas = qtdMaxPessoas;
	}

	@Override
	public double calculaCustoKm() {
		return getCustoFixo() + (2 * qtdMaxPessoas);
	}

	@Override
	public String toString() {
		return "{ %s, maxPessoas: %d }".formatted(super.toString(), qtdMaxPessoas);
	}
}
