package views;

import java.awt.Font;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Armazena fontes, cores e formatos como constantes para serem utilizadas nas
 * telas da aplicação.
 *
 * @author Lucas da Paz
 */
public class Constantes {
	// fontes
	public static final Font FONTE_TITULO = new Font("Segoe UI Semibold", Font.PLAIN, 24);

	// formatos
	public static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	public static final NumberFormat FORMATO_INTEIRO = NumberFormat.getIntegerInstance(Locale.ENGLISH);
	public static final NumberFormat FORMATO_PONTO_FLUTUANTE = NumberFormat.getInstance(Locale.ENGLISH);

	static {
		FORMATO_INTEIRO.setGroupingUsed(false);
		FORMATO_PONTO_FLUTUANTE.setGroupingUsed(false);
		FORMATO_PONTO_FLUTUANTE.setMaximumFractionDigits(6);
	}
}
