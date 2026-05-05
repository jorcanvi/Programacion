package com.pspr.jorge_canteli.casarural.controller.admin;

import com.pspr.jorge_canteli.casarural.model.Imagen;
import com.pspr.jorge_canteli.casarural.service.ImagenService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Controlador encargado de gestionar las imágenes desde el panel de administración.
 */
@Controller
@RequestMapping("/admin/imagenes")
public class AdminImagenController {

    private final ImagenService imagenService;

    /**
     * Constructor con inyección de dependencias.
     *
     * @param imagenService servicio encargado de gestionar las imágenes
     */
    public AdminImagenController(ImagenService imagenService) {
        this.imagenService = imagenService;
    }

    /**
     * Muestra el listado de imágenes.
     *
     * @param model objeto que permite enviar datos a la vista
     * @return vista del listado de imágenes
     */
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("imagenes", imagenService.obtenerTodas());
        return "admin/imagenes/lista";
    }

    /**
     * Muestra el formulario para crear una nueva imagen.
     *
     * @param model objeto que permite enviar datos a la vista
     * @return vista del formulario de imagen
     */
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("imagen", new Imagen());
        return "admin/imagenes/formulario";
    }

    /**
     * Guarda una nueva imagen en el sistema.
     *
     * @param imagen objeto con los datos descriptivos de la imagen
     * @param archivo archivo de imagen subido desde el formulario
     * @return redirección al listado de imágenes
     */
    @PostMapping("/guardar")
    public String guardar(Imagen imagen, @RequestParam("archivo") MultipartFile archivo) {
        imagenService.guardar(imagen, archivo);
        return "redirect:/admin/imagenes";
    }

    /**
     * Muestra el formulario para editar una imagen existente.
     *
     * @param id identificador de la imagen
     * @param model objeto que permite enviar datos a la vista
     * @return vista del formulario de imagen
     */
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("imagen", imagenService.obtenerPorId(id));
        return "admin/imagenes/formulario";
    }

    /**
     * Actualiza una imagen existente.
     *
     * @param imagen objeto con los nuevos datos
     * @param archivo archivo de imagen opcional
     * @return redirección al listado de imágenes
     */
    @PostMapping("/actualizar")
    public String actualizar(Imagen imagen, @RequestParam("archivo") MultipartFile archivo) {
        imagenService.actualizar(imagen, archivo);
        return "redirect:/admin/imagenes";
    }

    /**
     * Elimina una imagen.
     *
     * @param id identificador de la imagen
     * @return redirección al listado de imágenes
     */
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        imagenService.eliminar(id);
        return "redirect:/admin/imagenes";
    }
}