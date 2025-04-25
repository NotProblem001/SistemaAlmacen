package com.example;

public class Lacteo extends Producto {
    public Lacteo(String nombre, double precio, int stock) {
        super(nombre, precio, stock);
    }

    @Override
    public String getTipo() {
        return "Lácteo";
    }
}