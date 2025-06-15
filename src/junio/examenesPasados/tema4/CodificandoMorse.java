package junio.examenesPasados.tema4;

public class CodificandoMorse {
    /*
     * El código Morse codifica cada carácter se codifica como una sucesión de
     * puntos y raya. En realidad, el mensaje se enviaba como una serie de pitidos.
     * Según el
     * estándar de 1922, un punto se envía como un pitido, una raya como tres
     * pitidos (o un pitido de
     * tres puntos de duración). Además, entre símbolo y símbolo (raya o punto) de
     * una misma letra
     * hay que esperar un punto, entre letras de una misma palabra se esperan tres
     * puntos, y entre palabras cinco puntos.
     * Implementa el siguiente método que recibe una frase de no más de 80 letras
     * mayúsculas del alfabeto inglés, signos de admiración, interrogación y
     * espacios, y
     * devuelve la duración
     * del mensaje codificado en número de puntos.
     */
    public static void main(String[] args) {

        String caso1 = "?"; // 15
        String caso2 = "!"; // 19
        String caso3 = "SI"; // 11
        String caso4 = "YA NACIO"; // 73
        String morse = "-.-- .-    -. .- -.-. .. ---";

        System.out.println(numPuntosMorse(caso1));
        System.out.println(numPuntosMorse(caso2));
        System.out.println(numPuntosMorse(caso3));
        System.out.println(numPuntosMorse(caso4));

        System.out.println(convertirMorse(caso4));

        System.out.println(descodificarMorse(morse));
    }

    public static int numPuntosMorse(String frase) {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!?";
        String[] letrasMorse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-",
                ".--", "-..-", "-.--", "--..",
                "-.-.--", "..--.." };

        int puntosTotales = 0;

        // separar la frase
        frase = frase.trim();
        String[] palabras = frase.split(" ");

        // se recorre cada palabra
        for (int i = 0; i < palabras.length; i++) {
            String palabra = palabras[i];

            // recorrer cada letra de la palabra
            for (int j = 0; j < palabra.length(); j++) {
                char letra = palabra.charAt(j);
                int posicionLetra = letras.indexOf(letra);
                // se busca la correcpondencia de la letra en el alfabeto morse
                String morse = letrasMorse[posicionLetra];

                // se reocrre cada simbolo del codigo morse
                for (int k = 0; k < morse.length(); k++) {
                    char simbolo = morse.charAt(k);
                    if (simbolo == '.') {
                        puntosTotales += 1;
                    } else if (simbolo == '-') {
                        puntosTotales += 3;
                    }

                    // si no es el ultimo simbolo de la letra, sumamos 1 por espacio
                    if (k < morse.length() - 1) {
                        puntosTotales += 1;
                    }
                }
                // si no es la ultima letra de la palabra, 3 puntos espacio entre letras
                if (j < palabra.length() - 1) {
                    puntosTotales += 3;
                }

            }
            // si no es la ultima palabra, + 5 puntos por espacio
            if (i < palabras.length - 1) {
                puntosTotales += 5;
            }
        }

        return puntosTotales;
    }

    public static String convertirMorse(String frase) {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!?";
        String[] letrasMorse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-",
                ".--", "-..-", "-.--", "--..",
                "-.-.--", "..--.." };
        String fraseEnMorse = "";

        for (int i = 0; i < frase.length(); i++) {
            char letra = frase.charAt(i);

            // si hay espacio hay que separarlo
            if (letra == ' ') {
                fraseEnMorse += "   ";
            } else {
                // NO FRASE.INDEXOF
                int posicion = letras.indexOf(letra); // OJO BSCAR EN EL ARRAY DE LETRAS
                if (posicion != -1) { // si es caracter permitido
                    String letraMorse = letrasMorse[posicion];

                    fraseEnMorse += letraMorse;
                    fraseEnMorse += " ";
                }

            }

        }

        return fraseEnMorse;
    }

    public static String descodificarMorse(String morse) {
        // Alfabeto y equivalencias Morse (igual que antes)
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!?";
        String[] letrasMorse = {
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-",
                "...-", ".--", "-..-", "-.--", "--..",
                "-.-.--", "..--.."
        };

        String frase = ""; // Aquí se construye la frase resultante

        // Primero separamos por palabras (3 espacios)
        String[] palabras = morse.trim().split(" {3}"); // regex: 3 espacios

        for (int i = 0; i < palabras.length; i++) {
            String palabraMorse = palabras[i];

            // Luego separamos por letras (1 espacio)
            String[] letrasMorseSeparadas = palabraMorse.split(" ");

            for (int j = 0; j < letrasMorseSeparadas.length; j++) {
                String morseLetra = letrasMorseSeparadas[j];

                // Buscar el índice de esa letra en el array de letrasMorse
                int posicion = -1;
                for (int k = 0; k < letrasMorse.length; k++) {
                    if (letrasMorse[k].equals(morseLetra)) {
                        posicion = k;
                        break;
                    }
                }

                // Si se encuentra, se añade la letra correspondiente
                if (posicion != -1) {
                    frase += letras.charAt(posicion);
                }
            }

            // Después de cada palabra, añadir un espacio (excepto después de la última)
            if (i < palabras.length - 1) {
                frase += " ";
            }
        }

        return frase;
    }

}
