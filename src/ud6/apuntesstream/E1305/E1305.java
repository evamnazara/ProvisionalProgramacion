/*E1305. Implementar el método estático  
 
static <T, V> V[] transformar(T[] t, V[] transf, Function<T, V> f) 
 
al que se pasan dos tablas de tipo T y V respectivamente y devuelve o transforma la 
segunda tabla con los elementos de la primera transformados mediante la función que va 
en el tercer parámetro. 
Escribir un programa que use este método para obtener una tabla con las raíces 
cuadradas de los elementos de otra. 
 */

package ud6.apuntesstream.E1305;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class E1305 {

    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        int random;
        for (int i = 0; i < 20; i++) {
            random = (int) (Math.random() * 100 + 1);
            numeros.add(random);
        }

        System.out.println(numeros);
        List<Double> raicesCuadradas = transformar(numeros, x -> Math.sqrt(x));
        System.out.println(raicesCuadradas);
    }

    static <T, V> List<V> transformar(List<T> t, Function<T, V> f) {
        List<V> trans = new ArrayList<>();
        for (T e : t) {
            trans.add(f.apply(e));
        }
        return trans;
    }
}
