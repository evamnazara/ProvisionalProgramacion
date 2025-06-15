package ud4.aceptaelreto.arrays;

public class TurismoDeLuces {
    public static void main(String[] args) {
        // Definir el objeto scanner para leer la entrada
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Leer múltiples casos de prueba
        while (true) {
            // Leer los valores de N (número de calles) y K (número de calles a visitar)
            int numCalles = scanner.nextInt();
            int callesAVisitar = scanner.nextInt();

            // Condición de salida: si ambos son 0, se termina el programa
            if (numCalles == 0 && callesAVisitar == 0) {
                break;
            }

            // Leer la lista de espectacularidades de las calles
            int[] espectacularidades = new int[numCalles];
            for (int i = 0; i < numCalles; i++) {
                espectacularidades[i] = scanner.nextInt();
            }

            // Variable para almacenar el máximo grado de satisfacción que podemos obtener
            int maxSatisfaccion = -1; // Usamos -1 para indicar que aún no se ha encontrado una satisfacción

            // Evaluamos todas las posibles subsecuencias de K calles consecutivas
            for (int i = 0; i <= numCalles - callesAVisitar; i++) {
                int gradoSatisfaccionActual = 0;

                // Calculamos la diferencia de espectacularidad entre calles consecutivas en la
                // subsecuencia
                for (int j = i; j < i + callesAVisitar - 1; j++) {
                    gradoSatisfaccionActual += Math.abs(espectacularidades[j] - espectacularidades[j + 1]);
                }

                // Actualizamos el máximo grado de satisfacción si es necesario
                if (gradoSatisfaccionActual > maxSatisfaccion) {
                    maxSatisfaccion = gradoSatisfaccionActual;
                }
            }

            // Imprimir el resultado de este caso de prueba
            System.out.println(maxSatisfaccion);
        }

        // Cerrar el scanner para liberar recursos
        scanner.close();
    }
}

/*
 * Turismo de luces
 * Tiempo máximo: 1,000-2,000 s Memoria máxima: 8192 KiB
 * Calle Larios de Málaga, enero de 2018. CC BY-SA 2.0, Ángel de los Ríos (via
 * Flickr)
 * En Navidad, las ciudades compiten por iluminar sus calles de la forma más
 * vistosa y atrayente posible, lo que ha terminado por consolidar el llamado
 * turismo de luces, en el que infinidad de personas viajan a diferentes puntos
 * del mundo para presenciar estas maravillas.
 * 
 * El ayuntamiento de la localidad en la que vives ha hecho una inversión enorme
 * (parcialmente sufragada por los comerciantes de las zonas afortunadas) y ha
 * hecho un folleto con las N calles iluminadas ordenadas por cercanía, de tal
 * forma que lo más cómodo es visitarlas en ese mismo orden (o en sentido
 * inverso).
 * 
 * El problema es que ¡son demasiadas! Has estimado que te da tiempo a ver
 * únicamente K calles, contiguas en la lista, y tienes que decidir cuáles.
 * 
 * Por la zona en la que está cada calle (y el nivel adquisitivo de sus
 * comerciantes), intuyes el grado de espectacularidad de sus luces. Quieres
 * maximizar tu grado total de asombro que se calcula con la diferencia de la
 * espectacularidad de las visitas consecutivas. Por ejemplo, si ves una calle
 * con una espectacularidad de 10 y a continuación otra con una espectacularidad
 * de 300, entonces tu grado total de asombro sube 290. Pero si justo después
 * vas a una calle con una espectacularidad de 125, la decepción hace que tu
 * grado de asombro descienda 175 (300 − 125).
 * 
 * Entrada
 * El programa deberá leer múltiples casos de prueba, cada uno ocupando dos
 * líneas.
 * 
 * La primera contiene dos números, N y K, indicando cuántas calles hay
 * iluminadas y cuántas vas a visitar respectivamente (2 ≤ K ≤ N ≤ 500.000).
 * 
 * La segunda línea contiene N números (entre 1 y 109) separados por espacio con
 * el grado de espectacularidad de cada calle.
 * 
 * Salida
 * Para cada caso de prueba el programa escribirá el mayor grado de satisfacción
 * que puedes conseguir recorriendo exactamente K calles consecutivas de la
 * entrada.
 * 
 * Ten en cuenta que puedes decidir hacer el recorrido completo en cualquier
 * sentido, si eso aumenta tu grado de satisfacción.
 * 
 * Entrada de ejemplo
 * 3 3
 * 10 300 125
 * 5 3
 * 100 200 250 400 600
 * 4 2
 * 400 300 250 270
 * Salida de ejemplo
 * 115
 * 350
 * 100
 * 
 */