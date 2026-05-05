package com.pspr.jorge_canteli.casarural.controller.web;

import com.pspr.jorge_canteli.casarural.service.ReservaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador encargado de gestionar las reservas en la web pública.
 *
 * Aquí se centraliza toda la lógica relacionada con la visualización
 * y gestión de la disponibilidad de la casa rural.
 */
@Controller
public class ReservaController {

    private final ReservaService reservaService;

    /**
     * Constructor con inyección de dependencias.
     *
     * @param reservaService servicio encargado de gestionar las reservas
     */
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    /**
     * Muestra la página de reservas en castellano.
     *
     * @param model objeto que permite enviar datos a la vista
     * @return vista de reservas en castellano
     */
    @GetMapping("/reservas")
    public String reservasEs(Model model) {
        model.addAttribute("reservas", reservaService.obtenerTodas());
        return "public/es/reservas";
    }

    /**
     * Muestra la página de reservas en inglés.
     *
     * @param model objeto que permite enviar datos a la vista
     * @return vista de reservas en inglés
     */
    @GetMapping("/en/bookings")
    public String reservasEn(Model model) {
        model.addAttribute("reservas", reservaService.obtenerTodas());
        return "public/en/bookings";
    }
}