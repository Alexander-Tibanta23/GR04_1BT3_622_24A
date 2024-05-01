package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "productos_venta")
public class ProductosVenta {
    @EmbeddedId
    private ProductosVentaId id;

    @MapsId("iDVenta")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDVenta", nullable = false)
    private Venta iDVenta;

    @MapsId("iDProducto")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDProducto", nullable = false)
    private Producto iDProducto;

    @Column(name = "cantidad")
    private Integer cantidad;

    public ProductosVentaId getId() {
        return id;
    }

    public void setId(ProductosVentaId id) {
        this.id = id;
    }

    public Venta getIDVenta() {
        return iDVenta;
    }

    public void setIDVenta(Venta iDVenta) {
        this.iDVenta = iDVenta;
    }

    public Producto getIDProducto() {
        return iDProducto;
    }

    public void setIDProducto(Producto iDProducto) {
        this.iDProducto = iDProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}