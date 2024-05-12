package pruebasUnitarias.pruebasUnitarias;

import com.google.gson.stream.JsonToken;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PagoTest {

    private Pago pago;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Antes de todas las pruebas");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Después de todas las pruebas");
    }

    @Before
    public void setUp() {
        System.out.println("Antes de cada prueba");
        pago = new Pago("efectivo");
    }

    @After
    public void tearDown() {
        System.out.println("Después de cada prueba");
    }

    @Test
    public void verificarPago_when_efectivo() {
        assertTrue(pago.verificarPago());
        System.out.println("test 1");
    }

    @Test
    public void verificarPago_when_tarjeta() {
        pago = new Pago("tarjeta");
        assertTrue(pago.verificarPago());
        System.out.println("test 2");
    }

    @Test
    public void verificarPago_when_transferencia() {
        pago = new Pago("transferencia");
        assertTrue(pago.verificarPago());
        System.out.println("test 3");
    }

    @Test
    public void verificarPago_when_invalido() {
        pago = new Pago("cheque");
        assertFalse(pago.verificarPago());
        System.out.println("test 4");
    }
}
