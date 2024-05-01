package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class DescuentosVentaId implements java.io.Serializable {
    private static final long serialVersionUID = 6991676592362739552L;
    @Column(name = "IDVenta", nullable = false)
    private Integer iDVenta;

    @Column(name = "IDDescuento", nullable = false)
    private Integer iDDescuento;

    public Integer getIDVenta() {
        return iDVenta;
    }

    public void setIDVenta(Integer iDVenta) {
        this.iDVenta = iDVenta;
    }

    public Integer getIDDescuento() {
        return iDDescuento;
    }

    public void setIDDescuento(Integer iDDescuento) {
        this.iDDescuento = iDDescuento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DescuentosVentaId entity = (DescuentosVentaId) o;
        return Objects.equals(this.iDVenta, entity.iDVenta) &&
                Objects.equals(this.iDDescuento, entity.iDDescuento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iDVenta, iDDescuento);
    }

}