package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class Trifelios {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leer el número de casos de prueba
        System.out.println("num casos de prueba:");
        int numCasos = sc.nextInt();
        sc.nextLine(); // Para consumir el salto de línea después del número de casos

        // Procesar cada caso de prueba
        for (int i = 0; i < numCasos; i++) {
            // Leer las dos palabras
            String palabra1 = sc.nextLine().toLowerCase(); // Convertimos a minúsculas
            String palabra2 = sc.nextLine().toLowerCase(); // Convertimos a minúsculas

            // Sustituir 'b' por 'v' en ambas palabras
            palabra1 = palabra1.replace('b', 'v');
            palabra2 = palabra2.replace('b', 'v');

            // Comparar las palabras
            if (palabra1.equals(palabra2) && !palabra1.equals(sc.nextLine())) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        }

        // Cerrar el scanner
        sc.close();
    }
}

/*
 * Trifelios
 * 
 * Monja con un jamón
 * Aunque poca gente sabe lo que es un trifelio, casi todo el mundo conoce al
 * menos uno: "monja". Como todos los niños saben, si se repite rápidamente esa
 * palabra muchas veces, aparece otra distinta, "jamón".
 * 
 * Hay muchas otras parejas de palabras que tienen esta misma propiedad, como
 * "copa" y "Paco", "mora" y "amor" o "diosa" y "adiós".
 * 
 * Otras requieren cambios ortográficos (más allá de las tildes) como "carro" y
 * "roca", "llave" y "bella" o "labio" y "viola".
 * 
 * Por último, también existen algunas parejas que son trifelios al escribirlos,
 * pero no al decirlos, ya sea por cambio de fonética o de entonación (o ambas),
 * como "cogeré" y "recoge" o "encuadernaré" y "reencuaderna". Los llamamos
 * trifelios ortográficos.
 * 
 * Entrada
 * La entrada comienza con el número de casos de prueba que se deberán procesar.
 * Cada caso ocupará una línea independiente y contendrá dos palabras de no más
 * de 20 letras. Aunque suponga fallos ortográficos, por simplicidad ninguna
 * vocal llevará tilde.
 * 
 * Salida
 * Para cada caso de prueba se escribirá "SI" si la pareja de palabras es un
 * trifelio, y "NO" en otro caso.
 * 
 * Dado que fonéticamente la 'b' y la 'v' son similares, deben considerarse
 * iguales. De nuevo por simplicidad, el resto de idiosincrasias del español
 * deberán ignorarse y considerar por tanto únicamente los trifelios
 * ortográficos. Ten en cuenta que una palabra no forma un trifelio consigo
 * misma ni, en este problema, con sus posibles variaciones de 'b' y 'v'.
 * 
 * Entrada de ejemplo
 * 5
 * monja jamon
 * Paco copa
 * carro roca
 * lavese Besela
 * vota bota
 * Salida de ejemplo
 * SI
 * SI
 * NO
 * SI
 * NO
 */
