package ud7.exameud7_24.notas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*1. Notas y Promedios (3)
Paquete: notas
Se requiere implementar un programa en Java, AppNotas.java, que lea y procese
información contenida en un fichero de texto. El fichero de texto contendrá una lista de
estudiantes y sus respectivas calificaciones en varias materias. El programa debe leer este fichero, calcular el promedio de cada estudiante y escribir los resultados en un nuevo fichero de texto.

Especificaciones:
1. El fichero de entrada se llamará notas.txt.
2. Cada línea del fichero contendrá el nombre de un estudiante seguido de sus
calificaciones separadas por comas. Ejemplo:
Juan Perez,80,90,85
Maria Lopez,75,88,92
Carlos Garcia,60,70,80,90

3. El programa calculará el promedio de las calificaciones de cada estudiante.
4. Escribirá los resultados en un nuevo fichero llamado promedios.txt con el siguiente
formato:
Juan Perez: 85.0
Maria Lopez: 85.0
Carlos Garcia: 75.0
5. Si el fichero notas.txt no existe, está vacío o contiene datos incorrectos, el programa
debe manejar las excepciones correspondientes e imprimir los mensajes de error
adecuados. */
public class NotasyPromedios {

    static final String PATH = "src/ud7/exameud7_24/notas/";
    // ojo a la ultima barra !!

    public static void main(String[] args) {
        try {
            // archivo de lectura (notas.txt)
            BufferedReader in = new BufferedReader(new FileReader(PATH + "notas.txt"));
            Scanner sc = new Scanner(in);

            // archivo de escritura
            BufferedWriter out = new BufferedWriter(new FileWriter(PATH + "promedios.txt"));

            // leer linea a linea el archivin
            while (sc.hasNextLine()) {
                String linea = sc.nextLine().trim(); // .trim vacio porque no hay nada
                // if (linea.isEmpty()) {continue;}
                // partes en un array de strings partiendo por las comas
                System.out.println("Línea leída: " + linea);

                String[] partes = linea.split(",");
                String nombre = partes[0].trim();

                int cantidadNotas = 0;
                int sumaNotas = 0;

                // Se convierte de string a numero y se suman
                // empiezas desde int=1 pq no te interesa el 0, q es el nobre
                for (int i = 1; i < partes.length; i++) {
                    // Double.parseDouble()
                    int nota = Integer.parseInt(partes[i].trim());
                    sumaNotas += nota;
                    cantidadNotas++;
                }
                int promedio = sumaNotas / cantidadNotas;
                // escribes en el archivo de salirda
                out.write(nombre + ": " + promedio);
                out.newLine();
            }

            in.close();
            sc.close();

            out.close(); // IMPORTANTE

        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de L/E " + e.getMessage());
        }
    }
}
