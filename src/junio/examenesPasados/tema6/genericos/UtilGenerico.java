package junio.examenesPasados.tema6.genericos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class UtilGenerico {

    /*
     * (1) Método genérico contarCoincidencias() que reciba dos colecciones de
     * elementos y devuelva el número de elementos únicos (no repetidos) que existen
     * en
     * ambas colecciones.
     */

    // se declara asi
    public static <T> int contarCoincidencias(Collection<T> c1, Collection<T> c2) {
        Set<T> coincidencias = new TreeSet<>();

        // lo que el ide pone como Object, se cambia por T para que no de el aviso en el
        // add
        // original: for (Object object : c1)
        for (T object : c1) {
            if (c2.contains(object)) {
                coincidencias.add(object);
            }
        }

        // System.out.println(coincidencias);
        int num = coincidencias.size();
        return num;

    }

    /*
     * 2. (2) Método genérico invertirOrden()que recibe un Map<K, V> y devuelve un
     * nuevo Map<V, List<K>> donde:
     * a. Las claves son los valores del mapa sin repetir.
     * b. Los valores son listas de claves originales asociadas a ese valor.
     * Ejemplo: Mapa original: {1="a", 2="b", 3="a"} Resultado: {"a"=[1, 3],
     * "b"=[2]}
     */

    public static <K, V> Map<V, List<K>> invertirOrden(Map<K, V> mapa) {
        Map<V, List<K>> mapaInvertido = new HashMap<>();

        for (Map.Entry<K, V> entrada : mapa.entrySet()) {
            K clave = entrada.getKey();
            V valor = entrada.getValue();

            // Si el valor ya está como clave, añadimos la clave a su lista
            if (!mapaInvertido.containsKey(valor)) {
                mapaInvertido.put(valor, new ArrayList<>());
            }
            mapaInvertido.get(valor).add(clave);
        }

        return mapaInvertido;

        /*
         * ESTA SOLUCION esta MEDIO BIEN, pero al tener un solo elemteno, la salida pisa
         * los valores si se repiten
         * Map mapaInvertido = new HashMap<>();
         * 
         * List listaClaves = new ArrayList<>(mapa.keySet());
         * List listaElemetos = new ArrayList<>(mapa.values());
         * 
         * for (int i = 0; i < listaClaves.size(); i++) {
         * mapaInvertido.put(listaElemetos.get(i), listaClaves.get(i));
         * }
         * return mapaInvertido;
         */

    }

    /*
     * C
     * 1. (1) Método genérico repetidos() que reciba una lista de elementos y
     * devuelva
     * una copia de la lista original pero eliminando los elementos que aparecen
     * sólo una
     * vez.
     */

    public static <T> Set<T> repetidos(List<T> elementos) {
        Set<T> repetidosUnaVez = new HashSet<T>();

        for (T elemento : elementos) {
            if (elementos.indexOf(elemento) == (elementos.lastIndexOf(elemento))) {
                repetidosUnaVez.add(elemento);
            }
        }

        return repetidosUnaVez;
    }

    /*
     * 2. (2) Método genérico filtrarMayores() que recibe como parámetros de entrada
     * unha colección de elementos de un tipo T, un elemento del mismo tipo y un
     * comparator y devuelve una subcolección con los elementos de la colección
     * original
     * que sean mayores o iguales que el recibido según el criterio del comparator.
     */
    // NO OLVIDAR EL ELEMENTO
    public static <T> Collection<T> filtrarMayores(Collection<T> col, T valor, Comparator<T> comp) {
        Collection<T> resultado = new ArrayList<>();

        // el comparator devuelve un num positivo si es mayor
        for (T elemento : col) {
            if (comp.compare(elemento, valor) >= 0) {
                resultado.add(elemento);
            }
        }

        return resultado;

    }

    public static void main(String[] args) {
        // poner los tipos... como arriba son <T> da igual lo que se ponga aqui
        Collection<String> c1 = new ArrayList<>(Arrays.asList("Eren", "Kaneki", "Gojo"));
        Collection<String> c2 = new ArrayList<>(Arrays.asList("Geto", "Itadori", "Kaneki"));

        System.out.println(contarCoincidencias(c1, c2));
        // aviso: poner los tipos para q no se queje
        Map<Integer, String> mapa = new HashMap<>();
        mapa.put(1, "a");
        mapa.put(2, "b");
        mapa.put(3, "a");

        // Mapa original: {1="a", 2="b", 3="a"} Resultado: {"a"=[1, 3], "b"=[2]}

        System.out.println(invertirOrden(mapa));

        // 3

        List<String> lista = new ArrayList<>(Arrays.asList("Geto", "Gojo", "Gojo", "Itadori"));
        System.out.println(repetidos(lista));

    }
}
