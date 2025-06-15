package ud4.aceptaelreto.matrices;

import java.util.Scanner;

public class PantallasDeCarga {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Leer el tamaño de la imagen
            int ancho = scanner.nextInt();
            int alto = scanner.nextInt();

            // Si ambos son 0, terminamos la entrada
            if (ancho == 0 && alto == 0)
                break;

            // Crear una matriz para almacenar los píxeles de la imagen
            char[][] imagen = new char[alto][ancho];

            // Leer la imagen
            System.out.println("Ingrese la imagen:");
            for (int i = 0; i < alto; i++) {
                imagen[i] = scanner.next().toCharArray();
            }

            // Verificar si la imagen puede ser representada en el ZX Spectrum
            boolean esValida = true;
            for (int i = 0; i < alto; i += 8) {
                for (int j = 0; j < ancho; j += 8) {
                    // Comprobar el bloque de 8x8
                    if (!esBloqueValido(imagen, i, j)) {
                        esValida = false;
                        break;
                    }
                }
                if (!esValida) {
                    break;
                }
            }

            // Imprimir el resultado
            if (esValida) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        }

        scanner.close(); // Cerrar el scanner después de la lectura
    }

    // Función que verifica si un bloque 8x8 tiene más de dos colores
    public static boolean esBloqueValido(char[][] imagen, int inicioFila, int inicioColumna) {
        // Usamos un arreglo para contar los colores diferentes en el bloque
        boolean[] colores = new boolean[15]; // Hay 15 colores, de A a O (15 letras)
        int cantidadColores = 0;

        for (int i = inicioFila; i < inicioFila + 8; i++) {
            for (int j = inicioColumna; j < inicioColumna + 8; j++) {
                char pixel = imagen[i][j];
                int indiceColor = pixel - 'A'; // Calcular el índice para la letra ('A' es 0, 'B' es 1, ..., 'O' es 14)

                if (!colores[indiceColor]) {
                    colores[indiceColor] = true;
                    cantidadColores++;
                }

                // Si encontramos más de dos colores, podemos terminar la comprobación
                if (cantidadColores > 2) {
                    return false;
                }
            }
        }

        return true;
    }
}

/*
 * Pantallas de carga
 * Comparación de la carátula y la pantalla de presentación del NavyMoves de
 * Dinamic y Luis Royo
 * Durante los 80, las portadas de los juegos tenían que vender el juego en una
 * época en la que el realismo gráfico era inexistente. Los estudios encargaban
 * las portadas a ilustradores como Alfonso Azpiri o Luis Royo que crearon
 * verdaderas obras de arte.
 * 
 * El problema era cuando el juego tenía que mostrar esas imágenes durante las
 * pantallas de carga para aliviar la tediosa espera. Además de tener muy bajas
 * resoluciones, la riqueza de color era mínima.
 * 
 * El ZX Spectrum, por ejemplo, solo era capaz de mostrar 15 colores1, y no
 * todos a la vez. En concreto, la pantalla se dividía en bloques de 8×8
 * píxeles, y en cada bloque solo podían usarse dos colores distintos. De esta
 * forma, con su resolución de 256×192 la pantalla quedaba dividida en una
 * cuadrícula de 32×24 celdas de 8×8 píxeles, y cada una solo podía mostrar 2 de
 * los 15 colores.
 * 
 * Conseguir disimular esta limitación era también todo un arte.
 * 
 * Entrada
 * Cada caso de prueba comienza con dos números que indican el ancho y alto, en
 * número de píxeles, de una imagen. Se garantiza que ambas dimensiones son
 * múltiplo de 8 y no serán mayores que 48.
 * 
 * A continuación viene la imagen, con una letra para cada píxel entre la A y la
 * O (con el alfabeto inglés, 15 letras distintas).
 * 
 * La entrada termina con dos ceros, que no deben procesarse.
 * 
 * Salida
 * Por cada caso de prueba el programa escribirá "SI" si la imagen puede
 * representarse en un ZX Spectrum, es decir si cada uno de los bloques de 8×8
 * píxeles utiliza como mucho 2 colores (letras). Si, por el contrario, algún
 * bloque de 8×8 usa más de dos colores se escribirá "NO".
 * 
 * Entrada de ejemplo
 * 16 8
 * AAAAAAAIBBCCCBBC
 * AAIIIAAICBBCBBCC
 * AIIIAAIICCBBBCCC
 * IIIAAIIICCBBBCCC
 * IIAAIIAICBBCBBCC
 * IAAIIAAIBBCCCBBC
 * AAAAAAAIBBCCCBBC
 * IIIIIIIICCCCCCCC
 * 0 0
 * Salida de ejemplo
 * SI
 */