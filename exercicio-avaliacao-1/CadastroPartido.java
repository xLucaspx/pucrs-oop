import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Classe catalogo que gerencia o cadastro de partidos.
 */
public class CadastroPartido {
	/**
	 * Objeto responsavel por armazenar os partidos cadastrados. Utiliza-se um <code>Set</code>
	 * pois nao deseja-se cadastrar objetos repetidos.
	 */
	private final Set<Partido> partidos;

	/**
	 * Inicializa um objeto do tipo <code>CadastroPartido</code>.
	 */
	public CadastroPartido() {
		this.partidos = new HashSet<>();
	}

	/**
	 * Cadastra um novo partido no sistema. Não pode haver partidos com o mesmo numero.
	 *
	 * @param p O partido que sera cadastrado.
	 * @return <code>true</code> caso o cadastro tenha sido bem-sucedido, <code>false</code>
	 * caso contrario.
	 */
	public boolean cadastraPartido(Partido p) {
		return partidos.add(p);
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
		for (Partido p : partidos) {
			if (p.getNome().equals(nome)) {
				return p;
			}
		}
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
		for (Partido p : partidos) {
			if (p.getNumero() == numero) {
				return p;
			}
		}
		return null;
	}

	/**
	 * Busca o(s) partido(s) com maior quantidade de candidatos. A lista tera mais de um elemento
	 * se e somente se qualquer <code>Partido</code> da lista tiver a mesma quantidade de candidatos.
	 * No caso de nao haver candidatos filiados a nenhum partido, a lista estara vazia.
	 *
	 * @return Lista nao modificavel contendo os partidos com maior quantidade de candidatos cadastrados,
	 * ou vazia caso nao existam candidatos.
	 */
	public List<Partido> getPartidosComMaisCandidatos() {
		List<Partido> maisCandidatos = new ArrayList<>();
		// comecando em 1 pois se a quantidade de candidatos do partido for 0 ele nao entra na lista
		int totalCandidatos = 1;

		for (Partido p : partidos) {
			if (p.getTotalCandidatos() == totalCandidatos) {
				maisCandidatos.add(p);
				continue;
			}

			if (p.getTotalCandidatos() > totalCandidatos) {
				maisCandidatos.clear(); // limpa a lista se encontrar novo maximo
				maisCandidatos.add(p);
				totalCandidatos = p.getTotalCandidatos();
			}
		}

		return Collections.unmodifiableList(maisCandidatos);
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
		List<Partido> maisVotos = new ArrayList<>();
		// comecando em 1 pois se a quantidade de votos do partido for 0 ele nao entra na lista
		int totalVotos = 1;

		for (Partido p : partidos) {
			int votosVereadoresPartido = p.getVereadores().stream().mapToInt(Vereador::getVotos).sum();

			if (votosVereadoresPartido == totalVotos) {
				maisVotos.add(p);
				continue;
			}

			if (votosVereadoresPartido > totalVotos) {
				maisVotos.clear(); // limpa a lista se encontrar novo maximo
				maisVotos.add(p);
				totalVotos = votosVereadoresPartido;
			}
		}

		return new PartidoVotos(Collections.unmodifiableList(maisVotos), maisVotos.isEmpty() ? 0 : totalVotos);
	}

	/**
	 * Objeto que agrupa os dados de um consulta de partidos com a mesma quantidade de votos,
	 * nao levando em consideracao qual o criterio utilizado para comparar os votos.
	 *
	 * @param partidos   Lista de partidos que possuem a mesma quantidade de votos (sem considerar o criterio).
	 * @param totalVotos Quantidade de votos comum a todos os partidos da lista.
	 */
	public record PartidoVotos(List<Partido> partidos, int totalVotos) {}
}
