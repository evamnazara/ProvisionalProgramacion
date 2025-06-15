package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class MultiplicandoMal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al método de multiplicación de Celia.");
        System.out.println("Introduce el número de casos de prueba:");

        // Leer el número de casos de prueba
        int casos = scanner.nextInt();
        scanner.nextLine(); // Limpiar el salto de línea

        // Procesar cada caso de prueba
        for (int i = 0; i < casos; i++) {
            System.out.println("\nIntroduce dos números separados por espacio:");
            String linea = scanner.nextLine();
            String[] numeros = linea.split(" "); // Dividir los dos números

            String numero1 = numeros[0];
            String numero2 = numeros[1];

            // Llamar a la función de multiplicación de Celia
            String resultado = multiplicacionCelia(numero1, numero2);

            // Imprimir el resultado con los ceros a la izquierda si es necesario
            System.out.println("Resultado: " + resultado);
        }

        // Cerrar el scanner
        scanner.close();
        System.out.println("Fin del programa.");
    }

    // Función que realiza la multiplicación al estilo de Celia
    public static String multiplicacionCelia(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();

        // Determinar la longitud máxima para alinear los números
        int maxLen = Math.max(len1, len2);

        // Asegurar que ambos números tengan la misma longitud rellenando con ceros a la
        // izquierda
        num1 = rellenarConCeros(num1, maxLen);
        num2 = rellenarConCeros(num2, maxLen);

        // Array para almacenar el resultado
        char[] resultado = new char[maxLen];

        // Multiplicación "suma de columnas" (método de Celia)
        for (int i = 0; i < maxLen; i++) {
            // Multiplicar los dígitos en la misma posición
            int digito1 = num1.charAt(i) - '0'; // Convertir char a int
            int digito2 = num2.charAt(i) - '0'; // Convertir char a int

            // Aplicar la multiplicación de Celia
            int producto = (digito1 * digito2) % 10; // Solo el último dígito cuenta

            // Almacenar en el resultado
            resultado[i] = (char) (producto + '0'); // Convertir int a char
        }

        // Convertir el resultado en String y retornarlo
        return new String(resultado);
    }

    // Función para rellenar con ceros a la izquierda
    public static String rellenarConCeros(String numero, int longitud) {
        int diferencia = longitud - numero.length();
        String ceros = "";
        for (int i = 0; i < diferencia; i++) {
            ceros += "0"; // Concatenar ceros
        }
        return ceros + numero; // Devolver el número con ceros añadidos
    }
}

/*
 * Después de haber aprendido a sumar y restar (¡incluso llevando!) hace un par
 * de años, Celia no sale de su asombro con la multiplicación. Su profesor
 * insiste en que tiene que multiplicar el primer número por cada uno de los
 * dígitos del segundo, por separado, y luego sumar todos los resultados:
 * 
 * 123
 * × 123
 * 369
 * + 246
 * 123
 * 15129
 * "¡Pero eso es una lata!" — grita amargamente —
 * "¡Hay que dar un montón de pasos, con lo cómodo que era sumar y restar!"
 * Demostrando la rebeldía que tanto temen sus padres cuando piensan en la
 * futura adolescencia, ha decidido que prefiere el método "tradicional" de
 * hacer las cuentas, y multiplica como si estuviera sumando, utilizando de
 * manera independiente los números de las columnas.
 * 
 * 123
 * × 123
 * 149
 * Por más que la dicen que así no se hace y que los resultados están mal,
 * prefiere ignorar las críticas y asegura que su método es mucho más rápido y
 * práctico. No obstante, secretamente, reconoce que a veces le dan resultados
 * un poco raros con los ceros de la izquierda, cuando los números tienen
 * diferente longitud.
 * 
 * Entrada
 * La entrada comenzará con un número con la cantidad de casos de prueba que
 * deberán procesarse. Cada uno está compuesto por una pareja de números,
 * separados por un espacio, que deben multiplicarse. Como Celia no quiere hacer
 * caso, su profesor la castiga poniéndole números muy largos (de hasta 100
 * cifras) para que, al menos, practique las tablas de multiplicar.
 * 
 * Salida
 * Para cada caso de prueba el programa escribirá el resultado de la
 * multiplicación al estilo de Celia, incluyendo los posibles ceros a la
 * izquierda.
 * 
 * Entrada de ejemplo
 * 3
 * 423 424
 * 12 123
 * 123 82
 * Salida de ejemplo
 * 1652
 * 026
 * 166
 * 
 */