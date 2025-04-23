/*E0505. 
Escribe la función: int[] rellenaPares(int longitud, int fin) que crea y devuelve una tabla ordenada de la longitud especificada rellena con números pares aleatorios en el rango desde 2 hasta el valor de fin inclusive.

 */

package ud4.ejercicios;

import java.util.Arrays;
import java.util.Random;

public class E0505_FuncionOrdenada {
    public static int [] rellenaPares(int longitud, int fin) {
        int[] t = new int[longitud];
        
        //for -each no permite modificar el recorrido del array 

        //GENERACION 
                        //se puede sustituir longitud por t.lenght
        for (int i = 0; i < longitud; i++) {
            Random rnd = new Random();

            do 
                t[i] = rnd.nextInt(2,fin + 1); //inicio minimo enunciado, fin + 1
            while (t[i] % 2 != 0);
        }

        //ORDENAR

        Arrays.sort(t);
        
        return t;
    }

    public static void main(String[] args) {
        int [] t = rellenaPares(10, 20);
        System.out.println(Arrays.toString(t));

    }
}
