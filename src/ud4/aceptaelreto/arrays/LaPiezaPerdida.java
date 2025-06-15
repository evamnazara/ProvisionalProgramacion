package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class LaPiezaPerdida {
    public static void main(String[] args) {
        // Crear el scanner para leer la entrada
        Scanner sc = new Scanner(System.in);

        // Iniciar el ciclo para procesar múltiples casos de prueba
        while (true) {
            // Leer el número total de piezas del puzzle
            System.out.print("Introduce el número total de piezas del puzzle (0 para terminar): ");
            int numPiezas = sc.nextInt();

            // Si el número de piezas es 0, terminamos el programa
            if (numPiezas == 0) {
                break; // Caso de salida
            }

            // Array para saber qué piezas están en la bolsa
            boolean[] presente = new boolean[numPiezas + 1]; // Usamos índices de 1 a N, por eso numPiezas + 1

            // Leer los números de las piezas presentes en la bolsa
            System.out.println("Introduce los números de las piezas presentes en la bolsa: ");
            for (int i = 1; i < numPiezas; i++) {
                int pieza = sc.nextInt();
                presente[pieza] = true; // Marcar la pieza como presente
            }

            // Buscar la pieza faltante
            int piezaFaltante = 0;
            for (int i = 1; i <= numPiezas; i++) {
                if (!presente[i]) { // Si la pieza no está en la bolsa, es la que falta
                    piezaFaltante = i;
                    break;
                }
            }

            // Imprimir la pieza que falta
            System.out.println("La pieza que falta es: " + piezaFaltante);
        }

        // Cerrar el scanner al final
        sc.close();
    }
}

/*
 * La pieza perdida
 * Tiempo máximo: 1,000-5,000 s Memoria máxima: 4096 KiB
 * Puzzle con una ficha sin poner
 * Andrés no da crédito. Se ha encontrado en la calle una bolsa llena de piezas
 * de un puzzle. Lo peculiar del caso es que las piezas están numeradas por
 * detrás, lo que implica que su anterior propietario tuvo el puzzle montado y
 * lo desmontó etiquetando pacientemente cada ficha para hacer mucho más fácil
 * el siguiente montaje. Tras un rato se da cuenta de por qué, tras todo ese
 * esfuerzo, decidió deshacerse del puzzle: en la misma bolsa había una nota que
 * decía "Falta una pieza".
 * 
 * Lo que Andrés se pregunta ahora es ¿qué pieza es la que falta?
 * 
 * Entrada
 * La entrada estará compuesta de numerosos casos de prueba. Cada uno de ellos
 * contiene la información de un puzzle en dos líneas. La primera línea contiene
 * el número de piezas totales del puzzle (al menos dos y como mucho 10.000), y
 * la segunda contiene los números de todas las piezas que había en la bolsa (no
 * necesariamente en orden). La numeración de las piezas comienza por el número
 * 1.
 * 
 * La entrada terminará con un puzzle de cero piezas, que no generará salida.
 * 
 * Salida
 * Para cada caso de prueba se debe escribir una línea con el número de la pieza
 * que faltaba en la bolsa.
 * 
 * Entrada de ejemplo
 * 
 * 10
 * 1 2 3 5 6 7 8 9 10
 * 8
 * 6 4 3 2 1 8 7
 * 0
 * Salida de ejemplo
 * 4
 * 5
 */