package ud4.aceptaelreto.arrays;

public class AprendiendoaMultiplicar {

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Leer la cantidad de secuencias
        int t = scanner.nextInt();

        // Procesar cada secuencia
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt(); // Longitud de la secuencia
            int[] secuencia = new int[n];

            // Leer la secuencia de números
            for (int j = 0; j < n; j++) {
                secuencia[j] = scanner.nextInt();
            }

            // Llamar a la función que procesa la secuencia
            procesarSecuencia(secuencia);
        }

        // Cerrar el scanner
        scanner.close();
    }

    // Función que procesa la secuencia para encontrar el segmento más grande
    public static void procesarSecuencia(int[] secuencia) {
        int maxProducto = 0;
        int mejorInicio = -1;
        int mejorFin = -1;
        int maxLongitud = 0;

        int inicio = 0;
        int productoActual = 1;

        for (int i = 0; i < secuencia.length; i++) {
            if (secuencia[i] == 0) {
                // Si encontramos un cero, se termina el segmento actual
                if (productoActual != 1) {
                    // Comprobar si el segmento actual tiene un producto mayor
                    if (productoActual > maxProducto || (productoActual == maxProducto && (i - inicio > maxLongitud))) {
                        maxProducto = productoActual;
                        mejorInicio = inicio;
                        mejorFin = i - 1;
                        maxLongitud = i - inicio;
                    }
                }
                // Reiniciar el segmento para el siguiente bloque
                productoActual = 1;
                inicio = i + 1;
            } else {
                // Multiplicar el número actual
                productoActual *= secuencia[i];
            }
        }

        // Comprobar al final si el último segmento fue el mejor
        if (productoActual != 1) {
            if (productoActual > maxProducto
                    || (productoActual == maxProducto && (secuencia.length - inicio > maxLongitud))) {
                maxProducto = productoActual;
                mejorInicio = inicio;
                mejorFin = secuencia.length - 1;
                maxLongitud = secuencia.length - inicio;
            }
        }

        // Imprimir el resultado
        if (maxProducto == 0) {
            System.out.println("SIGUE BUSCANDO");
        } else {
            System.out.println(maxLongitud + " -> [" + mejorInicio + "," + mejorFin + "]");
        }
    }
}

/*
 * Aprendiendo a multiplicar
 * Tiempo máximo: 1,000-2,000 s Memoria máxima: 4096 KiB
 * El pequeño Samuel está aprendiendo a multiplicar. Su forma de ser le lleva a
 * querer aprenderlo todo, por lo que en cuanto ve una ristra de números se pone
 * a multiplicarlos uno tras otro hasta el final. No le asusta que sean número
 * grandes ni que el resultado tenga muchos dígitos.
 * 
 * Lo que sí le molesta es que habitualmente el resultado final de la
 * multiplicación de todos esos números (¡incluso miles de ellos!) termine
 * siendo cero. Y no le gusta porque, sabe, eso hace que no practique tanto como
 * le gustaría.
 * 
 * Ahora nos ha pedido ayuda para aconsejarle qué números multiplicar. Cuando se
 * encuentra una secuencia de números nos pregunta qué segmento de ellos
 * multiplicar de forma que sea lo más grande posible y que su resultado no sea
 * cero.
 * 
 * Entrada
 * La entrada comenzará con la cantidad de secuencias de números que tendremos
 * que procesar. Cada secuencia aparecerá en dos líneas en la entrada, la
 * primera contendrá la longitud de la secuencia (0 ≤ n ≤ 10.000), y la segunda
 * tendrá los n números enteros.
 * 
 * Salida
 * Para cada secuencia se indicará, en una línea independiente, la cantidad
 * total de números que Samuel podrá multiplicar y su lugar en la secuencia
 * (donde el primer elemento es el 0). Mira el formato exacto en el ejemplo. Si
 * hay varios segmentos posibles con la misma longitud, se debe mostrar el que
 * aparezca antes en la secuencia.
 * 
 * Si no hay ningún segmento posible que Samuel pueda multiplicar, se escribirá
 * "SIGUE BUSCANDO".
 * 
 * Entrada de ejemplo
 * 4
 * 4
 * 6 7 8 9
 * 10
 * 0 8 9 7 0 1 8 9 0 2
 * 1
 * 0
 * 1
 * 1
 * Salida de ejemplo
 * 
 * 4 -> [0,3]
 * 3 -> [1,3]
 * SIGUE BUSCANDO
 * 1 -> [0,0]
 * 
 */
