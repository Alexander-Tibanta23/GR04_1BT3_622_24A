package pruebasUnitarias.pruebasUnitariasWhitMock;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class VerificarPagoProcessorTest {

    @Test
    void verificarPago_when_is_valid() {
        VerificarPagoGateway gateway = Mockito.mock(VerificarPagoGateway.class);
        VerificarPagoProcessor processor = new VerificarPagoProcessor(gateway);

        Mockito.when(gateway.requestVerificarPago(Mockito.any())).
                thenReturn(new VerificarPagoResponse(VerificarPagoResponse.TargetStatus.VALIDA));

        assertTrue(processor.verificarPago(true));
    }

    @Test
    void verificarPago_when_is_invalid() {
        VerificarPagoGateway gateway = Mockito.mock(VerificarPagoGateway.class);
        VerificarPagoProcessor processor = new VerificarPagoProcessor(gateway);

        Mockito.when(gateway.requestVerificarPago(Mockito.any())).
                thenReturn(new VerificarPagoResponse(VerificarPagoResponse.TargetStatus.INVALIDA));

        assertTrue(processor.verificarPago(false));
    }
}