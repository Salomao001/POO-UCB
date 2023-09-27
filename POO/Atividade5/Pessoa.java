public abstract class Pessoa {
    private static int ultimoId = 0;
    private int id;
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.id = ++ultimoId;
        this.nome = nome;
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public abstract double calcularBonusAnual();
}
