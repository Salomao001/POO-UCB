package atividade2;
import java.util.Scanner;

public class Exercicio1{
    public static void main(String[] args){

        System.out.print("==========CALCULADORA==========\n\n");
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Escreva o primeiro numero da operacao: ");
        double numero1 = scanner.nextDouble();

        System.out.print("Escreva a OPERACAO (+   -   *  /): ");
        char operador = scanner.next().charAt(0);

        System.out.print("Escreva o segundo numero da operacao: ");
        double numero2 = scanner.nextDouble();

        Operar(numero1, operador, numero2, scanner);
        scanner.close();
    }
    public static void Operar(double numero1, char operador, double numero2, Scanner scanner){
        double resultado = 0.0;
        switch (operador){
            case '+':
                resultado = numero1 + numero2;
                break;
            case '-':
                resultado = numero1 - numero2;
                break;
            case '*':
                resultado = numero1 * numero2;
                break;
            case '/':
                resultado = numero1 / numero2;
                break;
        }
        System.out.println("O Resultado: " + resultado);
    }
}