import controller.LibroRecetasController;
import model.LibroRecetas;

public class App {
    public static void main(String[] args) {
        LibroRecetasController libroGestionRecetas = new LibroRecetasController();

        LibroRecetas libro = new LibroRecetas();
        libroGestionRecetas.setLibroActual(libro);
        libroGestionRecetas.gestionar();

    }
}
