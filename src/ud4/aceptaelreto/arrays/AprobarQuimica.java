package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class AprobarQuimica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Subniveles del diagrama de Moëller
        String[] subniveles = {
                "1s", "2s", "2p", "3s", "3p", "4s", "3d", "4p", "5s", "4d", "5p", "6s", "4f", "5d", "6p", "7s", "5f",
                "6d", "7p"
        };
        // Capacidades máximas de electrones por subnivel
        int[] capacidades = { 2, 2, 6, 2, 6, 2, 10, 6, 2, 10, 6, 2, 14, 10, 6, 2, 14, 10, 6 };

        System.out.println("PROGRAMA DE CONFIGURACION ELECTRÓNICA DE ELEMENTOS.");
        System.out.println("Escribe Exit para salir del programa.\n");

        System.out.println("Introduce el nombre del elemento: ");
        String nombreElemento = sc.nextLine();
        System.out.println("Introduce su número atómico: ");
        int numeroAtomico = sc.nextInt();

        if (!nombreElemento.equals("Exit")) {
            if (numeroAtomico == 0) {
                System.out.println("1s0");
            } else {
                // cadena vacia para almacenar la configuración electrónica
                String configuracion = "";

                // Recorrer los subniveles y asignar los electrones
                int electronesRestantes = numeroAtomico;

                for (int i = 0; i < subniveles.length; i++) {
                    // Calcular cuántos electrones se colocan en este subnivel
                    int electronesEnEsteSubnivel = Math.min(electronesRestantes, capacidades[i]);
                    // Concatenar el subnivel y la cantidad de electrones a la configuración
                    configuracion += subniveles[i] + electronesEnEsteSubnivel + " ";

                    // Reducir los electrones restantes
                    electronesRestantes -= electronesEnEsteSubnivel;

                    // Si ya no quedan electrones, terminamos
                    if (electronesRestantes == 0) {
                        break;
                    }
                }

                System.out.println(configuracion.trim());
            }
            sc.close();
        }
    }
}

/*
 * Aprobar química
 * Tiempo máximo: 1,000 s Memoria máxima: 4096 KiB
 * A Jonathan le han mandado en el instituto que realice un problema de
 * configuración electrónica. La verdad es que con química está bastante
 * perdido, y ha decidido que no va a ser ésta la asignatura que le deje fuera
 * de la universidad. Teniendo en cuenta que en el examen no es crucial para la
 * nota la realización de un ejercicio de este tipo, pero que no se les permite
 * aprobar si no entregan bien realizados todas las actividades propuestas en
 * clase, ha decidido pedirle ayuda a su hermano que está estudiando un Ciclo
 * Formativo de Grado Superior de Informática.
 * 
 * Lo primero que hace Jonathan es explicarle a su hermano el ejercicio, que
 * consiste en indicar de qué forma se distribuyen los electrones de los átomos
 * o elementos químicos. Para eso, le cuenta, se utiliza el diagrama de Moëller
 * que determina en qué orden se van completando los subniveles de cada orbital.
 * La idea intuitiva es que para saber cómo se distribuyen los N electrones de
 * un átomo concreto debemos pensar dónde se coloca el primer electrón, después
 * dónde se coloca el segundo, etc., hasta llegar al último. La tabla 1.a
 * muestra todos los "huecos" posibles donde se pueden colocar. Sus nombres son
 * una combinación del número nivel (1…7) y del orbital (s, p, d o f).
 * 
 * s p d f
 * n=1 1s
 * n=2 2s 2p
 * n=3 3s 3p 3d
 * n=4 4s 4p 4d 4f
 * n=5 5s 5p 5d 5f
 * n=6 6s 6p 6d
 * n=7 7s 7p
 * (a) Nombres de los subniveles
 * Orden de completado
 * (b) Orden en el que se completan
 * Figura 1: Diagrama de Moëller
 * La figura 1.b muestra en qué orden se van completando los subniveles. Como se
 * ve, consiste en recorrer los subniveles de forma diagonal de arriba a abajo y
 * de derecha a izquierda:
 * 
 * 1s 2s 2p 3s 3p 4s 3d 4p 5s 4d 5p 6s 4f 5d 6p 7s 5f 6d 7p
 * Lo último que hay que tener en cuenta es el número de electrones que entran
 * en cada subnivel: el subnivel s puede llenarse con 1 ó 2 electrones. El
 * subnivel p puede contener de 1 a 6 electrones, el d de 1 a 10 electrones y el
 * subnivel f de 1 a 14 electrones:
 * 
 * Orbital s p d f
 * Electrones 2 6 10 14
 * Para que todo le quede más claro, Jonathan le enseña a su hermano un
 * ejercicio que han realizado en clase: la configuración electrónica del
 * Rubidio que tiene 37 electrones (en la terminología química se dice que el
 * número atómico del Rubidio es Z=37).
 * 
 * Siguiendo el diagrama de Moëller, los dos primeros electrones irán en el
 * subnivel 1s y los dos siguientes en 2s. A continuación se completará el 2p
 * con seis electrones más (son los que entran en los orbitales p). Los dos
 * siguientes irán a parar a 3s y los siguientes seis a 3p. En este momento
 * hemos colocado ya 18 electrones. Si continuamos con el proceso hasta colocar
 * los 37 veremos que los 36 primeros electrones completan todos los subniveles
 * hasta el 4p y por tanto que el último electrón termina en el subnivel 5s. El
 * número de electrones que quedan en cada subnivel es:
 * 
 * s p d
 * n=1 2
 * n=2 2 6
 * n=3 2 6 10
 * n=4 2 6
 * n=5 1
 * La forma de indicar la configuración electrónica es mostrar uno tras otro
 * todos los subniveles que tienen electrones utilizando el orden en el que se
 * han ido rellenando. Además, para cada subnivel se indica el número de
 * electrones que han caído en él. Para nuestro ejemplo será:
 * 
 * 1s2 2s2 2p6 3s2 3p6 4s2 3d10 4p6 5s1
 * El problema consiste en obtener la configuración electrónica de los elementos
 * que nos vaya diciendo Jonathan.
 * 
 * Entrada
 * La entrada consistirá en una secuencia de casos de prueba, donde cada caso de
 * prueba está formado por dos líneas: el nombre del elemento químico y su
 * número atómico Z. El nombre del elemento químico estará compuesto por una
 * única palabra y no tendrá nunca más de 50 letras; por su parte, el número
 * atómico estará entre 0 y 118.
 * 
 * El programa terminará de recibir valores cuando el nombre del elemento sea
 * "Exit".
 * 
 * Salida
 * Para cada caso de prueba, el programa indicará la configuración electrónica
 * del elemento introducido. La configuración electrónica será la lista de los
 * subniveles en el orden en el que se van rellenando seguido del número de
 * electrones que hay en ese subnivel. Cada subnivel se separará del anterior
 * por un espacio en blanco.
 * 
 * Si por un casual nos preguntan por el isótopo del Hidrógeno que no tiene
 * ningún electrón (Z=0), escribiremos 1s0.
 * 
 * Entrada de ejemplo
 * Cloro
 * 17
 * Calcio
 * 20
 * Rubidio
 * 37
 * Hierro
 * 26
 * Exit
 * Salida de ejemplo
 * 
 * 1s2 2s2 2p6 3s2 3p5
 * 1s2 2s2 2p6 3s2 3p6 4s2
 * 1s2 2s2 2p6 3s2 3p6 4s2 3d10 4p6 5s1
 * 1s2 2s2 2p6 3s2 3p6 4s2 3d6
 */