package ud4.aceptaelreto.matrices;

import java.util.Scanner;

public class ModificacionDeTablas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Leer el número de filas (F), columnas (C) y modificaciones (N)
            System.out.print("Ingrese las filas, columnas y el número de modificaciones: ");
            int F = scanner.nextInt();
            int C = scanner.nextInt();
            int N = scanner.nextInt();

            // Terminar el programa si F, C y N son cero
            if (F == 0 && C == 0 && N == 0) {
                break;
            }

            // Crear la tabla inicial llena de ceros
            int[][] tabla = new int[F][C];

            // Realizar las modificaciones según la entrada
            System.out.println("Ingrese las modificaciones:");
            for (int i = 0; i < N; i++) {
                // Leer los valores de cada modificación
                int I = scanner.nextInt();
                int A = scanner.nextInt();
                int B = scanner.nextInt();
                int M = scanner.nextInt();

                // Modificar los valores de la columna I en las filas A a B
                for (int j = A; j <= B; j++) {
                    tabla[j][I] += M;
                }
            }

            // Imprimir la tabla resultante después de todas las modificaciones
            System.out.println("Tabla modificada:");
            for (int i = 0; i < F; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print(tabla[i][j] + " ");
                }
                System.out.println(); // Imprimir salto de línea al final de cada fila
            }
        }

        scanner.close();
    }
}

/*
 * Modificación de tablas
 * Sección de una hoja de cálculo grande
 * En ocasiones es necesario modificar los valores numéricos de una tabla a
 * través de un fichero que contiene instrucciones de cómo modificar dicha
 * tabla. Por ejemplo, una tarea a realizar de la forma anterior sería la de
 * aumentar o disminuir el valor de un rango consecutivo de casillas que se
 * encuentran dentro de una misma columna de la tabla.
 * 
 * Entrada
 * La entrada está formada por distintos casos de prueba, y cada caso de prueba
 * ocupa varias líneas. La primera línea contiene tres números: el número de
 * filas (F) y columnas (C) de la tabla, y el número de modificaciones que se
 * van a hacer sobre ella (N).
 * 
 * A continuación hay N líneas, cada una de ellas con la descripción de una
 * modificación a la tabla. Cada una de estas líneas consta de cuatro números:
 * I, A, B y M. El primer número, I, es el índice de la columna que se va a
 * modificar. Los números A y B son los índices de la primera y la última fila a
 * modificar. El número M es el valor a añadir a las casillas anteriores.
 * 
 * Se garantiza que 1 ≤ F, 1 ≤ C, F×C ≤ 1.000.000, 1 ≤ N ≤ 100.000 y −10 ≤ M ≤
 * 10. Los índices de las filas y las columnas empiezan en 0, y la tabla se
 * supone inicialmente rellena de ceros.
 * 
 * La entrada termina con tres ceros, que no deben procesarse.
 * 
 * Salida
 * Para cada caso de prueba, se escribirá una tabla con F filas y C columnas en
 * la cual se han realizado todas y cada una de las operaciones indicadas. Cada
 * número dentro de una misma fila se separará mediante un espacio y al final de
 * cada fila se insertará un salto de línea.
 * 
 * Entrada de ejemplo
 * 4 5 3
 * 2 0 3 1
 * 0 1 2 -1
 * 2 1 1 2
 * 0 0 0
 * Salida de ejemplo
 * 0 0 1 0 0
 * -1 0 3 0 0
 * -1 0 1 0 0
 * 0 0 1 0 0
 */
