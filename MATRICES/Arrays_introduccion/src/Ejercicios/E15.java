package Ejercicios;

import model.Estudiante;
import utils.Entrada;

public class E15 {
    public static void ejecutar(int tamanio) {
        System.out.println("Ejecutando... E15");
        System.out.println("---------------------------------");
        Estudiante[] estudiantes;
        estudiantes = pedirEstudiantes(tamanio);
        mostrarEstudiantes(estudiantes);

        System.out.println("---------------------------------\n");

    }

    private static Estudiante[] pedirEstudiantesV1(int tamanio) {
        Estudiante[] estudiantes = new Estudiante[tamanio];

        for (int i = 0; i < estudiantes.length; i++) {
            System.out.println("Datos del entudiante:\n");
            estudiantes[i] = new Estudiante(
                    Entrada.leerString("Nombre:"),
                    Entrada.leerString("Apellidos:"),
                    Entrada.leerString("Teléfono:")
            );
        }

        return estudiantes;
    }

    private static Estudiante[] pedirEstudiantes(int tamanio) {
        Estudiante[] estudiantes = new Estudiante[tamanio];
        boolean[] posicionesIntroducidas = new boolean[tamanio];

        boolean salir = false;
        int posicion;
        boolean rellenado;
        do {
            posicion = Entrada.leerEnteroEnRango("Introduce la posición (0-"+ (tamanio - 1) +") en la que se almacenará el número: ", 0, 4);
            estudiantes[posicion] = new Estudiante(
                    Entrada.leerString("Nombre:"),
                    Entrada.leerString("Apellidos:"),
                    Entrada.leerString("Teléfono:")
            );
            posicionesIntroducidas[posicion] = true;
            rellenado = obtenerNumeroTotalDePosicionesIntroducidas(posicionesIntroducidas);

            salir = Entrada.leerString("Salir? (S/N): ").equalsIgnoreCase("S");

        } while (!rellenado && !salir);


        return estudiantes;
    }

    private static void mostrarEstudiantes(Estudiante[] estudiantes) {
        System.out.println("\nEstudiantes creados:\n");
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.println(estudiantes[i]);
        }
    }

    private static boolean obtenerNumeroTotalDePosicionesIntroducidas(boolean[] posiciones) {
        boolean rellenado = true;

        for (int i = 0; i < posiciones.length; i++) {
            if (!posiciones[i]) {
                rellenado = false;
            }
        }

        return rellenado;
    }



}
