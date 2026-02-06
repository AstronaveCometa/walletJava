package serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import model.Cuenta;
import model.monedas.Dolar;
import model.monedas.Euro;
import model.monedas.Pesos;
import service.CuentaService;

public class CuentaServiceTest {

    @Test
    public void testAgregarFondos() {
        Cuenta cuenta = new Cuenta("Raquel", "raquel@alkemy", "1234", new Dolar());
        CuentaService.agregarFondos(cuenta, 100.0);
        assertEquals(100.0, cuenta.getSaldo());
    }

    @Test
    public void testRetirarFondos() {
        Cuenta cuenta = new Cuenta("Raquel", "raquel@alkemy", "1234", new Dolar());
        cuenta.setSaldo(100.0);
        CuentaService.retirarFondos(cuenta, 30.0);
        assertEquals(70.0, cuenta.getSaldo());
    }

    @Test
    public void testRetirarFondosInsuficientes() {
        Cuenta cuenta = new Cuenta("Raquel", "raquel@alkemy", "1234", new Dolar());
        cuenta.setSaldo(20.0);
        CuentaService.retirarFondos(cuenta, 30.0);
        assertEquals(20.0, cuenta.getSaldo()); // Como el saldo es insuficiente, el saldo no debería cambiar.
    }

    @Test
    public void testTransferirFondos() {
        Cuenta cuentaOrigen = new Cuenta("Raquel", "raquel@alkemy", "1234", new Dolar());
        Cuenta cuentaDestino = new Cuenta("Juan", "juan@alkemy", "5678", new Dolar());
        cuentaOrigen.setSaldo(100.0);
        CuentaService.transferirFondos(cuentaOrigen, cuentaDestino, 50.0);
        assertEquals(50.0, cuentaOrigen.getSaldo());
        assertEquals(50.0, cuentaDestino.getSaldo());
    }

    @Test
    public void testTransferirFondosInsuficientes() {
        Cuenta cuentaOrigen = new Cuenta("Raquel", "raquel@alkemy", "1234", new Dolar());
        Cuenta cuentaDestino = new Cuenta("Juan", "juan@alkemy", "5678", new Dolar());
        cuentaOrigen.setSaldo(30.0);
        CuentaService.transferirFondos(cuentaOrigen, cuentaDestino, 50.0);
        assertEquals(30.0, cuentaOrigen.getSaldo()); // Como el saldo es insuficiente, el saldo no debería cambiar.
        assertEquals(0.0, cuentaDestino.getSaldo()); // Y acá tampoco.
    }

    @Test
    public void testCambiarMoneda() {
        Cuenta cuenta = new Cuenta("Raquel", "raquel@alkemy", "1234", new Euro());
        CuentaService.cambiarMoneda(cuenta, new Pesos());
        assert(cuenta.getMoneda() instanceof Pesos);
        assertEquals(cuenta.getMoneda().getNombre(), "Pesos");
        assertEquals(cuenta.getMoneda().getSimbolo(), "$");
    }
}
