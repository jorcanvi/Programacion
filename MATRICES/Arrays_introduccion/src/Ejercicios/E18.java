package Ejercicios;

import utils.Entrada;

public class E18 {
    public static void ejecutar(int filas, int columnas) {
        System.out.println("Ejecutando... E18");
        System.out.println("---------------------------------");
        int[][] numeros;
        numeros = pedirNumeros(filas, columnas);
        mostrarNumeros(numeros);
        mostrarColumnaEspecial(numeros);

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

    private static void mostrarColumnaEspecial(int[][] numeros) {
        int j = 2;
        System.out.println("\nLos numeros de la columna 2:\n");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i][j] + " ");
        }
        System.out.println();
    }
}
