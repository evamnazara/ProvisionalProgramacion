package ud1.ejercicios;

/* 
Un economista te ha encargado un programa para realizar cálculos con el IVA. 
La aplicación debe solicitar la base imponible y el IVA que se debe aplicar. 
Muestra en pantalla el importe correspondiente al IVA y al total.
*/ 
import java.util.*;

public class EP0111 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Dime el precio base del producto");
        double baseImponible = sc.nextDouble();

        System.out.println("Ahora dime el tipo de IVA que tiene");
        int iva = sc.nextInt(); 

        double ivaTotal = baseImponible * iva / 100; //o iva * 0,01
        System.out.println("El importe total de IVA es " + ivaTotal); 

        double precioFinal = baseImponible + ivaTotal; 

        System.out.println("Precio final = " + precioFinal + "euros");

        sc.close();
    }
}
