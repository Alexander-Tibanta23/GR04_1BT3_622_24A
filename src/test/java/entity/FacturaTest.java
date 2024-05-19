package entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FacturaTest {

    @Before
    public void setUp() {
        // Código de inicialización antes de cada prueba
        System.out.println("Inicializando prueba...");
    }

    @After
    public void tearDown() {
        // Código de limpieza después de cada prueba
        System.out.println("Limpiando después de la prueba...");
    }

    @Test
    public void given_factura_when_generatePDF_then_PDFGenerated() {
        System.out.println("test 6");
        Factura factura = new Factura();

        boolean resultadoGeneracion = factura.generarPDF();

        assertTrue(resultadoGeneracion);
    }
}
