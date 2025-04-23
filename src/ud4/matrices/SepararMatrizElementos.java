//Elemento en posicion (1,3)

package ud4.matrices;

public class SepararMatrizElementos {
    public static void main(String[] args) {
        // Declarar una matriz 3x3
        int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Separando los elementos de la matriz:");
        for (int i = 0; i < matriz.length; i++) { // Recorrer las filas
            for (int j = 0; j < matriz[i].length; j++) { // Recorrer los elementos de cada fila
                System.out.println("Elemento en posición [" + i + "][" + j + "]: " + matriz[i][j]);
            }
        }
    }
}