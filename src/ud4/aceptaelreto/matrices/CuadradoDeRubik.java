package ud4.aceptaelreto.matrices;

import java.util.Scanner;

public class CuadradoDeRubik {

    // Método para rotar una fila a la derecha o izquierda
    public static void rotarFila(char[][] matriz, int fila, int desplazamiento) {
        char temp;
        if (desplazamiento > 0) { // Rotación a la derecha
            for (int i = 0; i < desplazamiento; i++) {
                temp = matriz[fila][matriz.length - 1];
                for (int j = matriz.length - 1; j > 0; j--) {
                    matriz[fila][j] = matriz[fila][j - 1];
                }
                matriz[fila][0] = temp;
            }
        } else { // Rotación a la izquierda
            for (int i = 0; i < -desplazamiento; i++) {
                temp = matriz[fila][0];
                for (int j = 0; j < matriz.length - 1; j++) {
                    matriz[fila][j] = matriz[fila][j + 1];
                }
                matriz[fila][matriz.length - 1] = temp;
            }
        }
    }

    // Método para rotar una columna hacia abajo o hacia arriba
    public static void rotarColumna(char[][] matriz, int columna, int desplazamiento) {
        char temp;
        if (desplazamiento > 0) { // Rotación hacia abajo
            for (int i = 0; i < desplazamiento; i++) {
                temp = matriz[matriz.length - 1][columna];
                for (int j = matriz.length - 1; j > 0; j--) {
                    matriz[j][columna] = matriz[j - 1][columna];
                }
                matriz[0][columna] = temp;
            }
        } else { // Rotación hacia arriba
            for (int i = 0; i < -desplazamiento; i++) {
                temp = matriz[0][columna];
                for (int j = 0; j < matriz.length - 1; j++) {
                    matriz[j][columna] = matriz[j + 1][columna];
                }
                matriz[matriz.length - 1][columna] = temp;
            }
        }
    }

    // Método para imprimir la matriz de manera legible
    public static void imprimirMatriz(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Leer tamaño de la matriz
            int n = scanner.nextInt();
            if (n == 0)
                break; // Fin de la entrada

            // Leer la matriz inicial
            char[][] cuadrado = new char[n][n];
            scanner.nextLine(); // Limpiar el buffer
            for (int i = 0; i < n; i++) {
                String linea = scanner.nextLine();
                for (int j = 0; j < n; j++) {
                    cuadrado[i][j] = linea.charAt(j);
                }
            }

            // Leer las operaciones
            String operaciones = scanner.nextLine();
            String[] operacionesArray = operaciones.split(" ");

            // Realizar las operaciones
            for (int i = 0; i < operacionesArray.length; i++) {
                String operacion = operacionesArray[i];
                if (operacion.equals("x"))
                    break; // Fin de operaciones

                char tipoOperacion = operacion.charAt(0); // 'f' o 'c'
                int valor = Integer.parseInt(operacion.substring(1)); // El número de la operación

                if (tipoOperacion == 'f') {
                    // Rotar fila
                    rotarFila(cuadrado, valor - 1, valor > 0 ? valor : -valor);
                } else if (tipoOperacion == 'c') {
                    // Rotar columna
                    rotarColumna(cuadrado, valor - 1, valor > 0 ? valor : -valor);
                }
            }

            // Imprimir el resultado
            imprimirMatriz(cuadrado);
            System.out.println("---");
        }

        scanner.close();
    }
}

/*
 * El cuadrado de Rubik
 * 
 * El cubo de Rubik vs. Pacman
 * El cubo de Rubik es el juego de puzzle más vendido de la historia a nivel
 * mundial. Como todo el mundo sabe, consiste en un cubo en el que cada una de
 * sus seis caras está dividida en 9 cuadrados de un mismo color. Todo el cubo
 * es articulado, de manera que los cuadrados pueden desplazarse de una cara a
 * otra haciéndolas girar. El objetivo del juego es conseguir llegar a la
 * configuración de partida, con cada cara de un único color, tras haberla
 * descompuesto con movimientos aleatorios.
 * 
 * Los propietarios de la patente, tras cientos de millones de unidades
 * vendidas, consideran que el mundo se les ha quedado pequeño y están
 * intentando llegar a otros mercados. Se han dado cuenta de que algunas
 * criaturas, como Mario, Sonic o Pacman, no son capaces de jugar al cubo de
 * Rubik porque, por mucho que se les explica, no conciben la existencia de una
 * tercera dimensión. De modo que están diseñando una versión simplificada de su
 * juego: el cuadrado de Rubik.
 * 
 * En esencia, es similar al cubo, pero con sólo una cara. Los desplazamientos
 * de los cuadrados se pueden realizar por filas o por columnas. Así, por
 * ejemplo, si se desplaza una fila hacia la derecha, todos sus cuadrados
 * avanzan una posición, y el cuadrado que estaba situado más a la derecha
 * reaparece en el lado izquierdo.
 * 
 * 
 * Ejemplo de rotación hacia la derecha
 * Durante la primera fase del desarrollo de este nuevo producto, están
 * planteándose sus dimensiones y su dificultad, por lo que quieren hacer un
 * simulador del funcionamiento antes de comenzar el proceso de fabricación.
 * 
 * Entrada
 * El programa deberá leer varios casos de prueba de la entrada estándar. Cada
 * caso de prueba estará compuesto de múltiples líneas. La primera indica el
 * número n de cuadrados de ancho y alto del cuadrado de Rubik simulado, 1 ≤ n ≤
 * 50. A continuación vendrá la situación inicial del cuadrado de Rubik a través
 * de n líneas, conteniendo exactamente n letras del alfabeto inglés. Cada letra
 * representa el color de un cuadro interior del cuadrado de Rubik, y puede ser
 * tanto en mayúsculas como minúsculas, considerándose diferentes.
 * 
 * Tras la configuración del cuadrado, vendrá una línea con las operaciones
 * realizadas sobre él, separadas por espacios. Una operación está compuesta de
 * dos partes: una letra indicando si el movimiento es sobre una fila ("f") o
 * una columna ("c"), y un número v, cuyo valor absoluto 1 ≤ |v| ≤ n indica la
 * fila o la columna sobre la que se realiza la operación. La fila 1 se
 * corresponde con la primera línea de la descripción; la columna 1 se
 * corresponde con la primera letra de cada línea. Si el número v es positivo,
 * el desplazamiento será hacia la derecha (filas) o hacia abajo (columnas). Si
 * es negativo será hacia la izquierda o hacia arriba. La lista de operaciones
 * acaba con una "x".
 * 
 * La entrada acaba con un cuadrado de tamaño 0.
 * 
 * Salida
 * Para cada caso de prueba el programa escribirá, en la salida estándar, la
 * configuración final del cuadrado de Rubik en el mismo formato que en la
 * entrada.
 * 
 * Además, deberá escribir una línea con tres guiones ("---") después de cada
 * caso de prueba.
 * 
 * Entrada de ejemplo
 * 3
 * abc
 * abc
 * abc
 * f 1 f -2 x
 * 3
 * aaa
 * bbb
 * ccc
 * c 1 c -2 x
 * 0
 * Salida de ejemplo
 * cab
 * bca
 * abc
 * ---
 * cba
 * acb
 * bac
 * ---
 */