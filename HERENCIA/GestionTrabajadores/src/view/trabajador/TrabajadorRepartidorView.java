package view.trabajador;

import model.trabajador.Trabajador;
import model.trabajador.TrabajadorRepartidor;

public class TrabajadorRepartidorView extends TrabajadorView {
    @Override
    public void mostrarFicha(Trabajador trabajador) {
        TrabajadorRepartidor trabajadorRepartidor = (TrabajadorRepartidor) trabajador;

        super.mostrarFicha(trabajadorRepartidor);
        System.out.println("\nZona: " + trabajadorRepartidor.getZona());
        System.out.println("Número de entregas: " + trabajadorRepartidor.getNumeroEntregas());
    }
}
