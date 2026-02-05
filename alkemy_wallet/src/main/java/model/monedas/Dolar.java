package model.monedas;

public class Dolar implements model.Moneda {
    @Override
    public Character getSimbolo() {
        return '$';
    }

    @Override
    public String getNombre() {
        return "Dolar";
    }

    @Override
    public Double convertirAPesos(Double cantidad) {
        return cantidad * 862;
    }

    @Override
    public Double convertirDesdePesos(Double cantidad) {
        return cantidad / 862.0;
    }
}
