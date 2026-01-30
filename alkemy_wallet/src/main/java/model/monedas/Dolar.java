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
    public long convertirAPesos(long cantidad) {
        return cantidad * 862;
    }
}
