public abstract class Funcionario {
	private String nome;
	private double salarioBase;
	private double descontos;

	public Funcionario(String nome, double salarioBase, double descontos) {
		this.nome = nome;
		this.salarioBase = salarioBase;
		this.descontos = descontos;
	}

	public String getNome() {
		return nome;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public double getDescontos() {
		return descontos;
	}

	public double calculaSalario() {
		return salarioBase - descontos;
	}

	public abstract double calculaImposto();

	public String geraDescricao() {
		String descricao = "";
		descricao += "Nome: " + nome + "\n";
		descricao += "Salario base: " + salarioBase + "\n";
		descricao += "Descontos: " + descontos + "\n";
		descricao += "Salario: " + calculaSalario() + "\n";
		descricao += "Imposto: " + calculaImposto() + "\n";
		return descricao;
	}

}
