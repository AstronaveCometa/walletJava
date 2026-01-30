package service;

import model.Cuenta;

public class CuentaService {

    public static void mostrarCuenta(Cuenta cuenta) {
        System.out.println("----- Detalles de la Cuenta -----");
        System.out.println("ID: " + cuenta.getId());
        System.out.println("Nombre: " + cuenta.getNombre());
        System.out.println("Email: " + cuenta.getEmail());
        System.out.println("Saldo: " + cuenta.getSaldo() + " " + cuenta.getMoneda().getSimbolo());
        System.out.println("---------------------------------");
    }

    public static void agregarFondos(Cuenta cuenta, long cantidad) {
        long saldoActual = cuenta.getSaldo();
        cuenta.setSaldo(saldoActual + cantidad);
    }

    public static void retirarFondos(Cuenta cuenta, long cantidad) {
        long saldoActual = cuenta.getSaldo();
        if (cantidad > saldoActual) {
            System.out.println("Fondos insuficientes.");
            return;
        }
        cuenta.setSaldo(saldoActual - cantidad);
        System.out.println("Fondos retirados correctamente.");
    }

    public static void transferirFondos(Cuenta cuentaOrigen, Cuenta cuentaDestino, long cantidad) {
        long saldoOrigen = cuentaOrigen.getSaldo();
        if (cantidad > saldoOrigen) {
            System.out.println("Fondos insuficientes para la transferencia.");
            return;
        }
        cuentaOrigen.setSaldo(saldoOrigen - cantidad);
        cuentaDestino.setSaldo(cuentaDestino.getSaldo() + cantidad);
        System.out.println("Transferencia realizada correctamente.");
    }

}
