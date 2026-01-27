package service.trabajador;

import model.trabajador.Trabajador;
import utils.Entrada;
import validator.trabajador.TrabajadorValidator;
import view.MainView;

public abstract class TrabajadorService {

    public abstract Trabajador crearTrabajador();

    protected void pedirInformacion(Trabajador trabajador) {
        TrabajadorValidator validator = new TrabajadorValidator();

        pedirNombre(trabajador, validator);


        trabajador.setApellidos(Entrada.leerString("Apellidos:"));
        trabajador.setTurno(Entrada.leerString("Turno:"));
    }

    private void pedirNombre(Trabajador trabajador, TrabajadorValidator validator) {
        boolean valido;

        do {
            valido = false;
            trabajador.setNombre(Entrada.leerString("Nombre:"));
            valido = validator.validarNombre(trabajador.getNombre());

            if (!valido) {
                MainView.mostrarMensaje("El nombre no puede estar vacio");
            }

        } while (!valido);
    }

    public abstract void gestionarTrabajador(Trabajador trabajador);

}
