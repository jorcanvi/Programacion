package Ejercicios;

import utils.Entrada;

public class E4 {
    public static void ejecutar(int tamanio) {
        System.out.println("Ejecutando... E4");
        System.out.println("---------------------------------");
        String[] palabras;
        palabras = pedirPalabras(tamanio);
        mostrarPalabras(palabras);

        System.out.println("---------------------------------\n");

    }

    private static String[] pedirPalabras(int tamanio) {
        String[] palabras = new String[tamanio];
        boolean[] posicionesIntroducidas = new boolean[tamanio];

        boolean salir = false;
        int posicion;
        boolean rellenado;
        do {
            posicion = Entrada.leerEnteroEnRango("Introduce la posición (0-"+ (tamanio - 1) +") en la que se almacenará la palabra: ", 0, 4);
            palabras[posicion] = Entrada.leerString("Introduce una palabra o cadena: ");
            posicionesIntroducidas[posicion] = true;
            rellenado = obtenerNumeroTotalDePosicionesIntroducidas(posicionesIntroducidas);

            salir = Entrada.leerString("Salir? (S/N): ").equalsIgnoreCase("S");

        } while (!rellenado && !salir);


        return palabras;
    }

    private static void mostrarPalabras(String[] palabras) {
        for (int i = 0; i < palabras.length; i++) {
            System.out.println("[" + i + "] -> " + palabras[i] + " ");
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
