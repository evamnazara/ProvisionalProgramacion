package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class CuantosDiasFaltan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Solicitar el número de casos de prueba
        System.out.println("¡Bienvenido al programa que calcula los días restantes hasta Nochevieja!");
        System.out.print("Introduce el número de casos de prueba: ");
        int numCasos = sc.nextInt();

        // Array con los días acumulados al inicio de cada mes en un año no bisiesto
        int[] diasAcumulados = { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334 };

        // Procesamos cada caso
        for (int i = 0; i < numCasos; i++) {
            System.out.println("\nCaso de prueba " + (i + 1) + ":");

            // Pedir al usuario el día y mes
            System.out.print("Introduce el día: ");
            int dia = sc.nextInt(); // Día dado
            System.out.print("Introduce el mes: ");
            int mes = sc.nextInt(); // Mes dado

            // Convertir la fecha en el número de día en el año
            int diaDelAnio = diasAcumulados[mes - 1] + dia;

            // Calcular los días faltantes hasta el 31 de diciembre
            int diasRestantes = 365 - diaDelAnio;

            // Imprimir el resultado
            System.out.println("Faltan " + diasRestantes + " días hasta Nochevieja.");
        }

        // Mensaje final para el usuario
        System.out.println("\n¡Gracias por usar el programa! ¡Felices fiestas!");
        sc.close(); // Cerrar el scanner
    }
}

/*
 * ALTERNATIVA:
 * 
 * package arrays;
 * 
 * import java.util.Scanner;
 * 
 * public class CuantosDiasFaltan {
 * public static void main(String[] args) {
 * Scanner sc = new Scanner(System.in);
 * 
 * // Solicitar el número de casos de prueba
 * System.out.
 * println("¡Bienvenido al programa que calcula los días restantes hasta Nochevieja!"
 * );
 * System.out.print("Introduce el número de casos de prueba: ");
 * int numCasos = sc.nextInt();
 * 
 * // Array con los días de cada mes de un año no bisiesto
 * int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
 * 
 * // Procesamos cada caso
 * for (int i = 0; i < numCasos; i++) {
 * System.out.println("\nCaso de prueba " + (i + 1) + ":");
 * 
 * // Pedir al usuario el día y mes
 * System.out.print("Introduce el día: ");
 * int dia = sc.nextInt(); // Día dado
 * System.out.print("Introduce el mes: ");
 * int mes = sc.nextInt(); // Mes dado
 * 
 * // Calcular el número de día en el año
 * int diaDelAnio = 0;
 * 
 * // Sumar los días de los meses anteriores al mes dado
 * for (int j = 0; j < mes - 1; j++) {
 * diaDelAnio += diasPorMes[j];
 * }
 * 
 * // Agregar el día del mes
 * diaDelAnio += dia;
 * 
 * // Calcular los días faltantes hasta el 31 de diciembre
 * int diasRestantes = 365 - diaDelAnio;
 * 
 * // Imprimir el resultado
 * System.out.println("Faltan " + diasRestantes + " días hasta Nochevieja.");
 * }
 * 
 * // Mensaje final para el usuario
 * System.out.println("\n¡Gracias por usar el programa! ¡Felices fiestas!");
 * sc.close(); // Cerrar el scanner
 * }
 * }
 * 
 * 
 */

/*
 * ¿Cuantos días faltan?
 * Dado un día del año, ¿sabrías decir cuantos días faltan para Nochevieja?
 * Asumiremos que nos encontramos en un año no bisiesto.
 * 
 * Entrada
 * La entrada comenzará con un entero para especificar el número de casos de
 * prueba que vendrá a continuación. Para cada caso de prueba se mostrará una
 * línea en la que aparecerán dos enteros, el primero de ellos será
 * correspondiente al día y el segundo correspondiente al mes de una fecha
 * válida.
 * 
 * Salida
 * Para cada fecha de la entrada, se mostrarán el número de días completos que
 * faltan hasta el día de Nochevieja.
 * 
 * Entrada de ejemplo
 * 3
 * 28 12
 * 30 12
 * 1 1
 * Salida de ejemplo
 * 
 * 3
 * 1
 * 364
 */