package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class CuriosaPropiedad9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leemos los casos de prueba hasta que se ingrese un 0
        while (true) {
            System.out.print("Introduce un número: ");
            String numeroStr = scanner.nextLine().trim();

            // Si el número es 0, terminamos el programa
            if (numeroStr.equals("0")) {
                break;
            }

            // Convertimos la cadena a un array de caracteres para poder manipular los
            // dígitos
            char[] digitos = numeroStr.toCharArray();

            // Ordenamos los dígitos en orden descendente para formar el número mayor
            for (int i = 0; i < digitos.length - 1; i++) {
                for (int j = i + 1; j < digitos.length; j++) {
                    if (digitos[i] < digitos[j]) {
                        // Intercambiamos los caracteres
                        char temp = digitos[i];
                        digitos[i] = digitos[j];
                        digitos[j] = temp;
                    }
                }
            }

            // Convertimos el array de caracteres ordenado en una cadena
            String mayorStr = new String(digitos);
            int mayor = Integer.parseInt(mayorStr); // El número mayor es el resultado

            // Ordenamos los dígitos en orden ascendente para formar el número menor
            for (int i = 0; i < digitos.length - 1; i++) {
                for (int j = i + 1; j < digitos.length; j++) {
                    if (digitos[i] > digitos[j]) {
                        // Intercambiamos los caracteres
                        char temp = digitos[i];
                        digitos[i] = digitos[j];
                        digitos[j] = temp;
                    }
                }
            }

            // Convertimos el array de caracteres ordenado en una cadena
            String menorStr = new String(digitos);
            int menor = Integer.parseInt(menorStr); // El número menor es el resultado

            // Calculamos la resta
            int resta = mayor - menor;

            // Calculamos el cociente de la división entre 9
            int cociente = resta / 9;

            // Mostramos el resultado de acuerdo al formato solicitado
            System.out.println(mayor + " - " + menor + " = " + resta + " = " + cociente + " x 9");
        }

        scanner.close();
    }
}

/*
 * Curiosa propiedad la del 9
 * Tiempo máximo: 1,000 s Memoria máxima: 4096 KiB
 * Un número 9 con brazos y piernas
 * Hoy nos ha contado el profe de Mates una cosa que me ha parecido muy curiosa.
 * Nos ha dicho:
 * "Pensad cada uno un número, de cualquier número de cifras. A continuación, formad el mayor y el menor número posible con esas mismas cifras. Si ahora calculáis la diferencia entre el mayor y el menor, resulta que siempre sale un número que es divisible por 9."
 * 
 * Yo he pensado el 34187, así que el mayor y el menor número que pueden
 * formarse con esas cifras son el 87431 y el 13478 respectivamente. Los he
 * restado y sale 73953, que efectivamente es divisible por 9: 73953 = 8217 × 9.
 * 
 * Aunque ha funcionado como decía, la verdad es que me extraña un poco que
 * salga siempre, así que me gustaría tener un programa para comprobarlo.
 * 
 * Entrada
 * La entrada está compuesta por diferentes casos de prueba. Cada caso es una
 * línea con un número N, positivo y no mayor que 109, que representa el número
 * que hemos pensado.
 * 
 * La entrada termina cuando N es 0. Este último caso no debe ser procesado.
 * 
 * Salida
 * Para cada caso de prueba se escribirán las operaciones realizadas para la
 * comprobación. Más concretamente, deben aparecer el número mayor y el número
 * menor restados, el resultado de su resta y el cociente de dividirlo entre 9
 * multiplicado por 9. Delante y detrás de cada operador hay un espacio. Los
 * ceros a la izquierda no aparecen.
 * 
 * Entrada de ejemplo
 * 34187
 * 1709876
 * 100
 * 11
 * 0
 * Salida de ejemplo
 * 87431 - 13478 = 73953 = 8217 x 9
 * 9877610 - 167789 = 9709821 = 1078869 x 9
 * 100 - 1 = 99 = 11 x 9
 * 11 - 11 = 0 = 0 x 9
 */
