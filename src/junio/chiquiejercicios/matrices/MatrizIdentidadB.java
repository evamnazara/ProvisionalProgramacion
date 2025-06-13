package junio.chiquiejercicios.matrices;

import java.util.Arrays;
import java.util.Scanner;

public class MatrizIdentidadB {
    // programa que genera una matriz identidad tamaño n x n

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("numero de filas y columnas de la matriz: ");
        int tamanho = sc.nextInt();
        sc.close();

        int matriz[][] = new int[tamanho][tamanho];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (i == j) {
                    matriz[i][j] = 1;
                } else {
                    matriz[i][j] = 0;
                }
            }
        }

        // System.out.println(Arrays.deepToString(matriz));
        for (int[] fila : matriz) {
            System.out.println(Arrays.toString(fila));
        }

    }
}
