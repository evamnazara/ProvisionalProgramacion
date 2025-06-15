package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class CarreraPopular {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el número de casos de prueba:");
        // Leer el número de casos de prueba directamente usando split y parseo
        String lineaCasos = scanner.nextLine().trim();
        int casos = 0;

        // Parseo del número de casos de prueba de forma manual (sin Integer.parseInt)
        String[] partesCasos = lineaCasos.split("");
        for (String parte : partesCasos) {
            if (parte.matches("[0-9]")) { // Si el carácter es un número
                casos = casos * 10 + Integer.parseInt(parte); // Convertimos manualmente cada dígito
            }
        }

        for (int i = 0; i < casos; i++) {
            System.out.println("Introduce los nombres de los participantes (finaliza con ====):");

            String[] participantes = new String[1000]; // Array con tamaño arbitrario grande
            int count = 0;

            // Leer los participantes hasta encontrar "===="
            while (true) {
                String linea = scanner.nextLine().trim();
                if (linea.equals("====")) {
                    break;
                }
                participantes[count++] = linea.toLowerCase(); // Guardamos en minúsculas
            }

            int hermanos = contarHermanos(participantes, count);
            System.out.println(count + " " + hermanos);
        }

        scanner.close();
    }

    // Cuenta los hermanos (participantes con el mismo apellido)
    private static int contarHermanos(String[] participantes, int total) {
        int hermanos = 0;

        for (int i = 0; i < total - 1; i++) {
            // Obtenemos el apellido de cada participante usando split
            String[] nombreActual = participantes[i].split(",");
            String[] nombreSiguiente = participantes[i + 1].split(",");

            String apellidoActual = nombreActual[0].trim(); // Extraemos el apellido
            String apellidoSiguiente = nombreSiguiente[0].trim(); // Extraemos el apellido

            // Si el apellido es el mismo, son hermanos
            if (apellidoActual.equals(apellidoSiguiente)) {
                hermanos++;
                // Saltamos a los participantes con el mismo apellido
                while (i < total - 1 && participantes[i].split(",")[0].trim().equals(apellidoSiguiente)) {
                    i++;
                }
            }
        }

        return hermanos;
    }
}

/*
 * Carrera popular
 * 
 * Adolfín Folk participa hoy en una carrera popular benéfica. En la zona de la
 * salida están los listados de los nombres de los participantes, con el número
 * de dorsal al lado. Tiene que buscarse, para saber en qué cola ponerse a
 * esperar para que le den su dorsal.
 * 
 * Mirando la lista (¡¡es una lista enorme!!) se ha dado cuenta de que es fácil
 * identificar a los participantes que son hermanos, dado que los nombres
 * aparecen ordenados por apellido.
 * 
 * Entrada
 * La entrada comenzará con una línea conteniendo únicamente un número con la
 * cantidad de casos de prueba. A continuación aparecerán dichos casos de
 * prueba.
 * 
 * Cada uno será una lista de participantes, con un participante por línea con
 * el formato "Apellido, Nombre" (sin las comillas), y ordenados por apellido.
 * El número de participantes es arbitrariamente grande, pero ninguna línea
 * tendrá más de 40 caracteres. Además, el uso de las mayúsculas en el texto es
 * errático, por lo que debe ignorarse.
 * 
 * Cada caso de prueba acaba con la cadena "====" (cuatro símbolos de igual
 * consecutivos, sin las comillas).
 * 
 * Salida
 * Para cada caso de prueba se debe indicar, en la misma línea, el número de
 * participantes en la carrera y cuántos de ellos tienen al menos otro hermano
 * inscrito. Ambos números se separarán por un espacio.
 * 
 * Entrada de ejemplo
 * 2
 * Folk, Adolfin
 * Zapatilla, Zape
 * ZAPATILLA, ZIPI
 * ====
 * Bunny, Bugs
 * Folk, Adolfin
 * Mouse, Mickey
 * ====
 * Salida de ejemplo
 * 3 2
 * 3 0
 */