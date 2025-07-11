import java.util.*;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("Olá, informe o valor do depósito inicial: R$ ");
        float depositoInicial = scanner.nextFloat();

        bank conta = new bank(depositoInicial);

        int opcao;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1 - Consultar Saldo");
            System.out.println("2 - Consultar Cheque Especial");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Pagar Boleto");
            System.out.println("6 - Verificar uso do Cheque Especial");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.printf("Saldo atual: R$ %.2f\n", conta.getSaldo());
                    break;
                case 2:
                    System.out.printf("Limite do Cheque Especial: R$ %.2f\n", conta.getLimiteChequeEspecial());
                    break;
                case 3:
                    System.out.print("Informe o valor a depositar: R$ ");
                    float valorDeposito = scanner.nextFloat();
                    conta.depositar(valorDeposito);
                    break;
                case 4:
                    System.out.print("Informe o valor a sacar: R$ ");
                    float valorSaque = scanner.nextFloat();
                    conta.sacar(valorSaque);
                    break;
                case 5:
                    System.out.print("Informe o valor do boleto: R$ ");
                    float valorBoleto = scanner.nextFloat();
                    if (conta.pagarBoleto(valorBoleto)) {
                        System.out.println("Boleto pago com sucesso.");
                    } else {
                        System.out.println("Falha ao pagar o boleto.");
                    }
                    break;
                case 6:
                    if (conta.estaUsandoChequeEspecial()) {
                        System.out.println("Você está usando o cheque especial.");
                    } else {
                        System.out.println("Você não está usando o cheque especial.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }


        } while (opcao != 0);

        scanner.close();
    }
}
