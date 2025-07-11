public class bank {

    private float saldo;
    private float limiteChequeEspecial;
    private float valorUsadoChequeEspecial = 0;

    public bank(float depositoInicial) {
        this.saldo = depositoInicial;

        if (depositoInicial <= 500.0) {
            this.limiteChequeEspecial = 50.0f;
        } else {
            this.limiteChequeEspecial = depositoInicial * 0.5f;
    }
    }
        public float getSaldo() {
            return saldo;
        }

        public float getLimiteChequeEspecial() {
            return limiteChequeEspecial - valorUsadoChequeEspecial;
        }
        public void depositar(float valor) {
            if (valorUsadoChequeEspecial > 0) {
                float taxa = valorUsadoChequeEspecial * 0.2f;
                float totalDivida = valorUsadoChequeEspecial + taxa;

                if (valor >= totalDivida) {
                    saldo -= valor - totalDivida;
                    System.out.printf("Cheque especial quitado com taxa de R$ %.2f\n", taxa);
                    valorUsadoChequeEspecial = 0;
                } else {
                    valorUsadoChequeEspecial -= valor / 1.2f;
                    System.out.println("Depósito parcial usado para cobrir cheque especial com taxa.");
                    valor = 0;
                }
            }
            saldo += valor;
            System.out.printf("Depósito realizado: R$ %.2f\n", valor);
        }

        public boolean sacar(float valor) {
            if (valor <= saldo) {
                saldo -= valor;
                System.out.printf("Saque realizado: R$ %.2f\n", valor);
                return true;
            } else if (valor <= saldo + getLimiteChequeEspecial()) {
                float valorChequeEspecial = valor - saldo;
                saldo = 0;
                valorUsadoChequeEspecial += valorChequeEspecial;
                System.out.printf("Saque realizado com cheque especial: R$ %.2f\n", valor);
                return true;
            } else {
                System.out.println("Saldo insuficiente para saque.");
                return false;
            }
        }

        public boolean pagarBoleto(float valor) {
           return sacar(valor);
        }

        public boolean estaUsandoChequeEspecial() {
            return valorUsadoChequeEspecial > 0;
        }

}
