import java.util.ArrayList;

public class Frota {
	private ArrayList<Veiculo> cadastro;

	public Frota() {
		cadastro = new ArrayList<>();
	}

	public boolean addVeiculo(Veiculo v) {
		return cadastro.add(v);
	}

	public Veiculo pesquisaPlaca(String placa) {
		for (Veiculo v : cadastro) {
			if (v.getPlaca().equals(placa)) {
				return v;
			}
		}
		return null;
	}
}
