package service;

import entity.Producto;
import java.util.HashMap;
import java.util.Map;

public class InventarioService {
    private Map<String, Producto> inventario;

    public InventarioService() {
        this.inventario = new HashMap<>();
        // Cargar productos existentes (dummy data)
        cargarProductosDummy();
    }

    private void cargarProductosDummy() {
        inventario.put("001", new Producto("Laptop", 1000, "Dell", "XPS15", "2 años", "Electrónica", 10));
        inventario.put("002", new Producto("Smartphone", 500, "Apple", "iPhone 12", "1 año", "Electrónica", 15));
    }

    public boolean agregarProducto(Producto producto) {
        if (producto != null && !inventario.containsKey(producto.getNombre())) {
            inventario.put(producto.getNombre(), producto);
            return true;
        }
        return false;
    }

    public Producto buscarProductoPorCodigo(String codigo) {
        return inventario.get(codigo);
    }
}
