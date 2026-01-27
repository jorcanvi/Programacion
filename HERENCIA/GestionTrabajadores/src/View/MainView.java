package View;

import Model.trabajador.Trabajador;

public class MainView {
    public static void menuPrincipal(Trabajador trabajador) {
        System.out.println("\nMenu Principal");
        System.out.println("1. Crear trabajador de sala");
        System.out.println("2. Crear trabajador de cocina");
        System.out.println("3. Crear trabajador de reparto");

        if (trabajador != null) {
            System.out.println("4. Mostrar ficha");
            System.out.println("5. Gestionar parte específica");
        }

        System.out.println("0. Salir");
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
