package u6.apuntes.iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
/*E1205. Implementar una aplicación en la que se insertan en una colección 100 números enteros aleatorios entre 1 y 10 (incluídos), que pueden estar repetidos. A continuación, se crea una lista con los mismos elementos sin repeticiones.
 */
public class e1205 {
    public static void main(String[] args) {
        Random rnd = new Random();

        ArrayList<Integer> numeros = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            numeros.add(rnd.nextInt(10) +1);
        }
        System.out.println(numeros);

        //se pasa a HashSet q no admite directamente duplicados. 
        Collection<Integer> sinRepetidos = new HashSet<>();
        for (Integer numero : numeros) {
            sinRepetidos.add(numero);
        }
        System.out.println(sinRepetidos);


        
    }
}
