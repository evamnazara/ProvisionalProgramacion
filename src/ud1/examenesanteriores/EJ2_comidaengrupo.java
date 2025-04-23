/* ComidaEnGrupo.java
Un grupo de persoas salen a comer juntas. Al terminar piden la cuenta conjunta. Haz un
programa que tenga como entrada el número de personas y el importe total de la comida,
que podrá tener decimales, y que tenga como salida la cantidad a pagar por cada comensal
que se presentará con hasta 2 decimales.
 */


package ud1.examenesanteriores;
import java.util.*;

public class EJ2_comidaengrupo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 

        System.out.println("Introduce el total de euros: ");
        double cuenta = sc.nextDouble();

        System.out.println("Introduce el número de comensales: ");
        double comensales = sc.nextDouble();

        sc.close();

        System.out.println("El importe a pagar por persona son " + ( cuenta / comensales) );
    }
    
}
