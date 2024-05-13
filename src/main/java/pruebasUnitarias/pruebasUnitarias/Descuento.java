package pruebasUnitarias.pruebasUnitarias;

public class Descuento {
    private double porcentajeDescuento;

    public Descuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public double calcularDescuento(double precioBase) {
        return precioBase * (porcentajeDescuento / 100);
    }
}
