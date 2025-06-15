package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class MensajeSecreto {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Continuar leyendo líneas de entrada hasta que no haya más
        while (scanner.hasNextLine()) {
            // Leemos la línea del mensaje cifrado
            String mensajeCifrado = scanner.nextLine().trim();

            // Llamamos a la función para descifrar el mensaje
            String mensajeDescifrado = descifrarMensaje(mensajeCifrado);

            // Imprimimos el mensaje descifrado
            System.out.println(mensajeDescifrado);
        }

        scanner.close(); // Cerramos el scanner después de que terminamos de leer
    }

    // Función para descifrar el mensaje
    public static String descifrarMensaje(String mensajeCifrado) {
        String mensajeDescifrado = ""; // String que guardará el mensaje descifrado
        int i = 0; // Índice para recorrer el mensaje cifrado

        // Recorremos el mensaje cifrado
        while (i < mensajeCifrado.length()) {
            // Intentamos obtener el siguiente número, que puede tener 2 o 3 dígitos (por
            // ejemplo: 65 o 100)
            int codigoAscii;
            if (i + 2 < mensajeCifrado.length() && esNumero(mensajeCifrado.charAt(i))
                    && esNumero(mensajeCifrado.charAt(i + 1)) && esNumero(mensajeCifrado.charAt(i + 2))) {
                // Si es un número de 3 dígitos
                codigoAscii = Integer.parseInt(mensajeCifrado.substring(i, i + 3));
                i += 3; // Avanzamos 3 posiciones
            } else {
                // Si es un número de 2 dígitos
                codigoAscii = Integer.parseInt(mensajeCifrado.substring(i, i + 2));
                i += 2; // Avanzamos 2 posiciones
            }

            // Convertimos el código ASCII a su carácter correspondiente
            char caracter = (char) codigoAscii;

            // Agregamos el carácter al mensaje descifrado
            mensajeDescifrado += caracter;
        }

        return mensajeDescifrado;
    }

    // Función para verificar si un carácter es un número (para determinar si es
    // parte de un código ASCII)
    public static boolean esNumero(char c) {
        return c >= '0' && c <= '9';
    }
}

/*
 * Mensaje secreto
 * Para enviarse mensajes secretos, Ana y Tomás (estudiantes de programación)
 * escriben notas en papel en las que cambian cada letra o símbolo por su valor
 * numérico (decimal) de acuerdo al código ASCII. Así, la letra A la escriben
 * como 65, la B como 66, y así sucesivamente. Ana ha recibido el siguiente
 * mensaje de Tomás:
 * 
 * 771013210311711511697115321099711532113117101321081111153211211711011610111411111546
 * 
 * Y necesita ayuda para descifrarlo. ¿Puedes echarle una mano?
 * 
 * Entrada
 * La entrada está formada por un conjunto de mensajes codificados, cada uno en
 * una línea distinta. Los mensajes pueden contener sólo letras mayúsculas y
 * minúsculas del alfabeto inglés, además de los símbolos espacio, coma y punto.
 * La longitud un mensaje, después de ser descifrado, no es nunca mayor de 100
 * caracteres.
 * 
 * Salida
 * Para cada mensaje codificado, se escribirá en una línea el mensaje
 * descifrado.
 * 
 * Entrada de ejemplo
 * 65666665
 * 651009766121114111110321091111089746
 * 77101321031171151169732112114111103114971099711432101110326746
 * Salida de ejemplo
 * ABBA
 * AdaByron mola.
 * Me gusta programar en C.
 */