package model;

// Esta clase se encarga de manejar la sesión del usuario, es decir,
// si el usuario ha iniciado sesión o no. El id de la cuenta activa es  la cuenta que ha iniciado sesión.
public class Sesion {
    int idActivo;
    boolean sesionIniciada;

    public Sesion() {
        this.idActivo = -1; // El idActivo se inicializa en -1, para indicar que no hay ninguna cuenta activa.
        this.sesionIniciada = false; // La sesión se inicializa en false, para indicar que no hay ninguna sesión iniciada.
    }

    public int getIdActivo() {
        return idActivo;
    }

    public void setIdActivo(int idActivo) {
        this.idActivo = idActivo;
    }

    public boolean isSesionIniciada() {
        return sesionIniciada;
    }

    public void setSesionIniciada(boolean sesionIniciada) {
        this.sesionIniciada = sesionIniciada;
    }
}
