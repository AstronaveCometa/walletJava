package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import model.Moneda;
import model.monedas.Dolar;

public class MonedaTest {

    @Test
    public void testDolarInstanciacion() {
        Moneda dolar = new Dolar();
        assert(dolar instanceof Dolar);
        assertEquals("Dolar", dolar.getNombre());
        assertEquals('$', dolar.getSimbolo());
    }

    @Test
    public void testDolarConversion() {
        Moneda dolar = new Dolar();
        assertEquals(86200, dolar.convertirAPesos(100.0));
        assertEquals(100.0, dolar.convertirDesdePesos(86200.0));
    }

    @Test
    public void testEuroInstanciacion() {
        Moneda euro = new model.monedas.Euro();
        assert(euro instanceof model.monedas.Euro);
        assertEquals("Euro", euro.getNombre());
        assertEquals('¤', euro.getSimbolo());
    }

    @Test
    public void testEuroConversion() {
        Moneda euro = new model.monedas.Euro();
        assertEquals(101400, euro.convertirAPesos(100.0));
        assertEquals(100.0, euro.convertirDesdePesos(101400.0));
    }

    @Test
    public void testPesosInstanciacion() {
        Moneda peso = new model.monedas.Pesos();
        assert(peso instanceof model.monedas.Pesos);
        assertEquals("Pesos", peso.getNombre());
        assertEquals('$', peso.getSimbolo());
    }

    @Test
    public void testPesosConversion() {
        Moneda peso = new model.monedas.Pesos();
        assertEquals(100.0, peso.convertirAPesos(100.0));
        assertEquals(100.0, peso.convertirDesdePesos(100.0));
    }
}
