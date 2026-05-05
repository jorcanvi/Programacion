package com.pspr.jorge_canteli.casarural.repository;

import com.pspr.jorge_canteli.casarural.model.Reserva;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Clase encargada de acceder a la base de datos para gestionar las reservas.
 *
 * Se utilizan consultas SQL manuales mediante JdbcTemplate.
 */
@Repository
public class ReservaRepository {

    private final JdbcTemplate jdbcTemplate;

    /**
     * Constructor con inyección de dependencias.
     *
     * @param jdbcTemplate objeto que permite ejecutar consultas SQL
     */
    public ReservaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Obtiene todas las reservas almacenadas en la base de datos.
     *
     * @return lista de reservas
     */
    public List<Reserva> findAll() {

        String sql = """
                SELECT id, nombre_cliente, telefono, fecha_inicio, fecha_fin
                FROM reservas
                ORDER BY fecha_inicio
                """;

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Reserva(
                        rs.getLong("id"),
                        rs.getString("nombre_cliente"),
                        rs.getString("telefono"),
                        rs.getDate("fecha_inicio").toLocalDate(),
                        rs.getDate("fecha_fin").toLocalDate()
                )
        );
    }

    /**
     * Obtiene una reserva concreta a partir de su identificador.
     *
     * @param id identificador de la reserva
     * @return objeto Reserva
     */
    public Reserva findById(Long id) {

        String sql = """
                SELECT id, nombre_cliente, telefono, fecha_inicio, fecha_fin
                FROM reservas
                WHERE id = ?
                """;

        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                new Reserva(
                        rs.getLong("id"),
                        rs.getString("nombre_cliente"),
                        rs.getString("telefono"),
                        rs.getDate("fecha_inicio").toLocalDate(),
                        rs.getDate("fecha_fin").toLocalDate()
                ), id);
    }

    /**
     * Inserta una nueva reserva en la base de datos.
     *
     * @param reserva objeto con los datos de la reserva
     */
    public void save(Reserva reserva) {

        String sql = """
                INSERT INTO reservas (nombre_cliente, telefono, fecha_inicio, fecha_fin)
                VALUES (?, ?, ?, ?)
                """;

        jdbcTemplate.update(
                sql,
                reserva.getNombreCliente(),
                reserva.getTelefono(),
                reserva.getFechaInicio(),
                reserva.getFechaFin()
        );
    }

    /**
     * Actualiza una reserva existente en la base de datos.
     *
     * @param reserva objeto con los nuevos datos de la reserva
     */
    public void update(Reserva reserva) {

        String sql = """
                UPDATE reservas
                SET nombre_cliente = ?, telefono = ?, fecha_inicio = ?, fecha_fin = ?
                WHERE id = ?
                """;

        jdbcTemplate.update(
                sql,
                reserva.getNombreCliente(),
                reserva.getTelefono(),
                reserva.getFechaInicio(),
                reserva.getFechaFin(),
                reserva.getId()
        );
    }

    /**
     * Elimina una reserva a partir de su identificador.
     *
     * @param id identificador de la reserva a eliminar
     */
    public void deleteById(Long id) {

        String sql = "DELETE FROM reservas WHERE id = ?";

        jdbcTemplate.update(sql, id);
    }
}