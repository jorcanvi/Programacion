package com.pspr.jorge_canteli.casarural.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador principal del panel de administración.
 */
@Controller
public class AdminController {

    /**
     * Muestra el dashboard del CMS.
     */
    @GetMapping("/admin")
    public String index() {
        return "admin/index";
    }
}