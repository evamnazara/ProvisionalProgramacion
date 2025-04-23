package ud1.ejercicios.one20241004;

/* EP0122. Convertir una temperatura introducida por teclado en grados Farenheit 
a grados Celsius o centígrados, mostrando el resultado por pantalla.
*/
import java.util.*;

public class EP0122_centigradosafaren {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Programa conversor de temperatura de Grados Farenheit a grados Celsius ");
        
        System.out.println("Introduce los grados Farenheit que quieras convertir:");
        double gradosFarenheit = sc.nextDouble();
        sc.close(); //mejor cerrar nada mas acabar 

        double gradosCelsius = 5.0 / 9.0 * (gradosFarenheit - 32);

        System.out.println(gradosFarenheit + " grados Farenheit son equivalentes a " + gradosCelsius + " grados Celsius");

    }
}
