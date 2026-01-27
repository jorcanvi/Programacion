package service.trabajador;

import model.trabajador.Trabajador;
import model.trabajador.TrabajadorCocina;
import utils.Entrada;
import view.MainView;

public class TrabajadorCocinaService extends TrabajadorService {

    // Regla de negocio, por eso lo meto en el servicio
    private static final int UMBRAL_PLATOS = 10;

    public Trabajador crearTrabajador(){
        TrabajadorCocina trabajadorCocina = new TrabajadorCocina();

        pedirInformacion(trabajadorCocina);

        trabajadorCocina.setPlatos(Entrada.leerEntero("Número de platos:"));

        return trabajadorCocina;
    }

    public void gestionarTrabajador(Trabajador trabajador){
        TrabajadorCocina trabajadorCocina = (TrabajadorCocina) trabajador;

        if (UMBRAL_PLATOS < trabajadorCocina.getPlatos()) {
            MainView.mostrarMensaje("\nRitmo de trabajo: ALTO (" + trabajadorCocina.getPlatos() + " realizados)");
        } else {
            MainView.mostrarMensaje("\nNúmero de platos: BAJO (" + trabajadorCocina.getPlatos() + " realizados)");
        }
    }


}
