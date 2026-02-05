package model;

public class Cuenta {
    private static int contadorIds = 0; //Este atributo es estático,
    // porque se comparte entre todas las instancias de la clase Cuenta,
    // y se utiliza para asignar un id único a cada cuenta creada, en el
    // orden de instanciación de las cuentas, es decir, la primera cuenta creada tendrá id 0,
    // la segunda cuenta creada tendrá id 1, y así sucesivamente.

    private int id;
    private String nombre;
    private String email;
    private String contrasena;
    private Double saldo;
    private Moneda moneda;

    public Cuenta(String nombre, String email, String contrasena, Moneda moneda) {
        this.id = contadorIds++; //Al asignar el id de esta manera,
        // se garantiza que cada cuenta creada tendrá un id único,
        // y que los ids se asignarán en el orden de instanciación de las cuentas.

        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.saldo = 0.0; // El saldo inicial de una cuenta es 0.0.
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

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }
}
