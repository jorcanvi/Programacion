package Validator.trabajador;

import Model.trabajador.Trabajador;

public class TrabajadorValidator {
    public boolean validarNombre(String nombre) {
        return !nombre.equals("");
    }
}
