package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class LoteriaAtletica {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Pedir el número de casos de prueba
        System.out.print("Introduce el número de casos de prueba: ");
        int t = entrada.nextInt();

        // Procesar cada caso de prueba
        for (int i = 0; i < t; i++) {
            System.out.println("\nProcesando el caso de prueba #" + (i + 1));

            // Leer el número de décimos disponibles en esta administración
            System.out.print("Introduce el número de décimos disponibles: ");
            int n = entrada.nextInt();

            // Leer los décimos en un array
            System.out.println("Introduce los números de los décimos:");
            int[] decimos = new int[n];
            for (int j = 0; j < n; j++) {
                decimos[j] = entrada.nextInt();
            }

            // Contar cuántos números son pares
            int countPares = 0;
            for (int j = 0; j < n; j++) {
                if (decimos[j] % 2 == 0) {
                    countPares++;
                }
            }

            // Mostrar el resultado para este caso
            System.out.println("La peña atlética puede comprar " + countPares + " décimos.");
        }

        // Cerrar el scanner
        entrada.close();
    }
}

/*
 * 
 * La lotería de la peña Atlética
 * El Atlético de Madrid es un conocido equipo de fútbol español, muy famoso por
 * su incondicional afición que llega a autodenominarse la mejor del mundo pues,
 * dicen, no decae ni siquiera cuando el rendimiento del equipo es bajo.
 * 
 * La historia del Atlético de Madrid en Europa es curiosa: todas sus finales
 * han sido en años pares. En los años 1974 y 2014 llegaron a la final de la
 * UEFA Champion League (eso sí, en ninguna de las dos ocasiones pudieron
 * ganarla), mientras que a la final de la UEFA Europa League llegaron (y
 * ganaron) en 2010 y 2012.
 * 
 * Con este palmarés, no es de extrañar que una peña atlética aficionada a la
 * numerología haya decidido que los números de la lotería que comprará serán
 * siempre números pares. Y ahora nos han pedido una aplicación que se descargue
 * la lista de los distintos décimos que venden en distintas administraciones de
 * lotería y nos diga cuántos de esos décimos pueden comprar.
 * 
 * Entrada
 * La entrada comienza con una línea que contiene el número de casos de prueba
 * que aparecen a continuación.
 * 
 * Cada caso de prueba, que se compone de dos líneas, se corresponde con una
 * administración de lotería. La primera línea tiene un único entero con el
 * número de décimos distintos que tiene la administración (como mucho 10.000),
 * mientras que la segunda línea contiene la lista con los números de cada
 * décimo (números entre 0 y 99.999).
 * 
 * Salida
 * Por cada caso de prueba aparecerá una línea independiente con el número de
 * décimos que la peña podría comprar (si el presupuesto se lo permite) de esa
 * administración.
 * 
 * Entrada de ejemplo
 * 1
 * 10
 * 1 2 3 4 5 6 7 8 9 10
 * Salida de ejemplo
 * 
 * 5
 */