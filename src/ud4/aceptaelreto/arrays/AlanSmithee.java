package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class AlanSmithee {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el número de casos de prueba:");
        int n = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer después de leer el número

        for (int i = 0; i < n; i++) {
            System.out.println("Introduce las dos palabras o frases a analizar (separadas por salto de línea):");

            // Leemos las dos líneas (dos palabras o frases)
            String linea1 = sc.nextLine().toLowerCase().replace(" ", "");
            String linea2 = sc.nextLine().toLowerCase().replace(" ", "");

            // Verificamos si son anagramas
            if (sonAnagramas(linea1, linea2)) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }

    // Función para verificar si dos palabras/frases son anagramas
    public static boolean sonAnagramas(String str1, String str2) {
        // Si tienen diferente longitud, no pueden ser anagramas
        if (str1.length() != str2.length()) {
            return false;
        }

        // Convertimos las cadenas a arreglos de caracteres
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        // Ordenamos ambos arreglos de caracteres
        ordenarArreglo(arr1);
        ordenarArreglo(arr2);

        // Comparamos los arreglos ordenados
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    // Función para ordenar un arreglo de caracteres (ordenamiento simple por
    // burbuja)
    public static void ordenarArreglo(char[] arr) {
        boolean intercambio;
        do {
            intercambio = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    // Intercambiamos los caracteres
                    char temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    intercambio = true;
                }
            }
        } while (intercambio);
    }
}

/*
 * 
 * Alan Smithee
 * Tiempo máximo: 1,000-2,000 s Memoria máxima: 4096 KiB
 * Claqueta de director
 * Muchos directores de cine que han tenido diferencias artísticas con los
 * productores o distribuidores de sus películas terminan firmándolas con el
 * seudónimo Alan Smithee para manifestar su insatisfacción con el resultado.
 * 
 * El nombre no es casualidad; fue acuñado por el sindicato de directores de
 * Estados Unidos en 1968 precisamente para ese uso, y es un anagrama de The
 * Alias Men ("los hombres con un alias").
 * 
 * Un anagrama es una palabra o frase que se construye con las mismas letras que
 * otra. Algunos ejemplos son esponja y japonés, letras y lastre o frase y
 * fresa.
 * 
 * En los libros también hay anagramas famosos. Por ejemplo el antagonista de
 * Harry Potter se llama Tom Marvolo Riddle del que surge el anagrama I am Lord
 * Voldemort. Por su parte, en la novela El código Da Vinci aparecen varios
 * anagramas que resultan ser pistas ocultas para el protagonista.
 * 
 * Entrada
 * El programa recibirá, por la entrada estándar, un número indicando cuántos
 * casos de prueba vendrán a continuación.
 * 
 * Cada caso de prueba estará compuesto de dos líneas, con dos palabras o frases
 * a analizar. Ninguna de ellas tendrá más de 1.000 letras, y todas tendrán al
 * menos una letra diferente de espacio.
 * 
 * Salida
 * Para cada caso de prueba el programa escribirá "SI" cuando la primera línea
 * sea un anagrama de la segunda y "NO" en caso contrario. Para dar la
 * respuesta, no se deberá tener en cuenta el uso de mayúsculas ni los espacios.
 * Además, por simplicidad, sólo se utilizarán letras del alfabeto inglés y
 * cualquier palabra se considerará anagrama de sí misma.
 * 
 * Entrada de ejemplo
 * 4
 * Alan Smithee
 * The Alias Men
 * frase
 * fresas
 * esponja
 * japones
 * Tom Marvolo Riddle
 * I am Lord Voldemort
 * Salida de ejemplo
 * SI
 * NO
 * SI
 * SI
 * 
 */