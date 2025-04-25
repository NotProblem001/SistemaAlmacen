package com.example;

import java.util.Scanner;

public class SistemaAlmacen {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Usuario usuario = null;
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            mostrarMenuPrincipal();
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    usuario = Usuario.crearUsuario(scanner);
                    break;
                case 2:
                    if (Usuario.iniciarSesion(usuario, scanner)) {
                    }
                    break;
                case 3:
                    inventario.procesarCompra(usuario, scanner);
                    break;
                case 4:
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
        scanner.close();
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("=== Sistema de Almacén ===");
        System.out.println("1.- Crear usuario");
        System.out.println("2.- Entrar por usuario");
        System.out.println("3.- Realizar compra");
        System.out.println("4.- Salir");
        System.out.println("========");
        System.out.print("Elija una opción: ");
    }
}