//Eva María Otero Názara 

package ud5.oneexamen;

import java.util.Comparator;


public class comCliSO implements Comparator {

    //CORREGIR el orden de enumeraciones no es igual que el de Strings
    @Override
    public int compare(Object o1, Object o2) {
        Cliente c1 = (Cliente) o1;
        Cliente c2 = (Cliente) o2;

        return c1.sistema.compareTo(c2.sistema);
    }
    
}
