package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventario {
    private ArrayList<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
        // Productos de ejemplo
        this.productos.add(new Fruta("Manzana", 500, 10, "Tropical"));
        this.productos.add(new Verdura("Zanahoria", 300, 15));
        this.productos.add(new Lacteo("Leche", 1200, 5));
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void mostrarInventario() {
        System.out.println("================");
        System.out.println("Inventario:");
        for (int i = 0; i < productos.size(); i++) {
            System.out.println(i + ": " + productos.get(i));
        }
        System.out.println("================");
    }

    public Producto getProducto(int indice) {
        if (indice >= 0 && indice < productos.size()) {
            return productos.get(indice);
        }
        return null;
    }

    public int size() {
        return productos.size();
    }

    public void procesarCompra(Usuario usuario, Scanner scanner) {
        if (usuario == null) {
            System.out.println("Debe crear un usuario e iniciar sesión primero.");
            return;
        }

        boolean terminar = false;
        while (!terminar) {
            mostrarInventario();
            System.out.print("Ingrese índice del producto (o -1 para terminar): ");
            int indice = scanner.nextInt();
            
            if (indice == -1) {
                terminar = true;
                usuario.realizarCompra();
                System.out.println("==== FIN ====");
            } else if (indice >= 0 && indice < size()) {
                System.out.print("Ingrese cantidad: ");
                int cantidad = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                
                Producto producto = getProducto(indice);
                usuario.agregarAlCarrito(producto, cantidad);
            } else {
                System.out.println("Índice no válido.");
            }
        }
    }
}