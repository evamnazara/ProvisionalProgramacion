package ud4.aceptaelreto.matrices;

import java.util.Scanner;

public class CampoDeMinas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            // Paso 1: Leer las dimensiones del tablero
            int ancho = sc.nextInt();
            int alto = sc.nextInt();

            if (ancho == 0 || alto == 0)
                break; // Terminar si el tamaño es 0

            // Paso 2: Leer el tablero
            char[][] tablero = new char[alto][ancho];
            sc.nextLine(); // Consumir la línea sobrante del salto de línea

            for (int i = 0; i < alto; i++) {
                String fila = sc.nextLine();
                for (int j = 0; j < ancho; j++) {
                    tablero[i][j] = fila.charAt(j);
                }
            }

            // Paso 3: Contar las celdas vacías con al menos 6 minas alrededor
            int contador = 0;
            for (int i = 0; i < alto; i++) {
                for (int j = 0; j < ancho; j++) {
                    if (tablero[i][j] == '-') {
                        int minasAlrededor = contarMinasAlrededor(tablero, i, j, alto, ancho);
                        if (minasAlrededor >= 6) {
                            contador++;
                        }
                    }
                }
            }

            // Paso 4: Imprimir el resultado para este caso de prueba
            System.out.println(contador);
        }

        sc.close();
    }

    // Método para contar las minas alrededor de una celda (i, j)
    public static int contarMinasAlrededor(char[][] tablero, int i, int j, int alto, int ancho) {
        int minas = 0;

        // Direcciones relativas a la celda (i, j) para las 8 celdas vecinas
        int[] direccionesX = { -1, -1, -1, 0, 1, 1, 1, 0 };
        int[] direccionesY = { -1, 0, 1, 1, 1, 0, -1, -1 };

        // Comprobar las 8 celdas adyacentes
        for (int k = 0; k < 8; k++) {
            int vecinoX = i + direccionesX[k];
            int vecinoY = j + direccionesY[k];

            // Comprobar si la celda vecina está dentro del tablero
            if (vecinoX >= 0 && vecinoX < alto && vecinoY >= 0 && vecinoY < ancho) {
                if (tablero[vecinoX][vecinoY] == '*') {
                    minas++;
                }
            }
        }

        return minas;
    }
}

/*
 * Campo de minas
 * Tiempo máximo: 1,000-2,000 s Memoria máxima: 8192 KiB
 * Juego de 'Buscaminas' con muchas minas
 * Aunque existieron antecedentes previos, el juego Buscaminas comenzó a ser
 * famoso cuando se incluyó en la versión 3.1 de Windows, en el lejano 1992.
 * Corre el rumor de que fue incluído para que los usuarios se entretuvieran
 * mientras, sin saberlo, cogían práctica utilizando un dispositivo por aquel
 * tiempo apenas conocido: el ratón.
 * 
 * Hoy el juego es archiconocido (y el dispositivo también). El número de
 * variantes e implementaciones es inmenso, y sigue estando incluído en la gran
 * mayoría de los sistemas de escritorio.
 * El juego consiste en un tablero rectangular con celdas, algunas de las cuales
 * ocultan minas. El usuario debe ir destapando las celdas con cuidado para no
 * seleccionar ninguna mina. Como ayuda, cada vez que destapa una celda libre,
 * se le muestra cuántas minas tiene alrededor.
 * 
 * En este problema os daremos la configuración de un tablero de Buscaminas
 * totalmente descubierto, y os pedimos que nos digáis cuántas celdas vacías
 * tienen al menos 6 minas a su alrededor.
 * 
 * Entrada
 * La entrada estará compuesta de múltiples casos de prueba. Cada uno comienza
 * con una línea conteniendo dos números enteros positivos, menores que 1.000,
 * que indican, respectivamente, el ancho y el alto del tablero. A continuación
 * vendrá una línea por cada fila del tablero. Cada celda se representa con un *
 * indicando que en esa celda hay una mina, o con un - indicando que está libre.
 * 
 * La entrada termina con un tablero de ancho o alto 0.
 * 
 * Salida
 * Para cada caso de prueba se debe indicar, en una única línea, el número de
 * celdas vacías con al menos 6 minas alrededor.
 * 
 * Entrada de ejemplo
 * 5 4
 * --**
 * ---*-
 * ---**
 *** --
 * 4 5
 ** -*
 ****
 * --*
 ** -*
 * -***
 * 0 0
 * Salida de ejemplo
 * 0
 * 3
 */