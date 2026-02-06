package model;

// Esta clase se encarga de manejar la sesi?n del usuario, es decir,
// si el usuario ha iniciado sesi?n o no. El id de la cuenta activa es  la cuenta que ha iniciado sesi?n.
public class Sesion {
    int idActivo;
    boolean sesionIniciada;

    public Sesion() {
        this.idActivo = -1; // El idActivo se inicializa en -1, para indicar que no hay ninguna cuenta activa.
        this.sesionIniciada = false; // La sesi?n se inicializa en false, para indicar que no hay ninguna sesi?n iniciada.
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
