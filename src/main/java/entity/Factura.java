package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "facturas")
public class Factura {
    @Id
    @Column(name = "IDFactura", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDVenta")
    private Venta iDVenta;

    @Column(name = "detalles")
    private String detalles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Venta getIDVenta() {
        return iDVenta;
    }

    public void setIDVenta(Venta iDVenta) {
        this.iDVenta = iDVenta;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

}