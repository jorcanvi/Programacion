package model.trabajador;

public class TrabajadorRepartidor extends Trabajador {
    private String zona;
    private int numeroEntregas;

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public int getNumeroEntregas() {
        return numeroEntregas;
    }

    public void setNumeroEntregas(int numeroEntregas) {
        this.numeroEntregas = numeroEntregas;
    }
}
