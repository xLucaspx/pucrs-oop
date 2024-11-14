package dados;

public abstract class Drone implements Comparable<Drone> {
	private int codigo;
	private double custoFixo;
	private double autonomia;

	public Drone(int codigo, double custoFixo, double autonomia) {
		this.codigo = codigo;
		this.custoFixo = custoFixo;
		this.autonomia = autonomia;
	}

	public abstract double calculaCustoKm();

	public double getCustoFixo() {
		return custoFixo;
	}

	@Override
	public int compareTo(Drone d) {
		return codigo - d.codigo;
	}

	@Override
	public String toString() {
		return "codigo: %d, custoFixo: R$ %.2f, autonomia: %.1f Km".formatted(codigo, custoFixo, autonomia);
	}
}
