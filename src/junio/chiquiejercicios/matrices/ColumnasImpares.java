package junio.chiquiejercicios.matrices;

import java.util.Arrays;
import java.util.Scanner;

//llenar una matriz con numeros de 2 en 2, pero que en las columnas impares solo haya 0 

public class ColumnasImpares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("introduce filas:");
        int filas = sc.nextInt();
        System.out.println("introduce columnas:");
        int columnas = sc.nextInt();
        sc.close();

        int numeros[][] = new int[filas][columnas];

        int valor = 0;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (j % 2 != 0) {
                    numeros[i][j] = 0;
                } else {
                    numeros[i][j] = valor;
                    valor += 2;
                }

            }

        }

        System.out.println(Arrays.deepToString(numeros));
        for (int[] fila : numeros) {
            System.out.println(Arrays.toString(fila));
        }

    }
}
