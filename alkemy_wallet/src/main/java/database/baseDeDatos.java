package database;
import java.util.ArrayList;

import model.Cuenta;

public class baseDeDatos {

    // Acá estoy simulando una base de datos con un ArrayList de cuentas,
    // para poder probar el funcionamiento del programa sin necesidad de una base de datos real.
    // En un proyecto real, esta clase se encargaría de manejar la conexión a la base de datos
    // y las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre las cuentas.
    private ArrayList<Cuenta> cuentas;

    // En el constructor de la clase, se crean dos cuentas de ejemplo, para
    // poder probar el funcionamiento del programa, y se les asigna un saldo inicial,
    // y se agregan al ArrayList de cuentas.
    public baseDeDatos() {
        Cuenta primeraCuenta = new Cuenta("Sebastian", "seba.leon@alkemy.com", "seba123", new model.monedas.Pesos());
        primeraCuenta.setSaldo(100000.0);
        Cuenta segundCuenta = new Cuenta("Sabina", "sabina@alkemy.com", "sabina123", new model.monedas.Euro());
        segundCuenta.setSaldo(500.0);
        this.cuentas = new ArrayList<>();
        this.cuentas.add(primeraCuenta);
        this.cuentas.add(segundCuenta);
    }

    // Este método se encarga de agregar una cuenta al ArrayList de cuentas,
    // para simular la creación de una cuenta en la base de datos.
    public void agregarCuenta(Cuenta cuenta) {
        this.cuentas.add(cuenta);
    }

    // Este método se encarga de devolver el ArrayList de cuentas,
    // para simular la lectura de las cuentas desde la base de datos.
    public ArrayList<Cuenta> getCuentas() {
        return this.cuentas;
    }

    // Acá se busca una cuenta por su email, recorriendo el ArrayList de cuentas,
    // y comparando el email de cada cuenta con el email buscado.
    public Cuenta obtenerCuentaPorEmail(String email) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getEmail().equals(email)) {
                return cuenta;  
            }
        }
        return null;
    }

    // Acá se busca una cuenta por su id, recorriendo el ArrayList de cuentas,
    // y comparando el id de cada cuenta con el id buscado.
    public Cuenta obtenerCuentaPorId(int id) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getId() == id) {
                return cuenta;  
            }
        }
        return null;
    }
}