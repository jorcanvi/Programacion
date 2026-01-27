package validator.trabajador;

public class TrabajadorValidator {
    public boolean validarNombre(String nombre) {
        return !nombre.equals("");
    }
}
