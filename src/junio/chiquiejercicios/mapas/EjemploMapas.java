package junio.chiquiejercicios.mapas;

import java.util.HashMap;
import java.util.Map;

public class EjemploMapas {
    public static void main(String[] args) {
        // primero declarar el mapa
        Map<Integer, String> mapaEmpleados = new HashMap<>();

        // para poner valores:
        mapaEmpleados.put(1, "Pedro");
        mapaEmpleados.put(2, "Juan");
        mapaEmpleados.put(3, "Eva");

        // buscar un valor:
        System.out.println(mapaEmpleados.containsKey(5)); // false);
        System.out.println(mapaEmpleados.containsValue("Juan")); // true

        // añadir:
        if (mapaEmpleados.containsKey(4) == false) {
            System.out.println("se ha añadido:");
            mapaEmpleados.put(4, "Adriano");
        } else {
            System.out.println("Ya esta añadido");
        }

        // ver todos los valores:
        System.out.println(mapaEmpleados.values());
        System.out.println(mapaEmpleados.keySet());

        // coger un valor pasandole una key

        // declarar variable
        String nombre = mapaEmpleados.get(4);
        System.out.println(nombre);

        // borrar
        if (mapaEmpleados.containsKey(7)) {
            System.out.println("se ha eliminado la clave");
            mapaEmpleados.remove(7);
        } else {
            System.out.println("La clave no estaba en el mapa");
        }

    }

}
