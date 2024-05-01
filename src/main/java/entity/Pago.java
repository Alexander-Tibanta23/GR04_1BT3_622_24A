package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pagos")
public class Pago {
    @Id
    @Column(name = "IDPago", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDVenta")
    private Venta iDVenta;

    @Column(name = "monto")
    private Double monto;

    @Column(name = "estado", length = 50)
    private String estado;

    @Lob
    @Column(name = "tipoPago")
    private String tipoPago;

    @Column(name = "detallesCuenta")
    private String detallesCuenta;

    @Column(name = "numeroTarjeta", length = 20)
    private String numeroTarjeta;

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

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getDetallesCuenta() {
        return detallesCuenta;
    }

    public void setDetallesCuenta(String detallesCuenta) {
        this.detallesCuenta = detallesCuenta;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

}