public class Aluguel {
	private int numero;
	private String data;
	private double valor;
	private Roupa roupa;

	public Aluguel(int numero, String data, double valor, Roupa roupa) {
		this.numero = numero;
		this.data = data;
		this.valor = valor;
		this.roupa = roupa;
	}

	public int getNumero() {
		return numero;
	}

	public String getData() {
		return data;
	}

	public double getValor() {
		return valor;
	}

	public Roupa getRoupa() {
		return roupa;
	}
}
