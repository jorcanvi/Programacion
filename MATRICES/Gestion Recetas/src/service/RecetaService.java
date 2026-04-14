package service;

import model.Ingrediente;
import model.Receta;
import utils.Entrada;
import validator.RecetaValidator;
import view.MensajeView;

public class RecetaService {

    private RecetaValidator recetaValidator = new RecetaValidator();

    public Receta crearReceta() {
        Receta receta = new Receta();

        boolean valido;

        MensajeView.mostrarMensaje("Creando receta......");
        do {
            receta.setNombre(Entrada.leerString("\tNombre de la receta: "));
            receta.setElaboracion(Entrada.leerString("\tElaboracion: "));

            valido = recetaValidator.validaReceta(receta);

            if (!valido) {
                MensajeView.mostrarMensaje("\t¡ERROR! Todos los datos son obligatorios o alguno está incorrecto");
            }

        } while (!valido);

        return receta;
    }

    public void pedirIngredientes(Receta receta) {
        boolean continuar;

        do {
            crearIngrediente(receta);

            continuar = Entrada.leerString("¿Quieres introducir otro ingrediente (S/N)").toLowerCase().equals("s");
        } while (!continuar);

    }

    public void crearIngrediente(Receta receta) {
        Ingrediente ingrediente = new Ingrediente();

        boolean valido;

        MensajeView.mostrarMensaje("Creando ingrediente......");

        do {
            ingrediente
        }
    }
}
