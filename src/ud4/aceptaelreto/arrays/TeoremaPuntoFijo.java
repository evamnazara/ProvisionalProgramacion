package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class TeoremaPuntoFijo {

    // Función para calcular el máximo común divisor (MCD) de dos números
    public static int mcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Función para calcular el mínimo común múltiplo (MCM) de dos números
    public static int mcm(int a, int b) {
        return (a * b) / mcd(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Procesar cada caso de prueba
        while (true) {
            // Leer el número de moléculas
            int n = sc.nextInt();

            // Si n es 0, terminamos
            if (n == 0) {
                break;
            }

            // Leer el vector de movimientos
            int[] movimientos = new int[n];
            for (int i = 0; i < n; i++) {
                movimientos[i] = sc.nextInt() - 1; // Restamos 1 para trabajar con índices 0-based
            }

            // Un array para marcar las moléculas que ya hemos procesado
            boolean[] visitado = new boolean[n];
            int ciclos = 1; // Para acumular el MCM de los tamaños de los ciclos

            // Detectar los ciclos en la permutación
            for (int i = 0; i < n; i++) {
                if (!visitado[i]) {
                    // Encontramos un ciclo
                    int longitudCiclo = 0;
                    int j = i;

                    // Seguimos el ciclo hasta volver a la posición inicial
                    while (!visitado[j]) {
                        visitado[j] = true;
                        j = movimientos[j]; // Ir al siguiente índice según el movimiento
                        longitudCiclo++;
                    }

                    // Calcular el MCM entre el ciclo actual y el acumulado
                    ciclos = mcm(ciclos, longitudCiclo);
                }
            }

            // Imprimir el número de movimientos necesarios
            System.out.println(ciclos);
        }

        sc.close();
    }
}

/*
 * 
 * El teorema del punto fijo
 * En la familia de teoremas matemáticos llamados del punto fijo, Brouwer
 * estudió uno que, parece ser, explicaba con la analogía de remover una taza de
 * café con azúcar. Brouwer afirmaba que en todo momento hay un punto/molécula
 * de la taza que no habrá cambiado de lugar.
 * 
 * Nosotros no estudiaremos ese teorema, pero nos quedamos con la idea de que,
 * al mover la taza de café, sus moléculas intercambian sus lugares para
 * terminar en sitios completamente distintos. Por poner un ejemplo reducido (en
 * el que ni siquiera se cumple el teorema del punto fijo), la molécula 1 podría
 * haber pasado a ocupar el lugar que tenía la molécula 2, la molécula 2 pasar
 * donde estaba la molécula 3, y la molécula 3 ocupar el lugar que originalmente
 * tenía la 1.
 * 
 * Ejemplo de movimiento de taza de café con tres moléculas
 * Si somos capaces de replicar el mismo movimiento una y otra vez, llega un
 * momento en el que la taza de café vuelve a su estado original:
 * 
 * Ejemplo de ciclo completo de movimientos
 * La pregunta que nos hacemos es, dada la descripción del intercambio de
 * moléculas que conseguimos con el movimiento de la taza de café, ¿cuántas
 * veces tendremos que repetirlo para que el estado de la taza vuelva a ser el
 * mismo que al principio?
 * 
 * Entrada
 * La entrada estará compuesta por distintos casos de prueba. Cada uno de ellos
 * consta de dos líneas, una primera con el número de moléculas en la taza de
 * café (1 ≤ n ≤ 100) y otra indicando qué movimiento de moléculas se realizan
 * cada vez que se mueve la taza.
 * 
 * El movimiento viene definido con n enteros que indican, para cada posición de
 * una molécula, en qué posición termina la molécula que ocupaba ese lugar.
 * 
 * La entrada termina con una taza de café sin moléculas, que no debe
 * procesarse.
 * 
 * Salida
 * Para cada caso de prueba se escribirá el número de veces que hay que mover la
 * taza de café para que cada molécula recupere su lugar original. Se garantiza
 * que el número no excederá 109.
 * 
 * Entrada de ejemplo
 * 3
 * 1 2 3
 * 3
 * 2 3 1
 * 4
 * 2 1 4 3
 * 0
 * Salida de ejemplo
 * 1
 * 3
 * 2
 */