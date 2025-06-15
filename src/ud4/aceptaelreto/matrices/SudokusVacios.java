/* No tiene más de 32 celdas llenas.
Es simétrico rotacionalmente (tras girarlo 180 grados, las celdas ocupadas deben coincidir).
*/
package ud4.aceptaelreto.matrices;

import java.util.Scanner;

public class SudokusVacios {

    public static void main(String[] args) {
        // Leer la cantidad de casos de prueba
        Scanner sc = new Scanner(System.in);
        String linea = sc.nextLine().trim(); // Leer el primer número (cantidad de casos)
        int casosDePrueba = linea.charAt(0) - '0'; // Convertir el primer carácter a número
        sc.nextLine(); // Leer la línea en blanco inicial

        // Procesar cada caso de prueba
        for (int caso = 0; caso < casosDePrueba; caso++) {
            if (caso > 0)
                sc.nextLine(); // Leer línea en blanco entre casos

            // Crear una matriz para representar el Sudoku
            char[][] sudoku = new char[9][9];
            int celdasLlenas = 0; // Contador de celdas llenas

            // Leer el tablero del Sudoku
            System.out.println("Procesando el caso de prueba #" + (caso + 1));
            for (int i = 0; i < 9; i++) {
                String fila = sc.nextLine();
                for (int j = 0; j < 9; j++) {
                    sudoku[i][j] = fila.charAt(j); // Rellenar la matriz
                    if (sudoku[i][j] != '-') {
                        celdasLlenas++; // Contar las celdas llenas
                    }
                }
            }

            // Verificar si el Sudoku tiene simetría rotacional
            boolean cumpleSimetria = true;
            for (int i = 0; i < 9 && cumpleSimetria; i++) {
                for (int j = 0; j < 9; j++) {
                    // Compara la casilla con su posición simétrica
                    if ((sudoku[i][j] != '-') != (sudoku[8 - i][8 - j] != '-')) {
                        cumpleSimetria = false;
                        break;
                    }
                }
            }

            // Evaluar las condiciones y mostrar el resultado
            if (celdasLlenas <= 32 && cumpleSimetria) {
                System.out.println("SI"); // El Sudoku cumple con las condiciones
            } else {
                System.out.println("NO"); // El Sudoku no cumple con las condiciones
            }
        }

        sc.close();
    }
}

/*
 * Sudokus vacíos
 * Un sudoku es un tipo de pasatiempo numérico que se popularizó en Japón en
 * 1986 e internacionalmente en 2005, aunque sus raíces alcanzan hasta el propio
 * Leonhard Euler, en el siglo XVIII. Consiste en una tabla de 9 × 9 celdas, en
 * la que se distinguen 9 "regiones" de 3 × 3.
 * 
 * En cada una de las celdas se debe escribir un dígito entre 1 y 9.
 * Inicialmente se proporcionan algunas de las celdas ya rellenas, y se deja al
 * jugador la responsabilidad de completar las demás, sabiendo que cada fila,
 * cada columna y cada región de 3 × 3 debe contener todos los dígitos del 1 al
 * 9 una única vez.
 * 
 * Ejemplo de sudoku
 * Los creadores de sudokus se encargan de que, dada la distribución de partida,
 * sólo exista un modo de completar el resto de celdas. Además, Nikoli, la
 * compañía japonesa que bautizó y popularizó el pasatiempo, impuso una
 * restricción extra: para ser considerado un buen sudoku, éste no debe
 * proporcionar más de 32 celdas rellenas, y debe tener simetría rotacional.
 * Esto significa que si la distribución inicial del sudoku se rota 180 grados,
 * las celdas ocupadas son las mismas, aunque no necesariamente con los mismos
 * dígitos. Por ejemplo, tras rotarlo 180 grados, el sudoku anterior queda:
 * 
 * Ejemplo de sudoku rotado
 * Si se superponen las dos figuras, se observa que, aunque con números
 * diferentes, las celdas que están rellenas son las mismas. Los buenos
 * aficionados a resolver sudokus aprovechan esto en su beneficio. Cada vez que
 * completan una celda, se plantean si es posible rellenar la celda simétrica,
 * algo que, aseguran, ocurre con bastante frecuencia.
 * 
 * Entrada
 * La entrada comienza con un primer número indicando el número de casos de
 * prueba que vienen a continuación. Cada caso de prueba consiste en la
 * distribución inicial de un sudoku.
 * 
 * Cada sudoku se proporciona con 9 líneas. Cada una está compuesta a su vez de
 * 9 caracteres contiguos, cada uno representando el valor de una de las celdas
 * de esa fila. El símbolo - se utiliza para indicar una celda vacía.
 * 
 * Dos casos de prueba consecutivos se separan por una línea en blanco. También
 * hay una línea en blanco antes del primer sudoku.
 * 
 * Salida
 * Para cada caso de prueba se escribirá SI si el sudoku es válido, es decir si
 * no supera los 32 dígitos rellenos y tiene simetría rotacional. En otro caso,
 * se escribirá NO.
 * 
 * Ten en cuenta que no hay que preocuparse de si, con la configuración de
 * partida, el sudoku es o no resoluble, por lo que los números leídos son
 * indiferentes y el programa debe únicamente preocuparse de qué casillas están
 * llenas y cuáles no.
 * 
 * Entrada de ejemplo
 * 2
 * 
 * ---5-92-7
 * 67-3----4
 * -----2---
 * -492---85
 * ---------
 * 23---416-
 * ---1-----
 * 5----8-91
 * 8-49-7---
 * 
 * ---5-92-7
 * 67-3----4
 * -----2---
 * -492---85
 * ---------
 * 23---416-
 * ---------
 * 5----8-91
 * 8-49-7---
 * Salida de ejemplo
 * 
 * SI
 * NO
 */