package model.monedas;

public class Pesos implements model.Moneda {
    @Override
    public Character getSimbolo() {
        return '$';
    }

    @Override
    public String getNombre() {
        return "Pesos";
    }

    @Override
    public long convertirAPesos(long cantidad) {
        return cantidad;
    }
}
