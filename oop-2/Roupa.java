import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Roupa {
	private int tamanho;
	private String cor;
	private int codigo;
	private ArrayList<Aluguel> alugueis;

	public Roupa(int tamanho, String cor, int codigo) {
		this.tamanho = tamanho;
		this.cor = cor;
		this.codigo = codigo;
		alugueis = new ArrayList<>();
	}

	public int getTamanho() {
		return tamanho;
	}

	public String getCor() {
		return cor;
	}

	public int getCodigo() {
		return codigo;
	}

	public List<Aluguel> getAlugueis() {
		return Collections.unmodifiableList(alugueis);
	}
}
