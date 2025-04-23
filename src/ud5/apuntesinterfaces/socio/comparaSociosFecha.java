package ud5.apuntesinterfaces.socio;

import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class comparaSociosFecha implements Comparator {
    //COMPARAR POR FECHA 
    @Override
    public int compare(Object o1, Object o2) {
        //hayq eu castearlos para poder acceder a sus atributos
        Socio s1 = (Socio) o1;
        Socio s2 = (Socio) o2;
       
        return s1.fechaNacimiento.compareTo(s2.fechaNacimiento);
    }


    

}
