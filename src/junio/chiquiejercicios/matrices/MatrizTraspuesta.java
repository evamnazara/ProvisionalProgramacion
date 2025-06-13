package junio.chiquiejercicios.matrices;

import java.util.Arrays;

// en una matriz traspuesta se intercambian las fialas por las columnas 
/*
 * La traspuesta de 
 * 1 2 3 4
 * 5 6 7 8
 * 
 * es 
 * 
 * 1 5
 * 2 6
 * 3 7
 * 4 8
 */
public class MatrizTraspuesta {
    public static void main(String[] args) {
        int[][] m1 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };

        matrizTraspuesta(m1);
    }

    public static int[][] matrizTraspuesta(int[][] t) {
        // verificar si esta vacia o no
        if (t == null || t.length == 0 || t[0].length == 0) {
            return null;
        }

        // ERROR EN ESTA FUNCION las traspuestas no tienen por que ser cuadradas!!
        // verificar si es cuadrada
        /*
         * if (t.length != t[0].length) {
         * return null;
         * }
         */

        // int[][] traspuesta = new int[t[0].length][t.length];
        int filas = t.length;
        int columnas = t[0].length;
        int[][] traspuesta = new int[columnas][filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                traspuesta[j][i] = t[i][j];
                // se cambian los indices, de las filas de una a la columna de la otra
            }
        }

        for (int[] fila : t) {
            System.out.println(Arrays.toString(fila));
        }

        for (int[] fila : traspuesta) {
            System.out.println(Arrays.toString(fila));
        }
        return traspuesta;
    }
}
