package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class RepartiendoRegalos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leer el número de casos de prueba
        int t = sc.nextInt();

        // Procesar cada caso de prueba
        for (int i = 0; i < t; i++) {
            // Leer el portal de aterrizaje y el número de portales
            int p = sc.nextInt();
            int n = sc.nextInt();

            // Leer la lista de portales donde repartir regalos
            int[] portales = new int[n];
            for (int j = 0; j < n; j++) {
                portales[j] = sc.nextInt();
            }

            // Creamos un arreglo para saber si ya hemos visitado un portal
            boolean[] visitados = new boolean[n];

            // Guardamos el orden de visita de los portales
            String ordenVisita = "";

            // Empezamos desde el portal de aterrizaje
            int actual = p;

            // Mientras haya portales por visitar
            while (true) {
                int minDistancia = Integer.MAX_VALUE;
                int portalSeleccionado = -1;
                int indiceSeleccionado = -1;

                // Buscar el portal más cercano
                for (int j = 0; j < n; j++) {
                    if (!visitados[j]) {
                        // Calculamos la distancia absoluta
                        int distancia = Math.abs(actual - portales[j]);

                        // Si encontramos una distancia menor o si están igual y el número del portal es
                        // mayor
                        if (distancia < minDistancia
                                || (distancia == minDistancia && portales[j] > portalSeleccionado)) {
                            minDistancia = distancia;
                            portalSeleccionado = portales[j];
                            indiceSeleccionado = j;
                        }
                    }
                }

                // Si hemos encontrado un portal por visitar, lo añadimos al orden
                if (portalSeleccionado != -1) {
                    // Marcamos el portal como visitado
                    visitados[indiceSeleccionado] = true;
                    // Añadimos el portal al resultado
                    if (ordenVisita.isEmpty()) {
                        ordenVisita += portalSeleccionado;
                    } else {
                        ordenVisita += " " + portalSeleccionado;
                    }
                    // Actualizamos la posición de Papá Noel
                    actual = portalSeleccionado;
                } else {
                    break; // Si no hay más portales por visitar, terminamos
                }
            }

            // Imprimir el resultado para este caso de prueba
            System.out.println(ordenVisita);
        }

        sc.close();
    }
}

/*
 * 
 * Repartiendo regalos en tu calle
 * Tiempo máximo: 1,000-2,000 s Memoria máxima: 4096 KiB
 * Papá Noel quiere repartir juguetes a todos los niños de la mejor calle del
 * mundo: la tuya. Para ello, consulta una lista de los portales de esa calle en
 * los que debe dejar regalos.
 * 
 * La forma en la que reparte los regalos es peculiar. Aterriza con su trineo en
 * un portal determinado (que no tiene por qué ser uno en los que tiene que dar
 * regalos), y luego sigue las siguientes reglas:
 * 
 * Reparte los regalos al portal que tiene más cerca de su posición actual.
 * La distancia entre dos portales es el valor absoluto de su resta. Es decir,
 * la distancia entre el portal 10 y el portal 8 es 2 (10 − 8 = 2), lo mismo que
 * la distancia entre el portal 8 y el portal 10 (valor absoluto de 8 − 10).
 * Si dos portales están a igual distancia, siempre va hacia el que tiene el
 * número más grande.
 * ¿Cuál es el orden en el que visita los portales?
 * 
 * Entrada
 * La entrada comienza con un número que indica el número de casos de prueba que
 * siguen a continuación.
 * 
 * Cada caso de prueba tiene dos líneas. La primera contiene el número p del
 * portal en el que Papá Noel aterriza (0 ≤ p ≤ 5.000) seguido del número n de
 * portales donde hay que repartir regalos (2 ≤ n ≤ 1.000). La segunda línea
 * tiene n números distintos entre 0 y 5.000 con los números del portal en los
 * que hay que dejar regalos.
 * 
 * Salida
 * Por cada caso de prueba se mostrará una única línea con el orden en el que
 * Papá Noel irá dejando los regalos cumpliendo las normas anteriores. El portal
 * en el que aterriza debe mostrarse únicamente si en él hay que dejar algo.
 * 
 * Entrada de ejemplo
 * 3
 * 0 2
 * 2 4
 * 3 3
 * 2 5 1
 * 3 3
 * 2 4 7
 * Salida de ejemplo
 * 
 * 2 4
 * 2 1 5
 * 4 2 7
 * 
 */
