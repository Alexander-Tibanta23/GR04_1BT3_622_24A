package entity;

import java.util.ArrayList;
import java.util.List;

public class Venta {
    private List<ProductoVenta> productos;
    private double total;

    public Venta() {
        this.productos = new ArrayList<>();
        this.total = 0;
    }

    public void agregarProducto(Producto producto, int cantidad) {
        productos.add(new ProductoVenta(producto, cantidad));
        calcularTotal();
    }

    public double calcularTotal() {
        total = 0;
        for (ProductoVenta pv : productos) {
            total += pv.getProducto().getPrecio() * pv.getCantidad();
        }
        return total;
    }

    public boolean setEstadoPago(String metodoPago, double monto) {
        // Implementación simple del pago
        return true;
    }

    public double getTotal() {
        return total;
    }

    public List<ProductoVenta> getProductos() {
        return productos;
    }
}

class ProductoVenta {
    private Producto producto;
    private int cantidad;

    public ProductoVenta(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }
}
