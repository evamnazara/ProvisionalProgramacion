package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class MaryPoppins {

    public static void main(String[] args) {
        // Creamos un objeto Scanner para leer la entrada desde el teclado
        Scanner sc = new Scanner(System.in);

        // Leemos el número de casos de prueba
        int casos = sc.nextInt();
        sc.nextLine(); // Limpiamos el buffer de entrada después de leer el número

        // Procesamos cada caso de prueba
        for (int i = 0; i < casos; i++) {
            // Leemos la palabra que se va a invertir
            String palabra = sc.nextLine();

            // Llamamos a la función que invierte la palabra correctamente
            String palabraInvertida = invertirPalabra(palabra);

            // Mostramos el resultado (palabra invertida)
            System.out.println(palabraInvertida);
        }

        // Cerramos el scanner
        sc.close();
    }

    // Función que invierte la palabra correctamente, manteniendo las mayúsculas
    public static String invertirPalabra(String palabra) {
        // Creamos un array de caracteres para almacenar la palabra invertida
        char[] palabraInvertida = new char[palabra.length()];

        // Recorremos la palabra original de atrás hacia adelante
        for (int i = 0; i < palabra.length(); i++) {
            // Tomamos el carácter de la palabra original de derecha a izquierda
            char c = palabra.charAt(palabra.length() - 1 - i);

            // Si el carácter es mayúscula, lo dejamos en mayúscula
            // y si es minúscula, lo dejamos en minúscula
            if (Character.isUpperCase(c)) {
                palabraInvertida[i] = Character.toUpperCase(c);
            } else {
                palabraInvertida[i] = Character.toLowerCase(c);
            }
        }

        // Convertimos el array de caracteres invertido a una cadena
        return new String(palabraInvertida);
    }
}

/*
 * La farsante de Mary Poppins
 * Tiempo máximo: 1,000 s Memoria máxima: 4096 KiB
 * Fotograma de la película 'Mary Poppins'
 * Todo el mundo sabe que para salir airoso de situaciones difíciles, o para
 * explicar cómo se siente se puede recurrir a una palabra:
 * supercalifragilísticoespialidoso. Cuando se escribe en inglés, la palabra es
 * incluso un poco más larga: supercalifragilisticexpialidocious. Y en alemán
 * ¡aún más! superkalifragilistischexpiallegetisch.
 * 
 * Lo que ya no todo el mundo sabe es decirla al revés. Cuando Mary Poppins está
 * hablando inglés, presume de decirla así: dociousaliexpilisticfragicalirepus.
 * ¡Pero eso es claramente trampa! Lo que hace es separar la palabra en bloques,
 * y decir los bloques en orden inverso, salvo el último, al que además invierte
 * las letras.
 * 
 * Sin embargo, cuando está de visita por España, al decir la palabra al revés
 * lo que hace es decir las sílabas de derecha a izquierda, así:
 * sodolipiaescotilisgifralicapersu. ¡Otra vez demuestra que es una farsante!
 * Eso no es decir la palabra al revés…
 * 
 * Sólo cuando el viento del este la lleva a México se esfuerza por hacerlo bien
 * y dice la palabra al revés sin trampa ni cartón, letra a letra:
 * osodilaipseocitsiligarfilacrepus. ¡Por fin, eso sí que es difícil de
 * pronunciar!
 * 
 * Entrada
 * La entrada comenzará con un número indicando el número de casos de prueba que
 * el programa tendrá que procesar.
 * 
 * Cada uno consiste en una línea con una única palabra. Tendrán un máximo de 40
 * letras del alfabeto inglés y todas serán minúsculas salvo, opcionalmente, la
 * primera.
 * 
 * Salida
 * El programa escribirá cada palabra dada la vuelta de verdad, letra a letra
 * como cuando Mary Poppins visita México, manteniendo el uso de las mayúsculas
 * que hubiera en la palabra original.
 * 
 * Entrada de ejemplo
 * 2
 * supercalifragilisticoespialidoso
 * Mary
 * Salida de ejemplo
 * 
 * osodilaipseocitsiligarfilacrepus
 * Yram
 */
