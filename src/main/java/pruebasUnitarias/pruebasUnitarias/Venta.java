package pruebasUnitarias.pruebasUnitarias;

public class Venta {


    public double calcularImpuesto(double subTotal, double impuesto) {

        return subTotal * impuesto;
    }

    public int calcularTotalItems(int numItems, int totalItems) {
        return numItems * totalItems;
    }
}
