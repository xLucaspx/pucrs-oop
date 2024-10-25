import app.ACMEVideos;

/**
 * Classe inicial do sistema; contém o método {@link #main}.
 *
 * @author Lucas da Paz
 */
public class Main {
	/**
	 * Cria uma instância de {@link ACMEVideos} e chama seu método
	 * {@link ACMEVideos#processar processar()}.
	 *
	 * @param args Argumentos recebidos do sistema operacional ao iniciar a
	 *             aplicação. <strong>Opcional</strong>: caminhos dos arquivos
	 *             de entrada e saída que deseja-se utilizar, nesta ordem. O arquivo
	 *             de entrada precisa ser um arquivo de texto válido existente; o
	 *             arquivo de saída, se não existir, será criado.
	 */
	public static void main(String[] args) {
		new ACMEVideos().processar(args);
	}
}
