package database;
import java.util.ArrayList;

import model.Cuenta;

public class baseDeDatos {

    private ArrayList<Cuenta> cuentas;

    public baseDeDatos() {
        Cuenta primeraCuenta = new Cuenta("Sebastian", "seba.leon@alkemy.com", "seba123", new model.monedas.Pesos());
        primeraCuenta.setSaldo(100000.0);
        Cuenta segundCuenta = new Cuenta("Sabina", "sabina@alkemy.com", "sabina123", new model.monedas.Euro());
        segundCuenta.setSaldo(500.0);
        this.cuentas = new ArrayList<>();
        this.cuentas.add(primeraCuenta);
        this.cuentas.add(segundCuenta);
    }

    public void agregarCuenta(Cuenta cuenta) {
        this.cuentas.add(cuenta);
    }

    public ArrayList<Cuenta> getCuentas() {
        return this.cuentas;
    }

    public Cuenta obtenerCuentaPorEmail(String email) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getEmail().equals(email)) {
                return cuenta;  
            }
        }
        return null;
    }

    public Cuenta obtenerCuentaPorId(int id) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getId() == id) {
                return cuenta;  
            }
        }
        return null;
    }
}