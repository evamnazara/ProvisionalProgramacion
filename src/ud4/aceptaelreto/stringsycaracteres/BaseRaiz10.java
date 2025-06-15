package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class BaseRaiz10 {

    public static void main(String[] args) {
        // Crear un scanner para leer la entrada
        Scanner sc = new Scanner(System.in);

        // Leer casos de prueba hasta que se acaben las líneas
        while (sc.hasNextLine()) {
            // Leer el número en base 10 como un String
            String numeroBase10 = sc.nextLine();

            // Si el número es "0", simplemente imprimir "0"
            if (numeroBase10.equals("0")) {
                System.out.println("0");
                continue;
            }

            // Convertir el número base 10 en base raiz de 10
            String resultado = convertirABaseRaiz10(numeroBase10);

            // Imprimir el resultado en base raiz de 10
            System.out.println(resultado);
        }

        // Cerrar el scanner
        sc.close();
    }

    // Función para convertir un número de base 10 a base raiz de 10
    private static String convertirABaseRaiz10(String numeroBase10) {
        // Convertimos el número base 10 a un número entero
        long numero = 0;
        for (int i = 0; i < numeroBase10.length(); i++) {
            numero = numero * 10 + (numeroBase10.charAt(i) - '0');
        }

        // La base es la raíz de 10, es decir, aproximadamente 3.162
        double base = Math.sqrt(10);

        // Crear la representación en la nueva base (sin usar StringBuilder o append)
        String resultado = "";

        // Mientras el número sea mayor que 0, vamos dividiendo
        while (numero > 0) {
            // Obtener el dígito en la nueva base
            long digito = (long) (numero % base);
            resultado = digito + resultado; // Concatenamos el dígito al inicio del resultado

            // Dividir el número por la base para obtener la siguiente potencia
            numero /= base;
        }

        // Si el resultado es vacío (caso en que el número es 0), debemos retornar 0
        if (resultado.equals("")) {
            resultado = "0";
        }

        return resultado;
    }
}

/*
 * Base raíz de 10
 * Tiempo máximo: 1,000 s Memoria máxima: 4096 KiB
 * Los sistemas de numeración posicionales son aquellos que asignan a cada
 * dígito un valor distinto en base a su posición. La llamada base 10, que es la
 * que utilizamos normalmente, utiliza 10 dígitos distintos que son
 * multiplicados por una potencia de 10 dependiendo del lugar que ocupan en el
 * número completo.
 * 
 * 4.321 = 4 × 103 + 3 × 102 + 2 × 101 + 1 × 100
 * 
 * Dependiendo del número elegido como base se necesitarán más o menos dígitos
 * para expresar el mismo número. Además la elección de ciertos números como
 * base da resultados curiosos. Uno de ellos es 10‾‾‾√2
 * utilizando los dígitos habituales (0…9).
 * 
 * Entrada
 * La entrada estará compuesta por distintos casos de prueba, cada uno de ellos
 * en una línea.
 * 
 * En cada línea aparecerá un número n (0 ≤ n ≤ 10100) que hay que convertir a
 * base 10‾‾‾√2
 * .
 * 
 * Salida
 * Para cada caso de prueba se mostrará en una línea independiente el número n
 * en su representación en base 10‾‾‾√2
 * .
 * 
 * Entrada de ejemplo
 * 9
 * 98
 * 987
 * Salida de ejemplo
 * 9
 * 908
 * 90807
 */