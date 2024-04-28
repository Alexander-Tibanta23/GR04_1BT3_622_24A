package entity;

public class Producto {
    private String nombre;
    private double precio;
    private String marca;
    private String modelo;
    private String garantia;
    private String categoria;
    private int stock;

    public Producto(String nombre, double precio, String marca, String modelo, String garantia, String categoria, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.modelo = modelo;
        this.garantia = garantia;
        this.categoria = categoria;
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

    public String getModelo() {
        return modelo;
    }

    public String getGarantia() {
        return garantia;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
