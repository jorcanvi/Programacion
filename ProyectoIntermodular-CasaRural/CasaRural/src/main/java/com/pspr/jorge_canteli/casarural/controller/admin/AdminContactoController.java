package com.pspr.jorge_canteli.casarural.controller.admin;

import com.pspr.jorge_canteli.casarural.service.ContactoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador encargado de mostrar los mensajes de contacto
 * en el panel de administración.
 */
@Controller
public class AdminContactoController {

    private final ContactoService contactoService;

    /**
     * Constructor con inyección de dependencias.
     *
     * @param contactoService servicio encargado de gestionar los mensajes de contacto
     */
    public AdminContactoController(ContactoService contactoService) {
        this.contactoService = contactoService;
    }

    /**
     * Muestra el listado de mensajes de contacto recibidos desde la web pública.
     *
     * @param model objeto que permite enviar datos a la vista
     * @return vista del listado de contactos
     */
    @GetMapping("/admin/contactos")
    public String listar(Model model) {
        model.addAttribute("contactos", contactoService.obtenerTodos());
        return "admin/contactos/lista";
    }
}