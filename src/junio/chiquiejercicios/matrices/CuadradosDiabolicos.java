package junio.chiquiejercicios.matrices;

/*Se considera un cuadrado mágico diabolico a la disposición de una serie de números enteros en un cuadrado de forma tal que la suma de los números por columna, fila y diagonales principales sea la misma. A esta suma se le llama constante mágica (CM). Para nuestro desarrollo consideraremos el cuadrado como una matriz con igual número de filas que de columnas.

Si suponemos n la cantidad de filas o columnas del cuadrado, un cuadrado mágico diabólico es esotérico cuando, además de ser diabólico, cumple las siguientes condiciones:

Tiene las mismas cifras que el número de casillas. Es decir, siguen la serie de números naturales de 1 a n².
La suma de sus esquinas debe ser la constante mágica 2 (CM2) que cumple que: 
            CM2 = 4 * CM / N 

*/
public class CuadradosDiabolicos {
    public static void main(String[] args) {
        int[][] cuadrado1 = {
                { 16, 3, 2, 13 },
                { 5, 10, 11, 8 },
                { 9, 6, 7, 12 },
                { 4, 15, 14, 1 }
        }; // Es esotérico

        System.out.println(cuadradoDiabolicoEsoterico(cuadrado1)); // Debería decir "ESOTERICO"
    }

    public static String cuadradoDiabolicoEsoterico(int[][] cuadrado) {
        int n = cuadrado.length;

        // Comprobar si es cuadrado
        for (int i = 0; i < n; i++) {
            if (cuadrado[i].length != n) {
                return "NO";
            }
        }

        int constanteMagica = 0;

        // 1. Comprobar si todas las filas, columnas y diagonales suman lo mismo
        // Calcular suma de la primera fila como CM
        for (int j = 0; j < n; j++) {
            constanteMagica += cuadrado[0][j];
        }

        // Comprobar filas
        for (int i = 1; i < n; i++) {
            int sumaFila = 0;
            for (int j = 0; j < n; j++) {
                sumaFila += cuadrado[i][j];
            }
            if (sumaFila != constanteMagica) {
                return "DIABOLICO";
            }
        }

        // Comprobar columnas
        for (int j = 0; j < n; j++) {
            int sumaCol = 0;
            for (int i = 0; i < n; i++) {
                sumaCol += cuadrado[i][j];
            }
            if (sumaCol != constanteMagica) {
                return "DIABOLICO";
            }
        }

        // Comprobar diagonales
        int diagPrincipal = 0;
        int diagSecundaria = 0;
        for (int i = 0; i < n; i++) {
            diagPrincipal += cuadrado[i][i];
            diagSecundaria += cuadrado[i][n - 1 - i];
        }

        if (diagPrincipal != constanteMagica || diagSecundaria != constanteMagica) {
            return "DIABOLICO";
        }

        // 2. Comprobar si tiene los números del 1 al n^2 sin repetir
        boolean[] vistos = new boolean[n * n + 1]; // posiciones 1 hasta n^2
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = cuadrado[i][j];
                if (val < 1 || val > n * n || vistos[val]) {
                    return "DIABOLICO";
                }
                vistos[val] = true;
            }
        }

        // 3. Comprobar si las 4 esquinas suman CM2 = 4*CM / n
        int CM2 = 4 * constanteMagica / n;

        int sumaEsquinas = cuadrado[0][0] + cuadrado[0][n - 1] + cuadrado[n - 1][0] + cuadrado[n - 1][n - 1];
        if (sumaEsquinas != CM2) {
            return "DIABOLICO";
        }

        return "ESOTERICO";
    }
}
