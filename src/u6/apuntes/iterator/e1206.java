package u6.apuntes.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class e1206 {
    public static void main(String[] args) {
        Random rnd = new Random();

        ArrayList<Integer> numeros = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            numeros.add(rnd.nextInt(10) +1);
        }
        System.out.println("Lista original de números:");
        System.out.println(numeros);

        Iterator<Integer> it = numeros.iterator();
            while(it.hasNext()){
                Integer num = it.next();
                if (num.equals(5)) {
                    it.remove();
                }
            }
        System.out.println("Lista sin 5:");
        System.out.println(numeros);
    }
}
