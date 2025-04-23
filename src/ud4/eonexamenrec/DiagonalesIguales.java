//Eva María Otero Názara

package ud4.eonexamenrec;

public class DiagonalesIguales {

    static boolean diagonalesIguales(int[][] t) {
        int filas = t.length;
        int columnas = t[0].length;
        //si no es cuadrada o esta vacia devuelve false
        if (filas != columnas || t == null) {
            return false;
        }

        int sumaDiagonalPrincipal = 0;
        for (int i = 0; i < t.length; i++) {
            sumaDiagonalPrincipal += t[i][i];
        }

        int sumaDiagonalSecundaria = 0;
        for (int i = 0; i < t.length; i++) {
            sumaDiagonalSecundaria += t[i][t.length - 1 - i];
        }
        
        if (sumaDiagonalSecundaria == sumaDiagonalPrincipal)
        return true;
        return true;

    }

}

/*Escribe una función que acepte una matriz cuadrada de números enteros y devuelva true si
la suma de los elementos de la diagonal principal es igual a la suma de los elementos de la
diagonal secundaria.
static boolean diagonalesIguales(int[][] t);
Si la matriz es null, está vacía o no es cuadrada la función también devolverá false. */