//Eva María Otero Názara 

package ud5.oneexamen;

import java.util.Comparator;

public class CompServidores implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Servidor s1 = (Servidor) o1;
        Servidor s2 = (Servidor) o2; 

        return s1.numServicios.compareTo(s2.numServicios);
    }
    
}
