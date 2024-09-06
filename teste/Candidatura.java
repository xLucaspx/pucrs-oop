import java.util.List;

/**
 * Classe catalogo que gerencia o cadastro de candidatos.
 */
public class Candidatura {

	private Candidato[] candidato;

	private MunicipioVotos municipioVotos;

	/**
	 * Inicializa um objeto do tipo <code>Candidatura</code>.
	 */
	public Candidatura() {

	}

	/**
	 * Cadastra um novo candidato no sistema. Não pode haver candidatos com o
	 * mesmo numero no mesmo municipio.
	 * 
	 * @param c O candidato que sera cadastrado.
	 * @return <code>true</code> caso o cadastro tenha sido bem-sucedido, <code>false</code>
	 * caso contrario.
	 */
	public boolean cadastraCandidato(Candidato c) {
		return false;
	}

	/**
	 * Busca um candidato pelo numero e municipio indicados.
	 * 
	 * @param numero    O numero do candidato buscado.
	 * @param municipio O municipio da candidatura.
	 * @return O candidato com os atributos correspondentes, ou <code>null</code> caso não encontre
	 * nenhum candidato.
	 */
	public Candidato consultaCandidato(int numero, String municipio) {
		return null;
	}

	/**
	 * Busca o(s) candidato(s) com maior quantidade de votos para prefeito. A lista tera mais de um elemento
	 * se e somente se qualquer <code>Candidato</code> da lista tiver a mesma quantidade de votos. No caso de
	 * nao haver candidatos ou nao haver candidatos com votos, a lista estara vazia.
	 * 
	 * @return Lista nao modificavel contendo os candidatos com maior quantidade de votos para prefeito, ou
	 * vazia caso nao existam candidatos.
	 */
	public List getPrefeitosMaisVotados() {
		return null;
	}

	/**
	 * Busca o(s) candidato(s) com maior quantidade de votos para vereador. A lista tera mais de um elemento
	 * se e somente se qualquer <code>Candidato</code> da lista tiver a mesma quantidade de votos. No caso de
	 * nao haver candidatos ou nao haver candidatos com votos, a lista estara vazia.
	 * 
	 * @return Lista nao modificavel contendo os candidatos com maior quantidade de votos para vereador, ou
	 * vazia caso nao existam candidatos.
	 */
	public List getVereadoresMaisVotados() {
		return null;
	}

	/**
	 * Busca o(s) municipio(s) com maior quantidade de votos. A lista tera mais de um elemento se e somente se qualquer
	 * municipio da lista tiver a mesma quantidade de votos. No caso de nao existir candidatos ou de nao existir
	 * candidatos com votos, a lista estara vazia.
	 * 
	 * @return Objeto <code>MunicipioVotos</code> que agrupa a lista nao modificavel com os nomes dos municipios com
	 * maior quantidade de votos (ou vazia caso nao existam candidatos ou nao existam candidatos com votos) e a
	 * quantidade de votos.
	 */
	public MunicipioVotos getMunicipiosComMaisVotos() {
		return null;
	}

	/**
	 * Busca, no <code>Set</code> de candidatos, pelos que possuem a maior quantidade de votos. Os criterios
	 * de busca serao os numeros passados como argumento, delimitando quais os candidatos buscados. A lista tera
	 * mais de um elemento se e somente se qualquer <code>Candidato</code> da lista tiver a mesma quantidade de
	 * votos. No caso de nao haver candidatos ou nao haver candidatos com votos, a lista estara vazia.
	 * 
	 * @param numeroMinimo <strong>Inclusivo</strong>. O numero minimo do candidato para ser considerado na busca.
	 * @param numeroMaximo <strong>Exclusivo</strong>. O numero maximo do candidato para ser considerado na busca.
	 * @return Os cadidatos mais votados e que tenham numero entre <code>numeroMinimo</code> e
	 * <code>numeroMaximo - 1</code>.
	 */
	private List getCandidatosMaisVotados() {
		return null;
	}

}
