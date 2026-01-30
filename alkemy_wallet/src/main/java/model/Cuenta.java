package model;

public class Cuenta {
    private static int contadorIds = 0;
    private int id;
    private String nombre;
    private String email;
    private String contrasena;
    private long saldo;
    private Moneda moneda;

    public Cuenta(String nombre, String email, String contrasena, Moneda moneda) {
        this.id = contadorIds++;
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.saldo = 0;
        this.moneda = moneda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }
}
