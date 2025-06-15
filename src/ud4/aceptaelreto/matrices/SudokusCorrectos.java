package ud4.aceptaelreto.matrices;

import java.util.Scanner;

public class SudokusCorrectos {

    // Función para verificar si una secuencia de 9 números contiene todos los
    // números del 1 al 9
    public static boolean verificarSecuencia(int[] secuencia) {
        boolean[] visto = new boolean[9]; // Para verificar si hemos visto los números del 1 al 9
        for (int i = 0; i < 9; i++) {
            int num = secuencia[i] - 1; // Restamos 1 para mapear el número al índice del array visto
            if (num < 0 || num >= 9 || visto[num]) {
                return false; // Si el número no es válido o ya lo hemos visto, retornamos falso
            }
            visto[num] = true; // Marcamos este número como visto
        }
        return true;
    }

    // Función para verificar si el sudoku es correcto
    public static boolean esSudokuCorrecto(int[][] sudoku) {
        // Verificar filas
        for (int i = 0; i < 9; i++) {
            if (!verificarSecuencia(sudoku[i])) {
                return false; // Si alguna fila no es válida, el sudoku no es correcto
            }
        }

        // Verificar columnas
        for (int j = 0; j < 9; j++) {
            int[] columna = new int[9];
            for (int i = 0; i < 9; i++) {
                columna[i] = sudoku[i][j]; // Cargar la columna en un array temporal
            }
            if (!verificarSecuencia(columna)) {
                return false; // Si alguna columna no es válida, el sudoku no es correcto
            }
        }

        // Verificar subcuadrículas 3x3
        for (int fila = 0; fila < 9; fila += 3) {
            for (int col = 0; col < 9; col += 3) {
                int[] subcuadricula = new int[9];
                int index = 0;
                for (int i = fila; i < fila + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        subcuadricula[index++] = sudoku[i][j]; // Extraemos los números de la subcuadrícula
                    }
                }
                if (!verificarSecuencia(subcuadricula)) {
                    return false; // Si alguna subcuadrícula no es válida, el sudoku no es correcto
                }
            }
        }

        // Si todas las verificaciones pasaron, el sudoku es correcto
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de casos de prueba
        System.out.print("Ingrese el número de casos de prueba: ");
        int casos = scanner.nextInt();

        // Para cada caso de prueba
        for (int c = 0; c < casos; c++) {
            System.out.println("\nCaso de prueba #" + (c + 1));
            int[][] sudoku = new int[9][9];

            // Leer el sudoku
            System.out.println("Ingrese el tablero de Sudoku:");
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sudoku[i][j] = scanner.nextInt();
                }
            }

            // Verificar si el sudoku es correcto
            if (esSudokuCorrecto(sudoku)) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        }

        scanner.close();
    }
}

/*
 * Sudokus correctos
 * Sudoku completo
 * El sudoku es un pasatiempo lógico que consiste en rellenar una cuadrícula de
 * 9×9 casillas dividida en nueve regiones 3×3 (las separadas con líneas más
 * gruesas en la imagen) con los números del 1 al 9 de tal forma que no se
 * repitan números en ninguna fila, columna o región. El sudoku inicialmente se
 * presenta con algunas casillas ya rellenas, a modo de pistas, y el jugador
 * debe deducir los valores de las casillas vacías. Si el sudoku está bien
 * planteado, la solución es única.
 * 
 * Dado un sudoku completamente relleno, ¿sabrías construir un programa que
 * comprobara si es correcto (es decir, cada fila, columna o región contiene los
 * números del 1 al 9 exactamente una vez)?
 * 
 * Entrada
 * La entrada comienza con un número que representa el número de casos de prueba
 * que vendrán a continuación.
 * 
 * Cada caso de prueba está formado por 9 líneas, cada una con 9 números entre
 * el 1 y el 9 separados por espacios, que representan un sudoku completamente
 * relleno.
 * 
 * Salida
 * Para cada caso, se escribirá una línea con la palabra SI si el sudoku ha sido
 * resuelto correctamente, y NO en caso contrario.
 * 
 * Entrada de ejemplo
 * 1
 * 4 1 3 8 2 5 6 7 9
 * 5 6 7 1 4 9 8 3 2
 * 2 8 9 7 3 6 1 4 5
 * 1 9 5 4 6 2 7 8 3
 * 7 2 6 9 8 3 5 1 4
 * 3 4 8 5 1 7 2 9 6
 * 8 5 1 6 9 4 3 2 7
 * 9 7 2 3 5 8 4 6 1
 * 6 3 4 2 7 1 9 5 8
 * Salida de ejemplo
 * 
 * SI
 */