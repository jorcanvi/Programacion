package Service.trabajador;

import Model.trabajador.Trabajador;
import Model.trabajador.TrabajadorCocina;
import Utils.Entrada;
import View.MainView;

public class TrabajadorCocinaService extends TrabajadorService {


    public Trabajador crearTrabajador(){
        TrabajadorCocina trabajadorCocina = new TrabajadorCocina();

        pedirInformacion(trabajadorCocina);

        trabajadorCocina.setPlatos(Entrada.leerEntero("Número de platos:"));

        return trabajadorCocina;
    }

    public void gestionarTrabajador(Trabajador trabajador){
        TrabajadorCocina trabajadorCocina = (TrabajadorCocina) trabajador;

        if (trabajadorCocina.UMBRAL_PLATOS < trabajadorCocina.getPlatos()) {
            MainView.mostrarMensaje("\nRitmo de trabajo: ALTO (" + trabajadorCocina.getPlatos() + " realizados)");
        } else {
            MainView.mostrarMensaje("\nNúmero de platos: BAJO (" + trabajadorCocina.getPlatos() + " realizados)");
        }
    }


}
