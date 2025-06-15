package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class EntrandoEnPeloton {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido al programa de clasificación por pelotón.");

        while (true) {
            // Leer la cantidad de corredores en la etapa
            System.out.println("\nIntroduce el número de corredores:");
            int cantidadCorredores = sc.nextInt();

            // Si el número de corredores es 0, terminamos el programa
            if (cantidadCorredores == 0) {
                System.out.println("Fin de los casos de prueba.");
                break;
            }

            // Crear un array para almacenar los tiempos en formato "HH:MM:SS"
            String[] tiemposOriginales = new String[cantidadCorredores];
            int[] tiemposEnSegundos = new int[cantidadCorredores];

            // Leer los tiempos de los corredores
            System.out.println("Introduce los tiempos de llegada en formato HH:MM:SS:");
            for (int i = 0; i < cantidadCorredores; i++) {
                tiemposOriginales[i] = sc.next(); // Guardamos el tiempo en formato original
                tiemposEnSegundos[i] = convertirASegundos(tiemposOriginales[i]); // Convertimos a segundos
            }

            // Mostrar los tiempos originales
            System.out.println("Tiempos registrados:");
            for (int i = 0; i < cantidadCorredores; i++) {
                System.out.println(tiemposOriginales[i]);
            }

            // Determinar las posiciones dentro del pelotón
            int[] posiciones = calcularPosicionesPeloton(tiemposEnSegundos, cantidadCorredores);

            // Mostrar las posiciones
            System.out.println("Clasificación tras agrupación en pelotones:");
            for (int i = 0; i < cantidadCorredores; i++) {
                System.out.println(posiciones[i]);
            }
            System.out.println("---"); // Separador entre casos de prueba
        }

        sc.close();
    }

    /**
     * Convierte un tiempo en formato "HH:MM:SS" a segundos.
     * 
     * @param tiempo Tiempo en formato "HH:MM:SS".
     * @return Tiempo en segundos.
     */
    public static int convertirASegundos(String tiempo) {
        int horas = 0, minutos = 0, segundos = 0;
        int indice = 0;
        String valorTemporal = "";

        // Extraer horas
        while (tiempo.charAt(indice) != ':') {
            valorTemporal += tiempo.charAt(indice);
            indice++;
        }
        horas = obtenerNumero(valorTemporal);
        indice++;
        valorTemporal = "";

        // Extraer minutos
        while (tiempo.charAt(indice) != ':') {
            valorTemporal += tiempo.charAt(indice);
            indice++;
        }
        minutos = obtenerNumero(valorTemporal);
        indice++;
        valorTemporal = "";

        // Extraer segundos
        while (indice < tiempo.length()) {
            valorTemporal += tiempo.charAt(indice);
            indice++;
        }
        segundos = obtenerNumero(valorTemporal);

        return horas * 3600 + minutos * 60 + segundos; // Convertimos todo a segundos
    }

    /**
     * Convierte una cadena de números en un entero sin usar parseo.
     * 
     * @param cadena Número en formato String.
     * @return Número convertido a entero.
     */
    public static int obtenerNumero(String cadena) {
        int numero = 0;
        for (int i = 0; i < cadena.length(); i++) {
            numero = numero * 10 + (cadena.charAt(i) - '0'); // Convertimos cada dígito
        }
        return numero;
    }

    /**
     * Calcula las posiciones dentro del pelotón.
     * 
     * @param tiemposEnSegundos  Array con los tiempos en segundos.
     * @param cantidadCorredores Número total de corredores.
     * @return Array con las posiciones asignadas a cada corredor.
     */
    public static int[] calcularPosicionesPeloton(int[] tiemposEnSegundos, int cantidadCorredores) {
        int[] posiciones = new int[cantidadCorredores];
        int[] tiemposOrdenados = new int[cantidadCorredores];

        // Copiar tiempos originales para ordenarlos sin modificar el array original
        for (int i = 0; i < cantidadCorredores; i++) {
            tiemposOrdenados[i] = tiemposEnSegundos[i];
        }

        // Ordenar los tiempos usando un algoritmo simple (Burbuja)
        for (int i = 0; i < cantidadCorredores - 1; i++) {
            for (int j = 0; j < cantidadCorredores - i - 1; j++) {
                if (tiemposOrdenados[j] > tiemposOrdenados[j + 1]) {
                    int temp = tiemposOrdenados[j];
                    tiemposOrdenados[j] = tiemposOrdenados[j + 1];
                    tiemposOrdenados[j + 1] = temp;
                }
            }
        }

        // Asignar posiciones considerando los cortes de pelotón
        int posicionActual = 1; // Iniciamos la posición en 1
        int tiempoAnterior = tiemposOrdenados[0]; // Primer tiempo ordenado

        for (int i = 0; i < cantidadCorredores; i++) {
            if (i > 0 && tiemposOrdenados[i] - tiempoAnterior > 1) {
                posicionActual = i + 1; // Si hay un corte, cambiamos la posición
            }
            tiempoAnterior = tiemposOrdenados[i];
        }

        // Asignar las posiciones de cada corredor en el orden original
        for (int i = 0; i < cantidadCorredores; i++) {
            for (int j = 0; j < cantidadCorredores; j++) {
                if (tiemposEnSegundos[i] == tiemposOrdenados[j]) {
                    posiciones[i] = j + 1;
                    break;
                }
            }
        }

        return posiciones;
    }
}

/*
 * Entrando en pelotón
 * Tiempo máximo: 1,000-2,000 s Memoria máxima: 4096 KiB
 * Pelotón ciclista (imagen CC0)
 * Cuando en una vuelta ciclista los corredores llegan en pelotón, todos reciben
 * el mismo tiempo para esa etapa, incluso aunque no hayan llegado exactamente
 * en el mismo instante. Se hace así porque es físicamente imposible, por obvios
 * motivos de espacio, que todos lleguen a la vez. De modo que para evitar
 * accidentes (y, por qué no decirlo, simplificar la gestión), se les asigna a
 * todos el mismo tiempo y problema resuelto.
 * 
 * Ahora eso sí, en cuanto hay un corte entre dos ciclistas, se utiliza para el
 * rezagado el tiempo real en el que haya llegado. Si detrás de él llega un
 * segundo pelotón, todos ellos tendrán el mismo tiempo, otra vez.
 * 
 * Entrada
 * El programa deberá leer, por cada caso de prueba, un primer número 1 ≤ n ≤
 * 100 indicando el número de corredores que han conseguido terminar la etapa.
 * 
 * A continuación, vendrán n líneas con los tiempos de esos corredores en
 * formato HH:MM:SS, indicando las horas, minutos y segundos reales que ha
 * tardado cada uno en llegar a la meta (nunca más de 24 horas). Por razones que
 * se desconocen, la organización proporciona los tiempos en orden arbitrario.
 * 
 * Salida
 * Por cada caso de prueba se escribirá la posición de llegada de cada corredor,
 * en el mismo orden en el que se recibieron en la entrada. Todos los corredores
 * que son calificados con el mismo tiempo de llegada (tras la agrupación por el
 * pelotón) deben recibir el mismo puesto. Se considera que se ha producido un
 * corte de corredores si su distancia en tiempo es mayor que un segundo.
 * 
 * Después de cada caso de prueba el programa escribirá una línea con tres
 * guiones (---).
 * 
 * Entrada de ejemplo
 * 3
 * 01:01:01
 * 01:00:59
 * 01:01:00
 * 3
 * 01:03:00
 * 01:01:00
 * 01:01:00
 * Salida de ejemplo
 * 
 * 1
 * 1
 * 1
 * ---
 * 3
 * 1
 * 1
 * ---
 * 
 */