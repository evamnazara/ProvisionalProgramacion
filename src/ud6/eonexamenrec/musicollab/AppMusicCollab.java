//Eva María Otero Názara

package ud6.eonexamenrec.musicollab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AppMusicCollab {

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
                                new Musico("Ana López", "BassQueen", List.of("bajo", "voz"),
                                                new HashSet<>(Arrays.asList(canciones.get(0), canciones.get(1),
                                                                canciones.get(5)))),
                                new Musico("Carlos Ruiz", "GuitarHero", List.of("guitarra", "voz"),
                                                new HashSet<>(Arrays.asList(canciones.get(0), canciones.get(4),
                                                                canciones.get(7)))),
                                new Musico("Luisa Pérez", "DrumStar", List.of("batería"),
                                                new HashSet<>(Arrays.asList(canciones.get(1), canciones.get(3),
                                                                canciones.get(6)))),
                                new Musico("Pablo Martín", "PianoMaster", List.of("piano"),
                                                new HashSet<>(Arrays.asList(canciones.get(0), canciones.get(2),
                                                                canciones.get(6)))),
                                new Musico("Sofía Vega", "Vocalist", List.of("voz"),
                                                new HashSet<>(Arrays.asList(canciones.get(2), canciones.get(4),
                                                                canciones.get(7)))),
                                new Musico("Mario Silva", "SaxKing", List.of("saxofón"),
                                                new HashSet<>(List.of(canciones.get(3)))),
                                new Musico("Elena Díaz", "MultiInstrumentalist", List.of("guitarra", "piano", "voz"),
                                                new HashSet<>(Arrays.asList(canciones.get(0), canciones.get(2),
                                                                canciones.get(7))))));

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

        public static List<Musico> musicosParaCancion(Cancion cancion, List<Musico> musicos) {
                List<Musico> candidatos = new ArrayList<>();
                List<String> instrumentosRequeridos = cancion.getInstrumentosRequeridos();

                for (Musico m : musicos) {
                        // Si el músico tiene algún instrumento que la canción requiere, es candidato
                        for (String inst : m.getInstrumentos()) {
                                if (instrumentosRequeridos.contains(inst)) {
                                        candidatos.add(m);
                                        break; // No necesitamos seguir comprobando este músico
                                }
                        }
                }

                return candidatos;
        }

        public static List<Cancion> cancionesPosibles(List<Musico> grupo, List<Cancion> canciones) {
                List<Cancion> resultado = new ArrayList<>();

                // Construir un set con todos los instrumentos que el grupo puede tocar
                Set<String> instrumentosGrupo = new HashSet<>();
                for (Musico m : grupo) {
                        instrumentosGrupo.addAll(m.getInstrumentos());
                }

                // Comprobar para cada canción si todos sus instrumentos están en
                // instrumentosGrupo
                for (Cancion c : canciones) {
                        if (instrumentosGrupo.containsAll(c.getInstrumentosRequeridos())) {
                                resultado.add(c);
                        }
                }

                return resultado;
        }

}
