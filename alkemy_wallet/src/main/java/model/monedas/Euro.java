package model.monedas;

// Euro implementa desde la interfaz Moneda, con los
// valores ajustados a los euros, con su símbolo, su nombre, y las conversiones a pesos y desde pesos.
public class Euro implements model.Moneda {
    @Override
    public Character getSimbolo() {
        return '¤';
    }

    @Override
    public String getNombre() {
        return "Euro";
    }

    @Override
    public Double convertirAPesos(Double cantidad) {
        return cantidad * 1024;
    }

    @Override
    public Double convertirDesdePesos(Double cantidad) {
        return cantidad / 1024.0;
    }

}
