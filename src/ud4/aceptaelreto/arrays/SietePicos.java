package ud4.aceptaelreto.arrays;

public class SietePicos {
    public static void main(String[] args) {
        // Usamos el scanner para leer la entrada de datos
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Leemos múltiples casos de prueba
        while (true) {
            // Leer el número de puntos en el recorrido
            int numAlturas = scanner.nextInt();

            // Si el número de alturas es 0, terminamos el programa
            if (numAlturas == 0) {
                break;
            }

            // Leer las alturas de la montaña rusa
            int[] alturas = new int[numAlturas];
            for (int i = 0; i < numAlturas; i++) {
                alturas[i] = scanner.nextInt();
            }

            // Variable para contar los picos
            int cantidadPicos = 0;

            // Recorremos cada punto de la montaña rusa
            for (int i = 0; i < numAlturas; i++) {
                // Indices anteriores y posteriores
                int anterior = (i - 1 + numAlturas) % numAlturas; // Circular: si es el primer elemento, anterior es el
                                                                  // último
                int siguiente = (i + 1) % numAlturas; // Circular: si es el último elemento, siguiente es el primero

                // Si la altura actual es mayor que la anterior y la siguiente, es un pico
                if (alturas[i] > alturas[anterior] && alturas[i] > alturas[siguiente]) {
                    cantidadPicos++;
                }
            }

            // Imprimir el número de picos encontrados en este caso de prueba
            System.out.println(cantidadPicos);
        }

        // Cerrar el scanner después de usarlo
        scanner.close();
    }
}

/*
 * Siete picos
 * Tiempo máximo: 1,000 s Memoria máxima: 4096 KiB
 * Foto clásica de '7 Picos', antigua atracción del Parque de Atracciones de
 * Madrid
 * En 1969 se inauguró el Parque de Atracciones de Madrid; su atracción estrella
 * era la montaña rusa "Siete picos", que, tras 36 años de servicio y unos 77
 * millones de usuarios, fue desmontada en 2005 para, como ella mismo "dijo" en
 * su carta de despedida, dejar paso a las nuevas generaciones.
 * 
 * Curiosamente, pese a su nombre, aquella montaña rusa no tenía siete picos. Si
 * llamamos "pico" a un punto del recorrido que está más alto que el
 * inmediatamente anterior y el inmediatamente siguiente, entonces tenía como
 * mucho 6 y ni siquiera las crónicas se ponen de acuerdo en esto.
 * 
 * Dado el recorrido de varias montañas rusas, ¿puedes contar el número de
 * picos? Ten en cuenta que las montañas rusas son circulares, y el punto de
 * inicio de la entrada ¡podría ser un pico!
 * 
 * Entrada
 * El programa leerá de la entrada estándar múltiples casos de prueba, cada uno
 * con la descripción de una montaña rusa.
 * 
 * Una montaña rusa queda descrita por un primer número 2 ≤ n ≤ 1.000 indicando
 * cuántas veces se ha anotado la altura del recorrido. A continuación vienen,
 * en otra línea, n números positivos (menores que 1.000) con todas esas
 * alturas.
 * 
 * La entrada termina con una montaña rusa sin alturas que no deberá procesarse.
 * 
 * Salida
 * Para cada caso de prueba el programa escribirá el número de picos de la
 * montaña rusa que representa. Recuerda que las montañas rusas son circuitos
 * cerrados, y tras el final vuelven a comenzar.
 * 
 * Entrada de ejemplo
 * 4
 * 4 10 3 2
 * 4
 * 10 3 2 4
 * 5
 * 4 10 10 3 2
 * 0
 * Salida de ejemplo
 * 1
 * 1
 * 0
 */