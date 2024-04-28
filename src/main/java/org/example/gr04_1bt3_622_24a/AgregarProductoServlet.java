package org.example.gr04_1bt3_622_24a;

import entity.Producto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AgregarProductoServlet extends HttpServlet {

    private static final Map<String, Producto> inventario = new HashMap<>();

    @Override
    public void init() {
        // Inicializar el inventario con algunos productos de ejemplo
        inventario.put("001", new Producto("Laptop", 1000, "Dell", "XPS15", "2 años", "Electrónica", 10));
        inventario.put("002", new Producto("Smartphone", 500, "Apple", "iPhone 12", "1 año", "Electrónica", 15));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recibir los datos del producto desde un formulario
        String nombre = request.getParameter("nombre");
        double precio = Double.parseDouble(request.getParameter("precio"));
        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
        String garantia = request.getParameter("garantia");
        String categoria = request.getParameter("categoria");
        int stock = Integer.parseInt(request.getParameter("stock"));

        Producto producto = new Producto(nombre, precio, marca, modelo, garantia, categoria, stock);
        if (agregarProducto(producto)) {
            response.getWriter().println("Producto agregado con éxito: " + nombre);
        } else {
            response.getWriter().println("Error: El producto ya existe en el inventario.");
        }
    }

    private static boolean agregarProducto(Producto producto) {
        if (!inventario.containsKey(producto.getNombre())) {
            inventario.put(producto.getNombre(), producto);
            return true;
        }
        return false;
    }
}
