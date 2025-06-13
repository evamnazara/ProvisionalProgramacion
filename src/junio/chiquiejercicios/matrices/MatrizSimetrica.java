package junio.chiquiejercicios.matrices;

import java.util.Arrays;

/*Es una matriz cuadrada que es igual a su transpuesta. 
Los elementos en posiciones simétricas con respecto a 
la diagonal principal son iguales.  */
public class MatrizSimetrica {

    public static void main(String[] args) {
        int[][] matriz1 = {
                { 2, 3 }, { 3, 2 }
        };
        int[][] matriz2 = {
                { 2, 3 }, { 3, 2 }
        };
        int[][] matriz3 = {
                { 4, 3 }, { 6, 2 }
        };

        System.out.println(esSimetrica(matriz1));
        System.out.println(esSimetrica(matriz2));
        System.out.println(esSimetrica(matriz3));

    }

    public static boolean esSimetrica(int[][] matriz) {
        // tiene que ser cuadrada
        // la traspuesta tiene que ser igual
        if (matriz.length != matriz[0].length) {
            return false;
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] != matriz[j][i]) {
                    return false;
                }
            }
        }

        return true;
    }
}
