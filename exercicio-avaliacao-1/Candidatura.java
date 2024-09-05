import java.util.HashSet;
import java.util.Set;

/**
 * Classe catalogo que gerencia o cadastro de candidatos.
 */
public class Candidatura {
	/**
	 * Objeto responsavel por armazenar os candidatos cadastrados. Utiliza-se um <code>Set</code>
	 * pois nao deseja-se cadastrar objetos repetidos.
	 */
	private final Set<Candidato> candidatos;

	/**
	 * Inicializa um objeto do tipo <code>Candidatura</code>.
	 */
	public Candidatura() {
		this.candidatos = new HashSet<>();
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
		return candidatos.add(c);
	}
}
