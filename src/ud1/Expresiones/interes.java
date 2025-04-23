package ud1.Expresiones;

import java.util.*;

/**
 * Solicita datos por teclado y calcula la formula de interes compuesto.
 *  
 * El importe en euros que desea invertir, nº de años que dura la inversion y usando la formula
 * del interes compuesto y para un valor fijo de interes (EJ: 5%) a pagar una vez al año, 
 * calcula el importe final que se pide al usuario)
 */

public class interes {
    public static void main(String[] args) {

        double importeInicial;
        double importeFinal;
        double anhos;
        final double INTERES = 0.05; //declaramos como constante pq el enunciado dice q no cambia
        final double NUM_PAGOS = 1;

        Scanner sc = new Scanner(System.in); //declaramos scanner x teclado system in

        // empieza la entrada de datos x teclado 

        System.out.println("Importe a invertir (euros)");
        importeInicial = sc.nextDouble();

        System.out.println("Duracion de la inversion en anhos");
        anhos = sc.nextInt();

        double base = 1 + INTERES / NUM_PAGOS;
        double exponente = NUM_PAGOS * anhos;
        importeFinal = importeInicial * Math.pow(base, exponente); 

        System.out.println("El interes compuesto es8" + importeFinal);
        //se pueden montar variables auxiliares
        sc.close();

    }
    
}
