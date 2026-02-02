package Ejercicios;

import utils.Entrada;

public class E14 {
    public static void ejecutar(int tamanio) {
        System.out.println("Ejecutando... E14");
        System.out.println("---------------------------------");
        String[] palabras;
        palabras = pedirPalabras(tamanio);
        mostrarPalabras(palabras);
        mostrarPalabrasQueCumplan(palabras);

        System.out.println("---------------------------------\n");

    }

    private static String[] pedirPalabras(int tamanio) {
        String[] palabras = new String[tamanio];

        for (int i = 0; i < palabras.length; i++) {
            palabras[i] = Entrada.leerString("Introduce una palabra o cadena: ");
        }

        return palabras;
    }

    private static void mostrarPalabras(String[] palabras) {
        for (int i = 0; i < palabras.length; i++) {
            System.out.println("[" + i + "] -> " + palabras[i] + " ");
        }
    }

    private static void mostrarPalabrasQueCumplan(String[] palabras) {
        System.out.println("\n Palabras con más de 5 caracteres:");
        for (int i = 0; i < palabras.length; i++) {
            if (palabras[i].length() > 5) {
                System.out.println("[" + i + "] -> " + palabras[i] + " ");
            }
        }
    }


}
