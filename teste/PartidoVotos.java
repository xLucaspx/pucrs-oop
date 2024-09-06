import java.util.List;

/**
 * Objeto que agrupa os dados de um consulta de partidos com a mesma quantidade de votos,
 * nao levando em consideracao qual o criterio utilizado para comparar os votos.
 * 
 * @param partidos   Lista de partidos que possuem a mesma quantidade de votos (sem considerar o criterio).
 * @param totalVotos Quantidade de votos comum a todos os partidos da lista.
 */
public class PartidoVotos {

	private List partidos;

	private int totalVotos;

	private CadastroPartido cadastroPartido;

	public List partidos() {
		return null;
	}

	public int totalVotos() {
		return 0;
	}

}
