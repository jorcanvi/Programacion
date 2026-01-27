package view.trabajador;

import model.trabajador.Trabajador;
import model.trabajador.TrabajadorSala;

public class TrabajadorSalaView extends TrabajadorView{

    @Override
    public void mostrarFicha(Trabajador trabajador) {
        TrabajadorSala trabajadorSala = (TrabajadorSala) trabajador;

        super.mostrarFicha(trabajadorSala);
        System.out.println("\nPropina: " + trabajadorSala.getPropina() + "%");
    }
}
