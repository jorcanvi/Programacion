package com.pspr.jorge_canteli.casarural.service;

import com.pspr.jorge_canteli.casarural.model.Imagen;
import com.pspr.jorge_canteli.casarural.repository.ImagenRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio encargado de la lógica de negocio relacionada con las imágenes.
 *
 * Esta clase actúa como intermediaria entre el controlador y el acceso a datos,
 * permitiendo encapsular la lógica necesaria para gestionar las imágenes
 * de la aplicación.
 */
@Service
public class ImagenService {

    private final ImagenRepository imagenRepository;

    /**
     * Constructor con inyección de dependencias.
     *
     * @param imagenRepository repositorio encargado de acceder a la base de datos
     */
    public ImagenService(ImagenRepository imagenRepository) {
        this.imagenRepository = imagenRepository;
    }

    /**
     * Obtiene todas las imágenes disponibles en la base de datos.
     *
     * Este método será utilizado en la web pública para mostrar
     * la galería de imágenes de la casa rural.
     *
     * @return lista de objetos Imagen
     */
    public List<Imagen> obtenerTodas() {
        return imagenRepository.findAll();
    }
}