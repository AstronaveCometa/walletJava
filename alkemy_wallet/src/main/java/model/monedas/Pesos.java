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
    public Double convertirAPesos(Double cantidad) {
        return cantidad;
    }

    @Override
    public Double convertirDesdePesos(Double cantidad) {
        return cantidad;
    }
}
