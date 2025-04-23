package ud6.ejercicios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class E1208 {
    public static void main(String[] args) {
        Collection <Integer> numeros = new ArrayList<>();
        Random rnd = new Random();

        for (int i = 0; i < 20; i++) {
            numeros.add(rnd.nextInt());
        }
        System.out.println(numeros);
    }

}

