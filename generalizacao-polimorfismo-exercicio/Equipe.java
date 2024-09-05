import java.util.ArrayList;

public class Equipe {
    private ArrayList<Funcionario> cadastro;

    public Equipe() {
        cadastro = new ArrayList<Funcionario>();
    }

    public boolean addFuncionario(Funcionario f) {
        return cadastro.add(f);
    }

    public Funcionario pesquisaNome(String nome) {
        for(Funcionario f : cadastro) {
            if(f.getNome().equals(nome))
                return f;
        }
        return null;
    }

    public double pesquisaSalario(String nome) {
        for(Funcionario f : cadastro) {
            if(f.getNome().equals(nome))
                return f.calculaSalario();
        }
        return -1;
    }
}
