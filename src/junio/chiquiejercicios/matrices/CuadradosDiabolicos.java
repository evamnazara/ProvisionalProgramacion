package junio.chiquiejercicios.matrices;

/*Se considera un cuadrado mágico diabolico a la disposición de una serie de números enteros en un cuadrado de forma tal que la suma de los números por columna, fila y diagonales principales sea la misma. A esta suma se le llama constante mágica (CM). Para nuestro desarrollo consideraremos el cuadrado como una matriz con igual número de filas que de columnas.

Si suponemos n la cantidad de filas o columnas del cuadrado, un cuadrado mágico diabólico es esotérico cuando, además de ser diabólico, cumple las siguientes condiciones:

Tiene las mismas cifras que el número de casillas. Es decir, siguen la serie de números naturales de 1 a n².
La suma de sus esquinas debe ser la constante mágica 2 (CM2) que cumple que: 
            CM2 = 4 * CM / N 

*/
public class CuadradosDiabolicos {
    public static void main(String[] args) {

    }

    public static String cuadradoDiabolicoEsoterico(int[][] cuadrado) {
        int filas = cuadrado.length;
        int columnas = cuadrado[0].length;

        String resultado = "";

        // si esta vacio o si no es cuadrado
        if (cuadrado == null || filas == 0 || columnas == 0 || filas != columnas) {
            return resultado = "NO";
        }

        int sumaDiagonalPrincipal;
        int sumaColumna;
        int sumaFila;

        /*
         * Si n es impar:
         * La suma de las cifras de las cuatro casillas de la mitad de los laterales
         * suman la constante mágica 2.
         * Si se multiplica el valor de la casilla central por 4, se obtiene la
         * constante mágica 2.
         */

        return null;

    }
}
