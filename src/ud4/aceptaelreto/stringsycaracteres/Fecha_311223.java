package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class Fecha_311223 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leemos el número de casos de prueba
        System.out.print("Introduce el número de casos: ");
        int numCasos = Integer.parseInt(scanner.nextLine().trim());

        // Procesamos cada caso de prueba
        for (int i = 0; i < numCasos; i++) {
            // Leemos los tres números (día, mes, año)
            System.out.print("Introduce tres números de dos dígitos: ");
            String[] numeros = scanner.nextLine().trim().split(" ");

            // Verificamos si alguno de los formatos genera dos bloques iguales
            if (esDivertido(numeros)) {
                System.out.println("DIVERTIDOS");
            } else {
                System.out.println("INSULSOS");
            }
        }

        scanner.close();
    }

    // Función que verifica si podemos formar dos bloques de tres dígitos iguales
    private static boolean esDivertido(String[] numeros) {
        // Generamos todas las combinaciones posibles de los tres números
        String[] combinaciones = new String[6];
        combinaciones[0] = numeros[0] + numeros[1] + numeros[2]; // DDMMYY
        combinaciones[1] = numeros[0] + numeros[2] + numeros[1]; // DDYYMM
        combinaciones[2] = numeros[1] + numeros[0] + numeros[2]; // MMDDYY
        combinaciones[3] = numeros[1] + numeros[2] + numeros[0]; // MMYYDD
        combinaciones[4] = numeros[2] + numeros[0] + numeros[1]; // YDDMM
        combinaciones[5] = numeros[2] + numeros[1] + numeros[0]; // YYMMDD

        // Revisamos si alguna combinación tiene dos bloques de 3 dígitos iguales
        for (String combinacion : combinaciones) {
            if (combinacion.charAt(0) == combinacion.charAt(1) && combinacion.charAt(1) == combinacion.charAt(2) &&
                    combinacion.charAt(3) == combinacion.charAt(4) && combinacion.charAt(4) == combinacion.charAt(5)) {
                return true;
            }
        }

        return false;
    }
}

/*
 * 31-12-23
 * Tiempo máximo: 1,000 s Memoria máxima: 4096 KiB
 * Texto DD/MM/AA, MM/DD/AA y AA/MM/DD
 * Escribir la fecha del último día del año 2023 no genera ningún tipo de hecho
 * curioso: 31−12−23 no deja de ser una fecha más.
 * 
 * Pero si se escribe con el formato habitual en los países anglosajones, donde
 * escriben primero el mes, luego el día y finalmente el año, la situación
 * cambia: 12−31−23. Ahora ¡aparece el 123 dos veces seguidas! Es verdad que su
 * forma de escribir las fechas no tiene ningún sentido, porque está
 * desordenada… la "unidad" más pequeña, los días, va en medio, por delante
 * tiene los meses, que es la "unidad" intermedia, y detrás los años, la
 * "unidad" más grande. Pero ¡oye! En este caso este formato da un poco de
 * gracia a una fecha que de otro modo sería insulsa.
 * 
 * Entrada
 * La entrada comienza con un número que indica cuántos casos deberán
 * procesarse. Cada caso de prueba son tres números entre 0 y 99 escritos con
 * dos dígitos.
 * 
 * Salida
 * Por cada caso de prueba se escribirá DIVERTIDOS si hay una forma de ordenar
 * los tres números de modo que formen dos bloques de 3 dígitos iguales, e
 * INSULSOS en otro caso.
 * 
 * Entrada de ejemplo
 * 3
 * 31 12 23
 * 01 02 03
 * 90 09 99
 * Salida de ejemplo
 * DIVERTIDOS
 * INSULSOS
 * DIVERTIDOS
 */