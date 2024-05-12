package pruebasUnitarias.pruebasUnitarias;

public class Pago {

    private int saldoDisponible;

    public Pago(int saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }


    public void realizarPago(double monto) throws SaldoInsuficienteException {
        if (monto > this.saldoDisponible) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar el pago");
        }else{
            this.saldoDisponible -= monto;
            System.out.println("Pago realizado com sucesso");
        }
    }

}
