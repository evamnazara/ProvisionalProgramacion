/*Pasos de la solución
Leer el número de molinos del caso de prueba.
Leer la cantidad de energía producida por cada molino y guardarla en un array.
Leer el número de consultas.
Para cada consulta, sumar la energía de los molinos en el rango indicado.
Imprimir el resultado de cada consulta.
Finalizar cuando el número de molinos sea 0.
*/
package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class MolinosViento {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            // Leer el número de molinos
            System.out.println("Introduce el número de molinos (0 para finalizar):");
            int numeroMolinos = sc.nextInt();

            // Caso de terminación
            if (numeroMolinos == 0) {
                break; // Termina si no hay más molinos
            }

            // Array para almacenar la energía de cada molino
            int[] energiaMolinos = new int[numeroMolinos];

            // Leer la energía de cada molino
            System.out.println("Introduce la cantidad de energía producida por cada molino:");
            for (int i = 0; i < numeroMolinos; i++) {
                energiaMolinos[i] = sc.nextInt();
            }

            // Crear el arreglo de prefijos para sumar rangos de manera eficiente
            int[] prefijos = new int[numeroMolinos + 1];
            prefijos[0] = 0; // Base para que las sumas empiecen en 1 correctamente
            for (int i = 1; i <= numeroMolinos; i++) {
                prefijos[i] = prefijos[i - 1] + energiaMolinos[i - 1];
            }

            // Leer el número de consultas
            System.out.println("Introduce el número de consultas:");
            int numeroConsultas = sc.nextInt();

            // Procesar cada consulta
            System.out.println("Introduce las consultas (inicio y fin del intervalo):");
            for (int i = 0; i < numeroConsultas; i++) {
                int inicio = sc.nextInt(); // Molino inicial
                int fin = sc.nextInt(); // Molino final

                // La suma de energía en el intervalo se calcula usando prefijos
                int sumaEnergia = prefijos[fin] - prefijos[inicio - 1];

                // Imprimir la energía total en el intervalo
                System.out.println("Energía total entre los molinos " + inicio + " y " + fin + ": " + sumaEnergia);
            }
        }
        sc.close();
    }
}

/*
 * Molinos de viento
 * Tiempo máximo: 1,000-5,000 s Memoria máxima: 8192 KiB
 * Los molinos de viento aprovechan la fuerza del viento para conseguir energía.
 * Las empresas eléctricas los instalan en parajes donde la cantidad de este
 * fenómeno natural es grande durante todo el año, para garantizar que cada uno
 * de ellos sea económicamente rentable.
 * 
 * El mantenimiento de estas altas construcciones, lamentablemente, no resulta
 * barato. Tanto es así que una empresa ha decidido desprenderse de unos cuantos
 * de estos molinos, vendiéndolos a otra empresa del sector para que sea ella la
 * que cubra con todos los gastos y, si tiene suerte, con los beneficios.
 * 
 * Esa nueva empresa ha establecido que lo más rentable es comprar, de toda la
 * hilera de molinos que están a la venta, un puñado de ellos consecutivos,
 * porque así se minimizan los desplazamientos que el personal de mantenimiento
 * tiene que hacer entre los molinos que supervisa.
 * 
 * Por lo tanto, ahora le toca elegir qué molinos quiere comprar. Para eso tiene
 * los datos de rendimiento de cada uno de ellos (la cantidad de energía
 * producida) y quiere saber rápidamente cuánta energía produciría un intervalo
 * concreto de molinos.
 * 
 * Entrada
 * La entrada estará compuesta de varios casos de prueba. Cada caso de prueba
 * contiene la descripción de un campo de molinos y una serie de intervalos de
 * los mismos de los que se quiere conocer la cantidad total de energía
 * producida.
 * 
 * En concreto, cada caso de prueba comienza con un número indicando la cantidad
 * de molinos instalados (hasta 1.000.000). A continuación se indica, en otra
 * línea, la cantidad de energía producida por cada uno de ellos que será
 * siempre mayor o igual que 0. El orden de los molinos es el mismo que aparece
 * en el campo de molinos, es decir, los molinos más cercanos geográficamente
 * también aparecen juntos en la entrada.
 * 
 * Tras la descripción de la energía producida vendrá un número que indica el
 * número de consultas que la empresa compradora hará. A continuación, en líneas
 * independientes, aparecerán dos números que indican el número de molino
 * inicial y molino final que marcan el intervalo del que se quiere conocer la
 * energía total producida. El número del molino inicial siempre será menor o
 * igual que el del molino final. La entrada termina con un caso de prueba sin
 * molinos que no deberá ser procesado.
 * 
 * Salida
 * Para cada caso de prueba se debe escribir una línea por cada consulta
 * realizada por la empresa compradora en la que se indicará la energía total
 * producida por los molinos en ese intervalo.
 * 
 * Entrada de ejemplo
 * 5
 * 5 6 7 7 1
 * 3
 * 1 5
 * 1 3
 * 5 5
 * 0
 * Salida de ejemplo
 * 26
 * 18
 * 1
 */