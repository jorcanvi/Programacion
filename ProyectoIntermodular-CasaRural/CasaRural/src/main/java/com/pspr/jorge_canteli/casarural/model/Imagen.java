package com.pspr.jorge_canteli.casarural.model;

/**
 * Clase que representa una imagen de la galería.
 *
 * Incluye descripciones en varios idiomas para su uso en la web pública.
 */
public class Imagen {

    private Long id;
    private String url;
    private String descripcionEs;
    private String descripcionEn;

    public Imagen() {
    }

    public Imagen(Long id, String url, String descripcionEs, String descripcionEn) {
        this.id = id;
        this.url = url;
        this.descripcionEs = descripcionEs;
        this.descripcionEn = descripcionEn;
    }

    public Long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getDescripcionEs() {
        return descripcionEs;
    }

    public String getDescripcionEn() {
        return descripcionEn;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDescripcionEs(String descripcionEs) {
        this.descripcionEs = descripcionEs;
    }

    public void setDescripcionEn(String descripcionEn) {
        this.descripcionEn = descripcionEn;
    }
}