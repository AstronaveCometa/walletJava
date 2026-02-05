package model.monedas;

// Pesos implementa desde la interfaz Moneda, con los
// valores ajustados a los pesos chilenos, con su símbolo, su nombre.
// En la implementación de los métodos convertirAPesos y convertirDesdePesos,
// se devuelve la misma cantidad, ya que los pesos son la moneda base del programa y no necesitan conversión.
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
