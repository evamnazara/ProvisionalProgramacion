package ud4.aceptaelreto.matrices;

import java.util.Arrays;
import java.util.Scanner;

public class HundirLaFlota {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Asegúrate de cerrar este Scanner al final.

        while (true) {
            // PASO 1: Leer el número de barcos
            System.out.print("Ingrese el número de barcos: ");
            int numBarcos = sc.nextInt();
            if (numBarcos == 0)
                break; // Terminar si no hay barcos

            // PASO 2: Leer los tamaños esperados de los barcos
            System.out.println("Ingrese los tamaños de los barcos:");
            int[] tamanosEsperados = new int[numBarcos];
            for (int i = 0; i < numBarcos; i++) {
                tamanosEsperados[i] = sc.nextInt();
            }

            // PASO 3: Leer el tamaño del tablero y la matriz
            System.out.print("Ingrese el tamaño del tablero (número de filas/columnas): ");
            int n = sc.nextInt();
            int[][] tablero = new int[n][n];

            System.out.println("Ingrese el tablero (0 para agua, 1 para parte de barco):");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    tablero[i][j] = sc.nextInt();
                }
            }

            // PASO 4: Encontrar los barcos en la matriz
            int[] barcosEncontrados = new int[numBarcos]; // Almacena los tamaños de los barcos encontrados
            int contadorBarcos = 0;
            boolean[][] visitado = new boolean[n][n]; // Para marcar las celdas visitadas

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // Si encontramos una parte del barco y no ha sido visitada
                    if (tablero[i][j] == 1 && !visitado[i][j]) {
                        int tamano = contarBarco(tablero, visitado, i, j, n);
                        if (tamano == -1 || contadorBarcos >= numBarcos) {
                            System.out.println("NO");
                            sc.close();
                            return;
                        }
                        barcosEncontrados[contadorBarcos++] = tamano;
                    }
                }
            }

            // PASO 5: Comparar barcos encontrados con los tamaños esperados
            Arrays.sort(barcosEncontrados, 0, contadorBarcos);
            Arrays.sort(tamanosEsperados);

            // Verificamos que los tamaños de los barcos coincidan exactamente
            boolean esCorrecto = true;
            for (int i = 0; i < numBarcos; i++) {
                if (barcosEncontrados[i] != tamanosEsperados[i]) {
                    esCorrecto = false;
                    break;
                }
            }

            // Imprimir resultado
            if (esCorrecto) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }

    // Función para contar el tamaño de un barco y verificar si es válido
    static int contarBarco(int[][] tablero, boolean[][] visitado, int fila, int col, int n) {
        int tamaño = 0;
        boolean horizontal = (col + 1 < n && tablero[fila][col + 1] == 1);
        boolean vertical = (fila + 1 < n && tablero[fila + 1][col] == 1);

        if (horizontal && vertical)
            return -1; // No puede ser diagonal

        // Contar en línea horizontal
        if (horizontal) {
            while (col < n && tablero[fila][col] == 1) {
                if (visitado[fila][col])
                    return -1; // Si ya fue visitado, es incorrecto
                visitado[fila][col] = true;
                tamaño++;
                col++;
            }
        }
        // Contar en línea vertical
        else if (vertical) {
            while (fila < n && tablero[fila][col] == 1) {
                if (visitado[fila][col])
                    return -1; // Si ya fue visitado, es incorrecto
                visitado[fila][col] = true;
                tamaño++;
                fila++;
            }
        }
        // Si es una sola celda
        else {
            visitado[fila][col] = true;
            tamaño = 1;
        }
        return tamaño;
    }
}

/*
 * El juego Hundir la flota o Batalla naval es un clásico juego infantil de
 * lápiz y papel, del que se han comercializado multitud de versiones como juego
 * de mesa.
 * 
 * Cada jugador dispone de dos tableros, formados por una cuadrícula de celdas.
 * Cada jugador coloca, secretamente, su flota de barcos en uno de sus tableros,
 * que se mantiene oculto del adversario durante toda la partida. Cada barco de
 * la flota ocupa un número variable de celdas, y deben colocarse en el tablero
 * vertical u horizontalmente. No se permite colocar barcos adyacentes, es
 * decir, dos barcos no pueden tocarse.
 * 
 * En cada ronda, los jugadores se alternan para "disparar" sobre el tablero de
 * barcos del oponente. Si en la posición escogida se encuentra una de las
 * partes de un barco, el jugador tendrá que anunciar que su barco ha sido
 * tocado o incluso hundido si ya han sido golpeadas todas las partes de ese
 * barco. En otro caso, anunciará agua. Cuando un jugador hace un disparo, anota
 * en su segundo tablero el resultado, para recordar las celdas que ya han sido
 * exploradas. Gana el primer jugador que hunde completamente la flota del
 * adversario.
 * 
 * Hay multitud de variedades del juego, algunas más simples que otras. El
 * tamaño del tablero, el número, longitud y nombre de los barcos son los puntos
 * de variación más obvios. Otras alternativas hacen, por ejemplo, uso de
 * salvas, es decir múltiples disparos simultáneos en el mismo turno, cuyo
 * número va disminuyendo al sufrir el hundimiento de buques.
 * 
 * Entrada
 * La entrada estará compuesta de múltiples casos de prueba. Cada caso de prueba
 * contendrá la definición de una variante del juego (tamaño de tablero, y
 * número y longitud de los barcos), y la configuración de un tablero. En
 * concreto, estará compuesto de:
 * 
 * Número de barcos. Una flota tendrá un máximo de 10 barcos.
 * Tamaño de cada barco. Para cada uno se indica el número de celdas que ocupa.
 * Este número será siempre mayor que cero.
 * Tamaño del tablero ("océano"). El tablero siempre será cuadrado, por lo que
 * aquí se proporciona un único valor, indicando el número de filas (y
 * columnas). El tamaño del tablero será como máximo 128×128.
 * Definición del tablero. Una celda con 0 indicará agua, y una celda con 1
 * indicará que hay una parte de un barco. Cada fila del tablero aparece en una
 * línea independiente y los números están separados por espacios.
 * La entrada finaliza con un caso de prueba en el que el número de barcos es
 * cero.
 * 
 * Salida
 * Para cada caso de prueba, el programa escribirá SI si el tablero es correcto
 * y NO en otro caso. Un tablero será correcto si contiene todos los barcos de
 * la variante del juego descrita en el caso de prueba (y ninguno más), con los
 * tamaños indicados. Los barcos pueden colocarse en vertical o en horizontal, y
 * no pueden tocarse (ni siquiera en diagonal).
 * 
 * Entrada de ejemplo
 * 2
 * 2 3
 * 6
 * 0 1 1 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 1 0 0
 * 0 0 0 1 0 0
 * 0 0 0 1 0 0
 * 0 0 0 0 0 0
 * 2
 * 2 3
 * 5
 * 0 1 1 1 0
 * 0 0 0 0 1
 * 0 0 0 0 1
 * 0 0 0 0 0
 * 0 0 0 0 0
 * 0
 * Salida de ejemplo
 * 
 * SI
 * NO
 */