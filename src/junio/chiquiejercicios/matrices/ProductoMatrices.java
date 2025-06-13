package junio.chiquiejercicios.matrices;

import java.util.Arrays;

public class ProductoMatrices {
    public static void main(String[] args) {
        int[][] matriz1 = {
                { 1, 2 }, { 3, 4 }
        };

        int[][] matriz2 = {
                { 2, 1 }, { 3, 3 }
        };

        System.out.println(Arrays.deepToString(multiplicar(matriz1, matriz2)));
    }

    public static int[][] multiplicar(int t1[][], int t2[][]) {
        int[][] matrizResultado = new int[t1.length][t1[0].length];

        for (int i = 0; i < matrizResultado.length; i++) {
            for (int j = 0; j < matrizResultado.length; j++) {
                matrizResultado[i][j] = t1[i][j] * t2[i][j];
            }
        }

        return matrizResultado;
    }

}
