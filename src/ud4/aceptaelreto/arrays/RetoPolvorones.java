package ud4.aceptaelreto.arrays;

public class RetoPolvorones {

    public static void main(String[] args) {
        // Crear un scanner para leer la entrada
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        while (true) {
            // Leer el límite máximo de polvorones y el número de tipos de polvorones
            System.out.print("Introduce el límite máximo de polvorones y el número de tipos: ");
            int limiteMaximo = scanner.nextInt();
            int numTipos = scanner.nextInt();

            // Si los dos son cero, se termina la entrada
            if (limiteMaximo == 0 && numTipos == 0) {
                break;
            }

            // Leer la cantidad máxima de polvorones que puede comer Paul por tipo
            int[] maxPorTipo = new int[numTipos];
            System.out.print("Introduce la cantidad máxima por tipo: ");
            for (int i = 0; i < numTipos; i++) {
                maxPorTipo[i] = scanner.nextInt();
            }

            // Leer la cantidad de polvorones por tipo que hay en la bandeja
            int[] cantidadBandeja = new int[numTipos];
            System.out.print("Introduce la cantidad de polvorones por tipo en la bandeja: ");
            for (int i = 0; i < numTipos; i++) {
                cantidadBandeja[i] = scanner.nextInt();
            }

            // Llamar a la función que verifica si puede aceptar el reto
            if (puedeAceptarReto(limiteMaximo, maxPorTipo, cantidadBandeja)) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        }

        // Cerrar el scanner
        scanner.close();
    }

    // Función que verifica si Paul puede aceptar el reto
    public static boolean puedeAceptarReto(int limiteMaximo, int[] maxPorTipo, int[] cantidadBandeja) {
        int totalPolvorones = 0;

        // Recorrer todos los tipos de polvorones y comprobar las condiciones
        for (int i = 0; i < maxPorTipo.length; i++) {
            if (cantidadBandeja[i] > maxPorTipo[i]) {
                // Si hay más polvorones de un tipo de los que Paul puede comer, devuelve NO
                return false;
            }
            totalPolvorones += cantidadBandeja[i];
        }

        // Si el total de polvorones excede el límite máximo, devolver NO
        if (totalPolvorones > limiteMaximo) {
            return false;
        }

        // Si no se superan los límites, devolver SI
        return true;
    }
}

/*
 * Reto de polvorones
 * Tiempo máximo: 1,000 s Memoria máxima: 4096 KiB
 * Primer plano de una bandeja de polvorones caseros
 * A Paul Boròn siempre le han gustado las navidades, pero desde que se instaló
 * en España le gustan aun más. No es por las vacaciones, los adornos, las luces
 * y los regalos. Por lo que más desea la llegada de las fiestas es por los
 * polvorones. Le vuelven loco esos dulces que, al comerlos, se deshacen en
 * polvo en la boca.
 * 
 * Todos los años al acercarse diciembre, su médico le recuerda que debe
 * contenerse, y este año está dispuesto a hacerlo, después de un pequeño susto
 * que le dio la salud en verano. La experiencia le ha enseñado también sus
 * propios límites. Puede comerse en una noche muchos polvorones de almendra,
 * pero los de coco los lleva un poco peor.
 * 
 * Sabiendo su afición por estos dulces, en la cena de Nochevieja con toda la
 * familia de su mujer, uno de sus cuñados le ha retado a comerse toda la
 * bandeja de polvorones y, con el último aún en la boca, gritar "¡PAMPLONA!".
 * Pero no quiere aceptar si no está seguro de que va a conseguirlo sin superar
 * sus límites.
 * 
 * Entrada
 * Cada caso de prueba comienza con dos números. El primero, entre 1 y 100,
 * indica el límite máximo de polvorones que el médico le ha impuesto a Paul
 * para ser comidos en una noche. A continuación aparece un segundo número 1 ≤ p
 * ≤ 10 con la cantidad de tipos de polvorones que hay en la bandeja (almendra,
 * chocolate, canela, coco,…).
 * 
 * En la línea siguiente aparecen p números con la cantidad máxima de polvorones
 * de cada uno de los tipos que Paul es capaz de comerse. La tercera línea del
 * caso de prueba indica cuántos polvorones de cada tipo, en el mismo orden que
 * antes, hay en la bandeja. Ninguno de estos números será mayor que 100.
 * 
 * La entrada termina con dos ceros.
 * 
 * Salida
 * Por cada caso de prueba el programa escribirá SI si Paul podrá conseguir el
 * reto de su cuñado, sin comer más polvorones de los que le ha pautado el
 * médico, ni superar sus propios límites para cada tipo. Si no debería aceptar
 * el reto se escribirá NO.
 * 
 * Entrada de ejemplo
 * 10 3
 * 10 3 1
 * 1 1 1
 * 8 2
 * 8 8
 * 6 6
 * 10 4
 * 5 4 3 2
 * 2 2 3 3
 * 0 0
 * Salida de ejemplo
 * 
 * SI
 * NO
 * NO
 * 
 */