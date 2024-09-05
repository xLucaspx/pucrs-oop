import java.util.ArrayList;

public class CatalogoAluguel {
	private ArrayList<Aluguel> alugueis;

	public CatalogoAluguel() {
		alugueis = new ArrayList<>();
	}

	/**
	 * Adiciona um aluguel na coleção
	 *
	 * @param aluguel o aluguel a ser adicionado; não pode ser <code>null</code>
	 * @return <code>false</code> caso o aluguel seja <code>null</code>, <code>true</code> caso contrário
	 */
	public boolean adicionaAluguel(Aluguel aluguel) {
		if (aluguel == null) {
			return false;
		}
		return alugueis.add(aluguel);
	}
}
