package utiles.usb;

import java.util.Scanner;
import java.util.InputMismatchException;

public class ComprobacionDouble {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        double numero = leerDouble();
        System.out.println("El número decimal introducido es: " + numero);
    }

    // Método para leer un número decimal (double) con comprobación de excepciones
    public static double leerDouble() {
        double num = 0.0;
        boolean valido = false;

        // Mientras no se haya introducido un número válido
        while (!valido) {
            try {
                System.out.print("Introduce un número decimal: ");
                num = sc.nextDouble(); // Intentamos leer un número decimal
                valido = true; // Si la entrada es correcta, cambiamos la bandera
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes introducir un número decimal válido.");
                sc.nextLine(); 
            }
        }
        return num;
    }
}
