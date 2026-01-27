package Model.trabajador;

public final class TrabajadorCocina extends Trabajador {
    public final int UMBRAL_PLATOS = 10;

    private int platos;

    public int getPlatos() {
        return platos;
    }

    public void setPlatos(int platos) {
        this.platos = platos;
    }
}
