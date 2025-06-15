package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class HoustonVerificacion {

    public static void main(String[] args) {
        // Crear un scanner para leer la entrada
        Scanner sc = new Scanner(System.in);

        // Leer el número de grupos de números en los vectores A y B
        int numGruposA = sc.nextInt();
        int numGruposB = sc.nextInt();

        // Leer los grupos del vector A
        int[] A = new int[10000000]; // El tamaño del arreglo es suficientemente grande
        int aIndex = 0;
        for (int i = 0; i < numGruposA; i++) {
            int repeticionesA = sc.nextInt();
            int valorA = sc.nextInt();
            // Descomprimir el grupo
            for (int j = 0; j < repeticionesA; j++) {
                A[aIndex++] = valorA;
            }
        }

        // Leer los grupos del vector B
        int[] B = new int[10000000]; // El tamaño del arreglo es suficientemente grande
        int bIndex = 0;
        for (int i = 0; i < numGruposB; i++) {
            int repeticionesB = sc.nextInt();
            int valorB = sc.nextInt();
            // Descomprimir el grupo
            for (int j = 0; j < repeticionesB; j++) {
                B[bIndex++] = valorB;
            }
        }

        // Verificamos que ambos vectores tengan el mismo tamaño
        if (aIndex != bIndex) {
            System.out.println("Error: los vectores tienen tamaños diferentes.");
        }

        // Calcular el producto escalar
        long productoEscalar = 0;
        for (int i = 0; i < aIndex; i++) {
            productoEscalar += (long) A[i] * B[i];
        }

        // Imprimir el resultado
        System.out.println(productoEscalar);

        // Cerrar el scanner
        sc.close();
    }
}

/*
 * Houston, necesito una verificación
 * Tiempo máximo: 1,000-2,000 s Memoria máxima: 4096 KiB
 * Fotograma de la película Apolo 13 donde se ven los cálculos de James Lovell
 * La séptima misión tripulada del programa Apolo de la NASA, Apolo 13, se hizo
 * mundialmente famosa en 1970. Tras dos días alejándose de la tierra, una
 * explosión en un tanque de oxígeno obligó a abortar la misión y regresar sin
 * tocar la Luna. Las dificultades a las que se enfrentaron tanto los ingenieros
 * de tierra como los propios astronautas y el hecho de que finalmente
 * regresaran sanos y salvos hizo que muchos etiquetaran la misión como un
 * fracaso triunfal.
 * 
 * En 1995 se estrenó una película con el mismo nombre en la que se relata la
 * aventura. En un momento de la misma James Lovell, el comandante de la misión
 * encarnado por Tom Hanks, hace unos cálculos de conversión de ángulos y pide a
 * control de tierra que verifiquen los resultados. Acto seguido, dicta los
 * datos y se ve como varios ingenieros en Houston comprueban que,
 * efectivamente, los cálculos son correctos.
 * 
 * En lugar de conversiones de ángulos, el cálculo bien podría haber sido el
 * producto escalar de dos vectores. Esta operación consiste en multiplicar los
 * componentes de cada vector uno a uno y sumar sus resultados.
 * 
 * Por ejemplo, si tenemos dos vectores A y B con 5 componentes: A=(2,5,5,4,4) y
 * B=(1,1,3,3,3), el producto escalar de ambos es:
 * 
 * A · B = 2 × 1 + 5 × 1 + 5 × 3 + 4 × 3 + 4 × 3 = 2 + 5 + 15 + 12 + 12 = 46
 * 
 * Explicación del producto escalar con el caso de ejemplo
 * Eso sí, como en la situación de emergencia en la que estaban el tiempo
 * apremiaba, en lugar de dictar el contenido de cada vector componente a
 * componente, el astronauta podría "comprimirla" en bloques de valores
 * consecutivos iguales. Así, la descripción del vector A anterior sería algo
 * como "un dos, dos cincos y dos cuatros". En este caso no se ahorra nada, pero
 * si el vector tiene diez millones de números en como mucho 30.000 grupos, la
 * compresión puede significar que termine de dictarlos antes de la reentrada.
 * 
 * Entrada
 * La entrada estará compuesta por varios casos de prueba, cada uno ocupando
 * tres líneas.
 * 
 * La primera línea contiene el número de grupos de números de los vectores A y
 * B respectivamente. Ambos tendrán como mínimo un grupo, y no más de 30.000.
 * 
 * Las dos líneas siguientes contienen la descripción de los vectores A y B.
 * Cada una contiene una pareja de números por cada grupo de valores
 * consecutivos; el primero indica el número de repeticiones (al menos 1) y el
 * segundo el valor que se repite (un número entre 0 y 50). Se garantiza que el
 * número de componentes de ambos vectores coincide y que no excederá
 * 10.000.000.
 * 
 * Salida
 * Por cada caso de prueba se escribirá una única línea con el producto escalar
 * de A y B.
 * 
 * Entrada de ejemplo
 * 3 2
 * 1 2 2 5 2 4
 * 2 1 3 3
 * 1 1
 * 1000000 40
 * 1000000 40
 * Salida de ejemplo
 * 
 * 46
 * 1600000000
 * 
 */