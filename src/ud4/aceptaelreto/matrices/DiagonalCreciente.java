package ud4.aceptaelreto.matrices;

import java.util.Scanner;

public class DiagonalCreciente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Ingrese el tamaño del tablero (0 para salir): ");
            int n = scanner.nextInt();
            if (n == 0)
                break;

            int[][] tablero = new int[n][n];

            System.out.println("Ingrese la configuración del tablero:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    tablero[i][j] = scanner.nextInt();
                }
            }

            int resultado = encontrarMinimosMovimientos(tablero, n);
            if (resultado == -1) {
                System.out.println("IMPOSIBLE");
            } else {
                System.out.println("Mínimos movimientos: " + resultado);
            }
        }
        scanner.close();
    }

    private static int encontrarMinimosMovimientos(int[][] tablero, int n) {
        // Verificar si la diagonal ya es estrictamente creciente
        if (esDiagonalCreciente(tablero, n)) {
            return 0;
        }

        // Aquí se debería implementar una estrategia de búsqueda para transformar el
        // tablero
        // con los movimientos permitidos y encontrar la solución óptima.
        // Esto podría incluir BFS o alguna heurística adecuada.

        return -1; // Si no se encuentra una solución, devolver -1 (IMPOSIBLE)
    }

    private static boolean esDiagonalCreciente(int[][] tablero, int n) {
        for (int i = 1; i < n; i++) {
            if (tablero[i][i] <= tablero[i - 1][i - 1]) {
                return false;
            }
        }
        return true;
    }
}

/*
 * Diagonal creciente
 * 
 * Ilustración sobre el puzzle de 15 de Sam Loyd en el libro Cyclopedia of 5000
 * Puzzles (1914)
 * A finales del siglo XIX se puso de moda el conocido como
 * "el solitario del quince", o el "puzzle del quince".
 * 
 * Este puzzle consiste en un cuadrado con 4×4 casillas ocupadas por 15 piezas
 * cuadradas con los números del 1 al 15 y una casilla vacía en el lugar donde
 * debería estar el número 16. El único movimiento posible consiste en deslizar
 * al cuadrado vacío una de las piezas que ocupan posiciones adyacentes. El
 * objetivo es conseguir una configuración determinada.
 * 
 * El puzzle fue objeto de polémica pues se lanzaron concursos en los que se
 * premiaba a aquellos que consiguieran configuraciones concretas, pero pronto
 * se demostró matemáticamente que de las más de 1013 colocaciones, sólo la
 * mitad son alcanzables.
 * 
 * Existe otro solitario parecido que también se juega con un tablero de N×N
 * casillas con números. En este caso los movimientos posibles son cuatro: mover
 * la columna de más a la izquierda a la derecha del todo desplazando el resto
 * de columnas una posición hacia la izquierda; mover la columna de la derecha a
 * la izquierda (movimiento contrario al anterior); mover la fila superior a la
 * parte inferior del tablero; y mover la fila inferior a la parte superior
 * (movimiento opuesto).
 * 
 * Con estos movimientos el objetivo del solitario es conseguir que la diagonal
 * principal (la que va de arriba a la izquierda a abajo a la derecha) sea
 * estrictamente creciente. Igual que en el puzzle del quince, no siempre es
 * posible alcanzar tal configuración.
 * 
 * Entrada
 * La entrada está formada por distintos casos de prueba. Cada uno comienza con
 * un número N que indica el ancho y el alto del tablero (1 ≤ N ≤ 2000). A
 * continuación aparecen N líneas con N números cada una representando la
 * configuración inicial del tablero.
 * 
 * El último caso va seguido de una línea con un 0.
 * 
 * Salida
 * Para cada caso de prueba se escribirá una única línea con el mínimo número de
 * movimientos que deben hacerse para conseguir que la diagonal principal del
 * tablero sea estrictamente creciente. Si no es posible alcanzar tal
 * configuración se escribirá IMPOSIBLE.
 * 
 * Entrada de ejemplo
 * 3
 * 1 4 0
 * 0 2 5
 * 6 0 3
 * 2
 * 0 1
 * 2 0
 * 3
 * 9 6 4
 * 9 8 5
 * 4 1 7
 * 2
 * 1 2
 * 2 1
 * 0
 * Salida de ejemplo
 * 
 * 0
 * 1
 * 2
 * IMPOSIBLE
 */