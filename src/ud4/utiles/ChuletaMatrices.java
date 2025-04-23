package ud4.utiles;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ChuletaMatrices {
    private int[][] matriz;
    private int filas;
    private int columnas;
    private Random rand = new Random();
    private Scanner scanner = new Scanner(System.in);

    // Rellena la matriz con valores aleatorios dentro de un rango dado
    public void rellenarAleatoriamente(int min, int max) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = rand.nextInt(max - min + 1) + min;
            }
        }
    }

    // Permite al usuario ingresar valores manualmente en la matriz
    public void rellenarPorTeclado() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Ingrese valor para la posición [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }
    }

    // Imprime la matriz en formato legible
    public void imprimirMatriz() {
        for (int[] fila : matriz) {
            System.out.println(Arrays.toString(fila));
        }
    }

    // Recorre la matriz por filas
    public void recorrerPorFilas() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Recorre la matriz por columnas
    public void recorrerPorColumnas() {
        for (int j = 0; j < columnas; j++) {
            for (int i = 0; i < filas; i++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Ordena cada fila de la matriz en orden ascendente
    public void ordenarFilas() {
        for (int[] fila : matriz) {
            Arrays.sort(fila);
        }
    }

    // Suma los valores de una fila específica
    public int sumaFila(int fila) {
        int suma = 0;
        for (int j = 0; j < columnas; j++) {
            suma += matriz[fila][j];
        }
        return suma;
    }

    // Suma los valores de una columna específica
    public int sumaColumna(int columna) {
        int suma = 0;
        for (int i = 0; i < filas; i++) {
            suma += matriz[i][columna];
        }
        return suma;
    }

    // Inserta un valor en una posición específica de la matriz
    public void insertarValor(int fila, int columna, int valor) {
        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            matriz[fila][columna] = valor;
        } else {
            System.out.println("Posición fuera de rango.");
        }
    }

    // Encuentra el valor máximo en la matriz
    public int encontrarMaximo() {
        int max = matriz[0][0];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] > max) {
                    max = matriz[i][j];
                }
            }
        }
        return max;
    }

    // Encuentra el valor mínimo en la matriz
    public int encontrarMinimo() {
        int min = matriz[0][0];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] < min) {
                    min = matriz[i][j];
                }
            }
        }
        return min;
    }

    // Calcula el promedio de todos los valores de la matriz
    public double promedioMatriz() {
        int suma = 0;
        int cantidadElementos = filas * columnas;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                suma += matriz[i][j];
            }
        }
        return (double) suma / cantidadElementos;
    }
}
