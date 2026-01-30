package model;

public interface Moneda {
    Character getSimbolo();

    String getNombre();

    long convertirAPesos(long cantidad);
}
