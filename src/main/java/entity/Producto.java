package entity;

public class Producto {
    private String nombre;
    private double precio;
    private String marca;
    private String modelo;
    private String garantia;
    private String categoria;
    private int stock;

    public Producto(String nombre, double precio, String marca, String garantia, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.garantia = garantia;
        this.stock = stock;
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
}
