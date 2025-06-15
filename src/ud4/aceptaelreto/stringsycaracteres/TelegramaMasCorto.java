package ud4.aceptaelreto.stringsycaracteres;

public class TelegramaMasCorto {

    // Mapa del código Morse para las letras, signos de exclamación e interrogación
    static String[] morse = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", // A - J
            "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", // K - T
            "..-", "...-", ".--", "-..-", "-.--", "--..", "-.-.--", "..--..", // U - Z, !, ?
    };

    public static void main(String[] args) {
        // Entradas de prueba
        String[] casos = {
                "?",
                "!",
                "SI",
                "YA NACIO"
        };

        // Procesar cada caso
        for (String caso : casos) {
            // Calculamos la duración de cada telegrama
            int duracion = calcularDuracionTelegrama(caso);
            System.out.println(duracion); // Imprimimos la duración
        }
    }

    // Función para calcular la duración de un telegrama
    public static int calcularDuracionTelegrama(String mensaje) {
        // Variable para almacenar la duración total en puntos
        int duracion = 0;

        // Recorremos cada caracter en el mensaje
        for (int i = 0; i < mensaje.length(); i++) {
            char c = mensaje.charAt(i);

            // Si es un espacio, se considera separación entre palabras (5 puntos)
            if (c == ' ') {
                duracion += 5;
            } else {
                // Obtenemos el código morse para el carácter
                String morseChar = obtenerMorse(c);
                if (morseChar != null) {
                    // Contamos la duración de este caracter en Morse
                    duracion += calcularDuracionMorse(morseChar);

                    // Si no es el último carácter, agregamos 1 punto de separación entre símbolos
                    if (i < mensaje.length() - 1 && mensaje.charAt(i + 1) != ' ') {
                        duracion += 1;
                    }
                }
            }
        }
        return duracion;
    }

    // Función para obtener el código Morse correspondiente a un carácter
    public static String obtenerMorse(char c) {
        // Si el carácter es un espacio, no lo procesamos
        if (c == ' ')
            return null;

        // Verificamos si el carácter es uno de los caracteres soportados (A-Z, !, ?)
        if (c >= 'A' && c <= 'Z') {
            return morse[c - 'A']; // A-Z mapeados
        } else if (c == '?') {
            return morse[26]; // ?
        } else if (c == '!') {
            return morse[27]; // !
        }
        return null; // En caso de que no sea un carácter reconocido
    }

    // Función para calcular la duración de un código Morse
    public static int calcularDuracionMorse(String morse) {
        int duracion = 0;

        // Recorrer cada símbolo Morse
        for (int i = 0; i < morse.length(); i++) {
            char c = morse.charAt(i);
            if (c == '.') {
                duracion += 1; // Un punto tiene duración de 1
            } else if (c == '-') {
                duracion += 3; // Una raya tiene duración de 3
            }
        }

        return duracion;
    }
}

/*
 * El telegrama más corto
 * Aunque hoy su uso está en horas bajas, el sistema de telégrafo fue el medio
 * principal de comunicación durante el final del siglo XIX y la primera mitad
 * del XX1. Para enviar letras y símbolos, se utilizaba código Morse, que
 * codificaba cada elemento como una sucesión de puntos y rayas2. Al menos esa
 * es la creencia popular porque, en realidad, ambos son meros "pitidos"
 * enviados por un cable con la característica de que el pitido asociado a una
 * raya es tres veces más largo que el de un punto. Se conocen como puntos y
 * rayas porque, en el receptor, esos pitidos ocasionaban perforaciones en una
 * cinta de papel en movimiento, lo que originaba zonas rasgadas cortas (puntos)
 * y largas (rayas).
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
 * ! -.-.-- ? ..--..
 * El sistema era tan artesanal que el servicio se pagaba por número de palabras
 * enviadas. Eso creó un lenguaje propio del telegrama, evitando palabras
 * superfluas e incorporando abreviaturas particulares, como ocurriría mucho
 * tiempo después con otras tecnologías como los SMS o Twitter.
 * 
 * Dice la leyenda que el telegrama más corto de la historia lo envió Victor
 * Hugo. Pese a ser amante del subjuntivo, las frases subordinadas y los libros
 * largos, cuando llegó el momento de preguntar por telegrama a su editor cómo
 * estaban yendo las ventas de su recién publicado libro "Los miserables",
 * decidió dejar su rimbombante prosa para otra ocasión y envió un simple "?".
 * 
 * Para saber si realmente Victor Hugo envió el telegrama más corto de la
 * historia hay que recurrir a la foto finish. Su editor, a la vista de las
 * buenas ventas del libro, le respondió con un simple "!".
 * 
 * Entrada
 * La entrada comienza con un número indicando cuántos casos de prueba deberán
 * ser procesados.
 * 
 * A continuación aparece una línea por cada caso de prueba, conteniendo una
 * frase de no más de 80 letras mayúsculas del alfabeto inglés, signos de
 * admiración e interrogación y espacios. Se garantiza que no aparecen dos
 * espacios seguidos, y que la línea no empieza ni termina en espacio.
 * 
 * Salida
 * Por cada caso de prueba el programa escribirá la duración en puntos del
 * telegrama. Según la publicación de 1922 del estándar del código Morse, una
 * raya dura tres puntos, entre símbolo y símbolo (raya o punto) de una misma
 * letra hay que esperar un punto, la separación temporal entre letras son tres
 * puntos, y la separación entre palabras cinco.
 * 
 * Entrada de ejemplo
 * 4
 * ?
 * !
 * SI
 * YA NACIO
 * Salida de ejemplo
 * 
 * 15
 * 19
 * 11
 * 73
 */