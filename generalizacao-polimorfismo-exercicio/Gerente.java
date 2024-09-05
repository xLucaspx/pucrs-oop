public class Gerente extends Funcionario {
	private String setor;
	private double adicionalSalario;

	public Gerente(String nome, double salarioBase, double descontos, String setor, double adicionalSalario) {
		super(nome, salarioBase, descontos);
		this.setor = setor;
		this.adicionalSalario = adicionalSalario;
	}

	@Override
	public double calculaSalario() {
		double salario = super.calculaSalario();
		return salario + adicionalSalario;
	}

	@Override
	public double calculaImposto() {
		double salario = calculaSalario();
		if (salario <= 1000) return 0;
		else return salario * 0.25;
	}

	@Override
	public String geraDescricao() {
		String descricao = super.geraDescricao();
		descricao += "Setor: " + setor + "\n";
		descricao += "Adicional de salario: " + adicionalSalario + "\n";
		return descricao;
	}
}
