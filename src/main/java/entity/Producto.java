package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @Column(name = "idProducto", nullable = false)
    private Integer id;

    @Column(name = "nombreProducto", nullable = false)
    private String nombreProducto;

    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "marca")
    private String marca;

    @Column(name = "garantia")
    private String garantia;

    @Column(name = "stock")
    private Integer stock;

    public Producto(Integer id, String nombreProducto, BigDecimal precio, String marca, String garantia, Integer stock) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.marca = marca;
        this.garantia = garantia;
        this.stock = stock;
    }

    public Producto(String nombreProducto, double precioProducto, String marcaProducto, String garantiaProducto, int cantidadProducto) {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Object getNombre() {
        return null;
    }
}