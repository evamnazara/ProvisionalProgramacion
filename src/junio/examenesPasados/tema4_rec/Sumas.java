package junio.examenesPasados.tema4_rec;

import java.util.Arrays;

/*1. sumas (3)
Crea una función que reciba un array de números enteros desordenados y devuelva un
array de 3 elementos con los siguientes valores:
● El primer elemento contendrá la suma de todos los elementos
● El segundo elemento contendrá la suma de todos los elementos pares
● El tercer elemento contendrá la suma de todos los elementos impares.
static int[] sumas(int t[]);
Si el array de entrada es nulo la función devolverá el valor null. */
public class Sumas {

    public static int[] sumas(int t[]) {
        if (t == null) {
            return null;
        }

        int suma = 0;
        int sumaPares = 0;
        int sumaImpares = 0;

        for (int i = 0; i < t.length; i++) {
            suma += t[i];

            if (t[i] % 2 == 0) {
                sumaPares += t[i];
            } else {
                sumaImpares += t[i];
            }
        }

        int[] resultado = new int[] { suma, sumaPares, sumaImpares };
        /*
         * resultado[0] = suma;
         * resultado[1] = sumaPares;
         * resultado[2] = sumaImpares;
         */

        return resultado;

    }

    public static void main(String[] args) {
        int[] tabla = new int[] { 9, 5, 7, 2, 8 };
        int[] tabla2 = null;

        System.out.println(Arrays.toString(sumas(tabla)));
        System.out.println(Arrays.toString(sumas(tabla2)));

    }

}
