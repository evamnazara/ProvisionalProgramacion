package ud6.ejercicios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

/*E1205. 
Implementar una aplicación en la que se insertan en una colección 100 números enteros aleatorios entre 1 y 10 (incluídos), que pueden estar repetidos. 
A continuación, se crea una lista con los mismos elementos sin repeticiones.  */
public class E1206 {
    public static void main(String[] args) {
        Collection <Integer> numeros = new ArrayList<>();
        Random rnd = new Random();

        for (int i = 0; i < 100; i++) {
            numeros.add(rnd.nextInt(10) + 1);
        }
        System.out.println(numeros);
        
        //sin 5
        System.out.println("sin 5:");
        int cont5 = 0;
        Iterator<Integer> it = numeros.iterator();
        
        while (it.hasNext()) {
            Integer numero = it.next();
            if (numero == 5) {
                it.remove();
                cont5++;
            }
        }
        System.out.println("Total de 5: " + cont5);
        System.out.println(numeros);
    }
}
