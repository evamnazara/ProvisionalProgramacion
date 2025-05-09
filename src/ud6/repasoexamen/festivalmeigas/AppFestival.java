package repasoexamen.festivalmeigas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class AppFestival {

    public static void main(String[] args) {
        System.out.println("\nFESTIVAL DE MEIGAS");
        System.out.println("==================\n");
        //array de meigas de exemplo
        Meiga[] meigasExemplo = Meiga.crearMeigasExemplo(Feitizo.crearFeitizosExemplo());

        //Ordena as Meigas de menor a maior número de feitizos
        Arrays.sort(meigasExemplo, (m1,m2) -> m1.getNumFeitizos() - m2.getNumFeitizos());


        //mapa de puntuaciones 
        Map<Meiga, Integer> puntuaciones = new HashMap<Meiga,Integer>();
        // Para cada meiga do festival, imprime os seus datos, lanza os
        // feitizos posibles, e imprime os puntos obtidos.
        for (Meiga meiga : meigasExemplo) {
            System.out.println("MEIGA: ");
            System.out.println(meiga);
            int puntos = meiga.lanzarFeitizos();
            System.out.println("TOTAL PUNTOS: " + puntos + "\n\n");

            //Engade o código que necesites...
            puntuaciones.put(meiga, puntos);

        }

        // Amosa a clasificación final do festival
        System.out.println("Clasificación Final do Festival: ");
        System.out.println(puntuaciones);

        List<Entry<Meiga, Integer>> entradas = new ArrayList<>(puntuaciones.entrySet());
        //orden descendente
        entradas.sort((entrada1,entrada2) -> entrada2.getValue() - entrada1.getValue());

        for(Entry<Meiga,Integer> entrada : entradas) {
            System.out.println(entrada.getKey().getNome() + "-" + entrada.getValue());
        }

        System.out.println("\nFIN DO FESTIVAL DE MEIGAS\n");

        System.out.println("EXTRA:");

        //List<Entry<Meiga,Integer>> entradasFiltradas = UtilGenerico.filtrarMayores(entradas, 5, null)
    }

}
