package View.trabajador;

import Model.trabajador.Trabajador;
import Model.trabajador.TrabajadorSala;

public class TrabajadorSalaView extends TrabajadorView{

    @Override
    public void mostrarFicha(Trabajador trabajador) {
        TrabajadorSala trabajadorSala = (TrabajadorSala) trabajador;

        super.mostrarFicha(trabajadorSala);
        System.out.println("\nPropina: " + trabajadorSala.getPropina() + "%");
    }
}
