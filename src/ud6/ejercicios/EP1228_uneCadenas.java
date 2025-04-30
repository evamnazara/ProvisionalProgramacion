package ejercicios;

import java.util.*;
/*EP1228. Implementa la función uneCadenas, con el siguiente prototipo que devuelve una lista con la concatenación de cad1 y cad2.
List<Character> uneCadenas(List<Character> cad1, List<Character> cad2) */

public class EP1228_uneCadenas {

    // Función que concatena dos listas de caracteres en una nueva lista
    public static List<Character> uneCadenas(List<Character> cadena1, List<Character> cadena2) {
        List<Character> resultadoConcatenado = new ArrayList<>();

        // Añadir todos los caracteres de la primera lista
        resultadoConcatenado.addAll(cadena1);
        // Añadir todos los caracteres de la segunda lista
        resultadoConcatenado.addAll(cadena2);

        return resultadoConcatenado;
    }

    public static void main(String[] args) {
        List<Character> lista1 = Arrays.asList('H', 'o', 'l', 'a');
        List<Character> lista2 = Arrays.asList(' ', 'm', 'u', 'n', 'd', 'o');

        List<Character> resultado = uneCadenas(lista1, lista2);

        System.out.println("Resultado de la concatenación: " + resultado);
    }

}
