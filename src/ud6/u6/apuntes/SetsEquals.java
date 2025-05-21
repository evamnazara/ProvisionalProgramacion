package ud6.u6.apuntes;

import java.util.*;

public class SetsEquals {

    public static class Persona {
        String nombre;
        Double altura;

        public Persona(String nombre) {
            this.nombre = nombre;
        }

        public Persona(String nombre, Double altura) {
            this.nombre = nombre;
            this.altura = altura;
        }
        // tenemos q poner bien el hashcode y el equals

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Persona other = (Persona) obj;
            if (nombre == null) {
                if (other.nombre != null)
                    return false;
            } else if (!nombre.equals(other.nombre))
                return false;
            return true;
        }

        @Override
        public String toString() {
            return nombre + " (" + altura + ")";
        }

    }

    public static void main(String[] args) {

        Persona p1 = new Persona("Antonio");

        Set<Persona> personas1 = new HashSet<>(Set.of(p1));
        Set<Persona> personas2 = new HashSet<>(Set.of(new Persona("Antonio")));

        System.out.println(personas1.equals(personas2));
        // false, aunque sean lo mismo, porque los hash no son iguales

        // si x cosa es igual a x2 cosa...

        // la unica forma de recorrer un ser es con un Iterator
        Iterator<Persona> it = personas1.iterator();
        Iterator<Persona> it2 = personas2.iterator();

        System.out.println(it.next().equals(it2.next()));

        // una vez se implementan los equals y hashcode, pasan a dar ambos true !!

        Persona p2 = new Persona("Adriano", 1.79);
        Persona p3 = new Persona("Eva", 1.64);
        Persona p4 = new Persona("David", 1.65);
        Persona p5 = new Persona("Pablo", 1.90);
        Persona p6 = new Persona("Antonio", 1.70);

        List<Persona> personas = new ArrayList<>();
        personas.add(p2);
        personas.add(p3);
        personas.add(p4);
        personas.add(p5);
        personas.add(p6);

        List<Persona> personasAltas = new ArrayList<>();
        List<Persona> personasBajas = new ArrayList<>();

        for (Persona persona : personas) {
            if (persona.altura >= 1.70) {
                personasAltas.add(persona);
            } else {
                personasBajas.add(persona);
            }
        }

        System.out.println("Personas altas:" + personasAltas.toString());
        System.out.println("Personas bajas: " + personasBajas.toString());
    }
}
