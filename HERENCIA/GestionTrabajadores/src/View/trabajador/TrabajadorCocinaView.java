package View.trabajador;

import Model.trabajador.Trabajador;
import Model.trabajador.TrabajadorCocina;

public class TrabajadorCocinaView extends TrabajadorView {

    @Override
    public void mostrarFicha(Trabajador trabajador) {
        TrabajadorCocina trabajadorCocina = (TrabajadorCocina) trabajador;

        super.mostrarFicha(trabajadorCocina);
        System.out.println("\nNúmero de platos: " + trabajadorCocina.getPlatos());
    }
}
