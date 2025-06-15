package ud4.aceptaelreto.matrices;

import java.util.Scanner;

public class ConcursoSimetrias {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Procesar múltiples casos de prueba
        while (scanner.hasNextInt()) {
            // Leer las dimensiones de la imagen (ancho tx y alto ty)
            int tx = scanner.nextInt();
            int ty = scanner.nextInt();
            scanner.nextLine(); // Consumir la línea de salto después de los números

            // Leer la matriz que representa el dibujo
            char[][] figura = new char[ty][tx];
            System.out.println("Introduzca la figura del concurso:");
            for (int i = 0; i < ty; i++) {
                figura[i] = scanner.nextLine().toCharArray();
            }

            // Verificar la simetría
            if (esSimetrico(figura, tx, ty)) {
                System.out.println("CORRECTO");
            } else {
                System.out.println("TRAMPOSO");
            }
        }

        scanner.close(); // Cerrar el scanner después de la lectura
    }

    // Método que verifica si la figura es simétrica tanto vertical como
    // horizontalmente
    public static boolean esSimetrico(char[][] figura, int tx, int ty) {
        // Verificar simetría horizontal
        if (!esSimetricoHorizontal(figura, tx, ty)) {
            return false; // Si no es simétrica horizontalmente, es tramposa
        }

        // Verificar simetría vertical
        if (!esSimetricoVertical(figura, tx, ty)) {
            return false; // Si no es simétrica verticalmente, es tramposa
        }

        return true; // Si pasa ambas verificaciones, es correcta
    }

    // Método que verifica la simetría horizontal
    public static boolean esSimetricoHorizontal(char[][] figura, int tx, int ty) {
        for (int i = 0; i < ty / 2; i++) {
            for (int j = 0; j < tx; j++) {
                if (figura[i][j] != figura[ty - 1 - i][j]) {
                    return false; // Si alguna fila no es simétrica, devuelve falso
                }
            }
        }
        return true; // Si todas las filas son simétricas, devuelve verdadero
    }

    // Método que verifica la simetría vertical
    public static boolean esSimetricoVertical(char[][] figura, int tx, int ty) {
        for (int i = 0; i < ty; i++) {
            for (int j = 0; j < tx / 2; j++) {
                if (figura[i][j] != figura[i][tx - 1 - j]) {
                    return false; // Si alguna columna no es simétrica, devuelve falso
                }
            }
        }
        return true; // Si todas las columnas son simétricas, devuelve verdadero
    }
}

/*
 * Concurso de simetrías
 * Cuando la directora del colegio te pidió que organizaras un concurso de
 * simetrías con papel quisiste cambiar de colegio. Pero tras unas pocas horas,
 * ya tienes lanzada la convocatoria:
 * 
 * “
 * Se convoca un concurso de simetrías con papel, consistente en realizar formas
 * simétricas utilizando únicamente papel y tijeras. El proceso es el siguiente:
 * 
 * Coger una hoja de papel rectangular (o cuadrada), y doblarla a lo largo y a
 * lo ancho para formar un rectángulo de forma que quedarán cuatro láminas de
 * papel unidas por dos de los bordes.
 * Utilizando unas tijeras, hacer los cortes que se consideren oportunos a los
 * cuatro bordes para eliminar pequeños trozos de papel.
 * Desdoblar el papel para descubrir la imagen final construida, que será la
 * presentada al concurso.
 * Se deben cumplir las siguientes normas:
 * 
 * La simetría entregada debe estar formada por una única pieza de papel.
 * Las tijeras solo deben hacer giros de 90 grados o lo que es lo mismo, los
 * cortes serán siempre paralelos a alguno de los bordes.
 * ”
 * Ejemplo de construcción de simetría
 * Resultado de la simetría
 * Ahora ya solo queda esperar a recibir las piezas presentadas al concurso y
 * comprobar que cumplen las condiciones anteriores.
 * 
 * Entrada
 * La entrada estará compuesta por distintos casos de prueba, cada uno formado
 * por varias líneas. Cada caso de prueba se corresponde con una foto de una
 * figura presentada al concurso.
 * 
 * La primera línea de cada caso contiene el tamaño de la foto en píxeles,
 * primero el ancho, tx, y luego el alto, ty. Ninguno de ellos será mayor que
 * 100.
 * 
 * A continuación vendrán ty líneas de tx caracteres en donde una 'X' indica que
 * en esa posición hay papel, y un '.' debe interpretarse como ausencia del
 * mismo.
 * 
 * Salida
 * Para cada caso de prueba se escribirá CORRECTO si la entrega cumple las
 * restricciones del enunciado y TRAMPOSO en caso contrario.
 * 
 * Entrada de ejemplo
 * 16 5
 * XX..X..XX..X..XX
 * .XXXXXXXXXXXXXX.
 * .XX..XXXXXX..XX.
 * .XXXXXXXXXXXXXX.
 * XX..X..XX..X..XX
 * 10 4
 * ..........
 * .XX....XX.
 * .XX....XX.
 * ..........
 * 2 2
 * X.
 * ..
 * Salida de ejemplo
 * CORRECTO
 * TRAMPOSO
 * TRAMPOSO
 */
