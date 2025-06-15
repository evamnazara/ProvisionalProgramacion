package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class AprendiendoCodigoMorse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Tabla del alfabeto en morse
        String[] morseAlfabeto = {
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
                "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
                "..-", "...-", ".--", "-..-", "-.--", "--.."
        };

        // Procesamiento de cada línea de entrada
        while (scanner.hasNextLine()) {
            String palabra = scanner.nextLine().trim();
            if (palabra.isEmpty()) {
                break;
            }

            // Generamos el código Morse de la palabra
            String codigoGenerado = generarCodigoMorse(palabra);

            // Convertimos la primera letra de la palabra a su índice en el alfabeto
            char primeraLetra = Character.toUpperCase(palabra.charAt(0));
            int indice = primeraLetra - 'A';
            String codigoEsperado = morseAlfabeto[indice];

            // Comparamos el código generado con el esperado
            if (codigoGenerado.equals(codigoEsperado)) {
                System.out.println(palabra + " OK");
            } else {
                System.out.println(palabra + " X");
            }
        }

        scanner.close();
    }

    // Genera el código Morse para una palabra dada
    public static String generarCodigoMorse(String palabra) {
        String resultado = ""; // Almacenamos el resultado en un String

        // Iteramos sobre cada letra de la palabra
        for (int i = 0; i < palabra.length(); i++) {
            char letra = Character.toLowerCase(palabra.charAt(i)); // Convertimos a minúscula

            // Si es una vocal, asignamos el símbolo correspondiente
            if (letra == 'o') {
                resultado += "-"; // 'o' se convierte en raya
            } else if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'u') {
                resultado += "."; // Las otras vocales se convierten en punto
            }
        }

        return resultado; // Retornamos el código Morse generado
    }
}

/*
 * CODIGO MORSE
 * 
 * Aprendiendo el código Morse
 * Todos hemos oído hablar del código o alfabeto Morse, que antiguamente servía
 * para transmitir mensajes de telégrafo. El código consiste en la codificación
 * de cada letra del abecedario con una sucesión de puntos y rayas que se
 * traducen a señales auditivas cortas (puntos) o largas (rayas), siguiendo las
 * transformaciones que se indican en la tabla.
 * 
 * Letra Código Letra Código
 * A .- N -.
 * B -... O ---
 * C -.-. P .--.
 * D -.. Q --.-
 * E . R .-.
 * F ..-. S ...
 * G --. T -
 * H .... U ..-
 * I .. V ...-
 * J .--- W .--
 * K -.- X -..-
 * L .-.. Y -.--
 * M -- Z --..
 * El código, no obstante, es bastante complicado de aprender y utilizar. Por
 * una parte hay que aprenderse los códigos de cada letra. Por otra, hay que
 * añadir pausas entre cada símbolo, al existir codificaciones de letras que son
 * prefijos de otras, y pausas más largas entre cada palabra, pues el "espacio"
 * no tiene ningún código asociado.
 * 
 * Una guía de ayuda para aprenderse la tabla de codificación consiste en tener
 * una palabra de referencia para cada letra. Así, por ejemplo, para la letra
 * 'A' podemos memorizar Arco. La palabra elegida para cada letra debe comenzar
 * por esa letra y ser tal que si cada vocal 'o' se sustituye por una raya, y el
 * resto de vocales por un punto, el resultado final sea la codificación de la
 * letra en cuestión.
 * 
 * A continuación aparecen algunos ejemplos de palabras que pueden utilizarse
 * como palabras de referencia:
 * 
 * Letra Palabra de referencia Código
 * A Arco .-
 * B Bogavante -...
 * C Corazones -.-.
 * Ahora estamos haciendo una tabla nueva y tenemos que comprobar si, dada una
 * palabra, podemos o no utilizarla como palabra de referencia.
 * Entrada
 * 
 * La entrada consiste en una serie de palabras de no más de 20 letras, cada una
 * en una línea independiente. Cada palabra contendrá únicamente símbolos del
 * alfabeto inglés ya sea en mayúscula o en minúscula. Las palabras no
 * contendrán tildes (aunque eso implique no escribir correctamente la palabra).
 * 
 * Salida
 * 
 * Para cada palabra se mostrará en una línea independiente si puede ser
 * utilizada como palabra de referencia según la descripción dada. En caso
 * afirmativo se escribirá la palabra leída seguida de "OK". En caso negativo,
 * tras la palabra se escribira "X".
 * 
 * Entrada de ejemplo
 * 
 * Arco
 * Corazones
 * ARBOLES
 * Salida de ejemplo
 * 
 * Arco OK
 * Corazones OK
 * ARBOLES X
 * 
 */