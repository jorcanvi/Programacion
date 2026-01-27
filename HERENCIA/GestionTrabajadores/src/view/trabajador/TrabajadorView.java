package view.trabajador;

import model.trabajador.Trabajador;

public abstract class TrabajadorView {

    public void mostrarFicha(Trabajador trabajador) {
        System.out.println("\nFicha de trabajador");
        System.out.println("--------------------------");
        System.out.println("Nombre: " + trabajador.getNombre());
        System.out.println("Apellidos: " + trabajador.getApellidos());
        System.out.println("Turno: " + trabajador.getTurno());
    }
}
