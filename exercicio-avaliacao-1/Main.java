/**
 * Classe principal (inicial) do sistema.
 */
public class Main {
	/**
	 * <p>Cria um objeto <code>ACMEVoting</code> e chama seu metodo <code>executar()</code>.</p>
	 * <p>Pode receber, por meio de <code>args</code>, o caminho para os arquivos de entrada e
	 * saida que deseja-se utilizar; caso estes valores nao sejam informados, serao utilizados
	 * os valores padrao da classe ACME<code>Voting</code></p>
	 *
	 * @param args <strong>Opcional</strong>: caminhos dos arquivos de entrada e saida que deseja-se
	 *             utilizar, nesta ordem. O arquivo de entrada precisa ser um arquivo de texto valido existente.
	 *             O arquivo de saida, se nao existir, sera criado.
	 */
	public static void main(String[] args) {
		new ACMEVoting().executar(args);
	}
}
