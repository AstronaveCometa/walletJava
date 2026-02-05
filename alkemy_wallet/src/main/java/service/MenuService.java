package service;

import java.util.Scanner;

import database.baseDeDatos;
import model.Cuenta;
import model.Sesion;
import model.monedas.Dolar;
import model.monedas.Euro;
import model.monedas.Pesos;
import utils.ComandosTerminal;

public class MenuService {

    static Scanner teclado = new Scanner(System.in);
    static baseDeDatos baseDeDatos = new baseDeDatos();
    static Sesion sesion = new Sesion();

    public static void mostrarMenu() {
        int opcion;
        boolean funcionando = true;
        System.out.println("""
                -------------------------------------------------------
                ------------ Bienvenido a Alkemy Wallet ---------------
                -------------------------------------------------------
                """);
        System.out.println("""
                    Probar con email: seba.leon@alkemy.com pass: seba123
                    Probar con email: sabina@alkemy.com pass: sabina123
                """);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        ComandosTerminal.limpiarPantalla();
        do {
            System.out.println("""
                Ingrese el número de la opción que desea ejecutar.
                1) Iniciar sesión.
                2) Crear cuenta.
                3) Salir.
            """);
            try {
                opcion = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                ComandosTerminal.limpiarPantalla();
                System.out.println("Error " + e + ". Ingrese un número entero.");
                continue;
            }
            if (opcion < 1 || opcion > 3) {
                ComandosTerminal.limpiarPantalla();
                System.out.println("Ingrese una opción válida.");
            } else {
                switch (opcion) {
                    case 1:
                        ComandosTerminal.limpiarPantalla();
                        iniciarSesion();
                        break;
                    case 2:
                        ComandosTerminal.limpiarPantalla();
                        crearCuenta();
                        break;
                    case 3:
                        ComandosTerminal.limpiarPantalla();
                        System.out.println("""
                            Saliendo del programa.
                            Gracias por utilizar Alkemy Wallet.
                        """);
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            System.out.println(e);
                        }
                        funcionando = false;
                        break;
                    default:
                        throw new AssertionError();
                }
            }
            ComandosTerminal.limpiarPantalla();
        } while (funcionando);
    }

    public static void iniciarSesion() {
        System.out.println("Ingrese el email:");
        String email = teclado.nextLine();
        System.out.println("Ingrese la contraseña:");
        String contrasena = teclado.nextLine();

        for (Cuenta cuenta : baseDeDatos.getCuentas()) {
            if (cuenta.getEmail().equals(email) && cuenta.getContrasena().equals(contrasena)) {
                sesion.setIdActivo(cuenta.getId());
                sesion.setSesionIniciada(true);
                ComandosTerminal.limpiarPantalla();
                System.out.println("Sesión iniciada correctamente. Bienvenido " + cuenta.getNombre() + ".");
                menuSesionIniciada();
                return;
            }
        }
        ComandosTerminal.limpiarPantalla();
        System.out.println("Email o contraseña incorrectos.");
                                try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            System.out.println(e);
                        }
    }

    public static void crearCuenta() {
        System.out.println("Ingrese su nombre:");
        String nombre = teclado.nextLine();
        System.out.println("Ingrese su email:");
        String email = teclado.nextLine();
        System.out.println("Ingrese su contraseña:");
        String contrasena = teclado.nextLine();
        Cuenta nuevaCuenta = new Cuenta(nombre, email, contrasena, new Pesos());
        baseDeDatos.agregarCuenta(nuevaCuenta);
        ComandosTerminal.limpiarPantalla();
        System.out.println("Cuenta creada correctamente. Su ID de usuario es: " + nuevaCuenta.getId());
    }

    public static void cerrarSesion() {
        sesion.setIdActivo(-1);
        sesion.setSesionIniciada(false);
        ComandosTerminal.limpiarPantalla();
        System.out.println("Sesión cerrada correctamente.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public static void cambiarMonedaDeCuenta() {
        ComandosTerminal.limpiarPantalla();
        boolean continuar = true;
        do {
            System.out.println("""
            Indique el número de la moneda a la que desea cambiar:
                1) Pesos
                2) Dólares
                3) Euros
        """);

            try {
                int opcion = Integer.parseInt(teclado.nextLine());
                Cuenta cuenta = baseDeDatos.obtenerCuentaPorId(sesion.getIdActivo());
                switch (opcion) {
                    case 1:
                        Double saldoEnPesos = cuenta.getMoneda().convertirAPesos(cuenta.getSaldo());
                        CuentaService.cambiarMoneda(cuenta, new Pesos());
                        cuenta.setSaldo(
                                cuenta.getMoneda().convertirDesdePesos(saldoEnPesos)
                        );
                        ComandosTerminal.limpiarPantalla();
                        System.out.println("Moneda cambiada a Pesos. Saldo actualizado: "
                                + cuenta.getMoneda().getSimbolo() + Math.round(cuenta.getSaldo() * 100.0) / 100.0);
                        continuar = false;
                        break;
                    case 2:
                        Double saldoEnDolar = cuenta.getMoneda().convertirAPesos(cuenta.getSaldo());
                        CuentaService.cambiarMoneda(cuenta, new Dolar());
                        cuenta.setSaldo(
                                cuenta.getMoneda().convertirDesdePesos(saldoEnDolar)
                        );
                        ComandosTerminal.limpiarPantalla();
                        System.out.println("Moneda cambiada a Dólares. Saldo actualizado: "
                                + cuenta.getMoneda().getSimbolo() + Math.round(cuenta.getSaldo() * 100.0) / 100.0);
                        continuar = false;
                        break;
                    case 3:
                        Double saldoEnEuro = cuenta.getMoneda().convertirAPesos(cuenta.getSaldo());
                        CuentaService.cambiarMoneda(cuenta, new Euro());
                        cuenta.setSaldo(
                                cuenta.getMoneda().convertirDesdePesos(saldoEnEuro)
                        );
                        ComandosTerminal.limpiarPantalla();
                        System.out.println("Moneda cambiada a Euros. Saldo actualizado: "
                                + cuenta.getMoneda().getSimbolo() + Math.round(cuenta.getSaldo() * 100.0) / 100.0);
                        continuar = false;
                        break;
                    default:
                        ComandosTerminal.limpiarPantalla();
                        System.out.println("Opción inválida.");
                }
            } catch (NumberFormatException e) {
                ComandosTerminal.limpiarPantalla();
                System.out.println("Error al ingresar el número de moneda. Ingrese un número válido.");
            }
        } while (continuar);
    }

    public static void menuSesionIniciada() {
        boolean enSesion = true;
        do {
            System.out.println();
            System.out.println("""
                Ingrese el número de la opción que desea ejecutar.
                1) Consultar saldo.
                2) Agregar fondos.
                3) Retirar fondos.
                4) Transferir fondos.
                5) Cambiar moneda.
                6) Cerrar sesión.
            """);
            try {
                int opcion2 = Integer.parseInt(teclado.nextLine());
                switch (opcion2) {
                    case 1:
                        CuentaService.mostrarCuenta(
                                baseDeDatos.obtenerCuentaPorId(sesion.getIdActivo())
                        );
                        break;
                    case 2:
                        ComandosTerminal.limpiarPantalla();
                        System.out.println("Ingrese la cantidad a agregar:");
                        try {
                            Double cantidadAgregar = Double.parseDouble(teclado.nextLine());
                            CuentaService.agregarFondos(
                                    baseDeDatos.obtenerCuentaPorId(sesion.getIdActivo()),
                                    cantidadAgregar
                            );
                            ComandosTerminal.limpiarPantalla();
                            System.out.println("Saldo actualizado correctamente.");
                        } catch (NumberFormatException e) {
                            ComandosTerminal.limpiarPantalla();
                            System.out.println("Error al agregar fondos. Ingrese un número válido.");
                        }
                        break;

                    case 3:
                        ComandosTerminal.limpiarPantalla();
                        System.out.println("Ingrese la cantidad a retirar:");
                        try {
                            Double cantidadRetirar = Double.parseDouble(teclado.nextLine());
                            CuentaService.retirarFondos(
                                    baseDeDatos.obtenerCuentaPorId(sesion.getIdActivo()),
                                    cantidadRetirar
                            );
                        } catch (NumberFormatException e) {
                            ComandosTerminal.limpiarPantalla();
                            System.out.println("Error al retirar fondos. Ingrese un número válido.");
                        }
                        break;

                    case 4:
                        System.out.println("Ingrese el ID de la cuenta a la que desea transferir.");
                        try {
                            int idCuentaReceptora = Integer.parseInt(teclado.nextLine());
                            try {
                                ComandosTerminal.limpiarPantalla();
                                System.out.println("Ingrese la cantidad a transferir en" +
                                baseDeDatos.obtenerCuentaPorId(sesion.getIdActivo()).getMoneda().getNombre() 
                                + ":");
                                Double cantidadTransferir = Double.parseDouble(teclado.nextLine());
                                CuentaService.transferirFondos(
                                        baseDeDatos.obtenerCuentaPorId(sesion.getIdActivo()),
                                        baseDeDatos.obtenerCuentaPorId(idCuentaReceptora),
                                        cantidadTransferir
                                );
                                ComandosTerminal.limpiarPantalla();
                                System.out.println("Saldo actualizado correctamente.");
                            } catch (NumberFormatException e) {
                                ComandosTerminal.limpiarPantalla();
                                System.out.println("Error al transferir fondos. Ingrese un monto válido.");
                            }
                        } catch (NumberFormatException e) {
                            ComandosTerminal.limpiarPantalla();
                            System.out.println("Error al transferir fondos. Ingrese un número válido.");
                        }
                        break;

                    case 5:
                        cambiarMonedaDeCuenta();
                        break;
                    case 6:
                        cerrarSesion();
                        enSesion = false;
                        break;
                    default:
                        ComandosTerminal.limpiarPantalla();
                        System.out.println("Ingrese una opción válida.");
                }
            } catch (NumberFormatException e) {
                ComandosTerminal.limpiarPantalla();
                System.out.println("Error " + e + ". Ingrese un número entero.");
            }
        } while (enSesion);
    }
}
