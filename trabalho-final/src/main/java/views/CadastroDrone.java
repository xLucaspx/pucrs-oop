package views;

import dados.Drone;
import dados.DroneCargaInanimada;
import dados.DroneCargaViva;
import dados.DronePessoal;
import handlers.DroneHandler;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas da Paz
 */
public class CadastroDrone extends javax.swing.JInternalFrame {
	private final DroneHandler droneHandler;

	public CadastroDrone() {
		droneHandler = DroneHandler.getHandler();
		initComponents();
		setVisible(true);
	}

	private void limpaCampos() {
		inputCodigo.setText("");
		inputCustoFixo.setText("");
		inputAutonomia.setText("");
		inputMaxPessoasPessoal.setText("");
		inputPesoMaximoCargaInanimada.setText("");
		inputPesoMaximoCargaViva.setText("");
		checkProtecaoCargaInanimada.setSelected(false);
		checkClimatizacaoCargaViva.setSelected(false);
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
    painelDrone = new javax.swing.JPanel();
    labelCodigo = new javax.swing.JLabel();
    inputCodigo = new javax.swing.JFormattedTextField(Constantes.FORMATO_INTEIRO);
    labelCustoFixo = new javax.swing.JLabel();
    inputCustoFixo = new javax.swing.JFormattedTextField(Constantes.FORMATO_PONTO_FLUTUANTE);
    labelAutonomia = new javax.swing.JLabel();
    inputAutonomia = new javax.swing.JFormattedTextField(Constantes.FORMATO_PONTO_FLUTUANTE);
    painelAbas = new javax.swing.JTabbedPane();
    tabDronePessoal = new javax.swing.JPanel();
    labelMaxPessoasPessoal = new javax.swing.JLabel();
    inputMaxPessoasPessoal = new javax.swing.JFormattedTextField(Constantes.FORMATO_INTEIRO);
    tabDroneCargaInanimada = new javax.swing.JPanel();
    labelPesoMaximoCargaInanimada = new javax.swing.JLabel();
    inputPesoMaximoCargaInanimada = new javax.swing.JFormattedTextField(Constantes.FORMATO_PONTO_FLUTUANTE);
    checkProtecaoCargaInanimada = new javax.swing.JCheckBox();
    tabDroneCargaViva = new javax.swing.JPanel();
    labelPesoMaximoCargaViva = new javax.swing.JLabel();
    inputPesoMaximoCargaViva = new javax.swing.JFormattedTextField(Constantes.FORMATO_PONTO_FLUTUANTE);
    checkClimatizacaoCargaViva = new javax.swing.JCheckBox();
    painelBotoes = new javax.swing.JPanel();
    btnCadastrar = new javax.swing.JButton();
    btnLimpar = new javax.swing.JButton();

    setClosable(true);
    setIconifiable(true);
    setMaximizable(true);
    setResizable(true);
    setTitle("Cadastro de Drone");
    setPreferredSize(new java.awt.Dimension(550, 400));

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

    painelDrone.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações gerais"));

    labelCodigo.setLabelFor(inputCodigo);
    labelCodigo.setText("Código:");
    labelCodigo.setPreferredSize(new java.awt.Dimension(125, 15));

    inputCodigo.setPreferredSize(new java.awt.Dimension(125, 30));

    labelCustoFixo.setLabelFor(inputCustoFixo);
    labelCustoFixo.setText("Custo fixo:");
    labelCustoFixo.setPreferredSize(new java.awt.Dimension(125, 15));

    inputCustoFixo.setPreferredSize(new java.awt.Dimension(125, 30));

    labelAutonomia.setLabelFor(inputAutonomia);
    labelAutonomia.setText("Autonomia:");
    labelAutonomia.setPreferredSize(new java.awt.Dimension(125, 15));

    inputAutonomia.setPreferredSize(new java.awt.Dimension(125, 30));

    javax.swing.GroupLayout painelDroneLayout = new javax.swing.GroupLayout(painelDrone);
    painelDrone.setLayout(painelDroneLayout);
    painelDroneLayout.setHorizontalGroup(
      painelDroneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(painelDroneLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(painelDroneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(inputCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
          .addComponent(labelCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGap(18, 18, Short.MAX_VALUE)
        .addGroup(painelDroneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(inputCustoFixo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(labelCustoFixo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, Short.MAX_VALUE)
        .addGroup(painelDroneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(inputAutonomia, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
          .addComponent(labelAutonomia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    painelDroneLayout.setVerticalGroup(
      painelDroneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(painelDroneLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(painelDroneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(painelDroneLayout.createSequentialGroup()
            .addComponent(labelCustoFixo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(inputCustoFixo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(painelDroneLayout.createSequentialGroup()
            .addGroup(painelDroneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(labelAutonomia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(labelCodigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(painelDroneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(inputAutonomia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(inputCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    painelAbas.setToolTipText("Escolha o tipo de drone que será cadastrado e preencha as informações");

    labelMaxPessoasPessoal.setLabelFor(inputMaxPessoasPessoal);
    labelMaxPessoasPessoal.setText("Máximo de Pessoas:");
    labelMaxPessoasPessoal.setPreferredSize(new java.awt.Dimension(125, 15));

    inputMaxPessoasPessoal.setPreferredSize(new java.awt.Dimension(125, 30));

    javax.swing.GroupLayout tabDronePessoalLayout = new javax.swing.GroupLayout(tabDronePessoal);
    tabDronePessoal.setLayout(tabDronePessoalLayout);
    tabDronePessoalLayout.setHorizontalGroup(
      tabDronePessoalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(tabDronePessoalLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(tabDronePessoalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(labelMaxPessoasPessoal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(inputMaxPessoasPessoal, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
        .addContainerGap(461, Short.MAX_VALUE))
    );
    tabDronePessoalLayout.setVerticalGroup(
      tabDronePessoalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(tabDronePessoalLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(labelMaxPessoasPessoal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(inputMaxPessoasPessoal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    painelAbas.addTab("Pessoal", tabDronePessoal);

    labelPesoMaximoCargaInanimada.setLabelFor(inputPesoMaximoCargaInanimada);
    labelPesoMaximoCargaInanimada.setText("Peso máximo:");
    labelPesoMaximoCargaInanimada.setPreferredSize(new java.awt.Dimension(125, 15));

    inputPesoMaximoCargaInanimada.setPreferredSize(new java.awt.Dimension(125, 30));

    checkProtecaoCargaInanimada.setText("Proteção");

    javax.swing.GroupLayout tabDroneCargaInanimadaLayout = new javax.swing.GroupLayout(tabDroneCargaInanimada);
    tabDroneCargaInanimada.setLayout(tabDroneCargaInanimadaLayout);
    tabDroneCargaInanimadaLayout.setHorizontalGroup(
      tabDroneCargaInanimadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(tabDroneCargaInanimadaLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(tabDroneCargaInanimadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(inputPesoMaximoCargaInanimada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(labelPesoMaximoCargaInanimada, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, Short.MAX_VALUE)
        .addComponent(checkProtecaoCargaInanimada)
        .addContainerGap(370, Short.MAX_VALUE))
    );
    tabDroneCargaInanimadaLayout.setVerticalGroup(
      tabDroneCargaInanimadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(tabDroneCargaInanimadaLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(labelPesoMaximoCargaInanimada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(tabDroneCargaInanimadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(inputPesoMaximoCargaInanimada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(checkProtecaoCargaInanimada))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    painelAbas.addTab("Carga Inanimada", tabDroneCargaInanimada);

    labelPesoMaximoCargaViva.setLabelFor(inputPesoMaximoCargaViva);
    labelPesoMaximoCargaViva.setText("Peso máximo:");
    labelPesoMaximoCargaViva.setPreferredSize(new java.awt.Dimension(125, 15));

    inputPesoMaximoCargaViva.setPreferredSize(new java.awt.Dimension(125, 30));

    checkClimatizacaoCargaViva.setText("Climatização");

    javax.swing.GroupLayout tabDroneCargaVivaLayout = new javax.swing.GroupLayout(tabDroneCargaViva);
    tabDroneCargaViva.setLayout(tabDroneCargaVivaLayout);
    tabDroneCargaVivaLayout.setHorizontalGroup(
      tabDroneCargaVivaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(tabDroneCargaVivaLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(tabDroneCargaVivaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(inputPesoMaximoCargaViva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(labelPesoMaximoCargaViva, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, Short.MAX_VALUE)
        .addComponent(checkClimatizacaoCargaViva)
        .addContainerGap(348, Short.MAX_VALUE))
    );
    tabDroneCargaVivaLayout.setVerticalGroup(
      tabDroneCargaVivaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(tabDroneCargaVivaLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(labelPesoMaximoCargaViva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(tabDroneCargaVivaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(inputPesoMaximoCargaViva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(checkClimatizacaoCargaViva))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    painelAbas.addTab("Carga Viva", tabDroneCargaViva);

    btnCadastrar.setText("Cadastrar");
    btnCadastrar.setToolTipText("Cadastrar novo drone");
    btnCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnCadastrar.setPreferredSize(new java.awt.Dimension(95, 30));
    getRootPane().setDefaultButton(btnCadastrar);
    btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnCadastrarActionPerformed(evt);
      }
    });

    btnLimpar.setText("Limpar");
    btnLimpar.setToolTipText("Limpar os campos do formulário");
    btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnLimpar.setPreferredSize(new java.awt.Dimension(95, 30));
    btnLimpar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnLimparActionPerformed(evt);
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
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(painelDrone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(painelAbas, javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(painelBotoes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap(20, Short.MAX_VALUE)
        .addComponent(painelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(painelDrone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(painelAbas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(painelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(34, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

	private Drone criaDrone(int codigo) {
		double custoFixo = Double.parseDouble(inputCustoFixo.getText());
		double autonomia = Double.parseDouble(inputAutonomia.getText());

		int tipoDrone = painelAbas.getSelectedIndex();
		return switch (tipoDrone) {
			case 0 -> criaDronePessoal(codigo, custoFixo, autonomia);
			case 1 -> criaDroneCargaInanimada(codigo, custoFixo, autonomia);
			case 2 -> criaDroneCargaViva(codigo, custoFixo, autonomia);
			default -> null;
		};
	}

	private Drone criaDronePessoal(int codigo, double custoFixo, double autonomia) {
		int maximoPessoas = Integer.parseInt(inputMaxPessoasPessoal.getText());
		return new DronePessoal(codigo, custoFixo, autonomia, maximoPessoas);
	}

	private Drone criaDroneCargaInanimada(int codigo, double custoFixo, double autonomia) {
		double pesoMaximo = Double.parseDouble(inputPesoMaximoCargaInanimada.getText());
		boolean protecao = checkProtecaoCargaInanimada.isSelected();
		return new DroneCargaInanimada(codigo, custoFixo, autonomia, pesoMaximo, protecao);
	}
	private Drone criaDroneCargaViva(int codigo, double custoFixo, double autonomia) {
		double pesoMaximo = Double.parseDouble(inputPesoMaximoCargaViva.getText());
		boolean climatizacao = checkClimatizacaoCargaViva.isSelected();
		return new DroneCargaViva(codigo, custoFixo, autonomia, pesoMaximo, climatizacao);
	}

  private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
		try {
			int codigo = Integer.parseInt(inputCodigo.getText());
			Drone novoDrone = criaDrone(codigo);
			boolean sucesso = droneHandler.cadastra(novoDrone);

			if (!sucesso) {
				JOptionPane.showMessageDialog(this, "Já existe um drone cadastrado com o código %d".formatted(codigo),
					getTitle(), JOptionPane.WARNING_MESSAGE);
				return;
			}

			JOptionPane.showMessageDialog(this, "Drone cadastrado com sucesso!",
				getTitle(), JOptionPane.INFORMATION_MESSAGE);
			limpaCampos();
		} catch (Exception e) {
			e.printStackTrace(System.err);
			JOptionPane.showMessageDialog(this, "Erro ao cadastrar drone...\nVerifique o tipo de drone e se os campos estão preenchidos corretamente!", getTitle(), JOptionPane.ERROR_MESSAGE);
		}
  }//GEN-LAST:event_btnCadastrarActionPerformed

	private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
		limpaCampos();
  }//GEN-LAST:event_btnLimparActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnCadastrar;
  private javax.swing.JButton btnLimpar;
  private javax.swing.JCheckBox checkClimatizacaoCargaViva;
  private javax.swing.JCheckBox checkProtecaoCargaInanimada;
  private javax.swing.JFormattedTextField inputAutonomia;
  private javax.swing.JFormattedTextField inputCodigo;
  private javax.swing.JFormattedTextField inputCustoFixo;
  private javax.swing.JFormattedTextField inputMaxPessoasPessoal;
  private javax.swing.JFormattedTextField inputPesoMaximoCargaInanimada;
  private javax.swing.JFormattedTextField inputPesoMaximoCargaViva;
  private javax.swing.JLabel labelAutonomia;
  private javax.swing.JLabel labelCodigo;
  private javax.swing.JLabel labelCustoFixo;
  private javax.swing.JLabel labelMaxPessoasPessoal;
  private javax.swing.JLabel labelPesoMaximoCargaInanimada;
  private javax.swing.JLabel labelPesoMaximoCargaViva;
  private javax.swing.JTabbedPane painelAbas;
  private javax.swing.JPanel painelBotoes;
  private javax.swing.JPanel painelDrone;
  private javax.swing.JPanel painelHeader;
  private javax.swing.JPanel tabDroneCargaInanimada;
  private javax.swing.JPanel tabDroneCargaViva;
  private javax.swing.JPanel tabDronePessoal;
  private javax.swing.JLabel title;
  // End of variables declaration//GEN-END:variables
}
