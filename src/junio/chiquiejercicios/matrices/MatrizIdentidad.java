
package junio.chiquiejercicios.matrices;

public class MatrizIdentidad {

    // es identidad si los elementos de la diagonal principal son 1 y el resto 0
    public static void main(String[] args) {
        int matriz[][] = {
                { 1, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 1 }
        };

        int matriz2[][] = {
                { 1, 0, 0 },
                { 0, 3, 0 },
                { 2, 0, 6 }
        };

        int matriz3[][] = {
                { 2, 0, 0 },
                { 0, 3, 0 },
                { 2, 0, 6 }
        };
        int matriz4[][] = {
                {},
                {},
                {}
        };
        int matriz5[][] = {
                { 2, 0, 0 },
                { 0, 3 },
                { 2, 0, 6 }
        };

        System.out.println(esIdentidad(matriz));
        System.out.println(esIdentidad(matriz2));
        System.out.println(esIdentidad(matriz3));
        System.out.println(esIdentidad(matriz4));
        System.out.println(esIdentidad(matriz5));

    }

    public static boolean esIdentidad(int[][] matriz) {
        if (matriz == null || matriz.length == 0 || matriz[0].length == 0) {
            return false;
        }

        if (matriz.length != matriz[0].length) {
            return false;
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                // mi codgio original dejaba que el ij fuese ==1, entonces solo funcionada si
                // ninguno de los valores era 1 , pero faba por cierto si habia un 1 en la
                // diagonal
                if (i == j && matriz[i][j] != 1) {
                    return false; // diagonal debe ser 1
                }
                if (i != j && matriz[i][j] != 0) {
                    return false; // fuera de diagonal debe ser 0
                }
            }
        }

        return true;

    }

}
