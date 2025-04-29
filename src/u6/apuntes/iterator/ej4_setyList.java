package u6.apuntes.iterator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ej4_setyList {
    public static class Alumnos {
        public String nombre;
        public String dni;
        public int edad;

        public Alumnos(String nombre, String dni, int edad) {
            this.nombre = nombre;
            this.dni = dni;
            this.edad = edad;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

    }

    public static void main(String[] args) {
        Set<Integer> numSet = new HashSet<>();
        numSet.add(5);
        numSet.add(8);
        numSet.add(2);
        numSet.add(3);
        numSet.add(3);
        numSet.add(4);
        numSet.add(5);
        System.out.println(numSet); // el orden en q se insertan no tiene pq ser el orden en que se muestra
        System.out.println(numSet.contains(1)); // false

        List<Integer> numList = new ArrayList<>();
        numList.add(5);
        numList.add(8);
        numList.add(2);
        numList.add(3);
        numList.add(3);
        numList.add(4);
        numList.add(5);
        System.out.println(numList);
        Set<Integer> numReps = new HashSet<>(numList); // cambiamos el formato para quitar los repetidos
        System.out.println(numReps);

        Set<String> nombres = new HashSet<>();
        nombres.add("Pep");
        nombres.add("Tom");
        nombres.add("Jon");
        nombres.add("Pep");
        nombres.add("Kal");
        nombres.add("Tom");
        System.out.println(nombres);

        // Si quisierams borrar a tom
        // nombres.get(2); no funciona pq no tenemos get
        // nombres.remove(2); // no borra nada -> Unlikely argument type int for
        // remove(Object) on a
        // Collection<String>
        nombres.remove("Tom");

        Set<Alumnos> dam = new HashSet<>();
        dam.add(new Alumnos("Pep", "222A", 25));
        dam.add(new Alumnos("Sam", "666A", 18));
        dam.add(new Alumnos("Kal", "777A", 20));

        Iterator<Alumnos> it = dam.iterator();

        while (it.hasNext()) {
            it.next().setNombre("AAA");

        }

    }

}
