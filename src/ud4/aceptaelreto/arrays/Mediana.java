package ud4.aceptaelreto.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Mediana {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Bucle que procesará múltiples casos de prueba
        while (true) {
            // Leer la cantidad de valores
            System.out.println("Introduce la cantidad de valores (0 para terminar):");
            int cantidad = sc.nextInt();
            if (cantidad == 0) {
                System.out.println("Fin de los casos de prueba.");
                break; // Termina si la cantidad es 0
            }

            // Array para almacenar los números
            int[] valores = new int[cantidad];

            // Leer los valores
            System.out.println("Introduce los " + cantidad + " valores:");
            for (int i = 0; i < cantidad; i++) {
                valores[i] = sc.nextInt();
            }

            // Ordenamos el array (en caso de que no esté ordenado)
            Arrays.sort(valores);

            // Calcular la mediana multiplicada por 2
            int medianaDoble;
            if (cantidad % 2 == 1) { // Si es impar
                medianaDoble = 2 * valores[cantidad / 2];
            } else { // Si es par
                int centro1 = valores[(cantidad / 2) - 1];
                int centro2 = valores[cantidad / 2];
                medianaDoble = centro1 + centro2; // Equivale a (centro1 + centro2) * 2 / 2
            }

            // Imprimir resultado
            System.out.println("El doble de la mediana es: " + medianaDoble);
        }

        sc.close();
    }
}

/*
 * Cálculo de la Mediana
 * Tiempo máximo: 1,000-2,000 s Memoria máxima: 4096 KiB
 * Dado un conjunto (o muestra) de valores positivos ordenados, se define la
 * mediana como el valor que ocupa la posición central de los datos dados:
 * 
 * 12617185 valores22⏞Mediana35461091432005 valores
 * En el caso de tener un número impar de valores, la mediana está clara: será
 * aquel valor que tenga el mismo número de valores más pequeños y más grandes
 * que él en la muestra. En el caso de tener un número par de valores, habría
 * dos candidatos a ser mediana. En vez de decidirnos por uno, en este caso la
 * mediana viene dada por la media aritmética de esos dos valores que ocupan las
 * posiciones centrales.
 * 
 * Dada una colección de números positivos, nos piden calcular la mediana. Para
 * evitar tener que trabajar con números decimales en algunos casos, habrá que
 * calcular su doble.
 * 
 * Entrada
 * La entrada consta de una serie de casos de prueba. Cada uno comienza con un
 * número, menor o igual que 25.000, que indica la cantidad de valores que tiene
 * la muestra. A continuación se dan los valores de la muestra, todos números
 * enteros positivos, de los que habrá que calcular la mediana multiplicada por
 * dos.
 * 
 * La entrada terminará con una serie de 0 valores.
 * 
 * Salida
 * Para cada caso de prueba se mostrará el doble de la mediana de los valores
 * dados.
 * 
 * Entrada de ejemplo
 * 11
 * 1 2 6 17 18 22 35 46 109 153 200
 * 5
 * 5 3 1 2 8
 * 4
 * 4 5 9 2
 * 0
 * Salida de ejemplo
 * 
 * 44
 * 6
 * 9
 */