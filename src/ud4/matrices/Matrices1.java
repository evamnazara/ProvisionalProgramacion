package ud4.matrices;

import java.util.Arrays;

public class Matrices1 {
    public static void main(String[] args) {
        //DECLARACION
        int [][] matriz;
        //y vertical 
        //x horizontal
        //INSTANCIA
        //matriz = new int [5][5]; --> 5 filas + 5 columnas
        matriz = new int [23][8]; //23 alumnos, 8 notas 

        //se inicializa con 2 bucles. 

        //for(int i = 0; i < 23; i++)
        for(int i = 0; i < matriz.length; i++) 
            for (int j = 0; j < matriz[i].length; j++)  
            //primero rellena las filas (0 a 7 veces), despues cambia a siguiente fila (i = 1)
            //[0] sólo si la matriz es rectangular
                matriz[i][j] =(int) (Math.random() * 10) + 1; 
                
        for(int i = 0; i < 23; i++) {
                for (int j = 0; j < 8; j++)
                System.out.print(matriz[i][j] + " ");
            System.out.println(" ");
            }

        //Arrays.toString(matriz); imprime las referencias de memoria
        System.out.println(Arrays.deepToString(matriz));


        int [][] matriz2 = {
            {0, 1, 2, 3, 4},
            {5, 6, 7, 8, 9},
            {3, 6, 9, 8, 2}
            };

        for(int i = 0; i < 23; i++) {
                for (int j = 0; j < 8; j++)
                System.out.print(matriz2[i][j] + " ");
                System.out.println(" ");
            }
        

        int [][] matriz3 = generarMatrizAleatori_0a9(23,8);
        System.out.println(Arrays.deepToString(matriz3));

    }

    static void mostrarMatriz(int [][] tabla) {
        for(int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++)
            System.out.print(tabla[i][j] + " ");
            System.out.println(" ");
        }

    }

    static int[][] generarMatrizAleatori_0a9(int numFilas, int numColumnas) {
        int[][] matriz = new int[numFilas] [numColumnas];

        for(int i = 0; i < matriz.length; i++) 
        for (int j = 0; j < matriz[i].length; j++)  
            matriz[i][j] =(int) (Math.random() * 10) + 1; 
        

        return matriz;
    }
}
