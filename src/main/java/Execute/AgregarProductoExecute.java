package Execute;

import dao.ProductoDAO;
import entity.Producto;

import java.io.IOException;
import java.math.BigDecimal;

public class AgregarProductoExecute {

    public static void main(String[] args) {
        // Crear un objeto Producto con los datos de prueba
        Producto producto = new Producto();
        producto.setNombreProducto("Laptop");
        producto.setPrecio(new BigDecimal("1200.00"));
        producto.setMarca("HP");
        producto.setGarantia("2 años");
        producto.setStock(10);

        // Guardar el producto en la base de datos
        ProductoDAO productoDAO = new ProductoDAO();
        productoDAO.guardarProducto(producto);

        System.out.println("Producto agregado exitosamente.");
    }
}
