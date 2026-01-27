package Controller;

import Model.trabajador.Trabajador;
import Service.trabajador.TrabajadorCocinaService;
import Service.trabajador.TrabajadorRepartidorService;
import Service.trabajador.TrabajadorSalaService;
import Service.trabajador.TrabajadorService;
import View.MainView;
import View.trabajador.TrabajadorCocinaView;
import View.trabajador.TrabajadorRepartidorView;
import View.trabajador.TrabajadorSalaView;
import View.trabajador.TrabajadorView;

public class TrabajadorController {
    private TrabajadorService servicio;
    private TrabajadorView vista;
    private Trabajador trabajador;

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void gestionar(int opcion) {
        switch (opcion) {
            case 1-> {
                servicio = new TrabajadorSalaService();
                vista = new TrabajadorSalaView();
                trabajador = servicio.crearTrabajador();
            }
            case 2-> {
                servicio = new TrabajadorCocinaService();
                vista = new TrabajadorCocinaView();
                trabajador = servicio.crearTrabajador();
            }
            case 3-> {
                servicio = new TrabajadorRepartidorService();
                vista = new TrabajadorRepartidorView();
                trabajador = servicio.crearTrabajador();
            }
            case 4-> {
                if (trabajador != null) {
                    vista.mostrarFicha(trabajador);
                } else {
                    MainView.mostrarMensaje("\nNo se encontro el trabajador" +
                            "\n----------------------------------------\n");
                }
            }
            case 5-> {
                servicio.gestionarTrabajador(trabajador);
            }
        }
    }


}
