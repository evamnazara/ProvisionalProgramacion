package Inmobiliaria;

import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class CompInmAlfabeticamente implements Comparator  {

    @Override
    public int compare(Object o1, Object o2) {
        Inmueble inmueble1 = ((Inmueble) o1);
        Inmueble inmueble2 = ((Inmueble) o2);

        return inmueble1.direccion.compareTo(inmueble2.direccion);
    }
    
}
