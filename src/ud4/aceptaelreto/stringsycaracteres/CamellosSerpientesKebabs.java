package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class CamellosSerpientesKebabs {

    public static void main(String[] args) {
        // Crear un scanner para leer la entrada
        Scanner sc = new Scanner(System.in);

        // Leer y procesar cada línea de entrada
        while (sc.hasNextLine()) {
            // Leer la línea de entrada
            String input = sc.nextLine();

            // Si la entrada es "XXX" significa el fin del programa
            if (input.equals("XXX")) {
                break;
            }

            // Separar el nombre de la variable y el tipo de notación a la que se quiere
            // convertir
            String[] parts = input.split(" ");
            String variable = parts[0];
            String notation = parts[1];

            // Imprimir la variable convertida en el formato adecuado
            if (notation.equals("CamelCase")) {
                System.out.println(toCamelCase(variable));
            } else if (notation.equals("snake_case")) {
                System.out.println(toSnakeCase(variable));
            } else if (notation.equals("kebab-case")) {
                System.out.println(toKebabCase(variable));
            }
        }

        // Cerrar el scanner
        sc.close();
    }

    // Función para convertir una variable en UpperCamelCase
    private static String toCamelCase(String variable) {
        String result = "";

        // Dividir la variable en palabras usando "_" o "-" como delimitadores
        String[] words = variable.split("[-_]");

        // Convertir la primera palabra en minúsculas y las demás en mayúsculas
        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                result += words[i].toLowerCase(); // Primera palabra en minúsculas
            } else {
                result += words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase(); // Palabras
                                                                                                        // siguientes
                                                                                                        // con la
                                                                                                        // primera letra
                                                                                                        // en mayúscula
            }
        }

        return result;
    }

    // Función para convertir una variable a snake_case
    private static String toSnakeCase(String variable) {
        String result = "";

        // Convertir todo el texto a minúsculas y separar las palabras por "_"
        for (int i = 0; i < variable.length(); i++) {
            char ch = variable.charAt(i);

            // Si encontramos una mayúscula, la convertimos a minúscula y añadimos "_"
            if (Character.isUpperCase(ch)) {
                if (i > 0) {
                    result += "_"; // Añadir guion bajo entre las palabras
                }
                result += Character.toLowerCase(ch);
            } else {
                result += ch; // Dejar las letras minúsculas tal como están
            }
        }

        return result;
    }

    // Función para convertir una variable a kebab-case
    private static String toKebabCase(String variable) {
        String result = "";

        // Convertir todo el texto a minúsculas y separar las palabras por "-"
        for (int i = 0; i < variable.length(); i++) {
            char ch = variable.charAt(i);

            // Si encontramos una mayúscula, la convertimos a minúscula y añadimos "-"
            if (Character.isUpperCase(ch)) {
                if (i > 0) {
                    result += "-"; // Añadir guion medio entre las palabras
                }
                result += Character.toLowerCase(ch);
            } else {
                result += ch; // Dejar las letras minúsculas tal como están
            }
        }

        return result;
    }
}

/*
 * Camellos, serpientes y kebabs
 * 
 * 
 * Lador, el "compi" con quien hago las prácticas de programación, me dice que
 * hay que poner nombres de variables significativos, que ayuden a entender qué
 * guarda cada una. Siempre me critica si uso identificadores como i, otra o
 * aux.
 * 
 * Para darle un escarmiento, intenté poner una variable que se llamaba suma de
 * los impares menores que n. Pero el compilador me gritó cosas muy feas que no
 * entendí. Cuando preguntamos a la profesora nos dijo que no se podían poner
 * espacios en los nombres. Si queríamos poner nombres con varias palabras
 * (aunque nos dijo que no pusiéramos tantas) entonces teníamos que usar algún
 * truco para que el nombre se leyera bien sin los espacios.
 * 
 * Nos contó que hay varias formas, y se usa una u otra dependiendo de las
 * preferencias personales, o del convenio usado en el lenguaje. Y nos soltó un
 * sermón sobre las mayúsculas del camello, serpientes y kebabs que nos dejaron
 * muy confundidos. Buscando luego en Internet vimos que hay principalmente tres
 * opciones:
 * 
 * CamelCase: la primera letra de cada palabra se escribe en mayúscula. Hay dos
 * alternativas, UpperCamelCase y lowerCamelCase dependiendo de si la primera
 * letra de la primera palabra va también en mayúscula o no. ¡Esta es la que más
 * se utiliza!
 * snake_case: todas las letras van en minúscula, y las palabras se separan por
 * un guión bajo (_). Se utilizaba en C, y todavía sobrevive en algunos sitios.
 * kebab-case: como antes, todas las letras van en minúscula, pero ahora las
 * palabras se separan por un guión medio (-). En muchos lenguajes de
 * programación no se puede usar, porque el - se confunde con el signo de la
 * resta y no es válido. Se usa en Lisp (el lenguaje de los paréntesis).
 * Lo peor de todo fue que a Lador, después de que la profesora nos contara todo
 * esto, se le ocurrió la feliz idea de preguntarle cuántos espacios utilizar
 * para sangrar el código, y en qué línea colocar las llaves. Al final,
 * terminamos perdiendo el autobús.
 * 
 * Entrada
 * Cada caso de prueba es un nombre de variable en alguna de las tres notaciones
 * anteriores seguida de la notación a la que se quiere convertir (CamelCase,
 * snake_case o kebab-case).
 * 
 * Ningún nombre de variable tendrá más de 20 caracteres y se garantiza que será
 * correcta en alguna de las notaciones.
 * 
 * Salida
 * Para cada caso de prueba se escribirá el nombre de la variable en la notación
 * solicitada. Tanto en la entrada como en la salida se utilizará UpperCamelCase
 * (y no lowerCamelCase).
 * 
 * Entrada de ejemplo
 * MiVar snake_case
 * es_primo kebab-case
 * suma-de-impares CamelCase
 * j CamelCase
 * Salida de ejemplo
 * 
 * mi_var
 * es-primo
 * SumaDeImpares
 * J
 */
