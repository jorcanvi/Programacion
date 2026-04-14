package com.pspr.jorge_canteli.casarural.repository;

import com.pspr.jorge_canteli.casarural.model.Imagen;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Acceso a datos de la tabla imagenes.
 */
@Repository
public class ImagenRepository {

    private final JdbcTemplate jdbcTemplate;

    public ImagenRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Obtiene todas las imágenes de la base de datos.
     *
     * @return lista de imágenes
     */
    public List<Imagen> findAll() {

        String sql = """
                SELECT id, url, descripcion_es, descripcion_en
                FROM imagenes
                """;

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Imagen(
                        rs.getLong("id"),
                        rs.getString("url"),
                        rs.getString("descripcion_es"),
                        rs.getString("descripcion_en")
                )
        );
    }
}