package pruebasUnitarias.pruebasUnitarias;

import static org.junit.Assert.*;

import org.junit.*;

public class VentaTest {


    private Venta venta = null;

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
        venta = new Venta();
        System.out.println("Antes de cada prueba");
    }

    @Test
    public void calcularTotal_when_salesTax_is_15Percent() {
        System.out.println("test 3");
        assertEquals(57.50, venta.calcularImpuesto(50, 1.15), 0.1);
    }

    @Test
    public void calcular_subTotal_when_buy_many_items() {
        System.out.println("test 4");
        assertEquals(150, venta.calcularTotalItems(5, 30));
    }

}