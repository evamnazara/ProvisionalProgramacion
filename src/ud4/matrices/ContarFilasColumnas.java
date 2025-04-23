package ud4.matrices;

public class ContarFilasColumnas {
    public static void main(String[] args) {
        // Definición de la matriz
        int[][] matriz = {
            {1, 2, 3, 4},   // Fila 0
            {5, 6, 7, 8},   // Fila 1
            {9, 10, 11, 12} // Fila 2
        };

        // Contar las filas de la matriz
        int numFilas = matriz.length;
        // Contar las columnas (se asume que la matriz no está vacía)
        int numColumnas = (numFilas > 0) ? matriz[0].length : 0;

        // Mostrar resultados
        System.out.println("La matriz tiene " + numFilas + " filas y " + numColumnas + " columnas.");
    }
}
