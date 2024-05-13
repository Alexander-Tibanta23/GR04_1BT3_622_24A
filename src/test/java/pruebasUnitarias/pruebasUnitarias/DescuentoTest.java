package pruebasUnitarias.pruebasUnitarias;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DescuentoTest {

    private Descuento descuento;
    private double precioBase;
    private double resultadoEsperado;

    public DescuentoTest(double porcentajeDescuento, double precioBase, double resultadoEsperado) {
        this.descuento = new Descuento(porcentajeDescuento);
        this.precioBase = precioBase;
        this.resultadoEsperado = resultadoEsperado;
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
    public void calcularDescuento_when_is_valid() {
        double resultado = descuento.calcularDescuento(precioBase);
        assertEquals(resultadoEsperado, resultado, 0.001);
    }
}
