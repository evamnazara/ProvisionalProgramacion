package ud5.interfacesejercicios.EP0913_Futbolista;

import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class CompFutDNI implements Comparator {

    @Override
    public int compare (Object o1, Object o2) {
        Futbolista futbolista1 = ((Futbolista) o1);
        Futbolista futbolista2 = ((Futbolista) o2);

        return futbolista1.dni.compareTo(futbolista2.dni);
    }

    
}
