package examenes.tema6.musicollab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

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

        // Devuelve una lista de músicos que dominan al menos uno de los instrumentos
        // requeridos por la canción c, ordenados por alias alfabético.
        public static List<Musico> musicosParaCancion(Cancion c, List<Musico> musicos) {
                List<Musico> musicosParaCancion = new ArrayList<>();

                c.getInstrumentosRequeridos();

                // hacen falta dos bucles, cuando yo originalmente solo estaba haciendo uno
                // primero por cada musico
                for (Musico musico : musicos) {
                        // depsues por cada instrumento
                        for (String instrumento : musico.getInstrumentosDomina()) {
                                if (c.getInstrumentosRequeridos().contains(instrumento)) {
                                        musicosParaCancion.add(musico);
                                }
                        }
                }

                Set<Musico> musicosSinRepetir = new TreeSet<>(musicosParaCancion);
                List<Musico> listaMusicos = new ArrayList<>(musicosSinRepetir); // el return especifica lista
                return listaMusicos;
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
                // para cada cancion, lista de insturmentos requeridos
                // intentar que los musicos de un grupo cubran esos insturmentos
                // cada musico toca un insturmento a la vez, excepto voz --> podría tocar 2
                // si se cubre, la cancion es valida

                List<Cancion> cancionesPosibles = new ArrayList<>();

                for (Cancion cancion : canciones) {
                        List<String> porCubrir = new ArrayList<>(cancion.getInstrumentosRequeridos());
                        List<Musico> musicosDisponibles = new ArrayList<>(grupo);
                        // Mantenemos un registro de qué instrumentos ha tocado cada músico
                        Map<Musico, Integer> instrumentosUsados = new HashMap<>();
                        Map<Musico, Boolean> yaUsoNoVoz = new HashMap<>();

                        for (Musico musico : musicosDisponibles) {
                                instrumentosUsados.put(musico, 0);
                                yaUsoNoVoz.put(musico, false);
                        }

                        for (String instrumentoNecesario : new ArrayList<>(porCubrir)) {
                                for (Musico musico : musicosDisponibles) {
                                        List<String> instrumentosQueDomina = musico.getInstrumentosDomina();
                                        if (instrumentosQueDomina.contains(instrumentoNecesario)) {
                                                boolean puedeTocar = false;

                                                if (instrumentoNecesario.equals("voz")) {
                                                        // La voz puede combinarse con otro instrumento
                                                        puedeTocar = true;
                                                } else if (!yaUsoNoVoz.get(musico)) {
                                                        // Si aún no tocó otro instrumento no voz
                                                        puedeTocar = true;
                                                }

                                                if (puedeTocar) {
                                                        porCubrir.remove(instrumentoNecesario);

                                                        instrumentosUsados.put(musico,
                                                                        instrumentosUsados.get(musico) + 1);

                                                        if (!instrumentoNecesario.equals("voz")) {
                                                                yaUsoNoVoz.put(musico, true); // ahora ya usó un
                                                                                              // instrumento no voz
                                                        }

                                                        // Ya encontramos a alguien para este instrumento, pasamos al
                                                        // siguiente
                                                        break; // Aquí podrías marcar con un booleano si no quieres usar
                                                               // `break`
                                                }
                                        }
                                }
                        }

                        if (porCubrir.isEmpty()) {
                                cancionesPosibles.add(cancion);
                        }
                }

                cancionesPosibles.sort(Comparator.comparing(Cancion::getNombre));

                return cancionesPosibles;
        }

}
