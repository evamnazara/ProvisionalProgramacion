package ud6.practicasgenericos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class practicasGenericos {

    /*
     * Crea un método genérico sinDuplicadosOrdenados() que reciba una colección de
     * elementos de tipo T, y devuelva una nueva colección con los elementos sin
     * duplicados y ordenados alfabéticamente o numéricamente según el orden natural
     * de los elementos.
     * Puedes asumir que T implementa Comparable<T>.
     */
    public static <T> Collection<T> sinDuplicadosOrdenados(Collection<T> coleccion) {
        Set<T> sinRepetidos = new TreeSet<>(coleccion);
        return sinRepetidos;
    }

    // EJERCICIO 2
    /*
     * (2) Método genérico interseccion()
     * Implementa un método genérico interseccion() que reciba dos colecciones de
     * tipo T y devuelva una colección con los elementos comunes a ambas
     * colecciones, sin repetirlos.
     */

    public static <T> Collection<T> interseccion(Collection<T> conjunto1, Collection<T> conjunto2) {
        Set<T> interseccion = new TreeSet<>(conjunto2);
        interseccion.retainAll(conjunto1);
        return interseccion;
    }

    // EJERCICIO 3
    /*
     * Define un método genérico filtrarMenores() similar a filtrarMayores() pero
     * que devuelva los elementos menores o iguales que un valor dado, utilizando un
     * Comparator<T>.
     */

    public static <T> Collection<T> filtrarMenores(Collection<T> coleccion, T valor, Comparator<T> comparador) {
        Collection<T> resultado = new ArrayList<>();

        for (T elemento : coleccion) {
            if (comparador.compare(elemento, valor) >= 0) {
                resultado.add(elemento);
            }
        }
        return resultado;
    }

    // EJERCICIO 4
    /*
     * Crea un método genérico contarFrecuencias() que reciba una colección de
     * elementos de tipo T y devuelva un Map<T, Integer> donde cada clave sea un
     * elemento de la colección y el valor asociado sea el número de veces que
     * aparece.
     */

    public static <T> Map<T, Integer> contarFrecuencias(Collection<T> coleccion) {
        Map<T, Integer> frecuencias = new HashMap<>();

        for (T elemento : coleccion) {
            frecuencias.put(elemento, frecuencias.getOrDefault(elemento, 0) + 1);
        }
        return frecuencias;
    }

    public static <T> void contarFrecuenciasSinMap(Collection<T> coleccion) {
        List<T> yaProcesados = new ArrayList<>();

        for (T elemento : coleccion) {
            if (!yaProcesados.contains(elemento)) {
                int contador = 0;

                for (T otro : coleccion) {
                    if (elemento.equals(otro)) {
                        contador++;
                    }
                }

                System.out.println(elemento + " aparece " + contador + " veces.");
                yaProcesados.add(elemento); // Para no contar el mismo elemento otra vez
            }
        }
    }

    public static void main(String[] args) {
        // ejercicio 1
        List<String> palabras = Arrays.asList("casa", "perro", "gato", "casa", "perro");
        System.out.println(sinDuplicadosOrdenados(palabras));
        // Salida esperada: [casa, gato, perro]

        // ejercicio 2
        List<Integer> l1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> l2 = Arrays.asList(3, 4, 4, 5, 6);
        System.out.println(interseccion(l1, l2));
        // Salida esperada: [3, 4, 5]

        // ejercicio 3
        Comparator<Double> comp = Comparator.naturalOrder();
        List<Double> numeros = Arrays.asList(4.5, 2.3, 6.7, 1.1);
        System.out.println(filtrarMenores(numeros, 4.0, comp));
        // Salida esperada: [2.3, 1.1]

        // ejercicio 4
        List<Character> letras = Arrays.asList('a', 'b', 'a', 'c', 'b', 'a');
        System.out.println(contarFrecuencias(letras));
        // Salida esperada: {a=3, b=2, c=1}

        // ejercicio 5
        contarFrecuenciasSinMap(letras);
        // Salida esperada:
        // a aparece 3 veces.
        // b aparece 2 veces.
        // c aparece 1 veces.
    }
}
