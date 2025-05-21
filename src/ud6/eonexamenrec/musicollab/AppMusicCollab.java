//Eva María Otero Názara

package ud6.eonexamenrec.musicollab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AppMusicCollab {

        // Devuelve una lista de músicos que dominan al menos uno de los instrumentos
        // requeridos por la canción c, ordenados por alias alfabético.

        public static List<Musico> musicosParaCancion(Cancion c, List<Musico> musicos) {
                List<Musico> musicosCapaces = new ArrayList<>();

                return musicosCapaces;

        }

        /*
         * Devuelve las canciones de la lista en las que el grupo de músicos puede
         * cubrir todos
         * los instrumentos requeridos, ordenadas por nombre alfabético.
         * a. Un músico no tiene por qué tocar en una canción si sus instrumentos no son
         * requeridos.
         * b. Un mismo músico solo puede tocar un instrumento a la vez (excepto "voz",
         * que puede combinarse con otros).
         */
        public static List<Cancion> cancionesPosibles(List<Musico> grupo, List<Cancion> canciones) {
                List<String> CancionesPosibles = new ArrayList<>();

                return cancionesPosibles(grupo, canciones);
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

                // Músicos de ejemplo
                List<Musico> musicos = new ArrayList<>(Arrays.asList(
                                new Musico("Ana López", "BassQueen", List.of("bajo", "voz")),
                                new Musico("Carlos Ruiz", "GuitarHero", List.of("guitarra", "voz")),
                                new Musico("Luisa Pérez", "DrumStar", List.of("batería")),
                                new Musico("Pablo Martín", "PianoMaster", List.of("piano")),
                                new Musico("Sofía Vega", "Vocalist", List.of("voz")),
                                new Musico("Mario Silva", "SaxKing", List.of("saxofón")),
                                new Musico("Elena Díaz", "MultiInstrumentalist",List.of("guitarra", "piano", "voz")
                                )));

                
                // Músicos para "Bohemian Rhapsody"
                Cancion bohemian = canciones.get(0);
                List<Musico> candidatos = musicosParaCancion(bohemian, musicos);
                System.out.println("\nMúsicos para '" + bohemian.getNombre() + "':");
                System.out.println("=====================================\n");
                candidatos.forEach(System.out::println);

                // Canciones que puede tocar un grupo de músicos
                List<Musico> grupo = List.of(musicos.get(1), musicos.get(0), musicos.get(2));
                List<Cancion> posibles = cancionesPosibles(grupo, canciones);
                System.out.println("\nCanciones posibles para el grupo:");
                System.out.println("=================================\n");
                posibles.forEach(System.out::println);

                System.out.println("\n");
        }

}
