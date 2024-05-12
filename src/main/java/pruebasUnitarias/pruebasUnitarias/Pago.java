package pruebasUnitarias.pruebasUnitarias;

public class Pago {

    private String metodoPago;

    public Pago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public boolean verificarPago() {
        if ("efectivo".equals(metodoPago) || "tarjeta".equals(metodoPago) || "transferencia".equals(metodoPago)) {
            return true;
        } else {
            return false;
        }
    }
}
