package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class AlcanceHistorias {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de casos de prueba
        int casosDePrueba = scanner.nextInt();

        for (int i = 0; i < casosDePrueba; i++) {
            // Leer el número de páginas en la secuencia
            int numPaginas = scanner.nextInt();

            // Crear un array para almacenar la secuencia de páginas
            int[] paginas = new int[numPaginas];

            // Leer la secuencia de páginas
            for (int j = 0; j < numPaginas; j++) {
                paginas[j] = scanner.nextInt();
            }

            // Variable para almacenar el alcance máximo encontrado
            int maxDiferencia = Integer.MIN_VALUE;

            // Buscar la mayor diferencia entre una página y cualquier otra que le siga
            for (int j = 0; j < numPaginas - 1; j++) {
                for (int k = j + 1; k < numPaginas; k++) {
                    int diferencia = paginas[j] - paginas[k];
                    if (diferencia > maxDiferencia) {
                        maxDiferencia = diferencia;
                    }
                }
            }

            // Imprimir el resultado del caso de prueba
            System.out.println(maxDiferencia);
        }

        scanner.close();
    }
}

/*
 * 
 * El alcance de las historias
 * Tiempo máximo: 1,000-2,000 s Memoria máxima: 4096 KiB
 * Elige tu propia aventura
 * A David le encantan los libros de la colección "Elige tu propia aventura", en
 * los que hay páginas con opciones para continuar la historia de formas
 * distintas. Además, en un mismo libro puede haber varias páginas de comienzo
 * de historias. En estos libros hay contenidas varias historias posibles y le
 * encanta explorar todas y cada una de ellas. Cuando lee este tipo de libros
 * escribe en un cuaderno la secuencia de las páginas que ha leído desde una de
 * las posibles páginas de comienzo hasta completar una historia y le fascina
 * contemplar los saltos que ha dado por el libro, sobre todo los que se
 * producen hacia el principio del libro. Como le gusta jugar con los números,
 * para cada secuencia de páginas calcula la diferencia mayor entre cada página
 * de la secuencia y cualquier otra página más adelante en la secuencia. Es lo
 * que él llama el "alcance" de la historia. En un libro normal de n páginas,
 * que empezase en la página 1 y en el que se avanzase de uno en uno hasta el
 * final, el alcance sería −1. Si se leyese de final al principio el alcance
 * sería en cambio n−1. Ayuda a David a calcular el alcance de sus historias.
 * 
 * Entrada
 * La primera línea contiene un número que indica el número de casos de prueba
 * que aparecen a continuación.
 * 
 * Cada caso de prueba se compone de dos líneas. La primera de ellas tiene un
 * único entero con el número de páginas leídas (entero mayor o igual que 2 y
 * menor o igual que 300.000), mientras que la segunda línea contiene la
 * secuencia de páginas (enteros mayores o iguales que 1 y menores o iguales que
 * 300.000).
 * 
 * Salida
 * Para cada caso de prueba se escribirá el alcance de la historia, es decir, la
 * mayor diferencia entre una página de la secuencia y las que le siguen en la
 * secuencia.
 * 
 * Entrada de ejemplo
 * 4
 * 8
 * 1 2 3 8 9 4 5 7
 * 7
 * 10 3 7 8 1 2 11
 * 6
 * 1 2 5 6 2 10
 * 5
 * 1 3 5 7 9
 * Salida de ejemplo
 * 
 * 5
 * 9
 * 4
 * -2
 */
