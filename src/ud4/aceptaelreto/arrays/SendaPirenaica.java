
package ud4.aceptaelreto.arrays;

public class SendaPirenaica {
    public static void main(String[] args) {
        // Usamos el scanner para leer la entrada de datos
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Leemos múltiples casos de prueba
        while (true) {
            // Leer el número de etapas de la ruta
            int numEtapas = scanner.nextInt();

            // Si el número de etapas es 0, terminamos el programa
            if (numEtapas == 0) {
                break;
            }

            // Leer las distancias de cada etapa
            int[] distancias = new int[numEtapas];
            int sumaTotal = 0;
            for (int i = 0; i < numEtapas; i++) {
                distancias[i] = scanner.nextInt();
                sumaTotal += distancias[i]; // Acumulamos la distancia total
            }

            // Variable para calcular la distancia restante
            int distanciaRestante = sumaTotal;
            // Imprimir las distancias restantes al comienzo de cada etapa
            for (int i = 0; i < numEtapas; i++) {
                distanciaRestante -= distancias[i]; // Restamos la distancia recorrida
                System.out.print(distanciaRestante + " "); // Imprimimos la distancia restante
            }

            // Salto de línea para separar los resultados de cada caso de prueba
            System.out.println();
        }

        // Cerrar el scanner después de usarlo
        scanner.close();
    }
}

/*
 * 
 * Senda pirenaica
 * Tiempo máximo: 1,000 s Memoria máxima: 4096 KiB
 * Cartel de la GR-11 con direcciones a Canfranc o Formigal en Canal Roya,
 * Huesca (CC BY-SA 3.0, por Ander-pirineos, Wikipedia)
 * En Europa existe una red de caminos para los senderistas, entre los que
 * destacan los senderos de Gran Recorrido (GR), pensados para caminatas de más
 * de dos jornadas.
 * 
 * La Senda Pirenaica es uno de ellos (el GR11), y cruza todo el Pirineo español
 * de oeste a este, empezando en el cabo Higuer, en el golfo de Vizcaya, y
 * terminando en el cabo de Creus, en el Mediterráneo (o al contrario). Son 800
 * kilómetros por montaña (con algunos tramos por Andorra) que, con el permiso
 * de las agujetas y el dolor de pies, permiten admirar los extraordinarios
 * paisajes de la cordillera.
 * 
 * El próximo verano vamos a recorrerlo y sabemos ya la longitud que tendremos
 * que andar cada etapa para llegar cada noche a un albergue. Pero para saber
 * cada mañana cómo vamos de provisiones totales para completar la Senda,
 * queremos saber cuántos kilómetros nos quedan hasta la meta.
 * 
 * Entrada
 * La entrada consta de una serie de casos de prueba, cada uno ocupando dos
 * líneas. La primera contiene el número N de etapas de la ruta, al menos 1 y no
 * más de 100. La segunda línea contiene las distancias a recorrer en cada
 * etapa, valores mayores que 0 y menores de 100.
 * 
 * La entrada termina con un 0, que no debe ser procesado.
 * 
 * Salida
 * Para cada caso de prueba se mostrará en una línea las distancias que faltan
 * por recorrer al comienzo de cada etapa hasta el final de la ruta, separadas
 * entre sí por un espacio.
 * 
 * Entrada de ejemplo
 * 2
 * 5 4
 * 5
 * 1 2 1 2 1
 * 1
 * 8
 * 0
 * Salida de ejemplo
 * 
 * 9 4
 * 7 6 4 3 1
 * 8
 */