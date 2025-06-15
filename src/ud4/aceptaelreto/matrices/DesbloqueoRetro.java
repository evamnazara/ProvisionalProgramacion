package ud4.aceptaelreto.matrices;

import java.util.Scanner;

public class DesbloqueoRetro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Procesar cada caso de prueba
        while (true) {
            // Leer el número de filas, columnas, y las coordenadas iniciales
            System.out.print("Ingrese F, C, f, c (dimensiones y posición inicial): ");
            int numFilas = scanner.nextInt(); // Número de filas
            int numColumnas = scanner.nextInt(); // Número de columnas
            int filaInicial = scanner.nextInt() - 1; // Fila inicial (convertida a índice 0)
            int columnaInicial = scanner.nextInt() - 1; // Columna inicial (convertida a índice 0)

            // Si F y C son 0, terminamos el programa
            if (numFilas == 0 && numColumnas == 0) {
                break;
            }

            // Crear la matriz de desbloqueo, inicialmente llena con puntos ('.')
            char[][] matrizDesbloqueo = new char[numFilas][numColumnas];
            for (int i = 0; i < numFilas; i++) {
                for (int j = 0; j < numColumnas; j++) {
                    matrizDesbloqueo[i][j] = '.';
                }
            }

            // Marcar la posición inicial con 'O'
            matrizDesbloqueo[filaInicial][columnaInicial] = 'O';

            // Leer la secuencia de movimientos
            System.out.print("Ingrese los movimientos: ");
            String secuenciaMovimientos = scanner.next();

            // Procesar cada movimiento
            int filaActual = filaInicial;
            int columnaActual = columnaInicial;
            for (int i = 0; i < secuenciaMovimientos.length(); i++) {
                char movimiento = secuenciaMovimientos.charAt(i);

                // Variables para la nueva posición y la línea a dibujar
                int filaNueva = filaActual;
                int columnaNueva = columnaActual;
                char caracterLinea = ' '; // Variable para la línea entre las celdas

                // Definir el movimiento según el número del teclado
                switch (movimiento) {
                    case '1': // Arriba-izquierda
                        filaNueva--;
                        columnaNueva--;
                        caracterLinea = '/';
                        break;
                    case '2': // Arriba
                        filaNueva--;
                        caracterLinea = '|';
                        break;
                    case '3': // Arriba-derecha
                        filaNueva--;
                        columnaNueva++;
                        caracterLinea = '\\';
                        break;
                    case '4': // Izquierda
                        columnaNueva--;
                        caracterLinea = '-';
                        break;
                    case '6': // Derecha
                        columnaNueva++;
                        caracterLinea = '-';
                        break;
                    case '7': // Abajo-izquierda
                        filaNueva++;
                        columnaNueva--;
                        caracterLinea = '\\';
                        break;
                    case '8': // Abajo
                        filaNueva++;
                        caracterLinea = '|';
                        break;
                    case '9': // Abajo-derecha
                        filaNueva++;
                        columnaNueva++;
                        caracterLinea = '/';
                        break;
                }

                // Marcar la nueva posición con 'O'
                matrizDesbloqueo[filaNueva][columnaNueva] = 'O';

                // Dibujar la línea entre la posición anterior y la nueva
                if (caracterLinea != ' ' && (filaActual != filaNueva || columnaActual != columnaNueva)) {
                    if (filaActual == filaNueva) {
                        // Línea horizontal
                        for (int j = Math.min(columnaActual, columnaNueva); j <= Math.max(columnaActual,
                                columnaNueva); j++) {
                            matrizDesbloqueo[filaActual][j] = caracterLinea;
                        }
                    } else if (columnaActual == columnaNueva) {
                        // Línea vertical
                        for (int j = Math.min(filaActual, filaNueva); j <= Math.max(filaActual, filaNueva); j++) {
                            matrizDesbloqueo[j][columnaActual] = caracterLinea;
                        }
                    } else {
                        // Línea diagonal
                        int pasoFila = (filaNueva > filaActual) ? 1 : -1;
                        int pasoColumna = (columnaNueva > columnaActual) ? 1 : -1;
                        int fila = filaActual;
                        int columna = columnaActual;
                        while (fila != filaNueva && columna != columnaNueva) {
                            matrizDesbloqueo[fila][columna] = caracterLinea;
                            fila += pasoFila;
                            columna += pasoColumna;
                        }
                        matrizDesbloqueo[filaNueva][columnaNueva] = 'O'; // Asegurar que la última posición sea 'O'
                    }
                }

                // Actualizar las posiciones para el siguiente movimiento
                filaActual = filaNueva;
                columnaActual = columnaNueva;
            }

            // Imprimir el patrón final con borde
            imprimirMatrizConBorde(matrizDesbloqueo);
        }

        // Cerrar el escáner
        scanner.close();
    }

    // Método para imprimir la matriz con borde
    private static void imprimirMatrizConBorde(char[][] matriz) {
        int numFilas = matriz.length;
        int numColumnas = matriz[0].length;

        // Imprimir la primera línea del borde
        System.out.print("+");
        for (int i = 0; i < numColumnas; i++) {
            System.out.print("-");
        }
        System.out.println("+");

        // Imprimir cada fila de la matriz con los valores y borde
        for (int i = 0; i < numFilas; i++) {
            System.out.print("|");
            for (int j = 0; j < numColumnas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("|");
        }

        // Imprimir la última línea del borde
        System.out.print("+");
        for (int i = 0; i < numColumnas; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}
/*
 * Desbloqueo retro
 * Móvil antiguo con teclado numérico sobre un móvil más moderno de pantalla
 * táctil mostrando el patrón de desbloqueo
 * Tu amigo Amadeo L. D. Zings vive en el pasado. Añora los viejos tiempos de
 * disquettes, chirriantes módems a 56 Kbps y monitores CRT. ¡Qué tiempos
 * aquellos en los que para ver el siguiente capítulo de una serie había que
 * esperar una larga semana de incertidumbre!
 * 
 * Fiel a sus principios, sigue utilizando su viejo móvil; dice que la sensación
 * de pulsar botones físicos es preferible a la frialdad de una pantalla, por
 * muchos colores y aplicaciones que tenga. Pero reconoce que le gustaría que su
 * móvil no pudiera usarlo cualquiera, y tener un patrón de desbloqueo como ha
 * visto en alguno de esos teléfonos mucho más modernos que el suyo. Está
 * convencido de que la pantalla del trasto al que llama teléfono podría
 * mostrar, con letras y símbolos, la "matriz" sobre la que pintar el patrón.
 * Luego, simularía el desplazamiento utilizando el teclado numérico a modo de
 * flechas del cursor, con el 1 indicando que quiere desplazarse hacia arriba y
 * a la izquierda, por ejemplo.
 * 
 * Como le ves un poco desesperado, has decidido buscar información sobre como
 * se desarrollaba para esos viejos aparatos para darle una sorpresa en su
 * próximo cumpleaños.
 * 
 * Entrada
 * Cada caso de prueba comienza con dos números, 1 ≤ F, C ≤ 30 indicando,
 * respectivamente, el número de filas y de columnas que tiene la matriz de
 * desbloqueo que quieres pintar en la pantalla. A continuación vienen dos
 * números, 1 ≤ f ≤ F y 1 ≤ c ≤ C, indicando la fila y la columna en la que
 * comienza el patrón. La última línea del caso de prueba es una sucesión de
 * dígitos indicando el desplazamiento en la matriz. Cada dígito indica una
 * dirección de desplazamiento de acuerdo a su posición en el teclado numérico
 * de un teléfono, de modo, por ejemplo, que los números del 1 al 3 indican un
 * desplazamiento hacia arriba, y, además, el 1 desplaza hacia la izquierda y el
 * 3 hacia la derecha. La secuencia de dígitos, de no más de 1.000, termina con
 * un 5 que marca el final. Se garantiza que la posición actual se mantiene
 * siempre dentro de los límites.
 * 
 * Amadeo es un pelín paranoico con la seguridad, y es posible que su patrón
 * pase varias veces por los mismos sitios.
 * 
 * La entrada termina con dos ceros, que no deben procesarse.
 * 
 * Salida
 * Por cada caso de prueba, el programa escribirá el estado final del patrón.
 * 
 * El patrón estará encerrado en un marco de guiones y líneas verticales, con
 * signos de suma en las esquinas. Cada posición "pulsable" está separada de las
 * demás por un hueco (espacio o línea en blanco). Las posiciones no tocadas se
 * pintarán con un punto (".") y las tocadas con la letra o mayúscula ("O").
 * 
 * Las posiciones tocadas se unirán con líneas ("-", "|", "\", "/" o "X") en
 * función del desplazamiento realizado.
 * 
 * Entrada de ejemplo
 * 3 3
 * 1 1
 * 687615
 * 2 4
 * 1 1
 * 9392735
 * 0 0
 * Salida de ejemplo
 * +-----+
 * |O-O .|
 * | | |
 * |O O .|
 * | X |
 * |O-O .|
 * +-----+
 * +-------+
 * |O . O O|
 * | \ / X||
 * |. O O O|
 * +-------+
 */