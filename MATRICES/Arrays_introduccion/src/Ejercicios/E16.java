package Ejercicios;

import utils.Entrada;

public class E16 {
    public static void ejecutar(int filas, int columnas) {
        System.out.println("Ejecutando... E16");
        System.out.println("---------------------------------");
        int[][] numeros;
        numeros = pedirNumeros(filas, columnas);
        mostrarNumeros(numeros);

        System.out.println("---------------------------------\n");

    }

    private static int[][] pedirNumeros(int filas, int columnas) {
        int[][] numeros = new int[filas][columnas];

        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                numeros[i][j] = Entrada.leerEntero("Introduce un numero: ");
            }
        }

        return numeros;
    }

    private static void mostrarNumeros(int[][] numeros) {
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                System.out.print(numeros[i][j] + " ");
            }
            System.out.println();
        }
    }
}
