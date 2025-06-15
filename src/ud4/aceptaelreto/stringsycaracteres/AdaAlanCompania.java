package ud4.aceptaelreto.stringsycaracteres;

public class AdaAlanCompania {

    public static void main(String[] args) {
        // Declaramos un array con los casos de prueba
        String[] casos = { "ada", "alan", "babbage", "john" };

        // Recorremos cada caso de prueba
        for (String caso : casos) {
            // Encontrar la longitud del palíndromo más largo
            int longitudPalindromo = encontrarPalindromoMasLargo(caso);
            // Imprimir el resultado
            System.out.println(longitudPalindromo);
        }
    }

    // Función que devuelve la longitud del palíndromo más largo dentro de una
    // palabra
    public static int encontrarPalindromoMasLargo(String palabra) {
        int longitudMaxima = 1; // La longitud mínima de un palíndromo es 1 (una sola letra)

        // Recorremos todas las posibles posiciones de inicio de una subcadena
        for (int i = 0; i < palabra.length(); i++) {
            // Probar subcadenas de longitud variable, desde 1 hasta el final de la palabra
            for (int j = i + 1; j <= palabra.length(); j++) {
                // Obtenemos la subcadena entre i y j
                String subcadena = palabra.substring(i, j);

                // Si la subcadena es un palíndromo y su longitud es mayor a la máxima
                // encontrada
                if (esPalindromo(subcadena) && subcadena.length() > longitudMaxima) {
                    longitudMaxima = subcadena.length();
                }
            }
        }

        return longitudMaxima;
    }

    // Función que verifica si una cadena es un palíndromo
    public static boolean esPalindromo(String subcadena) {
        int inicio = 0;
        int fin = subcadena.length() - 1;

        // Comprobamos si el primer y último carácter son iguales, y repetimos con los
        // caracteres internos
        while (inicio < fin) {
            if (subcadena.charAt(inicio) != subcadena.charAt(fin)) {
                return false; // Si encontramos una diferencia, no es un palíndromo
            }
            inicio++;
            fin--;
        }

        return true; // Si llegamos hasta aquí, es un palíndromo
    }
}

/*
 * Ada, Alan y compañía
 * Tiempo máximo: 2,000 s Memoria máxima: 8192 KiB
 * Ada Byron mirándose en un espejo
 * Cuando iba a las fiestas de la alta sociedad, a Ada le gustaba impresionar a
 * los maridos de sus amigas hablándoles de las palabras palíndromas.
 * "Los palíndromos —les decía— son palabras o frases que se leen igual de izquierda a derecha que de derecha a izquierda"
 * . Les ponía ejemplos como "seres", "somos" de 5 letras, o, más largas,
 * "acurruca" de 8 y "reconocer" de 9. Y siempre acababa su disertación
 * presumiendo de que su propio nombre, Ada, era también palíndromo.
 * 
 * Alan solía acompañarla en esas situaciones e, intentando quedar por encima
 * para impresionar aún más, siempre afirmaba que su nombre era todavía mejor.
 * Desde niño había sido aficionado a los códigos y las frases ocultas, y estaba
 * orgulloso de que su nombre no fuera palíndromo pero ocultara uno en su
 * interior, "ala".
 * 
 * Pero los dos se cuidaban mucho de presumir cuando su amigo Charles estaba
 * cerca. La primera vez que intentaron impresionarle, al fin y al cabo Charles
 * sólo esconde palíndromos triviales de longitud 1, salieron los dos
 * escaldados.
 * "Queridos —les replicó— mi nombre será vulgar pero mi apellido, Babbage, es mejor que vuestros nombres. No oculta uno, sino tres palíndromos no triviales, y además uno es de mayor longitud que los vuestros"
 * . Y no le faltaba razón. Si se buscan, se pueden encontrar "bb", "bab" y
 * "abba", el más largo de todos.
 * 
 * John, amigo de los tres, siempre esquivaba las discusiones sobre palíndromos.
 * Odiaba los juegos en los que siempre perdía.
 * 
 * Entrada
 * El programa deberá procesar múltiples casos de prueba, cada uno en una línea.
 * Cada caso de prueba contendrá una sucesión de un mínimo de 1 y un máximo de
 * 2.000 letras minúsculas del alfabeto inglés, sin símbolos especiales ni
 * espacios.
 * 
 * Salida
 * El programa debe indicar, en líneas independientes, la longitud del
 * palíndromo más largo que contiene la sucesión de letras de cada caso de
 * prueba.
 * 
 * Entrada de ejemplo
 * ada
 * alan
 * babbage
 * john
 * Salida de ejemplo
 * 3
 * 3
 * 4
 * 1
 */