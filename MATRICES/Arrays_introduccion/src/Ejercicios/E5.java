package Ejercicios;

import utils.Entrada;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class E5 {
    public static void ejecutar(int tamanio) {
        System.out.println("Ejecutando... E5");
        System.out.println("---------------------------------");
        int[] numeros;
        numeros = rellenarNumeros(tamanio);
        mostrarNumeros(numeros);

        System.out.println("---------------------------------\n");

    }

    private static int[] rellenarNumeros(int tamanio) {
        int[] numeros = new int[tamanio];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = ThreadLocalRandom.current().nextInt(1, 5);
        }

        return numeros;
    }

    private static void mostrarNumeros(int[] numeros) {
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("[" + i + "] -> " + numeros[i] + " ");
        }
    }
}
