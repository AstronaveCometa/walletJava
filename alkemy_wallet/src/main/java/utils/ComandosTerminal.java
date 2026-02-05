package utils;

import java.io.IOException;

// Esta clase fue pensada para agregar comandos a usar en la terminal,
// pero por ahora solo tiene el comando para limpiar la pantalla,
// que se usa en el MenuService para mejorar la experiencia del usuario.
public class ComandosTerminal {

    // Este es el método estático para limpiar la pantalla,
    // que detecta el sistema operativo y ejecuta el comando correspondiente
    // para limpiar la pantalla de la terminal.
    public static void limpiarPantalla() {
        try {
            String sistemaOperativo = System.getProperty("os.name");
            if (sistemaOperativo.contains("Windows")) {
                // Para Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Para Linux/Mac
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al limpiar la pantalla: " + e.getMessage());
        }
    }
}
