package ud1.ejercicios.eon20241010;

import java.util.*;

public class EP129_Multiplosde7 {
    public static void main(String[] args) {
        int num;

        Scanner sc = new Scanner(System.in);
        System.out.println("introduce el número:");

        num = sc.nextInt();
        sc.close();

        System.out.println("Multiplo de 7? " + (num % 7 == 0)); //booleano verdadero o falso
        System.out.println("Resto de num % 7:" + (num % 7)); //imprime el resto
        System.out.println("Para el siguiente múltiplo de 7, hay que sumar " + (7 - num % 7) );
        String salida = num % 7 == 0 ? "El número ya es múltiplo de 7, no hay que sumar nada" : "Para el siguiente múltiplo de 7, sumo " + (7 - num % 7) ;  
        System.out.println(salida);
        //es el num mult de 7 ? (<- SI) > ya lo es : (<- si no?) "otra opcion > cadena"

    

    }
    
}
