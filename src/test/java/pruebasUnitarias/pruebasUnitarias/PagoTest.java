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

    @After
    public void tearDown() {
        System.out.println("Después de cada prueba");
    }

    @Before
    public void setUp() {
        pago = new Pago(100);
        System.out.println("Antes de cada prueba");
    }

    //test unitario simple
    @Test(expected = SaldoInsuficienteException.class)
    public void realizarPago_when_exist_SaldoInsuficiente() throws SaldoInsuficienteException {
        System.out.println("test 1");
        Pago pago = new Pago(100);
        pago.realizarPago(150);
    }


}
