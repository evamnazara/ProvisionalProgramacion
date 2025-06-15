package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class FiestaAburrida {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leemos la cantidad de personas que Tinín no conoce
        System.out.println("Introduce el número de personas que Tinín no conoce:");
        String primeraLinea = scanner.nextLine();
        int cantidadPersonas = convertirAEntero(primeraLinea);

        // Procesamos cada presentación
        System.out.println("Ahora, cada persona se presentará diciendo 'Soy [nombre]':");
        for (int i = 0; i < cantidadPersonas; i++) {
            String lineaPresentacion = scanner.nextLine(); // Leemos la presentación "Soy [nombre]"
            String nombrePersona = extraerNombre(lineaPresentacion); // Extraemos el nombre de la persona
            System.out.println("Hola, " + nombrePersona + "."); // Imprimimos el saludo
        }

        scanner.close();
    }

    // Función para convertir un número en String a entero sin usar parseInt()
    public static int convertirAEntero(String numeroComoString) {
        int resultado = 0;
        for (int i = 0; i < numeroComoString.length(); i++) {
            char digito = numeroComoString.charAt(i);
            resultado = resultado * 10 + (digito - '0');
        }
        return resultado;
    }

    // Función para extraer el nombre de la frase "Soy [nombre]"
    public static String extraerNombre(String frasePresentacion) {
        return frasePresentacion.substring(4); // "Soy " tiene 4 caracteres, por lo que extraemos el nombre desde ahí
    }
}

/*
 * ===============
 * 
 * LA FIESTA ABURRIDA
 * 
 * 
 * La fiesta aburrida
 * Tiempo máximo: 1,000 s Memoria máxima: 2048 KiB
 * Tinín es un tipo bastante peculiar. No le gustan nada las fiestas, ni las
 * celebraciones, ni las cenas familiares o con amigos. Nada. Es sorprendente
 * que, a pesar de sus pocas ganas de interactuar con gente, haya encontrado
 * novia.
 * 
 * Cuando ésta consigue sacarle de casa para llevarle a algún tipo de
 * celebración y la gente le dice "Hombre, Tinín, ¡pero si has venido!" él
 * siempre suelta su mítica frase "Yo soy más traído que venido.".
 * 
 * Una de las cosas que más le molesta es tener que ir saludando a todos los
 * presentes, sobre todo si no le conocen. Eso de que se le acerquen y le digan
 * "Soy Lotario" y que él tenga que saludar no lo soporta. ¿Puedes ayudarle?
 * 
 * Entrada
 * 
 * La entrada comienza con un número que indica la cantidad de gente a la que
 * Tinín no conoce en la fiesta en la que está. A continuación viene una línea
 * por cada una de esas personas en la que se presenta indicando su nombre:
 * "Soy Lotario". La línea siempre tendrá el mismo formato; una primera palabra
 * "Soy" seguida del nombre de la persona que será simple (no será un nombre
 * compuesto por varias palabras) y formado por como mucho 100 letras del
 * alfabeto inglés.
 * 
 * Salida
 * 
 * Para cada persona que se le aproxima, se debe escribir la cadena
 * "Hola, [nombre].".
 * 
 * Entrada de ejemplo
 * 
 * 3
 * Soy Lotario
 * Soy Aldonza
 * Soy Ender
 * Salida de ejemplo
 * 
 * Hola, Lotario.
 * Hola, Aldonza.
 * Hola, Ender.
 * =======
 */
