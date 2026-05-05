package com.pspr.jorge_canteli.casarural.service;

import com.pspr.jorge_canteli.casarural.model.Contacto;
import com.pspr.jorge_canteli.casarural.repository.ContactoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Servicio encargado de la lógica de negocio relacionada con los mensajes de contacto.
 *
 * Esta clase actúa como intermediaria entre el controlador y el repositorio,
 * permitiendo centralizar tanto la validación básica del formulario como
 * el almacenamiento de los datos en la base de datos.
 */
@Service
public class ContactoService {

    private final ContactoRepository contactoRepository;

    /**
     * Constructor con inyección de dependencias.
     *
     * @param contactoRepository repositorio encargado de acceder a la base de datos
     */
    public ContactoService(ContactoRepository contactoRepository) {
        this.contactoRepository = contactoRepository;
    }

    /**
     * Valida los datos básicos del formulario de contacto.
     *
     * Se comprueba que los campos obligatorios no lleguen vacíos.
     *
     * @param contacto objeto con los datos introducidos por el usuario
     * @return mensaje de error si la validación falla; null si los datos son válidos
     */
    public String validarContacto(Contacto contacto) {

        if (contacto.getNombre() == null || contacto.getNombre().isBlank()) {
            return "nombre";
        }

        if (contacto.getEmail() == null || contacto.getEmail().isBlank()) {
            return "email";
        }

        if (contacto.getMensaje() == null || contacto.getMensaje().isBlank()) {
            return "mensaje";
        }

        return null;
    }

    /**
     * Guarda un nuevo mensaje de contacto en la base de datos.
     *
     * Antes de almacenar el mensaje, se asigna automáticamente
     * la fecha y hora actual de envío.
     *
     * @param contacto objeto con los datos del formulario
     */
    public void guardar(Contacto contacto) {
        contacto.setFechaEnvio(LocalDateTime.now());
        contactoRepository.save(contacto);
    }

    /**
     * Obtiene todos los mensajes de contacto almacenados.
     *
     * Este método será útil más adelante para mostrarlos en el panel
     * de administración.
     *
     * @return lista de mensajes de contacto
     */
    public List<Contacto> obtenerTodos() {
        return contactoRepository.findAll();
    }
}