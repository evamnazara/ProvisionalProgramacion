package examenes.tema4_rec;

/*2. diagonalesIguales(3)
Escribe una función que acepte una matriz cuadrada de números enteros y devuelva true si
la suma de los elementos de la diagonal principal es igual a la suma de los elementos de la
diagonal secundaria.
static boolean diagonalesIguales(int[][] t);
Si la matriz es null, está vacía o no es cuadrada la función también devolverá false. */

//la diagonal secundaria es la equivalente a is desde la esquina sup derecha en sentido contrario
public class DiagonalesIguales {

    public static boolean diagonalesIguales(int[][] matriz) {
        if (matriz == null || matriz.length == 0 || matriz[0].length == 0) {
            System.out.println("vacia");
            return false; // vacia
        }
        int filas = matriz.length;
        int columnas = matriz[0].length;

        if (filas != columnas) {
            System.out.println("no cuadrada");
            return false; // noe s cuadrada
        }

        int sumaDiagonalPrincipal = 0;
        int sumaDiagonalSecundaria = 0;
        for (int i = 0; i < filas; i++) {
            sumaDiagonalPrincipal += matriz[i][i];
            sumaDiagonalSecundaria += matriz[i][filas - 1 - i];
        }

        if (sumaDiagonalPrincipal == sumaDiagonalSecundaria) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matriz = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        int[][] matriz2 = {
                { 1, 2 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        int[][] matriz3 = {
                {},
                {},
                {}
        };

        int[][] matriz4 = null;

        System.out.println(diagonalesIguales(matriz)); // true
        System.out.println(diagonalesIguales(matriz2));
        System.out.println(diagonalesIguales(matriz3));
        System.out.println(diagonalesIguales(matriz4));

    }

}
