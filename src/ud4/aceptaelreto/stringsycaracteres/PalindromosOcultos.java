package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class PalindromosOcultos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una palabra:");
        String palabra = sc.nextLine().trim();

        String resultado = generarPalindromo(palabra);
        System.out.println(resultado);

        sc.close();
    }

    private static String generarPalindromo(String palabra) {
        int[] conteoLetras = new int[26];

        for (int i = 0; i < palabra.length(); i++) {
            conteoLetras[palabra.charAt(i) - 'a']++;
        }

        int contadorImpares = 0;
        char letraImpar = 0;
        for (int i = 0; i < 26; i++) {
            if (conteoLetras[i] % 2 != 0) {
                contadorImpares++;
                letraImpar = (char) (i + 'a');
            }
        }

        if (contadorImpares > 1) {
            return "NO HAY";
        }

        String mitadPalindromo = "";
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < conteoLetras[i] / 2; j++) {
                mitadPalindromo += (char) (i + 'a');
            }
        }

        String palindromo = mitadPalindromo;
        if (contadorImpares == 1) {
            palindromo += letraImpar;
        }
        for (int i = mitadPalindromo.length() - 1; i >= 0; i--) {
            palindromo += mitadPalindromo.charAt(i);
        }

        return palindromo;
    }
}

/*
 * Palíndromos ocultos
 * Tiempo máximo: 2,000 s Memoria máxima: 4096 KiB
 * A Ana Neuquén le encantan los palíndromos, esas palabras que se leen igual de
 * izquierda a derecha que de derecha a izquierda. Lamentablemente, el español
 * es un rollo porque se conocen muy pocos. Pero hay palabras que, reordenando
 * sus letras, pueden convertise en palíndromos.
 * 
 * Cuando otros hablan, siempre se oye un susurro porque Ana murmura palabras
 * incomprensibles intentando crear esos palíndromos. Para alegrarle su futuro
 * cumpleaños y que se pueda entretener, has decidido regalarle un programa que,
 * dada una palabra, intente reordenar sus letras y las escriba de modo que
 * formen un palíndromo, aunque sea impronunciable.
 * 
 * Entrada
 * Cada caso de prueba es una palabra de no más de 20 letras minúsculas del
 * alfabeto inglés.
 * 
 * Salida
 * Por cada caso de prueba se escribirá una palabra con las mismas letras que la
 * original pero reordenadas de modo que el resultado sea un palíndromo, aunque
 * no signifique nada o, incluso, no pueda leerse. Si hay varias opciones se
 * escribirá la que sea menor lexicográficamente.
 * 
 * Si no se puede formar ningún palíndromo se escribirá NO HAY.
 * 
 * Entrada de ejemplo
 * lamentablemente
 * rollo
 * conocen
 * reordenando
 * ala
 * palindromo
 * Salida de ejemplo
 * aeelmntbtnmleea
 * lorol
 * cnoeonc
 * denoraroned
 * ala
 * NO HAY
 */