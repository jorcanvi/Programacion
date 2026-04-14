package validator;

import model.Receta;

public class RecetaValidator {

    public boolean validaReceta(Receta receta) {
        return !receta.getNombre().isEmpty() &&
                !receta.getElaboracion().isEmpty();
    }
}
