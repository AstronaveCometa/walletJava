package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import model.Sesion;

public class SesionTest {

    @Test
    public void testSesionInstanciacion() {
        Sesion sesion = new Sesion();
        assertEquals(-1, sesion.getIdActivo());
        assertEquals(false, sesion.isSesionIniciada());
    }
}
