package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class Estrofas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Leemos el número de versos
            System.out.println("Introduce el número de versos (0 para terminar):");
            String lineaNumeroVersos = scanner.nextLine().trim();
            int numeroDeVersos = convertirAEntero(lineaNumeroVersos);

            // Si el número de versos es 0, terminamos el programa
            if (numeroDeVersos == 0) {
                break;
            }

            // Leemos los versos
            String[] versos = new String[numeroDeVersos];
            System.out.println("Introduce los versos:");
            for (int i = 0; i < numeroDeVersos; i++) {
                versos[i] = scanner.nextLine().trim();
            }

            // Identificamos el tipo de estrofa
            String tipoDeEstrofa = identificarEstrofa(versos);
            System.out.println("Tipo de estrofa: " + tipoDeEstrofa);
        }

        scanner.close();
    }

    // Función para convertir un número en String a entero sin usar parseInt()
    public static int convertirAEntero(String numero) {
        int resultado = 0;
        for (int i = 0; i < numero.length(); i++) {
            char digito = numero.charAt(i);
            resultado = resultado * 10 + (digito - '0');
        }
        return resultado;
    }

    // Función principal para identificar el tipo de estrofa
    public static String identificarEstrofa(String[] versos) {
        int numVersos = versos.length;
        String[] rimas = obtenerRimas(versos);

        // Evaluamos diferentes tipos de estrofas dependiendo de la cantidad de versos
        if (numVersos == 2) {
            // Pareado: Rima consonante AA
            if (rimas[0].equals(rimas[1])) {
                return "PAREADO";
            }
        } else if (numVersos == 3) {
            // Terceto: Rima consonante en el primer y último verso (A-A)
            if (rimas[0].equals(rimas[2]) && !rimas[0].equals(rimas[1])) {
                return "TERCETO";
            }
        } else if (numVersos == 4) {
            // Cuarteto: Rima consonante ABBA
            if (rimas[0].equals(rimas[3]) && rimas[1].equals(rimas[2]) && !rimas[0].equals(rimas[1])) {
                return "CUARTETO";
            }
            // Cuarteta: Rima consonante ABAB
            if (rimas[0].equals(rimas[2]) && rimas[1].equals(rimas[3]) && !rimas[0].equals(rimas[1])) {
                return "CUARTETA";
            }
            // Seguidilla: Rima asonante en los pares (-a-a)
            if (esSeguidilla(versos, rimas)) {
                return "SEGUIDILLA";
            }
            // Cuaderna vía: Rima consonante igual en todos los versos (AAAA)
            if (rimas[0].equals(rimas[1]) && rimas[1].equals(rimas[2]) && rimas[2].equals(rimas[3])) {
                return "CUADERNA VIA";
            }
        }

        return "DESCONOCIDO"; // Si no coincide con ningún tipo conocido
    }

    // Obtiene la parte final de la palabra clave para analizar la rima
    public static String[] obtenerRimas(String[] versos) {
        String[] rimas = new String[versos.length];

        for (int i = 0; i < versos.length; i++) {
            String[] palabras = versos[i].split(" "); // Separamos por palabras
            String ultimaPalabra = palabras[palabras.length - 1]; // Tomamos la última palabra

            rimas[i] = extraerRima(ultimaPalabra); // Extraemos la rima de la última palabra
        }

        return rimas;
    }

    // Extrae la parte clave de la rima (desde la última vocal acentuada en
    // adelante)
    public static String extraerRima(String palabra) {
        String vocales = "aeiou";
        int indice = -1;

        // Buscamos la última vocal en la palabra
        for (int i = palabra.length() - 2; i >= 0; i--) {
            if (contieneCaracter(vocales, palabra.charAt(i))) {
                indice = i;
                break;
            }
        }

        // Si encontramos una vocal, extraemos la rima desde esa vocal hasta el final
        if (indice == -1) {
            return palabra;
        }

        return palabra.substring(indice); // Devolvemos la parte desde la última vocal
    }

    // Verifica si la palabra contiene un caracter de las vocales
    public static boolean contieneCaracter(String cadena, char caracter) {
        return cadena.indexOf(caracter) >= 0;
    }

    // Verifica si es una seguidilla (-a-a con rima asonante)
    public static boolean esSeguidilla(String[] versos, String[] rimas) {
        // Verificamos las condiciones para una seguidilla
        if (esRimaAsonante(rimas[1], rimas[3]) && !esRimaConsonante(rimas[1], rimas[3])) {
            return !esRimaAsonante(rimas[0], rimas[1]) && !esRimaAsonante(rimas[2], rimas[3]);
        }
        return false;
    }

    // Verifica si dos palabras riman en asonante (mismas vocales en el mismo orden)
    public static boolean esRimaAsonante(String rima1, String rima2) {
        return extraerVocales(rima1).equals(extraerVocales(rima2));
    }

    // Extrae las vocales de una rima para compararlas
    public static String extraerVocales(String rima) {
        String vocales = "aeiou";
        StringBuilder vocalesExtraidas = new StringBuilder();

        for (int i = 0; i < rima.length(); i++) {
            char letra = rima.charAt(i);
            if (contieneCaracter(vocales, letra)) {
                vocalesExtraidas.append(letra);
            }
        }

        return vocalesExtraidas.toString();
    }

    // Verifica si dos palabras riman en consonante (son exactamente iguales)
    public static boolean esRimaConsonante(String rima1, String rima2) {
        return rima1.equals(rima2);
    }
}

/*
 * /*Estrofas
 * Historial ayer borrado,
 * anteayer hubo pecado.
 * El texto anterior es un pareado: una estrofa con dos versos que riman entre
 * sí con rima consonante. ¿Sabrías hacer un programa que identifique distintos
 * tipos de estrofa?
 * 
 * En concreto, nos bastará con identificar las rimas (no tendremos en cuenta el
 * número de sílabas de cada verso), existiendo dos rimas distintas:
 * 
 * Rima consonante: se dice que entre dos versos hay rima consonante cuando
 * todos los sonidos, tanto vocales como consonantes, riman. Para las
 * comparaciones se tienen en cuenta todos los sonidos a partir de la última
 * vocal acentuada.
 * Rima asonante: similar a la anterior pero únicamente riman las vocales.
 * Por ejemplo, el siguiente cuarteto de Diego de Silva y Mendoza:
 * 
 * Una, dos, tres estrellas, veinte, ciento, (A)
 * mil, un millón, millares de millares, (B)
 * ¡válgame Dios, que tienen mis pesares (B)
 * su retrato en el alto firmamento! (A)
 * tiene esquema ABBA consonante, pues coinciden las vocales y consonantes del
 * primer y último verso, así como las del segundo y tercero.
 * 
 * Nos piden ser capaces de identificar los siguientes tipos de estrofa:
 * 
 * De dos versos:
 * Pareado: rima consonante AA.
 * De tres versos:
 * Terceto: rima consonante en el primer y último verso (A-A). Ten en cuenta que
 * AAA no se considerará terceto.
 * De cuatro versos:
 * Cuarteto: rima consonante ABBA.
 * Cuarteta: rima consonante ABAB.
 * Seguidilla: rima asonante en los pares (-a-a). Ten en cuenta que otras
 * combinaciones con más rimas o con rima consonante en lugar de asonante (por
 * ejemplo -aaa o -A-A) no se consideran seguidillas.
 * Cuaderna via: rima consonante igual en todos los versos (AAAA).
 * Entrada
 * 
 * La entrada estará formada por un número indeterminado de casos de prueba.
 * Cada caso de prueba comienza con una línea que contiene un único entero con
 * el número de versos del siguiente poema. A continuación aparecen tantas
 * líneas como versos contiene la estrofa a analizar. Podemos asumir que la
 * última palabra de cada verso es llana (la vocal acentuada está en la
 * penúltima sílaba), y que ninguno tendrá más de 70 letras. La entrada no
 * contendrá tildes para facilitar la programación, aunque esto signifique
 * cometer errores ortográficos. Tampoco tendremos en cuenta que distintos
 * elementos gráficos pueden tener el mismo sonido. Es decir, un verso terminado
 * en -aba, no rimará de forma consonante con un verso terminado en -ava.
 * 
 * La entrada termina cuando el siguiente caso de prueba contiene 0 versos. Para
 * ese caso de prueba no se generará ninguna salida.
 * 
 * Salida
 * 
 * Para cada caso de prueba el programa indicará el nombre de la estrofa,
 * utilizando mayúsculas (PAREADO, TERCETO, CUARTETO, CUARTETA, SEGUIDILLA,
 * CUADERNA VIA) o la palabra DESCONOCIDO si no conoce la estrofa dada.
 * 
 * Entrada de ejemplo
 * 
 * 2
 * Historial ayer borrado
 * anteayer hubo pecado
 * 2
 * Esto no pega
 * ni con cola.
 * 4
 * Era un simple clerigo, pobre de clerecia,
 * dicie cutiano missa de la sancta Maria;
 * non sabie decir otra, diciela cada dia,
 * mas la sabie por uso qe por sabiduria.
 * 3
 * Un manotazo duro, un golpe helado,
 * un hachazo invisible y homicida,
 * un empujon brutal te ha derribado.
 * 0
 * Salida de ejemplo
 * 
 * PAREADO
 * DESCONOCIDO
 * CUADERNA VIA
 * TERCETO
 */