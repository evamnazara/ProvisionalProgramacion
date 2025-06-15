package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class EscaleraDeColor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            // Leer el primer número (si es 0, terminar el programa)
            System.out.print("Introduce las cartas (0 para terminar): ");
            String carta1 = sc.next();

            if (carta1.equals("0")) {
                break; // Si es 0, terminamos el programa
            }

            // Leer las 4 cartas de la mano
            String[] cartas = new String[4];
            cartas[0] = carta1 + " " + sc.next(); // Carta 1
            cartas[1] = sc.next() + " " + sc.next(); // Carta 2
            cartas[2] = sc.next() + " " + sc.next(); // Carta 3
            cartas[3] = sc.next() + " " + sc.next(); // Carta 4

            // Determinar el palo y los valores de las cartas
            String palo = cartas[0].split(" ")[1]; // El palo es el mismo en todas las cartas
            int[] valores = new int[4];

            for (int i = 0; i < 4; i++) {
                String valor = cartas[i].split(" ")[0];
                valores[i] = getValorCarta(valor); // Obtener el valor numérico de la carta
            }

            // Ordenar los valores para analizar la secuencia
            sortArray(valores);

            // Verificar si las cartas son del mismo palo
            boolean mismoPalo = true;
            for (int i = 1; i < 4; i++) {
                if (!cartas[i].split(" ")[1].equals(palo)) {
                    mismoPalo = false;
                    break;
                }
            }

            if (!mismoPalo) {
                System.out.println("NADA");
                continue;
            }

            // Verificar si falta una carta para completar la escalera
            String resultado = verificarEscalera(valores, palo);
            System.out.println(resultado);
        }

        sc.close();
    }

    // Función que convierte el valor de la carta a un número
    public static int getValorCarta(String valor) {
        switch (valor) {
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
            default:
                return Integer.parseInt(valor);
        }
    }

    // Función para ordenar el array de valores (implementación simple de burbuja)
    public static void sortArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    // Intercambiar los valores
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    // Función que verifica si es posible formar una escalera de color
    public static String verificarEscalera(int[] valores, String palo) {
        // Si ya son consecutivos, devolver "NADA"
        if (valores[3] - valores[0] == 3) {
            return "NADA";
        }

        // Si hay una carta faltante, devolver el valor de la carta
        if (valores[3] - valores[0] == 4) {
            for (int i = valores[0]; i <= valores[3]; i++) {
                if (!contains(valores, i)) {
                    String cartaFaltante = getCartaValor(i) + " " + palo;
                    return cartaFaltante;
                }
            }
        }

        return "NADA";
    }

    // Función para verificar si un valor está en el array de valores (sin utilizar
    // Arrays.stream)
    public static boolean contains(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    // Función para obtener la carta a partir de su valor numérico
    public static String getCartaValor(int valor) {
        switch (valor) {
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            case 14:
                return "A";
            default:
                return Integer.toString(valor);
        }
    }
}

/*
 * Escalera de color
 * 
 * La llamada baraja inglesa es una modificación menor de la baraja francesa.
 * Sus similitudes son tan grandes, que es habitual considerarlas la misma.
 * Contiene 52 cartas, distribuídas en 4 palos diferentes. Los palos se conocen
 * con el nombre de picas (♠), diamantes (♦), tréboles (♣) y corazones (♥). De
 * cada uno, hay trece cartas, con valores del 1 (al que se conoce como As)
 * hasta el 10, más las tres figuras, Jack (J), Queen (Q) y King (K), que,
 * numéricamente, serían los valores 11, 12 y 13. Las diferencias más notables
 * entre la baraja francesa y la inglesa están en el nombre de la carta Jack
 * (conocida en la francesa como Valet, V), y el As, nombre específico de la
 * baraja inglesa que, además, desplaza su valor en muchos juegos del 1 al 14,
 * convirtiéndola en una carta más poderosa que la K.
 * 
 * La baraja inglesa se utiliza en juegos mundialmente conocidos, como el
 * bridge, la canasta o el póquer.
 * 
 * En este último, la jugada más valiosa es una escalera de color, que se forma
 * cuando un mismo jugador consigue una mano de 5 cartas del mismo palo con
 * valores consecutivos.
 * 
 * Entrada
 * La entrada estará compuesta por sucesivos casos de prueba. Cada uno ocupará
 * una línea, y estará compuesto por una mano de cuatro cartas del juego del
 * póquer.
 * 
 * Cada carta se representará indicando primero su número (2, 3, 4, 5, 6, 7, 8,
 * 9, 10, J, Q, K, A) y luego su palo (P para picas, D para diamantes, T para
 * tréboles y C para corazones) separados por un espacio. Las cuatro cartas de
 * cada caso de prueba estarán también separadas por un espacio.
 * 
 * La entrada finalizará cuando se reciba un 0 en lugar del valor de la primera
 * carta de la mano.
 * 
 * Salida
 * Para cada caso de prueba el programa escribirá la carta necesaria que habría
 * que añadir a las cuatro recibidas para obtener la escalera de color más alta
 * posible. La salida vendrá dada por un valor y un palo, con el mismo formato
 * que en la entrada. Si con las cartas del caso de prueba resultase imposible
 * crear una escalera, se escribirá NADA.
 * 
 * Aunque en el desarrollo de una partida de póquer para crear una escalera el
 * As puede utilizarse tanto al principio de los números (valor 1) como al final
 * (valor 14), el programa considerará que sólo puede colocarse después de una
 * K.
 * 
 * Entrada de ejemplo
 * 2 C 3 C 4 C 5 C
 * Q P 9 P 7 P 6 P
 * Q P K P 9 P 10 P
 * 0
 * Salida de ejemplo
 * 
 * 6 C
 * NADA
 * J P
 */