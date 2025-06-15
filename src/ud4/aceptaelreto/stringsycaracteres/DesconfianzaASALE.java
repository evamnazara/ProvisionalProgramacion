package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class DesconfianzaASALE {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leemos el número de casos a procesar
        System.out.println("Introduce el número de casos:");
        int numeroDeCasos = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        // Procesamos cada caso de prueba
        for (int i = 0; i < numeroDeCasos; i++) {
            System.out.println("Introduce las dos palabras:");
            String caso = scanner.nextLine();
            String[] palabras = caso.split(" ");

            // Llamamos a la función que compara las palabras siguiendo las reglas del
            // antiguo diccionario
            String resultado = compararPalabras(palabras[0], palabras[1]);

            // Imprimimos el resultado
            System.out.println(resultado);
        }

        scanner.close(); // Cerramos el scanner
    }

    // Función que compara las palabras como en el diccionario anterior
    public static String compararPalabras(String palabra1, String palabra2) {
        // Reemplazamos "ch" por "ç" y "ll" por "ë" para tratarlos como caracteres
        // únicos
        palabra1 = palabra1.replace("ch", "ç").replace("ll", "ë");
        palabra2 = palabra2.replace("ch", "ç").replace("ll", "ë");

        // Comparamos las dos palabras
        if (palabra1.compareTo(palabra2) < 0) {
            return palabra1;
        } else {
            return palabra2;
        }
    }
}

/*
 * La desconfianza de la ASALE
 * 
 * 
 * Cuando en el lejano 1754 se publicó la Ortografía de la lengua española, los
 * digrafos ch y ll (conocidos como che y elle) fueron considerados letras. Es
 * por ello que cuando en 1803 se publicó la cuarta edición del Diccionario de
 * la lengua española estos dos digrafos tuvieron secciones separadas dentro de
 * la ordenación alfabética1.
 * 
 * En particular, los niños en la escuela aprendían que el alfabeto era a, b, c,
 * ch, d, e, f, g, h, i, j, k, l, ll, m, n, ñ, o, p, q, r, s, t, u, v, w, x, y,
 * y z2.
 * La consecuencia práctica a la hora de buscar en esos diccionarios era que,
 * por ejemplo, "chocolate" aparecía después que "cuchillo" a pesar de que su
 * segundo carácter (h) va antes en el alfabeto latino que el segundo carácter
 * de "cuchillo" (la u). Ese mismo funcionamiento se da cuando los digrafos
 * aparecen en medio de una palabra. Por ejemplo "cacique" aparecía antes que
 * "cacho".
 * 
 * Durante el X congreso de la Asociación de Academias de la Lengua Española
 * (ASALE) celebrada en 1994, la historia dio un vuelco. En aquellas reuniones
 * en Madrid se acordó reordenar los digrafos y colocarlos en el lugar que
 * determina el alfabeto latino clásico por lo que la siguiente edición del
 * diccionario (2001) no tuvo secciones separadas para ellos y "cacho" apareció
 * antes que "cacique". Por contar la historia completa, en 2010 se publicó una
 * nueva ortografía de la lengua española, en donde se quitó a los digrafos la
 * categoría de letra.
 * 
 * Aunque la ASALE seguramente justificará su decisión por otros motivos,
 * nuestras sospechas son que desconfía por completo de los informáticos que
 * tienen que programar los algoritmos de ordenación de cadenas en nuestro
 * idioma. Y es que no resulta fácil. Además de manejar correctamente la ñ,
 * vocales con tilde y las diéresis, teníamos que controlar los digrafos.
 * 
 * Es hora de demostrar a la ASALE que se equivocaba.
 * 
 * Entrada
 * La entrada está compuesta por distintos casos de prueba, cada uno en una
 * línea.
 * 
 * En cada línea aparecen dos palabras distintas con letras en minúscula de no
 * más de 10 caracteres. Para no tentar mucho a la suerte (y tener que terminar
 * dando la razón a la ASALE) ninguna de las palabras tiene ñ, tildes o
 * diéresis. Las palabras, eso sí, no tienen por qué ser válidas en nuestro
 * idioma (podrían, por ejemplo, no tener vocales), aunque se garantiza que
 * nunca aparecerán más de dos l's seguidas.
 * 
 * Salida
 * Por cada caso de prueba se escribirá la palabra que debería aparecer antes en
 * un diccionario anterior a la supresión de los digrafos.
 * 
 * Entrada de ejemplo
 * allanar alunizar
 * cacho cacique
 * cuchillo chocolate
 * peruano peru
 * Salida de ejemplo
 * 
 * alunizar
 * cacique
 * cuchillo
 * peru
 */