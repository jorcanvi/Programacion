package com.pspr.jorge_canteli.casarural.controller.admin;

import com.pspr.jorge_canteli.casarural.model.Reserva;
import com.pspr.jorge_canteli.casarural.service.ReservaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador encargado de gestionar las reservas desde el panel de administración.
 *
 * Permite listar, crear, editar y eliminar reservas mediante vistas Thymeleaf.
 */
@Controller
@RequestMapping("/admin/reservas")
public class AdminReservaController {

    private final ReservaService reservaService;

    /**
     * Constructor con inyección de dependencias.
     *
     * @param reservaService servicio encargado de gestionar las reservas
     */
    public AdminReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    /**
     * Muestra el listado de reservas del sistema.
     *
     * @param model objeto que permite enviar datos a la vista
     * @return vista del listado de reservas
     */
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("reservas", reservaService.obtenerTodas());
        return "admin/reservas/lista";
    }

    /**
     * Muestra el formulario para crear una nueva reserva.
     *
     * @param model objeto que permite enviar datos a la vista
     * @return vista del formulario de reservas
     */
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("reserva", new Reserva());
        return "admin/reservas/formulario";
    }

    /**
     * Guarda una nueva reserva en la base de datos.
     *
     * @param reserva objeto con los datos introducidos en el formulario
     * @return redirección al listado de reservas
     */
    @PostMapping("/guardar")
    public String guardar(Reserva reserva) {
        reservaService.guardar(reserva);
        return "redirect:/admin/reservas";
    }

    /**
     * Muestra el formulario de edición de una reserva existente.
     *
     * @param id identificador de la reserva a editar
     * @param model objeto que permite enviar datos a la vista
     * @return vista del formulario de reservas
     */
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("reserva", reservaService.obtenerPorId(id));
        return "admin/reservas/formulario";
    }

    /**
     * Actualiza una reserva existente en la base de datos.
     *
     * @param reserva objeto con los nuevos datos de la reserva
     * @return redirección al listado de reservas
     */
    @PostMapping("/actualizar")
    public String actualizar(Reserva reserva) {
        reservaService.actualizar(reserva);
        return "redirect:/admin/reservas";
    }

    /**
     * Elimina una reserva a partir de su identificador.
     *
     * @param id identificador de la reserva a eliminar
     * @return redirección al listado de reservas
     */
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        reservaService.eliminar(id);
        return "redirect:/admin/reservas";
    }
}