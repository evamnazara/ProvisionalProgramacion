package ud4.aceptaelreto.matrices;

import java.util.Scanner;

public class RubikPixelArt {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Leer número de filas (f) y columnas (c) de cubos
            int f = scanner.nextInt();
            int c = scanner.nextInt();

            // Si f y c son 0, terminar el programa
            if (f == 0 && c == 0)
                break;

            // Leer la figura original (3 * f filas y 3 * c columnas)
            char[][] figura = new char[3 * f][3 * c];
            scanner.nextLine(); // Limpiar el buffer
            for (int i = 0; i < 3 * f; i++) {
                String linea = scanner.nextLine();
                for (int j = 0; j < 3 * c; j++) {
                    figura[i][j] = linea.charAt(j);
                }
            }

            // Leer el número de cubos que tenemos que colocar
            int numCubos = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            // Leer las configuraciones de los cubos a colocar
            char[][][] cubos = new char[numCubos][3][3];
            for (int i = 0; i < numCubos; i++) {
                for (int j = 0; j < 3; j++) {
                    String linea = scanner.nextLine();
                    for (int k = 0; k < 3; k++) {
                        cubos[i][j][k] = linea.charAt(k);
                    }
                }
            }

            // Buscar cada cubo en la figura
            for (int i = 0; i < numCubos; i++) {
                boolean encontrado = false;
                // Recorremos la figura original
                for (int row = 0; row <= 3 * f - 3; row++) {
                    for (int col = 0; col <= 3 * c - 3; col++) {
                        // Comparar el cubo en la posición (row, col) con el cubo actual
                        boolean match = true;
                        for (int dr = 0; dr < 3; dr++) {
                            for (int dc = 0; dc < 3; dc++) {
                                if (figura[row + dr][col + dc] != cubos[i][dr][dc]) {
                                    match = false;
                                    break;
                                }
                            }
                            if (!match)
                                break;
                        }

                        if (match) {
                            System.out.println((row / 3 + 1) + " " + (col / 3 + 1)); // Imprimir la posición (1-indexed)
                            encontrado = true;
                            break;
                        }
                    }
                    if (encontrado)
                        break;
                }

                // Si no se encuentra el cubo en la figura
                if (!encontrado) {
                    System.out.println("NO SE USA");
                }
            }
        }

        scanner.close();
    }
}

/*
 * Rubik pixel art
 * Tiempo máximo: 4,000 s Memoria máxima: 4096 KiB
 * Mosaico con cubos de Rubik
 * El cubo de Rubik es un famoso puzzle inventado en la década de 1970 por Erno
 * Rubik, arquitecto y escultor húngaro. Cada una de sus caras está dividida en
 * 9 pequeños cuadros. En su configuración inicial, cada cara tiene todos sus
 * cuadros del mismo color; pero al ir girándolas, los colores se distribuyen
 * arbitrariamente por todo el cubo. Una vez desordenado, el objetivo del puzzle
 * consiste en conseguir recolocar los cuadrados para que todas las caras
 * vuelvan a tener un único color.
 * 
 * Con el tiempo, han surgido algunos usos del cubo más imaginativos. En
 * concreto, convirtiendo cada cuadro en un gran pixel, es posible construir
 * imágenes con muchos cubos (y mucha paciencia). El proceso es el siguiente: se
 * empieza con la imagen que se quiere reproducir y se convierte a una imagen de
 * únicamente 6 colores. Los colores seleccionados deben ser los mismos que
 * aparecen en las caras de los cubos que se utilizarán (normalmente blanco,
 * rojo, azul, naranja, verde y amarillo). Tras esto se debe conseguir, para
 * cada región de 3×3 píxeles, un cubo con una de las caras con exactamente la
 * misma configuración. El último paso es colocar todos los cubos juntos para
 * formar la imagen final de Rubik pixel art.
 * 
 * Cuando descubriste esta nueva modalidad de arte retro te pusiste manos a la
 * obra, y, varias horas después, tenías montado un gran retrato con infinidad
 * de cubos. Por desgracia, no se te ocurrió pegar los cubos entre sí, algo de
 * lo que acabas de arrepentirte porque hace un momento has sufrido un percance
 * y varios de los cubos se han caído.
 * 
 * Quieres volver a colocarlos para poder reconstruir tu obra maestra, pero es
 * difícil averiguar dónde va cada uno. Afortunadamente, conservas el diseño
 * original del retrato. Ahora sólo falta buscar la posición de cada cubo.
 * 
 * Entrada
 * La entrada está compuesta por múltiples casos de prueba. Cada uno consta de
 * una primera línea con dos números, f y c, indicando el número de filas y de
 * columnas de cubos de Rubik de tu figura. Ningún caso de prueba tendrá más de
 * 50 cubos a lo ancho o a lo alto, y todos tendrán al menos uno.
 * 
 * Después, aparece el diseño de la figura, con la configuración de cada cubo en
 * una sucesión de 3×f líneas de texto de 3×c caracteres cada una. Cada carácter
 * indica el color de un cuadro, con los valores 'B', 'R', 'A', 'N', 'V' y 'M'
 * para blanco, rojo, azul, naranja, verde y amarillo respectivamente.
 * 
 * Tras esto, aparecerá un número indicando la cantidad de cubos de Rubik que
 * tienes que colocar. A continuación, aparecerá la configuración de la cara de
 * cada uno de esos cubos que usaste en la figura, con su orientación correcta
 * (no se debe rotar).
 * 
 * 
 * La entrada terminará con una figura sin cubos.
 * 
 * Salida
 * Para cada caso de prueba se escribirá la posición de cada uno de los cubos
 * que hay que colocar. Cada posición se escribirá en su propia línea, indicando
 * el número de fila y el número de columna separados por un espacio. El primer
 * cubo dado en la descripción de la figura del caso de prueba se corresponde
 * con la primera fila y la primera columna.
 * 
 * Si aparece la configuración buscada en varios cubos de la figura original, se
 * indicará la posición del situado más arriba. Si hay dos cubos iguales en la
 * misma fila, se mostrará la posición del situado más a la izquierda.
 * 
 * Si el cubo no aparece en la figura, se escribirá "NO SE USA".
 * 
 * Entrada de ejemplo
 * 3 4
 * BBABBBBBABBB
 * BBBABBBABBBB
 * BBAAAAAAABBB
 * BAABAAABAABB
 * AAAAAAAAAAAB
 * ABAAAAAAABAB
 * ABABBBBBABAB
 * BBBAABAABBBB
 * BBBBBBBBBBBB
 * 2
 * BBB
 * BBB
 * BBB
 * RRR
 * RRR
 * RRR
 * 0 0
 * Salida de ejemplo
 * 1 4
 * NO SE USA
 */