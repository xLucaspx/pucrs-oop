package views;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

/**
 *
 * @author Lucas da Paz
 */
public abstract class Relatorio extends javax.swing.JInternalFrame {
	private final String titulo;
	
	public Relatorio(String titulo) {
		this.titulo = titulo;
		initComponents();
	}
	
	protected abstract String geraRelatorio();

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
    painelRelatorio = new javax.swing.JPanel();
    scrollPaneRelatorio = new javax.swing.JScrollPane();
    textAreaRelatorio = new javax.swing.JTextArea();
    painelBotoes = new javax.swing.JPanel();
    btnGerar = new javax.swing.JButton();
    btnCopiar = new javax.swing.JButton();

    setClosable(true);
    setIconifiable(true);
    setMaximizable(true);
    setResizable(true);
    setTitle(titulo);
    setPreferredSize(new java.awt.Dimension(550, 600));
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

    painelRelatorio.setBorder(javax.swing.BorderFactory.createTitledBorder("Relatório"));
    painelRelatorio.setPreferredSize(new java.awt.Dimension(500, 400));

    scrollPaneRelatorio.setPreferredSize(new java.awt.Dimension(500, 400));

    textAreaRelatorio.setEditable(false);
    textAreaRelatorio.setColumns(20);
    textAreaRelatorio.setLineWrap(true);
    textAreaRelatorio.setRows(5);
    textAreaRelatorio.setTabSize(2);
    textAreaRelatorio.setWrapStyleWord(true);
    scrollPaneRelatorio.setViewportView(textAreaRelatorio);

    javax.swing.GroupLayout painelRelatorioLayout = new javax.swing.GroupLayout(painelRelatorio);
    painelRelatorio.setLayout(painelRelatorioLayout);
    painelRelatorioLayout.setHorizontalGroup(
      painelRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(scrollPaneRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
    );
    painelRelatorioLayout.setVerticalGroup(
      painelRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(scrollPaneRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
    );

    btnGerar.setText("Gerar");
    btnGerar.setToolTipText("Gerar um novo relatório");
    btnGerar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnGerar.setPreferredSize(new java.awt.Dimension(95, 30));
    getRootPane().setDefaultButton(btnGerar);
    btnGerar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mostraRelatorio(evt);
      }
    });

    btnCopiar.setText("Copiar");
    btnCopiar.setToolTipText("Limpar relatório");
    btnCopiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnCopiar.setPreferredSize(new java.awt.Dimension(95, 30));
    btnCopiar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        copiaRelatorio(evt);
      }
    });

    javax.swing.GroupLayout painelBotoesLayout = new javax.swing.GroupLayout(painelBotoes);
    painelBotoes.setLayout(painelBotoesLayout);
    painelBotoesLayout.setHorizontalGroup(
      painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(painelBotoesLayout.createSequentialGroup()
        .addContainerGap(103, Short.MAX_VALUE)
        .addComponent(btnGerar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
        .addComponent(btnCopiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(104, Short.MAX_VALUE))
    );
    painelBotoesLayout.setVerticalGroup(
      painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(painelBotoesLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(btnGerar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnCopiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(painelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap(26, Short.MAX_VALUE)
        .addComponent(painelRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
        .addContainerGap(27, Short.MAX_VALUE))
      .addGroup(layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(painelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap(22, Short.MAX_VALUE)
        .addComponent(painelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(painelRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
        .addGap(18, 18, 18)
        .addComponent(painelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(35, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void copiaRelatorio(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copiaRelatorio
		StringSelection selecao = new StringSelection(textAreaRelatorio.getText());
    Clipboard areaDeTransferencia = Toolkit.getDefaultToolkit().getSystemClipboard();
    areaDeTransferencia.setContents(selecao, null);
  }//GEN-LAST:event_copiaRelatorio

  private void mostraRelatorio(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostraRelatorio
		textAreaRelatorio.setText("\n%s\n".formatted(geraRelatorio()));
		textAreaRelatorio.setCaretPosition(0);
  }//GEN-LAST:event_mostraRelatorio

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnCopiar;
  private javax.swing.JButton btnGerar;
  private javax.swing.JPanel painelBotoes;
  private javax.swing.JPanel painelHeader;
  private javax.swing.JPanel painelRelatorio;
  private javax.swing.JScrollPane scrollPaneRelatorio;
  private javax.swing.JTextArea textAreaRelatorio;
  private javax.swing.JLabel title;
  // End of variables declaration//GEN-END:variables
}