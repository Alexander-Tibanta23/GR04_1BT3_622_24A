package entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductoTest {

    private Producto producto;

    @Before
    public void setUp() {
        producto = new Producto();
        producto.setStock(10); // Stock inicial
    }

    @After
    public void tearDown() {
        System.out.printf("despues del test");
        producto = null;
    }

    @Test
    public void given_stock_when_updateStock_then_stockUpdated() {
        System.out.println("test 7");
        producto.setStock(15);
        assertEquals(15, producto.getStock());
    }
}
