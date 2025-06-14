package junio.chiquiejercicios.matrices;

import java.util.Arrays;

public class BuscaFilaMayorSuma {
    /*
     * BuscarFilaMayorSuma. Escribe un método en Java que reciba una matriz de
     * enteros y determine y devuelva en un array la fila que tiene la mayor suma de
     * sus elementos.
     * 
     * Casos especiales:
     * matriz de entrada == null
     * devuelve null
     * matriz de entrada vacía
     * devuelve array vacío []
     * matriz de una única fila
     * devuelve esa fila
     * empate de dos o más filas en la suma de sus elementos
     * devuelve la primera de las filas empatadas
     */
    public static void main(String[] args) {
        int[][] matriz = {
                { 1, 2, 3 },
                { 4, 7, 4 },
                { 8, 8, 1 }
        };

        int[][] matrizvacia = { {} };
        int[][] matriznula = null;
        int[][] matriz1 = { { 1, 1, 1 }, };
        System.out.println(Arrays.toString(buscaFilaMayorSuma(matriz)));
        System.out.println(Arrays.toString(buscaFilaMayorSuma(matriz1)));
        System.out.println(Arrays.toString(buscaFilaMayorSuma(matrizvacia)));
        System.out.println(Arrays.toString(buscaFilaMayorSuma(matriznula)));
    }

    public static int[] buscaFilaMayorSuma(int[][] matriz) {
        // matriz vacía devuelve null
        if (matriz == null) {
            return null;
        }

        // si las filas estan vacias devuelve array vacio
        if (matriz.length == 0) {
            int[] arrayVacio = new int[0];
            // return new int[0];
            return arrayVacio;
        }

        // una fila
        if (matriz.length == 1) {
            return matriz[0];
        }

        // inicializar --> por defecto la primera fila sería la mayor
        int[] filaMayor = matriz[0];
        int sumaMayor = sumaFila(matriz[0]);
        int nFilaMayor = 0; // para imprimir el numero de fila !!

        // recorrer
        for (int i = 0; i < matriz.length; i++) {
            int sumaActual = sumaFila(matriz[i]);

            if (sumaActual > sumaMayor) {
                sumaMayor = sumaActual;
                filaMayor = matriz[i];
                nFilaMayor = i;
            }
        }

        System.out.println("Suma mayor: " + sumaMayor + ", correspondiente a la fila " + nFilaMayor);

        return filaMayor;

    }

    public static int sumaFila(int[] tabla) {
        int suma = 0;

        for (int numero : tabla) {
            suma += numero;
        }

        return suma;
    }
}
