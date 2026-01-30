package service;

import java.util.Scanner;

import database.baseDeDatos;
import model.Cuenta;
import model.Sesion;
import model.monedas.Pesos;
import service.CuentaService;

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
        do {
            System.out.println("""
                Ingrese el número de la opción que desea ejecutar.
                1) Iniciar sesión.
                2) Crear cuenta.
                3) Salir.
            """);
            try {
                opcion = Integer.parseInt(teclado.nextLine());
            } catch (Exception e) {
                System.out.println("Error " + e + ". Ingrese un número entero.");
                continue;
            }
            if (opcion < 1 || opcion > 3) {
                System.out.println("Ingrese una opción válida.");
            } else {
                switch (opcion) {
                    case 1:
                        iniciarSesion();
                        break;
                    case 2:
                        crearCuenta();
                        break;
                    case 3:
                        System.out.println("""
                            Saliendo del programa.
                            Gracias por utilizar Alkemy Wallet.
                        """);
                        funcionando = false;
                        break;
                    default:
                        throw new AssertionError();
                }
            }
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
                System.out.println("Sesión iniciada correctamente. Bienvenido " + cuenta.getNombre() + ".");
                return;
            }
        }
        System.out.println("Email o contraseña incorrectos.");
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
        System.out.println("Cuenta creada correctamente. Su ID de usuario es: " + nuevaCuenta.getId());
    }

    public static void cerrarSesion() {
        sesion.setIdActivo(-1);
        sesion.setSesionIniciada(false);
        System.out.println("Sesión cerrada correctamente.");
    }

    public static void menuSesionIniciada() {
        boolean enSesion = true;
        do {
            System.out.println("""
                Ingrese el número de la opción que desea ejecutar.
                1) Consultar saldo.
                2) Agregar fondos.
                3) Retirar fondos.
                4) Transferir fondos.
                5) Cerrar sesión.
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
                        System.out.println("Ingrese la cantidad a agregar:");
                        try {
                            long cantidadAgregar = Long.parseLong(teclado.nextLine());
                            CuentaService.agregarFondos(
                                baseDeDatos.obtenerCuentaPorId(sesion.getIdActivo()),
                                cantidadAgregar
                            );
                            System.out.println("Saldo actualizado correctamente.");
                        } catch (Exception e) {
                            System.out.println("Error al retirar fondos. Ingrese un número válido.");
                        }
                        break;
                    case 3:
                       System.out.println("Ingrese la cantidad a retirar:");
                        try {
                            long cantidadRetirar = Long.parseLong(teclado.nextLine());
                            CuentaService.agregarFondos(
                                baseDeDatos.obtenerCuentaPorId(sesion.getIdActivo()),
                                cantidadRetirar
                            );
                            System.out.println("Saldo actualizado correctamente.");
                        } catch (Exception e) {
                            System.out.println("Error al retirar fondos. Ingrese un número válido.");
                        }
                        break;
                    case 4:
                        System.out.println("Ingrese el ID de la cuenta a la que desea transferir.");
                        try {
                            int idCuentaReceptora = Integer.parseInt(teclado.nextLine());
                            try{
                                long cantidadTransferir = Long.parseLong(teclado.nextLine());
                                CuentaService.transferirFondos(
                                    baseDeDatos.obtenerCuentaPorId(sesion.getIdActivo()),
                                    baseDeDatos.obtenerCuentaPorId(idCuentaReceptora),
                                    cantidadTransferir
                                );
                                System.out.println("Saldo actualizado correctamente.");
                            } catch (Exception e) {
                                System.out.println("Error al retirar fondos. Ingrese un monto válido.");
                            }
                        } catch (Exception e) {
                            System.out.println("Error al retirar fondos. Ingrese un número válido.");
                        }
                        break;
                    case 5:
                        cerrarSesion();
                        enSesion = false;
                        break;
                    default:
                        System.out.println("Ingrese una opción válida.");
                }
            } catch (Exception e) {
                System.out.println("Error " + e + ". Ingrese un número entero.");
                continue;
            }
        } while (enSesion);
    }
}
