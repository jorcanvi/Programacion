import Controller.TrabajadorController;
import Utils.Entrada;
import View.MainView;

public class App {

    static TrabajadorController gestionTrabajadores = new TrabajadorController();

    public static void main(String[] args) {
        System.out.println("Aplicación Trabajadores");

        int opcion;
        do {
            MainView.menuPrincipal(gestionTrabajadores.getTrabajador());
            opcion = Entrada.leerEntero("Introduce la opcion: ");
            ejecutarOpcion(opcion);
        } while (opcion != 0);

        System.out.println("Cerrando programa");
    }

    private static void ejecutarOpcion(int opcion) {
        gestionTrabajadores.gestionar(opcion);
    }
}
