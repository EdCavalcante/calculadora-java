import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Numero n1 = new Numero(0);
        Numero n2 = new Numero(0);
        Numero resultado = new Numero(0);
        int escolha = -1;

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> historico = new ArrayList<>();
        Operacoes operar = new Operacoes();

        System.out.println("Bem-vindo à calculadora!");

        while (escolha != 3) {

            System.out.println("""
                    ----------------------------------
                    Escolha a opção desejada:
                    0. Multiplicar
                    1. Somar
                    2. Subtrair
                    3. Sair
                    4. Mostrar histórico de operações
                    ----------------------------------
                    """);

            escolha = scanner.nextInt();

            while (escolha < 0 || escolha > 4) {
                System.out.println("""
                        ----------------------------------
                        Operação inválida! 
                        Escolha novamente a opção desejada:
                        0. Multiplicar
                        1. Somar
                        2. Subtrair
                        3. Sair
                        4. Mostrar histórico de operações
                        ----------------------------------
                        """);
                escolha = scanner.nextInt();
            }

            if (escolha == 0 || escolha == 1 || escolha == 2) {

                System.out.println("Digite o primeiro número:");
                n1.setNumero(scanner.nextDouble());

                System.out.println("Digite o segundo número:");
                n2.setNumero(scanner.nextDouble());
            }

            if (escolha == 0) {
                resultado.setNumero(operar.multiplicar(n1.getNumero(), n2.getNumero()));
                System.out.println("Resultado da multiplicação: " + resultado.getNumero());
                historico.add(n1.getNumero() + " x " + n2.getNumero() + " = " + resultado.getNumero());

            } else if (escolha == 1) {
                resultado.setNumero(operar.somar(n1.getNumero(), n2.getNumero()));
                System.out.println("Resultado da soma: " + resultado.getNumero());
                historico.add(n1.getNumero() + " + " + n2.getNumero() + " = " + resultado.getNumero());

            } else if (escolha == 2) {
                resultado.setNumero(operar.subtrair(n1.getNumero(), n2.getNumero()));
                System.out.println("Resultado da subtração: " + resultado.getNumero());
                historico.add(n1.getNumero() + " - " + n2.getNumero() + " = " + resultado.getNumero());

            } else if (escolha == 4) {
                if (historico.isEmpty()) {
                    System.out.println("Não há registros de operações no histórico.");
                } else {
                    System.out.println("Histórico de operações:");
                    for (String op : historico) {
                        System.out.println(op);
                    }
                }

            } else if (escolha == 3) {
                System.out.println("Encerrando a calculadora. Até mais!");
            }
        }

        scanner.close();
    }
}
