package pruebasUnitarias.pruebasUnitariasWhitMock;

import org.junit.Before;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class VerificarPagoProcessorTest {

    private VerificarPagoGateway gateway = null;
    private VerificarPagoProcessor processor = null;

    @Before
    public void setUp() {
        gateway = mock(VerificarPagoGateway.class);
        processor = new VerificarPagoProcessor(gateway);
    }

    @Test
    void verificarPago_when_is_valid() {
        System.out.println("test 1 con mockito");
        Mockito.when(gateway.requestVerificarPago(any())).
                thenReturn(new VerificarPagoResponse(VerificarPagoResponse.TargetStatus.VALIDA));

        assertTrue(processor.verificarPago(true));
    }

    @Test
    void verificarPago_when_is_invalid() {
        System.out.println("test 2 con mockito");
        Mockito.when(gateway.requestVerificarPago(any())).
                thenReturn(new VerificarPagoResponse(VerificarPagoResponse.TargetStatus.INVALIDA));

        assertFalse(processor.verificarPagoInvalid(false));
    }
}
