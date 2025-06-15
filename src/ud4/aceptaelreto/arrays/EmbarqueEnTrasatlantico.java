package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class EmbarqueEnTrasatlantico {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        while (true) {
            // Leer el número de pasajeros
            System.out.print("Ingrese el número de pasajeros: ");
            int n = entrada.nextInt();
            if (n == 0)
                break; // Si no hay pasajeros, terminamos el ciclo

            // Leer las cubiertas de los pasajeros
            int[] cubiertas = new int[n];
            System.out.println("Ingrese las cubiertas de los " + n + " pasajeros (separadas por espacio):");
            for (int i = 0; i < n; i++) {
                cubiertas[i] = entrada.nextInt();
            }

            // Leer el número de acciones
            System.out.print("Ingrese el número de acciones: ");
            int numAcciones = entrada.nextInt();

            // Procesar las acciones
            for (int i = 0; i < numAcciones; i++) {
                System.out.println("\nAcción #" + (i + 1) + ":");
                String accion = entrada.next();

                if (accion.equals("EMBARQUE")) {
                    int cubierta = entrada.nextInt();
                    System.out.println("Realizando EMBARQUE para la cubierta " + cubierta);

                    // Realizamos el embarque eliminando a los pasajeros de esa cubierta
                    int nuevosPasajeros = 0;
                    // Contamos cuántos pasajeros quedan después del embarque
                    for (int j = 0; j < n; j++) {
                        if (cubiertas[j] != cubierta) {
                            nuevosPasajeros++;
                        }
                    }

                    // Imprimir la cantidad de pasajeros restantes
                    System.out.println("Pasajeros restantes después del embarque: " + nuevosPasajeros);

                    // Eliminamos a los pasajeros que embarcaron
                    int[] nuevosCubiertas = new int[nuevosPasajeros];
                    int index = 0;
                    for (int j = 0; j < n; j++) {
                        if (cubiertas[j] != cubierta) {
                            nuevosCubiertas[index++] = cubiertas[j];
                        }
                    }
                    // Actualizamos el arreglo de cubiertas
                    cubiertas = nuevosCubiertas;
                    n = nuevosPasajeros; // Actualizamos la cantidad de pasajeros restantes

                } else if (accion.equals("CONSULTA")) {
                    int pos = entrada.nextInt() - 1; // Convertir a índice base 0
                    System.out.println("Consultando la cubierta del pasajero en la posición " + (pos + 1));

                    // Mostrar la cubierta del pasajero en la posición indicada
                    System.out.println("El pasajero en la posición " + (pos + 1) + " tiene el pasaje para la cubierta "
                            + cubiertas[pos]);
                }
            }

            // Separador entre casos de prueba
            System.out.println("\n* Fin del caso de prueba *\n");
        }

        entrada.close();
    }
}

/*
 * 
 * Embarque en un transatlántico
 * Tiempo máximo: 1,000-5,000 s Memoria máxima: 8192 KiB
 * Los transatlánticos son buques gigantes con infinidad de cubiertas ("pisos")
 * con camarotes, que pueden transportar simultáneamente a un ingente número de
 * viajeros. Esto hace que se necesite una gran cantidad de tiempo hasta que
 * todos los pasajeros embarcan, organizándose grandes líos en los pasillos
 * interiores.
 * 
 * Queen Mary 2 (fotografía de Brian Burnell)
 * Queen Mary 2 (fotografía de Brian Burnell)
 * Para intentar paliar el problema, los responsables de la empresa Cruz Ana Do
 * han decidido que, independientemente de cómo se sitúen los pasajeros en la
 * cola para embarcar, los irán llamando por cubiertas.
 * 
 * Por organizarse, cada vez que hagan embarcar a los ocupantes de una cubierta,
 * los organizadores desean saber cuánta gente queda aún en el puerto esperando.
 * También están interesados en saber, algunas veces, a qué cubierta va alguno
 * de los pasajeros de la cola.
 * 
 * Entrada
 * La entrada consta de una serie de casos de prueba. Cada uno comienza con una
 * línea con un único número que indica la cantidad de pasajeros, 1 ≤ n ≤
 * 1.000.000, a la espera de embarcar. A continuación, en una segunda línea,
 * aparece un número por cada uno de los n pasajeros indicando en qué cubierta
 * tiene su pasaje. Los transatlánticos tienen numeraciones de las cubiertas
 * bastante caprichosas (por ejemplo, por superstición algunos no tienen
 * cubierta número 13) de modo que no se debe asumir que sean consecutivos. Al
 * menos sabemos que siempre son positivos menores que 231.
 * 
 * Tras la descripción de los pasajeros aparece una nueva línea con un número
 * indicando cuántas acciones realizan los responsables del embarque. Estas
 * acciones aparecen enumeradas a continuación, cada una en una línea.
 * 
 * A la acción de embarcar a los ocupantes de una determinada cubierta se la
 * denomina EMBARQUE y viene seguida por el número de la cubierta. A la acción
 * de averiguar la cubierta a la que está destinado uno de los pasajeros que aún
 * quedan en la cola se la denomina CONSULTA, y viene seguido por su posición en
 * la cola (un número entre 1 y el número de pasajeros restantes).
 * 
 * Los responsables del embarque a veces se confunden y llaman a los pasajeros
 * de cubiertas que no existen (o que ya han sido embarcadas). Sin embargo,
 * siempre preguntan la cubierta de pasajeros existentes.
 * 
 * El programa terminará cuando se llegue a un caso de prueba sin pasajeros.
 * 
 * Salida
 * Para cada acción EMBARQUE el programa indicará cuántos pasajeros quedan aún
 * esperando en el puerto para subir al transatlántico una vez que han embarcado
 * todos los viajeros que iban a la cubierta dada. Para cada acción CONSULTA se
 * indicará la cubierta del pasajero situado en esa posición de la cola de
 * viajeros pendiente.
 * 
 * Se escribirá un * después de cada caso de prueba.
 * 
 * Entrada de ejemplo
 * 2
 * 3 4
 * 2
 * EMBARQUE 0
 * CONSULTA 2
 * 10
 * 0 1 0 2 0 3 0 4 0 5
 * 5
 * CONSULTA 1
 * CONSULTA 2
 * EMBARQUE 0
 * CONSULTA 1
 * CONSULTA 2
 * 0
 * Salida de ejemplo
 * 
 * 2
 * 4
 *
 * 0
 * 1
 * 5
 * 1
 * 2
 *
 */
