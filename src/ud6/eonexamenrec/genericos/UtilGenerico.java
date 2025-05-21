//Eva María Otero Názara
package ud6.eonexamenrec.genericos;

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
     * en ambas colecciones.
     */

    public static <T> Collection <T> contarCoincidencias(Collection<T> c1, Collection<T> c2) {
        Collection<T> mezcladas = new ArrayList<>(c1);
        mezcladas.addAll(c2);

        Set<T> coincidencias = new TreeSet<>();

        for (T elemento : mezcladas) {
            coincidencias.add(elemento);
        }

        return coincidencias;
    }

    /*
     * 2. (2) Método genérico invertirOrden()que recibe un Map<K, V> y devuelve un
     * nuevo Map<V, List<K>> donde:
     * a. Las claves son los valores del mapa sin repetir.
     * b. Los valores son listas de claves originales asociadas a ese valor.
     * 
     * Ejemplo: Mapa original: {1="a", 2="b", 3="a"} Resultado: {"a"=[1, 3],
     * "b"=[2]}.*/

     public static <T> Map<String, Integer> invertirOrden(Map <Integer, String> mapa1) {
        Map<T, Integer> m2 = new HashMap<>();
        return null;

    }
    public static void main(String[] args) {
        // 1
        Collection<Integer> colec1 = Arrays.asList(1,2,3,4,5,6,7);
        Collection<Integer> colec2 = Arrays.asList(2,9,12,34);
        System.out.println("Numero de elementos que coinciden: " + contarCoincidencias(colec1, colec2).size());

        // 2 Mapa original: {1="a", 2="b", 3="a"} Resultado: {"a"=[1, 3], "b"=[2]}.
        Map<Integer,String> mapa = new HashMap<>();
        mapa.put(1,"a");
        mapa.put(2,"b");
        mapa.put(3,"a");
        System.out.println(invertirOrden(mapa));
        
    }

}
