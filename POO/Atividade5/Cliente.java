public class Cliente extends Pessoa {
    private String numeroTelefone;

    public Cliente(String nome, int idade, String numeroTelefone) {
        super(nome, idade);
        this.numeroTelefone = numeroTelefone;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    @Override
    public double calcularBonusAnual() {

        return 0;
    }
}
