package atividade2;
import java.util.Scanner;

public class Exercicio2{
    public static void main(String[] args){
        
        System.out.print("==========Conversor de temperatura==========\n\n");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o Grau: \n");
        double Grau = scanner.nextDouble();

        System.out.print("\nDigite SOMENTE C (Celsius) ou F (Fahrenheit)\n \n");

        System.out.print("Digite qual medida de temperatura do grau indicado: ");
        String unidade = scanner.next();

        Converter(Grau, unidade, scanner);
        scanner.close();
    }
    public static void Converter(double Grau, String unidade, Scanner scanner){
        double conversao = 0.0;
        if (unidade.equals("C")) {
            conversao = (Grau * 1.8) + 32;
            System.out.println("Convertido: " + conversao + " graus Fahrenheit");
        }
        if (unidade.equals("F")) {
           conversao = (Grau - 32) / 1.8;
            System.out.println("Convertido: " + conversao + " graus Celsius");
        }
    }
}