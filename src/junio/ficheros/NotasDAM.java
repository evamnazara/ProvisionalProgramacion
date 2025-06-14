package junio.ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
Notas y medias de DAM
El fichero calificacion_alumnos.csv contiene las notas finales obtenidas por el alumnado del ciclo DAM en el siguiente formato:
Los datos se presentan en filas con la información separada por punto y coma (;)
La primera fila contiene las cabeceras de la información
Las siguientes filas representan la nota de un alumno/a en un módulo.

Elabora un programa que lea el fichero y muestre:
el nombre y la nota media de cada alumno/a ordenados descendentemente por media
el nombre y el número de suspensos de cada módulo ordenados ascendentemente por número de suspensos.
Genera un fichero de texto de salida de nombre "InformeDAM1.txt" que contengo un informe con el siguiente contenido:


Informe Avaliación DAM1
=======================
Total Alumnado = ??

Alumnado con…:
- Todo aprobado: ??
- 1 módulo suspenso: ??
- 2 módulos suspensos: ??
- 3 módulos suspensos: ??
- Máis de 3 módulos suspensos: ??
etc.
 */

public class NotasDAM {
    static final String PATH = "src/junio/ficheros/";
    static final String FICHERO_ENTRADA = PATH + "calificacion_alumnos.csv";
    static final String FICHERO_SALIDA = PATH + "InformeDAM1.txt";

    public static void main(String[] args) {
        // declarar los mapas

        Map<String, List<Double>> notasPorAlumno = new TreeMap<>();
        Map<String, Integer> suspensosPorMateria = new TreeMap<>();
        Map<String, Integer> suspensosPorAlumno = new TreeMap<>();

        try (BufferedReader in = new BufferedReader(new FileReader(FICHERO_ENTRADA))) {

            String linea;

            // Leemos línea a línea hasta que no queden más (readLine devuelve null al
            // final)
            while ((linea = in.readLine()) != null) {

                // Saltamos la primera línea si contiene cabeceras
                // Alternativamente, puedes leer la cabecera antes del bucle
                if (linea.startsWith("NOME;")) {
                    continue; // Puedes quitar esto si ya has leído la primera fuera del while
                }

                // Dividimos la línea por el carácter ';'
                String[] partes = linea.split(";");

                // Comprobamos que la línea tenga exactamente 3 partes válidas
                if (partes.length == 3) {
                    String nombre = partes[0].trim(); // Alumno
                    double nota = Double.parseDouble(partes[1].trim()); // Nota
                    String materia = partes[2].trim(); // Módulo

                    // Si el alumno no está en el mapa, lo añadimos
                    if (!notasPorAlumno.containsKey(nombre)) {
                        notasPorAlumno.put(nombre, new ArrayList<>());
                    }

                    // Añadimos la nota a la lista del alumno
                    notasPorAlumno.get(nombre).add(nota);

                    // Si es suspenso (< 5), actualizar contadores
                    if (nota < 5) {
                        // Suspensos por materia
                        if (!suspensosPorMateria.containsKey(materia)) {
                            suspensosPorMateria.put(materia, 1);
                        } else {
                            int actual = suspensosPorMateria.get(materia);
                            suspensosPorMateria.put(materia, actual + 1);
                        }

                        // Suspensos por alumno
                        if (!suspensosPorAlumno.containsKey(nombre)) {
                            suspensosPorAlumno.put(nombre, 1);
                        } else {
                            int actual = suspensosPorAlumno.get(nombre);
                            suspensosPorAlumno.put(nombre, actual + 1);
                        }
                    }
                }
            }
            // Mapa donde almacenamos la media de cada alumno
            Map<String, Double> medias = new HashMap<>();

            for (String alumno : notasPorAlumno.keySet()) {
                List<Double> notas = notasPorAlumno.get(alumno);
                double suma = 0;
                for (double nota : notas) {
                    suma += nota;
                }
                double media = suma / notas.size();
                medias.put(alumno, media);
            }

            // Mapa para contar cuántos alumnos tienen 0, 1, 2... suspensos
            Map<Integer, Integer> resumenSuspensos = new TreeMap<>();
            for (String alumno : notasPorAlumno.keySet()) {
                int numSuspensos = suspensosPorAlumno.getOrDefault(alumno, 0);
                if (!resumenSuspensos.containsKey(numSuspensos)) {
                    resumenSuspensos.put(numSuspensos, 1);
                } else {
                    int actual = resumenSuspensos.get(numSuspensos);
                    resumenSuspensos.put(numSuspensos, actual + 1);
                }
            }

            // FICHERO DE SALIDA
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FICHERO_SALIDA))) {
                writer.write("Informe Avaliación DAM1");
                writer.newLine();
                writer.write("=========================");
                writer.newLine();
                writer.write("Total Alumnado = " + notasPorAlumno.size());
                writer.newLine();
                writer.newLine();

                writer.write("Alumnado con…:");
                writer.newLine();

                // Escribimos el resumen de suspensos por alumno
                for (int numSuspensos : resumenSuspensos.keySet()) { // ahora no hay conflicto
                    int cantidad = resumenSuspensos.get(numSuspensos);
                    String texto;
                    if (numSuspensos == 0) {
                        texto = "- Todo aprobado";
                    } else if (numSuspensos == 1) {
                        texto = "- 1 módulo suspenso";
                    } else {
                        texto = "- " + numSuspensos + " módulos suspensos";
                    }
                    writer.write(texto + ": " + cantidad);
                    writer.newLine();
                }

                // Escribimos las medias de los alumnos, ordenadas descendentemente
                writer.newLine();
                writer.write("Media por alumno (descendente):");
                writer.newLine();

                List<Map.Entry<String, Double>> listaMedias = new ArrayList<>(medias.entrySet());
                listaMedias.sort((a, b) -> Double.compare(b.getValue(), a.getValue())); // ordenar descendente

                for (Map.Entry<String, Double> entrada : listaMedias) {
                    writer.write("- " + entrada.getKey() + " → " + String.format("%.2f", entrada.getValue()));
                    writer.newLine();
                }

                // Escribimos los suspensos por materia, ordenados ascendentemente
                writer.newLine();
                writer.write("Suspensos por módulo (ascendente):");
                writer.newLine();

                List<Map.Entry<String, Integer>> listaSuspensos = new ArrayList<>(suspensosPorMateria.entrySet());
                listaSuspensos.sort(Map.Entry.comparingByValue()); // menor a mayor

                for (Map.Entry<String, Integer> entrada : listaSuspensos) {
                    writer.write("- " + entrada.getKey() + ": " + entrada.getValue() + " suspensos");
                    writer.newLine();
                }

                // Se cierra automáticamente por el try-with-resources
                System.out.println("Informe generado correctamente con BufferedWriter: " + FICHERO_SALIDA);
            } catch (IOException e) {
                System.out.println("Error escribiendo el fichero: " + e.getMessage());
            }

        } catch (FileNotFoundException e) { // error de no encontrar
            System.out.println(e.getMessage()); // (El sistema no puede encontrar el archivo especificado)
        } catch (IOException e) { // error de entrada salida
            System.out.println(e.getMessage());
        }
    }

}
