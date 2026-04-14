package view;

import model.Receta;

public class RecetaView {

    public void menuReceta(Receta receta) {
        System.out.println("Receta " + receta.getNombre());
        System.out.println("1. Ver elaboracion");
        System.out.println("2. Ver ingredientes");
        System.out.println("3. Gestionar ingredientes");
        System.out.println("0. Volver");
    }
}
