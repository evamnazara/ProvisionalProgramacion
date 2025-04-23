package ud1.Identificadores;

import java.util.Scanner;
import java.time.*;

public class ApiScanner {
    public static void main(String[] args) {
        /* primero hay que declarar una clase escanner */

        Scanner sc = new Scanner(System.in);
        System.out.print("Como te llamas? ");
        String nombre = sc.nextLine(); /* lee por teclado y lo guarda en una variable */

        System.out.println("Hola, " + nombre + ", estamos en clase de programación ");
        
        System.out.print("En que año naciste? ");
        int anhoNacimiento = sc.nextInt();
        int anhoActual = LocalDate.now().getYear(); /* saca el año de la fecha actual */
        int edad = anhoActual - anhoNacimiento;


        System.out.println("Naciste en el anho " + anhoNacimiento + " , así que tienes " + edad + " anhos" );

        sc.close();
    }
    
}
