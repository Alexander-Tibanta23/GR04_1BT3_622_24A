package entity;

import org.junit.*;

import java.math.BigDecimal;

import static org.junit.Assert.*;

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
    public void given_calcularTotal_when_impuestoVenta_es_quincePorciento_then_returnTotalMasImpuesto() {
        System.out.println("test 3");
        assertEquals(57.50, venta.calcularImpuesto(50, 1.15), 0.0001);
    }

    @Test
    public void given_calcular_subTotal_when_buy_many_items_then_return_subTotal() {
        System.out.println("test 4");
        assertEquals(150, venta.calcularTotalItems(5, 30));
    }

    @Test
    public void given_venta_when_agregarProducto_then_calculateTotal() {
        System.out.println("test 8");
        Producto producto1 = new Producto();
        producto1.setNombreProducto("Laptop");
        producto1.setPrecio(BigDecimal.valueOf(1000.0));
        producto1.setMarca("Marca");
        producto1.setGarantia("1 año");
        producto1.setStock(10);

        Producto producto2 = new Producto();
        producto2.setNombreProducto("Mouse");
        producto2.setPrecio(BigDecimal.valueOf(20.0));
        producto2.setMarca("MarcaMouse");
        producto2.setGarantia("1 año");
        producto2.setStock(50);

        venta.agregarProducto(producto1, 2); // 2 laptops
        venta.agregarProducto(producto2, 5); // 5 mice

        double totalEsperado = 1000.0 * 2 + 20.0 * 5; // Precio de las laptops y los mice
        double totalVenta = venta.calcularTotal().doubleValue(); // Convertir el BigDecimal a double
        assertEquals(totalEsperado, totalVenta, 0); // 0 de margen de error para comparar doubles
    }

}