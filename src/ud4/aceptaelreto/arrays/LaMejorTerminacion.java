package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class LaMejorTerminacion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Leer el número de sorteos anteriores
            int n = scanner.nextInt();
            if (n == 0)
                break; // Si es 0, terminamos

            // Array para contar las apariciones de cada terminación (0-9)
            int[] contadorTerminaciones = new int[10];

            // Leer los números premiados
            for (int i = 0; i < n; i++) {
                int numeroPremiado = scanner.nextInt();
                int ultimaCifra = numeroPremiado % 10; // Obtener la última cifra
                contadorTerminaciones[ultimaCifra]++;
            }

            // Encontrar la terminación más repetida
            int maxFrecuencia = 0;
            int terminacionMasFrecuente = -1;
            boolean varias = false;

            for (int i = 0; i < 10; i++) {
                if (contadorTerminaciones[i] > maxFrecuencia) {
                    maxFrecuencia = contadorTerminaciones[i];
                    terminacionMasFrecuente = i;
                    varias = false;
                } else if (contadorTerminaciones[i] == maxFrecuencia && maxFrecuencia > 0) {
                    varias = true;
                }
            }

            // Imprimir el resultado
            if (varias) {
                System.out.println("VARIAS");
            } else {
                System.out.println(terminacionMasFrecuente);
            }
        }

        scanner.close();
    }
}

/*
 * La mejor terminación
 * Tiempo máximo: 1,000-2,000 s Memoria máxima: 4096 KiB
 * Décimo de la lotería de Navidad
 * En los sorteos de la lotería más mediáticos, como el del Gordo de Navidad o
 * el del Niño, es habitual que los fetichistas busquen números con algún tipo
 * de significado extraño o que los matemáticos y estadísticos se entretengan
 * informando sobre los números más habituales.
 * 
 * Esto último es interesante si queremos maximizar la probabilidad de ganar
 * algo. Dado que los números que terminan con el mismo dígito que el del premio
 * principal tienen un reintegro, una buena forma de intentar, al menos, no
 * perder dinero es jugar un número con la terminación más habitual en el
 * histórico de sorteos.
 * 
 * Siendo puristas, la probabilidad de que salga un número es independiente de
 * lo que haya ocurrido en años anteriores. Pero es tan tentador ignorar esto
 * que no puedes resistirte.
 * 
 * Entrada
 * La entrada estará compuesta por múltiples casos de prueba que el programa
 * deberá procesar. Cada uno comienza con un número n (1 ≤ n ≤ 10.000) indicando
 * de cuántos sorteos anteriores conocemos el premio principal. A continuación
 * aparecerán, en otra línea, los n números premiados en esos sorteos. Los
 * números tendrán como mucho 5 dígitos.
 * 
 * La entrada terminará con un caso sin sorteos, que no deberá procesarse.
 * 
 * Salida
 * Por cada caso de prueba el programa escribirá la terminación (de un dígito)
 * más premiada. Si hay varias terminaciones que aparecen el mismo número
 * (máximo) de veces, se escribirá "VARIAS".
 * 
 * Entrada de ejemplo
 * 3
 * 00004 03847 39804
 * 2
 * 39875 09877
 * 0
 * Salida de ejemplo
 * 4
 * VARIAS
 * 
 */