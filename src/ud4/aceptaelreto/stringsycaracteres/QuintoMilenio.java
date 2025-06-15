package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class QuintoMilenio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leer el número de casos de prueba
        System.out.print("Ingrese el número de casos de prueba: ");
        String primeraLinea = sc.nextLine();
        int numeroCasos = convertirAEntero(primeraLinea);

        // Procesar cada caso de prueba
        for (int i = 0; i < numeroCasos; i++) {
            // Leer el titular y el mensaje oculto
            System.out.println("Ingrese el titular:");
            String titular = sc.nextLine();
            System.out.println("Ingrese el mensaje oculto a buscar:");
            String mensajeOculto = sc.nextLine();

            // Convertir todo a minúsculas
            titular = convertirAMinusculas(titular);
            mensajeOculto = convertirAMinusculas(mensajeOculto);

            // Eliminar espacios del mensaje oculto
            String mensajeSinEspacios = eliminarEspacios(mensajeOculto);

            // Buscar si el mensaje oculto aparece en el titular
            boolean mensajeEncontrado = buscarMensajeOculto(titular, mensajeSinEspacios);

            // Mostrar el resultado
            if (mensajeEncontrado) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }

    // Convierte un String numérico a entero sin usar parseInt()
    public static int convertirAEntero(String numero) {
        int resultado = 0;
        for (int i = 0; i < numero.length(); i++) {
            char digito = numero.charAt(i);
            resultado = resultado * 10 + (digito - '0'); // Convertir cada caracter a número
        }
        return resultado;
    }

    // Convierte una cadena a minúsculas sin usar toLowerCase()
    public static String convertirAMinusculas(String texto) {
        char[] caracteres = texto.toCharArray();
        for (int i = 0; i < caracteres.length; i++) {
            if (caracteres[i] >= 'A' && caracteres[i] <= 'Z') {
                caracteres[i] = (char) (caracteres[i] + 32); // Convertir a minúscula
            }
        }
        return new String(caracteres);
    }

    // Elimina los espacios de la cadena sin usar replace()
    public static String eliminarEspacios(String texto) {
        char[] caracteres = texto.toCharArray();
        String resultado = "";
        for (char c : caracteres) {
            if (c != ' ') {
                resultado += c;
            }
        }
        return resultado;
    }

    // Verifica si el mensaje oculto aparece en orden dentro del titular
    public static boolean buscarMensajeOculto(String titular, String mensaje) {
        int indiceMensaje = 0;
        int longitudMensaje = mensaje.length();

        // Recorrer el titular buscando el mensaje en orden
        for (int i = 0; i < titular.length(); i++) {
            if (titular.charAt(i) == mensaje.charAt(indiceMensaje)) {
                indiceMensaje++;
                // Si se ha encontrado todo el mensaje, devolver verdadero
                if (indiceMensaje == longitudMensaje) {
                    return true;
                }
            }
        }
        return false; // No se encontró el mensaje completo
    }
}

/*
 * QUINTO MILENIO
 * 
 * Quinto milenio
 * Túker Chiménez ve cosas escondidas en cualquier lado. Una mancha de humedad
 * en la pared se le antoja la cara de la anterior propietaria de una casa; el
 * sonido del viento le parece un susurro venido del más allá; una nube con
 * forma peculiar le convence de la existencia de vida extraterrestre.
 * 
 * Ahora le ha dado por ver mensajes ocultos en cualquier sitio. Por poner un
 * ejemplo, si lee el siguiente titular:
 * "El presidente del Gobierno se somete esta noche al escrutinio de varios periodistas en Televisión Española."
 * , se las ingenia para leer un "te odio" oculto que le mantiene en vela toda
 * la noche:
 * 
 * El presidenTe dEl Gobierno se sOmete esta noche al escrutinio De varIos
 * periOdistas en Televisión Española.
 * 
 * Ahora quiere automatizar la tarea de la búsqueda de estos mensajes.
 * 
 * Entrada
 * 
 * La entrada comenzará con un entero que indica el número de casos de prueba.
 * Cada uno de ellos está formado por dos líneas; la primera indica el titular
 * donde buscar un mensaje oculto y la segunda indica el mensaje a buscar. La
 * longitud de cada una de las cadenas no excederá los 2000 caracteres. Ten en
 * cuenta que no hace falta distinguir entre mayúsculas y minúsculas y que los
 * espacios del mensaje oculto no son relevantes, es decir, no hace falta que
 * existan en el mensaje original, pero sí deben aparecer el resto de caracteres
 * (signos de puntuación, comillas, etc.). Se garantiza que el mensaje oculto a
 * buscar no empieza ni termina por espacios.
 * 
 * La entrada contendrá únicamente letras del alfabeto inglés, por lo que no
 * aparecerán vocales con tilde. Además, podrían aparecer múltiples espacios
 * consecutivos.
 * 
 * Salida
 * 
 * Para cada caso de prueba el programa escribirá SI si el mensaje buscado
 * aparece en el titular y NO en caso contrario.
 * 
 * Entrada de ejemplo
 * 
 * 4
 * ...dente ...somete ... de varios periodistas ...
 * te odio.
 * Teo dijo "si".
 * te odio.
 * Y adios, que ya viene el alba.
 * te odio.
 * Teo subio al podio.
 * te odio.
 */