package com.pspr.jorge_canteli.casarural.model;

import java.time.LocalDateTime;

/**
 * Clase que representa un mensaje de contacto enviado por un usuario.
 *
 * Cada objeto Contacto corresponde a un registro de la tabla "contactos"
 * en la base de datos.
 */
public class Contacto {

    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private String mensaje;
    private LocalDateTime fechaEnvio;

    /**
     * Constructor vacío.
     */
    public Contacto() {
    }

    /**
     * Constructor con parámetros.
     *
     * @param id identificador del mensaje
     * @param nombre nombre del usuario
     * @param email correo electrónico
     * @param telefono teléfono de contacto
     * @param mensaje contenido del mensaje
     * @param fechaEnvio fecha y hora de envío
     */
    public Contacto(Long id, String nombre, String email, String telefono, String mensaje, LocalDateTime fechaEnvio) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.mensaje = mensaje;
        this.fechaEnvio = fechaEnvio;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }
}