package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class Acronimos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leemos la cantidad de casos de prueba sin parseo directo
        System.out.println("Introduce el número de casos de prueba:");
        String line = scanner.nextLine().trim();
        int numCasos = line.equals("") ? 0 : line.length(); // Contamos la longitud de la cadena para definir cuántos
                                                            // casos procesar

        // Procesamos cada caso
        for (int i = 0; i < numCasos; i++) {
            System.out.println("Introduce la frase para generar el acrónimo:");
            String frase = scanner.nextLine().trim();

            // Generamos el acrónimo
            String acronimo = obtenerAcronimo(frase);
            System.out.println(acronimo);
        }

        scanner.close();
    }

    /**
     * Extrae las iniciales de las palabras en mayúsculas y forma el acrónimo.
     */
    private static String obtenerAcronimo(String frase) {
        String resultado = ""; // Almacena el acrónimo final
        String[] palabras = frase.split(" "); // Separa la frase en palabras

        // Recorremos cada palabra
        for (int i = 0; i < palabras.length; i++) {
            String palabra = palabras[i];

            // Verificamos si la primera letra es mayúscula
            if (!palabra.isEmpty() && palabra.charAt(0) >= 'A' && palabra.charAt(0) <= 'Z') {
                resultado += palabra.charAt(0); // Agregamos la inicial al acrónimo
            }
        }

        return resultado;
    }
}

/*
 * Acrónimos
 * Señal SOS
 * Un acrónimo es una palabra que se forma uniendo partes (en muchos casos, las
 * iniciales) de varias palabras. Por el uso, muchos acaban incorporándose al
 * léxico habitual. Ejemplos muy conocidos son LASER (Light Amplification by
 * Stimulated Emission of Radiation), RENFE (Red Nacional de Ferrocarriles
 * Españoles), OVNI (Objeto Volador No Identificado) o AENA (Aeropuertos
 * Españoles y Navegación Aérea).
 * 
 * Hay también algunos acrónimos sospechosos, por ejemplo, SOS. Popularmente se
 * cree que esta señal significa Save Our Ship (salven nuestro barco, en
 * inglés), Save Our Souls (salven nuestras almas) o Send Out Succour (envíen
 * socorro). Sin embargo, la mayoría de especialistas afirman que SOS no es el
 * acrónimo de ninguna frase, sino que fue una señal seleccionada por su
 * simplicidad para ser transmitida por código Morse, el sistema de
 * representación de letras y números mediante señales acústicas emitidas de
 * forma intermitente. Con él, SOS se envía con una sucesión de tres pulsos
 * cortos, seguida de tres largos y otros tres cortos (··· - - - ···).
 * 
 * Lo que vamos a hacer nosotros es construir nuestros propios acrónimos. Estos
 * se van a formar uniendo las iniciales de las palabras siempre y cuando estas
 * estén en mayúsculas.
 * 
 * Entrada
 * La entrada comienza con un primer número que indica cuántos casos de prueba
 * deberán ser procesados. Cada caso de prueba es una frase de no más de 100
 * caracteres. En la frase solo aparecerán letras del alfabeto inglés, en
 * mayúsculas o en minúsculas y sin tildes, y espacios en blanco que las
 * separan.
 * 
 * Se garantiza que todos los acrónimos formados tendrán al menos una letra.
 * 
 * Salida
 * Para cada caso de prueba se escribirá el acrónimo formado uniendo las
 * iniciales de las palabras siempre y cuando estas estén en mayúsculas.
 * 
 * Entrada de ejemplo
 * 4
 * Light Amplification by Stimulated Emission of Radiation
 * Objeto Volador NO Identificado
 * Tren Articulado Ligero GOICOECHEA ORIOL
 * United Nations Educational Scientific and Cultural Organization
 * Salida de ejemplo
 * LASER
 * OVNI
 * TALGO
 * UNESCO
 */