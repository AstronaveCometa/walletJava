package service;

import model.Cuenta;
import model.Moneda;
import utils.ComandosTerminal;

public class CuentaService {

    public static void mostrarCuenta(Cuenta cuenta) {
        ComandosTerminal.limpiarPantalla();
        System.out.println("----- Detalles de la Cuenta -----");
        System.out.println("ID: " + cuenta.getId());
        System.out.println("Nombre: " + cuenta.getNombre());
        System.out.println("Email: " + cuenta.getEmail());
        System.out.println("Saldo: " + cuenta.getMoneda().getSimbolo() + cuenta.getSaldo());
        System.out.println("---------------------------------");
    }

    public static void agregarFondos(Cuenta cuenta, Double cantidad) {
        Double saldoActual = cuenta.getSaldo();
        cuenta.setSaldo(saldoActual + cantidad);
    }

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

    public static void cambiarMoneda(Cuenta cuenta, Moneda nuevaMoneda) {
        cuenta.setMoneda(nuevaMoneda);
    }
}
