package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class ReinasAtacadas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Leer el tamaño del tablero y el número de reinas
            int tamañoTablero = scanner.nextInt();
            int numReinas = scanner.nextInt();

            // Condición de salida
            if (tamañoTablero == 0 && numReinas == 0) {
                break;
            }

            // Arrays para almacenar las posiciones de las reinas
            int[] x = new int[numReinas];
            int[] y = new int[numReinas];

            // Leer las coordenadas de las reinas
            for (int i = 0; i < numReinas; i++) {
                x[i] = scanner.nextInt();
                y[i] = scanner.nextInt();
            }

            // Verificar si hay reinas atacadas
            boolean atacadas = false;

            for (int i = 0; i < numReinas && !atacadas; i++) {
                for (int j = i + 1; j < numReinas; j++) {
                    if (x[i] == x[j] || y[i] == y[j] || Math.abs(x[i] - x[j]) == Math.abs(y[i] - y[j])) {
                        atacadas = true;
                        break;
                    }
                }
            }

            // Imprimir el resultado
            if (atacadas) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        }
        scanner.close();
    }
}

/*
 * Reinas atacadas
 * Tiempo máximo: 1,000-3,000 s Memoria máxima: 4096 KiB
 * En el ajedrez, la reina es la pieza más poderosa, al poderse mover cualquier
 * número de escaques en vertical, horizontal, o diagonal.
 * 
 * 
 * Movimientos de la reina
 * En 1848, el alemán Max Bezzel planteó el puzzle de las 8 reinas, en el que
 * retó a colocar 8 reinas sobre un tablero sin que se atacaran entre sí. Dos
 * años después, se dieron algunas de las 92 soluciones.
 * 
 * 
 * Una de las soluciones posibles
 * Desde entonces, matemáticos y aficionados de todo el mundo han estudiado el
 * problema, generalizándolo a tamaños de tableros de ajedrez de N×N. En 1972,
 * Dijkstra, en plena crisis del software, usó el problema para demostrar el
 * poder de la programación estructurada, y desde entonces es un ejemplo clásico
 * de algoritmo de vuelta atrás.
 * 
 * Para poder colocar las reinas, el primer paso es saber cuándo un grupo de
 * reinas sobre un tablero de ajedrez se atacan entre sí, es decir cuándo hay al
 * menos una reina que podría comer a otra siguiendo las reglas del movimiento
 * del juego.
 * 
 * Entrada
 * La entrada consta de un conjunto de casos de prueba. Cada uno comienza con
 * una línea con dos números. El primero indica el ancho y alto del tablero de
 * ajedrez (siempre será cuadrado de como mucho 2.000×2.000). El segundo indica
 * el número de reinas colocadas sobre él (entre 1 y 100).
 * 
 * A continuación vendrá una línea con la posición de todas las reinas. Para
 * cada una, se indicará primero la coordenada X y luego la Y, separadas por
 * espacio. Las posiciones de cada reina también se separarán por un único
 * espacio. Todas las posiciones serán válidas (cada coordenada estará entre 1 y
 * el tamaño del tablero) y se garantiza que no habrá dos reinas en la misma
 * posición.
 * 
 * La entrada termina con un caso de prueba con un tablero de tamaño 0×0 y sin
 * reinas que no debe procesarse.
 * 
 * Salida
 * Para cada caso de prueba, el programa escribirá, en la salida estándar, una
 * línea con el texto "SI" si hay reinas atacadas en la configuración dada, y
 * "NO" en otro caso (sin las comillas).
 * 
 * Entrada de ejemplo
 * 8 8
 * 1 2 2 8 3 6 4 1 5 3 6 5 7 7 8 4
 * 4 2
 * 1 1 3 3
 * 4 2
 * 1 1 3 2
 * 0 0
 * Salida de ejemplo
 * 
 * NO
 * SI
 * NO
 * 
 */