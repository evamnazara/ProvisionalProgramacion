package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class EncadenandoPalabras {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce las secuencias de palabras encadenadas (línea vacía para finalizar):");

        while (true) {
            String linea = scanner.nextLine().trim();
            if (linea.isEmpty()) {
                System.out.println("Fin del programa.");
                break;
            }

            String resultado = verificarEncadenamiento(linea) ? "SI" : "NO";
            System.out.println(resultado);
        }

        scanner.close();
    }

    private static boolean verificarEncadenamiento(String linea) {
        String[] palabras = linea.split(" ");

        for (int i = 0; i < palabras.length - 1; i++) {
            String ultimaSilaba = extraerUltimaSilaba(palabras[i]);
            String primeraSilaba = extraerPrimeraSilaba(palabras[i + 1]);

            if (!ultimaSilaba.equals(primeraSilaba)) {
                return false;
            }
        }

        return true;
    }

    private static String extraerUltimaSilaba(String palabra) {
        int longitud = palabra.length();
        return palabra.substring(longitud - 2);
    }

    private static String extraerPrimeraSilaba(String palabra) {
        return palabra.substring(0, 2);
    }
}

/*
 * Encadenando palabras
 * A Samuel y a Clara les encanta jugar a encadenar palabras. Si Samuel dice
 * Mata, Clara sigue diciendo Tapa. Samuel le sigue el juego diciendo Papa y
 * Clara remata diciendo Pato.
 * 
 * Normalmente no tarda mucho en estallar la discusión cuando alguno piensa que
 * el otro lo ha hecho mal. En realidad Samuel acaba de aprender a leer y a
 * Clara todavía le queda un poco para empezar... así que es normal que tengan
 * conflictos, pero lo cierto es que sus padres acaban cansados de tantas
 * discusiones.
 * 
 * ¿Puedes hacer un programa que les diga a Samuel y a Clara si su lista de
 * palabras encadenadas está bien? No te preocupes por la existencia o
 * inexistencia de las palabras que usan, de eso seguirán ocupándose sus
 * sufridos padres.
 * 
 * Entrada
 * La entrada consta de un conjunto de casos de prueba, cada uno formado por una
 * serie de entre 1 y 50 palabras en una misma línea. Cada palabra, de un mínimo
 * de 2 caracteres y un máximo de 24, está separada de la siguiente mediante un
 * espacio. Clara y Samuel no tienen aún demasiado vocabulario, por lo que
 * podemos asegurar que las palabras que utilizan están formadas por sílabas
 * formadas por dos letras.
 * 
 * Salida
 * Para cada caso de prueba se escribirá una línea que mostrará un SI si todas
 * las palabras de la serie están correctamente encadenadas, y un NO en caso
 * contrario.
 * 
 * Se considera que dos palabras están encadenadas si la última sílaba de la
 * primera palabra es igual que la primera de la segunda. Para las palabras que
 * tienen una única sílaba, ésta se considera simultáneamente la primera y la
 * última.
 * 
 * Nos interesa que los niños aprendan ortografía, así que exigiremos que no
 * sólo el sonido sea igual, sino que la grafía también lo sea. No obstante,
 * todas las palabras se escribirán en minúscula y no se tendrán vocales con
 * tilde u otros símbolos no pertenecientes al alfabeto inglés.
 * 
 * Entrada de ejemplo
 * gugutata
 * mata tapa papa pato
 * seto taco coma matute
 * sien encima mapa patuco comida
 * cata tasama malote tejaba batama
 * kiosko comida
 * Salida de ejemplo
 * 
 * SI
 * SI
 * NO
 * SI
 * SI
 * NO
 */