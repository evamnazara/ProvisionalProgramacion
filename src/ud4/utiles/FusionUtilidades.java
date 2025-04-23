package ud4.utiles;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class FusionUtilidades {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    // ================= Utilidades.java =================
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

    // ================= ArraysUtil.java =================
    // Genera y devuelve un array de n números aleatorios entre -9 y 9
    static int[] arrayAleatorio(int n) {
        int[] t = new int[n];
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            t[i] = rnd.nextInt(19) - 9;
        }
        return t;
    }

    // Genera y devuelve un array de números aleatorios entre un rango específico
    public static int[] arrayAleatorio(int n, int rndInicio, int rndFin) {
        int[] t = new int[n];
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            t[i] = rnd.nextInt(rndFin - rndInicio + 1) + rndInicio;
        }
        return t;
    }

    // Rellena un array con valores introducidos por el usuario
    public static void leerNumeros(int[] t) {
        for (int i = 0; i < t.length; i++) {
            t[i] = scanner.nextInt();
        }
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

    // Muestra una matriz en la consola
    public static void mostrarMatriz(int[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Genera una matriz con valores aleatorios dentro de un rango
    public static int[][] matrizAleatoria(int x, int y, int min, int max) {
        int[][] t = new int[x][y];
        Random rnd = new Random();
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                t[i][j] = rnd.nextInt(min, max + 1);
            }
        }
        return t;
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

    // Método principal con ejemplos de uso
    public static void main(String[] args) {
        int[] array = generarArray(10, 1, 100);
        System.out.println("Array generado:");
        System.out.println(Arrays.toString(array));

        int[][] matriz = matrizAleatoria(3, 4, 1, 50);
        System.out.println("Matriz generada:");
        mostrarMatriz(matriz);
    }
}
