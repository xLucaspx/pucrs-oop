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
	private static final String NOME_ARQUIVO_ENTRADA = "./resources/exemplos-io/input.txt";
	/**
	 * Define o caminho do arquivo de saida de dados.
	 */
	private static final String NOME_ARQUIVO_SAIDA = "./output.txt";

	/**
	 * Objeto que gerencia o cadastro de partidos.
	 */
	private final CadastroPartido partidoHandler;
	/**
	 * Objeto que gerencia o cadastro de candidatos.
	 */
	private final Candidatura candidaturaHandler;

	private Scanner in = new Scanner(System.in);
	private PrintStream out = System.out;

	/**
	 * Construtor da aplicacao
	 */
	public ACMEVoting() {
		redirecionaEntrada();
		// redirecionaSaida();

		this.partidoHandler = new CadastroPartido();
		this.candidaturaHandler = new Candidatura();
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
		cadastraPartidos();
		cadastraCandidatos();
		cadastraVotosCandidatos();
		consultaPartido();
		consultaCandidato();
		consultaPrefeitosPartido();
	}

	/**
	 * <p>Metodo que realiza o cadastro de partidos. Le os dados (numero e nome), cria a instancia de
	 * partido e chama o metodo responsavel da classe <code>CadastroPartido</code>; se o cadastro foi realizado com
	 * sucesso, a saida exibira os dados no formato <code>1:numero,nome</code>. Interrompe a execucao ao ler o valor
	 * <code>-1</code>.</p>
	 * <p><strong>Importante</strong>: Para o funcionamento correto do metodo, o arquivo de entrada deve obedecer o
	 * formato proposto, i.e.: uma linha contendo o numero do partido (ou <code>-1</code> para encerrar) e outra
	 * linha contendo o nome.</p>
	 */
	private void cadastraPartidos() {
		boolean run = true;

		while (run) {
			String strNumero = in.nextLine();

			// verifica condicao de encerramento
			if (strNumero.equals("-1")) {
				run = false;
				continue;
			}

			// le dados restantes para cadastro
			String nome = in.nextLine();

			// cria instancia e realiza cadastro
			Partido p = new Partido(Integer.parseInt(strNumero), nome);
			boolean success = partidoHandler.cadastraPartido(p);

			if (success) {
				System.out.printf("1:%d,%s%n", p.getNumero(), p.getNome());
			}
		}
	}

	/**
	 * <p>Metodo que realiza o cadastro de candidatos. Le os dados (numero, nome e municipio), cria a instancia de
	 * candidato e chama o metodo responsavel da classe <code>Candidatura</code>; se o cadastro foi realizado com
	 * sucesso, a saida exibira os dados no formato <code>2:numero,nome,municipio</code>. Interrompe a execucao ao ler
	 * o valor <code>-1</code>.</p>
	 * <p><strong>Importante</strong>: Para o funcionamento correto do metodo, o arquivo de entrada deve obedecer o
	 * formato proposto, i.e.: uma linha contendo o numero do partido (ou <code>-1</code> para encerrar), outra linha
	 * contendo o nome e a ultima contendo o municipio.</p>
	 */
	private void cadastraCandidatos() {
		boolean run = true;

		while (run) {
			String strNumero = in.nextLine();

			// verifica condicao de encerramento
			if (strNumero.equals("-1")) {
				run = false;
				continue;
			}

			// le dados restantes para cadastro
			String nome = in.nextLine();
			String municipio = in.nextLine();

			// verifica se o partido existe
			int numeroPartido = Integer.parseInt(strNumero.substring(0, 2));
			Partido p = partidoHandler.consultaPartido(numeroPartido);
			if (p == null) {
				continue;
			}

			// cria instancia e realiza cadastro
			Candidato c = new Candidato(Integer.parseInt(strNumero), nome, municipio, p);
			boolean success = candidaturaHandler.cadastraCandidato(c);

			if (success) {
				p.adicionaCandidato(c); // add candidato ao partido apenas em caso de sucesso
				System.out.printf("2:%d,%s,%s%n", c.getNumero(), c.getNome(), c.getMunicipio());
			}
		}
	}

	/**
	 * <p>Metodo que realiza o cadastro de votos dos candidatos. Le os dados (numero do candidato, municipio e
	 * quantidade) de votos, busca o candidato correspondente e, caso todas as informações sejam validas, contabiliza
	 * os votos e exibe a saida no formato <code>3:numero,municipio,votos</code>. Interrompe a execucao ao ler o valor
	 * <code>-1</code>.</p>
	 * <p><strong>Importante</strong>: Para o funcionamento correto do metodo, o arquivo de entrada deve obedecer o
	 * formato proposto, i.e.: uma linha contendo o numero do candidato (ou <code>-1</code> para encerrar), outra
	 * linha contendo o municipio e a ultima contendo o total de votos (maior do que 0).</p>
	 */
	private void cadastraVotosCandidatos() {
		boolean run = true;

		while (run) {
			String strNumero = in.nextLine();

			// verifica condicao de encerramento
			if (strNumero.equals("-1")) {
				run = false;
				continue;
			}

			// le dados restantes para cadastro
			String municipio = in.nextLine();
			int votos = Integer.parseInt(in.nextLine());

			// verifica se o candidato existe
			Candidato c = candidaturaHandler.consultaCandidato(Integer.parseInt(strNumero), municipio);

			if (c == null) {
				continue;
			}

			c.adicionaVotos(votos);
			System.out.printf("3:%d,%s,%d%n", c.getNumero(), c.getMunicipio(), c.getVotos());
		}
	}

	/**
	 * <p>Metodo que mostra os dados de um determinado partido pelo numero informado; se nao for encontrado
	 * nenhum partido sera exibida a mensagem <code>4:Nenhum partido encontrado.</code>, caso contrario a saida
	 * mostrara os dados do partido no formato <code>4:numero,nome</code>. É executado apenas uma vez.</p>
	 * <p><strong>Importante</strong>: Para o funcionamento correto do metodo, o arquivo de entrada deve obedecer o
	 * formato proposto, i.e.: uma linha contendo o numero do partido imediatamente apos o fim do cadastro de votos.
	 * </p>
	 */
	private void consultaPartido() {
		int numero = Integer.parseInt(in.nextLine());
		Partido p = partidoHandler.consultaPartido(numero);

		String saida = p == null ? "4:Nenhum partido encontrado." : "4:%d,%s".formatted(p.getNumero(), p.getNome());

		System.out.println(saida);
	}

	/**
	 * <p>Metodo que mostra os dados de um determinado candidato. Le o numero do candidato e o municipio da candidatura;
	 * se nao for encontrado nenhum candidato sera exibida a mensagem <code>5:Nenhum candidato encontrado.</code>, caso
	 * contrario a saida mostrara os dados do candidato no formato <code>5:numero,nome,municipio,votos</code>. É
	 * executado apenas uma vez.</p>
	 * <p><strong>Importante</strong>: Para o funcionamento correto do metodo, o arquivo de entrada deve obedecer o
	 * formato proposto, i.e.: uma linha contendo o numero do partido e outra contendo o municipio, imediatamente apos
	 * o fim da consulta de partido.</p>
	 */
	private void consultaCandidato() {
		int numero = Integer.parseInt(in.nextLine());
		String municipio = in.nextLine();
		Candidato c = candidaturaHandler.consultaCandidato(numero, municipio);

		String saida = c == null ? "5:Nenhum candidato encontrado." : "5:%d,%s,%s,%d".formatted(c.getNumero(),
			c.getNome(),
			c.getMunicipio(),
			c.getVotos()
		);

		System.out.println(saida);
	}

	/**
	 * <p>Metodo que mostra os dados de todos os candidatos a prefeito de um determinado partido. Le o nome do partido e,
	 * se nao for encontrado nenhum partido correspondente sera exibida a mensagem
	 * <code>6:Nenhum partido encontrado.</code>, caso contrario a saida mostrara os dados cada candidato a prefeito do
	 * partido no formato <code>6:nomePartido,numeroPrefeito,nomePrefeito,municipio,votos</code>. Se não hover candidatos
	 * a prefeito, não havera saida. É executado apenas uma vez.</p>
	 * <p><strong>Importante</strong>: Para o funcionamento correto do metodo, o arquivo de entrada deve obedecer o
	 * formato proposto, i.e.: uma linha contendo o nome do partido imediatamente apos o fim da consulta de candidato.
	 * </p>
	 */
	private void consultaPrefeitosPartido() {
		String nome = in.nextLine();
		Partido p = partidoHandler.consultaPartido(nome);

		if (p == null) {
			System.out.println("6:Nenhum partido encontrado.");
			return;
		}

		p.getPrefeitos().forEach(pref -> System.out.printf("6:%s,%d,%s,%s,%d%n",
			p.getNome(),
			pref.getNumero(),
			pref.getNome(),
			pref.getMunicipio(),
			pref.getVotos()
		));
	}

	/**
	 * Redireciona a entrada de dados para o arquivo especificado na constante <code>NOME_ARQUIVO_ENTRADA</code>.
	 * Ajusta o <code>Locale</code> para utilizar ponto decimal.
	 */
	private void redirecionaEntrada() {
		try {
			BufferedReader inputStream = new BufferedReader(new FileReader(NOME_ARQUIVO_ENTRADA));
			in = new Scanner(inputStream);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

		Locale.setDefault(Locale.ENGLISH);
		in.useLocale(Locale.ENGLISH);
	}

	/**
	 * Redireciona a saida de dados para o arquivo especificado na constante <code>NOME_ARQUIVO_SAIDA</code>.
	 * Ajusta o <code>Locale</code> para utilizar ponto decimal.
	 */
	private void redirecionaSaida() {
		try {
			PrintStream outputStream = new PrintStream(NOME_ARQUIVO_SAIDA, StandardCharsets.UTF_8);
			System.setOut(outputStream);
		} catch (IOException | SecurityException e) {
			System.err.println(e.getMessage());
		}
		Locale.setDefault(Locale.ENGLISH);
	}
}
