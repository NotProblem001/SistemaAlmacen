package com.example;

public class Fruta extends Producto {
    private String tipo;

    public Fruta(String nombre, double precio, int stock, String tipo) {
        super(nombre, precio, stock);
        this.tipo = tipo;
    }

    @Override
    public String getTipo() {
        return "Fruta, Tipo: " + tipo;
    }
}