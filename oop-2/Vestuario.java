import java.util.ArrayList;

public class Vestuario {

	private ArrayList<Roupa> roupas;

	/**
	 * Construtor
	 */
	public Vestuario() {
		roupas = new ArrayList<>();
	}

	/**
	 * Adiciona uma nova roupa no carrinho
	 *
	 * @param novaRoupa nova roupa a ser cadastrada
	 * @return true se sucesso, false em caso contrario
	 */
	public boolean adicionaRoupa(Roupa novaRoupa) {
		Roupa c = consultaRoupaPorCodigo(novaRoupa.getCodigo());
		if (c != null) {
			return false;
		}

		return roupas.add(novaRoupa);
	}

	/**
	 * Consulta uma roupa a partir de um codigo
	 *
	 * @param codigo codigo da roupa a ser pesquisada
	 * @return Roupa com o codigo indicado, null se nao existir
	 */
	public Roupa consultaRoupaPorCodigo(int codigo) {
		for (int i = 0; i < roupas.size(); i++) {
			Roupa c = roupas.get(i);
			if (c.getCodigo() == codigo) return c;
		}
		return null;
	}

	/**
	 * Retorna uma colecao de roupas com parte do nome da cor
	 *
	 * @param parteNomeCor Parte do nome da cor da roupa
	 * @return colecao de roupas com parte do nome da cor
	 */
	public ArrayList<Roupa> consultaRoupasParteNomeCor(String parteNomeCor) {
		return null;
	}
}
