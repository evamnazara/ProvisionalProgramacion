package junio.chiquiejercicios.matrices;

import java.util.Arrays;

public class SumaMatrices {
    public static void main(String[] args) {
        int[][] matriz1 = { { 2, 2 }, { 2, 2 } };

        int[][] matriz2 = { { 2, 2 }, { 2, 2 } };

        System.out.println(Arrays.deepToString(sumaMatrices(matriz1, matriz2)));

    }

    // la funcion tiene q deovlver otra matriz
    public static int[][] sumaMatrices(int[][] matriz1, int[][] matriz2) {
        int[][] matrizResultado = new int[matriz1.length][matriz1[0].length];

        if (matriz1.length != matriz2.length || matriz1[0].length != matriz2[0].length) {
            System.out.println("las matrices no tienen las mismas dimensiones");
            return null;
        }

        for (int i = 0; i < matrizResultado.length; i++) {
            for (int j = 0; j < matrizResultado.length; j++) {
                matrizResultado[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }

        return matrizResultado;
    }
}
