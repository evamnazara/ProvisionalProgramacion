package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class NanaAlBebe {

    public static void main(String[] args) {
        // Crear un scanner para leer la entrada
        Scanner sc = new Scanner(System.in);

        // Leer las palabras de entrada
        while (sc.hasNextLine()) {
            String palabra = sc.nextLine().trim();

            // Convertir la palabra a minúsculas para que la comparación sea insensible a
            // mayúsculas/minúsculas
            palabra = palabra.toLowerCase();

            // Encontrar la longitud de la subcadena más corta
            int longitud = encontrarSubcadenaCorta(palabra);

            // Imprimir el resultado
            System.out.println(longitud);
        }

        // Cerrar el scanner
        sc.close();
    }

    // Función para encontrar la longitud de la subcadena más corta
    public static int encontrarSubcadenaCorta(String palabra) {
        int longitudPalabra = palabra.length();

        // Comenzamos con subcadenas de longitud 1 hasta la longitud de la palabra
        for (int i = 1; i <= longitudPalabra; i++) {
            // Obtener la subcadena que estamos probando
            String subcadena = palabra.substring(0, i);

            // Variable para construir la palabra repetida
            String palabraRepetida = "";

            // Repetir la subcadena suficientes veces para cubrir toda la longitud de la
            // palabra
            for (int j = 0; j < (longitudPalabra / i); j++) {
                palabraRepetida += subcadena; // Concatenamos las subcadenas manualmente
            }

            // Si la longitud total de la repetición cubre la palabra original, la subcadena
            // es la correcta
            if (palabraRepetida.equals(palabra)) {
                return i; // Devuelve la longitud de la subcadena que se repite
            }
        }

        // Si no encontramos una subcadena (lo cual no debería ocurrir si la palabra es
        // cíclica)
        return longitudPalabra;
    }
}

/*
 * Nana al bebé de papá y mamá
 * Tiempo máximo: 1,000-2,000 s Memoria máxima: 4096 KiB
 * Cartel 'Baba on Board'
 * A los padres primerizos se les cae la baba cuando su bebé dice sus primeras
 * palabras: "mamá" y "papá".
 * 
 * Pero ¿por qué son esas dos palabras las primeras que aprendemos a decir? Es
 * curioso que ambas sean la repetición de una sílaba dos veces. ¡Eso las hace
 * más fáciles de vocalizar! De hecho, el vocabulario de la primera infancia
 * está lleno de palabras así: mamá, papá, nana, bebé, tete, coco, baba, pipí…
 * 
 * A todas esas palabras las denominaremos palabras cíclicas, pues se construyen
 * con la repetición, varias veces, de un conjunto de letras. Cuando alguien
 * duerme escribimos "Zzzzz", que también es cíclica, pues es la repetición de
 * la letra "z". También lo son "toctoc" o "trantrán".
 * 
 * Entrada
 * El programa debe aceptar una serie de palabras, cada una en una línea, con
 * longitudes de entre 1 y 200 letras. Contendrán únicamente letras del alfabeto
 * inglés, en mayúscula o minúscula, sin espacios ni ningún otro separador.
 * 
 * Salida
 * Para cada cadena, el programa escribirá la longitud de la subcadena más corta
 * posible que puede usarse para crear la palabra original repitiéndola varias
 * veces, ignorando las diferencias entre mayúsculas y minúsculas.
 * 
 * Entrada de ejemplo
 * Mama
 * TranTran
 * ZzZzZzZzZzZz
 * juguete
 * Salida de ejemplo
 * 2
 * 4
 * 1
 * 7
 * 
 */