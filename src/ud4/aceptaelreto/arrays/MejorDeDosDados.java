package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class MejorDeDosDados {
    public static void main(String[] args) {
        Scanner entradaUsuario = new Scanner(System.in);

        System.out.println("Bienvenido al juego del mejor dado.");

        while (true) {
            // Leer el número de caras de los dados
            System.out.println("\nIntroduce el número de caras de los dados:");
            int numeroCaras = entradaUsuario.nextInt();

            // Si el número de caras es 0, terminamos el programa
            if (numeroCaras == 0) {
                System.out.println("Fin de los casos de prueba.");
                break;
            }

            // Crear arrays para almacenar los valores de cada dado
            int[] dadoUno = new int[numeroCaras];
            int[] dadoDos = new int[numeroCaras];

            // Leer los valores del primer dado
            System.out.println("Introduce los valores del primer dado:");
            for (int i = 0; i < numeroCaras; i++) {
                dadoUno[i] = entradaUsuario.nextInt();
            }

            // Leer los valores del segundo dado
            System.out.println("Introduce los valores del segundo dado:");
            for (int i = 0; i < numeroCaras; i++) {
                dadoDos[i] = entradaUsuario.nextInt();
            }

            // Calcular cuántas veces gana cada dado
            int victoriasDadoUno = calcularVictorias(dadoUno, dadoDos, numeroCaras);
            int victoriasDadoDos = calcularVictorias(dadoDos, dadoUno, numeroCaras);

            // Mostrar los resultados
            System.out.println("\nResultados:");
            System.out.println("Dado 1 gana en " + victoriasDadoUno + " ocasiones.");
            System.out.println("Dado 2 gana en " + victoriasDadoDos + " ocasiones.");

            // Determinar qué dado es mejor
            if (victoriasDadoUno > victoriasDadoDos) {
                System.out.println("PRIMERO");
            } else if (victoriasDadoDos > victoriasDadoUno) {
                System.out.println("SEGUNDO");
            } else {
                System.out.println("NO HAY DIFERENCIA");
            }
        }

        entradaUsuario.close();
    }

    /**
     * Calcula cuántas veces un dado gana contra el otro.
     * 
     * @param dadoA       Valores del dado a analizar.
     * @param dadoB       Valores del dado contrario.
     * @param numeroCaras Número de caras de los dados.
     * @return Número de veces que el dado A gana contra el dado B.
     */
    public static int calcularVictorias(int[] dadoA, int[] dadoB, int numeroCaras) {
        int totalVictorias = 0;

        // Comparamos cada cara de un dado con cada cara del otro
        for (int i = 0; i < numeroCaras; i++) {
            for (int j = 0; j < numeroCaras; j++) {
                if (dadoA[i] > dadoB[j]) {
                    totalVictorias++;
                }
            }
        }
        return totalVictorias;
    }
}

/*
 * El mejor de dos dados
 * Tiempo máximo: 1,000-2,000 s Memoria máxima: 8192 KiB
 * Dados
 * Existe un juego para dos jugadores que se juega con dos dados. Cada jugador
 * coge uno de ellos y lo lanza. El que obtiene la tirada más alta, gana esa
 * ronda. Y, como es lógico, sale vencedor el que más rondas gana.
 * 
 * Desde un punto de vista de probabilidad, el juego no tiene ningún misterio si
 * ambos jugadores utilizan dados idénticos. Ambos tienen las mismas
 * probabilidades de ganar.
 * 
 * Lo divertido viene cuando los dados son distintos. En el momento de comenzar
 * una partida, el jugador de más edad analiza ambos dados y decide con cuál
 * jugará.
 * 
 * Entrada
 * La entrada está compuesta por varios casos de prueba, cada uno ocupando 3
 * líneas.
 * 
 * La primera línea contiene el número de caras de los dados (2 ≤ n ≤ 100.000).
 * A continuación vendrán dos líneas con n números cada una que contienen los
 * valores de cada cara (entre 1 y 10.000).
 * 
 * La salida termina con un caso de prueba con dados de 0 caras que no debe
 * procesarse.
 * 
 * Salida
 * Por cada caso de prueba se escribirá PRIMERO si el jugador debe coger el
 * primer dado para maximizar sus opciones de ganar, y SEGUNDO si es mejor el
 * segundo dado.
 * 
 * Si no hay diferencia entre elegir uno u otro, se escribirá NO HAY DIFERENCIA.
 * 
 * Entrada de ejemplo
 * 6
 * 9 9 9 9 1 1
 * 6 6 6 6 6 6
 * 6
 * 4 4 4 4 11 11
 * 6 6 6 6 6 6
 * 3
 * 3 3 3
 * 3 3 3
 * 6
 * 9 9 9 9 1 1
 * 4 4 4 4 11 11
 * 0
 * Salida de ejemplo
 * PRIMERO
 * SEGUNDO
 * NO HAY DIFERENCIA
 * SEGUNDO
 * 
 */