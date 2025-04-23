//Eva María Otero Názara 

package ud5.oneexamen;

import java.util.Comparator;

public class compHosts implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Host h1 = (Host) o1;
        Host h2 = (Host) o2;

        return h1.nombre.compareTo(h2.nombre);

    }
    
}
