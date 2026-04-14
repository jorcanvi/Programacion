package view;

import model.Receta;

public class LibroRecetasView {
    public void menuPrincipal() {
        System.out.println("Menú principal");
        System.out.println("1. Crear Receta");
        System.out.println("2. Listar Recetas");
        System.out.println("3. Ver Receta");
        System.out.println("4. Eliminar Receta");
        System.out.println("0. Salir");
    }

    public void listarRecetas(Receta[] recetas) {
        for (int i = 0; i < recetas.length; i++) {
            System.out.println((i+1) + ". " + recetas[i].getNombre());
        }
    }
}
