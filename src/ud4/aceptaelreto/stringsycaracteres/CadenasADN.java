package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class CadenasADN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Procesar cada caso de prueba
        while (sc.hasNextLine()) {
            // Leer el número de cadenas de ADN
            String primeraLinea = sc.nextLine();
            int cantidadCadenas = convertirAEntero(primeraLinea);

            // Caso base para terminar el programa si no hay cadenas
            if (cantidadCadenas == 0) {
                break;
            }

            // Leer las cadenas de ADN
            String[] cadenasADN = new String[cantidadCadenas];
            for (int i = 0; i < cantidadCadenas; i++) {
                cadenasADN[i] = sc.nextLine();
            }

            // Array para contar coincidencias
            int[] conteo = new int[cantidadCadenas];

            // Comparar cada cadena con las demás
            for (int i = 0; i < cantidadCadenas; i++) {
                for (int j = i + 1; j < cantidadCadenas; j++) {
                    if (esPosibleCoincidencia(cadenasADN[i], cadenasADN[j])) {
                        conteo[i]++;
                        conteo[j]++;
                    }
                }
            }

            // Imprimir el resultado de coincidencias para cada cadena
            for (int i = 0; i < cantidadCadenas; i++) {
                if (i > 0) {
                    System.out.print(" ");
                }
                System.out.print(conteo[i]);
            }
            System.out.println(); // Nueva línea al final de cada caso
        }

        sc.close();
    }

    // Convierte un String numérico a entero sin usar parseInt()
    public static int convertirAEntero(String numero) {
        int resultado = 0;
        for (int i = 0; i < numero.length(); i++) {
            char digito = numero.charAt(i);
            resultado = resultado * 10 + (digito - '0'); // Convertir cada caracter en un número
        }
        return resultado;
    }

    // Verifica si dos cadenas de ADN pueden pertenecer al mismo individuo
    public static boolean esPosibleCoincidencia(String adn1, String adn2) {
        int longitud = adn1.length();

        // Compara los nucleótidos de ambas cadenas
        for (int i = 0; i < longitud; i++) {
            char nucleotido1 = adn1.charAt(i);
            char nucleotido2 = adn2.charAt(i);

            // Si ambos nucleótidos son conocidos (no guion) y no coinciden, no son
            // compatibles
            if (nucleotido1 != '-' && nucleotido2 != '-' && nucleotido1 != nucleotido2) {
                return false;
            }
        }
        return true;
    }
}

/*
 * CADENAS ADN
 * 
 * Comparando cadenas de ADN
 * Tiempo máximo: 3,000-4,000 s Memoria máxima: 196608 KiB
 * El ADN (o en su nombre largo el ácido desoxirribonucleico) es apasionante. Es
 * una molécula clave para los seres vivos que contiene la información para
 * construir otros componentes celulares. Además es la responsable de la
 * transmisión hereditaria y de que los hijos se parezcan a sus padres.
 * 
 * Gracias a esa transmisión hereditaria, el análisis del ADN ha servido a los
 * científicos para desentrañar muchos misterios. Por ejemplo, gracias a algunos
 * proyectos científicos se han podido rastrear migraciones humanas de hace
 * miles de años en base a las similitudes y diferencias entre el ADN encontrado
 * en distintos yacimientos. Sin irnos tan lejos, 135 años después de que
 * tuvieran lugar los crímenes del famoso Jack el Destripador a finales del
 * siglo XIX, varios científicos aseguraron tener pruebas de ADN que podrían
 * demostrar su identidad. Las pruebas se basaban en la comparación entre una
 * muestra de ADN recogida de ropa conservada del asesino y el ADN de un
 * descendiente de uno de los sospechosos que barajó en su momento Scotland
 * Yard.
 * 
 * El hecho de que el ADN de una persona sea único (exceptuando hermanos
 * gemelos) hace que sirva también a la policía forense para esclarecer crímenes
 * mucho más cercanos. Si se compara ADN encontrado en el lugar del crimen con
 * el ADN de un sospechoso y resultan ser iguales, el sospechoso tendrá que dar
 * muchas más explicaciones para salirse sin una sentencia en contra.
 * 
 * No obstante, determinar si dos muestras de ADN son de la misma persona no es
 * tarea fácil pues las muestras que se recogen no están siempre completas. Para
 * entenderlo mejor diremos que una cadena de ADN está compuesta por cuatro
 * tipos de nucleótidos: Adenina, Citosina, Guanina y Timina (A, C, G y T). En
 * un mundo ideal, si nos dan dos cadenas de ADN con la lista ordenada de
 * nucleótidos que tiene cada una, basta comparar si los caracteres coinciden.
 * En la práctica no es tan fácil pues muchas veces algunos de los nucleótidos
 * se han perdido (principalmente en las esquinas).
 * 
 * Dada una serie de cadenas de ADN, para cada una de ellas ¿cuántas de las
 * otras podrían pertenecer al mismo individuo?
 * 
 * Entrada
 * 
 * La entrada estará formada por distintos casos de prueba. Cada uno comienza
 * con una línea que indica el número de cadenas de ADN que se darán (hasta
 * 40.000). A continuación vendrá una línea con cada una de las cadenas, todas
 * con la misma longitud (como mucho 50 caracteres).
 * 
 * Cada cadena de ADN tendrá los caracteres A, C, G y T indicando el nucleótido
 * colocado en esa posición o un guión (-) indicando un hueco (nucleótido
 * desconocido) en la cadena. De haber huecos o guiónes estos estarán colocados
 * principalmente en los laterales de la cadena; en la parte central nunca habrá
 * más de 2.
 * 
 * Dos cadenas pueden pertenecer al mismo individuo si en las posiciones en las
 * que ambas tienen nucleótido conocido, este coincide.
 * 
 * Salida
 * 
 * Por cada caso de prueba se escribirá una línea con tantos números como
 * cadenas de ADN se han dado. El número en la posición i indicará cuántas
 * cadenas iguales a la cadena colocada en la posición i hay (sin contar a ella
 * misma), teniendo en cuenta que los guiones se consideran igual a cualquier
 * otro nucleótido (o a otro guión)
 * 
 * Entrada de ejemplo
 * 
 * 3
 * --AAA-
 * ------
 * -TTT--
 * 4
 * AAA
 * -AA
 * AA-
 * ---
 * 1
 * ACGT
 * 
 */