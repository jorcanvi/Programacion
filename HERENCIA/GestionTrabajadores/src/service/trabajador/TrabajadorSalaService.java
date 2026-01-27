package service.trabajador;

import model.trabajador.Trabajador;
import model.trabajador.TrabajadorSala;
import utils.Entrada;
import view.MainView;

public class TrabajadorSalaService extends TrabajadorService{

    public Trabajador crearTrabajador(){
        TrabajadorSala trabajadorSala = new TrabajadorSala();

        pedirInformacion(trabajadorSala);

        trabajadorSala.setPropina(Entrada.leerEntero("Propina:"));

        return trabajadorSala;
    }

    public void gestionarTrabajador(Trabajador trabajador){
        TrabajadorSala trabajadorSala = (TrabajadorSala) trabajador;

        float totalCobrado;
        do {
            totalCobrado = Entrada.leerDecimal("\nTotal Cobrado:");

            if (totalCobrado < 0) {
                MainView.mostrarMensaje("Introduce un valor mayor que 0");
            }
        } while (totalCobrado < 0);

        MainView.mostrarMensaje("Propinas generadas: " + (totalCobrado * trabajadorSala.getPropina()) / 100);
    }
}
