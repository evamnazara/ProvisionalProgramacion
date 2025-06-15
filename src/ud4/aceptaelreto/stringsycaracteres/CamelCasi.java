package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class CamelCasi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de casos de prueba, pero sin parseo
        String line = scanner.nextLine();

        // Mientras la línea no esté vacía
        while (!line.equals("")) {
            // Como no vamos a hacer parseo, la cantidad de identificadores es la longitud
            // de la cadena (para simplificar)
            String[] identificadores = new String[Integer.parseInt(line)];

            // Leer cada uno de los identificadores y corregirlos
            for (int i = 0; i < identificadores.length; i++) {
                identificadores[i] = scanner.nextLine().trim();
                // Convertir cada identificador a formato camelCase
                String corregido = convertirACamelCase(identificadores[i]);
                System.out.println(corregido);
            }

            // Separador entre casos de prueba
            System.out.println("---");

            // Leer la siguiente línea para el siguiente caso de prueba
            line = scanner.nextLine();
        }

        scanner.close(); // Cerrar el scanner
    }

    // Función que convierte una cadena a formato CamelCase
    public static String convertirACamelCase(String variable) {
        // La variable que almacena el resultado final
        String resultado = "";

        // Variable para saber cuándo estamos en el inicio de una palabra
        boolean nuevaPalabra = true;

        // Recorrer cada caracter de la variable
        for (int i = 0; i < variable.length(); i++) {
            char caracter = variable.charAt(i);

            // Si es el inicio de una nueva palabra, la letra debe ser mayúscula
            if (nuevaPalabra) {
                resultado += Character.toUpperCase(caracter);
                nuevaPalabra = false; // Ya no estamos en el inicio de una nueva palabra
            } else {
                // Si no es el inicio de una nueva palabra, la letra será minúscula
                resultado += Character.toLowerCase(caracter);
            }
        }

        return resultado;
    }
}

/*
 * CamelCasi
 * Tiempo máximo: 1,000 s Memoria máxima: 4096 KiB
 * Camello andando, con la imagen cortada intencionadamente (la cabeza queda
 * fuera de la imagen, a la derecha)
 * En programación es habitual utilizar el estilo camel case para escribir los
 * nombres de variables que concatenan varias palabras. La norma de estilo
 * indica que la primera letra de cada una de las palabras concatenadas debe ser
 * mayúscula, mientras que el resto deben escribirse en minúscula. Algunos
 * ejemplos de nombres de variables utilizando esta notación son CamelCase,
 * AdaByron o ConcursoDeProgramacion.
 * 
 * Jaime ha decidido utilizar el estilo camel case para nombrar todas sus
 * variables. Sin embargo ha cometido errores al teclear, y algunas de las
 * letras que deberían ser mayúsculas aparecen en minúscula. Como consecuencia
 * el compilador ha mostrado un montón de errores, y Jaime ha decidido llamar a
 * su estilo camel casi.
 * 
 * Entrada
 * La entrada está formada por distintos casos de prueba, cada uno ocupando
 * varias líneas.
 * 
 * Cada caso de prueba comienza el número N de identificadores que hay en el
 * programa (1 ≤ N ≤ 1.000). A continuación aparecen N líneas con los
 * identificadores (de hasta 50 caracteres) en formato camel casi. Todas las
 * variables aparecen al menos una vez bien escritas (en formato camel case
 * correcto). Además no existen dos variables que se diferencien sólo en el uso
 * de mayúsculas. Por ejemplo las cadenas AdaByron y adaByron se refieren a la
 * misma variable.
 * 
 * Salida
 * Para cada identificador de la entrada en formato camel casi se imprimirá una
 * línea con el nombre de la variable en formato camel case.
 * 
 * El final de cada caso de prueba vendrá seguido de una línea con tres guiones,
 * ---.
 * 
 * Entrada de ejemplo
 * 2
 * AdaByron
 * adabyron
 * 4
 * camelcase
 * concursoDeProgramacion
 * CamelCase
 * camelCase
 * Salida de ejemplo
 * AdaByron
 * AdaByron
 * ---
 * CamelCase
 * concursoDeProgramacion
 * CamelCase
 * CamelCase
 * ---
 */