package ud4.aceptaelreto.arrays;

public class Conjuritis {

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        while (true) {
            // Leer el número de hechizos
            int n = scanner.nextInt();

            // Si el número de hechizos es 0, terminamos el proceso
            if (n == 0) {
                break;
            }

            // Leer los daños a priori de los hechizos
            int[] hechizos = new int[n];
            for (int i = 0; i < n; i++) {
                hechizos[i] = scanner.nextInt();
            }

            // Leer el daño total real
            int dañoTotalReal = scanner.nextInt();

            // Llamar a la función para encontrar los dos hechizos que fallaron
            encontrarConjurosFallidos(hechizos, dañoTotalReal);
        }

        // Cerrar el scanner
        scanner.close();
    }

    // Función para encontrar los dos hechizos que fallaron
    public static void encontrarConjurosFallidos(int[] hechizos, int dañoTotalReal) {
        // Calcular la suma total de los daños a priori
        int sumaTotal = 0;
        for (int i = 0; i < hechizos.length; i++) {
            sumaTotal += hechizos[i];
        }

        // La diferencia entre la suma total a priori y el daño real es la suma de los
        // dos hechizos fallidos
        int diferencia = sumaTotal - dañoTotalReal;

        // Usar dos punteros para buscar la pareja que haga esa diferencia
        int izquierda = 0;
        int derecha = hechizos.length - 1;

        while (izquierda < derecha) {
            int suma = hechizos[izquierda] + hechizos[derecha];

            if (suma == diferencia) {
                // Si encontramos la pareja, la imprimimos
                System.out.println(hechizos[izquierda] + " " + hechizos[derecha]);
                return;
            } else if (suma < diferencia) {
                // Si la suma es menor, mover el puntero izquierdo hacia la derecha
                izquierda++;
            } else {
                // Si la suma es mayor, mover el puntero derecho hacia la izquierda
                derecha--;
            }
        }
    }
}

/*
 * Conjuritis
 * Tiempo máximo: 2,000 s Memoria máxima: 4096 KiB
 * Hechicero invocando un conjuro
 * El Doctor Extraño es un poderoso hechicero entrenado por El Anciano, y
 * sucesor del título de "Hechicero supremo" a su muerte. A pesar de ser un
 * superhéroe muy poderoso, ahora está en un apuro.
 * 
 * El Barón Mordo ha sometido al Doctor Extraño a un hechizo llamado
 * "conjuritis" que le impide pensar en conjuros con claridad y en su mente se
 * mezclan conjuros reales y conjuros falsos.
 * 
 * Tras invocar una sucesión de conjuros, el Doctor Extraño está convencido de
 * que dos le han fallado. Sabe cuánto daño inflinge, a priori, cada uno de sus
 * conjuros, y sabe cuánto daño real ha causado en total en el villano destino
 * de sus hechizos. Ahora necesita saber qué dos han fallado por estar siendo
 * afectados por su conjuritis para no usarlos otra vez.
 * 
 * Entrada
 * El programa deberá procesar, de la entrada estándar, múltiples casos de
 * prueba.
 * 
 * Cada caso de prueba comienza con un número 3 ≤ N ≤ 200.000 que indica la
 * cantidad de hechizos invocados. A continuación sigue una línea con N números
 * con el daño que, a priori, inflinge cada uno. La lista está ordenada de menor
 * a mayor, y no hay dos hechizos iguales. El hechizo menos poderoso posible
 * sólo tiene poder 1, y el más fuerte alcanza 500.000.
 * 
 * Por útlimo, aparece una tercera línea indicando el daño total causado sobre
 * el villano que ha recibido todos los hechizos.
 * 
 * La entrada termina con un caso sin hechizos, que no deberá procesarse.
 * 
 * Salida
 * Por cada caso de prueba, el programa escribirá, en la salida estándar, el
 * poder a priori de los dos hechizos que no han funcionado, de menor a mayor.
 * Se garantiza que habrá solución y que será única.
 * 
 * Entrada de ejemplo
 * 3
 * 1 2 3
 * 3
 * 4
 * 1 3 5 9
 * 10
 * 5
 * 1 3 5 6 7
 * 18
 * 0
 * Salida de ejemplo
 * 1 2
 * 3 5
 * 1 3
 * 
 */
