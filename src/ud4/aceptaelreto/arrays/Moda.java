package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class Moda {

    public static void main(String[] args) {
        // Crear un scanner para leer la entrada
        Scanner sc = new Scanner(System.in);

        // Empezamos a procesar cada caso de prueba
        while (true) {
            // Leer el número de elementos en el conjunto
            System.out.println("Introduce el número de elementos del conjunto (0 para terminar):");
            int n = sc.nextInt();

            // Si el número de elementos es 0, terminamos el programa
            if (n == 0) {
                break;
            }

            // Crear un arreglo para contar las frecuencias de los números
            // El tamaño de 100001 es suficiente para cubrir números de 0 a 100000
            int[] frecuencias = new int[100001];

            System.out.println("Introduce los " + n + " números:");

            // Leer los números del conjunto y contar su frecuencia
            for (int i = 0; i < n; i++) {
                int numero = sc.nextInt();
                frecuencias[numero]++; // Incrementamos la frecuencia del número leído
            }

            // Encontrar el número que más veces se repite (la moda)
            int moda = -1; // Inicializamos la moda con un valor que sabemos que no será la moda
            int maxFrecuencia = 0; // Inicializamos la frecuencia máxima en 0

            // Recorrer las frecuencias para encontrar la moda
            for (int i = 0; i < 100001; i++) {
                if (frecuencias[i] > maxFrecuencia) {
                    maxFrecuencia = frecuencias[i]; // Actualizamos la frecuencia máxima
                    moda = i; // Actualizamos la moda con el número actual
                }
            }

            // Imprimir la moda para este caso de prueba
            System.out.println("La moda de este conjunto es: " + moda);
        }

        // Cerrar el scanner
        sc.close();
    }
}

/*
 * Va de modas...
 * Tiempo máximo: 1,000-4,000 s Memoria máxima: 4096 KiB
 * Dado un conjunto, o distribución, de valores se define la moda como el valor
 * (o valores) que más se repite en dicho conjunto.
 * 
 * En este problema te pedimos que calcules la moda de un conjunto de números.
 * 
 * Entrada
 * La entrada consta de una serie de casos de prueba.
 * 
 * Cada caso comienza con un número que representa el número de valores que
 * tiene el conjunto, que nunca será mayor de 25.000. En la siguiente línea se
 * proporcionan, separados por espacio, los valores de todos los elementos del
 * conjunto. Todos ellos serán números enteros.
 * 
 * La entrada terminará con una serie de 0 valores.
 * 
 * Salida
 * Para cada caso de prueba se mostrará la moda de la distribución, es decir el
 * número que más se repite.
 * 
 * Se garantiza que ningún caso de prueba contendrá más de una moda, es decir
 * únicamente habrá un valor que aparezca el mayor número de veces.
 * 
 * Entrada de ejemplo
 * 11
 * 1 2 2 3 3 3 4 4 4 4 5
 * 17
 * 1 8 9 6 3 2 1 5 4 7 9 6 3 2 1 4 7
 * 0
 * Salida de ejemplo
 * 4
 * 1
 */