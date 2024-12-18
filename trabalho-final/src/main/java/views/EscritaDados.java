package views;

import arquivo.ArquivoCSV;
import arquivo.ArquivoJSON;
import arquivo.ArquivoXML;
import formatos.FormatoArquivo;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

/**
 * {@link JInternalFrame} que contém o formulário utilizado
 * para exportar os dados da aplicação para um arquivo estruturado.
 *
 * @author Lucas da Paz
 */
public class EscritaDados extends javax.swing.JInternalFrame {

	/**
	 * Inicializa um novo frame {@link EscritaDados}.
	 */
	public EscritaDados() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    tipoArquivoButtonGroup = new ButtonGroup();
    JPanel painelHeader = new JPanel();
    JLabel title = new JLabel();
    JPanel painelArquivo = new JPanel();
    JLabel labelArquivo = new JLabel();
    inputArquivo = new JTextField();
    JButton btnSalvar = new JButton();
    JPanel painelTipoArquivo = new JPanel();
    JRadioButton radioTipoCsv = new JRadioButton();
    JRadioButton radioTipoJson = new JRadioButton();
    JRadioButton radioTipoXml = new JRadioButton();
    JPanel paineAjuda = new JPanel();
    JButton btnAjuda = new JButton();

    setClosable(true);
    setIconifiable(true);
    setMaximizable(true);
    setResizable(true);
    setTitle("Salvar dados");
    setPreferredSize(new Dimension(500, 320));
    setVisible(true);

    title.setFont(Constantes.FONTE_TITULO);
    title.setHorizontalAlignment(SwingConstants.CENTER);
    title.setLabelFor(this);
    title.setText(getTitle());

    GroupLayout painelHeaderLayout = new GroupLayout(painelHeader);
    painelHeader.setLayout(painelHeaderLayout);
    painelHeaderLayout.setHorizontalGroup(painelHeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(painelHeaderLayout.createSequentialGroup()
        .addContainerGap(32, Short.MAX_VALUE)
        .addComponent(title, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
        .addContainerGap(34, Short.MAX_VALUE))
    );
    painelHeaderLayout.setVerticalGroup(painelHeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(painelHeaderLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(title, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    painelArquivo.setBorder(BorderFactory.createTitledBorder("Arquivo"));
    painelArquivo.setPreferredSize(new Dimension(500, 225));

    labelArquivo.setLabelFor(inputArquivo);
    labelArquivo.setText("Nome do arquivo:");
    labelArquivo.setPreferredSize(new Dimension(120, 30));

    inputArquivo.setToolTipText("Informe o nome do cliente");
    inputArquivo.setPreferredSize(new Dimension(185, 30));

    btnSalvar.setText("Salvar");
    btnSalvar.setToolTipText("Salvar todos os dados do sistema no arquivo informado");
    btnSalvar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    btnSalvar.setPreferredSize(new Dimension(95, 30));
    getRootPane().setDefaultButton(btnSalvar);
    btnSalvar.addActionListener(this::salvaDados);

    painelTipoArquivo.setBorder(BorderFactory.createTitledBorder("Formato"));
    painelTipoArquivo.setLayout(new FlowLayout(FlowLayout.LEFT));

    tipoArquivoButtonGroup.add(radioTipoCsv);
    radioTipoCsv.setSelected(true);
    radioTipoCsv.setText("CSV");
    radioTipoCsv.setToolTipText("Salvar dados em formato CSV");
    radioTipoCsv.setActionCommand(FormatoArquivo.CSV.name());
    radioTipoCsv.setPreferredSize(new Dimension(100, 15));
    painelTipoArquivo.add(radioTipoCsv);

    tipoArquivoButtonGroup.add(radioTipoJson);
    radioTipoJson.setText("JSON");
    radioTipoJson.setToolTipText("Salvar dados em formato JSON");
    radioTipoJson.setActionCommand(FormatoArquivo.JSON.name());
    radioTipoJson.setPreferredSize(new Dimension(100, 15));
    painelTipoArquivo.add(radioTipoJson);

    tipoArquivoButtonGroup.add(radioTipoXml);
    radioTipoXml.setText("XML");
    radioTipoXml.setToolTipText("Salvar dados em formato XML");
    radioTipoXml.setActionCommand(FormatoArquivo.XML.name());
    radioTipoXml.setPreferredSize(new Dimension(100, 15));
    painelTipoArquivo.add(radioTipoXml);

    GroupLayout painelArquivoLayout = new GroupLayout(painelArquivo);
    painelArquivo.setLayout(painelArquivoLayout);
    painelArquivoLayout.setHorizontalGroup(painelArquivoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(GroupLayout.Alignment.TRAILING, painelArquivoLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(painelArquivoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
          .addComponent(painelTipoArquivo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(painelArquivoLayout.createSequentialGroup()
            .addComponent(labelArquivo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(inputArquivo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        .addContainerGap())
    );
    painelArquivoLayout.setVerticalGroup(painelArquivoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(painelArquivoLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(painelArquivoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
          .addComponent(labelArquivo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
          .addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
          .addComponent(inputArquivo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(painelTipoArquivo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    paineAjuda.setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 5));

    btnAjuda.setText("Ajuda");
    btnAjuda.setToolTipText("Mostrar informações de ajuda ao usuário");
    btnAjuda.setCursor(new Cursor(Cursor.HAND_CURSOR));
    btnAjuda.setPreferredSize(new Dimension(95, 30));
    btnAjuda.addActionListener(this::mostraAjuda);
    paineAjuda.add(btnAjuda);

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap(19, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
          .addComponent(painelArquivo, GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
          .addComponent(painelHeader, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(paineAjuda, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap(19, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap(20, Short.MAX_VALUE)
        .addComponent(painelHeader, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(painelArquivo, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(paineAjuda, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
        .addContainerGap(35, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void mostraAjuda(ActionEvent evt) {//GEN-FIRST:event_mostraAjuda
		String ajuda = """
			Digite o nome do arquivo no qual deseja salvar os dados,
			sem extensão. Caso o arquivo já exista na pasta raíz do
			projeto, seu conteúdo será sobrescrito; caso não exista,
			será criado.

			Os dados serão salvos conforme o formato escolhido. E.g.:
			Considerando "dados" como o nome do arquivo inserido, se o
			formato selecionado for JSON o sistema salvará os dados da
			aplicação no arquivo "dados.json" na pasta raíz. Se o formato
			selecionado for CSV, os dados serão salvos em dois arquivos
			distintos, "dados-drones.csv" e "dados-transportes.csv",
			também na pasta raíz.

			Se algum erro ocorrer durante a operação, uma mensagem será
			exibida para o usuário.
			""";
		JOptionPane.showMessageDialog(this, ajuda, getTitle(), JOptionPane.INFORMATION_MESSAGE);
  }//GEN-LAST:event_mostraAjuda

  private void salvaDados(ActionEvent evt) {//GEN-FIRST:event_salvaDados
		try {
			String nomeArquivo = inputArquivo.getText();
			if (nomeArquivo.isBlank()) {
				JOptionPane.showMessageDialog(this, "O nome do arquivo deve ser informado!", getTitle(), JOptionPane.WARNING_MESSAGE);
				return;
			}

			FormatoArquivo formato = FormatoArquivo.valueOf(tipoArquivoButtonGroup.getSelection().getActionCommand());
			switch (formato) {
				case CSV -> new ArquivoCSV(nomeArquivo).realizaEscrita();
				case JSON -> new ArquivoJSON(nomeArquivo).realizaEscrita();
				case XML -> new ArquivoXML(nomeArquivo).realizaEscrita();
				default -> {
					JOptionPane.showMessageDialog(this, "Erro ao selecionar formato do arquivo...\nTente novamente!",
						getTitle(), JOptionPane.ERROR_MESSAGE);
					return;
				}
			}

			JOptionPane.showMessageDialog(this, "Exportação realizada com sucesso!", getTitle(), JOptionPane.INFORMATION_MESSAGE);
			inputArquivo.setText("");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
				"Erro inesperado durante a exportação:\n%s\nPara mais informações consulte o log de erros.".formatted(
					e.getMessage()),
				getTitle(),
				JOptionPane.WARNING_MESSAGE
			);
			e.printStackTrace(System.err);
		}
  }//GEN-LAST:event_salvaDados

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private JTextField inputArquivo;
  private ButtonGroup tipoArquivoButtonGroup;
  // End of variables declaration//GEN-END:variables
}
