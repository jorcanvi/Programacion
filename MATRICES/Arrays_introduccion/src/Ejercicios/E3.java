package Ejercicios;

import utils.Entrada;

public class E3 {
    public static void ejecutar() {
        System.out.println("Ejecutando... E3");
        System.out.println("---------------------------------");
        int tamanio = Entrada.leerEntero("Introduce el tamaño del array: ");
        int[] numeros;
        numeros = pedirNumeros(tamanio);
        mostrarNumeros(numeros);

        System.out.println("---------------------------------\n");

    }

    private static int[] pedirNumeros(int tamanio) {
        int[] numeros = new int[tamanio];
        boolean[] posicionesIntroducidas = new boolean[tamanio];

        boolean salir = false;
        int posicion;
        boolean rellenado;
        do {
            posicion = Entrada.leerEnteroEnRango("Introduce la posición (0-"+ (tamanio - 1) +") en la que se almacenará el número: ", 0, 4);
            numeros[posicion] = Entrada.leerEntero("Introduce un numero: ");
            posicionesIntroducidas[posicion] = true;
            rellenado = obtenerNumeroTotalDePosicionesIntroducidas(posicionesIntroducidas);

            salir = Entrada.leerString("Salir? (S/N): ").equalsIgnoreCase("S");

        } while (!rellenado && !salir);


        return numeros;
    }

    private static void mostrarNumeros(int[] numeros) {
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("[" + i + "] -> " + numeros[i] + " ");
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
