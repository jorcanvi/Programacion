package Ejercicios;

import utils.Entrada;

public class E13 {
    public static void ejecutar(int tamanio) {
        System.out.println("Ejecutando... E13");
        System.out.println("---------------------------------");
        int[] numeros;
        numeros = pedirNumeros(tamanio);
        mostrarNumeros(numeros);
        mostrarCaracteristicas(numeros);

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

    private static void mostrarCaracteristicas(int[] numeros) {
        System.out.println("Total números pares: " + mostrarContadorTipoNumeros(numeros, 0));
        System.out.println("Total números impares: " + mostrarContadorTipoNumeros(numeros, 1));
    }

    private static int mostrarContadorTipoNumeros(int[] numeros, int tipo) {
        int contador = 0;

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 == tipo) {
                contador++;
            }
        }

        return contador;
    }
}
