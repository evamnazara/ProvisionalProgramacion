
package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class CrecientePorLosPelos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Loop para leer cada caso de prueba
        while (true) {
            // Leer el tamaño del vector
            int n = sc.nextInt();

            // Si el tamaño es 0, terminamos
            if (n == 0) {
                break;
            }

            // Leer el vector
            int[] vector = new int[n];
            for (int i = 0; i < n; i++) {
                vector[i] = sc.nextInt();
            }

            // Buscar el siguiente vector creciente por los pelos
            int i = n - 1; // Empezamos desde el último elemento

            // Buscar el primer valor que se pueda incrementar sin romper las reglas
            while (i >= 0 && vector[i] == 1000) {
                i--; // Si el valor es 1000, no podemos incrementarlo, pasamos al anterior
            }

            // Si encontramos un valor que se puede incrementar
            if (i >= 0) {
                vector[i]++; // Incrementamos el valor
                // Después de incrementar, reiniciamos los valores a la derecha del índice i
                for (int j = i + 1; j < n; j++) {
                    vector[j] = vector[i]; // Aseguramos que la secuencia sigue siendo creciente por los pelos
                }
            }

            // Imprimir el siguiente vector
            for (int j = 0; j < n; j++) {
                System.out.print(vector[j] + " ");
            }
            System.out.println();
        }

        // Cerrar el scanner
        sc.close();
    }
}

/*
 * Creciente por los pelos
 * Tiempo máximo: 1,000 s Memoria máxima: 4096 KiB
 * Cabezas crecientes por los pelos
 * Un vector es creciente por los pelos si, además de ser creciente, la
 * diferencia entre dos posiciones consecutivas es como mucho uno. Por ejemplo,
 * existen cuatro vectores crecientes por los pelos de tamaño tres que empiezan
 * por uno: el 1 1 1, el 1 1 2, el 1 2 2 y el 1 2 3. Observa que el 1 1 1 se
 * considera creciente por los pelos, porque no se fuerza a que sea
 * estrictamente creciente y por tanto el caso sin crecimiento también se
 * admite.
 * 
 * Además de comparar individualmente los elementos del vector, podemos también
 * comparar vectores entre sí. Cuando dos vectores tienen el mismo tamaño, uno
 * es menor que otro si tras una primera parte (quizá vacía) de elementos
 * iguales, tiene un elemento menor que el otro. La lista de vectores de tamaño
 * tres anterior es, según esta definición, creciente. Otro ejemplo de secuencia
 * creciente de vectores crecientes por los pelos es:
 * 
 * Ejemplo de secuencia de vectores crecientes
 * En esa secuencia, sin embargo, hay "huecos" entre los vectores. Por ejemplo,
 * entre el primero, 1 1 1 1 y el segundo, 1 1 2 2, existe un vector creciente
 * por los pelos que es mayor que el primero pero menor que el segundo.
 * 
 * Para poder generar una secuencia de vectores crecientes por los pelos de un
 * tamaño dado, el primer paso es saber, dado uno de estos vectores, cuál sería
 * el siguiente, de forma que no exista ningún otro que esté entre los dos.
 * 
 * Entrada
 * La entrada está formada por distintos casos de prueba. Cada uno de ellos
 * ocupa dos líneas. La primera contiene un único número N (1 ≤ N ≤ 100) con el
 * tamaño del vector que viene a continuación. La segunda línea contiene los N
 * enteros de un vector creciente por los pelos. El primer elemento de todos los
 * vectores estará siempre entre 1 y 1.000.
 * 
 * Al último caso de prueba le sigue una línea con un 0.
 * 
 * Salida
 * Por cada caso de prueba se escribirá una línea con el siguiente vector
 * creciente por los pelos al de la entrada, según la definición de orden entre
 * vectores del mismo tamaño dada anteriormente. Los números irán separados por
 * un único espacio.
 * 
 * Entrada de ejemplo
 * 4
 * 1 1 1 1
 * 3
 * 1 1 1
 * 3
 * 1 2 2
 * 0
 * Salida de ejemplo
 * 
 * 1 1 1 2
 * 1 1 2
 * 1 2 3
 * 
 */