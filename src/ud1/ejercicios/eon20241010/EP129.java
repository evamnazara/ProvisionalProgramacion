/* 
EP0129. Escribe un programa que tome como entrada un número entero e indique qué
 cantidad hay que sumarle para que el resultado sea múltiplo de 7. Un ejemplo:
 A 2hay que sumarle 5 para que el resultado (2+5=7) sea múltiplo de 7.
 A 13 hay que sumarle 1 para que el resultado (13+1=14) sea múltiplo de 7.
 Si proporcionas el número 2 o el 13, la salida de la aplicación debe ser 5 o 1,
 respectivamente.

 Pista: El operador módulo puede ser muy útil para solucionar esta actividad 
 */

package ud1.ejercicios.eon20241010;

import java.util.Scanner;

public class EP129 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el número");
        double numeroInicial = sc.nextDouble();
        sc.close ();

        double resto = numeroInicial % 7;
        double numeroAAnadir = resto == 0 ? 0 : 7 - resto;

        if (resto == 0.0) {
            System.out.println("El número ya es múltipo de 7");
        
        } else {
            System.out.println("Para que " + numeroInicial + " sea múltiplo de 7, debes sumarle " + numeroAAnadir  ); 
        }
 
        
    }
    
}
