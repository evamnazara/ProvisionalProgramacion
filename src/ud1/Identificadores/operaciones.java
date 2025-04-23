/** 
    operadores aritméticos (pueden ser enteros o reales):
    + - * / % (resto de division) 

    operadores lógicos:
    && AND - verdadero si ambos se complen
    || OR - verdadero si alguno se cumple
    ! NOT - invierte el valor dado

    incrementacion: 
    + - ++ -- ~ !

    tiene que coincidir el tipo de dato
*/

package ud1.Identificadores;

/* import java.math.*;  para potencias y raices */

public class operaciones {
    public static void main(String[] args) {
        int a = 18;
        double b = 21; /* si no se pone el .0, java lo interpreta como entero (5/2 = 2) */

        System.out.println(a % b);
    }
    
}


/* a=8, b=3, c=-5
(3 * a – 2 * b) % (2 * a – c)
(3 * 8 – 2 * 3) % (2 * 8 – -5)
(24 – 6) % (16 + 5)
18 % 21
18
 */