//Eva María Otero Názara 

package ud6.
eonexamen.genericos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/* (1) Método genérico repetidos() que reciba una lista de elementos y devuelva 
una copia de la lista original pero eliminando los elementos que aparecen sólo una 
vez. */
 
public class UtilGenerico<T> {
    
     static <T> Collection repetidos(Collection<T> conjunto1) {
        Set<T> sinRepetidos = new HashSet<>(conjunto1);
        for (T o : conjunto1) {
            sinRepetidos.add(o);
        }

        Collection<T> repetidos = new TreeSet<>(conjunto1);
        repetidos.removeAll(sinRepetidos);
        
        return repetidos;
    }

    /* 2.  (2) Método genérico filtrarMayores() que recibe como parámetros de entrada 
unha colección de elementos de un tipo T, un elemento del mismo tipo y un 
comparator y devuelve una subcolección con los elementos de la colección original 
que sean mayores o iguales que el recibido según el criterio del comparator.   */

    static <T> Collection filtrarmayores(Collection <T> conj1, Collection<T> conj2, Comparator<T> comp) {
        //return Arrays.sort(conj1, conj2, comp);
        return null;
    }

    public static void main(String[] args) {
        String [] prueba = {"A", "A", "B", "C", "D"};
        List <String> prueba2 = new ArrayList<>(Arrays.asList(prueba));

        System.out.println(repetidos(prueba2));
    }
}
