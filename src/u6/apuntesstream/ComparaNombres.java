package u6.apuntesstream;

import java.util.Comparator;

import u6.apuntescolecciones.Cliente;

public class ComparaNombres implements Comparator<Cliente> {
    public int compare(Cliente cl, Cliente c2) {
        return cl.getNombre().compareTo(c2.getNombre());
    }
}
