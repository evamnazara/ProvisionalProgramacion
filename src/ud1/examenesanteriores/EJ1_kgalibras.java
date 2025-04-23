/* KilosALibras.java
Diseña un programa que lea una medida de peso en kilogramos y la devuelva en libras. Una
libra equivale a 0.453592 kilogramos.
*/

package ud1.examenesanteriores;
import java.util.*;

public class EJ1_kgalibras {
    public static void main(String[] args) {
        final double LIBRA = 0.453592;
        Scanner sc = new Scanner(System.in);


        System.out.println("Introduce el número de kg que quieras convertir:");
        double kg = sc.nextDouble();

        double resultado = kg / LIBRA; 
        System.out.println( kg + "kg en libras son " + resultado);

        sc.close();

    }
    
}
