package ud6.repasoexamen.genericos;

import java.util.*;

public class UtilGenerico {
    // (1) Método genérico repetidos() que reciba una lista de elementos y devuelva
    // una copia de la lista original pero eliminando los elementos que aparecen
    // sólo una vez.

    public static <T> List<T> repetidos(List<T> lista) {
        List<T> soloRepetidos = new ArrayList<>();

        for (T elemento : lista) {
            // si el indice es el ultimo, solo esta 1 vez
            if (lista.indexOf(elemento) != lista.lastIndexOf(elemento)) {
                soloRepetidos.add(elemento);
            }
        }

        return soloRepetidos;

    }

    // Método genérico filtrarMayores() que recibe como parámetros de entrada unha
    // colección de elementos de un tipo T, un elemento del mismo tipo y un
    // comparator y devuelve una subcolección con los elementos de la colección
    // original que sean mayores o iguales que el recibido según el criterio del
    // comparator. Crea un pequeño programa principal en la propia clase
    // UtilGenerico que muestre ejemplos de uso de los métodos creados.

    public static <T> Collection<T> filtrarMayores(Collection<T> coleccion, T valor, Comparator<T> comp) {
        Collection<T> resultante = new ArrayList<>();

        // se reocrre la lista
        for (T e : coleccion) {
            // se comparan, el resultado tiene q ser mayor a 0
            if (comp.compare(e, valor) >= 0) {
                resultante.add(e);
            }
        }

        return resultante;

    }

    public static void main(String[] args) {
        Integer[] t = { 1, 2, 1, 3, 5, 5, 6, 7, 8, 9, 10 };

        // 1
        System.out.println(Arrays.asList(t));
        System.out.println(repetidos(Arrays.asList(t)));

        // 2
        Comparator<Integer> comp = Comparator.naturalOrder();
        // saca solo los mayores q 4
        System.out.println(filtrarMayores(Arrays.asList(t), 4, comp));
    }
}
