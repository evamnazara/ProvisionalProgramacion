package ud4.aceptaelreto.arrays;

public class DigitosSaltarines {

    public static void main(String[] args) {
        // Scanner para leer la entrada
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Leer el número de casos de prueba
        System.out.print("Introduce la cantidad de casos de prueba: ");
        int n = scanner.nextInt();

        // Procesar cada caso de prueba
        for (int i = 0; i < n; i++) {
            // Leer el número como una cadena de caracteres
            System.out.print("Introduce el número para el caso de prueba " + (i + 1) + ": ");
            String numero = scanner.next();

            // Llamamos a la función para verificar si el número tiene dígitos saltarines
            if (esSaltarines(numero)) {
                System.out.println("SALTARINES");
            } else {
                System.out.println("NORMALES");
            }
        }

        // Cerrar el scanner
        scanner.close();
    }

    // Función para verificar si un número tiene dígitos saltarines
    public static boolean esSaltarines(String numero) {
        // Convertimos el número a un arreglo de dígitos
        int[] digitos = new int[numero.length()];

        // Llenar el arreglo de dígitos con los valores numéricos de la cadena
        for (int i = 0; i < numero.length(); i++) {
            digitos[i] = Character.getNumericValue(numero.charAt(i));
        }

        // Creamos un arreglo para marcar los dígitos que hemos visitado
        boolean[] visitado = new boolean[numero.length()];

        // Empezamos en el primer dígito
        int indice = 0;

        // Hacemos el recorrido
        for (int pasos = 0; pasos < numero.length(); pasos++) {
            // Si ya hemos visitado este índice, el número no es saltarín
            if (visitado[indice]) {
                return false;
            }

            // Marcamos este dígito como visitado
            visitado[indice] = true;

            // Saltamos tantas posiciones como indique el valor del dígito
            indice = (indice + digitos[indice]) % numero.length();
        }

        // Si hemos visitado todos los dígitos y volvemos al principio, es saltarín
        return indice == 0;
    }
}

/*
 * Dígitos saltarines
 * Tiempo máximo: 1,000-3,000 s Memoria máxima: 4096 KiB
 * Un número tiene sus dígitos saltarines si, empezando por el primero, se puede
 * ir saltando de uno al siguiente tantos puestos como indiquen, y al final se
 * llega de nuevo al principio habiendo pasado por todos ellos. Por ejemplo, el
 * número 2.312 tiene a sus dígitos saltarines. Empezando por el primero, el
 * primer 2, avanzamos dos dígitos y llegamos al 1. Desde él, avanzamos un
 * dígito más, y llegamos al segundo 2. Desde él, avanzamos otros dos dígitos
 * (dando la vuelta y empezando de nuevo por la izquierda), y llegamos al 3. Y
 * desde éste, avanzamos tres veces, y llegamos otra vez al principio.
 * 
 * Ejemplo de análisis de un número con los dígitos saltarines
 * Los números con dígitos saltarines son una rareza de la naturaleza y son
 * difíciles de encontrar.
 * 
 * Entrada
 * El programa deberá leer un primer número n indicando cuántos casos de prueba
 * deberá procesar. A continuación vendrán n líneas, cada una con un número 0 <
 * i < 109.
 * 
 * Ningún número tendrá ceros superfluos a la izquierda.
 * 
 * Salida
 * Para cada caso de prueba, el programa escribirá "SALTARINES" si el número
 * tiene a sus dígitos saltarines, y "NORMALES" en otro caso.
 * 
 * Entrada de ejemplo
 * 4
 * 2312
 * 3
 * 12
 * 30
 * Salida de ejemplo
 * 
 * SALTARINES
 * SALTARINES
 * NORMALES
 * NORMALES
 * 
 */