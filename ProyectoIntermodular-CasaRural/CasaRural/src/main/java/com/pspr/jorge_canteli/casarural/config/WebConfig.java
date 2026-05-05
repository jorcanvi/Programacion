package com.pspr.jorge_canteli.casarural.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Clase de configuración web.
 *
 * Permite exponer como recurso accesible desde el navegador la carpeta
 * donde se almacenan las imágenes subidas al servidor.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Registra un manejador de recursos estáticos para la carpeta uploads.
     *
     * De este modo, cualquier archivo guardado en la carpeta física
     * "uploads" podrá accederse desde una URL que empiece por "/uploads/".
     *
     * @param registry registro de recursos de Spring MVC
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        Path rutaUploads = Paths.get("uploads");
        String rutaAbsoluta = rutaUploads.toFile().getAbsolutePath();

        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:" + rutaAbsoluta + "/");
    }
}