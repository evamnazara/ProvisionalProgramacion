package utiles.usb;

import java.util.Scanner;
import java.util.InputMismatchException;

public class ComprobacionInt {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int numero = leerEntero();
        System.out.println("El número introducido es: " + numero);
    }

    // Método para leer un número entero con comprobación de excepciones
    public static int leerEntero() {
        int num = 0;
        boolean valido = false;

        // Mientras no se haya introducido un número válido
        while (!valido) {
            try {
                System.out.print("Introduce un número entero: ");
                num = sc.nextInt();  // Intentamos leer un número entero
                valido = true;  // Si la entrada es correcta, cambiamos la bandera
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes introducir un número entero válido.");
                sc.nextLine();  
            }
        }
        return num;
    }
}
