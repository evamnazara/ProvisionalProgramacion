package ud4.aceptaelreto.matrices;

import java.util.Scanner;

public class DaredevilSinRadar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Leer el número de filas y columnas de la sala
            int filas = scanner.nextInt();
            int columnas = scanner.nextInt();

            // Caso de terminación (0 0)
            if (filas == 0 && columnas == 0) {
                break; // Si filas y columnas son 0, terminamos el programa
            }

            // Leer la representación de la sala (matriz de caracteres)
            char[][] sala = new char[filas][columnas];
            System.out.println("Introduzca el mapa de la sala:");
            for (int i = 0; i < filas; i++) {
                String linea = scanner.next(); // Cada línea de la sala
                for (int j = 0; j < columnas; j++) {
                    sala[i][j] = linea.charAt(j); // Guardamos cada celda de la sala
                }
            }

            // Leer el número de consultas que se van a realizar
            int numConsultas = scanner.nextInt();
            System.out.println("Realizando consultas:");

            // Procesar cada consulta
            for (int i = 0; i < numConsultas; i++) {
                // Leer la posición inicial de Daredevil (ajustamos a índice base 0)
                int fila = scanner.nextInt() - 1;
                int columna = scanner.nextInt() - 1;
                String direccion = scanner.next().toUpperCase(); // Convertimos la dirección a mayúsculas para asegurar
                                                                 // la consistencia

                // Determinar la distancia al villano más cercano
                int distancia = buscarVillano(sala, filas, columnas, fila, columna, direccion);

                // Imprimir el resultado de la consulta
                if (distancia == -1) {
                    System.out.println("NINGUNO"); // Si no hay villano, imprimir "NINGUNO"
                } else {
                    System.out.println(distancia); // Imprimir la distancia al villano
                }
            }

            // Separador entre casos de prueba
            System.out.println("---");
        }

        // Cerrar el scanner para liberar recursos
        scanner.close();
    }

    // Busca la distancia al villano más cercano en la dirección dada
    public static int buscarVillano(char[][] sala, int filas, int columnas, int fila, int columna, String direccion) {
        int distancia = 0;

        // Determinar cómo moverse en función de la dirección
        int incrementoFila = 0;
        int incrementoColumna = 0;

        switch (direccion) {
            case "ARRIBA":
                incrementoFila = -1; // Moverse hacia arriba
                break;
            case "ABAJO":
                incrementoFila = 1; // Moverse hacia abajo
                break;
            case "IZQUIERDA":
                incrementoColumna = -1; // Moverse hacia la izquierda
                break;
            case "DERECHA":
                incrementoColumna = 1; // Moverse hacia la derecha
                break;
            default:
                return -1; // Dirección inválida
        }

        // Moverse en la dirección hasta encontrar un villano o salir del mapa
        while (true) {
            fila += incrementoFila;
            columna += incrementoColumna;
            distancia++;

            // Verificar si se salió del mapa
            if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
                return -1; // Si nos salimos del mapa, no hay villano en esta dirección
            }

            // Si encontramos un villano (representado por 'X'), devolver la distancia
            if (sala[fila][columna] == 'X') {
                return distancia; // Devolvemos la distancia al villano
            }
        }
    }
}

/*
 * EL HOMBRE SIN MIEDO Y SIN RADAR
 * 
 * El hombre sin miedo y sin radar
 * Tiempo máximo: 2,000 s Memoria máxima: 4096 KiB
 * Daredevil, también conocido como "El hombre sin miedo", es un superhéroe que
 * quedó ciego de niño por culpa de una sustancia radiactiva. Dicha sustancia le
 * hizo perder la vista pero, al mismo tiempo, agudizó el resto de sus sentidos.
 * 
 * Así, Daredevil desarrolló un sistema de radar (similar a la ecolocalización)
 * que le permite saber en qué lugar están los villanos con los que va a
 * combatir.
 * 
 * Sin embargo, su archienemigo Kingpin le ha tendido una trampa y le ha
 * encerrado en una habitación cuya resonancia anula su sistema de radar.
 * Además, ha convocado a un montón de villanos que le esperan con rencor para
 * darle una paliza.
 * 
 * Daredevil todavía no sabe la que se le viene encima pero, afortunadamente,
 * tiene un gadget programable que quizá pueda ayudarle.
 * 
 * Entrada
 * 
 * El programa deberá procesar múltiples casos de prueba. Cada uno comienza con
 * la descripción de la sala a la que llega Daredevil. Una sala es un espacio
 * rectangular organizado en celdas, cada una de las cuales puede estar libre u
 * ocupada por un villano.
 * 
 * La primera línea del caso de prueba contiene dos números, 1 ≤ F, C ≤ 100
 * indicando la cantidad de filas y columnas que tiene la sala. A continuación
 * vienen F líneas de C letras cada una. Las letras pueden ser "X" para indicar
 * que la celda está ocupada por un villano, o "." para indicar que está vacía.
 * 
 * Tras el mapa del caso de prueba aparece un número 1 ≤ N ≤ 100 con la cantidad
 * de consultas que se realizarán sobre ese mapa. Cada consulta es una posición
 * donde podría estar Daredevil y la dirección hacia la que apunta con su
 * gadget. La posición se indica proporcionando primero el número de fila, y
 * luego el número de columna. La celda (1,1) se encuentra en la esquina
 * superior izquierda del mapa. La dirección será IZQUIERDA, DERECHA, ARRIBA o
 * ABAJO. Se garantiza que no se realizará ninguna consulta en una posición
 * ocupada por un villano.
 * 
 * La entrada termina con dos ceros.
 * 
 * Salida
 * 
 * Por cada consulta se escribirá, en una línea independiente, la distancia, en
 * número de celdas, al villano más cercano desde la posición de la consulta en
 * la dirección indicada. Si no hay ningún villano, se escribirá "NINGUNO".
 * 
 * Al final de cada caso de prueba se escribirá "---".
 * 
 * Entrada de ejemplo
 * 
 * 3 8
 * .X....X.
 * ...X....
 * ....X...
 * 3
 * 3 2 ARRIBA
 * 2 1 DERECHA
 * 1 1 ABAJO
 * 0 0
 * 
 * _________
 * Aquí tienes una solución en Java explicada paso a paso, utilizando solo
 * estructuras básicas y sin List, parseInt() ni funciones avanzadas.
 * 
 * Estrategia para resolver el problema
 * 1. Leer la entrada
 * • Se leen dos números F y C que indican el tamaño de la sala.
 * • Luego se leen F líneas con C caracteres (X para villano, . para espacio
 * libre).
 * • Se almacena el mapa en un arreglo bidimensional (char[][]).
 * 2. Leer las consultas
 * • Se lee N, el número de consultas.
 * • Para cada consulta:
 * • Se obtiene la fila y la columna donde está Daredevil.
 * • Se lee la dirección (ARRIBA, ABAJO, IZQUIERDA, DERECHA).
 * 3. Buscar el villano más cercano en la dirección dada
 * • Se empieza desde la posición de Daredevil y se avanza en la dirección
 * indicada.
 * • Se cuenta cuántas celdas se recorren hasta encontrar un X o salir del mapa.
 * • Si se encuentra un X, se imprime la distancia.
 * • Si no se encuentra ninguno, se imprime "NINGUNO".
 * 4. Imprimir los resultados
 * • Para cada consulta se imprime la distancia al villano o "NINGUNO".
 * • Al final de cada caso de prueba, se imprime "---".
 * 
 * 
 * 
 * Explicación del código
 * 
 * 1. Leer la entrada
 * • scanner.nextInt() obtiene filas y columnas.
 * • Si ambos son 0, se termina el programa.
 * • Se usa un char[][] para almacenar la sala.
 * • Se lee cada línea del mapa y se guarda en el arreglo.
 * 
 * 2. Leer las consultas
 * • scanner.nextInt() obtiene numConsultas.
 * • Para cada consulta:
 * • Se obtienen la fila y la columna (restando 1 para convertir a índice base
 * 0).
 * • Se lee la dirección (ARRIBA, ABAJO, IZQUIERDA, DERECHA).
 * 
 * 3. Buscar el villano más cercano
 * • Se usa una función buscarVillano(), que:
 * • Usa un while para moverse en la dirección indicada.
 * • Si se sale del mapa, devuelve -1 (“NINGUNO”).
 * • Si encuentra X, devuelve la distancia
 * 
 * 
 */