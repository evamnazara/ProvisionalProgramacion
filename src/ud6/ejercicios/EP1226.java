/*EP1226. Un centro educativo necesita distribuir de forma aleatoria a los alumnos de un curso entre los grupos disponibles para ese curso. 
Diseña la función
    List<List<String>> repartoAlumnos(List<String> lista, int numGrupos) 
    que devuelve una lista de listas, cada una de las cuales corresponde a un grupo. Cada nombre de la lista de alumnos se asigna a uno de los grupos.
 */

 package ud6.ejercicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EP1226 {
    // Función que reparte los alumnos de forma aleatoria en numGrupos grupos
    static List<List<String>> repartoAlumnos(List<String> lista, int numGrupos) {
        // Barajamos la lista para asegurar aleatoriedad
        Collections.shuffle(lista);

        // Creamos la lista de grupos (listas vacías)
        List<List<String>> grupos = new ArrayList<>();
        for (int i = 0; i < numGrupos; i++) {
            grupos.add(new ArrayList<>());
        }

        // Repartimos los alumnos en los grupos de forma cíclica
        for (int i = 0; i < lista.size(); i++) {
            int grupoIndex = i % numGrupos;
            grupos.get(grupoIndex).add(lista.get(i));
        }

        return grupos;
    }

    public static void main(String[] args) {
        List<String> alumnos = new ArrayList<>();
        alumnos.add("Ana");
        alumnos.add("Luis");
        alumnos.add("Carlos");
        alumnos.add("Marta");
        alumnos.add("Sofía");
        alumnos.add("Jorge");
        alumnos.add("Elena");
        alumnos.add("Pablo");

        int numGrupos = 3;

        List<List<String>> grupos = repartoAlumnos(alumnos, numGrupos);

        // Imprimir los grupos
        for (int i = 0; i < grupos.size(); i++) {
            System.out.println("Grupo " + (i + 1) + ": " + grupos.get(i));
        }
    }

}
