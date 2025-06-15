
package ud4.aceptaelreto.matrices;

import java.util.Scanner;

public class MatrizIdentidad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer casos de prueba hasta que se ingrese una matriz de 0 filas
        while (true) {
            System.out.print("Ingresa el número de filas (y columnas) de la matriz (0 para terminar): ");
            int tamañoMatriz = scanner.nextInt(); // Número de filas (y columnas)

            // Si el tamaño de la matriz es 0, terminamos el programa
            if (tamañoMatriz == 0) {
                System.out.println("Programa terminado.");
                break; // Si es 0, terminamos la entrada
            }

            // Crear la matriz
            int[][] matriz = new int[tamañoMatriz][tamañoMatriz];
            boolean esMatrizIdentidad = true; // Suponemos que es una matriz identidad

            System.out.println("Ingresa los elementos de la matriz:");

            // Leer los elementos de la matriz
            for (int i = 0; i < tamañoMatriz; i++) {
                for (int j = 0; j < tamañoMatriz; j++) {
                    matriz[i][j] = scanner.nextInt();
                }
            }

            // Comprobar si la matriz es identidad
            for (int i = 0; i < tamañoMatriz; i++) {
                for (int j = 0; j < tamañoMatriz; j++) {
                    // Si estamos en la diagonal principal (i == j), debe ser 1
                    // Si no estamos en la diagonal principal (i != j), debe ser 0
                    if ((i == j && matriz[i][j] != 1) || (i != j && matriz[i][j] != 0)) {
                        esMatrizIdentidad = false;
                        break;
                    }
                }
                if (!esMatrizIdentidad) {
                    break;
                }
            }

            // Imprimir el resultado para este caso de prueba
            if (esMatrizIdentidad) {
                System.out.println("La matriz es identidad: SI");
            } else {
                System.out.println("La matriz es identidad: NO");
            }
        }

        // Cerrar el scanner
        scanner.close();
    }
}

/*
 * ¿Es matriz identidad?
 * Tiempo máximo: 1,000-2,000 s Memoria máxima: 4096 KiB
 * Se dice que una matriz es identidad cuando todos sus elementos son cero a
 * excepción de la diagonal principal, que se encuentra rellena de unos:
 * 
 * I3=⎡⎣⎢⎢100010001⎤⎦⎥⎥
 * Para que una matriz sea identidad debe de ser cuadrada, es decir, tener el
 * mismo número de filas que de columnas.
 * 
 * Entrada
 * La entrada consta de una serie de casos de prueba. Cada uno comienza con un
 * número que representa el número de filas, como máximo 50, de una matriz
 * cuadrada. Tras él, aparecen los elementos que forman la matriz, que serán
 * valores entre -1.000 y 1.000 (incluídos).
 * 
 * La entrada terminará con una matriz de 0 filas.
 * 
 * Salida
 * Para cada caso de prueba se indicará SI si la matriz es identidad y NO en
 * caso contrario.
 * 
 * Entrada de ejemplo
 * 3
 * 1 0 0
 * 0 1 0
 * 0 0 1
 * 2
 * 0 1
 * 1 0
 * 5
 * 1 0 0 0 0
 * 0 5 0 0 0
 * 0 0 1 0 0
 * 0 0 0 1 0
 * 0 0 0 0 1
 * 0
 * Salida de ejemplo
 * SI
 * NO
 * NO
 */