package ud5.interfacesejercicios.EP0913_Futbolista;

import java.util.Comparator;


@SuppressWarnings("rawtypes")
public class CompFutEdad implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Futbolista f1 = (Futbolista) o1;
        Futbolista f2 = (Futbolista) o2;
        return f1.edad.compareTo(f2.edad);
    }
    
} 
