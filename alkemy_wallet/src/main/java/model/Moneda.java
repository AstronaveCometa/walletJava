package model;

// La interfaz Moneda define los métodos que deben implementar todas las monedas del programa,
// como el símbolo de la moneda, su nombre, y las conversiones a pesos y desde pesos,
// para poder realizar las operaciones de conversión entre monedas y pesos en el programa.
// Consideré una conversión de ida y vuelta a pesos para usar esa moneda como referencia,
// y poder convertir entre monedas a través de pesos.
public interface Moneda {
    Character getSimbolo();

    String getNombre();

    Double convertirAPesos(Double cantidad);

    Double convertirDesdePesos(Double cantidad);
}
