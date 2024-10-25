package dados;

import java.util.Objects;

/**
 * Contém as informações básicas de qualquer tipo de vídeo
 * cadastrado no sistema. Delega para as classes filhas a
 * implementação dos métodos da interface {@link Imprimivel}.
 *
 * @author Lucas da Paz
 */
public abstract class Video implements Imprimivel {
	private int codigo;
	private String titulo;

	/**
	 * Inicializa os campos do {@link Video}.
	 *
	 * @param codigo O código do vídeo.
	 * @param titulo O título do vídeo.
	 */
	public Video(int codigo, String titulo) {
		this.codigo = codigo;
		this.titulo = titulo;
	}

	/**
	 * @return O código deste {@link Video}.
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @return O título deste {@link Video}.
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @return Inteiro que representa esta instância de {@link Video}, conforme
	 * a definição do método {@link #equals} desta classe.
	 * @see Objects#hashCode
	 */
	@Override
	public int hashCode() {
		return Objects.hashCode(codigo);
	}

	/**
	 * Compara esta instância de {@link Video} com o objeto passado como argumento.
	 *
	 * @param o O objeto que será comparado.
	 * @return {@code true} caso o objeto passado como argumento seja uma instancia de
	 * {@code Video} e o código de ambos os objetos comparados seja igual, {@code false}
	 * caso contrario.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Video v)) return false;
		return codigo == v.codigo;
	}
}
