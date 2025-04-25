package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
    private String username;
    private String password;
    private ArrayList<Producto> carrito;
    private ArrayList<Integer> cantidades;

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
        this.carrito = new ArrayList<>();
        this.cantidades = new ArrayList<>();
    }

    public boolean autenticar(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public void agregarAlCarrito(Producto producto, int cantidad) {
        if (producto == null) {
            System.out.println("Producto no válido.");
            return;
        }

        if (cantidad <= 0) {
            System.out.println("Cantidad debe ser mayor a cero.");
            return;
        }

        if (producto.getStock() >= cantidad) {
            carrito.add(producto);
            cantidades.add(cantidad);
            producto.reducirStock(cantidad);
            System.out.println("Producto añadido a la compra.");
        } else {
            System.out.println("No hay suficiente stock disponible.");
        }
    }

    public void realizarCompra() {
        if (carrito.isEmpty()) {
            System.out.println("El carrito está vacío.");
            return;
        }

        double total = 0;
        System.out.println("=== Resumen de Compra ===");
        for (int i = 0; i < carrito.size(); i++) {
            Producto p = carrito.get(i);
            int cantidad = cantidades.get(i);
            double subtotal = p.getPrecio() * cantidad;
            System.out.println(p.getNombre() + " x" + cantidad + ": $" + subtotal);
            total += subtotal;
        }
        System.out.println("Total: $" + total);
        System.out.println("=== Gracias por su compra ===");

        carrito.clear();
        cantidades.clear();
    }

    public static Usuario crearUsuario(Scanner scanner) {
        System.out.print("Ingrese nombre de usuario: ");
        String username = scanner.nextLine();
        System.out.print("Ingrese contraseña: ");
        String password = scanner.nextLine();
        return new Usuario(username, password);
    }

    public static boolean iniciarSesion(Usuario usuario, Scanner scanner) {
        if (usuario == null) {
            System.out.println("No hay usuarios registrados. Cree uno primero.");
            return false;
        }
        
        System.out.print("Ingrese nombre de usuario: ");
        String username = scanner.nextLine();
        System.out.print("Ingrese contraseña: ");
        String password = scanner.nextLine();
        
        if (usuario.autenticar(username, password)) {
            System.out.println("Inicio de sesión exitoso.");
            return true;
        } else {
            System.out.println("Credenciales incorrectas.");
            return false;
        }
    }
}