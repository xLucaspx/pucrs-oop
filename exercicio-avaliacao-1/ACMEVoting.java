import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;

/**
 * <p>Classe da aplicacao.</p>
 * <p><strong>Restricoes:</strong></p>
 *
 * <ul>
 *   <li>
 *     A entrada de dados devera ocorrer por leitura de arquivo de texto. Os dados de entrada estarao
 *     no arquivo <em>input.txt</em> e a saida devera ser gravada no arquivo <em>output.txt</em>;
 *   </li>
 *   <li>
 *     Toda entrada e saida de dados com o usuario deve ocorrer apenas na classe <code>ACMEVoting</code>.
 *   </li>
 * </ul>
 */
public class ACMEVoting {
	/**
	 * Define o caminho do arquivo de entrada de dados.
	 */
	private static final String INPUT_FILE_NAME = "./resources/exemplos-io/input.txt";
	/**
	 * Define o caminho do arquivo de saida de dados.
	 */
	private static final String OUTPUT_FILE_NAME = "./output.txt";

	private Scanner in = new Scanner(System.in);
	private PrintStream out = System.out;

	/**
	 * Objeto que gerencia o cadastro de partidos.
	 */
	private CadastroPartido partidoHandler;
	/**
	 * Objeto que gerencia o cadastro de candidatos.
	 */
	private Candidatura candidaturaHandler;

	/**
	 * Construtor da aplicacao
	 */
	public ACMEVoting() {
		redirectInput();
		// redirectOutput();
	}

	/**
	 * <p>Executa o funcionamento da aplicacao. Deve realizar a sequencia de passos:</p>
	 * <ol>
	 *   <li>
	 *     <strong>Cadastrar partidos</strong>: Le todos os dados de cada partido e, se o numero
	 *     nao for repetido, cadastra-o no sistema. Para cada partido cadastrado com sucesso no
	 *     sistema, mostra os dados do partido no formato <code>1:numero,nome</code>;
	 *   </li>
	 *   <li>
	 *     <strong>Cadastrar candidatos</strong>: Le todos os dados de cada candidato e, se o numero
	 *     nao for repetido no municipio e o partido existir, cadastra o candidato no sistema. Para
	 *     cada candidato cadastrado com sucesso no sistema, mostra os dados do candidato no formato
	 *     <code>2:numero,nome,municipio</code>;
	 *   </li>
	 *   <li>
	 *     <strong>Cadastrar votos de candidatos</strong>: Le os votos de um determinado candidato. Se
	 *     o numero do candidato for valido, adiciona os votos do candidato. Para cada cadastramento com
	 *     sucesso no sistema, mostra os dados no formato <code>3:numero,municipio,votos</code>;
	 *   </li>
	 *   <li>
	 *     <strong>Mostrar os dados de um determinado partido pelo numero</strong>: Le o numero de um
	 *     determinado partido. Se nao existir um partido com o numero indicado, mostra a mensagem de erro
	 *     <code>4:Nenhum partido encontrado.</code>. Se existir, mostra os dados do partido no formato
	 *     <code>4:numero,nome</code>;
	 *   </li>
	 *   <li>
	 *     <strong>Mostrar os dados de um determinado candidato</strong>: Le um numero de candidato e o
	 *     municipio. Se nao existir um candidato com o numero indicado no municipio, mostra a mensagem de
	 *     erro <code>5:Nenhum candidato encontrado.</code>. Se existir, mostra os dados do candidato no
	 *     formato <code>5:numero,nome,municipio,votos</code>;
	 *   </li>
	 *   <li>
	 *     <strong>Mostrar os votos dos prefeitos de um determinado partido</strong>: Le o nome de um partido.
	 *     Se nao existir nenhum partido com o nome indicado, mostra a mensagem de erro <code>6:Nenhum partido
	 *     encontrado.</code>. Se existir, mostra os dados de cada um dos seus prefeitos no formato
	 *     <code>6:nomePartido,numeroPrefeito,nomePrefeito,municipio,votos</code>;
	 *   </li>
	 *   <li>
	 *     <strong>Mostrar os dados do partido com mais candidatos</strong>: Localiza o partido com a maior
	 *     quantidade de candidatos. Se nao houver partidos com candidatos, mostra a mensagem de erro <code>
	 *     7:Nenhum partido com candidatos.</code>. Caso contrario, mostra os dados do partido e quantidade de
	 *     candidatos correspondente no formato <code>7:numero,nome,quantidade</code>;
	 *   </li>
	 *   <li>
	 *     <strong>Mostrar os dados do prefeito e do vereador mais votados</strong>: Se nao houver candidatos
	 *     cadastrados no sistema, mostra a mensagem de erro <code>8:Nenhum candidato encontrado.</code>. Caso
	 *     contrario, mostra os dados do prefeito e do vereador mais votados (<em>em caso de empate, sao mostrados
	 *     os dados de todos os candidatos com o numero de votos correspondente</em>) no formato
	 *     <code>8:numero,nome,municipio,votos</code>;
	 *   </li>
	 *   <li>
	 *     <strong>Mostrar o partido com mais votos de vereadores</strong>: Se nao houver candidatos vereadores
	 *     cadastrados no sistema, mostra a mensagem de erro <code>9:Nenhum candidato vereador encontrado.</code>.
	 *     Caso contrario, mostra os dados dos partidos com mais votos de vereadores no formato
	 *     <code>9:numero,nome,quantidade</code>;
	 *   </li>
	 * 	 <li>
	 *     <strong>Mostrar o municipio com maior quantidade de votos</strong>: Se nao houver candidatos cadastrados
	 *     no sistema, mostra a mensagem de erro <code>10:Nenhum candidato encontrado.</code>. Caso contrario, mostra
	 *     os dados do municipio que possuir a maior quantidade de votos somados para prefeito e para vereadores no
	 *     formato <code>10:municipio,quantidade</code>.
	 *   </li>
	 * </ol>
	 *
	 * <p>Nos passos 1, 2 e 3, cada linha de entrada correspondera a uma informacao necessaria para o cadastro sendo
	 * realizado. Quando a informacao lida for <code>-1</code> significa que nao serao realizados mais cadastros naquele
	 * passo especifico.</p>
	 * <p>As demais linhas de entrada correspondem ao numero de um partido para o passo 4, numero de um candidato para o
	 * passo 5 e nome de um partido para o passo 6.</p>
	 */
	public void executar() {
		// TODO implement method
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/**
	 * Redireciona a entrada de dados para o arquivo especificado na constante <code>INPUT_FILE_NAME</code>.
	 * Ajusta o <code>Locale</code> para utilizar ponto decimal.
	 */
	private void redirectInput() {
		try {
			BufferedReader inputStream = new BufferedReader(new FileReader(INPUT_FILE_NAME));
			in = new Scanner(inputStream);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

		Locale.setDefault(Locale.ENGLISH);
		in.useLocale(Locale.ENGLISH);
	}

	/**
	 * Redireciona a saida de dados para o arquivo especificado na constante <code>OUTPUT_FILE_NAME</code>.
	 * Ajusta o <code>Locale</code> para utilizar ponto decimal.
	 */
	private void redirectOutput() {
		try {
			PrintStream outputStream = new PrintStream(OUTPUT_FILE_NAME, StandardCharsets.UTF_8);
			System.setOut(outputStream);
		} catch (IOException | SecurityException e) {
			System.err.println(e.getMessage());
		}
		Locale.setDefault(Locale.ENGLISH);
	}
}
