package com.example;

public class Verdura extends Producto {
    public Verdura(String nombre, double precio, int stock) {
        super(nombre, precio, stock);
    }

    @Override
    public String getTipo() {
        return "Verdura";
    }
}