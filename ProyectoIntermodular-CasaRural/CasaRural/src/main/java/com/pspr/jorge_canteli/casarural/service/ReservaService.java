package com.pspr.jorge_canteli.casarural.service;

import com.pspr.jorge_canteli.casarural.model.Reserva;
import com.pspr.jorge_canteli.casarural.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio encargado de la lógica de negocio relacionada con las reservas.
 *
 * Esta clase actúa como intermediaria entre los controladores y el repositorio,
 * permitiendo centralizar la gestión de las reservas del sistema.
 */
@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    /**
     * Constructor con inyección de dependencias.
     *
     * @param reservaRepository repositorio encargado de acceder a la base de datos
     */
    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    /**
     * Obtiene todas las reservas almacenadas en la base de datos.
     *
     * Este método se utiliza tanto en la web pública como en el panel
     * de administración.
     *
     * @return lista de objetos Reserva
     */
    public List<Reserva> obtenerTodas() {
        return reservaRepository.findAll();
    }

    /**
     * Obtiene una reserva concreta a partir de su identificador.
     *
     * @param id identificador de la reserva
     * @return objeto Reserva correspondiente al identificador indicado
     */
    public Reserva obtenerPorId(Long id) {
        return reservaRepository.findById(id);
    }

    /**
     * Guarda una nueva reserva en la base de datos.
     *
     * @param reserva objeto con los datos de la nueva reserva
     */
    public void guardar(Reserva reserva) {
        reservaRepository.save(reserva);
    }

    /**
     * Actualiza una reserva existente en la base de datos.
     *
     * @param reserva objeto con los nuevos datos de la reserva
     */
    public void actualizar(Reserva reserva) {
        reservaRepository.update(reserva);
    }

    /**
     * Elimina una reserva a partir de su identificador.
     *
     * @param id identificador de la reserva a eliminar
     */
    public void eliminar(Long id) {
        reservaRepository.deleteById(id);
    }
}