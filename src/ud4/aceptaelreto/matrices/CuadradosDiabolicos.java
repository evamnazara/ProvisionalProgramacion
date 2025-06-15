package ud4.aceptaelreto.matrices;

import java.util.Scanner;

public class CuadradosDiabolicos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            // Paso 1: Leer el tamaño de la matriz
            int n = sc.nextInt();
            if (n == 0)
                break; // Terminar si el tamaño es 0

            // Paso 2: Crear la matriz y leer sus valores
            int[][] matriz = new int[n][n];
            int[] valores = new int[n * n];
            for (int i = 0; i < n * n; i++) {
                valores[i] = sc.nextInt();
            }

            // Llenar la matriz
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matriz[i][j] = valores[i * n + j];
                }
            }

            // Paso 3: Verificar si es cuadrado mágico
            int constanteMagica = calcularConstanteMagica(matriz, n);

            if (constanteMagica == -1) {
                System.out.println("NO");
                continue;
            }

            // Verificar si cumple con las condiciones de esotérico
            if (esEsoterico(matriz, n, constanteMagica)) {
                System.out.println("ESOTERICO");
            } else if (esDiabolico(matriz, n, constanteMagica)) {
                System.out.println("DIABOLICO");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }

    // Método para calcular la constante mágica y verificar la validez del cuadrado
    // mágico
    public static int calcularConstanteMagica(int[][] matriz, int n) {
        int sumaFila = 0;
        // Sumar la primera fila para establecer la constante mágica
        for (int j = 0; j < n; j++) {
            sumaFila += matriz[0][j];
        }
        int constanteMagica = sumaFila;

        // Verificar si la suma de todas las filas es igual a la constante mágica
        for (int i = 1; i < n; i++) {
            sumaFila = 0;
            for (int j = 0; j < n; j++) {
                sumaFila += matriz[i][j];
            }
            if (sumaFila != constanteMagica) {
                return -1; // No es cuadrado mágico
            }
        }

        // Verificar las columnas
        for (int j = 0; j < n; j++) {
            int sumaColumna = 0;
            for (int i = 0; i < n; i++) {
                sumaColumna += matriz[i][j];
            }
            if (sumaColumna != constanteMagica) {
                return -1; // No es cuadrado mágico
            }
        }

        // Verificar la diagonal principal
        int sumaDiagonalPrincipal = 0;
        for (int i = 0; i < n; i++) {
            sumaDiagonalPrincipal += matriz[i][i];
        }
        if (sumaDiagonalPrincipal != constanteMagica) {
            return -1; // No es cuadrado mágico
        }

        // Verificar la diagonal secundaria
        int sumaDiagonalSecundaria = 0;
        for (int i = 0; i < n; i++) {
            sumaDiagonalSecundaria += matriz[i][n - 1 - i];
        }
        if (sumaDiagonalSecundaria != constanteMagica) {
            return -1; // No es cuadrado mágico
        }

        return constanteMagica;
    }

    // Verificar si es esotérico
    public static boolean esEsoterico(int[][] matriz, int n, int constanteMagica) {
        // Comprobar que contiene todos los números del 1 al n²
        boolean[] numerosPresentes = new boolean[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matriz[i][j] < 1 || matriz[i][j] > n * n || numerosPresentes[matriz[i][j] - 1]) {
                    return false; // No contiene todos los números del 1 a n²
                }
                numerosPresentes[matriz[i][j] - 1] = true;
            }
        }

        // Calcular CM2
        int constanteMagica2 = 4 * constanteMagica;

        // Sumar las esquinas
        int sumaEsquinas = matriz[0][0] + matriz[0][n - 1] + matriz[n - 1][0] + matriz[n - 1][n - 1];
        if (sumaEsquinas != constanteMagica2) {
            return false;
        }

        // Si n es impar, verificar la casilla central
        if (n % 2 == 1) {
            int centro = matriz[n / 2][n / 2];
            if (centro * 4 != constanteMagica2) {
                return false;
            }

            // Verificar las casillas centrales de los laterales
            int sumaCentroLados = matriz[n / 2][n / 2 - 1] + matriz[n / 2][n / 2 + 1]
                    + matriz[n / 2 - 1][n / 2] + matriz[n / 2 + 1][n / 2];
            if (sumaCentroLados != constanteMagica2) {
                return false;
            }
        }

        // Si n es par, comprobar las condiciones para n par (casillas centrales de los
        // lados)
        if (n % 2 == 0) {
            int sumaCentroLados = 0;
            for (int i = 0; i < n / 2; i++) {
                sumaCentroLados += matriz[i][n / 2 - 1] + matriz[i][n / 2];
            }
            if (sumaCentroLados != constanteMagica2) {
                return false;
            }
        }

        return true;
    }

    // Verificar si es diabólico
    public static boolean esDiabolico(int[][] matriz, int n, int constanteMagica) {
        // Solo se comprueba si la suma de filas, columnas y diagonales es la constante
        // mágica
        return true;
    }
}

/*
 * Cuadrados diabólicos y esotéricos
 * Se considera un cuadrado mágico diabolico a la disposición de una serie de
 * números enteros en un cuadrado de forma tal que la suma de los números por
 * columna, fila y diagonales principales sea la misma. A esta suma se le llama
 * constante mágica (CM). Para nuestro desarrollo consideraremos el cuadrado
 * como una matriz con igual número de filas que de columnas.
 * 
 * Si suponemos n la cantidad de filas o columnas del cuadrado, un cuadrado
 * mágico diabólico es esotérico cuando, además de ser diabólico, cumple las
 * siguientes condiciones:
 * 
 * Tiene las mismas cifras que el número de casillas. Es decir, siguen la serie
 * de números naturales de 1 a n².
 * La suma de sus esquinas debe ser la constante mágica 2 (CM2) que cumple que:
 * CM2=4⋅CMn
 * Si n es impar:
 * La suma de las cifras de las cuatro casillas de la mitad de los laterales
 * suman la constante mágica 2.
 * Si se multiplica el valor de la casilla central por 4, se obtiene la
 * constante mágica 2.
 * 22 47 16 41 10 35 4
 * 5 23 48 17 42 11 29
 * 30 6 24 49 18 36 12
 * 13 31 7 25 43 19 37
 * 38 14 32 1 26 44 20
 * 21 39 8 33 2 27 45
 * 46 15 40 9 34 3 28
 * n = 7
 * Constante mágica = 175
 * Constante mágica 2 = 100
 * Esquinas 22 + 4 + 46 + 28 = 100 (CM2)
 * Centro 4 · 25 = 100 (CM2)
 * Centro lados 41 + 13 + 37 + 9 = 100 (CM2)
 * Si n es par:
 * La suma de las dos casillas centrales de cada uno de los cuatro laterales
 * suman el doble de la constante mágica 2 (2 · CM2)
 * La suma de las cuatro casillas centrales da como resultado la constante
 * mágica 2.
 * 1 63 62 4 5 59 58 8
 * 56 10 11 53 52 14 15 49
 * 48 18 19 45 44 22 23 41
 * 25 39 38 28 29 35 34 32
 * 33 31 30 36 37 27 26 40
 * 24 42 43 21 20 46 47 17
 * 16 50 51 13 12 54 55 9
 * 57 7 6 60 61 3 2 64
 * n = 8
 * Constante mágica = 260
 * Constante mágica 2 = 130
 * Esquinas 1 + 8 + 57 + 64 = 130 (CM2)
 * Centro 28 + 29 + 36 + 37 = 130 (CM2)
 * Centro lados 4 + 5 + 25+ 33 + 60 + 61 + 32 + 40
 * = 260 (2 · CM2)
 * Entrada
 * El programa leerá de la entrada estándar un cuadrado mágico tras otro. Cada
 * cuadrado mágico consistirá en dos líneas. La primera línea contendrá el valor
 * de n (2 ≤ n ≤ 1024). La segunda línea será los valores de las n² celdas, uno
 * detrás de otro.
 * 
 * La entrada termina cuando al leer el tamaño del siguiente cuadrado mágico se
 * recibe un 0.
 * 
 * Salida
 * Para un cuadrado esotérico, el programa escribirá ESOTERICO, para un cuadrado
 * mágico diabólico (no esotérico) escribirá DIABOLICO. Para cualquier otro
 * cuadrado, mostrará NO.
 * 
 * Entrada de ejemplo
 * 3
 * 4 9 2 3 5 7 8 1 6
 * 2
 * 1 2 3 4
 * 4
 * 16 3 2 13 5 10 11 8 9 6 7 12 4 15 14 1
 * 3
 * 28 21 26 23 25 27 24 29 22
 * 3
 * 2 8 1 6 3 5 7 4 9
 * 0
 * Salida de ejemplo
 * 
 * ESOTERICO
 * NO
 * ESOTERICO
 * DIABOLICO
 * NO
 */