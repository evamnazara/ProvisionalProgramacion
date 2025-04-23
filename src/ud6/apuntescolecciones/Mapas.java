package ud6.apuntescolecciones;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Mapas {
    public static void main(String[] args) {
        Map<String,Double> m = new HashMap<>();

        m.put("Ana", 1.65);
        m.put("Marta",1.60);
        m.put("Luis", 1.73);
        m.put("Pedro", 1.69);

        System.out.println(m);

        m.put("Pedro", 1.71);
        //la clave es la misma, se sobreescribe en vez de duplicarse
        System.out.println(m);

        System.out.println(m.get("Pepe"));
        System.out.println(m.get("Pedro"));

        System.out.println(m.remove("Pedro"));
        System.out.println(m);

        Set<String> nombres = m.keySet();
        System.out.println(nombres);

        Collection<Double> estaturas = m.values();
        System.out.println(estaturas);


    }
    
}
