package ud5.practicas.Inmobiliaria;

import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class CompInmM2 implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Inmueble inmueble1 = ((Inmueble) o1);
        Inmueble inmueble2 = ((Inmueble) o2);

        return inmueble1.metrosCuadrados.compareTo(inmueble2.metrosCuadrados);
    }
    
}
