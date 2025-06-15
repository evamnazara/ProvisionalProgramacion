package ud4.aceptaelreto.arrays;

public class BingoInfantil {

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        while (true) {
            // Leer el número de bolas que quedan en el bombo
            int n = scanner.nextInt();

            // Si n es 0, terminamos el programa
            if (n == 0) {
                break;
            }

            // Leer los números de las bolas
            int[] bolas = new int[n];
            for (int i = 0; i < n; i++) {
                bolas[i] = scanner.nextInt();
            }

            // Usamos un conjunto para almacenar las diferencias únicas
            boolean[] posiblesNumeros = new boolean[2001]; // Para almacenar números del 1 al 2000

            // Generamos todas las posibles restas entre los números
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        int resta = Math.abs(bolas[i] - bolas[j]);
                        if (resta > 0) {
                            posiblesNumeros[resta] = true;
                        }
                    }
                }
            }

            // Imprimir los números posibles en orden ascendente
            boolean first = true; // Para controlar el espacio entre números
            for (int i = 1; i <= 2000; i++) {
                if (posiblesNumeros[i]) {
                    if (!first) {
                        System.out.print(" "); // Separador de espacios
                    }
                    System.out.print(i);
                    first = false;
                }
            }

            // Nueva línea después de cada caso de prueba
            System.out.println();
        }

        // Cerrar el scanner
        scanner.close();
    }
}

/*
 * Bingo infantil
 * Tiempo máximo: 2,000 s Memoria máxima: 4096 KiB
 * 'Bingo' con letras de un collage en un corcho de aula.
 * Para que los niños que tiene en clase practiquen las restas que acaba de
 * enseñarles, Mavi ha pensado en una versión especial del juego del Bingo. En
 * la versión tradicional, cada jugador recibe un cartón con una serie de
 * números, y se van extrayendo de un bombo bolas con números impresos hasta que
 * alguien asegura que todos los números de su cartón han salido ya.
 * 
 * En la variante que ha pensado Mavi, en cada jugada extraerá dos números en
 * lugar de solo uno. El valor jugado, que los niños tendrán que tachar de sus
 * cartones, es la resta del mayor menos el menor. Tras cada jugada, los dos
 * números serán incorporados de nuevo al bombo, en contra de lo que ocurre en
 * el juego tradicional.
 * 
 * Aunque la idea es interesante, Mavi se enfrenta a un problema. El bingo que
 * va a utilizar lleva en el armario de la clase muchos años y ha pasado por
 * muchas manos… algunas un poco descuidadas que han hecho que se pierdan bolas.
 * De modo que necesita saber la lista de números que pueden "salir" en su
 * particular bingo, para ponerlos en los cartones y que todos tengan la
 * posibilidad de ganar.
 * 
 * Mavi es consciente de que seguramente algunos números tengan más
 * posibilidades de salir que otros, pero no le importa mucho. De hecho más bien
 * lo considera una virtud, porque así podrá crear cartones con números más
 * probables para los niños que restan con dificultad y que tengan también
 * posibilidades de ganar.
 * 
 * Entrada
 * Cada caso de prueba comienza con un número indicando cuántas bolas quedan aún
 * en el bingo de la clase (al menos 2). A continuación aparece el número de
 * cada una de ellas. Todos los números son valores entre 1 y 2.000 y no hay
 * ninguno repetido.
 * 
 * La entrada termina con un 0 que no debe procesarse.
 * 
 * Salida
 * Para cada caso de prueba, el programa deberá escribir, por la salida estándar
 * los números que pueden formarse, ordenados de menor a mayor y separados por
 * un espacio. No debe haber espacio tras el último número.
 * 
 * Entrada de ejemplo
 * 4
 * 1 3 4 5
 * 3
 * 4 1 8
 * 0
 * Salida de ejemplo
 * 1 2 3 4
 * 3 4 7
 * 
 */