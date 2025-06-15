package ud4.aceptaelreto.matrices;

import java.util.Scanner;

public class Buscaminas {

    // Dirección de los 8 posibles vecinos (N, NE, E, SE, S, SW, W, NW)
    static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
    static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

    // Función para contar las bombas alrededor de una celda
    public static int contarBombas(char[][] tablero, int f, int c, int F, int C) {
        int contador = 0;
        for (int i = 0; i < 8; i++) {
            int nf = f + dx[i];
            int nc = c + dy[i];
            if (nf >= 0 && nf < F && nc >= 0 && nc < C && tablero[nf][nc] == '*') {
                contador++;
            }
        }
        return contador;
    }

    // Función recursiva para destapar celdas vacías (si tiene 0 bombas alrededor)
    public static void destaparCelda(char[][] tablero, char[][] descubierto, int f, int c, int F, int C) {
        // Si la celda ya está descubierta, no hacer nada
        if (descubierto[f][c] != 'X') {
            return;
        }

        // Contamos las bombas alrededor
        int bombasAlrededor = contarBombas(tablero, f, c, F, C);

        // Si tiene 0 bombas, se deja vacía y destapamos sus vecinos automáticamente
        if (bombasAlrededor == 0) {
            descubierto[f][c] = '-';
            // Destapamos las celdas adyacentes
            for (int i = 0; i < 8; i++) {
                int nf = f + dx[i];
                int nc = c + dy[i];
                if (nf >= 0 && nf < F && nc >= 0 && nc < C) {
                    destaparCelda(tablero, descubierto, nf, nc, F, C);
                }
            }
        } else {
            // Si tiene bombas alrededor, mostramos el número de bombas
            descubierto[f][c] = (char) ('0' + bombasAlrededor);
        }
    }

    // Función para imprimir el tablero
    public static void imprimirTablero(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Leer filas (F) y columnas (C)
            int F = scanner.nextInt();
            int C = scanner.nextInt();

            // Si F y C son 0, terminar el programa
            if (F == 0 && C == 0) {
                break;
            }

            // Leer el tablero (con bombas y celdas vacías)
            char[][] tablero = new char[F][C];
            scanner.nextLine(); // Limpiar el buffer
            for (int i = 0; i < F; i++) {
                String linea = scanner.nextLine();
                for (int j = 0; j < C; j++) {
                    tablero[i][j] = linea.charAt(j);
                }
            }

            // Inicializar el tablero descubierto (con X)
            char[][] descubierto = new char[F][C];
            for (int i = 0; i < F; i++) {
                for (int j = 0; j < C; j++) {
                    descubierto[i][j] = 'X'; // Las celdas no descubiertas
                }
            }

            // Leer el número de celdas a descubrir
            int K = scanner.nextInt();

            // Procesar cada celda a descubrir
            boolean gameOver = false;
            for (int i = 0; i < K; i++) {
                int fila = scanner.nextInt() - 1; // Convertir a índice 0-based
                int col = scanner.nextInt() - 1; // Convertir a índice 0-based

                if (tablero[fila][col] == '*') {
                    // Si destapamos una bomba, el juego termina
                    System.out.println("GAME OVER");
                    gameOver = true;
                    break;
                }

                // Si no hay bomba, destapamos la celda y sus adyacentes si es necesario
                destaparCelda(tablero, descubierto, fila, col, F, C);
            }

            // Si no hubo GAME OVER, mostramos el tablero final
            if (!gameOver) {
                imprimirTablero(descubierto);
            }
        }

        scanner.close();
    }
}

/*
 * Jugando al Buscaminas
 * Hoy vamos a jugar al Buscaminas. Seguro que lo conoces. En un tablero
 * dividido en celdas se esconde cierto número de bombas. El objetivo es
 * encontrarlas todas. Para ello hay que destapar todas las celdas que no
 * esconden bombas. Como ayuda, cuando se descubre una celda sin bombas, aparece
 * en ella el número de bombas en las (como mucho) 8 celdas colindantes. Así, si
 * al descubrir una celda aparece un 3 eso significa que de las 8 celdas que hay
 * alrededor 3 de ellas esconden una bomba y 5 no. Cuando se descubre una celda
 * que no tiene bombas alrededor, en vez de un 0 la celda se deja vacía y se
 * descubren de forma automática las 8 celdas colindantes (ahorrando al jugador
 * tener que descubrirlas por sí mismo sin ningún riesgo). Esto provoca que en
 * ocasiones se descubran muchas celdas de golpe. Si se descubre una celda con
 * una bomba, se pierde la partida.
 * 
 * La figura muestra el estado del juego después de haber descubierto
 * consecutivamente las cuatro esquinas del tablero.
 * 
 * Lo que queremos es conocer el estado del juego después de que el jugador haya
 * descubierto una serie de celdas.
 * 
 * Entrada
 * La entrada constará de una serie de casos de prueba. Cada caso comienza con
 * una línea con los números de filas F y columnas C del tablero (1 ≤ F, C ≤
 * 50). A continuación aparecen F líneas, cada una con C caracteres: un *
 * significa que en la celda correspondiente se esconde una bomba; las casillas
 * vacías se indican con -. Después aparece el número K de celdas a descubrir,
 * seguido de K líneas que indican las coordenadas de cada celda descubierta:
 * una fila entre 1 y F y una columna entre 1 y C. Pueden intentarse descubrir
 * celdas ya descubiertas anteriormente (quizás de forma automática), en cuyo
 * caso el estado del tablero no cambia. Si al descubrir una celda aparece una
 * bomba, esa será la última celda a descubrir que aparezca en la entrada para
 * ese caso.
 * 
 * Salida
 * Para cada caso de prueba, se escribirá el tablero después de haber
 * descubierto todas las celdas indicadas en la entrada (y las que lo hayan
 * hecho de forma automática). Por cada celda descubierta se escribirá un número
 * indicando el número de bombas que hay alrededor, salvo que este sea 0, que se
 * escribirá -. Las celdas sin descubrir se indicarán con X.
 * 
 * Si durante el juego se ha descubierto una bomba, se escribirá GAME OVER en
 * vez del tablero final.
 * 
 * 
 * Entrada de ejemplo
 * 8 8
 * -*---*--
 * --------
 ** ------
 * ---*----
 * ---*---*
 * -*--*---
 * ----*---
 * --------
 * 4
 * 1 1
 * 1 8
 * 8 8
 * 8 1
 * Salida de ejemplo
 * 1XXXXX1-
 * XXXX111-
 * XXXX1---
 * XXXX2-11
 * XXXX311X
 * XXXXX211
 * 1112X2--
 * ---1X1--
 */