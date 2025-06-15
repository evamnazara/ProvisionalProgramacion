package ud4.aceptaelreto.matrices;

import java.util.Scanner;

public class PresupuestandoSemaforos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // PASO 1: Leer el ancho y el alto del pueblo
            System.out.print("Ingresa el ancho y alto del pueblo (0 0 para terminar): ");
            int anchoPueblo = scanner.nextInt();
            int altoPueblo = scanner.nextInt();

            // Si ambos son 0, terminamos el programa
            if (anchoPueblo == 0 && altoPueblo == 0) {
                System.out.println("Fin del programa.");
                break;
            }

            // PASO 2: Crear la cuadrícula para el plano del pueblo
            char[][] planoPueblo = new char[altoPueblo][anchoPueblo];
            scanner.nextLine(); // Limpiar el salto de línea

            System.out.println(
                    "Ingresa el plano del pueblo, donde '#' es una calle y otros caracteres son áreas libres:");
            for (int i = 0; i < altoPueblo; i++) {
                planoPueblo[i] = scanner.nextLine().toCharArray();
            }

            // PASO 3: Contar los semáforos necesarios (intersecciones)
            int numeroSemaforos = 0;

            // PASO 4: Recorrer toda la cuadrícula y verificar intersecciones
            for (int i = 0; i < altoPueblo; i++) {
                for (int j = 0; j < anchoPueblo; j++) {
                    // Verificar si hay una calle en la posición (i, j)
                    if (planoPueblo[i][j] == '#') {
                        // Verificar si hay una calle horizontal en la misma fila
                        boolean hayCalleHorizontal = false;
                        for (int k = 0; k < anchoPueblo; k++) {
                            if (k != j && planoPueblo[i][k] == '#') {
                                hayCalleHorizontal = true;
                                break;
                            }
                        }

                        // Verificar si hay una calle vertical en la misma columna
                        boolean hayCalleVertical = false;
                        for (int k = 0; k < altoPueblo; k++) {
                            if (k != i && planoPueblo[k][j] == '#') {
                                hayCalleVertical = true;
                                break;
                            }
                        }

                        // Si ambas calles están presentes (horizontal y vertical), es una intersección
                        if (hayCalleHorizontal && hayCalleVertical) {
                            numeroSemaforos++;
                        }
                    }
                }
            }

            // PASO 5: Imprimir el número de semáforos necesarios
            System.out.println("Número de semáforos necesarios: " + numeroSemaforos);
        }

        // Cerrar el scanner
        scanner.close();
    }
}

/*
 * ==========
 * PRESUPUESTANDO SEMAFOROS
 * 
 * Presupuestando semáforos
 * Tiempo máximo: 1,000-2,000 s Memoria máxima: 8192 KiB
 * El tráfico en el pueblo se ha vuelto inmanejable. Hace unos años era raro ver
 * dos tractores coincidir en una esquina. Ahora la salida del sol hace
 * despertar a infinidad de coches, tractores, furgonetas, motos y otros medios
 * de locomoción que llenan las calles de ruido y confusión. Si a eso le sumamos
 * los peatones que zigzaguean por la falta de aceras y le añadimos aquellos que
 * siguen moviéndose en burro, la situación es insostenible.
 * 
 * Como alcalde, Jacinto ha decidido coger el toro por los cuernos y, pese a las
 * protestas de muchos vecinos, llenar el pueblo de semáforos. Pondrá, dice, un
 * semáforo en cada calle que llegue a una intersección, trayendo la modernidad
 * a este pueblo que hace bien poco no tenía ni las calles asfaltadas.
 * 
 * Eso sí, como el número de intersecciones en el pueblo es grande no podrá
 * hacerlo de manera inmediata. El primer paso es incorporar la previsión del
 * gasto en los presupuestos del año que viene. Y para eso necesita saber
 * cuántos semáforos habrá que instalar, por lo que es hora de ponerse a contar.
 * 
 * Entrada
 * 
 * La entrada contiene distintos casos de prueba, cada uno con un plano en forma
 * de cuadrícula.
 * 
 * La descripción de cada plano comienza con una línea con dos números con el
 * ancho (1 ≤ a ≤ 1.000) y alto (1 ≤ l ≤ 1.000) del pueblo.
 * 
 * A continuación vienen l líneas cada una con a caracteres (distintos de
 * espacios). Cada carácter tiene un significado (los hay para simbolizar
 * parques, casas, consultorio médico...), pero el que nos interesa es el # que
 * representa una calle (cuyo ancho es siempre 1). Las calles van en horizontal
 * o vertical.
 * 
 * Salida
 * 
 * Por cada caso de prueba se escribirá una línea con un único número
 * conteniendo el número de semáforos totales que hay que presupuestar.
 * 
 * Entrada de ejemplo
 * 
 * 5 4
 * --#..
 * --#..
 * ####'
 * :::##
 * 7 3
 * ..#....
 * #######
 * ..#...#
 * 7 4
 * ..#....
 * #######
 * ...#.#.
 * ...#.#.
 * 13 3
 * ..#####...###
 * ..#...#...#..
 * ###...#####..
 * 
 * 
 * ==
 * 
 * Para resolver este problema, necesitamos contar el número de intersecciones
 * en un plano de calles, donde las calles están representadas por el carácter
 * #. Cada vez que una calle (representada por #) se cruza con otra en una
 * intersección (es decir, si hay una calle que se cruza vertical y
 * horizontalmente en el mismo lugar), necesitamos contar un semáforo.
 * 
 * Estrategia para resolver el problema:
 * 1. Leer los datos de entrada:
 * • El primer paso es leer las dimensiones del pueblo (ancho y alto de la
 * cuadrícula).
 * • Luego, leer la cuadrícula que representa el plano del pueblo, donde los
 * caracteres # indican las calles.
 * 2. Contar las intersecciones:
 * • Una intersección se produce cuando un # se encuentra con otro # tanto en la
 * misma fila (horizontal) como en la misma columna (vertical).
 * • Para contar estas intersecciones, simplemente debemos recorrer toda la
 * cuadrícula y comprobar si hay un # en una posición y si también hay otro # en
 * la misma fila y columna.
 * 3. Consideraciones:
 * • Asegúrate de contar solo los # que realmente forman una intersección (es
 * decir, no contar un semáforo si solo hay una calle en una fila o columna).
 * • La entrada termina cuando se recibe un caso de prueba con dimensiones 0 0,
 * lo cual no debe procesarse.
 * 
 * Implementación paso a paso:
 * 1. Leer el tamaño de la cuadrícula.
 * 2. Crear una cuadrícula de calles y calles vacías.
 * 3. Contar las intersecciones.
 * 4. Imprimir el número total de semáforos necesarios (intersecciones).
 * 
 * Implementación en Java:
 * 
 * 
 * 
 * Explicación paso a paso:
 * 1. Leer los datos de entrada:
 * • Usamos el Scanner para leer el ancho y alto de la cuadrícula, seguido por
 * la cuadrícula misma. La cuadrícula es representada como un arreglo
 * bidimensional de caracteres char.
 * 2. Comprobar intersecciones:
 * • Para cada casilla en la cuadrícula que contiene un #, comprobamos si hay
 * alguna otra calle en la misma fila (horizontal) o en la misma columna
 * (vertical). Si ambas condiciones son verdaderas, entonces hay una
 * intersección y necesitamos contar un semáforo.
 * 3. Contar las intersecciones:
 * • Si encontramos que una casilla contiene un # y tiene al menos otro # en su
 * misma fila y columna, incrementamos el contador de semáforos.
 * 4. Salida:
 * • Para cada caso de prueba, imprimimos el número de semáforos necesarios.
 * 
 * Ejemplo de entrada:
 * 
 * 5 4
 * --#..
 * --#..
 * ####'
 * :::##
 * 7 3
 * ..#....
 * #######
 * ..#...#
 * 7 4
 * ..#....
 * #######
 * ...#.#.
 * ...#.#.
 * 13 3
 * ..#####...###
 * ..#...#...#..
 * ###...#####..
 * 0 0
 * 
 * Ejemplo de salida:
 * 
 * 1
 * 3
 * 2
 * 4
 * 
 * Explicación de la salida:
 * • En el primer caso, solo hay una intersección donde se encuentran dos calles
 * (una horizontal y una vertical).
 * • En el segundo caso, hay tres intersecciones.
 * • En el tercer caso, hay dos intersecciones.
 * • En el cuarto caso, hay cuatro intersecciones.
 * 
 * Resumen:
 * 
 * Este enfoque resuelve el problema de contar las intersecciones en un plano de
 * calles en forma de cuadrícula. Lo hace de manera eficiente, recorriendo cada
 * casilla y comprobando si es parte de una intersección. El código también se
 * asegura de manejar correctamente los límites y terminar cuando encuentra un
 * caso de entrada 0 0.
 * 
 * ==========
 * 
 * 
 * 
 * 
 * 
 */