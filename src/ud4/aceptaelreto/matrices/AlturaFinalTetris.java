package ud4.aceptaelreto.matrices;

import java.util.Scanner;

public class AlturaFinalTetris {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Leer el número de columnas y el número de piezas
            System.out.println("Ingrese el número de columnas y piezas:");
            int numColumnas = scanner.nextInt(); // número de columnas
            int numPiezas = scanner.nextInt(); // número de piezas

            // Si ambos valores son 0, terminamos la entrada
            if (numColumnas == 0 && numPiezas == 0)
                break;

            // Inicializar el tablero con 0 en cada columna
            int[] alturasColumnas = new int[numColumnas]; // Esta array guardará la altura de cada columna
            System.out.println("Tablero inicial de alturas:");
            for (int h : alturasColumnas) {
                System.out.print(h + " ");
            }
            System.out.println();

            // Procesar cada pieza
            for (int i = 0; i < numPiezas; i++) {
                System.out.println("Ingrese los datos de la pieza (Identificador, Rotación, Posición):");
                int tipoPieza = scanner.nextInt(); // Identificador de la pieza (1-7)
                int rotacion = scanner.nextInt(); // Rotación (0, 90, 180, 270)
                int posicionPieza = scanner.nextInt() - 1; // Posición de la pieza (1-indexed, la pasamos a 0-indexed)

                // Definir la pieza según su identificador y rotación
                int[][] pieza = obtenerPieza(tipoPieza, rotacion);

                // Encontrar la altura máxima donde puede caer la pieza
                int alturaMaxima = 0;
                for (int j = 0; j < pieza[0].length; j++) {
                    int columna = posicionPieza + j;
                    if (columna >= 0 && columna < numColumnas) {
                        alturaMaxima = Math.max(alturaMaxima, alturasColumnas[columna] + pieza[1][j]);
                    }
                }

                // Colocar la pieza en el tablero y actualizar las alturas
                for (int j = 0; j < pieza[0].length; j++) {
                    int columna = posicionPieza + j;
                    if (columna >= 0 && columna < numColumnas) {
                        alturasColumnas[columna] = Math.max(alturasColumnas[columna], alturaMaxima + pieza[0][j]);
                    }
                }

                System.out.println("Estado del tablero después de la pieza " + (i + 1) + ":");
                for (int h : alturasColumnas) {
                    System.out.print(h + " ");
                }
                System.out.println();
            }

            // Imprimir las alturas finales
            System.out.println("Alturas finales de las columnas:");
            for (int h : alturasColumnas) {
                System.out.print(h + " ");
            }
            System.out.println();
        }

        scanner.close(); // Cerrar el scanner después de la lectura
    }

    // Función para obtener la forma de la pieza con base en su rotación
    public static int[][] obtenerPieza(int tipoPieza, int rotacion) {
        int[][] pieza = new int[2][4]; // Para almacenar la forma de la pieza
        // Definir la pieza por tipo
        switch (tipoPieza) {
            case 1: // I
                pieza[0] = new int[] { 1, 1, 1, 1 }; // Línea horizontal
                pieza[1] = new int[] { 1, 1, 1, 1 };
                break;
            case 2: // O
                pieza[0] = new int[] { 1, 1, 0, 0 }; // Cuadrado 2x2
                pieza[1] = new int[] { 1, 1, 0, 0 };
                break;
            case 3: // T
                pieza[0] = new int[] { 1, 1, 1, 0 }; // Forma en T
                pieza[1] = new int[] { 0, 1, 0, 0 };
                break;
            case 4: // S
                pieza[0] = new int[] { 0, 1, 1, 0 }; // Forma en S
                pieza[1] = new int[] { 1, 1, 0, 0 };
                break;
            case 5: // Z
                pieza[0] = new int[] { 1, 1, 0, 0 }; // Forma en Z
                pieza[1] = new int[] { 0, 1, 1, 0 };
                break;
            case 6: // J
                pieza[0] = new int[] { 1, 0, 0, 0 }; // Forma J
                pieza[1] = new int[] { 1, 1, 1, 0 };
                break;
            case 7: // L
                pieza[0] = new int[] { 0, 0, 1, 0 }; // Forma L
                pieza[1] = new int[] { 1, 1, 1, 0 };
                break;
        }

        // Aplicar rotaciones
        for (int r = 0; r < rotacion / 90; r++) {
            pieza = rotarPieza(pieza);
        }

        return pieza;
    }

    // Función para rotar una pieza 90 grados
    public static int[][] rotarPieza(int[][] pieza) {
        int filas = pieza.length;
        int columnas = pieza[0].length;
        int[][] nuevaPieza = new int[columnas][filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                nuevaPieza[j][filas - 1 - i] = pieza[i][j];
            }
        }

        return nuevaPieza;
    }
}

/*
 * Altura final en Tetris
 * En este problema vamos a suponer una secuencia de piezas que caen, cada una
 * en una determinada posición y con una determinada orientación que no se
 * pueden cambiar. Las piezas se van amontonando según caen y no se eliminan las
 * filas completas (como ocurre en el juego original). El objetivo es determinar
 * la altura final de cada columna del tablero después de que caigan todas las
 * piezas.
 * 
 * La entrada está formada por distintos casos de prueba, cada uno ocupando
 * varias líneas.
 * 
 * La primera línea contiene dos números, el número de columnas del tablero (C)
 * y el número de piezas que van a caer (N). A continuación hay N líneas, cada
 * una de ellas con la descripción de una pieza.
 * 
 * La descripción de una pieza consta de tres números: I, R y P. El primer
 * número, I, es el identificador de la pieza (un número entre 1 y 7, en el
 * mismo orden que en la figura). El segundo número, R, es la rotación de la
 * pieza. Puede tomar los valores 0, 90, 180 o 270 y representa el ángulo de
 * rotación de la pieza en el sentido contrario a las agujas del reloj. El
 * tercer número, P, indica la posición de la pieza. Representa la columna más a
 * la izquierda ocupada por la pieza. La numeración de las columnas empieza en
 * 1.
 * 
 * Los valores mínimo y máximo para C y N son 4 ≤ C ≤ 100, 1 ≤ N ≤ 100.000. A
 * modo de ejemplo, se muestra el resultado de colocar tres fichas en un tablero
 * de 5 columnas.
 * 
 * El final de la entrada se indica con una línea con dos ceros que no se debe
 * procesar.
 * ===
 * 
 * Para resolver este problema de Tetris, lo que debemos hacer es simular cómo
 * caen las piezas en un tablero de varias columnas. A medida que las piezas
 * caen, se amontonan en el tablero y las columnas se van incrementando en
 * altura. Al final, necesitamos saber la altura final de cada columna.
 * 
 * Descripción del problema
 * • Se nos proporciona un tablero con un número de columnas (C).
 * • Se nos dice cuántas piezas van a caer (N).
 * • Cada pieza tiene un identificador (I), una rotación (R) y una posición
 * inicial (P).
 * • Nuestra tarea es determinar cómo las piezas caen y amontonan en el tablero,
 * calculando la altura de las columnas después de que todas las piezas hayan
 * caído.
 * 
 * Solución paso a paso
 * 1. Leer la entrada:
 * • Leer el número de columnas y el número de piezas.
 * • Luego, para cada pieza, leer su identificador, rotación y posición.
 * 2. Simular la caída de las piezas:
 * • Para cada pieza, dependiendo de su rotación, determinaremos qué bloques
 * ocupará en las columnas.
 * • Se simula el comportamiento de las piezas, y vamos actualizando la altura
 * de las columnas del tablero.
 * 3. Rotación de las piezas:
 * • Las piezas tienen distintas rotaciones. Dependiendo de la rotación, el
 * tamaño de la pieza y su forma varían. Por ejemplo, una pieza de tipo 1 (una
 * línea de 4 bloques) puede ser vertical u horizontal dependiendo de la
 * rotación.
 * 4. Actualización de la altura de las columnas:
 * • Cuando una pieza cae, actualizamos las columnas correspondientes en el
 * tablero para reflejar la nueva altura.
 * 5. Imprimir el resultado:
 * • Al final, mostramos la altura final de cada columna después de que todas
 * las piezas hayan caído.
 * 
 * Código en Java
 * 
 * 
 * 
 * Explicación del código
 * 1. Entrada y Preparación del Tablero:
 * • Leemos el número de columnas y piezas, y luego leemos la descripción de
 * cada pieza.
 * • Inicializamos un arreglo altura[] para almacenar la altura de cada columna.
 * 2. Procesamiento de las Piezas:
 * • Dependiendo del tipo de pieza, la rotación y la posición, calculamos las
 * posiciones ocupadas por la pieza en el tablero.
 * • Ajustamos la altura de las columnas según donde la pieza cae.
 * 3. Rotación de las Piezas:
 * • Usamos una matriz para representar la forma de cada pieza.
 * • Rotamos la pieza según el ángulo proporcionado (0, 90, 180, 270 grados)
 * usando una función rotarPieza.
 * 4. Impresión de Resultados:
 * • Después de procesar todas las piezas, imprimimos la altura final de cada
 * columna del tablero.
 * 
 * Conclusión
 * • El algoritmo simula la caída de las piezas y ajusta las alturas de las
 * columnas conforme van cayendo.
 * • El uso de matrices para representar las piezas facilita las rotaciones.
 * • El programa es eficiente para las restricciones del problema (hasta 100,000
 * piezas).
 */