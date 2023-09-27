import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Pessoa> pessoas = new ArrayList<>();

        while (true) {
            System.out.println("\n*** Sistema de Gerenciamento de Pessoas ***");
            System.out.println("1. Cadastrar Funcionario");
            System.out.println("2. Cadastrar Cliente");
            System.out.println("3. Cadastrar Gerente");
            System.out.println("4. Listar Pessoas");
            System.out.println("5. Remover Funcionario");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opcao: ");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    cadastrarFuncionario(scanner, pessoas);
                    break;
                case 2:
                    cadastrarCliente(scanner, pessoas);
                    break;
                case 3:
                    cadastrarGerente(scanner, pessoas);
                    break;
                case 4:
                    listarPessoas(pessoas);
                    break;
                case 5:
                    removerFuncionario(scanner, pessoas);
                    break;
                case 6:
                    System.out.println("Saindo do programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
                    break;
            }
        }
    }

    private static void cadastrarFuncionario(Scanner scanner, List<Pessoa> pessoas) {
        System.out.print("Digite o nome do funcionario: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a idade do funcionario: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o cargo do funcionario: ");
        String cargo = scanner.nextLine();
        System.out.print("Digite o salario do funcionario: ");
        double salario = scanner.nextDouble();
        scanner.nextLine();

        Funcionario funcionario = new Funcionario(nome, idade, cargo, salario);
        pessoas.add(funcionario);
        System.out.println("Funcionario cadastrado com sucesso. ID: " + funcionario.getId());
    }

    private static void cadastrarCliente(Scanner scanner, List<Pessoa> pessoas) {
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a idade do cliente: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o numero de telefone do cliente: ");
        String numeroTelefone = scanner.nextLine();

        Cliente cliente = new Cliente(nome, idade, numeroTelefone);
        pessoas.add(cliente);
        System.out.println("Cliente cadastrado com sucesso. ID: " + cliente.getId());
    }

    private static void cadastrarGerente(Scanner scanner, List<Pessoa> pessoas) {
        System.out.print("Digite o nome do gerente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a idade do gerente: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o cargo do gerente: ");
        String cargo = scanner.nextLine();
        System.out.print("Digite o salario do gerente: ");
        double salario = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Digite o departamento do gerente: ");
        String departamento = scanner.nextLine();

        Gerente gerente = new Gerente(nome, idade, cargo, salario, departamento);
        pessoas.add(gerente);
        System.out.println("Gerente cadastrado com sucesso. ID: " + gerente.getId());
    }

    private static void listarPessoas(List<Pessoa> pessoas) {
        System.out.println("\n*** Lista de Pessoas ***");
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Funcionario) {
                Funcionario funcionario = (Funcionario) pessoa;
                System.out.println("Tipo: Funcionario");
                System.out.println("Nome: " + funcionario.getNome());
                System.out.println("Idade: " + funcionario.getIdade());
                System.out.println("ID do Funcionario: " + funcionario.getId());
                System.out.println("Cargo: " + funcionario.getCargo());
                System.out.println("Salario: " + funcionario.getSalario());
                System.out.println("Bonus Anual: " + funcionario.calcularBonusAnual());
            } else if (pessoa instanceof Cliente) {
                Cliente cliente = (Cliente) pessoa;
                System.out.println("Tipo: Cliente");
                System.out.println("Nome: " + cliente.getNome());
                System.out.println("Idade: " + cliente.getIdade());
                System.out.println("ID do Cliente: " + cliente.getId());
                System.out.println("Numero de Telefone: " + cliente.getNumeroTelefone());
            } else if (pessoa instanceof Gerente) {
                Gerente gerente = (Gerente) pessoa;
                System.out.println("Tipo: Gerente");
                System.out.println("Nome: " + gerente.getNome());
                System.out.println("Idade: " + gerente.getIdade());
                System.out.println("ID do Gerente: " + gerente.getId());
                System.out.println("Cargo: " + gerente.getCargo());
                System.out.println("Salario: " + gerente.getSalario());
                System.out.println("Departamento: " + gerente.getDepartamento());
            }
            System.out.println("-----------------------------------");
        }
    }

    private static void removerFuncionario(Scanner scanner, List<Pessoa> pessoas) {
        System.out.print("Digite o ID do funcionario que deseja remover: ");
        int idRemover = scanner.nextInt();

        Iterator<Pessoa> iterator = pessoas.iterator();
        boolean encontrado = false;

        while (iterator.hasNext()) {
            Pessoa pessoa = iterator.next();
            if (pessoa instanceof Funcionario) {
                Funcionario funcionario = (Funcionario) pessoa;
                if (funcionario.getId() == idRemover) {
                    iterator.remove();
                    System.out.println("Funcionario removido com sucesso.");
                    encontrado = true;
                    break;
                }
            }
        }

        if (!encontrado) {
            System.out.println("Funcionario com ID " + idRemover + " nao encontrado.");
        }
    }
}
