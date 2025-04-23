package ud4.matrices;

public class SepararMatrizArrays {
    public static void main(String[] args) {
        // Declaramos una matriz 3x3
        int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Crear arrays separados para almacenar las filas
        int[] fila0 = matriz[0]; // Primera fila
        int[] fila1 = matriz[1]; // Segunda fila
        int[] fila2 = matriz[2]; // Tercera fila

        // Mostrar cada array
        System.out.print("Fila 0: ");
        imprimirArray(fila0);

        System.out.print("Fila 1: ");
        imprimirArray(fila1);

        System.out.print("Fila 2: ");
        imprimirArray(fila2);
    }

    public static void imprimirArray(int[] array) {
        for (int num : array) { // Recorre los elementos del array
            System.out.print(num + " ");
        }
        System.out.println(); // Salto de línea
    }
}
