package entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DescuentoTest {

    private Descuento descuento;
    private double precioBase;
    private double resultadoEsperado;

    public DescuentoTest(double porcentajeDescuento, double precioBase, double resultadoEsperado) {
        this.descuento = new Descuento();
        this.descuento.setPorcentajeDescuento(BigDecimal.valueOf(porcentajeDescuento));
        this.precioBase = precioBase;
        this.resultadoEsperado = resultadoEsperado;
        System.out.println("Porcentaje descuento: " + this.descuento.getPorcentajeDescuento());
    }



    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {10, 100, 10},
                {15, 200, 30},
                {20, 150, 30},
                {25, 80, 20}
        });
    }

    @Test
    public void given_calcularDescuento_when_is_valid_then_return_descuento() {
        System.out.println("test 2 con parametros");
        double resultado = descuento.calcularDescuento(precioBase);
        assertEquals(resultadoEsperado, resultado, 0.01);
    }
}
