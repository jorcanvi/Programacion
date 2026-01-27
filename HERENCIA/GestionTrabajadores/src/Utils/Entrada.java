package Utils;
import java.util.Scanner;

/**
 * Clase utilitaria para la lectura de datos por consola.
 *
 * Centraliza la interacción con el usuario en lo referente
 * a la entrada de datos, evitando el uso de Scanner en múltiples
 * clases de la aplicación.
 */
public class Entrada {

    /**
     * Scanner único para la lectura desde consola.
     */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Lee un número entero introducido por el usuario.
     *
     * El método mostrará el mensaje indicado y repetirá la petición
     * hasta que el usuario introduzca un valor entero válido.
     *
     * @param mensaje texto que se mostrará al usuario antes de leer el valor
     * @return número entero introducido por el usuario
     */
    public static int leerEntero(String mensaje) {

        int valor;
        boolean valido = false;

        do {
            System.out.print(mensaje);

            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();
                valido = true;
            } else {
                System.out.println("ERROR: Debe introducir un número entero.");
                scanner.next(); // descartar entrada incorrecta
                valor = 0;
            }

        } while (!valido);

        scanner.nextLine();

        return valor;
    }

    /**
     * Lee un número decimal introducido por el usuario.
     *
     * El método mostrará el mensaje indicado y repetirá la petición
     * hasta que el usuario introduzca un valor decimal válido.
     *
     * @param mensaje texto que se mostrará al usuario antes de leer el valor
     * @return número decimal introducido por el usuario
     */
    public static float leerDecimal(String mensaje) {

        float valor;
        boolean valido = false;

        do {
            System.out.print(mensaje);

            if (scanner.hasNextFloat()) {
                valor = scanner.nextFloat();
                valido = true;
            } else {
                System.out.println("ERROR: Debe introducir un número decimal.");
                scanner.next(); // descartar entrada incorrecta
                valor = 0;
            }

        } while (!valido);

        scanner.nextLine();

        return valor;
    }

    /**
     * Lee una cadena de texto
     *
     * El método mostrará el mensaje indicado y devolverá la entrada del usuario.
     *
     * @param mensaje texto que se mostrará al usuario antes de leer el valor
     * @return cadena de texto introducido por el usuario
     */
    public static String leerString(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }
}
