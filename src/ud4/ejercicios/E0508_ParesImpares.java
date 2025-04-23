package ud4.ejercicios;

import java.util.Arrays;

public class E0508_ParesImpares {
    public static void main(String[] args) {
        
        int [] t = {5,9,8,2,6,5,2,4,6,3,4}; //array aleatorio

            //2 arrays vacios
        int [] pares = new int[0];
        int [] impares = new int [0];

        for (int elemento : t) {
            if (elemento % 2 == 0) {
                pares = Arrays.copyOf(pares, pares.length + 1);
                pares[pares.length - 1] = elemento; 
            } else {
                impares = Arrays.copyOf(impares, impares.length + 1);
                impares[impares.length - 1] = elemento; 
            }
        }

        Arrays.sort(pares);
        Arrays.sort(impares);
        System.out.println("Array original: " + Arrays.toString(t));
        System.out.println("Números pares: " + Arrays.toString(pares));
        System.out.println("Números impares: " + Arrays.toString(impares));
    }
}
