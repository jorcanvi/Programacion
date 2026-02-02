package data;

public enum Rol {
    ADMIN("Administrador", 10),
    EDITOR("Editor", 20),
    VISOR("Invitado", 30);

    private String nombre;
    private int codigo;

    Rol(String nombre, int valor) {
        this.nombre = nombre;
        this.codigo = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }
}
