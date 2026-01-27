package Service.trabajador;

import Model.trabajador.Trabajador;
import Model.trabajador.TrabajadorRepartidor;
import Utils.Entrada;
import View.MainView;

public class TrabajadorRepartidorService extends TrabajadorService{

    public Trabajador crearTrabajador(){
        TrabajadorRepartidor trabajadorRepartidor = new TrabajadorRepartidor();

        pedirInformacion(trabajadorRepartidor);

        trabajadorRepartidor.setZona(Entrada.leerString("Zona:"));
        trabajadorRepartidor.setNumeroEntregas(Entrada.leerEntero("Número de entregas:"));

        return trabajadorRepartidor;
    }

    public void gestionarTrabajador(Trabajador trabajador){
        TrabajadorRepartidor trabajadorRepartidor = (TrabajadorRepartidor) trabajador;

        float plus;
        do {
            plus = Entrada.leerDecimal("\nPlus por entrega:");

            if (plus < 0) {
                MainView.mostrarMensaje("Introduce un valor mayor que 0");
            }
        } while (plus < 0);

        MainView.mostrarMensaje("Plus por entregas: " + (plus * trabajadorRepartidor.getNumeroEntregas()));
    }
}
