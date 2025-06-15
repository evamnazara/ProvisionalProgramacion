package ud4.aceptaelreto.arrays;

public class LaColaDePapaNoel {

    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada
        java.util.Scanner sc = new java.util.Scanner(System.in);

        // Leer el número de casos de prueba
        int casos = sc.nextInt();

        // Procesar cada caso de prueba
        for (int i = 0; i < casos; i++) {
            // Leer el número de niños (n) y la posición de Aitor (a)
            int n = sc.nextInt();
            int a = sc.nextInt() - 1; // Convertimos a la posición 0-indexada

            // Crear un array para almacenar los regalos de los niños
            int[] regalos = new int[n];

            // Leer la cantidad de regalos que cada niño quiere pedir
            for (int j = 0; j < n; j++) {
                regalos[j] = sc.nextInt();
            }

            // Simulación de la cola de Papá Noel
            int tiempoEspera = 0; // Tiempo total que Marcos tiene que esperar
            int index = 0; // Indicador para la posición del primer niño en la cola

            // Continuamos hasta que Aitor haya pedido todos sus regalos
            while (regalos[a] > 0) {
                // Si el niño en la posición actual tiene regalos por pedir
                if (regalos[index] > 0) {
                    // Aumentamos el tiempo total por cada regalo que se le da
                    tiempoEspera += 2;

                    // Si es Aitor, se le resta un regalo
                    if (index == a) {
                        regalos[index]--;
                    } else {
                        // Si no es Aitor, simplemente pasamos al siguiente niño
                        regalos[index]--;
                    }
                }

                // Después de cada atención, avanzamos al siguiente niño (en un ciclo circular)
                index = (index + 1) % n;
            }

            // Imprimir el tiempo total que Marcos tiene que esperar
            System.out.println(tiempoEspera);
            sc.close();
        }
    }
}

/*
 * En la cola de Papá Noel
 * Tiempo máximo: 2,000 s Memoria máxima: 4096 KiB
 * Niño hablando en secreto a Papá Noel
 * A Marcos Tilla le ha tocado llevar a su hermano Aitor a ver a Papá Noel para
 * pedirle los regalos. En la cola hay muchos niños, cada uno con varios regalos
 * que pedir, pero Papá Noel ha decidido que sólo atenderá un regalo por niño
 * cada vez. Así que cuando un niño acaba de pedirle un regalo, se va al final
 * de la cola y le toca volver a esperar para pedir el siguiente.
 * 
 * Papá Noel está 2 minutos con un niño cada vez que le pide un regalo, y a
 * Marcos se le está haciendo interminable. Ha quedado después con su novia
 * Merce Bolla y necesita calcular el tiempo que le queda hasta que su hermano
 * pida todo los regalos. ¿Le puedes ayudar?
 * 
 * Entrada
 * La entrada comenzará con un número indicando cuántos casos de prueba habrá
 * que procesar.
 * 
 * Cada caso de prueba comenzará con dos números, n y a, indicando cuántos niños
 * hay en la cola, y la posición que ocupa Aitor respectivamente, 1 ≤ a ≤ n ≤
 * 100.
 * 
 * A continuación, seguirán n enteros positivos con el número de regalos que
 * quiere pedir cada niño. Ninguno ha sido tan bueno como para atreverse a pedir
 * más de 100 regalos.
 * 
 * Salida
 * Por cada caso de prueba, el programa escribirá una línea con un número
 * indicando el número de minutos que Marcos tendrá que esperar hasta que su
 * hermano Aitor pida todos los regalos a Papá Noel.
 * 
 * Entrada de ejemplo
 * 3
 * 1
 * 1
 * 3
 * 3
 * 2
 * 2 2 2
 * 5
 * 4
 * 2 2 1 2 1
 * Salida de ejemplo
 * 
 * 6
 * 10
 * 16
 * 
 */
