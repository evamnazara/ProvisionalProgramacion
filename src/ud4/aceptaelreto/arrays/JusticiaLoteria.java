package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class JusticiaLoteria {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Bucle para procesar varios casos de prueba
        while (true) {
            // Leer el número de localidades
            int n = sc.nextInt();

            // Si n es 0, terminamos el proceso
            if (n == 0) {
                break;
            }

            // Variables para almacenar la proporción de dinero invertido a premios
            // obtenidos
            int dineroPrevio = sc.nextInt(); // Dinero de la primera localidad
            int premiosPrevios = sc.nextInt(); // Premios de la primera localidad
            double proporcionPrevio = (double) dineroPrevio / premiosPrevios; // Proporción de la primera localidad

            boolean esJusto = true; // Suponemos que es justo, luego verificamos

            // Recorremos las siguientes localidades
            for (int i = 1; i < n; i++) {
                int dinero = sc.nextInt(); // Dinero invertido
                int premios = sc.nextInt(); // Premios obtenidos

                // Verificamos si la proporción es la misma
                double proporcionActual = (double) dinero / premios;

                if (proporcionActual != proporcionPrevio) {
                    esJusto = false; // Si alguna proporción no coincide, el reparto no es justo
                    break; // Salimos del bucle, no es necesario seguir verificando
                }
            }

            // Imprimimos el resultado basado en la condición de justicia
            if (esJusto) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}

/*
 * 
 * La justicia de la lotería
 * Tiempo máximo: 1,000-2,000 s Memoria máxima: 4096 KiB
 * Bolas de lotería
 * La lotería es un juego de azar basado en la existencia de billetes o cartones
 * que los jugadores compran con la esperanza de que el número o números que
 * contienen coincidan con los extraídos de un bombo o cualquier otro recipiente
 * durante el sorteo.
 * 
 * Existen sorteos famosos que "arrastran" a miles o millones de personas a
 * comprar sueños en forma de billetes de lotería. Muchos no se conforman con
 * comprar un número, sino que compran varios, para incrementar las
 * posibilidades de llevarse el premio.
 * 
 * Esa obsesión por comprar números, intercambiarlos con familiares, vecinos o
 * asociaciones de padres se basa en la intuición de que cuanto más billetes se
 * hayan comprado más probabilidades hay de que toque algo.
 * 
 * Para comprobar si es o no eso cierto, tenemos las estadísticas de los últimos
 * sorteos llevados a cabo en un territorio. En concreto, tenemos la cantidad
 * total de dinero invertido por los vecinos de distintas localidades y el
 * dinero ganado por ellos. ¿Ha sido justo el reparto que ha hecho el bombo? Se
 * entiende que el reparto es justo si cuando una ciudad ha gastado más que otra
 * consigue ganar también más premios.
 * 
 * Entrada
 * La entrada estará compuesta por varios casos de prueba.
 * 
 * Cada caso de prueba comienza con una línea indicando el número n de
 * localidades analizadas (1 ≤ n ≤ 100.000). A continuación vendrán n líneas,
 * una por localidad, con dos enteros: la cantidad de dinero invertida en
 * lotería por sus vecinos y la cantidad de premios conseguidos. Ambos números
 * serán menores que 1.000.000.
 * 
 * La entrada termina con un caso de prueba sin ciudades, que no debe
 * procesarse.
 * 
 * Salida
 * Por cada caso de prueba se escribirá SI si en ese caso la lotería fue justa,
 * y NO en caso contrario.
 * 
 * Entrada de ejemplo
 * 4
 * 9 4
 * 10 6
 * 9 5
 * 1 3
 * 3
 * 10 5
 * 20 5
 * 30 5
 * 0
 * Salida de ejemplo
 * 
 * SI
 * NO
 * 
 */
