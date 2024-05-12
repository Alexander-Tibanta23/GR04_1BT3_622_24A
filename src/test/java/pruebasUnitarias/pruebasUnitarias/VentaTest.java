package pruebasUnitarias.pruebasUnitarias;

import static org.junit.Assert.*;
import org.junit.Test;

public class VentaTest {

    @Test
    public void calcularTotal_when_salesTax_is_15Percent() {
        Venta venta = new Venta();
        assertEquals(57.50, venta.calcularImpuesto(50, 1.15), 0.1);
        System.out.println("test 1");
    }

    @Test
    public void calcular_subTotal_when_buy_many_items() {
        Venta venta = new Venta();
        assertEquals(150, venta.calcularTotalItems(5, 30));
    }



}