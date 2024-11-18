package views;

import dados.Transporte;
import dados.TransporteCargaInanimada;
import dados.TransporteCargaViva;
import dados.TransportePessoal;
import handlers.TransporteHandler;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 * {@link JInternalFrame} que contém o formulário para
 * o cadastro de novas instâncias de {@link Transporte}
 * no sistema.
 *
 * @author Lucas da Paz
 */
public class CadastroTransporte extends javax.swing.JInternalFrame {
	private final TransporteHandler transporteHandler;

	/**
	 * Inicializa um novo frame {@link CadastroTransporte}.
	 */
	public CadastroTransporte() {
		transporteHandler = TransporteHandler.getHandler();
		initComponents();
	}

	/**
	 * Limpa todos os campos de texto e caixas de seleção
	 * do formulário.
	 */
	private void limpaCampos() {
		inputNumero.setText("");
		inputPeso.setText("");
		inputCliente.setText("");
		inputDescricao.setText("");
		inputLatOrigem.setText("");
		inputLongOrigem.setText("");
		inputLatDestino.setText("");
		inputLongDestino.setText("");
		inputQtdPessoasPessoal.setText("");
		inputTemperaturaMinimaCargaViva.setText("");
		inputTemperaturaMaximaCargaViva.setText("");
		checkPerigosaCargaInanimada.setSelected(false);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    painelHeader = new javax.swing.JPanel();
    title = new javax.swing.JLabel();
    painelGeral = new javax.swing.JPanel();
    labelNumero = new javax.swing.JLabel();
    inputNumero = new javax.swing.JFormattedTextField(Constantes.FORMATO_INTEIRO);
    labelPeso = new javax.swing.JLabel();
    inputPeso = new javax.swing.JFormattedTextField(Constantes.FORMATO_PONTO_FLUTUANTE);
    labelCliente = new javax.swing.JLabel();
    inputCliente = new javax.swing.JTextField();
    labelDescricao = new javax.swing.JLabel();
    inputDescricao = new javax.swing.JTextField();
    PainelCoordenadas = new javax.swing.JPanel();
    labelLatOrigem = new javax.swing.JLabel();
    inputLatOrigem = new javax.swing.JFormattedTextField(Constantes.FORMATO_PONTO_FLUTUANTE);
    labelLongOrigem = new javax.swing.JLabel();
    inputLongOrigem = new javax.swing.JFormattedTextField(Constantes.FORMATO_PONTO_FLUTUANTE);
    labelLatDestino = new javax.swing.JLabel();
    inputLatDestino = new javax.swing.JFormattedTextField(Constantes.FORMATO_PONTO_FLUTUANTE);
    labelLongDestino = new javax.swing.JLabel();
    inputLongDestino = new javax.swing.JFormattedTextField(Constantes.FORMATO_PONTO_FLUTUANTE);
    painelAbas = new javax.swing.JTabbedPane();
    tabTransportePessoal = new javax.swing.JPanel();
    labelQtdPessoasPessoal = new javax.swing.JLabel();
    inputQtdPessoasPessoal = new javax.swing.JFormattedTextField(Constantes.FORMATO_INTEIRO);
    tabCargaInanimada = new javax.swing.JPanel();
    checkPerigosaCargaInanimada = new javax.swing.JCheckBox();
    tabCargaViva = new javax.swing.JPanel();
    labelTemperaturaMinimaCargaViva = new javax.swing.JLabel();
    inputTemperaturaMinimaCargaViva = new javax.swing.JFormattedTextField(Constantes.FORMATO_PONTO_FLUTUANTE);
    labelTemperaturaMaximaCargaViva = new javax.swing.JLabel();
    inputTemperaturaMaximaCargaViva = new javax.swing.JFormattedTextField(Constantes.FORMATO_PONTO_FLUTUANTE);
    painelBotoes = new javax.swing.JPanel();
    btnCadastrar = new javax.swing.JButton();
    btnLimpar = new javax.swing.JButton();

    setClosable(true);
    setIconifiable(true);
    setMaximizable(true);
    setResizable(true);
    setTitle("Cadastro de Transporte");
    setPreferredSize(new java.awt.Dimension(550, 625));
    setVisible(true);

    title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    title.setLabelFor(this);
    title.setText(getTitle());

    javax.swing.GroupLayout painelHeaderLayout = new javax.swing.GroupLayout(painelHeader);
    painelHeader.setLayout(painelHeaderLayout);
    painelHeaderLayout.setHorizontalGroup(
      painelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelHeaderLayout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    painelHeaderLayout.setVerticalGroup(
      painelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(painelHeaderLayout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(title)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    painelGeral.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações gerais"));

    labelNumero.setLabelFor(inputNumero);
    labelNumero.setText("Número:");
    labelNumero.setPreferredSize(new java.awt.Dimension(125, 15));

    inputNumero.setToolTipText("Informe o número do transporte");
    inputNumero.setPreferredSize(new java.awt.Dimension(125, 30));

    labelPeso.setLabelFor(inputPeso);
    labelPeso.setText("Peso:");
    labelPeso.setPreferredSize(new java.awt.Dimension(125, 15));

    inputPeso.setToolTipText("Informe o peso do transporte em Kg");
    inputPeso.setPreferredSize(new java.awt.Dimension(125, 30));

    labelCliente.setLabelFor(inputCliente);
    labelCliente.setText("Cliente:");
    labelCliente.setPreferredSize(new java.awt.Dimension(125, 15));

    inputCliente.setToolTipText("Informe o nome do cliente");
    inputCliente.setPreferredSize(new java.awt.Dimension(125, 30));

    labelDescricao.setLabelFor(inputDescricao);
    labelDescricao.setText("Descrição:");
    labelDescricao.setPreferredSize(new java.awt.Dimension(125, 15));

    inputDescricao.setToolTipText("Descreva brevemente o transporte");
    inputDescricao.setPreferredSize(new java.awt.Dimension(125, 30));

    javax.swing.GroupLayout painelGeralLayout = new javax.swing.GroupLayout(painelGeral);
    painelGeral.setLayout(painelGeralLayout);
    painelGeralLayout.setHorizontalGroup(
      painelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(painelGeralLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(painelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(painelGeralLayout.createSequentialGroup()
            .addGroup(painelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(inputNumero, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
              .addComponent(labelNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(painelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(inputPeso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(labelPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(painelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(labelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(inputCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addComponent(labelDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(inputDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    painelGeralLayout.setVerticalGroup(
      painelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(painelGeralLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(painelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(painelGeralLayout.createSequentialGroup()
            .addComponent(labelPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(inputPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(painelGeralLayout.createSequentialGroup()
            .addGroup(painelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(labelCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(labelNumero, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(painelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(inputNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(inputCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(labelDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(inputDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    inputCliente.getAccessibleContext().setAccessibleName("");

    PainelCoordenadas.setBorder(javax.swing.BorderFactory.createTitledBorder("Coordenadas"));

    labelLatOrigem.setLabelFor(inputLatOrigem);
    labelLatOrigem.setText("Latitude origem:");
    labelLatOrigem.setPreferredSize(new java.awt.Dimension(200, 15));

    inputLatOrigem.setToolTipText("Informe a latitude de origem em graus");
    inputLatOrigem.setPreferredSize(new java.awt.Dimension(200, 30));

    labelLongOrigem.setLabelFor(inputLongOrigem);
    labelLongOrigem.setText("Longitude origem:");
    labelLongOrigem.setPreferredSize(new java.awt.Dimension(200, 15));

    inputLongOrigem.setToolTipText("Informe a longitude de origem em graus");
    inputLongOrigem.setPreferredSize(new java.awt.Dimension(200, 30));

    labelLatDestino.setLabelFor(inputLatDestino);
    labelLatDestino.setText("Latitude destino:");
    labelLatDestino.setPreferredSize(new java.awt.Dimension(200, 15));

    inputLatDestino.setToolTipText("Informe a latitude de destino em graus");
    inputLatDestino.setPreferredSize(new java.awt.Dimension(200, 30));

    labelLongDestino.setLabelFor(inputLongDestino);
    labelLongDestino.setText("Longitude destino:");
    labelLongDestino.setPreferredSize(new java.awt.Dimension(200, 15));

    inputLongDestino.setToolTipText("Informe a longitude de destino em graus");
    inputLongDestino.setPreferredSize(new java.awt.Dimension(200, 30));

    javax.swing.GroupLayout PainelCoordenadasLayout = new javax.swing.GroupLayout(PainelCoordenadas);
    PainelCoordenadas.setLayout(PainelCoordenadasLayout);
    PainelCoordenadasLayout.setHorizontalGroup(
      PainelCoordenadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(PainelCoordenadasLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(PainelCoordenadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(PainelCoordenadasLayout.createSequentialGroup()
            .addGroup(PainelCoordenadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(inputLatOrigem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(labelLatOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PainelCoordenadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(inputLongOrigem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(labelLongOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addGroup(PainelCoordenadasLayout.createSequentialGroup()
            .addGroup(PainelCoordenadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(inputLatDestino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(labelLatDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PainelCoordenadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(inputLongDestino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(labelLongDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
        .addContainerGap())
    );
    PainelCoordenadasLayout.setVerticalGroup(
      PainelCoordenadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(PainelCoordenadasLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(PainelCoordenadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(PainelCoordenadasLayout.createSequentialGroup()
            .addComponent(labelLongOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(inputLongOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(PainelCoordenadasLayout.createSequentialGroup()
            .addComponent(labelLatOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(inputLatOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(PainelCoordenadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(PainelCoordenadasLayout.createSequentialGroup()
            .addComponent(labelLatDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(inputLatDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(PainelCoordenadasLayout.createSequentialGroup()
            .addComponent(labelLongDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(inputLongDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap())
    );

    painelAbas.setToolTipText("Escolha o tipo de transporte que será cadastrado e preencha as informações");

    labelQtdPessoasPessoal.setLabelFor(inputQtdPessoasPessoal);
    labelQtdPessoasPessoal.setText("Quantidade de pessoas:");
    labelQtdPessoasPessoal.setPreferredSize(new java.awt.Dimension(125, 15));

    inputQtdPessoasPessoal.setToolTipText("Informe a quantidade de pessoas que será transportada");
    inputQtdPessoasPessoal.setPreferredSize(new java.awt.Dimension(125, 30));

    javax.swing.GroupLayout tabTransportePessoalLayout = new javax.swing.GroupLayout(tabTransportePessoal);
    tabTransportePessoal.setLayout(tabTransportePessoalLayout);
    tabTransportePessoalLayout.setHorizontalGroup(
      tabTransportePessoalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(tabTransportePessoalLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(tabTransportePessoalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(labelQtdPessoasPessoal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(inputQtdPessoasPessoal, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
        .addContainerGap(390, Short.MAX_VALUE))
    );
    tabTransportePessoalLayout.setVerticalGroup(
      tabTransportePessoalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(tabTransportePessoalLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(labelQtdPessoasPessoal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(inputQtdPessoasPessoal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    painelAbas.addTab("Pessoal", tabTransportePessoal);

    checkPerigosaCargaInanimada.setText("Carga perigosa");
    checkPerigosaCargaInanimada.setToolTipText("Marque a caixa de seleção se a carga é perigosa");

    javax.swing.GroupLayout tabCargaInanimadaLayout = new javax.swing.GroupLayout(tabCargaInanimada);
    tabCargaInanimada.setLayout(tabCargaInanimadaLayout);
    tabCargaInanimadaLayout.setHorizontalGroup(
      tabCargaInanimadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(tabCargaInanimadaLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(checkPerigosaCargaInanimada)
        .addContainerGap(414, Short.MAX_VALUE))
    );
    tabCargaInanimadaLayout.setVerticalGroup(
      tabCargaInanimadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(tabCargaInanimadaLayout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(checkPerigosaCargaInanimada)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    painelAbas.addTab("Carga Inanimada", tabCargaInanimada);

    labelTemperaturaMinimaCargaViva.setLabelFor(inputTemperaturaMinimaCargaViva);
    labelTemperaturaMinimaCargaViva.setText("Temperatura mínima:");
    labelTemperaturaMinimaCargaViva.setPreferredSize(new java.awt.Dimension(125, 15));

    inputTemperaturaMinimaCargaViva.setToolTipText("Informe a temperatura mínima do transporte em graus Celsius");
    inputTemperaturaMinimaCargaViva.setPreferredSize(new java.awt.Dimension(125, 30));

    labelTemperaturaMaximaCargaViva.setLabelFor(inputTemperaturaMaximaCargaViva);
    labelTemperaturaMaximaCargaViva.setText("Temperatura máxima:");
    labelTemperaturaMaximaCargaViva.setPreferredSize(new java.awt.Dimension(125, 15));

    inputTemperaturaMaximaCargaViva.setToolTipText("Informe a temperatura máxima do transporte em graus Celsius");
    inputTemperaturaMaximaCargaViva.setPreferredSize(new java.awt.Dimension(125, 30));

    javax.swing.GroupLayout tabCargaVivaLayout = new javax.swing.GroupLayout(tabCargaViva);
    tabCargaViva.setLayout(tabCargaVivaLayout);
    tabCargaVivaLayout.setHorizontalGroup(
      tabCargaVivaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(tabCargaVivaLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(tabCargaVivaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(inputTemperaturaMinimaCargaViva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(labelTemperaturaMinimaCargaViva, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(tabCargaVivaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(inputTemperaturaMaximaCargaViva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(labelTemperaturaMaximaCargaViva, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(247, Short.MAX_VALUE))
    );
    tabCargaVivaLayout.setVerticalGroup(
      tabCargaVivaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(tabCargaVivaLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(tabCargaVivaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(tabCargaVivaLayout.createSequentialGroup()
            .addComponent(labelTemperaturaMaximaCargaViva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(inputTemperaturaMaximaCargaViva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(tabCargaVivaLayout.createSequentialGroup()
            .addComponent(labelTemperaturaMinimaCargaViva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(inputTemperaturaMinimaCargaViva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap())
    );

    painelAbas.addTab("Carga Viva", tabCargaViva);

    btnCadastrar.setText("Cadastrar");
    btnCadastrar.setToolTipText("Cadastrar novo transporte");
    btnCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnCadastrar.setPreferredSize(new java.awt.Dimension(95, 30));
    getRootPane().setDefaultButton(btnCadastrar);
    btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cadastraTransporte(evt);
      }
    });

    btnLimpar.setText("Limpar");
    btnLimpar.setToolTipText("Limpar os campos do formulário");
    btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnLimpar.setPreferredSize(new java.awt.Dimension(95, 30));
    btnLimpar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        chamaLimpaCampos(evt);
      }
    });

    javax.swing.GroupLayout painelBotoesLayout = new javax.swing.GroupLayout(painelBotoes);
    painelBotoes.setLayout(painelBotoesLayout);
    painelBotoesLayout.setHorizontalGroup(
      painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(painelBotoesLayout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    painelBotoesLayout.setVerticalGroup(
      painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(painelBotoesLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(painelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(painelGeral, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(painelAbas)
          .addComponent(painelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(PainelCoordenadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap(20, Short.MAX_VALUE)
        .addComponent(painelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(painelGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(PainelCoordenadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(painelAbas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(painelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(35, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

	/**
	 * Valida os campos e cria um novo {@link Transporte} com
	 * o número passado como argumento.
	 *
	 * @param numero O número do transporte que será criado.
	 * @return O transporte instanciado, ou {@code null} se alguma
	 * das validações realizadas falhar.
	 */
	private Transporte criaTransporte(int numero) {
		double peso = Double.parseDouble(inputPeso.getText());
		if (peso <= 0) {
			JOptionPane.showMessageDialog(this, "O peso do transporte deve ser maior do que zero!", getTitle(), JOptionPane.WARNING_MESSAGE);
			return null;
		}

		String cliente = inputCliente.getText();
		if (cliente.isEmpty()) {
			JOptionPane.showMessageDialog(this, "O nome do cliente deve ser informado!", getTitle(), JOptionPane.WARNING_MESSAGE);
			return null;
		}

		String descricao = inputDescricao.getText();
		if (descricao.isEmpty()) {
			JOptionPane.showMessageDialog(this, "A descrição do transporte deve ser preenchida!", getTitle(), JOptionPane.WARNING_MESSAGE);
			return null;
		}

		double latitudeOrigem = Double.parseDouble(inputLatOrigem.getText());
		double longitudeOrigem = Double.parseDouble(inputLongOrigem.getText());
		double latitudeDestino = Double.parseDouble(inputLatDestino.getText());
		double longitudeDestino = Double.parseDouble(inputLongDestino.getText());

		if (latitudeOrigem == latitudeDestino && longitudeOrigem == longitudeDestino) {
			JOptionPane.showMessageDialog(this, "As coordenadas de origem e de destino devem ser diferentes!", getTitle(), JOptionPane.WARNING_MESSAGE);
			return null;
		}

		int tipoTransporte = painelAbas.getSelectedIndex();
		return switch (tipoTransporte) {
			case 0 ->
				criaTransportePessoal(numero, cliente, descricao, peso, latitudeOrigem, longitudeOrigem, latitudeDestino, longitudeDestino);
			case 1 ->
				criaTransporteCargaInanimada(numero, cliente, descricao, peso, latitudeOrigem, longitudeOrigem, latitudeDestino, longitudeDestino);
			case 2 ->
				criaTransporteCargaViva(numero, cliente, descricao, peso, latitudeOrigem, longitudeOrigem, latitudeDestino, longitudeDestino);
			default ->
				null;
		};
	}

	/**
	 * Lê os campos necessários, realiza as validações e cria uma
	 * nova instância de {@link TransportePessoal} com os valores
	 * passados como argumento.
	 *
	 * @param numero           O número do transporte.
	 * @param cliente          O nome do cliente relacionado.
	 * @param descricao        A descrição do transporte.
	 * @param peso             O peso do transporte, em kg.
	 * @param latitudeOrigem   A latitude de origem do transporte, em graus.
	 * @param longitudeOrigem  A longitude de origem do transporte, em graus.
	 * @param latitudeDestino  A latitude de destino do transporte, em graus.
	 * @param longitudeDestino A longitude de destino do transporte, em graus.
	 * @return O transporte instanciado, ou {@code null} se alguma das
	 * validações realizadas falhar.
	 */
	private Transporte criaTransportePessoal(int numero, String cliente, String descricao, double peso,
		double latitudeOrigem, double longitudeOrigem, double latitudeDestino, double longitudeDestino) {
		int qtdPessoas = Integer.parseInt(inputQtdPessoasPessoal.getText());
		if (qtdPessoas < 0) {
			JOptionPane.showMessageDialog(this, "O campo \"Quantidade de pessoas\" não pode ser negativo!", getTitle(), JOptionPane.WARNING_MESSAGE);
			return null;
		}

		return new TransportePessoal(numero, cliente, descricao, peso, latitudeOrigem,  longitudeOrigem,  latitudeDestino,  longitudeDestino, qtdPessoas);
	}

	/**
	 * Lê os campos necessários, realiza as validações e cria uma
	 * nova instância de {@link TransporteCargaInanimada} com os
	 * valores passados como argumento.
	 *
	 * @param numero           O número do transporte.
	 * @param cliente          O nome do cliente relacionado.
	 * @param descricao        A descrição do transporte.
	 * @param peso             O peso do transporte, em kg.
	 * @param latitudeOrigem   A latitude de origem do transporte, em graus.
	 * @param longitudeOrigem  A longitude de origem do transporte, em graus.
	 * @param latitudeDestino  A latitude de destino do transporte, em graus.
	 * @param longitudeDestino A longitude de destino do transporte, em graus.
	 * @return O transporte instanciado, ou {@code null} se alguma das
	 * validações realizadas falhar.
	 */
	private Transporte criaTransporteCargaInanimada(int numero, String cliente, String descricao, double peso,
		double latitudeOrigem, double longitudeOrigem, double latitudeDestino, double longitudeDestino) {
		boolean cargaPerigosa = checkPerigosaCargaInanimada.isSelected();
		return new TransporteCargaInanimada(numero, cliente, descricao, peso, latitudeOrigem,  longitudeOrigem,  latitudeDestino,  longitudeDestino, cargaPerigosa);
	}

	/**
	 * Lê os campos necessários, realiza as validações e cria uma
	 * nova instância de {@link TransporteCargaViva} com os valores
	 * passados como argumento.
	 *
	 * @param numero           O número do transporte.
	 * @param cliente          O nome do cliente relacionado.
	 * @param descricao        A descrição do transporte.
	 * @param peso             O peso do transporte, em kg.
	 * @param latitudeOrigem   A latitude de origem do transporte, em graus.
	 * @param longitudeOrigem  A longitude de origem do transporte, em graus.
	 * @param latitudeDestino  A latitude de destino do transporte, em graus.
	 * @param longitudeDestino A longitude de destino do transporte, em graus.
	 * @return O transporte instanciado, ou {@code null} se alguma das
	 * validações realizadas falhar.
	 */
	private Transporte criaTransporteCargaViva(int numero, String cliente, String descricao, double peso,
		double latitudeOrigem, double longitudeOrigem, double latitudeDestino, double longitudeDestino) {
		double temperaturaMinima = Double.parseDouble(inputTemperaturaMinimaCargaViva.getText());
		double temperaturaMaxima = Double.parseDouble(inputTemperaturaMaximaCargaViva.getText());

		if (temperaturaMaxima < temperaturaMinima) {
			JOptionPane.showMessageDialog(this, "A temperatura mínima não pode ser maior do que a temperatura máxima!", getTitle(), JOptionPane.WARNING_MESSAGE);
			return null;
		}

		return new TransporteCargaViva(numero, cliente, descricao, peso, latitudeOrigem,  longitudeOrigem,  latitudeDestino,  longitudeDestino, temperaturaMinima, temperaturaMaxima);
	}

  private void cadastraTransporte(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastraTransporte
		try {
			int numero = Integer.parseInt(inputNumero.getText());
			if (numero <= 0) {
				JOptionPane.showMessageDialog(this, "O número do transporte deve ser um inteiro positivo!", getTitle(), JOptionPane.WARNING_MESSAGE);
				return;
			}

			Transporte novoTransporte = criaTransporte(numero);
			if (novoTransporte == null) {
				return;
			}

			String[] opcoes = {"Sim", "Não"};
			int resposta = JOptionPane.showOptionDialog(this,
				"%s\n\nConfirma a criação do transporte?".formatted(novoTransporte),
				getTitle(), JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[1]);

			if (resposta != 0) {
				return;
			}

			boolean sucesso = transporteHandler.cadastra(novoTransporte);
			if (!sucesso) {
				JOptionPane.showMessageDialog(this, "Já existe um transporte cadastrado com o número %d".formatted(numero),
					getTitle(), JOptionPane.WARNING_MESSAGE);
				return;
			}

			JOptionPane.showMessageDialog(this, "Transporte cadastrado com sucesso!",
				getTitle(), JOptionPane.INFORMATION_MESSAGE);
			limpaCampos();
		} catch (Exception e) {
			e.printStackTrace(System.err);
			JOptionPane.showMessageDialog(this, "Erro ao cadastrar transporte...\nVerifique o tipo de transporte e se os campos estão preenchidos corretamente!", getTitle(), JOptionPane.ERROR_MESSAGE);
		}
  }//GEN-LAST:event_cadastraTransporte

	private void chamaLimpaCampos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chamaLimpaCampos
		limpaCampos();
  }//GEN-LAST:event_chamaLimpaCampos

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel PainelCoordenadas;
  private javax.swing.JButton btnCadastrar;
  private javax.swing.JButton btnLimpar;
  private javax.swing.JCheckBox checkPerigosaCargaInanimada;
  private javax.swing.JTextField inputCliente;
  private javax.swing.JTextField inputDescricao;
  private javax.swing.JFormattedTextField inputLatDestino;
  private javax.swing.JFormattedTextField inputLatOrigem;
  private javax.swing.JFormattedTextField inputLongDestino;
  private javax.swing.JFormattedTextField inputLongOrigem;
  private javax.swing.JFormattedTextField inputNumero;
  private javax.swing.JFormattedTextField inputPeso;
  private javax.swing.JFormattedTextField inputQtdPessoasPessoal;
  private javax.swing.JFormattedTextField inputTemperaturaMaximaCargaViva;
  private javax.swing.JFormattedTextField inputTemperaturaMinimaCargaViva;
  private javax.swing.JLabel labelCliente;
  private javax.swing.JLabel labelDescricao;
  private javax.swing.JLabel labelLatDestino;
  private javax.swing.JLabel labelLatOrigem;
  private javax.swing.JLabel labelLongDestino;
  private javax.swing.JLabel labelLongOrigem;
  private javax.swing.JLabel labelNumero;
  private javax.swing.JLabel labelPeso;
  private javax.swing.JLabel labelQtdPessoasPessoal;
  private javax.swing.JLabel labelTemperaturaMaximaCargaViva;
  private javax.swing.JLabel labelTemperaturaMinimaCargaViva;
  private javax.swing.JTabbedPane painelAbas;
  private javax.swing.JPanel painelBotoes;
  private javax.swing.JPanel painelGeral;
  private javax.swing.JPanel painelHeader;
  private javax.swing.JPanel tabCargaInanimada;
  private javax.swing.JPanel tabCargaViva;
  private javax.swing.JPanel tabTransportePessoal;
  private javax.swing.JLabel title;
  // End of variables declaration//GEN-END:variables
}
