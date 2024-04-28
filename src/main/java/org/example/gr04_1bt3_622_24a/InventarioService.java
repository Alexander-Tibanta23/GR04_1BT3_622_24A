package org.example.gr04_1bt3_622_24a;

import entity.Producto;
import java.util.HashMap;
import java.util.Map;

public class InventarioService {
    private static final Map<String, Producto> inventario = new HashMap<>();

    static {
        // Inicialización de algunos productos en el inventario para ejemplo
        inventario.put("001", new Producto("Laptop", 1000, "Dell", "XPS15", "2 años", "Electrónica", 10));
        inventario.put("002", new Producto("Smartphone", 500, "Apple", "iPhone 12", "1 año", "Electrónica", 15));
    }

    public static Producto buscarProductoPorCodigo(String codigo) {
        return inventario.get(codigo);
    }

    public static boolean actualizarStockProducto(String codigo, int cantidad) {
        Producto producto = inventario.get(codigo);
        if (producto != null && producto.getStock() >= cantidad) {
            producto.setStock(producto.getStock() - cantidad);
            return true;
        }
        return false;
    }
}
