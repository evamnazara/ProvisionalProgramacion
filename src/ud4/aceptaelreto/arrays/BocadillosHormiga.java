package ud4.aceptaelreto.arrays;

public class BocadillosHormiga {

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        while (true) {
            // Leer el número de cortezas
            int n = scanner.nextInt();

            // Si el número de cortezas es 0, terminamos el programa
            if (n == 0) {
                break;
            }

            // Leer los tamaños de los trozos de corteza
            int[] cortezas = new int[n];
            int total = 0; // Suma total de todos los trozos
            for (int i = 0; i < n; i++) {
                cortezas[i] = scanner.nextInt();
                total += cortezas[i]; // Acumulamos el total de todos los trozos
            }

            // Intentamos encontrar una tapa válida
            int respuestaPosicion = -1;
            int sumaIzquierda = 0;

            for (int i = 0; i < n; i++) {
                sumaIzquierda += cortezas[i]; // La suma de los trozos hasta la tapa

                if (sumaIzquierda == total - sumaIzquierda) {
                    // Si la suma de los trozos a la izquierda es igual a los trozos a la derecha
                    respuestaPosicion = i + 1; // Posición de la tapa (1-based index)
                    break;
                }
            }

            // Si se encontró una tapa válida
            if (respuestaPosicion != -1) {
                System.out.println("SI " + respuestaPosicion);
            } else {
                System.out.println("NO");
            }

            // Imprimir tres guiones después de cada caso de prueba
            System.out.println("---");
        }

        // Cerrar el scanner
        scanner.close();
    }
}

/*
 * Los bocadillos de la hormiga reina
 * Tiempo máximo: 1,000-4,000 s Memoria máxima: 4096 KiB
 * Hormiga
 * Ser hormiga reina no es fácil. No vamos a enumerar aquí todos y cada uno de
 * los problemas que tiene que solucionar a lo largo del día; baste con uno de
 * ellos a modo de ejemplo.
 * 
 * Cuando llega la hora de la merienda tiene que ponerse a hacer bocadillos para
 * toda su prole. Migas de pan y de corteza no le faltan, pero cada uno de los
 * cachitos de corteza tiene un tamaño distinto, así que conseguir dos cachos
 * iguales para poder poner en la base del bocadillo y en la tapa es una tarea
 * complicada. Afortunadamente sus hijas son bastante inocentes y si la tapa
 * inferior del bocadillo está formada por distintos cachitos de corteza no se
 * darán cuenta, siempre y cuanto la corteza superior cubra exactamente todos
 * los cachos de corteza de la capa inferior.
 * 
 * Como no tiene tiempo que perder ha decidido simplificar las cosas. Ha puesto
 * en fila todos los cachos de corteza que hay en el hormiguero (¡son muchos!).
 * Para hacer el primer bocadillo simplemente busca desde la izquierda de la
 * hilera hacia el final un cacho de corteza que sirva de tapa de todos los
 * trocitos que quedan a la derecha. ¿Podrá hacer un bocadillo? ¿Con qué tapa?
 * 
 * Entrada
 * La entrada está compuesta por distintos casos de prueba, cada uno de ellos
 * ocupando dos líneas. La primera línea indica el número de cortezas que hay en
 * el hormiguero (como mucho 100.000); la segunda línea contiene los tamaños de
 * cada uno de los trocitos, según han quedado dispuestos para hacer los
 * bocadillos. Todos los tamaños serán números positivos y la suma de todos
 * ellos no será superior a 109.
 * 
 * La entrada termina con un caso de prueba sin cortezas, que no debe
 * procesarse.
 * 
 * Salida
 * Para cada caso de prueba se indicará si se podrá hacer un bocadillo
 * utilizando el mecanismo simplificado de la reina explicado más arriba que
 * tenga una tapa con la misma longitud que la base. En caso negativo se
 * indicará NO. En caso afirmativo se escribirá SI seguido de la posición que
 * ocupa en la hilera original la tapa superior del bocadillo (empezando a
 * contar desde el 1).
 * 
 * Si hay varios posibles bocadillos, se montará el más grande posible; después
 * de todo las hormigas son pequeñas, pero están hambrientas.
 * 
 * Entrada de ejemplo
 * 10
 * 3 5 8 25 12 15 5 7 1 2
 * 7
 * 6 2 3 1 1 8 12
 * 8
 * 9 45 5 20 10 1 6 3
 * 0
 * Salida de ejemplo
 * 
 * SI 6
 * NO
 * SI 2
 * 
 */
