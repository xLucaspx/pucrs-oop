package views;

import arquivo.ArquivoCSV;
import arquivo.ArquivoJSON;
import arquivo.ArquivoXML;
import formatos.FormatoArquivo;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 * {@link JInternalFrame} que contém o formulário utilizado
 * para importar dados de um arquivo estruturado para a aplicação.
 *
 * @author Lucas da Paz
 */
public class LeituraDados extends javax.swing.JInternalFrame {

	/**
	 * Inicializa um novo frame {@link LeituraDados}.
	 */
	public LeituraDados() {
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

    tipoArquivoButtonGroup = new javax.swing.ButtonGroup();
    javax.swing.JPanel painelHeader = new javax.swing.JPanel();
    javax.swing.JLabel title = new javax.swing.JLabel();
    javax.swing.JPanel painelArquivo = new javax.swing.JPanel();
    javax.swing.JLabel labelArquivo = new javax.swing.JLabel();
    inputArquivo = new javax.swing.JTextField();
    javax.swing.JButton btnCarregar = new javax.swing.JButton();
    javax.swing.JPanel painelTipoArquivo = new javax.swing.JPanel();
    javax.swing.JRadioButton radioTipoCsv = new javax.swing.JRadioButton();
    javax.swing.JRadioButton radioTipoJson = new javax.swing.JRadioButton();
    javax.swing.JRadioButton radioTipoXml = new javax.swing.JRadioButton();
    javax.swing.JPanel paineAjuda = new javax.swing.JPanel();
    javax.swing.JButton btnAjuda = new javax.swing.JButton();

    setClosable(true);
    setIconifiable(true);
    setMaximizable(true);
    setResizable(true);
    setTitle("Carregar dados");
    setPreferredSize(new java.awt.Dimension(500, 320));
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

    painelArquivo.setBorder(javax.swing.BorderFactory.createTitledBorder("Arquivo"));
    painelArquivo.setPreferredSize(new java.awt.Dimension(500, 225));

    labelArquivo.setLabelFor(inputArquivo);
    labelArquivo.setText("Nome do arquivo:");
    labelArquivo.setPreferredSize(new java.awt.Dimension(105, 30));

    inputArquivo.setToolTipText("Informe o nome do cliente");
    inputArquivo.setPreferredSize(new java.awt.Dimension(125, 30));

    btnCarregar.setText("Carregar");
    btnCarregar.setToolTipText("Carregar para o sistema os dados do arquivo informado");
    btnCarregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnCarregar.setPreferredSize(new java.awt.Dimension(95, 30));
    getRootPane().setDefaultButton(btnCarregar);
    btnCarregar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        carregaDados(evt);
      }
    });

    painelTipoArquivo.setBorder(javax.swing.BorderFactory.createTitledBorder("Formato"));
    painelTipoArquivo.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

    tipoArquivoButtonGroup.add(radioTipoCsv);
    radioTipoCsv.setSelected(true);
    radioTipoCsv.setText("CSV");
    radioTipoCsv.setToolTipText("Carregar dados de arquivos em formato CSV");
    radioTipoCsv.setActionCommand(FormatoArquivo.CSV.name());
    radioTipoCsv.setPreferredSize(new java.awt.Dimension(100, 15));
    painelTipoArquivo.add(radioTipoCsv);

    tipoArquivoButtonGroup.add(radioTipoJson);
    radioTipoJson.setText("JSON");
    radioTipoJson.setToolTipText("Carregar dados de arquivo em formato JSON");
    radioTipoJson.setActionCommand(FormatoArquivo.JSON.name());
    radioTipoJson.setPreferredSize(new java.awt.Dimension(100, 15));
    painelTipoArquivo.add(radioTipoJson);

    tipoArquivoButtonGroup.add(radioTipoXml);
    radioTipoXml.setText("XML");
    radioTipoXml.setToolTipText("Carregar dados de arquivo em formato XML");
    radioTipoXml.setActionCommand(FormatoArquivo.XML.name());
    radioTipoXml.setPreferredSize(new java.awt.Dimension(100, 15));
    painelTipoArquivo.add(radioTipoXml);

    javax.swing.GroupLayout painelArquivoLayout = new javax.swing.GroupLayout(painelArquivo);
    painelArquivo.setLayout(painelArquivoLayout);
    painelArquivoLayout.setHorizontalGroup(
      painelArquivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelArquivoLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(painelArquivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(painelTipoArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(painelArquivoLayout.createSequentialGroup()
            .addComponent(labelArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(inputArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 22, Short.MAX_VALUE)
            .addComponent(btnCarregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap())
    );
    painelArquivoLayout.setVerticalGroup(
      painelArquivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(painelArquivoLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(painelArquivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(labelArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnCarregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(inputArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(painelTipoArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    paineAjuda.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 15, 5));

    btnAjuda.setText("Ajuda");
    btnAjuda.setToolTipText("Mostrar informações de ajuda ao usuário");
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
        .addComponent(painelArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(paineAjuda, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(35, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void mostraAjuda(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostraAjuda
		String ajuda = """
			Digite o nome do arquivo do qual deseja carregar os dados,
			sem extensão; os dados serão salvos conforme o formato escolhido.
			
			E.g.: Considerando "dados" como o nome do arquivo inserido, se o
			formato selecionado for CSV, os dados serão lidos de dois arquivos
			distintos, "dados-drones.csv" e "dados-transportes.csv", buscados na
			pasta raíz.

			Se algum erro ocorrer durante a operação, uma mensagem será exibida.
			""";
		JOptionPane.showMessageDialog(this, ajuda, getTitle(), JOptionPane.INFORMATION_MESSAGE);
  }//GEN-LAST:event_mostraAjuda

  private void carregaDados(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carregaDados
		try {
			String nomeArquivo = inputArquivo.getText();
			if (nomeArquivo.isBlank()) {
				JOptionPane.showMessageDialog(this, "O nome do arquivo deve ser informado!", getTitle(), JOptionPane.WARNING_MESSAGE);
				return;
			}

			FormatoArquivo formato = FormatoArquivo.valueOf(tipoArquivoButtonGroup.getSelection().getActionCommand());
			switch (formato) {
				case CSV -> new ArquivoCSV(nomeArquivo).realizaLeitura();
				case JSON -> new ArquivoJSON(nomeArquivo).realizaLeitura();
				case XML -> new ArquivoXML(nomeArquivo).realizaLeitura();
				default -> {
					JOptionPane.showMessageDialog(this, "Erro ao selecionar formato do arquivo...\nTente novamente!",
						getTitle(), JOptionPane.ERROR_MESSAGE);
					return;
				}
			}

			JOptionPane.showMessageDialog(this, "Importação realizada com sucesso!", getTitle(), JOptionPane.INFORMATION_MESSAGE);
			inputArquivo.setText("");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
				"Erros ocorridos durante a importação:\n%s\nPara mais informações consulte o log de erros.".formatted(
					e.getMessage()),
				getTitle(),
				JOptionPane.WARNING_MESSAGE
			);
			e.printStackTrace(System.err);
		}
  }//GEN-LAST:event_carregaDados

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTextField inputArquivo;
  private javax.swing.ButtonGroup tipoArquivoButtonGroup;
  // End of variables declaration//GEN-END:variables
}
