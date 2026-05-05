package com.pspr.jorge_canteli.casarural.controller.api;

import com.pspr.jorge_canteli.casarural.model.Reserva;
import com.pspr.jorge_canteli.casarural.service.ReservaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador REST encargado de exponer la información de reservas en formato JSON.
 *
 * Este tipo de controlador no devuelve vistas Thymeleaf, sino datos que pueden
 * ser consumidos por JavaScript u otros clientes.
 */
@RestController
public class ReservaRestController {

    private final ReservaService reservaService;

    /**
     * Constructor con inyección de dependencias.
     *
     * @param reservaService servicio encargado de gestionar las reservas
     */
    public ReservaRestController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    /**
     * Devuelve la lista completa de reservas en formato JSON.
     *
     * Este endpoint podrá utilizarse más adelante para alimentar componentes
     * dinámicos, como un calendario de disponibilidad.
     *
     * @return lista de reservas
     */
    @GetMapping("/api/reservas")
    public List<Reserva> obtenerReservas() {
        return reservaService.obtenerTodas();
    }
}