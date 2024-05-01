package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class ProductosVentaId implements java.io.Serializable {
    private static final long serialVersionUID = -1999129040082238108L;
    @Column(name = "IDVenta", nullable = false)
    private Integer iDVenta;

    @Column(name = "IDProducto", nullable = false)
    private Integer iDProducto;

    public Integer getIDVenta() {
        return iDVenta;
    }

    public void setIDVenta(Integer iDVenta) {
        this.iDVenta = iDVenta;
    }

    public Integer getIDProducto() {
        return iDProducto;
    }

    public void setIDProducto(Integer iDProducto) {
        this.iDProducto = iDProducto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductosVentaId entity = (ProductosVentaId) o;
        return Objects.equals(this.iDVenta, entity.iDVenta) &&
                Objects.equals(this.iDProducto, entity.iDProducto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iDVenta, iDProducto);
    }

}