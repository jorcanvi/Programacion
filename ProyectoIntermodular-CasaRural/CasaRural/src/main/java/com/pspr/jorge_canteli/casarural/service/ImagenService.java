package com.pspr.jorge_canteli.casarural.service;

import com.pspr.jorge_canteli.casarural.model.Imagen;
import com.pspr.jorge_canteli.casarural.repository.ImagenRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

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

    @Value("${app.upload.dir}")
    private String uploadDir;

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
     * @return lista de objetos Imagen
     */
    public List<Imagen> obtenerTodas() {
        return imagenRepository.findAll();
    }

    /**
     * Obtiene una imagen a partir de su identificador.
     *
     * @param id identificador de la imagen
     * @return objeto Imagen
     */
    public Imagen obtenerPorId(Long id) {
        return imagenRepository.findById(id);
    }

    /**
     * Guarda una nueva imagen en la base de datos y almacena su archivo en el servidor.
     *
     * @param imagen objeto con los datos descriptivos de la imagen
     * @param archivo archivo recibido desde el formulario
     */
    public void guardar(Imagen imagen, MultipartFile archivo) {
        String rutaRelativa = guardarArchivo(archivo);
        imagen.setUrl(rutaRelativa);
        imagenRepository.save(imagen);
    }

    /**
     * Actualiza una imagen existente.
     *
     * Si el usuario sube un nuevo archivo, se guarda la nueva imagen,
     * se elimina el archivo anterior del servidor y se actualiza la ruta
     * almacenada en la base de datos.
     *
     * Si no se sube un nuevo archivo, se conserva la ruta actual.
     *
     * @param imagen objeto con los nuevos datos de la imagen
     * @param archivo archivo opcional recibido desde el formulario
     */
    public void actualizar(Imagen imagen, MultipartFile archivo) {

        // Recuperar la imagen actual almacenada en la base de datos
        // para poder conservar o eliminar el archivo existente según el caso
        Imagen imagenActual = imagenRepository.findById(imagen.getId());

        // Si el usuario ha subido una nueva imagen
        if (archivo != null && !archivo.isEmpty()) {

            // Guardar el nuevo archivo y obtener su nueva ruta relativa
            String rutaRelativaNueva = guardarArchivo(archivo);

            // Eliminar el archivo antiguo del servidor para evitar archivos huérfanos
            eliminarArchivo(imagenActual.getUrl());

            // Asignar al objeto la nueva ruta que se guardará en la base de datos
            imagen.setUrl(rutaRelativaNueva);

        } else {

            // Si no se ha subido una nueva imagen, se conserva la ruta anterior
            imagen.setUrl(imagenActual.getUrl());
        }

        // Actualizar el registro en la base de datos
        imagenRepository.update(imagen);
    }

    public void eliminar(Long id) {

        // 1. Obtener imagen antes de borrar
        Imagen imagen = imagenRepository.findById(id);

        // 2. Borrar archivo físico
        eliminarArchivo(imagen.getUrl());

        // 3. Borrar en BD
        imagenRepository.deleteById(id);
    }

    /**
     * Elimina el archivo físico de una imagen en el servidor.
     *
     * A partir de la ruta relativa almacenada en la base de datos
     * (por ejemplo: "/uploads/galeria/foto.jpg"),
     * se construye la ruta real en el sistema de ficheros
     * y se elimina el archivo si existe.
     *
     * @param rutaRelativa ruta relativa almacenada en la base de datos
     */
    private void eliminarArchivo(String rutaRelativa) {

        // Si la ruta es nula o vacía, no se realiza ninguna acción
        if (rutaRelativa == null || rutaRelativa.isEmpty()) {
            return;
        }

        try {

            // Se elimina la barra inicial "/" para obtener la ruta relativa del sistema
            // Ejemplo:
            // "/uploads/galeria/foto.jpg" → "uploads/galeria/foto.jpg"
            Path rutaArchivo = Paths.get(rutaRelativa.substring(1));

            // Se elimina el archivo solo si existe, evitando excepciones innecesarias
            Files.deleteIfExists(rutaArchivo);

        } catch (IOException e) {

            // En caso de error, se lanza una excepción controlada
            // para informar de que ha fallado la eliminación del archivo
            throw new RuntimeException("Error al eliminar el archivo de imagen.", e);
        }
    }

    /**
     * Guarda físicamente un archivo de imagen en la carpeta configurada.
     *
     * El archivo se renombra automáticamente para evitar colisiones de nombres.
     *
     * @param archivo archivo subido por el usuario
     * @return ruta relativa que se almacenará en la base de datos
     */
    private String guardarArchivo(MultipartFile archivo) {

        if (archivo == null || archivo.isEmpty()) {
            throw new RuntimeException("No se ha seleccionado ningún archivo de imagen.");
        }

        try {
            Path rutaUpload = Paths.get(uploadDir);
            Files.createDirectories(rutaUpload);

            String nombreOriginal = archivo.getOriginalFilename();
            String extension = "";

            if (nombreOriginal != null && nombreOriginal.contains(".")) {
                extension = nombreOriginal.substring(nombreOriginal.lastIndexOf("."));
            }

            String nombreArchivo = UUID.randomUUID() + extension;

            Path rutaCompleta = rutaUpload.resolve(nombreArchivo);

            Files.copy(
                    archivo.getInputStream(),
                    rutaCompleta,
                    StandardCopyOption.REPLACE_EXISTING
            );

            return "/uploads/galeria/" + nombreArchivo;

        } catch (IOException e) {
            throw new RuntimeException("Error al guardar el archivo de imagen.", e);
        }
    }


}