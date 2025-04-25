package com.example;

public abstract class Producto {
    protected String nombre;
    protected double precio;
    protected int stock;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void reducirStock(int cantidad) {
        if (cantidad <= stock) {
            stock -= cantidad;
        }
    }

    public abstract String getTipo();

    @Override
    public String toString() {
        return nombre + " (" + getTipo() + ", Precio: $" + precio + ", Stock: " + stock + ")";
    }
}