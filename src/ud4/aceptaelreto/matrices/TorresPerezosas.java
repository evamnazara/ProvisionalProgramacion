package ud4.aceptaelreto.matrices;

public class TorresPerezosas {
    public static void main(String[] args) {
        // Definición de varios tableros de ejemplo
        char[][] tablero1 = {
                { '.', '.', '.' },
                { '.', '.', '.' },
                { '.', '.', '.' }
        };

        char[][] tablero2 = {
                { '.', '.', '.' },
                { 'x', '.', '.' },
                { '.', '.', '.' }
        };

        char[][] tablero3 = {
                { '.', '.', '.' },
                { '.', 'x', '.' },
                { '.', '.', '.' }
        };

        // Llamada a la función iterativa para calcular los caminos posibles
        System.out.println("Resultado (iterativo) para tablero 1: " + caminosDistintos(tablero1));
        System.out.println("Resultado (iterativo) para tablero 2: " + caminosDistintos(tablero2));
        System.out.println("Resultado (iterativo) para tablero 3: " + caminosDistintos(tablero3));

        // Llamada a la función recursiva para calcular los caminos posibles
        System.out.println("Resultado (recursivo) para tablero 1: " + caminosDistintosRecursivo(tablero1));
        System.out.println("Resultado (recursivo) para tablero 2: " + caminosDistintosRecursivo(tablero2));
        System.out.println("Resultado (recursivo) para tablero 3: " + caminosDistintosRecursivo(tablero3));
    }

    // Función iterativa para calcular los caminos distintos
    private static int caminosDistintos(char[][] tablero) {
        int n = tablero.length; // Tamaño del tablero
        int[][] tablaResultado = new int[n][n]; // Tabla para almacenar el número de caminos

        // Inicializar la casilla inicial (esquina inferior izquierda)
        tablaResultado[n - 1][0] = 1;

        // Recorrer el tablero de abajo hacia arriba y de izquierda a derecha
        for (int fila = n - 1; fila >= 0; fila--) {
            for (int columna = 0; columna < n; columna++) {
                // Si la casilla es transitable (no es 'x')
                if (tablero[fila][columna] != 'x') {
                    // Si no estamos en la primera fila, sumar las formas de llegar desde la casilla
                    // de abajo
                    if (fila < n - 1) {
                        tablaResultado[fila][columna] += tablaResultado[fila + 1][columna];
                    }

                    // Si no estamos en la primera columna, sumar las formas de llegar desde la
                    // casilla de la izquierda
                    if (columna > 0) {
                        tablaResultado[fila][columna] += tablaResultado[fila][columna - 1];
                    }
                }
            }
        }

        // El resultado estará en la casilla superior derecha
        return tablaResultado[0][n - 1];
    }

    // Función recursiva para calcular los caminos distintos
    private static int caminosDistintosRecursivo(char[][] tablero) {
        return calcularCasilla(tablero, 0, tablero.length - 1);
    }

    // Función recursiva que calcula el número de caminos desde una casilla (i, j)
    private static int calcularCasilla(char[][] tablero, int fila, int columna) {
        int n = tablero.length;

        // Caso base: si llegamos a la casilla destino (esquina superior derecha)
        if (fila == 0 && columna == n - 1) {
            return 1;
        }

        // Si la casilla es no transitable ('X'), no se puede pasar
        if (tablero[fila][columna] == 'x') {
            return 0;
        }

        // Si estamos en la primera fila, solo podemos movernos a la derecha
        if (fila == 0) {
            return calcularCasilla(tablero, fila, columna + 1);
        }

        // Si estamos en la primera columna, solo podemos movernos hacia arriba
        if (columna == n - 1) {
            return calcularCasilla(tablero, fila - 1, columna);
        }

        // Si no estamos en el borde, podemos movernos tanto hacia la derecha como hacia
        // arriba
        return calcularCasilla(tablero, fila, columna + 1) + calcularCasilla(tablero, fila - 1, columna);
    }
}

/*
 * 
 * En un tablero de ajedrez las torres pueden moverse en horizontal y en
 * vertical tantas casillas como quieran, pero siempre en línea recta. En
 * nuestro caso, tenemos una torre perezosa que se mueve sólo hacia la derecha o
 * hacia arriba y una casilla cada vez.
 * 
 * Si situamos a nuestra torre en la esquina inferior izquierda de un tablero de
 * 3×3 y queremos que vaya a la esquina superior derecha, es fácil ver que
 * tendrá que hacer como mínimo 4 movimientos, aunque puede seguir varias rutas
 * distintas. En la siguiente figura aparecen dos de ellas:
 * 
 * Dos caminos igual de largos en un tablero de 3x3
 * Tiene sentido plantearse, ¿de cuántas formas distintas podría llegar nuestra
 * torre desde el origen al destino con el mínimo número de movimientos posible?
 * Una forma de hacer el cálculo es averiguar de forma iterativa el número de
 * formas diferentes que tenemos de llegar hasta cada uno de los escaques
 * intermedios. Empezamos anotando que sólo hay una forma para que la torre
 * "vaya" de la casilla inicial a esa misma casilla inicial en el mínimo número
 * de movimientos (no moviéndose):
 * 
 * Primer paso iterativo, con un '1' en la esquina inferior izquierda
 * Para las demás, sabemos que el número de maneras de llegar a un escaque en el
 * mínimo número de pasos será la suma del número de formas de llegar a cada uno
 * de los escaques adyacentes hacia la izquierda o hacia abajo (llegar a un
 * escaque por arriba o por la derecha sería "ir hacia atrás"). Por tanto, lo
 * que tenemos que hacer es ir calculando de cuántas formas se puede llegar a
 * los escaques adyacentes de los ya conocidos sumando los números conseguidos
 * anteriormente:
 * 
 * Siguientes pasos iterativos
 * Repitiendo el proceso hasta llegar a la última celda tenemos:
 * 
 * Ultimos pasos iterativos que rellenan el cuadrado completo
 * Esto demuestra que en un tablero de 3×3 hay seis formas distintas de ir, con
 * el mínimo número de movimientos posibles, de una esquina a otra.
 * 
 * Si en el tablero hay algunas casillas no transitables es necesario adaptar el
 * recorrido para tenerlas en cuenta. Por ejemplo, en el siguiente tablero de
 * 3×3 con una celda no transitable se puede llegar del origen al destino de
 * tres formas distintas utilizando los cuatro movimientos mínimos:
 * 
 * Tablero de 3x3 con una celda no transitable
 * Entrada
 * La entrada estará compuesta de varios tableros de distintos tamaños. Cada
 * tablero comienza con una línea que contiene un número n (1 ≤ n ≤ 15) que
 * indica el número de filas y columnas del tablero. A continuación aparecen n
 * líneas, una por cada fila con n caracteres cada una. El carácter '.' (punto)
 * indica una casilla transitable, mientras que 'X' significa casilla no
 * transitable. Se garantiza que las casillas origen y destino siempre serán
 * transitables.
 * 
 * La entrada termina con un tablero vacío que no debe procesarse.
 * 
 * Salida
 * Para cada caso de prueba se escribirá una línea con un único número que
 * indica de cuántas formas distintas puede llegar nuestra torre perezosa desde
 * la esquina inferior izquierda del tablero a la esquina superior derecha
 * pasando por el mínimo número de casillas.
 * 
 * Se garantiza que el resultado nunca será mayor que 109.
 */