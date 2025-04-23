package ud6.ejercicios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

public class E1206b {
    public static void main(String[] args) {
        Collection<Integer> numerosPositivos = new ArrayList<>();
        Collection<Integer> numerosNegativos = new ArrayList<>();

        Random rnd = new Random();

        for (int i = 0; i < 100; i++) {
            int numRandom = rnd.nextInt(201) -100;
            if (numRandom >= 0) {
                numerosPositivos.add(numRandom);
            } else if (numRandom < 0) {
                numerosNegativos.add(numRandom);
            }
            numerosPositivos.add(numRandom);
        }

        System.out.println("Negativos: " + numerosNegativos);
        System.out.println("Positivos: " + numerosPositivos);

        System.out.println("Suma positivos: "); 
        getSuma(numerosPositivos);

        System.out.println("Suma negativos: "); 
        getSuma(numerosNegativos);

        Iterator<Integer> it = numerosPositivos.iterator();
        while (it.hasNext()) {
            Integer numero = it.next();
            if (numero > 10) {
                it.remove();
            }
        }
        System.out.println(numerosPositivos);
    }

    private static void getSuma(Collection<Integer> numeros) {
        int suma = 0;
        for (Integer numero : numeros) {
            suma+= numero;
        }
        System.out.println(suma);
    }
}
