package Ejercicios;

import utils.Entrada;

public class E12 {
    public static void ejecutar(int tamanio) {
        System.out.println("Ejecutando... E12");
        System.out.println("---------------------------------");
        int[] numeros;
        numeros = pedirNumeros(tamanio);
        mostrarNumeros(numeros);
        mostrarMenor(numeros);

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

    private static void mostrarMenor(int[] numeros) {
        int menor = numeros[0];

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] < menor) {
                menor = numeros[i];
            }
        }
        System.out.println();
        System.out.println("El número menor es: " + menor);
    }
}
