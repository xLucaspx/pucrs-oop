import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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

	/**
	 * Busca um candidato pelo numero e municipio indicados.
	 *
	 * @param numero    O numero do candidato buscado.
	 * @param municipio O municipio da candidatura.
	 * @return O candidato com os atributos correspondentes, ou <code>null</code> caso não encontre
	 * nenhum candidato.
	 */
	public Candidato consultaCandidato(int numero, String municipio) {
		for (Candidato c : candidatos) {
			if (c.getNumero() == numero && c.getMunicipio().equals(municipio)) {
				return c;
			}
		}
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
	public List<Candidato> getPrefeitosMaisVotados() {
		List<Candidato> prefeitos = getCandidatosMaisVotados(10, 100);
		return Collections.unmodifiableList(prefeitos);
	}

	/**
	 * Busca o(s) candidato(s) com maior quantidade de votos para vereador. A lista tera mais de um elemento
	 * se e somente se qualquer <code>Candidato</code> da lista tiver a mesma quantidade de votos. No caso de
	 * nao haver candidatos ou nao haver candidatos com votos, a lista estara vazia.
	 *
	 * @return Lista nao modificavel contendo os candidatos com maior quantidade de votos para vereador, ou
	 * vazia caso nao existam candidatos.
	 */
	public List<Candidato> getVereadoresMaisVotados() {
		List<Candidato> vereadores = getCandidatosMaisVotados(10000, 100000);
		return Collections.unmodifiableList(vereadores);
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
		// mapeando municipios e votos
		Map<String, Integer> municipios = new HashMap<>();

		for (Candidato c : candidatos) {
			municipios.merge(c.getMunicipio(), c.getVotos(), Integer::sum);
		}

		// buscando municipio com mais votos
		List<String> maisVotos = new ArrayList<>();
		// comecando em 1 pois se a quantidade de votos do municipio for 0 ele nao entra na lista
		int totalVotos = 1;

		for (Map.Entry<String, Integer> e : municipios.entrySet()) {
			int votos = e.getValue();

			if (votos == totalVotos) {
				maisVotos.add(e.getKey());
				continue;
			}

			if (votos > totalVotos) {
				maisVotos.clear();
				maisVotos.add(e.getKey());
				totalVotos = votos;
			}
		}

		return new MunicipioVotos(Collections.unmodifiableList(maisVotos), maisVotos.isEmpty() ? 0 : totalVotos);
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
	private List<Candidato> getCandidatosMaisVotados(int numeroMinimo, int numeroMaximo) {
		List<Candidato> maisVotados = new ArrayList<>();
		// comecando em 1 pois se a quantidade de votos do candidato for 0 ele nao entra na lista
		int totalVotos = 1;

		for (Candidato c : candidatos) {
			if (c.getNumero() < numeroMinimo || c.getNumero() >= numeroMaximo) {
				continue;
			}

			if (c.getVotos() == totalVotos) {
				maisVotados.add(c);
				continue;
			}

			if (c.getVotos() > totalVotos) {
				maisVotados.clear(); // limpa a lista se encontrar novo maximo
				maisVotados.add(c);
				totalVotos = c.getVotos();
			}
		}

		return maisVotados;
	}

	/**
	 * Objeto que agrupa os dados de um consulta de municipios com a mesma quantidade de votos,
	 * nao levando em consideracao qual o criterio utilizado para comparar os votos.
	 *
	 * @param municipios Lista contendo os nomes dos municipios que possuem a mesma quantidade de votos
	 *                   (sem considerar o criterio).
	 * @param totalVotos Quantidade de votos comum a todos os municipios da lista.
	 */
	public record MunicipioVotos(List<String> municipios, int totalVotos) {}
}
