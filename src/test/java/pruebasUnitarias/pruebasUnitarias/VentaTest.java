package pruebasUnitarias.pruebasUnitarias;

import static org.junit.Assert.*;

import org.junit.*;

public class VentaTest {


    private Venta venta;

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
        Venta venta = new Venta();
        assertEquals(57.50, venta.calcularImpuesto(50, 1.15), 0.1);
        System.out.println("test 3");
    }

    @Test
    public void calcular_subTotal_when_buy_many_items() {
        Venta venta = new Venta();
        assertEquals(150, venta.calcularTotalItems(5, 30));
        System.out.println("test 4");
    }


}