package ud4.aceptaelreto.arrays;

public class DesgasteBombines {

    public static void main(String[] args) {
        // Crear un scanner para leer la entrada
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.println("Bienvenido al programa de desgastes de bombines. Procesaremos varios casos de prueba.");

        // Continuar procesando hasta que se encuentre un 0
        while (true) {
            // Leer el número de días
            System.out.print("Introduce el número de días del periodo (0 para terminar): ");
            int numDias = scanner.nextInt();

            // Si el número de días es 0, terminamos
            if (numDias == 0) {
                System.out.println("Proceso terminado. ¡Hasta luego!");
                break;
            }

            // Leer los desgastes para los n días
            int[] desgastes = new int[numDias];
            System.out.println("Introduce los desgastes para cada uno de los días (valores positivos o negativos):");
            for (int i = 0; i < numDias; i++) {
                desgastes[i] = scanner.nextInt();
            }

            // Llamar a la función para calcular el día en el que se debe llamar al
            // cerrajero
            calcularDiaCerrajero(desgastes, numDias);
        }

        // Cerrar el scanner
        scanner.close();
    }

    // Función que calcula el mejor día para llamar al cerrajero
    public static void calcularDiaCerrajero(int[] desgastes, int numDias) {
        // Variable para el desgaste acumulado
        long desgasteAcumulado = 0;
        // Variable para la suma total del desgaste (al final del periodo)
        long desgasteTotal = 0;

        // Calcular el desgaste total (suma de todos los desgastes)
        for (int i = 0; i < numDias; i++) {
            desgasteTotal += desgastes[i];
        }

        // Informar al usuario del desgaste total
        System.out.println("El desgaste total de todos los días es: " + desgasteTotal);

        // Si el desgaste total ya es 0, no necesitamos cerrajero, se puede imprimir 0 y
        // continuar
        if (desgasteTotal == 0) {
            System.out.println("¡El desgaste ya está equilibrado! No es necesario llamar al cerrajero.");
            return;
        }

        // Recorrer los días para encontrar el punto de equilibrio
        for (int i = 0; i < numDias; i++) {
            desgasteAcumulado += desgastes[i];

            // Informar el desgaste acumulado hasta el día actual
            System.out.println("Día " + (i + 1) + ": Desgaste acumulado hasta ahora es " + desgasteAcumulado);

            // Si el desgaste acumulado es igual al desgaste total / 2, entonces encontramos
            // el día óptimo
            if (desgasteAcumulado * 2 == desgasteTotal) {
                System.out.println("El cerrajero debe venir el día " + (i + 1) + " para equilibrar el desgaste.");
                return;
            }
        }

        // Si no se ha encontrado un punto de equilibrio, entonces no es necesario
        // cerrajero
        System.out.println("No es necesario llamar al cerrajero en ningún día. El desgaste ya está equilibrado.");
    }
}

/*
 * El desgaste de los bombines
 * Tiempo máximo: 2,000-3,000 s Memoria máxima: 8192 KiB
 * El bombín de una cerradura
 * Todas las urbanizaciones cerradas con un gran número de vecinos experimentan
 * el mismo problema con las cerraduras: al ser tanta gente entrando y saliendo
 * diariamente, las cerraduras se resienten y terminan funcionando mal.
 * 
 * Cuando en una puerta concreta se utiliza más uno de los dos lados de la
 * cerradura, una solución que aplica habitualmente el personal de mantenimiento
 * es dar la vuelta al bombín para que el desgaste de ambos lados se equilibre
 * y, al menos, ambos lados funcionen más o menos igual.
 * 
 * Lamentablemente con la crisis el personal de mantenimiento de nuestra
 * urbanización se ha tenido que eliminar por completo y sólo tenemos
 * presupuesto para llamar al cerrajero una vez. Tenemos una previsión del
 * número de veces que entrará y saldrá la gente por la puerta a lo largo de un
 * periodo de tiempo y tenemos que decidir qué día queremos que venga el
 * cerrajero a dar la vuelta al bombín para que al final del periodo el desgaste
 * de ambos lados sea lo más parecido posible.
 * 
 * Entrada
 * La entrada estará compuesta por distintos casos de prueba que representan la
 * estimación de uso de una puerta en un periodo de tiempo.
 * 
 * Cada caso de prueba consiste en dos líneas. La primera indica el número de
 * días del periodo (1 ≤ n ≤ 1.000.000). La segunda línea contiene n números,
 * cada uno de ellos indicando el desgaste del bombín; un número positivo v debe
 * interpretarse como que el lado de fuera de la puerta se ha utilizado v veces
 * más que el de dentro durante ese día. Un número negativo indica lo contrario.
 * Se garantiza que el valor absoluto de v no superará 1.000.000 y que la suma
 * de los valores absolutos de todos los números será menor o igual a 109.
 * 
 * La entrada termina con una línea con un 0.
 * 
 * Salida
 * Por cada caso de prueba se indicará al final de qué día querremos que venga
 * el cerrajero para que dé la vuelta al bombín, de forma que al final del
 * periodo de n días el desgaste de ambos lados de la cerradura sea lo más
 * parecido posible. El primer día de la secuencia se corresponde con el número
 * 1.
 * 
 * Si no es necesario que venga ningún cerrajero, se escribirá un 0. Si hay
 * varios días posibles, preferiremos que venga cuanto antes, por si sube sus
 * honorarios.
 * 
 * Entrada de ejemplo
 * 4
 * 1 2 2 1
 * 4
 * 1 2 2 0
 * 4
 * 1 2 -2 -1
 * 4
 * 6 1 -1 5
 * 3
 * -4 -5 5
 * 0
 * Salida de ejemplo
 * 2
 * 2
 * 0
 * 1
 * 0
 * 
 */
