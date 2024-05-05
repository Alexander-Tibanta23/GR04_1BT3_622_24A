package entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "descuentos")
public class Descuento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDescuento", nullable = false)
    private Integer id;

    @Column(name = "codigo", nullable = false)
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "porcentajeDescuento", nullable = false, precision = 5, scale = 2)
    private BigDecimal porcentajeDescuento;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(BigDecimal porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

}