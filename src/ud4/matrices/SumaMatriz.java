package ud4.matrices;
import java.util.Scanner;

public class SumaMatriz {
    public static void main(String[] args) {
        // Crear una matriz de 3 filas y 3 columnas
        int[][] matriz = new int[3][3];
        int suma = 0; 

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce los valores para una matriz de 3x3:");

        // Leer los valores de la matriz del usuario
        for (int i = 0; i < matriz.length; i++) { // Recorrer las filas
            for (int j = 0; j <  matriz.length; j++) { // Recorrer las columnas
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextInt(); // Leer cada elemento
                suma += matriz[i][j]; // Sumar el elemento a la variable 'suma'
            }
        }

        System.out.println("La suma de todos los elementos de la matriz es: " + suma);

        sc.close();
    }
}

