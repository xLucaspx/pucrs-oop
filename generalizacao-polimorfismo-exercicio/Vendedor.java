public class Vendedor extends Funcionario {
	private double comissao;

	public Vendedor(String nome, double salarioBase, double descontos, double comissao) {
		super(nome, salarioBase, descontos);
		this.comissao = comissao;
	}

	@Override
	public double calculaSalario() {
		// ( salário base - descontos ) + comissão X ( salário base - descontos )
		double salarioMenosDescontos = getSalarioBase() - getDescontos();
		return (salarioMenosDescontos) + comissao * salarioMenosDescontos;
	}

	@Override
	public double calculaImposto() {
		double salario = calculaSalario();
		if (salario <= 500) {
			return 0;
		} else if (salario <= 2000) {
			return salario * 0.1;
		}
		return salario * 0.2;
	}
}
