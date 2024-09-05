import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe que representa um partido na eleicao.
 */
public class Partido {
	private int numero;
	private String nome;
	private List<Candidato> candidatos;

	/**
	 * Inicializa um objeto do tipo <code>Partido</code>.
	 *
	 * @param numero O numero do partido
	 * @param nome   O nome do partido
	 */
	public Partido(int numero, String nome) {
		this.numero = numero;
		this.nome = nome;
		this.candidatos = new ArrayList<>();
	}

	/**
	 * @return O numero do partido.
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @return O nome do partido.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Adiciona um novo candidato ao partido.
	 *
	 * @param c O candidato que sera adicionado.
	 */
	public void adicionaCandidato(Candidato c) {
		this.candidatos.add(c);
	}

	/**
	 * Calcula um inteiro que representa a instancia atual da classe de acordo com a definicao
	 * de igualdade (<code>equals</code>).
	 *
	 * @return Um inteiro representando a instancia atual da classe.
	 */
	@Override
	public int hashCode() {
		return Objects.hashCode(numero);
	}

	/**
	 * Compara uma instancia de <code>Partido</code> com o objeto passado como argumento.
	 *
	 * @param o O objeto a ser comparado com a instancia de <code>Partido</code> na qual o metodo foi chamado
	 * @return <code>true</code> caso o objeto passado como argumento seja uma instancia de <code>Partido</code>
	 * e o numero de ambos os objetos comparados seja igual, <code>false</code> caso contrario.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (!(o instanceof Partido p)) {
			return false;
		}

		return numero == p.numero;
	}
}
