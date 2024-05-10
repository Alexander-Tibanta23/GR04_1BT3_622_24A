package entity;
import jakarta.persistence.*;

@Entity
@Table(name = "productos")

public class Producto {

    @Id
    @Column(name = "idProducto", nullable = false, length = 4)
    private int idProducto;

    @Column(name = "nombreProducto", nullable = false, length = 20)
    private String nombre;

    @Column(name = "precio", nullable = false, length = 4)
    private double precio;

    @Column(name = "marca", nullable = false, length = 20)
    private String marca;

    @Column(name = "garantia", nullable = false, length = 10)
    private String garantia;

    @Column(name = "stock", nullable = false, length = 3)
    private int stock;

    public Integer getIdProducto() {
        return idProducto;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getMarca() {
        return marca;
    }

    public String getGarantia() {
        return garantia;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

}
