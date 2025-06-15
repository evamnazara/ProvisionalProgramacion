package ud4.aceptaelreto.matrices;

import java.util.Scanner;

public class FuerzasImperiales {

    // Direcciones de movimiento: arriba, abajo, izquierda, derecha
    private static final int[] DIRECCION_X = { -1, 1, 0, 0 };
    private static final int[] DIRECCION_Y = { 0, 0, -1, 1 };

    // Función para verificar si una posición es válida (dentro de los límites y no
    // es un asteroide)
    private static boolean esValido(int x, int y, int filas, int columnas, char[][] campo) {
        return x >= 0 && x < filas && y >= 0 && y < columnas && campo[x][y] != '*';
    }

    // Función para realizar un recorrido secuencial simple
    private static boolean recorrerCampo(char[][] campo, int filas, int columnas, int sx, int sy, int fx, int fy) {
        boolean[][] visitado = new boolean[filas][columnas]; // Para marcar las celdas visitadas

        // Usamos una pila sencilla para hacer el recorrido manualmente
        int[] pilaX = new int[filas * columnas]; // Pilas para la posición X
        int[] pilaY = new int[filas * columnas]; // Pilas para la posición Y
        int top = -1; // Índice de la pila

        // Comenzamos desde la posición 'S'
        pilaX[++top] = sx;
        pilaY[top] = sy;
        visitado[sx][sy] = true;

        while (top >= 0) {
            // Sacamos la última posición de la pila
            int x = pilaX[top];
            int y = pilaY[top];
            top--;

            // Si llegamos a la posición 'F', hemos encontrado el camino
            if (x == fx && y == fy) {
                return true;
            }

            // Revisamos las 4 direcciones posibles (arriba, abajo, izquierda, derecha)
            for (int i = 0; i < 4; i++) {
                int nuevaX = x + DIRECCION_X[i];
                int nuevaY = y + DIRECCION_Y[i];

                // Si la nueva posición es válida y no ha sido visitada
                if (esValido(nuevaX, nuevaY, filas, columnas, campo) && !visitado[nuevaX][nuevaY]) {
                    visitado[nuevaX][nuevaY] = true;
                    pilaX[++top] = nuevaX;
                    pilaY[top] = nuevaY;
                }
            }
        }

        return false; // Si no hemos encontrado un camino
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de casos de prueba
        System.out.print("Ingrese el número de casos de prueba: ");
        int casos = scanner.nextInt();

        // Para cada caso de prueba
        for (int c = 0; c < casos; c++) {
            System.out.println("\nCaso de prueba #" + (c + 1));

            // Leer las dimensiones de la cuadrícula
            int filas = scanner.nextInt();
            int columnas = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea después de los enteros

            // Crear la cuadrícula y encontrar las posiciones S y F
            char[][] campo = new char[filas][columnas];
            int sx = -1, sy = -1, fx = -1, fy = -1;

            // Leer el mapa del campo de asteroides
            for (int i = 0; i < filas; i++) {
                String linea = scanner.nextLine();
                for (int j = 0; j < columnas; j++) {
                    campo[i][j] = linea.charAt(j);
                    if (campo[i][j] == 'S') {
                        sx = i;
                        sy = j; // Guardamos la posición de la entrada
                    }
                    if (campo[i][j] == 'F') {
                        fx = i;
                        fy = j; // Guardamos la posición de la salida
                    }
                }
            }

            // Ejecutamos el recorrido secuencial para ver si podemos llegar de 'S' a 'F'
            if (recorrerCampo(campo, filas, columnas, sx, sy, fx, fy)) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        }

        scanner.close();
    }
}

/*
 * Escapando de las fuerzas imperiales
 * El Halcón Milenario
 * Nuestros héroes, a bordo del Halcón Milenario y confiando en la pericia de
 * Han Solo, están intentado escapar de las fuerzas rebeldes. Para despistar a
 * las fuerzas imperiales, Han Solo quiere introducirse en un campo de
 * asteroides.
 * 
 * Pero antes de tan arriesgada maniobra quiere saber si, una vez dentro, podrán
 * salir de él o es mejor buscar una alternativa más prudente.
 * 
 * El campo de asteroides es una cuadrícula en el que el Halcón Milenario puede
 * moverse en horizontal y en vertical, pero no en diagonal. Las casillas pueden
 * ser transitables, o estar ocupadas por asteroides inmóviles.
 * 
 * Entrada
 * Cada caso de prueba comienza con una pareja de números 1 ≤ F,C ≤ 20
 * indicando, respectivamente, el número de filas y columnas de la cuadrícula
 * que representa el campo de asteroides.
 * 
 * A continuación irán F líneas, cada una con C caracteres. Un asterisco ('*')
 * indica una celda con asteroide, y un punto ('.') indica una celda
 * transitable. El Halcón Milenario entra al campo de asteroides en la celda
 * identificada con la letra S, y necesita salir de él en la celda F. En el
 * mapa, existirá una y solo una de cada una de esas letras y sus celdas deben
 * considerarse transitables.
 * 
 * Ten en cuenta que, gracias al hiperespacio, las celdas S y F pueden estar en
 * cualquier posición, no únicamente en los extremos.
 * 
 * Salida
 * Por cada caso de prueba el programa escribirá "SI" si es viable que el Halcón
 * Milenario se adentre en el campo de asteroides porque hay al menos un camino
 * desde el punto S al punto F siguiendo las reglas de movimiento de la nave. En
 * otro caso, el programa escribirá "NO".
 * 
 * Entrada de ejemplo
 * 2 2
 * SF
 * ..
 * 2 3
 * S*F
 * ..
 * 3 3
 * .S.
 ** .
 * F..
 * Salida de ejemplo
 * 
 * SI
 * NO
 * SI
 */