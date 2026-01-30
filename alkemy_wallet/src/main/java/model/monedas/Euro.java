package model.monedas;

public class Euro implements model.Moneda {
    @Override
    public Character getSimbolo() {
        return '€';
    }

    @Override
    public String getNombre() {
        return "Euro";
    }

    @Override
    public long convertirAPesos(long cantidad) {
        return cantidad * 1024;
    }

}
