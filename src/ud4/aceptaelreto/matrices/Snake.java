package ud4.aceptaelreto.matrices;

import java.util.Scanner;

public class Snake {
    private static final int SIZE = 21;
    private static final int INITIAL_LENGTH = 10;
    private static final char UP = 'U';
    private static final char DOWN = 'D';
    private static final char LEFT = 'L';
    private static final char RIGHT = 'R';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int numMovements = scanner.nextInt();
            if (numMovements == 0)
                break;

            int[][] board = new int[SIZE][SIZE];
            int headRow = SIZE / 2;
            int headCol = SIZE / 2;
            int[][] snake = new int[SIZE * SIZE][2];
            int snakeLength = INITIAL_LENGTH;
            int time = 0;
            char currentDirection = UP;

            for (int i = 0; i < INITIAL_LENGTH; i++) {
                snake[i][0] = headRow + i;
                snake[i][1] = headCol;
                board[snake[i][0]][snake[i][1]] = 1;
            }

            int moveIndex = 0;
            int nextMoveTime = scanner.nextInt();
            char nextMoveDirection = scanner.next().charAt(0);

            while (true) {
                time++;

                if (moveIndex < numMovements && time == nextMoveTime) {
                    currentDirection = nextMoveDirection;
                    if (++moveIndex < numMovements) {
                        nextMoveTime = scanner.nextInt();
                        nextMoveDirection = scanner.next().charAt(0);
                    }
                }

                switch (currentDirection) {
                    case UP:
                        headRow--;
                        break;
                    case DOWN:
                        headRow++;
                        break;
                    case LEFT:
                        headCol--;
                        break;
                    case RIGHT:
                        headCol++;
                        break;
                }

                if (headRow < 0 || headRow >= SIZE || headCol < 0 || headCol >= SIZE || board[headRow][headCol] == 1) {
                    System.out.println(time - 1);
                    break;
                }

                board[headRow][headCol] = 1;

                if (time % 10 == 0) {
                    snakeLength++;
                } else {
                    int tailRow = snake[0][0];
                    int tailCol = snake[0][1];
                    board[tailRow][tailCol] = 0;
                    for (int i = 0; i < snakeLength - 1; i++) {
                        snake[i][0] = snake[i + 1][0];
                        snake[i][1] = snake[i + 1][1];
                    }
                }

                snake[snakeLength - 1][0] = headRow;
                snake[snakeLength - 1][1] = headCol;
            }
        }
        scanner.close();
    }
}

/*
 * Snake
 * Snake es un videojuego clásico que se creó en los años 70 y se popularizó
 * algunos años más tarde. Consiste en controlar a una serpiente evitando que
 * choque contra las paredes y contra su propia cola. La serpiente siempre está
 * en movimiento, pero el jugador puede controlar la dirección en la que su
 * cabeza avanza (izquierda, derecha, arriba o abajo). El cuerpo de la serpiente
 * sigue exactamente el movimiento de la cabeza. Para complicar las cosas, la
 * cola de la serpiente va creciendo y cada vez queda menos espacio disponible.
 * El juego termina cuando la cabeza de la serpiente choca, o bien contra una
 * pared, o bien contra su propio cuerpo.
 * 
 * Suponiendo un panel de juego cuadrado de tamaño 21 × 21 casillas, nuestro
 * objetivo es determinar en qué instante acaba el juego dada la secuencia de
 * movimientos realizados por el jugador.
 * 
 * El juego comienza en el instante t=0 con una serpiente de longitud 10,
 * alineada en dirección vertical, con la cabeza en el centro del tablero y
 * moviéndose hacia arriba. En ese momento tiene por delante 10 casillas en
 * blanco hasta el borde superior.
 * 
 * La serpiente siempre se mueve a razón de una casilla por unidad de tiempo en
 * base a la dirección que lleva, por lo que en el instante t=1 estará una
 * unidad más cerca del borde superior. Si no hay movimientos, en t=10 la cabeza
 * de la serpiente estará tocando el borde del tablero y al intentar avanzar
 * otra vez no podrá y colisionará. Eso sí, si en t=10 el usuario se mueve a la
 * derecha, salvará la situación y la serpiente se moverá pegada al borde
 * superior hasta el borde derecho, que alcanzará en t=20. Si no hay otros
 * movimientos, la partida terminará ahí.
 * 
 * Como hemos dicho, la serpiente va haciéndose más grande con el paso del
 * tiempo. En concreto cada 10 unidades de tiempo crece una unidad. Eso
 * significa, por ejemplo, que en t=10 la serpiente tiene las 10 unidades de
 * longitud iniciales pero en t=11 pasa a ocupar una unidad más. Ten en cuenta
 * que la serpiente crece por la cola, por lo que si el final de la serpiente en
 * t=10 estaba en la posición (x,y), esa posición seguirá ocupada en t=11 y, por
 * lo tanto, si la cabeza iba a colocarse en esa posición, habrá colisión y
 * terminará la partida.
 * 
 * Entrada
 * La entrada está formada por distintos casos de prueba, cada uno en una línea
 * distinta.
 * 
 * En cada línea aparece en primer lugar un número entero N (1 ≤ N ≤ 1.000), que
 * indica el número de movimientos que siguen a continuación. Tras esto la línea
 * contiene una lista con la descripción de los N movimientos. Un movimiento
 * viene descrito por la pareja (ti, li), i = 1,...,N, con ti un número entero y
 * li una letra mayúscula. El número, 1 ≤ ti ≤ 2.000, indica el instante en el
 * que se realiza el movimiento (será visible en ti+1). La letra indica la
 * dirección del mismo de acuerdo al siguiente esquema: U = arriba (up), D =
 * abajo (down), L = izquierda (left), R = derecha (right). Se garantiza que los
 * movimientos aparecen siempre ordenados por el instante en que se realizan.
 * 
 * El final de la entrada se indica con una línea con un único 0 que no se debe
 * procesar.
 * 
 * Salida
 * Para cada caso de prueba, se escribirá en una línea el último instante de
 * tiempo en el que la serpiente pudo avanzar, justo antes de la primera
 * colisión. Este instante siempre existirá, pues después del último movimiento,
 * en el supuesto de que se llegue a este punto, la serpiente continúa en línea
 * recta hasta chocar. Por otra parte es posible que en algunos casos el juego
 * termine antes de que se realicen todos los movimientos.
 * 
 * Entrada de ejemplo
 * 1 100 R
 * 1 10 R
 * 1 1 D
 * 3 1 R 2 D 6 L
 * 0
 * Salida de ejemplo
 * 10
 * 20
 * 1
 * 17
 */