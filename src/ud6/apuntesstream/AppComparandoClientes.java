package apuntesstream;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import apuntescolecciones.Cliente;

public class AppComparandoClientes {
    public static void main(String[] args) {
        List<Cliente> clientes = Cliente.clientesDeEjemplo(); // Obtiene una lista de clientes de ejemplo

        // Distintas maneras de utilizar un Comparator para ordenar:
        // 1. Usando una clase que implementa Comparator
        // 2. Usando una clase anónima
        // 3. Usando una expresión lambda
        // 4. Usando una referencia a un método

        // 1. Usando una clase que implementa Comparator
        Comparator<Cliente> comp = new ComparaNombres(); // Se usa una clase concreta para comparar por nombre
        Collections.sort(clientes, comp); // Se ordena la lista de clientes usando ese comparador

        // Lo mismo de antes pero en una única línea
        // Collections.sort(clientes, new ComparaNombres());

        // 2. Usando una clase anónima
        Comparator<Cliente> comp2 = new Comparator<Cliente>() {
            @Override
            public int compare(Cliente cl, Cliente c2) {
                return cl.getNombre().compareTo(c2.getNombre()); // Se comparan los nombres
            }
        };
        Collections.sort(clientes, comp2); // Se usa el comparador anónimo para ordenar la lista

        // Lo mismo de antes pero instanciando el Comparator directamente en el
        // parámetro de sort()
        Collections.sort(clientes, new Comparator<Cliente>() {
            @Override
            public int compare(Cliente cl, Cliente c2) {
                return cl.getNombre().compareTo(c2.getNombre());
            }
        });

        // 3. Usando una expresión lambda
        Comparator<Cliente> comp3 = (Cliente cl, Cliente c2) -> {
            return cl.getNombre().compareTo(c2.getNombre()); // Lambda para comparar nombres
        };
        Collections.sort(clientes, comp3);

        // Lo mismo de antes en una única línea
        Collections.sort(clientes, (cl, c2) -> cl.getNombre().compareTo(c2.getNombre()));

        // 4. Usando una referencia a un método
        Comparator<Cliente> comp4 = Comparator.comparing(Cliente::getNombre); // Referencia al método getNombre
        Collections.sort(clientes, comp4);

        // Lo mismo de antes en una única línea
        Collections.sort(clientes, Comparator.comparing(Cliente::getNombre));
    }

    // Clase que implementa Comparator<Cliente> para comparar clientes por nombre
    public static class ComparaNombres implements Comparator<Cliente> {
        @Override
        public int compare(Cliente cl, Cliente c2) {
            return cl.getNombre().compareTo(c2.getNombre());
        }
    }
}
