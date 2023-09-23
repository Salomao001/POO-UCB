import java.util.ArrayList;
import java.util.Scanner;

class Item {
    String nome;
    int quantidade;

    public Item(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }
}

class Inventario {
    ArrayList<Item> itens;

    public Inventario() {
        itens = new ArrayList<>();
    }

    public void adicionarItem(String nome, int quantidade) {
        Item novoItem = new Item(nome, quantidade);
        itens.add(novoItem);
    }

    public void removerItem(String nome) {
        itens.removeIf(item -> item.nome.equals(nome));
    }

    public void atualizarQuantidade(String nome, int novaQuantidade) {
        for (Item item : itens) {
            if (item.nome.equals(nome)) {
                item.quantidade = novaQuantidade;
                break;
            }
        }
    }

    public void listarItens() {
        System.out.println("Inventario:");
        for (Item item : itens) {
            System.out.println(item.nome + " - Quantidade: " + item.quantidade);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();

        while (true) {
            System.out.println("1. Adicionar Item");
            System.out.println("2. Remover Item");
            System.out.println("3. Atualizar Quantidade");
            System.out.println("4. Listar Itens");
            System.out.println("5. Sair");
            System.out.print("Selecione uma opcao: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Digite o nome do item: ");
                    String nomeItem = scanner.nextLine();
                    System.out.print("Digite a quantidade do item: ");
                    int quantidadeItem = scanner.nextInt();
                    inventario.adicionarItem(nomeItem, quantidadeItem);
                    break;

                case 2:
                    System.out.print("Digite o nome do item a ser removido: ");
                    String itemParaRemover = scanner.nextLine();
                    inventario.removerItem(itemParaRemover);
                    break;

                case 3:
                    System.out.print("Digite o nome do item para atualizar a quantidade: ");
                    String itemParaAtualizar = scanner.nextLine();
                    System.out.print("Digite a nova quantidade: ");
                    int novaQuantidade = scanner.nextInt();
                    inventario.atualizarQuantidade(itemParaAtualizar, novaQuantidade);
                    break;

                case 4:
                    inventario.listarItens();
                    break;

                case 5:
                    System.out.println("Encerrando...");
                    System.exit(0);

                default:
                    System.out.println("Escolha invalida. Por favor, selecione novamente.");
            }
        }
    }
}
