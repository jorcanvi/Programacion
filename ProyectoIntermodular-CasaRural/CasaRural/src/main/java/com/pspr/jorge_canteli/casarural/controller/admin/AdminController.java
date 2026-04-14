package com.pspr.jorge_canteli.casarural.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador encargado de gestionar las vistas del panel de administración (CMS).
 *
 * Este controlador agrupa las rutas que permiten acceder a la parte privada
 * de la aplicación, donde se gestionará la información de la casa rural.
 */
@Controller
public class AdminController {

    /**
     * Método que gestiona la petición a la página principal del panel de administración.
     *
     * Cuando el usuario accede a la ruta "/admin", se muestra la vista principal
     * del CMS.
     *
     * @return nombre de la plantilla correspondiente al panel de administración
     */
    @GetMapping("/admin")
    public String adminHome() {
        return "admin/index";
    }
}