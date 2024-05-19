package incrementos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

public class PagoTest {
    private VerificarPagoGateway gateway = null;
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
        gateway = Mockito.mock(VerificarPagoGateway.class);
        pago = new Pago(100, gateway);
        System.out.println("Antes de cada prueba");
    }

    //test unitario simple
    @Test(expected = SaldoInsuficienteException.class)
    public void given_saldoInsuficiente_when_realizarPago_then_throwSaldoInsuficienteException()
            throws SaldoInsuficienteException {
        System.out.println("test 1");
        pago.realizarPago(150);
    }

    @Test
    public void given_verificarPago_when_is_valid_then_return_true() {
        System.out.println("test 1 con mockito");
        Mockito.when(gateway.requestVerificarPago(any())).
                thenReturn(new VerificarPagoResponse(VerificarPagoResponse.TargetStatus.VALIDA));

        assertTrue(pago.verificarPago(true));
    }

    @Test
    public void given_verificarPago_when_is_invalid_then_return_false() {
        System.out.println("test 2 con mockito");
        Mockito.when(gateway.requestVerificarPago(any())).
                thenReturn(new VerificarPagoResponse(VerificarPagoResponse.TargetStatus.INVALIDA));

        assertFalse(pago.verificarPagoInvalid(false));
    }

}
