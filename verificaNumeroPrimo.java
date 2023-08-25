public class verificaNumeroPrimo {

    public static int verificaNumeroPrimo(Integer n) {
        if (n <= 1) {
            return 0; // Números menores ou iguais a 1 não são primos
        }
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return 0; // Se encontrar um divisor, o número não é primo
            }
        }
        
        return 1; // Se não encontrou divisores, o número é primo
    }
    
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java VerificadorNumeroPrimo <numero>");
            return;
        }
        
        try {
            Integer numero = Integer.parseInt(args[0]);
            int resultado = verificaNumeroPrimo(numero);
            
            if (resultado == 1) {
                System.out.println(numero + " e primo.");
            } else {
                System.out.println(numero + " nao e primo.");
            }
        } catch (NumberFormatException e) {
            System.out.println("O argumento fornecido não é um número válido.");
        }
    }
}
