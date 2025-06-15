package ud4.aceptaelreto.arrays;

import java.util.*;

public class SecretoBolsa {
    public static void main(String[] args) {
        // Usamos el scanner para leer la entrada de datos
        Scanner scanner = new java.util.Scanner(System.in);

        // Leemos el número de casos de prueba
        int casosDePrueba = scanner.nextInt();

        // Procesar cada caso de prueba
        for (int i = 0; i < casosDePrueba; i++) {
            // Leemos la suma clave
            int sumaClave = scanner.nextInt();

            // Leemos la secuencia de dígitos
            String secuencia = scanner.next();

            // Variable para contar las veces que la suma clave aparece
            int contador = 0;

            // Recorrer la secuencia y calcular la suma de los dígitos consecutivos
            for (int j = 0; j <= secuencia.length() - 1; j++) {
                int suma = 0; // Acumulador de la suma de los dígitos consecutivos
                // Recorrer los dígitos a partir de la posición j
                for (int k = j; k < secuencia.length(); k++) {
                    suma += secuencia.charAt(k) - '0'; // Convertir el carácter a número y sumar
                    if (suma == sumaClave) {
                        // Si la suma es igual a la suma clave, incrementamos el contador
                        contador++;
                    }
                    // Si la suma es mayor que la suma clave, no necesitamos continuar con los
                    // siguientes dígitos
                    if (suma > sumaClave) {
                        break;
                    }
                }
            }

            // Imprimimos el número de veces que aparece la suma clave en la secuencia
            System.out.println(contador);
        }

        // Cerrar el scanner después de usarlo
        scanner.close();
    }
}

/*
 * El secreto de la bolsa
 * Tiempo máximo: 1,000-2,000 s Memoria máxima: 4096 KiB
 * NASDAQ MarketSite TV Studio (CC BY 2.0)
 * Jonás es un paranoico. Cuando ve los ríos de números con la cotización de la
 * bolsa, cree que es el modo que tienen los gobiernos de enviar información
 * oculta a sus agentes secretos.
 * 
 * Dice que el primer número que se emite en el momento de la apertura es el que
 * hace las veces de suma clave. Una vez identificado, todos los demás números
 * del día se ponen seguidos, formando una gran secuencia. Lo importante de la
 * secuencia es cuántas veces se puede encontrar la suma clave en la suma de
 * dígitos consecutivos.
 * 
 * Dependiendo de cuántas veces esté escondida la suma, los agentes infiltrados
 * sabrán si tienen que mantenerse escondidos o entrar en acción de alguna
 * forma.
 * 
 * Para poder demostrar su teoría, Jonás necesita poder contar rápidamente
 * cuántas veces aparece la suma en las cotizaciones del día. Cuando lo hace a
 * mano, le lleva cosa de una semana averiguarlo, y para cuando lo sabe la
 * información está demasiado obsoleta como para ser útil.
 * 
 * Entrada
 * La entrada comienza con un primer número indicando cuántos casos de prueba
 * tendrán que procesarse.
 * 
 * Cada caso está compuesto por una única línea, que comienza con un número con
 * la suma clave. A continuación, tras un espacio, vendrá la secuencia de
 * dígitos. La cotización del día puede ser muy larga (para poder esconder mucha
 * información), por lo que la secuencia puede llegar a tener hasta 250.000
 * dígitos.
 * 
 * Como lo importante de este supuesto sistema de codificación son las sumas,
 * los ceros no aportan nada y son eliminados con antelación. Gracias a esto, la
 * suma clave no será nunca 0, ni aparecerá dicho dígito en la secuencia.
 * 
 * Salida
 * Por cada caso de prueba el programa escribirá el número escondido en la
 * cotización, es decir, cuántos bloques de dígitos consecutivos de la secuencia
 * suman exactamente la suma clave.
 * 
 * Entrada de ejemplo
 * 3
 * 20 1234
 * 10 91234
 * 3 1214212
 * Salida de ejemplo
 * 0
 * 2
 * 4
 * 
 */
