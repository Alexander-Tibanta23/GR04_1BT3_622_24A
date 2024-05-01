package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "descuentos_venta")
public class DescuentosVenta {
    @EmbeddedId
    private DescuentosVentaId id;

    @MapsId("iDVenta")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDVenta", nullable = false)
    private Venta iDVenta;

    @MapsId("iDDescuento")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDDescuento", nullable = false)
    private Descuento iDDescuento;

    public DescuentosVentaId getId() {
        return id;
    }

    public void setId(DescuentosVentaId id) {
        this.id = id;
    }

    public Venta getIDVenta() {
        return iDVenta;
    }

    public void setIDVenta(Venta iDVenta) {
        this.iDVenta = iDVenta;
    }

    public Descuento getIDDescuento() {
        return iDDescuento;
    }

    public void setIDDescuento(Descuento iDDescuento) {
        this.iDDescuento = iDDescuento;
    }

}