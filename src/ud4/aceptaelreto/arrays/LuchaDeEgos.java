package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class LuchaDeEgos {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Continuar procesando casos de prueba hasta que se ingrese un 0
        System.out.println("Bienvenido al sistema de emparejamiento de superhéroes. Procesando casos de prueba...");

        while (true) {
            // Leer el número de superhéroes
            System.out.print("\nIntroduce el número de superhéroes: ");
            int n = entrada.nextInt();

            // Si n es 0, terminar el programa
            if (n == 0) {
                System.out.println("Fin del programa. ¡Gracias por usar el sistema de emparejamiento!");
                break;
            }

            // Leer las destrezas de los superhéroes
            System.out.println("Introduce las destrezas de los superhéroes (valores entre 1 y 5):");
            int[] destrezas = new int[n];
            for (int i = 0; i < n; i++) {
                destrezas[i] = entrada.nextInt();
            }

            // Leer las preferencias de los superhéroes
            entrada.nextLine(); // Limpiar el buffer
            System.out.println("Introduce las preferencias de los superhéroes (en formato <N, =N, >N):");
            String[] preferencias = new String[n];
            for (int i = 0; i < n; i++) {
                preferencias[i] = entrada.nextLine();
            }

            // Array para marcar si un superhéroe ya ha sido emparejado
            boolean[] emparejado = new boolean[n];
            boolean algunaPelea = false;

            System.out.println("\nIniciando el proceso de emparejamiento de superhéroes...");

            // Procesar las peleas
            for (int i = 0; i < n; i++) {
                // Si el superhéroe ya está emparejado, continuar
                if (emparejado[i])
                    continue;

                boolean peleaEncontrada = false;

                // Buscar un oponente
                for (int j = i + 1; j < n; j++) {
                    // Si el oponente ya está emparejado, continuar
                    if (emparejado[j])
                        continue;

                    // Verificar si las preferencias de ambos superhéroes se cumplen
                    if (puedenPelea(destrezas[i], preferencias[i], destrezas[j]) &&
                            puedenPelea(destrezas[j], preferencias[j], destrezas[i])) {

                        // Registrar la pelea
                        emparejado[i] = true;
                        emparejado[j] = true;
                        System.out.println("¡Pelea emparejada! Superhéroe " + (i + 1) + " luchará contra el superhéroe "
                                + (j + 1));
                        algunaPelea = true;
                        peleaEncontrada = true;
                        break; // Salir del ciclo interno
                    }
                }

                // Si no se encontró pelea, el superhéroe sigue buscando
                if (!peleaEncontrada) {
                    continue;
                }
            }

            // Si no hubo peleas, imprimir "NO HAY"
            if (!algunaPelea) {
                System.out.println("NO HAY emparejamientos posibles.");
            }

            // Imprimir el separador "---"
            System.out.println("---");
        }

        // Cerrar el scanner
        entrada.close();
    }

    // Función que determina si dos superhéroes pueden pelear basándose en su
    // destreza y preferencia
    public static boolean puedenPelea(int destreza1, String preferencia, int destreza2) {
        if (preferencia.charAt(0) == '=') {
            // Quiere oponentes con la misma destreza
            return destreza1 == destreza2;
        } else if (preferencia.charAt(0) == '>') {
            // Quiere oponentes con destreza mayor
            int nivel = preferencia.charAt(1) - '0'; // Convertir el número a int
            return destreza2 > nivel;
        } else if (preferencia.charAt(0) == '<') {
            // Quiere oponentes con destreza menor
            int nivel = preferencia.charAt(1) - '0'; // Convertir el número a int
            return destreza2 < nivel;
        }
        return false;
    }
}

/*
 * 
 * Lucha de egos
 * Reunión de multitud de superhéroes creados por Stan Lee
 * Se veía venir. La fila de superhéroes entrando en el despacho de Stan Lee a
 * quejarse se divisaba desde Asgard. Y es que todos querían ser más poderosos
 * que sus compañeros de trabajo. Que si Luke Cage decía que era más fuerte que
 * Hulk, que si Iron Man quería ser más seductor que Daredevil, que si Jessica
 * Jones quería ser más impertinente que la Viuda negra…
 * 
 * Stan Lee propuso que esta lucha de egos se zanjara mediante batallas justas,
 * pactadas y equilibradas. Equilibrarlas supuso un quebradero de cabeza para
 * todos.
 * 
 * Al final, el sindicato THANOS (Trabajadores Heroicos Aunque Necesitados de
 * Organización Sindical) tuvo que intervenir, y acordó con Stan Lee crear un
 * sistema que emparejara a los superhéroes en función de sus preferencias.
 * 
 * El propio Stan Lee asignó a cada superhéroe un nivel de destreza entre 1 y 5.
 * Por su parte, los superhéroes indicaron sus preferencias de la destreza que
 * debía tener su oponente:
 * 
 * Si querían enfrentarse con superhéroes con un nivel concreto, indicaban "=N",
 * con N entre 1 y 5.
 * Si, por el contrario, estaban dispuestos a enfrentarse con superhéroes que
 * tuvieran un nivel mayor, decían ">N", con N entre 0 y 4.
 * Los más cobardes podían indicar "<N" para pedir superhéroes de nivel inferior
 * a N, entre 2 y 6.
 * La lucha se ha convertido en tradición y se hace todos los años. Tienes la
 * valoración de cada superhéroe y sus preferencias y debes emparejarlos. Cada
 * superhéroe luchará con el primero que vaya después en la lista y que cumpla
 * las restricciones de ambos, siempre que no haya sido emparejado previamente.
 * Con este mecanismo de emparejamiento, es posible que algunos superhéroes se
 * queden sin emparejar.
 * 
 * Entrada
 * El programa deberá procesar múltiples casos de prueba leídos de la entrada
 * estándar.
 * 
 * Cada uno comienza con el número N de superhéroes que competirán en el torneo
 * de egos (como mucho 100).
 * 
 * A continuación aparece una línea de N números entre 1 y 5 con la destreza de
 * cada uno. Después, seguirá una segunda línea con sus preferencias en el mismo
 * orden, y de la forma <N, =N y >N.
 * 
 * La entrada termina con un caso sin superhéroes, que no debe procesarse.
 * 
 * Salida
 * El programa escribirá, por cada caso de prueba, los emparejamientos
 * realizados en líneas independientes. Cada superhéroe se identifica por su
 * posición en la lista de la entrada (valores entre 1 y N).
 * 
 * La asignación de emparejamientos se realiza buscando desde el primero hasta
 * el último el primer superhéroe que vaya después en la lista que permita que
 * ambos estén conformes con el enfrentamiento. Cada superhéroe lucha solo una
 * vez, por lo que si un superhéroe es asignado en un duelo, no se le busca
 * otro.
 * 
 * Si el proceso termina sin ningún emparejamiento se escribirá NO HAY.
 * 
 * Después de cada caso de prueba se escribirá "---".
 * 
 * Entrada de ejemplo
 * 3
 * 3 1 4
 * <3 >3 =4
 * 6
 * 3 1 4 4 5 3
 * =3 >0 <5 =4 <3 >2
 * 0
 * Salida de ejemplo
 * 
 * NO HAY
 * ---
 * 1 6
 * 2 3
 * ---
 */