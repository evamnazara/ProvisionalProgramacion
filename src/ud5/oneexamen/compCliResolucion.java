//Eva María Otero Názara 

package ud5.oneexamen;

import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class compCliResolucion implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Cliente c1 = (Cliente) o1;
        Cliente c2 = (Cliente) o2;

        return c1.resolucion.compareTo(c2.resolucion);
    }

}
