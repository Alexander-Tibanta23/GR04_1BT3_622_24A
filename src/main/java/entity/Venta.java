package entity;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "ventas")
public class Venta {
    @Id
    @Column(name = "IDVenta", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCajero")
    private Cajero idCajero;

    @Column(name = "fecha")
    private Instant fecha;

    @Column(name = "totalVenta")
    private Double totalVenta;

    @Column(name = "estadoPago")
    private Boolean estadoPago;

    private Map<Producto, Integer> productos = new HashMap<>();

    public void agregarProducto(Producto producto, int cantidad) {
        if (producto.getStock() >= cantidad) {
            productos.put(producto, productos.getOrDefault(producto, 0) + cantidad);
            producto.setStock(producto.getStock() - cantidad); // Actualiza el stock del producto
            // Aquí debería haber una lógica para persistir la actualización del stock en la base de datos
        } else {
            throw new RuntimeException("Stock insuficiente");
        }
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Map.Entry<Producto, Integer> entry : productos.entrySet()) {
            total += entry.getKey().getPrecio() * entry.getValue();
        }
        setTotalVenta(total);
        return total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cajero getIdCajero() {
        return idCajero;
    }

    public void setIdCajero(Cajero idCajero) {
        this.idCajero = idCajero;
    }

    public Instant getFecha() {
        return fecha;
    }

    public void setFecha(Instant fecha) {
        this.fecha = fecha;
    }

    public Double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(Double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public Boolean getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(Boolean estadoPago) {
        this.estadoPago = estadoPago;
    }

}