package ud4.aceptaelreto.arrays;

public class TomasIneditas {

    public static void main(String[] args) {
        // Usamos el scanner para leer la entrada
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Solicitar al usuario que ingrese la cadena con los movimientos
        System.out.println("Ingrese la cadena de movimientos ('I' = igual, 'S' = subir, 'B' = bajar):");
        String movimientos = scanner.nextLine(); // Leer la cadena de movimientos

        // Crear un array de caracteres para representar la gráfica
        char[] grafica = new char[movimientos.length()];

        // Variables para mantener el estado de la altura actual
        int altura = 0; // La altura inicial es 0

        // Procesamos la cadena de movimientos
        for (int i = 0; i < movimientos.length(); i++) {
            char movimiento = movimientos.charAt(i);
            if (movimiento == 'S') {
                altura++; // Subir, aumentar la altura
                grafica[i] = '/'; // Representar con '/'
            } else if (movimiento == 'B') {
                altura--; // Bajar, disminuir la altura
                grafica[i] = '\\'; // Representar con '\'
            } else if (movimiento == 'I') {
                grafica[i] = '_'; // Mantener, representado por '_'
            }
        }

        // Encontramos la altura máxima y mínima para construir el marco de la gráfica
        int alturaMaxima = 0;
        int alturaMinima = 0;
        for (int i = 0; i < movimientos.length(); i++) {
            char movimiento = movimientos.charAt(i);
            if (movimiento == 'S') {
                alturaMaxima = Math.max(alturaMaxima, ++altura);
            } else if (movimiento == 'B') {
                alturaMinima = Math.min(alturaMinima, --altura);
            }
        }

        // La altura total de la gráfica será desde la altura mínima hasta la máxima
        int alturaTotal = alturaMaxima - alturaMinima + 1;

        // Crear la gráfica con el marco en '#'
        char[][] pantalla = new char[alturaTotal + 2][movimientos.length() + 2];

        // Inicializar el marco exterior
        for (int i = 0; i < pantalla.length; i++) {
            for (int j = 0; j < pantalla[i].length; j++) {
                if (i == 0 || i == pantalla.length - 1 || j == 0 || j == pantalla[i].length - 1) {
                    pantalla[i][j] = '#'; // Colocar el marco
                } else {
                    pantalla[i][j] = ' '; // El interior comienza vacío
                }
            }
        }

        // Colocar los movimientos de la gráfica dentro del marco
        int offset = -alturaMinima; // Ajuste para que la gráfica comience en la altura correcta
        for (int i = 0; i < movimientos.length(); i++) {
            // Colocar el símbolo correspondiente en la pantalla en la fila correspondiente
            int fila = alturaMaxima - (offset + 1); // Ajuste para la fila correcta
            if (grafica[i] == '/') {
                pantalla[fila][i + 1] = '/';
            } else if (grafica[i] == '\\') {
                pantalla[fila][i + 1] = '\\';
            } else if (grafica[i] == '_') {
                pantalla[fila][i + 1] = '_';
            }
        }

        // Imprimir la pantalla con el marco
        for (int i = 0; i < pantalla.length; i++) {
            for (int j = 0; j < pantalla[i].length; j++) {
                System.out.print(pantalla[i][j]);
            }
            System.out.println(); // Nueva línea después de cada fila
        }

        // Cerrar el scanner después de usarlo
        scanner.close();
    }
}

/*
 * 
 * Tomas inéditas
 * Tiempo máximo: 1,000 s Memoria máxima: 4096 KiB
 * Panel de ayuda a la navegación en La Guerra de las Galaxias. Fotograma de la
 * película original.
 * Se está preparando una nueva versión, totalmente remasterizada, de
 * "Star Wars: Episodio IV", con nuevas tomas inéditas. Como todo el material de
 * la película original ha sido ya publicado y republicado, la única forma de
 * saciar la sed de los fans es crear contenido nuevo, manteniendo el estilo
 * original. Para la nueva reedición, se ha decidido añadir alguna toma
 * adicional del interior de las naves durante la gran batalla final.
 * 
 * En particular, se va a enseñar el monitor del panel de apoyo a la navegación
 * que mostraba gráficas temporales sobre alguna característica de la nave como
 * la altura o velocidad. Como el estilo visual de los paneles de control de la
 * película era, por ser finos, "vintage", se quieren generar esas gráficas
 * usando sólo caracteres alfanuméricos para imitar el aspecto. Se usarán
 * únicamente los caracteres "/", "\" y "_" (guión bajo) en función de si la
 * gráfica sube, baja o se mantiene constante en un determinado punto.
 * 
 * Como amante de la "saga galáctica" has decidido crear (¡y donar!) el software
 * para que las nuevas tomas vean la luz. Te darán los movimientos de la gráfica
 * en cada paso, y la pintarás con los caracteres anteriores, enmarcándola,
 * además, entre "#" para simular el monitor CRT.
 * 
 * Entrada
 * Cada caso de prueba es una cadena de entre 1 y 100 letras, indicando la
 * evolución de la gráfica. Una "I" indica que la gráfica se mantiene igual que
 * en el paso previo ("_"), una "S" indica que sube una línea hacia arriba ("/")
 * y una "B" indica que baja una posición
 * "\". Se debe considerar que la "altura" inicial en la gráfica es 0 y a partir
 * de ahí se mueve en función de lo indicado. Se garantiza que el valor nunca
 * descenderá de ese mismo 0 y que no habrá letras distintas a las descritas.
 * 
 * Salida
 * Por cada caso de prueba se dibujará el panel de ayuda utilizando los
 * caracteres alfanumericos descritos. La gráfica se enmarcará en un cuadro
 * formado por el carácter "#". El interior del marco tendrá tantas columnas
 * como letras la entrada, y las filas necesarias para incluir exactamente la
 * gráfica.
 * 
 * Entrada de ejemplo
 * IISSBSIIIII
 * SIISBIB
 * Salida de ejemplo
 * #############
 * # _____#
 * # /\/ #
 * #__/ #
 * #############
 * #########
 * # __/\_ #
 * #/ \#
 * #########
 * 
 */
