import controller.TrabajadorController;
import utils.Entrada;
import view.MainView;

public class App {

    static TrabajadorController gestionTrabajadores = new TrabajadorController();

    public static void main(String[] args) {
        MainView.mostrarMensaje("Aplicación Trabajadores");

        int opcion;
        do {
            MainView.menuPrincipal(gestionTrabajadores.getTrabajador());
            opcion = Entrada.leerEntero("Introduce la opcion: ");
            ejecutarOpcion(opcion);
        } while (opcion != 0);

        MainView.mostrarMensaje("Cerrando programa");
    }

    private static void ejecutarOpcion(int opcion) {
        gestionTrabajadores.gestionar(opcion);
    }
}
