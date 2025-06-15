package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class Anelidos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer la línea de entrada
        System.out.println("Numero de fases de crecimiento a simular:");
        String linea = scanner.nextLine().trim();

        // Si la entrada es vacía o solo contiene "C", terminamos el programa

        if (linea.equals("C")) {
            System.out.println("");
        }

        // Buscar el primer espacio en la línea, que separa las fases del patrón de
        // anillos

        int espacio = encontrarEspacio(linea);
        if (espacio == -1) {
            System.out.println("Entrada inválida. No se encontró el número de fases.");
            // Terminar el programa si no hay espacio
        }

        // Obtener el número de fases (entero) y la cadena de anillos
        int numeroDeFases = convertirAEntero(linea.substring(0, espacio));
        String cadenaDeAnillos = linea.substring(espacio + 1); // La cadena de anillos

        // Si la cadena de anillos es solo "C", terminamos, ya que no tiene anillos
        if (cadenaDeAnillos.equals("C")) {
            System.out.println("Cadena de anillos solo contiene la cabeza.");
            // Terminar si solo hay la cabeza 'C'
        }

        // Simular el crecimiento de los anélidos por el número de fases
        System.out.println("Configuración inicial: " + cadenaDeAnillos);
        for (int i = 0; i < numeroDeFases; i++) {
            cadenaDeAnillos = simularCrecimiento(cadenaDeAnillos);
            System.out.println("Después de la fase " + (i + 1) + ": " + cadenaDeAnillos);
        }

        // Imprimir el resultado final después de las fases de crecimiento
        System.out.println("Resultado final después de " + numeroDeFases + " fases: " + cadenaDeAnillos);

        scanner.close();
    }

    // encontrar el primer espacio en la línea de entrada
    public static int encontrarEspacio(String texto) {
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == ' ') {
                return i; // Retorna la posición del primer espacio
            }
        }
        return -1; // Si no hay espacio, retornamos -1
    }

    // convertir una cadena de caracteres a un número entero
    public static int convertirAEntero(String numero) {
        int resultado = 0;
        for (int i = 0; i < numero.length(); i++) {
            char digito = numero.charAt(i);
            resultado = resultado * 10 + (digito - '0'); // Convertir cada caracter en un número
        }
        return resultado;
    }

    // Método para simular una fase de crecimiento de los anélidos
    public static String simularCrecimiento(String anillos) {
        String nuevaCadena = ""; // Cadena vacía para guardar el resultado

        // Iteramos sobre cada anillo en la cadena original (excepto el 'C')
        for (int i = 0; i < anillos.length() - 1; i++) {
            char anillo = anillos.charAt(i);
            if (anillo == 'A') {
                nuevaCadena += "NA"; // Si el anillo es amarillo, se convierte en "NA"
            } else if (anillo == 'N') {
                nuevaCadena += "AN"; // Si el anillo es negro, se convierte en "AN"
            }
        }

        // Finalmente, añadimos la cabeza 'C' al final de la cadena
        return nuevaCadena + "C";
    }
}

/*
 * ANELIDOS
 * 
 * 
 * Los anélidos son una variedad de lo que coloquialmente se conoce como
 * gusanos. Su propiedad más característica (y que los diferencia del resto de
 * variedades) es que sus cuerpos están compuestos por la repetición de
 * "anillos" con la misma estructura, repitiéndose en cada anillo todos los
 * órganos internos y externos. Seguramente los anélidos más conocidos sean las
 * orugas.
 * En algunos lugares de la selva tropical se da una variedad de oruga, llamada
 * thuelis, que intriga desde hace muchos años a los biólogos. Cuando nacen,
 * poseen únicamente un anillo (además de la cabeza), de color o bien amarillo,
 * o bien negro. En cada fase de crecimiento todos sus anillos se replican, de
 * forma que donde antes había un anillo ahora aparecen dos. En particular cada
 * anillo da lugar, a su lado y más cerca que él de la cabeza, a un nuevo anillo
 * del color contrario:
 * Estas orugas crecen indefinidamente siguiendo ese patrón. Aunque no son
 * venenosas, los colores que muestran son similares a los de otras especies que
 * sí lo son, por lo que los depredadores suelen evitarlas. Se han llegado a
 * encontrar ejemplares de casi dos metros.
 * Para una distribución inicial de anillos, ¿eres capaz de decir qué colores
 * tendrán después de varias fases de crecimiento?
 * Entrada
 * La entrada estará compuesta de varios casos de prueba. Cada uno empezará con
 * un número entero no negativo que indicará cuantas fases de crecimiento hay
 * que simular. Después vendrá una cadena indicando los colores de los anillos
 * del ejemplar (A para amarillo y N para negro), acabando con la letra C que
 * indica la posición de la cabeza.
 * Ten en cuenta que, en muy raras ocasiones, el crecimiento no sigue el patrón
 * habitual, por lo que las configuraciones iniciales de la entrada
 * nonecesariamente serán alcanzables desde alguno de las dos variedades de
 * nacimiento de los thuelis (un único anillo amarillo o negro).
 * La entrada terminará cuando se reciba un thuelis sin anillos.
 * Salida
 * Para cada caso de prueba el programa deberá indicar, en una línea, la
 * configuración de colores de los anillos tras el número solicitado de fases de
 * crecimiento, asumiendo que todas siguen el patrón habitual descrito. Se
 * usará, como en la entrada, Apara amarillo y N para negro, acabando con la C
 * para la cabeza. No se añadirán espacios en ningún caso.
 * ====
 * 
 * 
 */