package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class SonLosCuartos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leemos el número de casos de prueba
        System.out.println("Introduce el número de casos de prueba:");
        int numCasos = Integer.parseInt(sc.nextLine().trim());

        // Procesamos cada caso de prueba
        for (int i = 0; i < numCasos; i++) {
            // Leemos los sonidos para cada caso de prueba
            System.out.println("Introduce los sonidos de las campanadas:");
            String sonidos = sc.nextLine().trim();

            // Creamos un arreglo de sonidos, separado por espacios
            String[] sonidosArray = sonidos.split(" ");

            // Comprobamos el caso de los cuartos antes de las campanadas
            if (sonidosArray[0].equals("ding-dong")) {
                System.out.println("SALIDA NULA");
            }
            // Comprobamos si el primer sonido es "doong", es decir, que se ha empezado
            // tarde
            else if (sonidosArray[0].equals("doong")) {
                // Comprobamos si faltan campanadas, es decir, no hay 12 sonidos "doong"
                if (sonidosArray.length < 12) {
                    System.out.println("TARDE");
                } else if (sonidosArray.length == 12) {
                    System.out.println("CORRECTO");
                } else {
                    System.out.println("MARISA NARANJO");
                }
            } else {
                System.out.println("Entrada no válida");
            }
        }

        sc.close();
    }
}

/*
 * ¡Son los cuartos!
 * Tiempo máximo: 1,000 s Memoria máxima: 4096 KiB
 * Cartel de 'Feliz 1990' sobre el reloj de la Puerta del Sol
 * "¡Todavía no, que son los cuartos!" La tradición española de comerse 12 uvas
 * en el cambio de año al son de las campanadas no es trivial. No es por el
 * riesgo de tener un susto por una uva que se va por un mal sitio, que también,
 * sino porque el reloj de la Puerta del Sol quiere sus segundos de protagonismo
 * y al repiqueteo del carrillón le siguen los famosos "cuartos", campanadas de
 * mentira que solo sirven para causar salidas nulas.
 * 
 * Y si no que se lo pregunten a Marisa Naranjo que presentó las campanadas en
 * el lejano 1989. Bueno, las presentó a toro pasado; fueron campanadas
 * infinitas, sin principio ni fin. Mientras el público bajo el balcón gritaba y
 * se felicitaba el nuevo año, ella decía a todos los televidentes
 * "Aquí comienzan las 12 campanadas; ha terminado 1989". Confundió las
 * campanadas con los cuartos y, mientras el reloj daba las 12, ella pedía que
 * no se empezara. Irma Soriano pasó a la historia de la televisión 5 años
 * después cometiendo el mismo error.
 * 
 * Con estos precedentes no es de extrañar que todos los años, en todas las
 * cadenas nos cuenten lo mismo.
 * "Los cuartos suenan ding−dong, ding−dong… y las campanadas suenan doong, doong…"
 * 
 * Entrada
 * La entrada comienza con el número de casos de prueba que deberán procesarse.
 * 
 * Cada caso de prueba es el sonido hecho por las "campanadas" del reloj a
 * partir del momento en el que una persona empieza a comerse las uvas. A veces
 * empieza antes de tiempo, y suena algún cuarto, o empieza tarde, y faltan
 * campanadas.
 * 
 * Salida
 * Para cada caso de prueba, el programa escribirá SALIDA NULA si ha empezado a
 * comer uvas antes de tiempo (durante los cuartos), CORRECTO si ha empezado en
 * la primera campanada, y TARDE si se ha saltado alguna campanada. Si empieza a
 * comer cuando las campanadas han terminado se escribirá MARISA NARANJO.
 * 
 * Entrada de ejemplo
 * 3
 * ding-dong doong doong doong doong doong doong doong doong doong doong doong
 * doong
 * 
 * doong doong doong doong doong doong doong doong doong doong doong doong
 * Salida de ejemplo
 * SALIDA NULA
 * MARISA NARANJO
 * CORRECTO
 */