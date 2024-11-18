package views;

import java.awt.Color;
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
	public static final Font FONTE_TITULO = new Font("Yu Gothic UI Semibold", Font.PLAIN, 24);
	public static final Font FONTE_PADRAO = new Font("Yu Gothic UI", Font.PLAIN, 14);
	public static final Font FONTE_SERIFADA = new Font("Lucida Bright", Font.PLAIN, 14);
	public static final Font FONTE_MONOESPACADA = new Font("Lucida Console", Font.PLAIN, 14);
	public static final Font FONTE_PEQUENA = new Font("Yu Gothic UI", Font.PLAIN, 12);
	public static final Font FONTE_MEDIA = new Font("Yu Gothic UI", Font.PLAIN, 16);
	public static final Font FONTE_GRANDE = new Font("Yu Gothic UI Medium", Font.PLAIN, 18);

	// cores
	public static final Color COR_FONTE = new Color(42, 42, 42);
	public static final Color COR_FUNDO = new Color(234, 234, 234);
	public static final Color PRETO = new Color(0, 0, 0);
	public static final Color BRANCO = new Color(255, 255, 255);
	public static final Color AZUL = new Color(0, 129, 184);
	public static final Color AZUL_CLARO = new Color(134, 187, 216);
	public static final Color AZUL_ESCURO = new Color(22, 70, 163);
	public static final Color VERMELHO = new Color(222, 16, 16);
	public static final Color VERMELHO_ESCURO = new Color(146, 5, 5);
	public static final Color VERDE = new Color(0, 164, 0);
	public static final Color VERDE_ESCURO = new Color(30, 113, 37);
	public static final Color AMARELO_ESCURO = new Color(221, 127, 3);

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
