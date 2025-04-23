package ud4.utiles;
import java.util.Random;
import java.util.Scanner;

public class Utilidades {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    // Generar un array de longitud dada con valores aleatorios entre min y max
    public static int[] generarArray(int longitud, int min, int max) {
        int[] array = new int[longitud];
        for (int i = 0; i < longitud; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
        return array;
    }

    // Generar una matriz de tamaño dado con valores aleatorios entre min y max
    public static int[][] generarMatriz(int filas, int columnas, int min, int max) {
        int[][] matriz = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = random.nextInt(max - min + 1) + min;
            }
        }
        return matriz;
    }

    // Rellenar un array con valores introducidos por el usuario hasta que escriba
    // -1
    public static int[] rellenarArray() {
        System.out.println("Introduce números (-1 para terminar):");
        int[] temp = new int[100]; // Capacidad máxima temporal
        int count = 0;

        while (true) {
            int num = scanner.nextInt();
            if (num == -1)
                break;
            temp[count++] = num;
        }

        int[] resultado = new int[count];
        System.arraycopy(temp, 0, resultado, 0, count);
        return resultado;
    }

        // Suma los elementos de un array
        public static int sumar(int[] t) {
            int suma = 0;
            for (int i : t) {
                suma += i;
            }
            return suma;
        }
    
        // Encuentra el máximo valor en un array
        public static int maximo(int t[]) {
            if (t == null || t.length == 0)
                return 0;
            int maximo = t[0];
            for (int i = 1; i < t.length; i++)
                if (t[i] > maximo)
                    maximo = t[i];
            return maximo;
        }

    // Rellenar una matriz con valores introducidos por el usuario
    public static int[][] rellenarMatriz(int filas, int columnas) {
        int[][] matriz = new int[filas][columnas];
        System.out.println("Introduce los valores de la matriz:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }
        return matriz;
    }

    // Imprimir un array
    public static void imprimirArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Imprimir una matriz
    public static void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int num : fila) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    // Intercambiar dos posiciones en un array
    public static void intercambiarArray(int[] array, int i, int j) {
        if (i >= 0 && i < array.length && j >= 0 && j < array.length) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    // Intercambiar dos posiciones en una matriz
    public static void intercambiarMatriz(int[][] matriz, int fila1, int col1, int fila2, int col2) {
        if (fila1 >= 0 && fila1 < matriz.length && fila2 >= 0 && fila2 < matriz.length &&
                col1 >= 0 && col1 < matriz[0].length && col2 >= 0 && col2 < matriz[0].length) {
            int temp = matriz[fila1][col1];
            matriz[fila1][col1] = matriz[fila2][col2];
            matriz[fila2][col2] = temp;
        }
    }

        // Encuentra la columna con la mayor suma en una matriz
        public static int[] columnaMayorSuma(int[][] t) {
            int mayor = 0;
            int aux = 0;
            int valori = 0;
            for (int i = 0; i < t.length; i++) {
                for (int j = 0; j < t[i].length; j++) {
                    aux += t[i][j];
                }
                if (aux > mayor) {
                    mayor = aux;
                    valori = i;
                }
                aux = 0;
            }
            return t[valori];
        }

    // Recorrer una matriz por filas
    public static void recorrerPorFilas(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Recorrer una matriz por columnas
    public static void recorrerPorColumnas(int[][] matriz) {
        for (int j = 0; j < matriz[0].length; j++) {
            for (int i = 0; i < matriz.length; i++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Recorrer un array al revés
    public static void recorrerArrayReves(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // Contar ocurrencias de un carácter en una cadena
    public static int contarCaracter(String cadena, char caracter) {
        int count = 0;
        for (char c : cadena.toCharArray()) {
            if (c == caracter)
                count++;
        }
        return count;
    }

    // Invertir una cadena
    public static String invertirCadena(String cadena) {
        return new StringBuilder(cadena).reverse().toString();
    }

    // Comparar dos cadenas
    public static boolean compararCadenas(String cadena1, String cadena2) {
        return cadena1.equals(cadena2);
    }

    // Comparar dos arrays
    public static boolean compararArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length)
            return false;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i])
                return false;
        }
        return true;
    }

    // Comparar dos matrices
    public static boolean compararMatrices(int[][] matriz1, int[][] matriz2) {
        if (matriz1.length != matriz2.length || matriz1[0].length != matriz2[0].length)
            return false;
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[i].length; j++) {
                if (matriz1[i][j] != matriz2[i][j])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        int[] array = generarArray(10, 1, 100);
        imprimirArray(array);
        intercambiarArray(array, 0, array.length - 1);
        imprimirArray(array);

        int[][] matriz = generarMatriz(3, 4, 1, 50);
        imprimirMatriz(matriz);
        intercambiarMatriz(matriz, 0, 0, 2, 3);
        imprimirMatriz(matriz);

        System.out.println("Ocurrencias de 'a' en 'banana': " + contarCaracter("banana", 'a'));
        System.out.println("Invertir 'hola': " + invertirCadena("hola"));
        System.out.println("Comparar 'hola' y 'hola': " + compararCadenas("hola", "hola"));
    }
}
