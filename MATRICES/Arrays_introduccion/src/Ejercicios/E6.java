package Ejercicios;

import utils.Entrada;

public class E6 {
    public static void ejecutar(int tamanio) {
        System.out.println("Ejecutando... E6");
        System.out.println("---------------------------------");
        int[] numeros;
        numeros = pedirNumeros(tamanio);
        mostrarNumeros(numeros);
        mostrarNumerosEspeciales(numeros);

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

    private static void mostrarNumerosEspeciales(int[] numeros) {
        System.out.println();
        System.out.println("Primer número del vector: " + numeros[0]);
        System.out.println("Último número del vector: " + numeros[numeros.length - 1]);
    }
}
