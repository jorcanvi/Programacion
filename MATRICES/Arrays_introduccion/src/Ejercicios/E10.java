package Ejercicios;

import utils.Entrada;

public class E10 {
    public static void ejecutar(int tamanio) {
        System.out.println("Ejecutando... E10");
        System.out.println("---------------------------------");
        int[] numeros;
        numeros = pedirNumeros(tamanio);
        mostrarNumeros(numeros);
        mostrarMedia(numeros);

        System.out.println("---------------------------------\n");

    }

    private static int[] pedirNumeros(int tamanio) {
        int[] numeros = new int[tamanio];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = Entrada.leerEntero("Introduce un numero: ");
        }

        return numeros;
    }

    private static void mostrarNumeros(int[] numeros) {
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("[" + i + "] -> " + numeros[i] + " ");
        }
    }

    private static void mostrarMedia(int[] numeros) {
        int suma = 0;

        for (int i = 0; i < numeros.length; i++) {
            suma += numeros[i];
        }
        System.out.println();
        System.out.printf("La media es: %.3f%n", (float) suma / numeros.length);
    }
}
