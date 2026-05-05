package com.pspr.jorge_canteli.casarural.controller.web;

import com.pspr.jorge_canteli.casarural.model.Contacto;
import com.pspr.jorge_canteli.casarural.service.ContactoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Controlador encargado de gestionar la sección de contacto.
 *
 * Incluye tanto la visualización del formulario como el procesamiento
 * de los datos enviados por el usuario.
 */
@Controller
public class ContactoController {

    private final ContactoService contactoService;

    /**
     * Constructor con inyección de dependencias.
     *
     * @param contactoService servicio encargado de gestionar los mensajes de contacto
     */
    public ContactoController(ContactoService contactoService) {
        this.contactoService = contactoService;
    }

    /**
     * Muestra la página de contacto en castellano.
     *
     * @return vista de contacto en castellano
     */
    @GetMapping("/contacto")
    public String contactoEs() {
        return "public/es/contacto";
    }

    /**
     * Muestra la página de contacto en inglés.
     *
     * @return vista de contacto en inglés
     */
    @GetMapping("/en/contact")
    public String contactoEn() {
        return "public/en/contact";
    }

    /**
     * Procesa el envío del formulario de contacto en castellano.
     *
     * @param contacto objeto que recoge los datos del formulario
     * @return redirección a la página de contacto
     */
    @PostMapping("/contacto")
    public String enviarContactoEs(Contacto contacto, Model model) {

        String error = contactoService.validarContacto(contacto);

        if (error != null) {

            switch (error) {
                case "nombre":
                    model.addAttribute("error", "El nombre es obligatorio");
                    break;
                case "email":
                    model.addAttribute("error", "El correo electrónico es obligatorio");
                    break;
                case "mensaje":
                    model.addAttribute("error", "El mensaje es obligatorio");
                    break;
            }

            return "public/es/contacto";
        }

        contactoService.guardar(contacto);

        return "redirect:/contacto?ok";
    }

    /**
     * Procesa el envío del formulario de contacto en inglés.
     *
     * @param contacto objeto que recoge los datos del formulario
     * @return redirección a la página de contacto en inglés
     */
    @PostMapping("/en/contact")
    public String enviarContactoEn(Contacto contacto, Model model) {

        String error = contactoService.validarContacto(contacto);

        if (error != null) {

            switch (error) {
                case "nombre":
                    model.addAttribute("error", "Name is required");
                    break;
                case "email":
                    model.addAttribute("error", "Email is required");
                    break;
                case "mensaje":
                    model.addAttribute("error", "Message is required");
                    break;
            }

            return "public/en/contact";
        }

        contactoService.guardar(contacto);

        return "redirect:/en/contact?ok";
    }
}