package service;

import model.LibroRecetas;
import model.Receta;
import utils.Entrada;

public class LibroRecetasService {

    public Receta crearReceta() {
        RecetaService recetaService = new RecetaService();

        return recetaService.crearReceta();
    }

    public boolean aniadirReceta(Receta receta, LibroRecetas libroRecetas) {
        libroRecetas.setRecetas(incrementarTamanioRecetas(libroRecetas.getRecetas()));
        libroRecetas.getRecetas()[libroRecetas.getRecetas().length - 1] = receta;

        return true;
    }

    private Receta[] incrementarTamanioRecetas(Receta[] recetas) {
        if (recetas == null) {
            return new Receta[0];
        }

        Receta[] recetasCopia = new Receta[recetas.length+1];
        for (int i = 0; i < recetasCopia.length; i++) {
            recetasCopia[i] = recetas[i];
        }

        return recetasCopia;
    }
}
