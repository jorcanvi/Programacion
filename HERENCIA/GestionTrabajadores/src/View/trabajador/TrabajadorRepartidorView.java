package View.trabajador;

import Model.trabajador.Trabajador;
import Model.trabajador.TrabajadorCocina;
import Model.trabajador.TrabajadorRepartidor;

public class TrabajadorRepartidorView extends TrabajadorView {
    @Override
    public void mostrarFicha(Trabajador trabajador) {
        TrabajadorRepartidor trabajadorRepartidor = (TrabajadorRepartidor) trabajador;

        super.mostrarFicha(trabajadorRepartidor);
        System.out.println("\nZona: " + trabajadorRepartidor.getZona());
        System.out.println("Número de entregas: " + trabajadorRepartidor.getNumeroEntregas());
    }
}
