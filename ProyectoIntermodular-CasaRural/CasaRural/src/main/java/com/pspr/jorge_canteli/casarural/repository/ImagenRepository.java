package com.pspr.jorge_canteli.casarural.repository;

import com.pspr.jorge_canteli.casarural.model.Imagen;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Clase encargada de acceder a la base de datos para gestionar las imágenes.
 *
 * Se utilizan consultas SQL manuales mediante JdbcTemplate.
 */
@Repository
public class ImagenRepository {

    private final JdbcTemplate jdbcTemplate;

    /**
     * Constructor con inyección de dependencias.
     *
     * @param jdbcTemplate objeto que permite ejecutar consultas SQL
     */
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
                ORDER BY id
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

    /**
     * Obtiene una imagen concreta a partir de su identificador.
     *
     * @param id identificador de la imagen
     * @return objeto Imagen encontrado en la base de datos
     */
    public Imagen findById(Long id) {
        String sql = """
                SELECT id, url, descripcion_es, descripcion_en
                FROM imagenes
                WHERE id = ?
                """;

        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                new Imagen(
                        rs.getLong("id"),
                        rs.getString("url"),
                        rs.getString("descripcion_es"),
                        rs.getString("descripcion_en")
                ), id);
    }

    /**
     * Inserta una nueva imagen en la base de datos.
     *
     * @param imagen objeto con los datos de la imagen
     */
    public void save(Imagen imagen) {
        String sql = """
                INSERT INTO imagenes (url, descripcion_es, descripcion_en)
                VALUES (?, ?, ?)
                """;

        jdbcTemplate.update(
                sql,
                imagen.getUrl(),
                imagen.getDescripcionEs(),
                imagen.getDescripcionEn()
        );
    }

    /**
     * Actualiza una imagen existente en la base de datos.
     *
     * @param imagen objeto con los nuevos datos de la imagen
     */
    public void update(Imagen imagen) {
        String sql = """
                UPDATE imagenes
                SET url = ?, descripcion_es = ?, descripcion_en = ?
                WHERE id = ?
                """;

        jdbcTemplate.update(
                sql,
                imagen.getUrl(),
                imagen.getDescripcionEs(),
                imagen.getDescripcionEn(),
                imagen.getId()
        );
    }

    /**
     * Elimina una imagen de la base de datos a partir de su identificador.
     *
     * @param id identificador de la imagen a eliminar
     */
    public void deleteById(Long id) {
        String sql = "DELETE FROM imagenes WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}