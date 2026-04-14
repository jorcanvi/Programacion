package controller;

import model.Receta;
import service.RecetaService;
import utils.Entrada;
import view.RecetaView;

public class RecetaController {

    private RecetaService servicio;
    private RecetaView vista;

    private Receta recetaActual;

    public void setRecetaActual(Receta recetaActual) {
        this.recetaActual = recetaActual;
    }

    public void gestionar() {
        int opcion;

        do {
            vista.menuReceta(recetaActual);
            opcion = Entrada.leerEntero("Seleccione una opción: ");
            ejecutarOpcion(opcion);
        } while (opcion != 0);
    }

    private void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:;
            case 2:;

        }
    }

    public RecetaController() {
        this.servicio = new RecetaService();
        this.vista = new RecetaView();
    }
}
