//Eva María Otero Názara

package ud4.eonexamenrec;

import java.util.Arrays;

public class Suma {
    public static void main(String[] args) {
        int[] tabla1 = {9,8,52,10,6,12,13}; 
        int[] tVacia = {};
        int[] tImpares = {1,2,3};
        int[] tPares = {2,2};


        System.out.println(Arrays.toString(sumas(tVacia)));
        System.out.println(Arrays.toString(sumas(tPares)));
        System.out.println(Arrays.toString(sumas(tImpares)));
        System.out.println(Arrays.toString(sumas(tabla1)));

        
    }
    
    static int[] sumas(int t[]) {
        if (t == null || t.length == 0){
            return null;
        }
           

        int suma = 0;
        for (int i : t) {
            suma += i;
        }

        int sumaPares = 0;
        for (int i : t) {
            if (i % 2 == 0) {
                sumaPares += i;
            }
        }


        int sumaImpares = 0;
        for (int i : t) {
            if (i % 2 != 0) {
                sumaImpares += i;
            }
        }

        
        int [] tablaDevuelta = {suma,sumaPares,sumaImpares};
        return tablaDevuelta;

    }

}

/*Crea una función que reciba un array de números enteros desordenados y devuelva un
array de 3 elementos con los siguientes valores:
● El primer elemento contendrá la suma de todos los elementos
● El segundo elemento contendrá la suma de todos los elementos pares
● El tercer elemento contendrá la suma de todos los elementos impares.
Si el array de entrada es nulo la función devolverá el valor null. */