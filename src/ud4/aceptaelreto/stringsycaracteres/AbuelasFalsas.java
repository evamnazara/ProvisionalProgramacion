package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class AbuelasFalsas {
    /*
     * public static void main(String[] args) {
     * Scanner sc = new Scanner(System.in);
     * 
     * System.out.println("Nombre real del nieto:");
     * String nombreNieto = sc.nextLine();
     * sc.nextLine(); // <-- limpia el buffer
     * System.out.println("Numero de veces dicho:");
     * int numeroNombres = sc.nextInt();
     * 
     * String[] nombresDichos = new String[numeroNombres];
     * 
     * System.out.println("Nombres dichos por la abuela");
     * for (int i = 0; i < nombresDichos.length; i++) {
     * nombresDichos[i] = sc.nextLine();
     * }
     * 
     * // ver si el nombre del nieto es el ultimo
     * 
     * if (nombreNieto.equals(nombresDichos[numeroNombres - 1])) {
     * System.out.println("VERDADERO");
     * } else {
     * System.out.println("FALSO");
     * }
     * 
     * }
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Numero pruebas:");
        int numero = sc.nextInt();

        // Leer y procesar cada prueba
        for (int i = 0; i < numero; i++) {
            // Leer el nombre real del nieto y la cantidad de nombres que dijo la abuela
            System.out.println("Nombre real del nieto: ");
            String nombreReal = sc.next();

            System.out.println("Cantidad de nombres:");
            int cantidadNombres = sc.nextInt();

            // Leer los nombres dichos por la abuela
            System.out.println("Nombres dichos por la abuela: ");
            String[] nombresDichos = new String[cantidadNombres];
            for (int j = 0; j < cantidadNombres; j++) {
                nombresDichos[j] = sc.next();
            }

            // Verificar si el nombre real está al final de la lista de nombres dichos
            if (nombresDichos[cantidadNombres - 1].equals(nombreReal)) {
                // Si el último nombre es el nombre real, la abuela es verdadera
                System.out.println("VERDADERA");
            } else {
                // Si no es así, la abuela es falsa
                System.out.println("FALSA");
            }
        }
        // Cerrar el scanner
        sc.close();
    }

}

/*
 * Abuelas falsas
 * Hay una conjetura que dice que todas las abuelas del mundo cuando van a decir
 * el nombre de un nieto, dicen primero el nombre de muchos otros nietos antes
 * de decir el nombre correcto.
 * 
 * El gobierno ha ideado una prueba para saber si una persona mayor es abuela o
 * no. La prueba consiste en enseñar una foto de un nieto y preguntar cómo se
 * llama ese nieto, anotando los nombres que dice la mujer.
 * 
 * Si la mujer sólo ha dicho el nombre del nieto al final de la lista de nombres
 * se considera que es una abuela verdadera, en caso contrario es una falsa
 * abuela.
 * 
 * Entrada
 * La entrada comienza por el número N de pruebas realizadas a distintas
 * personas mayores.
 * 
 * Cada una de esas pruebas ocupa una única línea. Comienza con el nombre real
 * del nieto de la foto. A continuación viene un número positivo que indica la
 * cantidad de nombres que dijo la abuela en cuestión (como mucho 100), al que
 * le sigue cada uno de esos nombres.
 * 
 * Para evitar confusiones, tanto el nombre real como los nombres dichos por las
 * abuelas aparecerán siempre en minúsculas y no contendrán espacios ni tildes o
 * eñes. La longitud de cada nombre no excederá los 10 caracteres.
 * 
 * Salida
 * Por cada prueba se escribirá una única línea con la cadena VERDADERA si la
 * persona encuestada es una abuela real y FALSA si es una farsante.
 * 
 * Entrada de ejemplo
 * 3
 * mireia 5 ximo vicente maria vicente mireia
 * juan 2 juan maria
 * ximo 1 ximo
 * Salida de ejemplo
 * 
 * VERDADERA
 * FALSA
 * FALSA
 */