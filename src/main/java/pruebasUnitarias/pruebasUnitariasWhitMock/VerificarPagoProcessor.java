package pruebasUnitarias.pruebasUnitariasWhitMock;

public class VerificarPagoProcessor {

    private VerificarPagoGateway gateway;

    public VerificarPagoProcessor(VerificarPagoGateway gateway) {
        this.gateway = gateway;
    }

    public boolean verificarPago(boolean numeroTarjeta){
        VerificarPagoResponse response =
                gateway.requestVerificarPago(new VerificarPagoRequest(numeroTarjeta));

        if(response.getStatus() == VerificarPagoResponse.TargetStatus.VALIDA){
            return true;
        } else {
            return false;
        }
    }

    public boolean verificarPagoInvalid(boolean numeroTarjeta){
        VerificarPagoResponse response =
                gateway.requestVerificarPago(new VerificarPagoRequest(numeroTarjeta));

        if(response.getStatus() == VerificarPagoResponse.TargetStatus.INVALIDA){
            return false;
        } else {
            return true;
        }
    }

}
