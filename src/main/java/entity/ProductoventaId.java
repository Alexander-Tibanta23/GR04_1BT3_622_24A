package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class ProductoventaId implements java.io.Serializable {
    private static final long serialVersionUID = -6800112498226327661L;
    @Column(name = "producto_id", nullable = false)
    private Integer productoId;

    @Column(name = "venta_id", nullable = false)
    private Integer ventaId;

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public Integer getVentaId() {
        return ventaId;
    }

    public void setVentaId(Integer ventaId) {
        this.ventaId = ventaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductoventaId entity = (ProductoventaId) o;
        return Objects.equals(this.productoId, entity.productoId) &&
                Objects.equals(this.ventaId, entity.ventaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productoId, ventaId);
    }

}