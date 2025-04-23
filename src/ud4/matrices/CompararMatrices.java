package ud4.matrices;

import java.util.*;

public class CompararMatrices {
    public static void main(String[] args) {
        int [][] matriz = {
            {0, 1, 2, 3, 4},
            {5, 6, 7, 8, 9},
            {3, 6, 9, 8, 2}
            };

        int [][] matriz2 = {
            {0, 1, 2, 3, 4},
            {5, 6, 7, 8, 9},
            {3, 6, 9, 8, 2}
            };

            System.out.println("matriz == matriz2: " + (matriz == matriz2));
            System.out.println("Arrays.equals(matriz,matriz2): " + Arrays.equals(matriz,matriz2));
            System.out.println("Arrays.deepEquals(matriz, matriz2): " + Arrays.deepEquals(matriz, matriz2));
    }
}
