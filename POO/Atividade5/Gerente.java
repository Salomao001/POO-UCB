public class Gerente extends Funcionario {
    private String departamento;

    public Gerente(String nome, int idade, String cargo, double salario, String departamento) {
        super(nome, idade, cargo, salario);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }
}
