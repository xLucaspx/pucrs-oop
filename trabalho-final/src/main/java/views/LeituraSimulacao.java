package views;

import arquivo.ArquivoSimulacao;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas da Paz
 */
public class LeituraSimulacao extends javax.swing.JInternalFrame {

	public LeituraSimulacao() {
		initComponents();
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
    painelArquivo = new javax.swing.JPanel();
    labelArquivo = new javax.swing.JLabel();
    inputArquivo = new javax.swing.JTextField();
    btnRealizarSimulacao = new javax.swing.JButton();
    paineAjuda = new javax.swing.JPanel();
    btnAjuda = new javax.swing.JButton();

    setClosable(true);
    setIconifiable(true);
    setMaximizable(true);
    setResizable(true);
    setTitle("Realizar simulação");
    setPreferredSize(new java.awt.Dimension(500, 550));
    setVisible(true);

    title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    title.setLabelFor(this);
    title.setText(getTitle());

    javax.swing.GroupLayout painelHeaderLayout = new javax.swing.GroupLayout(painelHeader);
    painelHeader.setLayout(painelHeaderLayout);
    painelHeaderLayout.setHorizontalGroup(
      painelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(painelHeaderLayout.createSequentialGroup()
        .addContainerGap(31, Short.MAX_VALUE)
        .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
        .addContainerGap(31, Short.MAX_VALUE))
    );
    painelHeaderLayout.setVerticalGroup(
      painelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(painelHeaderLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(title)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    painelArquivo.setBorder(javax.swing.BorderFactory.createTitledBorder("Arquivo de simulação"));
    painelArquivo.setPreferredSize(new java.awt.Dimension(500, 225));

    labelArquivo.setLabelFor(inputArquivo);
    labelArquivo.setText("Nome do arquivo:");
    labelArquivo.setPreferredSize(new java.awt.Dimension(105, 30));

    inputArquivo.setToolTipText("Informe o nome do cliente");
    inputArquivo.setPreferredSize(new java.awt.Dimension(125, 30));

    btnRealizarSimulacao.setText("Simular");
    btnRealizarSimulacao.setToolTipText("Buscar arquivos e realizar simulação");
    btnRealizarSimulacao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnRealizarSimulacao.setPreferredSize(new java.awt.Dimension(95, 30));
    getRootPane().setDefaultButton(btnRealizarSimulacao);
    btnRealizarSimulacao.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        realizaSimulacao(evt);
      }
    });

    javax.swing.GroupLayout painelArquivoLayout = new javax.swing.GroupLayout(painelArquivo);
    painelArquivo.setLayout(painelArquivoLayout);
    painelArquivoLayout.setHorizontalGroup(
      painelArquivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(painelArquivoLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(labelArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(inputArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(btnRealizarSimulacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );
    painelArquivoLayout.setVerticalGroup(
      painelArquivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(painelArquivoLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(painelArquivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(labelArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnRealizarSimulacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(inputArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    paineAjuda.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 5));

    btnAjuda.setText("Ajuda");
    btnAjuda.setToolTipText("Mostrar informações sobre a simulação");
    btnAjuda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnAjuda.setPreferredSize(new java.awt.Dimension(95, 30));
    btnAjuda.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mostraAjuda(evt);
      }
    });
    paineAjuda.add(btnAjuda);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap(19, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(painelArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
          .addComponent(painelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(paineAjuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap(19, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap(20, Short.MAX_VALUE)
        .addComponent(painelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(painelArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(paineAjuda, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(35, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void mostraAjuda(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostraAjuda
		String ajuda = """
			Digite o nome do arquivo de simulação, sem extensão.
			O sistema buscará, na pasta raíz, pelos arquivos com o
			nome digitado e com seguintes sufixos:
			- "-DRONES.csv";
			- "-TRANSPORTES.csv".

			E.g.: Ao digitar "simula", o sistema buscará pelos arquivos
			"simula-drones.csv" e "simula-transportes.csv".

			O formato dos arquivos deve corresponder à especificação no
			enunciado da tarefa; se algum erro ocorrer durante a leitura,
			o sistema continuará tentando ler os arquivos até o final e
			depois mostrará quais erros ocorreram.""";
		JOptionPane.showMessageDialog(this, ajuda, getTitle(), JOptionPane.INFORMATION_MESSAGE);
  }//GEN-LAST:event_mostraAjuda

  private void realizaSimulacao(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_realizaSimulacao
		try {
			String nomeArquivo = inputArquivo.getText();
			new ArquivoSimulacao(nomeArquivo).realizaLeitura();
			JOptionPane.showMessageDialog(this, "Simulação realizada com sucesso!", getTitle(), JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Os seguintes erros ocorreram durante a simulação:\n%s".formatted(e.getMessage()), getTitle(), JOptionPane.WARNING_MESSAGE);
			e.printStackTrace(System.err);
		}
  }//GEN-LAST:event_realizaSimulacao

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnAjuda;
  private javax.swing.JButton btnRealizarSimulacao;
  private javax.swing.JTextField inputArquivo;
  private javax.swing.JLabel labelArquivo;
  private javax.swing.JPanel paineAjuda;
  private javax.swing.JPanel painelArquivo;
  private javax.swing.JPanel painelHeader;
  private javax.swing.JLabel title;
  // End of variables declaration//GEN-END:variables
}