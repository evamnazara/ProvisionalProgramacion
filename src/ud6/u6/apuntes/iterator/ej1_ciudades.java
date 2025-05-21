package ud6.u6.apuntes.iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class ej1_ciudades {
    public static void main(String[] args) {
        ArrayList<String> ciudades = new ArrayList<>();
        ciudades.add("New York");
        ciudades.add("Tokio");
        ciudades.add("París");

        System.out.println("Ciudades:");
        Iterator<String> it = ciudades.iterator();
        // PARA BORRAR UN ELEMENTO:
        // it.next();
        // it.remove(); // <- por si solo da excepcion!! solo con next antes
        // entra al while a partir del siguiente
        while (it.hasNext()) {
            System.out.println(it.next());
            // System.out.println(it.next() + " "); //New York Tokio Paris
        }
    }
}
