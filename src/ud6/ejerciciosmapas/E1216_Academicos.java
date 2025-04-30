package ejerciciosmapas;

/*E1216. Los miembros de la Real Academia de la Lengua ocupan sillones con las letras del abecedario español, minúsculas y mayúsculas (en la práctica, las letras v, w, x, y, z, N, W, Y nunca se ocupan, pero nosotros no lo tendremos en cuenta). Cuando un sillón queda vacante, se nombra un nuevo académico para ocuparlo.

Implementar la clase Academico cuyos atributos son el nombre y el año de ingreso. El criterio de ordenación natural será por nombres.

Implementar un programa donde se cargan los datos de los académicos se crean cinco objetos Academico, que se insertan en
un mapa en el que la clave es la letra del sillón que ocupan, y el valor un objeto de la clase Academico. Para ello implementar el método estático:

static boolean nuevoAcademico (Map<Character, Academico> academia, Academico
nuevo, Character letra)

donde se lleva a cabo la inserción después de comprobar que el carácter pasado como
parámetro es una letra del abecedario.

Hacer diversos listados de los académicos: 
primero sin letra, por orden de nombre y de año de ingreso; 
y después con letra, por orden de letra (clave), nombre y fecha de ingreso.

Debemos recordar que en código Unicode, las mayúsculas van antes que las minúsculas.

Utiliza el método del repositorio para cargar y preparar los datos del fichero de texto: 

public static String readFileToString(String filePath)

DATOS
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class E1216_Academicos {
    public static class Academico implements Comparable<Academico> {
        String nombre;
        int anhoIngreso;

        public Academico(String nombre, int anhoIngreso) {
            this.nombre = nombre;
            this.anhoIngreso = anhoIngreso;
        }

        public String getNombre() {
            return nombre;
        }

        public int getAnhoIngreso() {
            return anhoIngreso;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setAnhoIngreso(int anhoIngreso) {
            this.anhoIngreso = anhoIngreso;
        }

        // añadir un nuevo académico:
        static boolean nuevoAcademico(Map<Character, Academico> academia, Academico nuevo, Character letra) {
            if (Character.isLetter(letra)) {
                academia.put(letra, nuevo);
                return true;
            }

            return false;
        }

        @Override
        public String toString() {
            return nombre + " (" + anhoIngreso + ")";
        }

        // criterio de ord natural: por nombre
        @Override
        public int compareTo(Academico otro) {
            return this.nombre.compareTo(otro.nombre);
        }

    }

    public static String readFileToString(String filePath) {
        StringBuilder fileContent = new StringBuilder();
        try {
            FileReader reader = new FileReader(filePath);
            BufferedReader buffer = new BufferedReader(reader);

            String line;
            while ((line = buffer.readLine()) != null) {
                fileContent.append(line);
                fileContent.append("\n");
            }

            buffer.close();
            reader.close();
        } catch (IOException e) {
            System.out.println("No existe el fichero.");
        }

        return fileContent.toString();
    }

    public static void main(String[] args) {
        // cargar fichero:
        String ficheroAcademicos = readFileToString("academicos.txt");
        // System.out.println(ficheroAcademicos);

        // crear mapa academia: ordenado x clave (letra) -> Character
        Map<Character, Academico> academia = new TreeMap<>();

        // separar las lineas del fichero con un setring:
        String[] lineas = ficheroAcademicos.split("\\n");
        // System.out.println(Arrays.toString(lineas));

        for (int i = 0; i < lineas.length; i++) {
            Character letra = lineas[i].charAt(6); // el txt empieza por Silla, no directamente en la letra
            String nombre = lineas[i].substring(7, lineas[i].length() - 6);
            int anho = Integer.parseInt(lineas[i].substring(lineas[i].length() - 5, lineas[i].length() - 1));
            // System.out.println(letra + " - " + nombre + " ( " + anho + ")");

            // Insertar en el mapa
            Academico.nuevoAcademico(academia, new Academico(nombre, anho), letra);
        }

        // ordenados de diferentes maneras:

        // System.out.println("Listado de académicos, sin letra:");
        // se crea una lista con todos los valores
        List<Academico> listaAcademicos = new ArrayList<>(academia.values());

        System.out.println("Académicos ordenados por nombre:");
        Collections.sort(listaAcademicos); // como pide orden natural, se hace con compareTo
        for (Academico academico : listaAcademicos) {
            System.out.println(academico);
        }

        // sin letra, por orden de año de ingreso y en caso de empate por nombre;
        System.out.println("Académicos ordenados por año, ");
        listaAcademicos.sort(Comparator.comparingInt(Academico::getAnhoIngreso).thenComparing(Academico::getNombre));
        Collections.sort(listaAcademicos); // como pide orden natural, se hace con compareTo
        for (Academico academico : listaAcademicos) {
            System.out.println(academico);
        }

        // con letra, por orden de letra (clave), indicando nombre y fecha de ingreso.
        // ya esta en el mapa treemap, ordenado x la clave

        System.out.println("Mapa de académicos ordenados por letra:");
        for (Map.Entry<Character, Academico> entry : academia.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }

}
