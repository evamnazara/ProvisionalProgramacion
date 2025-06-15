package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class Pipos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al programa de las uvas de Nochevieja.");

        while (true) {
            // Leer el año como String
            System.out.println("\nIntroduce el año (de 4 dígitos) o '0' para terminar:");
            String año = scanner.nextLine();

            // Si el año es "0", terminamos el programa
            if (año.equals("0")) {
                System.out.println("Fin de los casos de prueba.");
                break;
            }

            // Leer las cantidades de uvas con diferentes números de pipos
            System.out.println("Introduce el número de uvas con 0, 1, 2, ..., 9 pipos:");
            String[] uvasStr = scanner.nextLine().split(" ");

            // Almacenar las cantidades de uvas en un array
            String[] uvas = new String[10];
            for (int i = 0; i < 10; i++) {
                uvas[i] = uvasStr[i];
            }

            // Mostrar el número de uvas con sus pipos
            System.out.print("Número de uvas por cantidad de pipos: ");
            for (int i = 0; i < 10; i++) {
                System.out.print(uvas[i] + " ");
            }
            System.out.println();

            // Obtener los dígitos del año
            char[] digitosAño = año.toCharArray();

            // Determinar cuántos grupos de 4 se pueden formar
            String minPersonas = uvas[Character.getNumericValue(digitosAño[0])];

            System.out.println("Dígitos del año: " + año);

            // Buscar el mínimo de personas posibles
            for (int i = 1; i < 4; i++) {
                String cantidadUvas = uvas[Character.getNumericValue(digitosAño[i])];

                if (compararStringsNumericos(cantidadUvas, minPersonas) < 0) {
                    minPersonas = cantidadUvas;
                }
            }

            // Mostrar resultado
            System.out.println("Número máximo de personas a las que se les puede dar las uvas: " + minPersonas);
        }

        // Cerrar el scanner
        scanner.close();
    }

    // Función para comparar dos Strings numéricos sin convertirlos a enteros
    public static int compararStringsNumericos(String a, String b) {
        if (a.length() < b.length()) {
            return -1;
        } else if (a.length() > b.length()) {
            return 1;
        } else {
            return a.compareTo(b); // Comparación lexicográfica
        }
    }
}

/*
 * Pipos
 * Tiempo máximo: 1,000 s Memoria máxima: 4096 KiB
 * Pipos en una uva cortada en rodajas
 * Pese a haber nacido en martes y 13, Jose Mayus T. es un supersticioso. No le
 * parece suficiente comerse las 12 uvas religiosamente al son de las campanadas
 * de fin de año para evitar que una maldición caiga sobre su cabeza. También se
 * complica la vida pensando que las uvas que se coma deben tener, exactamente,
 * el número de pipos que digan los dígitos del nuevo año, y en el mismo orden.
 * 
 * Empezó a hacerlo cuando aún era joven, al pasar al año 2000. Se dio cuenta de
 * que la primera uva que se comió tenía dos semillitas, y las tres siguientes
 * no tuvieron ninguna, de modo que los pipos formaron, de casualidad, el número
 * 2000. Lo sorprendente es que le pasó lo mismo con las 4 uvas siguientes y con
 * las cuatro últimas.
 * 
 * Para Jose, el año 2000 fue muy bueno y, achacándolo a aquella coincidencia,
 * desde entonces todas las nocheviejas se organiza para conseguir que sus 12
 * uvas formen 3 grupos de 4, y en cada grupo el número de pipos de las uvas
 * formen los dígitos del nuevo año.
 * 
 * La edad le está volviendo cada vez más fetichista y este año, que organiza la
 * cena de nochevieja para la familia, quiere que todos los asistentes se coman
 * las uvas siguiendo su excéntrica manía. Tiene un montón de uvas y, con
 * paciencia infinita, ha averiguado, mirándolas una a una al trasluz, cuantos
 * pipos tiene cada una. Ahora necesita saber a cuánta gente, como máximo, podrá
 * darle las uvas correctas.
 * 
 * Entrada
 * El programa deberá leer, de la entrada estándar, un conjunto de casos de
 * prueba. Cada uno comienza con un número indicando el año que está a punto de
 * empezar (siempre de cuatro dígitos). A continuación van, en otra línea, diez
 * números menores que 109 indicando cuántas uvas no tienen ningún pipo, cuántas
 * tienen 1, y así sucesivamente hasta 9 pipos. Nunca ha encontrado ninguna que
 * tenga más.
 * 
 * La entrada termina con un 0, que no debe procesarse.
 * 
 * Salida
 * Por cada caso de prueba el programa deberá escribir el número de personas a
 * las que Jose podrá dar las uvas de modo que se puedan formar, con sus pipos,
 * tres veces los dígitos del nuevo año.
 * 
 * Entrada de ejemplo
 * 2023
 * 6 6 6 6 6 6 6 6 6 6
 * 2031
 * 30 30 30 30 30 30 30 30 30 30
 * 3791
 * 30 5 7 8 3 10 2 7 0 13
 * 0
 * Salida de ejemplo
 * 1
 * 10
 * 1
 * 
 */