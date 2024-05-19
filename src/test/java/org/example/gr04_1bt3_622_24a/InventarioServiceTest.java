    package org.example.gr04_1bt3_622_24a;

    import entity.Producto;
    import org.testng.annotations.Test;
    import servlets.AgregarProductoServlet;
    import servlets.InventarioService;

    import java.math.BigDecimal;

    import static org.junit.Assert.*;


    public class InventarioServiceTest {

        private AgregarProductoServlet agregarProductoServlet;

        public InventarioServiceTest(){
            this.agregarProductoServlet = new AgregarProductoServlet();
        }

        @Test
        public void given_add_product_when_is_in_the_webPage() {
            Producto producto = new Producto();
            producto.setNombreProducto("Laptop");
            producto.setPrecio(BigDecimal.valueOf(1000.0));
            producto.setMarca("Marca");
            producto.setGarantia("1 año");
            producto.setStock(10);
        }
    }