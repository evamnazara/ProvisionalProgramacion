package ud4.aceptaelreto.arrays;

public class DetectandoCopiones {

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Leemos múltiples casos de prueba
        while (true) {
            // Leemos el número de exámenes (N) y la cantidad de exámenes que el profesor
            // puede recordar (K)
            System.out.print(
                    "Introduce el número de exámenes y la cantidad de exámenes que el profesor puede recordar (N K): ");
            int totalExamenes = scanner.nextInt();
            int cantidadRecordar = scanner.nextInt();

            // Si encontramos un caso con 0 0, terminamos la entrada
            if (totalExamenes == 0 && cantidadRecordar == 0) {
                break;
            }

            // Leemos las respuestas de los exámenes
            int[] respuestasExamenes = new int[totalExamenes];
            System.out.print("Introduce las respuestas de los exámenes: ");
            for (int i = 0; i < totalExamenes; i++) {
                respuestasExamenes[i] = scanner.nextInt();
            }

            // Creamos un arreglo para simular la "memoria" del profesor, que almacena las
            // últimas respuestas que puede recordar
            int[] memoriaProfesor = new int[cantidadRecordar];
            int copiasDetectadas = 0;
            int totalCopias = 0;

            // Inicializamos la memoria con un valor imposible (-1)
            for (int i = 0; i < cantidadRecordar; i++) {
                memoriaProfesor[i] = -1; // Indicamos que la memoria está vacía inicialmente
            }

            // Procesamos los exámenes
            System.out.println("Procesando los exámenes...");
            for (int i = 0; i < totalExamenes; i++) {
                int respuestaActual = respuestasExamenes[i];
                boolean esCopia = false;

                // Comprobamos si la respuesta actual ya está en la memoria del profesor
                for (int j = 0; j < cantidadRecordar; j++) {
                    if (memoriaProfesor[j] == respuestaActual) {
                        esCopia = true;
                        copiasDetectadas++;
                        break;
                    }
                }

                // Si es una copia, aumentamos el contador de copias detectadas
                if (esCopia) {
                    totalCopias++;
                }

                // Ahora actualizamos la memoria, agregando la respuesta actual
                // Desplazamos las respuestas anteriores en la memoria para hacer espacio
                for (int j = cantidadRecordar - 1; j > 0; j--) {
                    memoriaProfesor[j] = memoriaProfesor[j - 1];
                }

                // Colocamos la respuesta actual en la memoria
                memoriaProfesor[0] = respuestaActual;
            }

            // Mostramos el resultado final
            System.out.println("Número de exámenes copiados: " + copiasDetectadas);
            System.out.println("Número de copias detectadas: " + totalCopias);
            System.out.println("-----");
        }

        scanner.close();
    }
}

/*
 * 
 * Detectando copiones
 * 
 * Foto tomada durante un examen
 * La memoria del viejo profesor de matemáticas ya no es lo que era. Hace años,
 * cuando empezó en eso de ilustrar mentes en blanco, no sólo se sabía los
 * nombres y apellidos de todos sus alumnos sino que además era un lince
 * detectando copias de exámenes. Estaba tan seguro de su habilidad que mientras
 * los alumnos intentaban resolver aquellas derivadas e integrales infernales,
 * él se sentaba en la última fila de la clase a dormir sin preocuparse de que
 * la información fluyera entre los estudiantes.
 * 
 * Su habilidad se basaba en su memoria fotográfica: cuando corregía un examen,
 * era capaz de recordar a la perfección si había visto otro examen con
 * exactamente las mismas respuestas o no. Y si lo encontraba, acusaba al
 * segundo de copiar.
 * 
 * Ahora, con tantos años encima, su memoria fotográfica se limita a sólo unos
 * pocos de los últimos exámenes que ha corregido, por lo que el número de
 * copias que detecta se ha reducido drásticamente.
 * 
 * Entrada
 * La entrada contiene distintos casos de prueba, cada uno de ellos formado por
 * dos líneas.
 * 
 * En la primera línea aparecen dos números, N y K, que indican,
 * respectivamente, el número de exámenes que tiene que corregir el viejo
 * profesor y el número de exámenes que es capaz de recordar (1 ≤ N ≤ 1.000.000,
 * 1 ≤ K ≤ 100.000). Tras eso, viene una línea con N números (entre 1 y 100.000)
 * separados por espacios que representan las respuestas de cada uno de los
 * exámenes. Dos exámenes se consideran copiados si están representados por el
 * mismo número.
 * 
 * Salida
 * Para cada caso de prueba se escribirá una línea con dos números separados por
 * un espacio. El primero indicará el número de exámenes copiados mientras que
 * el segundo dará la cantidad de copias detectadas por el profesor, sabiendo
 * que, en el momento de corregir un examen, éste es capaz de recordar
 * únicamente los K exámenes inmediatamente anteriores.
 * 
 * Entrada de ejemplo
 * 5 1
 * 1 2 1 2 1
 * 5 2
 * 1 2 1 2 1
 * 6 2
 * 1 2 3 1 2 1
 * Salida de ejemplo
 * 
 * 3 0
 * 3 3
 * 3 1
 */
