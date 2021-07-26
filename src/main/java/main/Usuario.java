package main;

public class Usuario {
    private String nombre;
    private String password;
    private boolean isActive;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.password = new StringBuilder(nombre).reverse().toString();
        this.isActive = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
