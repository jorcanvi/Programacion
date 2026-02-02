import data.Rol;
import model.Estudiante;
import utils.Entrada;
import view.MainView;

public class App {
    private static int[][] info;

    public static void main(String[] args) {
        test();
//        iniciarConfiguracion();
//        ejecutar();
    }

    private static void test() {

        int[] dataEnteros;
        String[] dataCadenas;
        Estudiante[] dataEstudiante;



        int[][] tableroNumeros;


        dataEnteros = new int[3];
        dataCadenas = new String[4];
        dataEstudiante = new Estudiante[5];

        tableroNumeros = new int[3][5];


        int[] dataEnterosV2 = {8,2,13,4,25};
        int[][] dataMatrizV2 = { {1,8,5}, {4,5,7}, {10,456,65} };

        int[][] dataMatrizV3 = { {1,8,5}, {4,5}, {10,456,65} };






        dataEnteros[1] = 2;
        dataCadenas[2] = "Jorge";
        dataEstudiante[3] = new Estudiante();










    }

    private static void iniciarConfiguracion() {
        crearMatriz();
        rellenarMatriz();
    }

    private static void crearMatriz() {
        int filas = pedirValor("Introduce la filas de la matriz: ");
        int columnas = pedirValor("Introduce la columnas de la matriz: ");

        info = new int[filas][columnas];
    }

    private static int pedirValor(String texto) {
        int numero;
        do {
            numero = Entrada.leerEntero(texto);
        } while (numero < 0 || numero >= 100);

        return numero;
    }

    private static void rellenarMatriz() {
        for (int i = 0; i < info.length; i++) {
            for (int j = 0; j < info[i].length; j++) {
                info[i][j] = Entrada.leerEntero("Introduce valor:");
            }
        }
    }


    private static void ejecutar() {
        int opcion;

        do {
            MainView.menuPrincipal();
            opcion = Entrada.leerEntero("Introduce la opcion: ");
            ejecutarOpcion(opcion);
        } while (opcion != 0);

    }

    private static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1-> imprimirMatriz();
            case 2-> invertirMatriz();
        }
    }

    private static void imprimirMatriz() {
        System.out.println("Imprimir matriz:");
        for (int i = 0; i < info.length; i++) {
            for (int j = 0; j < info[i].length; j++) {
                System.out.print(info[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void invertirMatriz() {
        System.out.println("Invirtiendo diagonal:");
        for (int i = 0; i < info.length; i++) {
            for (int j = 0; j < info[i].length; j++) {

                System.out.println();
            }
        }
    }
}
