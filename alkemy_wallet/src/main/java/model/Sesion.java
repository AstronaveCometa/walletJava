package model;

public class Sesion {
    int idActivo;
    boolean sesionIniciada;

    public Sesion() {
        this.idActivo = -1;
        this.sesionIniciada = false;
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
