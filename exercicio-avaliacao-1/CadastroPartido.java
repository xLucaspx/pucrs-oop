import java.util.ArrayList;

/**
 * Classe catalogo que gerencia o cadastro de partidos.
 */
public class CadastroPartido {
	private ArrayList<Partido> partidos;

	/**
	 * Cadastra um novo partido no sistema. Não pode haver partidos com o mesmo numero.
	 *
	 * @param p O partido que sera cadastrado.
	 * @return <code>true</code> caso o cadastro tenha sido bem-sucedido, <code>false</code>
	 * caso contrario.
	 */
	public boolean cadastraPartido(Partido p) {
		// TODO: implement method
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/**
	 * Busca um partido pelo nome indicado.
	 *
	 * @param nome O nome do partido buscado.
	 * @return O primeiro partido encontrado com nome igual ao passado como argumento,
	 * ou <code>null</code> caso não encontre nenhum partido com esse nome.
	 */
	public Partido consultaPartido(String nome) {
		// TODO: implement method
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/**
	 * Busca um partido pelo numero indicado.
	 *
	 * @param numero O numero do partido buscado.
	 * @return O partido de numero correspondente, ou <code>null</code> caso não encontre
	 * nenhum partido com este numero.
	 */
	public Partido consultaPartido(int numero) {
		// TODO: implement method
		throw new UnsupportedOperationException("Not supported yet.");
	}
}