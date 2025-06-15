package ud4.aceptaelreto.matrices;

import java.util.Scanner;

public class PuntosDeSilla {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Leer el número de filas y columnas
            int filas = scanner.nextInt();
            int columnas = scanner.nextInt();

            // Si las filas y columnas son 0, terminamos la entrada
            if (filas == 0 && columnas == 0)
                break;

            // Leer la matriz
            int[][] matriz = new int[filas][columnas];
            System.out.println("Ingrese los valores de la matriz:");

            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    matriz[i][j] = scanner.nextInt();
                }
            }

            // Verificar si la matriz tiene un punto de silla
            boolean tienePuntoDeSilla = false;

            // Comprobar cada elemento de la matriz
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    int elemento = matriz[i][j];
                    boolean esMinimoDeFila = true;
                    boolean esMaximoDeColumna = true;
                    boolean esMaximoDeFila = true;
                    boolean esMinimoDeColumna = true;

                    // Verificar si es el mínimo en su fila
                    for (int k = 0; k < columnas; k++) {
                        if (matriz[i][k] < elemento) {
                            esMinimoDeFila = false;
                            break;
                        }
                    }

                    // Verificar si es el máximo en su columna
                    for (int k = 0; k < filas; k++) {
                        if (matriz[k][j] > elemento) {
                            esMaximoDeColumna = false;
                            break;
                        }
                    }

                    // Verificar si es el máximo en su fila
                    for (int k = 0; k < columnas; k++) {
                        if (matriz[i][k] > elemento) {
                            esMaximoDeFila = false;
                            break;
                        }
                    }

                    // Verificar si es el mínimo en su columna
                    for (int k = 0; k < filas; k++) {
                        if (matriz[k][j] < elemento) {
                            esMinimoDeColumna = false;
                            break;
                        }
                    }

                    // Si cumple alguna de las condiciones de punto de silla
                    if ((esMinimoDeFila && esMaximoDeColumna) || (esMaximoDeFila && esMinimoDeColumna)) {
                        tienePuntoDeSilla = true;
                        break;
                    }
                }
                if (tienePuntoDeSilla) {
                    break;
                }
            }

            // Imprimir el resultado
            if (tienePuntoDeSilla) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        }

        scanner.close(); // Cerrar el scanner después de la lectura
    }
}

/*
 * Puntos de silla
 * Los puntos de silla de una matriz son aquellos elementos de la matriz que
 * cumplen que son menores o iguales que el resto de elementos de su fila y
 * mayores o iguales que el resto de elementos de su columna, o al revés,
 * mayores o iguales que el resto de elementos de su fila y menores o iguales
 * que el resto de elementos de su columna.
 * 
 * Reciben este nombre por su similitud con una silla de montar a caballo;
 * aunque el caso de la silla de montar es mucho más particular (los elementos a
 * partir del punto de silla están ordenados).
 * 
 * Dada una matriz, queremos saber si tiene puntos de silla o no.
 * 
 * Entrada
 * La entrada está compuesta por diferentes casos de prueba. Cada caso comienza
 * con una línea con dos enteros, el número F de filas y el número C de columnas
 * de la matriz (entre 1 y 300). A continuación, aparecen F líneas cada una con
 * C números enteros, que representan los valores de la matriz.
 * 
 * La entrada termina cuando el número de filas y columnas de un caso es 0. Este
 * último caso no debe ser procesado.
 * 
 * Salida
 * Para cada caso de prueba se escribirá SI si la matriz tiene puntos de silla y
 * NO en caso contrario.
 * 
 * Entrada de ejemplo
 * 3 3
 * 2 4 2
 * 1 3 1
 * 2 4 2
 * 2 4
 * 1 2 6 1
 * 5 6 2 4
 * 2 2
 * 1 1
 * 1 1
 * 0 0
 * Salida de ejemplo
 * 
 * SI
 * NO
 * SI
 */