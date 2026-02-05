package model;

public interface Moneda {
    Character getSimbolo();

    String getNombre();

    Double convertirAPesos(Double cantidad);

    Double convertirDesdePesos(Double cantidad);
}
