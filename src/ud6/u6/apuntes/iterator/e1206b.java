package ud6.u6.apuntes.iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

/*E1206b. Implementa una aplicación donde se generen 100 números reales entre -100 y 100. 
A medida que se generan, los valores positivos se insertan en una colección y los negativos en otra. 
Al final se muestran ambas colecciones y las sumas de los elementos de cada una de ellas. 
Por último, se eliminan de ambas colecciones todos los valores que sean mayores que 10 o menores de -10 y se vuelven a mostrar.
 */

public class e1206b {
    public static void main(String[] args) {
        Random rnd = new Random();
        Collection<Integer> numeros = new ArrayList<>();
        Collection<Integer> positivos = new ArrayList<>();
        Collection<Integer> negativos = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            // se declara fuera para poder añadirla en todas las listas
            int numRandom = rnd.nextInt(201) - 100;

            if (numRandom > 0) {
                positivos.add(numRandom);
            } else {
                negativos.add(numRandom);
            }
            numeros.add(numRandom);
        }
        System.out.println("Lista completa:");
        System.out.println(numeros);

        System.out.println("Lista de positivos:");
        System.out.println(positivos);

        System.out.println("Lista de negativos:");
        System.out.println(negativos);

        System.out.println("Suma de los valores positivos:");
        getSuma(positivos);

        System.out.println("Suma de los valores negativos:");
        getSuma(negativos);

        System.out.println("Positivos quitando los mayores a 10");
        Iterator<Integer> it = positivos.iterator();
        while (it.hasNext()) {
            Integer num = it.next();
            if (num > 10) {
                it.remove();
            }
        }
        System.out.println(positivos);

        System.out.println("Negativos quitando los menores que -10");
        Iterator<Integer> it2 = negativos.iterator();
        while (it2.hasNext()) {
            Integer num = it2.next();
            if (num < -10) {
                it2.remove();
            }
        }
        System.out.println(negativos);

    }

    private static void getSuma(Collection<Integer> numeros) {
        int suma = 0;
        for (Integer numero : numeros) {
            suma = suma + numero;
        }

        System.out.println(suma);
    }
}
