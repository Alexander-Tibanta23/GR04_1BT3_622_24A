package entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private List<ProductoVenta> productos;

    private double total;

    public Venta() {
        this.productos = new ArrayList<>();
        this.total = 0;
    }

    public void agregarProducto(Producto producto, int cantidad) {
        ProductoVenta pv = new ProductoVenta(producto, cantidad, this);
        productos.add(pv);
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

    //incremento del test
    public double calcularImpuesto(double subTotal, double impuesto) {

        return subTotal * impuesto;
    }

    //incremento del test
    public int calcularTotalItems(int numItems, int totalItems) {
        return numItems * totalItems;
    }


}

@Entity
class ProductoVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Venta venta;

    @ManyToOne
    private Producto producto;

    private int cantidad;

    public ProductoVenta() {
    }

    public ProductoVenta(Producto producto, int cantidad, Venta venta) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }
}
