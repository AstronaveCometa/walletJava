package service;

import model.Cuenta;
import model.Moneda;
import utils.ComandosTerminal;

public class CuentaService {

    // Este método se encarga de mostrar los detalles de una cuenta: su id, nombre, email, saldo y moneda.
    public static void mostrarCuenta(Cuenta cuenta) {
        ComandosTerminal.limpiarPantalla();
        System.out.println("----- Detalles de la Cuenta -----");
        System.out.println("ID: " + cuenta.getId());
        System.out.println("Nombre: " + cuenta.getNombre());
        System.out.println("Email: " + cuenta.getEmail());
        System.out.println("Saldo: " + cuenta.getMoneda().getSimbolo() + cuenta.getSaldo());
        System.out.println("---------------------------------");
    }

    // Este método se encarga de agregar fondos a una cuenta, sumando la cantidad ingresada al saldo actual de la cuenta.
    public static void agregarFondos(Cuenta cuenta, Double cantidad) {
        Double saldoActual = cuenta.getSaldo();
        cuenta.setSaldo(saldoActual + cantidad);
    }

    // Este método se encarga de retirar fondos de una cuenta, restando la cantidad ingresada al saldo actual de la cuenta,
    // pero antes verifica que la cantidad a retirar no sea mayor al saldo actual de la cuenta,
    // para evitar que el saldo quede negativo.
    public static void retirarFondos(Cuenta cuenta, Double cantidad) {
        Double saldoActual = cuenta.getSaldo();
        if (cantidad > saldoActual) {
            ComandosTerminal.limpiarPantalla();
            System.out.println("Fondos insuficientes.");
            return;
        }
        cuenta.setSaldo(saldoActual - cantidad);
        ComandosTerminal.limpiarPantalla();
        System.out.println("Fondos retirados correctamente.");
    }

    // Este método se encarga de transferir fondos de una cuenta origen a una cuenta destino,
    // restando la cantidad a transferir al saldo de la cuenta origen,
    // y sumando la cantidad a transferir al saldo de la cuenta destino,
    // pero antes verifica que la cantidad a transferir no sea mayor al saldo actual de la
    // cuenta origen, para evitar que el saldo quede negativo.
    // Además, para realizar la transferencia, se convierte la cantidad a transferir a pesos,
    // y luego se convierte esa cantidad a la moneda de la cuenta destino, para que la transferencia se realice correctamente,
    // teniendo en cuenta las diferencias de valor entre las monedas.
    public static void transferirFondos(Cuenta cuentaOrigen, Cuenta cuentaDestino, Double cantidad) {
        Double saldoOrigen = cuentaOrigen.getSaldo();
        if (cantidad > saldoOrigen) {
            ComandosTerminal.limpiarPantalla();
            System.out.println("Fondos insuficientes para la transferencia.");
            return;
        }
        cuentaOrigen.setSaldo(saldoOrigen - cantidad);
        cuentaDestino.setSaldo( //actualizar saldo de la cuenta destino
                cuentaDestino.getMoneda().convertirDesdePesos( //convertir monto sumado desde pesos a moneda de la cuenta de destino
                        cuentaOrigen.getMoneda().convertirAPesos(cantidad) //convertir monto a transferir a pesos
                        + cuentaDestino.getMoneda().convertirAPesos(cuentaDestino.getSaldo()) //convertir saldo destino a pesos
                )
        );
        ComandosTerminal.limpiarPantalla();
        System.out.println("Transferencia realizada correctamente.");
    }

    // Este método se encarga de cambiar la moneda de una cuenta, asignando la nueva moneda a la cuenta.
    public static void cambiarMoneda(Cuenta cuenta, Moneda nuevaMoneda) {
        cuenta.setMoneda(nuevaMoneda);
    }
}
