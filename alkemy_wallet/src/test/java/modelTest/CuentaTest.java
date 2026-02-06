package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.Cuenta;
import model.monedas.Dolar;

public class CuentaTest {

    @Test
    public void testCuentaInstanciacion() {
        Cuenta cuenta = new Cuenta("Javiera","javiera@alkemy.com","javiera123", new Dolar());
        cuenta.setSaldo(15000d);
        assertEquals("Javiera", cuenta.getNombre());
        assertEquals("javiera@alkemy.com", cuenta.getEmail());
        assertEquals("javiera123", cuenta.getContrasena());
        assertEquals(15000d, cuenta.getSaldo());
    }

    
}
