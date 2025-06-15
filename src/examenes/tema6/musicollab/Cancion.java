package examenes.tema6.musicollab;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Cancion implements Comparable<Cancion> {

        private String nombre;
        private String autor;
        private String estiloMusical;
        private List<String> instrumentosRequeridos;

        /*
         * Clase Cancion (3)
         * Implementa la clase según los requisitos y completa el código para que el
         * programa
         * principal genere la siguiente salida por consola.
         * Atributos:
         * ● nombre (String).
         * ● autor (String).
         * ● estiloMusical (String).
         * ● instrumentosRequeridos (List<String>, sin repetir).
         * Método:
         * ● instrumentosDistintos(): método estático que devuelve una lista de los
         * distintos instrumentos únicos (no repetidos) y ordenados alfabéticamente, que
         * requiere una colección de canciones que se pasa como parámetro de entrada.
         * Otros Requisitos:
         * 1. Orden natural: Por nombre alfabético.
         * 2. Método toString():
         * ○ Devuelve "Nombre" (Autor) - [Estilo] | Instrumentos: [lista].
         */

        public Cancion(String nombre, String autor, String estiloMusical, List<String> instrumentosRequeridos) {
                this.nombre = nombre;
                this.autor = autor;
                this.estiloMusical = estiloMusical;
                this.instrumentosRequeridos = instrumentosRequeridos;
        }

        public String getNombre() {
                return nombre;
        }

        public String getAutor() {
                return autor;
        }

        public String getEstiloMusical() {
                return estiloMusical;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public void setAutor(String autor) {
                this.autor = autor;
        }

        public void setEstiloMusical(String estiloMusical) {
                this.estiloMusical = estiloMusical;
        }

        public void setInstrumentosRequeridos(List<String> instrumentosRequeridos) {
                this.instrumentosRequeridos = instrumentosRequeridos;
        }

        public List<String> getInstrumentosRequeridos() {
                return instrumentosRequeridos;
        }

        public static Collection<String> instrumentosDistintos(Collection<Cancion> instrumentos) {
                Set<String> instrumentosUnicos = new TreeSet<>();
                for (Cancion intrumento : instrumentos) {
                        instrumentosUnicos.addAll(intrumento.instrumentosRequeridos);
                }
                return instrumentosUnicos;
        }

        @Override
        public int compareTo(Cancion o) {
                return nombre.compareTo(o.nombre);
        }

        @Override
        public String toString() {
                return "\"" + nombre + "\" (" + autor + ") [" + estiloMusical + "] | Intrumentos "
                                + instrumentosRequeridos;
        }

        public static void main(String[] args) {
                // Canciones de ejemplo
                List<Cancion> canciones = Arrays.asList(
                                new Cancion("Bohemian Rhapsody", "Queen", "Rock",
                                                List.of("voz", "piano", "guitarra", "batería")),
                                new Cancion("Billie Jean", "Michael Jackson", "Pop",
                                                List.of("voz", "bajo", "batería")),
                                new Cancion("Imagine", "John Lennon", "Balada",
                                                List.of("voz", "piano")),
                                new Cancion("Smells Like Teen Spirit", "Nirvana", "Grunge",
                                                List.of("voz", "guitarra", "bajo", "batería")),
                                new Cancion("Yesterday", "The Beatles", "Pop",
                                                List.of("voz", "guitarra")),
                                new Cancion("Sweet Child O'Mine", "Guns N' Roses", "Rock",
                                                List.of("voz", "guitarra", "bajo", "batería")),
                                new Cancion("Rolling in the Deep", "Adele", "Pop",
                                                List.of("voz", "piano", "batería")),
                                new Cancion("Hotel California", "Eagles", "Rock",
                                                List.of("voz", "guitarra", "bajo", "batería")));

                // Ordenar canciones por nombre
                Collections.sort(canciones);
                System.out.println("\nCanciones ordenadas por nombre:");
                System.out.println("===============================\n");
                canciones.forEach(System.out::println);

                // Ordenar canciones alfabéticamente por estilo musical, luego por autor y luego
                // por nombre
                System.out.println("\nCanciones ordenadas por estilo musical, luego por autor y luego por nombre:");
                System.out.println("===========================================================================\n");

                Comparator<Cancion> porEstilo = (c1, c2) -> c1.getEstiloMusical().compareTo(c2.getEstiloMusical());
                Comparator<Cancion> porAutor = (c1, c2) -> c1.getAutor().compareTo(c2.getAutor());
                Comparator<Cancion> porNombre = (c1, c2) -> c1.getNombre().compareTo(c2.getNombre());

                canciones.sort(porEstilo.thenComparing(porAutor).thenComparing(porNombre));

                canciones.forEach(System.out::println);

                // Obtener lista de instrumentos distintos
                System.out.println("\nLista de instrumentos distintos:");
                System.out.println("================================\n");
                System.out.println(instrumentosDistintos(canciones));

                System.out.println("\n");
        }

}
