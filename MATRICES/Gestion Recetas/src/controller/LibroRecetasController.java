package controller;

import model.LibroRecetas;
import model.Receta;
import service.LibroRecetasService;
import utils.Entrada;
import view.LibroRecetasView;
import view.MensajeView;

public class LibroRecetasController {

    private LibroRecetasService servicio;
    private LibroRecetasView vista;

    private LibroRecetas libroActual;

    public void setLibroActual(LibroRecetas libroActual) {
        this.libroActual = libroActual;
    }

    public void gestionar() {
        int opcion;

        do {
            vista.menuPrincipal();
            opcion = Entrada.leerEntero("Introduce una opcion: ");
            ejecutarOpcion(opcion);
        } while (opcion != 0);
    }

    private void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1: crearReceta();
            case 2: listarRecetas();
            case 3: ; gestionarReceta();
            case 4: ;
        }
    }

    private void listarRecetas() {
        if (libroActual == null) {
            MensajeView.mostrarMensaje("No se encontro el libro de recetas");
            return;
        }

        if (libroActual.getRecetas() == null) {
            MensajeView.mostrarMensaje("No hay ninguna receta actualmente");
            return;
        }

        vista.listarRecetas(libroActual.getRecetas());

    }

    private void crearReceta() {
        Receta receta = servicio.crearReceta();
        servicio.aniadirReceta(receta);
    }

    private void gestionarReceta() {
        listarRecetas();
        int opcion = Entrada.leerEntero("Introduce el número de receta: ");

        Receta receta = recuperarReceta(opcion);

        RecetaController recetaGestion = new RecetaController();
        recetaGestion.setRecetaActual(receta);
        recetaGestion.gestionar();

    }

    private Receta recuperarReceta(int opcion) {
        return libroActual.getRecetas()[opcion-1];
    }

    public LibroRecetasController() {
        this.servicio = new LibroRecetasService();
        this.vista = new LibroRecetasView();
    }
}
