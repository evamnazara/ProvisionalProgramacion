package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class MadrigueraConejo {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Bucle para procesar cada caso de prueba
        while (true) {
            // Pedimos al usuario el número de conejos y agujeros
            System.out.println("--------------------------------------------------------");
            System.out.print("Introduce el número de conejos y agujeros (0 para finalizar): ");
            int N = entrada.nextInt();

            // Si N es 0, terminamos el programa
            if (N == 0) {
                System.out.println("Fin del programa.");
                break;
            }

            // Pedimos al usuario los diámetros de los agujeros
            System.out.print("Introduce los diámetros de los agujeros, separados por espacios: ");
            int[] agujeros = new int[N];
            for (int i = 0; i < N; i++) {
                agujeros[i] = entrada.nextInt();
            }

            // Variable para llevar la cuenta de la distancia total recorrida por todos los
            // conejos
            int distanciaTotal = 0;

            // Recorremos cada conejo (cada agujero por el que entra)
            System.out.println("Procesando los movimientos de los conejos...");
            for (int i = 0; i < N; i++) {
                // Cada conejo entra por el agujero agujeros[i], y tiene que buscar el primer
                // agujero más grande
                // que se encuentra a la derecha de su entrada.
                for (int j = i + 1; j < N; j++) {
                    // Si encontramos un agujero más grande, el conejo puede salir por él
                    if (agujeros[j] > agujeros[i]) {
                        // Sumar la distancia recorrida por este conejo
                        distanciaTotal += (j - i);
                        System.out.println("El conejo en el agujero " + (i + 1) + " ha recorrido una distancia de "
                                + (j - i) + " unidades.");
                        break; // Este conejo ya salió, así que salimos del bucle
                    }
                }
            }

            // Mostrar la distancia total recorrida por todos los conejos
            System.out.println("La distancia total recorrida por los conejos es: " + distanciaTotal);
            System.out.println("--------------------------------------------------------");
        }

        // Cerrar el scanner
        entrada.close();
    }
}

/*
 * VERSION VALORES UNO A UNO
 * package arrays;
 * 
 * import java.util.Scanner;
 * 
 * public class MadrigueraConejo {
 * 
 * public static void main(String[] args) {
 * Scanner entrada = new Scanner(System.in);
 * 
 * // Bucle para procesar cada caso de prueba
 * while (true) {
 * // Pedimos al usuario el número de conejos y agujeros
 * System.out.println("--------------------------------------------------------"
 * );
 * System.out.
 * print("Introduce el número de conejos y agujeros (0 para finalizar): ");
 * int N = entrada.nextInt();
 * 
 * // Si N es 0, terminamos el programa
 * if (N == 0) {
 * System.out.println("Fin del programa.");
 * break;
 * }
 * 
 * // Inicializamos el arreglo para los diámetros de los agujeros
 * int[] agujeros = new int[N];
 * 
 * // Pedimos al usuario que ingrese el diámetro de cada agujero uno por uno
 * System.out.println("Introduce los diámetros de los " + N +
 * " agujeros uno por uno:");
 * for (int i = 0; i < N; i++) {
 * System.out.print("Diámetro del agujero " + (i + 1) + ": ");
 * agujeros[i] = entrada.nextInt();
 * }
 * 
 * // Variable para llevar la cuenta de la distancia total recorrida por todos
 * los conejos
 * int distanciaTotal = 0;
 * 
 * // Recorremos cada conejo (cada agujero por el que entra)
 * System.out.println("Procesando los movimientos de los conejos...");
 * for (int i = 0; i < N; i++) {
 * // Cada conejo entra por el agujero agujeros[i], y tiene que buscar el primer
 * agujero más grande
 * // que se encuentra a la derecha de su entrada.
 * for (int j = i + 1; j < N; j++) {
 * // Si encontramos un agujero más grande, el conejo puede salir por él
 * if (agujeros[j] > agujeros[i]) {
 * // Sumar la distancia recorrida por este conejo
 * distanciaTotal += (j - i);
 * System.out.println("El conejo en el agujero " + (i + 1) +
 * " ha recorrido una distancia de " + (j - i) + " unidades.");
 * break; // Este conejo ya salió, así que salimos del bucle
 * }
 * }
 * }
 * 
 * // Mostrar la distancia total recorrida por todos los conejos
 * System.out.println("La distancia total recorrida por los conejos es: " +
 * distanciaTotal);
 * System.out.println("--------------------------------------------------------"
 * );
 * }
 * 
 * // Cerrar el scanner
 * entrada.close();
 * }
 * }
 * 
 */

/*
 * La madriguera del Señor Conejo
 * Dos conejos europeos juntos
 * El Señor Conejo y su familia tienen una madriguera muy particular. Para poder
 * refugiarse rápidamente cuando aparece el señor Zorro, cada conejo entra en la
 * madriguera por un agujero distinto. Estos agujeros están situados a lo largo
 * de una línea recta y, por supuesto, están hechos a la medida exacta de cada
 * conejo. Tanto es así que cuando celebran una fiesta y comen más de la cuenta,
 * los conejos no son capaces de salir por el agujero que les corresponde. En
 * estas situaciones cada conejo tiene que buscar un agujero más grande que el
 * suyo para poder salir, y normalmente se arma un follón considerable.
 * 
 * Así que han decidido organizarse de la siguiente manera: los conejos siempre
 * saldrán por el primer agujero que puedan que se encuentre a la derecha de
 * aquel por el que entraron. Es decir, para salir todos se mueven hacia la
 * derecha, y cuando encuentran el primer agujero más grande que el suyo salen.
 * Al final de la madriguera han construido un agujero lo suficientemente grande
 * como para que todos puedan salir por él si es necesario. En particular, el
 * último conejo siempre tiene que salir por este agujero.
 * 
 * Con este modo de actuar todos los conejos deberán moverse, al menos, una
 * unidad de distancia. ¿Cuál es la suma total de las distancias recorridas por
 * todos los conejos?
 * 
 * Entrada
 * La entrada está formada por distintos casos de prueba, cada uno en una línea
 * distinta. En cada línea aparece en primer lugar un número entero N (1 ≤ N ≤
 * 500.000), el número de conejos y agujeros. A continuación aparece una lista
 * con N números enteros d1, d2, ..., dN, que representan los diámetros de cada
 * uno de los N agujeros por los que entran los conejos. Los diámetros de todos
 * los agujeros satisfacen 1 ≤ di ≤ 20.
 * 
 * El final de la entrada se indica con una línea con un único 0 que no se debe
 * procesar.
 * 
 * Salida
 * Para cada caso de prueba, se escribirán una línea con la distancia total
 * recorrida por todos los conejos hasta encontrar el agujero por el que salir.
 * Ten en cuenta que aunque cada conejo entra por un agujero distinto, puede
 * ocurrir que varios salgan por el mismo sitio.
 * 
 * Entrada de ejemplo
 * 4 1 2 3 4
 * 4 2 1 3 4
 * 5 5 4 3 2 1
 * 0
 * Salida de ejemplo
 * 4
 * 5
 * 15
 * 
 */
