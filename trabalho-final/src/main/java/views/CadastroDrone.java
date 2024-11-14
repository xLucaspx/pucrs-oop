package views;

import dados.Drone;
import dados.DronePessoal;
import handlers.DroneHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * @author Lucas da Paz
 */
public class CadastroDrone extends JFrame {

	private final NumberFormat integerFormat;
	private final NumberFormat decimalFormat;
	private final DroneHandler droneHandler;
	private JButton btnCadastrar;
	private JButton btnLimpar;
	private JButton btnListar;
	private JButton btnSair;
	private JFormattedTextField inputAutonomia;
	private JFormattedTextField inputCodigo;
	private JFormattedTextField inputCustoFixo;
	private JFormattedTextField inputMaxPessoasPessoal;
	private JLabel labelAutonomia;
	private JLabel labelCodigo;
	private JLabel labelCustoFixo;
	private JLabel labelMaxPessoasPessoal;
	private JTabbedPane painelAbas;
	private JPanel painelBotoes;
	private JPanel painelDrone;
	private JPanel painelHeader;
	private JPanel painelMensagens;
	private JScrollPane scrollPaneMensagens;
	private JPanel tabDronePessoal;
	private JTextArea textAreaMensagens;
	private JLabel title;

	/**
	 * Creates new form CadastroDrones
	 */
	public CadastroDrone() {
		integerFormat = NumberFormat.getIntegerInstance(Locale.ENGLISH);
		integerFormat.setGroupingUsed(false);
		decimalFormat = NumberFormat.getInstance(Locale.ENGLISH);
		decimalFormat.setGroupingUsed(false);
		droneHandler = new DroneHandler();
		initComponents();
		setVisible(true);
	}

	private void limpaCampos() {
		inputCodigo.setText("");
		inputCustoFixo.setText("");
		inputAutonomia.setText("");
		inputMaxPessoasPessoal.setText("");
	}

	private void limpaMensagens() {
		textAreaMensagens.setText("");
	}

	private void notifica(String mensagem, int tipo) {
		textAreaMensagens.append("%n%s%n".formatted(mensagem));
		JOptionPane.showMessageDialog(this, mensagem, getTitle(), tipo);
	}

	private void initComponents() {
		painelHeader = new JPanel();
		title = new JLabel();
		painelDrone = new JPanel();
		labelCodigo = new JLabel();
		inputCodigo = new JFormattedTextField(integerFormat);
		labelCustoFixo = new JLabel();
		inputCustoFixo = new JFormattedTextField(decimalFormat);
		labelAutonomia = new JLabel();
		inputAutonomia = new JFormattedTextField(decimalFormat);
		painelAbas = new JTabbedPane();
		tabDronePessoal = new JPanel();
		labelMaxPessoasPessoal = new JLabel();
		inputMaxPessoasPessoal = new JFormattedTextField(integerFormat);
		painelMensagens = new JPanel();
		scrollPaneMensagens = new JScrollPane();
		textAreaMensagens = new JTextArea();
		painelBotoes = new JPanel();
		btnCadastrar = new JButton();
		btnListar = new JButton();
		btnLimpar = new JButton();
		btnSair = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Cadastro de Drone");
		setName(""); // NOI18N
		setPreferredSize(new java.awt.Dimension(600, 550));

		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setLabelFor(this);
		title.setText("Cadastro de Drones");

		GroupLayout painelHeaderLayout = new GroupLayout(painelHeader);
		painelHeader.setLayout(painelHeaderLayout);
		painelHeaderLayout.setHorizontalGroup(painelHeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(GroupLayout.Alignment.TRAILING,
				painelHeaderLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(title, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			));
		painelHeaderLayout.setVerticalGroup(painelHeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(painelHeaderLayout.createSequentialGroup()
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(title)
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		painelDrone.setBorder(BorderFactory.createTitledBorder("Informações gerais"));

		labelCodigo.setLabelFor(inputCodigo);
		labelCodigo.setText("Código:");
		labelCodigo.setPreferredSize(new java.awt.Dimension(125, 15));

		inputCodigo.setPreferredSize(new java.awt.Dimension(125, 30));

		labelCustoFixo.setLabelFor(inputCustoFixo);
		labelCustoFixo.setText("Custo fixo:");
		labelCustoFixo.setPreferredSize(new java.awt.Dimension(125, 15));

		inputCustoFixo.setPreferredSize(new java.awt.Dimension(125, 30));

		labelAutonomia.setLabelFor(inputAutonomia);
		labelAutonomia.setText("Autonomia");
		labelAutonomia.setPreferredSize(new java.awt.Dimension(125, 15));

		inputAutonomia.setPreferredSize(new java.awt.Dimension(125, 30));

		GroupLayout painelDroneLayout = new GroupLayout(painelDrone);
		painelDrone.setLayout(painelDroneLayout);
		painelDroneLayout.setHorizontalGroup(painelDroneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(painelDroneLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(painelDroneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
					.addComponent(inputCodigo, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
					.addComponent(labelCodigo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGap(18, 18, Short.MAX_VALUE)
				.addGroup(painelDroneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
					.addComponent(inputCustoFixo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(labelCustoFixo, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
				.addGap(18, 18, Short.MAX_VALUE)
				.addGroup(painelDroneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
					.addComponent(inputAutonomia, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
					.addComponent(labelAutonomia, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addContainerGap()));
		painelDroneLayout.setVerticalGroup(painelDroneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(painelDroneLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(painelDroneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addGroup(painelDroneLayout.createSequentialGroup()
						.addComponent(labelCustoFixo,
							GroupLayout.PREFERRED_SIZE,
							GroupLayout.DEFAULT_SIZE,
							GroupLayout.PREFERRED_SIZE
						)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(inputCustoFixo,
							GroupLayout.PREFERRED_SIZE,
							GroupLayout.DEFAULT_SIZE,
							GroupLayout.PREFERRED_SIZE
						))
					.addGroup(painelDroneLayout.createSequentialGroup()
						.addGroup(painelDroneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
							.addComponent(labelAutonomia,
								GroupLayout.Alignment.LEADING,
								GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE
							)
							.addComponent(labelCodigo,
								GroupLayout.Alignment.LEADING,
								GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE
							))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(painelDroneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(inputAutonomia,
								GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE
							)
							.addComponent(inputCodigo,
								GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE
							))))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		labelMaxPessoasPessoal.setLabelFor(inputMaxPessoasPessoal);
		labelMaxPessoasPessoal.setText("Máximo de Pessoas");
		labelMaxPessoasPessoal.setPreferredSize(new java.awt.Dimension(125, 15));

		inputMaxPessoasPessoal.setPreferredSize(new java.awt.Dimension(125, 30));

		GroupLayout tabDronePessoalLayout = new GroupLayout(tabDronePessoal);
		tabDronePessoal.setLayout(tabDronePessoalLayout);
		tabDronePessoalLayout.setHorizontalGroup(tabDronePessoalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(tabDronePessoalLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(tabDronePessoalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
					.addComponent(labelMaxPessoasPessoal, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(inputMaxPessoasPessoal, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
				.addContainerGap(452, Short.MAX_VALUE)));
		tabDronePessoalLayout.setVerticalGroup(tabDronePessoalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(tabDronePessoalLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(labelMaxPessoasPessoal,
					GroupLayout.PREFERRED_SIZE,
					GroupLayout.DEFAULT_SIZE,
					GroupLayout.PREFERRED_SIZE
				)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(inputMaxPessoasPessoal,
					GroupLayout.PREFERRED_SIZE,
					GroupLayout.DEFAULT_SIZE,
					GroupLayout.PREFERRED_SIZE
				)
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		painelAbas.addTab("Drone Pessoal", tabDronePessoal);

		painelMensagens.setBorder(BorderFactory.createTitledBorder("Mensagens"));

		textAreaMensagens.setEditable(false);
		textAreaMensagens.setColumns(45);
		textAreaMensagens.setRows(5);
		textAreaMensagens.setTabSize(2);
		textAreaMensagens.setWrapStyleWord(true);
		textAreaMensagens.setFocusable(false);
		scrollPaneMensagens.setViewportView(textAreaMensagens);

		GroupLayout painelMensagensLayout = new GroupLayout(painelMensagens);
		painelMensagens.setLayout(painelMensagensLayout);
		painelMensagensLayout.setHorizontalGroup(painelMensagensLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(painelMensagensLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(scrollPaneMensagens)
				.addContainerGap()));
		painelMensagensLayout.setVerticalGroup(painelMensagensLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(painelMensagensLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(scrollPaneMensagens,
					GroupLayout.PREFERRED_SIZE,
					GroupLayout.DEFAULT_SIZE,
					GroupLayout.PREFERRED_SIZE
				)
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		btnCadastrar.setText("Cadastrar");
		btnCadastrar.setToolTipText("Cadastrar novo drone");
		btnCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnCadastrar.setPreferredSize(new java.awt.Dimension(95, 30));
		getRootPane().setDefaultButton(btnCadastrar);
		btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnCadastrarActionPerformed(evt);
			}
		});

		btnListar.setText("Listar");
		btnListar.setToolTipText("Listar, no campo Mensagens, os drones cadastrados");
		btnListar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnListar.setPreferredSize(new java.awt.Dimension(95, 30));
		btnListar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnListarActionPerformed(evt);
			}
		});

		btnLimpar.setText("Limpar");
		btnLimpar.setToolTipText("Limpar os campos de texto e de mensagem");
		btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnLimpar.setPreferredSize(new java.awt.Dimension(95, 30));
		btnLimpar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnLimparActionPerformed(evt);
			}
		});

		btnSair.setText("Sair");
		btnSair.setToolTipText("Encerrar a aplicação");
		btnSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnSair.setPreferredSize(new java.awt.Dimension(95, 30));
		btnSair.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnSairActionPerformed(evt);
			}
		});

		GroupLayout painelBotoesLayout = new GroupLayout(painelBotoes);
		painelBotoes.setLayout(painelBotoesLayout);
		painelBotoesLayout.setHorizontalGroup(painelBotoesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(painelBotoesLayout.createSequentialGroup()
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(btnListar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		painelBotoesLayout.setVerticalGroup(painelBotoesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(painelBotoesLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(painelBotoesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(btnListar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addComponent(painelHeader, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			.addGroup(GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addComponent(painelDrone, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(painelAbas, GroupLayout.Alignment.LEADING)
						.addComponent(painelMensagens,
							GroupLayout.Alignment.LEADING,
							GroupLayout.DEFAULT_SIZE,
							GroupLayout.DEFAULT_SIZE,
							Short.MAX_VALUE
						)
						.addComponent(painelBotoes,
							GroupLayout.Alignment.LEADING,
							GroupLayout.DEFAULT_SIZE,
							GroupLayout.DEFAULT_SIZE,
							Short.MAX_VALUE
						))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup()
				.addContainerGap(18, Short.MAX_VALUE)
				.addComponent(painelHeader, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(18, 18, 18)
				.addComponent(painelDrone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(18, 18, 18)
				.addComponent(painelAbas, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
				.addGap(18, 18, 18)
				.addComponent(painelMensagens, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
					GroupLayout.PREFERRED_SIZE)
				.addGap(18, 18, 18)
				.addComponent(painelBotoes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(0, 26, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void btnCadastrarActionPerformed(ActionEvent evt) {
		try {
			int codigo = Integer.parseInt(inputCodigo.getText());
			double custoFixo = Double.parseDouble(inputCustoFixo.getText());
			double autonomia = Double.parseDouble(inputAutonomia.getText());
			int maximoPessoas = Integer.parseInt(inputMaxPessoasPessoal.getText());

			Drone novoDrone = new DronePessoal(codigo, custoFixo, autonomia, maximoPessoas);
			boolean sucesso = droneHandler.cadastra(novoDrone);

			if (!sucesso) {
				notifica("Já existe um drone cadastrado com o código %d".formatted(codigo), JOptionPane.WARNING_MESSAGE);
				return;
			}

			notifica("Drone cadastrado com sucesso!", JOptionPane.INFORMATION_MESSAGE);
			limpaCampos();
		} catch (Exception e) {
			notifica("Erro ao cadastrar drone...\nVerifique se os campos estão preenchidos corretamente e tente novamente!",
				JOptionPane.ERROR_MESSAGE
			);
		}
	}

	private void btnListarActionPerformed(ActionEvent evt) {
		List<Drone> drones = droneHandler.buscaTodos();
		if (drones.isEmpty()) {
			notifica("Nenhum drone cadastrado!", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		StringBuilder sb = new StringBuilder("\nDrones cadastrados:\n");
		drones.forEach(d -> sb.append(d).append("\n"));
		sb.append("\n");
		textAreaMensagens.append(sb.toString());
	}

	private void btnLimparActionPerformed(ActionEvent evt) {
		limpaCampos();
		limpaMensagens();
	}

	private void btnSairActionPerformed(ActionEvent evt) {
		limpaCampos();
		dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
	// End of variables declaration//GEN-END:variables
}
