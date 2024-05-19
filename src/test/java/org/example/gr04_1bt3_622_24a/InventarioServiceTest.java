    package org.example.gr04_1bt3_622_24a;

    import entity.Producto;
    import org.testng.annotations.Test;
    import static org.junit.Assert.*;


    public class InventarioServiceTest {

        private InventarioService inventarioService;

        public InventarioServiceTest(){
            this.inventarioService = new InventarioService();
        }   

        @Test
        public void given_add_product_when_is_in_the_webPage() {
            Producto producto = new Producto();
            producto.setNombre("Laptop");
            producto.setPrecio(1000.0);
            producto.setMarca("Marca");
            producto.setGarantia("1 año");
            producto.setStock(10);

            boolean resultado = inventarioService.agregarProducto(producto);

            assertEquals(true, resultado);
        }
    }