package ud6.ejercicios;

/*E1212. Implementar un método estático que lleve a cabo la unión de dos conjuntos de 
elementos genéricos. La unión es un nuevo conjunto con todos los elementos que 
pertenezcan, al menos a uno de los dos conjuntos. 
Implementa en otro método genérico la intersección, formada por los elementos comunes 
a los dos conjuntos. Los prototipos de los métodos son: 
 
●  static <E> Set<E> union(Set<E> conjunto1, Set<E> conjunto2) 
●  static <E> Set<E> interseccion(Set<E> conjunto1, Set<E> conjunto2)   */

import java.util.Set;
import java.util.TreeSet;

public class E1212 {

    static <E> Set<E> union(Set<E> conjunto1, Set<E> conjunto2) {
        Set<E> union = new TreeSet<>(conjunto1);
        union.addAll(conjunto2);
        return union;
    }

    static <E> Set<E> interseccion(Set<E> conjunto1, Set<E> conjunto2) {
        Set<E> interseccion = new TreeSet<>(conjunto2);
        interseccion.retainAll(conjunto1);
        return interseccion;
    }
    static <E> Set<E> except(Set<E> conjunto1, Set<E> conjunto2) {
        Set<E> except = new TreeSet<>(conjunto2);
        except.removeAll(conjunto1);
        return except;
    }
}
