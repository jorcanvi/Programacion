package com.pspr.jorge_canteli.casarural.repository;

import com.pspr.jorge_canteli.casarural.model.Contacto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Clase encargada de acceder a la base de datos para gestionar los mensajes de contacto.
 */
@Repository
public class ContactoRepository {

    private final JdbcTemplate jdbcTemplate;

    /**
     * Constructor con inyección de dependencias.
     *
     * @param jdbcTemplate objeto que permite ejecutar consultas SQL
     */
    public ContactoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Guarda un nuevo mensaje de contacto en la base de datos.
     *
     * @param contacto objeto con los datos del formulario
     */
    public void save(Contacto contacto) {

        String sql = """
                INSERT INTO contactos (nombre, email, telefono, mensaje, fecha_envio)
                VALUES (?, ?, ?, ?, ?)
                """;

        jdbcTemplate.update(
                sql,
                contacto.getNombre(),
                contacto.getEmail(),
                contacto.getTelefono(),
                contacto.getMensaje(),
                Timestamp.valueOf(contacto.getFechaEnvio())
        );
    }

    /**
     * Obtiene todos los mensajes de contacto.
     *
     * Este método será útil más adelante para el CMS.
     *
     * @return lista de contactos
     */
    public List<Contacto> findAll() {

        String sql = """
                SELECT id, nombre, email, telefono, mensaje, fecha_envio
                FROM contactos
                ORDER BY fecha_envio DESC
                """;

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Contacto(
                        rs.getLong("id"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("telefono"),
                        rs.getString("mensaje"),
                        rs.getTimestamp("fecha_envio").toLocalDateTime()
                )
        );
    }
}