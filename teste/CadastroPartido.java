import java.util.List;

/**
 * Classe catalogo que gerencia o cadastro de partidos.
 */
public class CadastroPartido {

	private Partido[] partido;

	private PartidoVotos partidoVotos;

	/**
	 * Inicializa um objeto do tipo <code>CadastroPartido</code>.
	 */
	public CadastroPartido() {

	}

	/**
	 * Cadastra um novo partido no sistema. Não pode haver partidos com o mesmo numero.
	 * 
	 * @param p O partido que sera cadastrado.
	 * @return <code>true</code> caso o cadastro tenha sido bem-sucedido, <code>false</code>
	 * caso contrario.
	 */
	public boolean cadastraPartido(Partido p) {
		return false;
	}

	/**
	 * Busca um partido pelo nome indicado. Como nao ha restricao no cadastro para nomes
	 * de partidos iguais, ira retornar o primeiro resultado encontrado, mesmo que existam outros.
	 * 
	 * @param nome O nome do partido buscado.
	 * @return O primeiro partido encontrado com nome igual ao passado como argumento,
	 * ou <code>null</code> caso não encontre nenhum partido com esse nome.
	 */
	public Partido consultaPartido(String nome) {
		return null;
	}

	/**
	 * Busca um partido pelo numero indicado.
	 * 
	 * @param numero O numero do partido buscado.
	 * @return O partido de numero correspondente, ou <code>null</code> caso não encontre
	 * nenhum partido com este numero.
	 */
	public Partido consultaPartido(int numero) {
		return null;
	}

	/**
	 * Busca o(s) partido(s) com maior quantidade de candidatos. A lista tera mais de um elemento
	 * se e somente se qualquer <code>Partido</code> da lista tiver a mesma quantidade de candidatos.
	 * No caso de nao haver candidatos filiados a nenhum partido, a lista estara vazia.
	 * 
	 * @return Lista nao modificavel contendo os partidos com maior quantidade de candidatos cadastrados, ou vazia caso nao existam candidatos.
	 */
	public List getPartidosComMaisCandidatos() {
		return null;
	}

	/**
	 * Busca o(s) partido(s) com maior quantidade de votos para vereadores. A lista tera mais de um elemento
	 * se e somente se qualquer <code>Partido</code> da lista tiver a mesma quantidade de votos para vereadores.
	 * No caso de nao existir candidatos filiados a nenhum partido ou de nao existir candidatos vereadores, a lista
	 * estara vazia.
	 * 
	 * @return Objeto <code>PartidoVotos</code> que agrupa a lista nao modificavel com os partidos com maior
	 * quantidade de votos para vereadores (ou vazia caso nao existam candidatos vereadores ou nao existam candidatos
	 * vereadores com votos) e o total de votos.
	 */
	public PartidoVotos getPartidosComMaisVotosDeVereadores() {
		return null;
	}

}
