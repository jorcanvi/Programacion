package view.trabajador;

import model.trabajador.Trabajador;
import model.trabajador.TrabajadorCocina;

public class TrabajadorCocinaView extends TrabajadorView {

    @Override
    public void mostrarFicha(Trabajador trabajador) {
        TrabajadorCocina trabajadorCocina = (TrabajadorCocina) trabajador;

        super.mostrarFicha(trabajadorCocina);
        System.out.println("\nNúmero de platos: " + trabajadorCocina.getPlatos());
    }
}
