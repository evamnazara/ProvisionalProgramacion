package ud4.aceptaelreto.matrices;

import java.util.Scanner;

public class SieteDeUnGolpe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inicia un ciclo para leer múltiples casos de prueba
        while (true) {
            // Leer las dimensiones de la mesa y del matamoscas
            System.out.println("Ingresa las dimensiones de la mesa (tx ty) y las dimensiones del matamoscas (mx my):");
            int numeroColumnas = scanner.nextInt(); // número de columnas de la mesa
            int numeroFilas = scanner.nextInt(); // número de filas de la mesa
            int tamanoMatamoscasHorizontal = scanner.nextInt(); // tamaño horizontal del matamoscas
            int tamanoMatamoscasVertical = scanner.nextInt(); // tamaño vertical del matamoscas

            // Si encontramos una línea con 0 0 0 0, terminamos el programa
            if (numeroColumnas == 0 && numeroFilas == 0 && tamanoMatamoscasHorizontal == 0
                    && tamanoMatamoscasVertical == 0) {
                break;
            }

            // Leer la mesa (mapa de moscas)
            System.out.println("Ingresa el mapa de la mesa (con 'X' para moscas y '.' para espacios vacíos):");
            char[][] mesa = new char[numeroFilas][numeroColumnas];
            for (int i = 0; i < numeroFilas; i++) {
                mesa[i] = scanner.next().toCharArray();
            }

            // Inicializar un array para contar cuántas posiciones matan 0, 1, ..., 7 o más
            // moscas
            int[] conteoMoscas = new int[8]; // conteoMoscas[0] -> 0 moscas, conteoMoscas[1] -> 1 mosca, ...,
                                             // conteoMoscas[7] -> 7 o más moscas

            // Recorremos las posibles posiciones donde podemos colocar el matamoscas
            for (int fila = 0; fila <= numeroFilas - tamanoMatamoscasVertical; fila++) { // Filas donde puede entrar el
                                                                                         // matamoscas
                for (int columna = 0; columna <= numeroColumnas - tamanoMatamoscasHorizontal; columna++) { // Columnas
                                                                                                           // donde
                                                                                                           // puede
                                                                                                           // entrar el
                                                                                                           // matamoscas
                    // Contamos cuántas moscas están en el área cubierta por el matamoscas
                    int moscasMuertas = 0;
                    for (int y = 0; y < tamanoMatamoscasVertical; y++) { // Recorremos las filas del matamoscas
                        for (int x = 0; x < tamanoMatamoscasHorizontal; x++) { // Recorremos las columnas del matamoscas
                            if (mesa[fila + y][columna + x] == 'X') {
                                moscasMuertas++;
                            }
                        }
                    }

                    // Clasificamos el número de moscas muertas en la posición correspondiente
                    if (moscasMuertas > 7) {
                        conteoMoscas[7]++; // Si mata más de 7 moscas, lo contamos en la posición de 7 o más
                    } else {
                        conteoMoscas[moscasMuertas]++; // Si mata entre 0 y 7 moscas, lo contamos en la posición
                                                       // correspondiente
                    }
                }
            }

            // Imprimimos los resultados del conteo de moscas muertas para este caso de
            // prueba
            System.out.println("Resultado del conteo de posiciones con moscas muertas:");
            for (int k = 0; k < 8; k++) {
                System.out.print(conteoMoscas[k] + " ");
            }
            System.out.println(); // Para hacer un salto de línea después de la salida

        }

        scanner.close();
    }
}

/*
 * ===========
 * 
 * SIETE DE UN GOLPE
 * 
 * Siete de un golpe
 * Tiempo máximo: 1,000-2,000 s Memoria máxima: 10240 KiB
 * En la adaptación libre que hizo Walt Disney del cuento El sastrecillo
 * valiente de los hermanos Grimm un sastre está siendo molestado por siete
 * moscas. La fortuna hace que consiga eliminar las siete de un solo golpe de
 * matamoscas1.
 * 
 * La dificultad de matar de un solo golpe a siete moscas apoyadas en una mesa
 * depende fundamentalmente de tres cosas: el número de moscas que haya en la
 * mesa, el tamaño del matamoscas y lo rápido que éstas sean para levantar el
 * vuelo.
 * 
 * Podemos imaginarnos la mesa dividida en pequeños cuadrados todos del mismo
 * tamaño y que pueden o no tener una mosca dentro. Y podemos tener un
 * matamoscas de tamaño N×M que cuando se coloca sobre la mesa, liquida a todas
 * las moscas que hay en esos N×M cuadrados.
 * 
 * Para ver cómo de extraordinaria es la hazaña del sastre, queremos averiguar
 * en cuántas posiciones podemos colocar el matamoscas sobre la mesa (orientado
 * siempre en horizontal) para matar distintas moscas de un golpe.
 * 
 * Entrada
 * 
 * La entrada estará compuesta por distintos casos de prueba. Cada uno de ellos
 * comienza con una línea con cuatro números: el número de cuadrados en
 * horizontal (tx) y vertical (ty) en los que está dividida la mesa (como mucho
 * 1.000) y el tamaño del matamoscas, o número de cuadrados que cubre en
 * horizontal (1 ≤ mx ≤ tx) y vertical (1 ≤ my ≤ ty). A continuación vienen ty
 * líneas cada una con tx caracteres que indican si en esa celda hay mosca (X) o
 * no (.).
 * 
 * La entrada termina con un tablero y matamoscas de tamaños 0×0, que no debe
 * procesarse.
 * 
 * Salida
 * 
 * Por cada caso de prueba se escribirá una línea con ocho números enteros; el
 * primero de ellos contiene el número de posiciones en donde el matamoscas no
 * mataría ninguna; el siguiente indica las posiciones en las que moriría una
 * única mosca, después dos moscas, y así sucesivamente hasta terminar con el
 * último número que marca las posiciones en las que el sastre mataría a siete
 * moscas de un golpe.
 * 
 * Ten en cuenta que el matamoscas siempre se coloca con la misma orientación y
 * que debe entrar todo entero en la mesa. Además, podría haber posiciones en
 * las que el número de moscas muertas sea superior a siete.
 * 
 * 
 * 0 4 0 0 0 0 0 0
 * 0 0 0 0 0 1 1 0
 * 0 0 0 0 0 0 1 0
 * 1En el cuento original el número de moscas eran "legiones" y, dice, aniquila
 * por lo menos a veinte utilizando un paño. Vemos, pues, que la película de
 * Walt Disney dista mucho del original.
 * 
 * 
 * =====
 * 
 * Vamos a resolver este problema paso a paso. La idea es simular el proceso de
 * colocar un matamoscas de tamaño sobre una mesa de y contar cuántas moscas
 * “mataría” el matamoscas al colocarse en diferentes posiciones posibles.
 * 
 * Pasos para resolver el problema:
 * 1. Leer la entrada:
 * • La entrada contiene varias líneas con información sobre el tamaño de la
 * mesa, el tamaño del matamoscas, y luego las celdas de la mesa que indican si
 * hay o no una mosca.
 * • Leemos los valores tx, ty (dimensiones de la mesa), y mx, my (dimensiones
 * del matamoscas). Luego, leemos el mapa de la mesa, que consiste en una serie
 * de líneas con caracteres ‘X’ (mosca) y ‘.’ (vacío).
 * 2. Contar las posiciones posibles:
 * • El matamoscas se coloca en distintas posiciones dentro de la mesa. Las
 * posiciones posibles para colocar el matamoscas son todas las celdas en el
 * mapa donde la esquina superior izquierda del matamoscas puede encajar
 * completamente (es decir, las celdas desde (0,0) hasta (tx-mx, ty-my)).
 * • Para cada una de esas posiciones, debemos contar cuántas moscas hay dentro
 * del área cubierta por el matamoscas.
 * 3. Clasificar las posiciones:
 * • Contamos cuántas posiciones matan a exactamente 0, 1, 2,… hasta 7 moscas.
 * • Si en una posición el matamoscas mata más de 7 moscas, contamos cuántas
 * posiciones matan 7 o más moscas.
 * 4. Salida:
 * • Después de procesar todas las posiciones posibles, imprimimos los
 * resultados para cada caso de prueba: el número de posiciones que matan 0, 1,
 * 2,… 7 moscas.
 * 
 * Implementación en Java:
 * 
 * Explicación del código:
 * 1. Lectura de la entrada:
 * • Leemos las dimensiones de la mesa tx (columnas) y ty (filas) y las
 * dimensiones del matamoscas mx (ancho) y my (alto).
 * • Luego leemos la mesa, representada como una matriz de caracteres, donde ‘X’
 * indica que hay una mosca y ‘.’ indica que no hay.
 * 2. Inicialización del array conteo:
 * • Creamos un array conteo de 8 elementos para contar cuántas posiciones matan
 * 0, 1, …, 7 o más moscas. conteo[0] cuenta las posiciones con 0 moscas,
 * conteo[1] cuenta las posiciones con 1 mosca, y así sucesivamente.
 * 3. Recorrido de la mesa para colocar el matamoscas:
 * • Iteramos sobre todas las posibles posiciones donde podemos colocar el
 * matamoscas. Esas posiciones están definidas por las filas de 0 a ty-my y las
 * columnas de 0 a tx-mx, porque el matamoscas no puede sobresalir de la mesa.
 * • Para cada posición, contamos cuántas moscas hay dentro del área que
 * cubriría el matamoscas.
 * 4. Clasificación de los resultados:
 * • Según el número de moscas en el área cubierta por el matamoscas,
 * incrementamos el contador correspondiente en el array conteo. Si el número de
 * moscas es mayor que 7, se cuenta en conteo[7] (para 7 o más moscas).
 * 5. Salida:
 * • Después de procesar todos los casos de prueba, imprimimos el array conteo,
 * que contiene el número de posiciones para cada cantidad de moscas muertas, en
 * orden desde 0 hasta 7 o más.
 * 
 * Ejemplo de ejecución:
 * 
 * Salida:
 * 
 * 0 4 0 0 0 0 0 0
 * 0 0 0 0 0 1 1 0
 * 1 0 0 0 0 0 1 0
 * 
 * Explicación de la salida:
 * • En el primer caso, hay 0 posiciones donde el matamoscas no mata ninguna
 * mosca, 4 posiciones donde mata 1 mosca, y no hay posiciones donde mata 2 o
 * más moscas.
 * • En el segundo caso, el matamoscas mata 1 mosca en 1 posición y 2 moscas en
 * 1 posición.
 * • En el tercer caso, hay 1 posición donde el matamoscas mata 1 mosca y 1
 * posición donde mata 3 moscas.
 * 
 * Conclusión:
 * 
 * El algoritmo recorre la mesa, coloca el matamoscas en cada posición válida,
 * cuenta las moscas dentro del área del matamoscas y clasifica las posiciones
 * según la cantidad de moscas muertas. Es eficiente para los límites del
 * problema y cumple con los requisitos de tiempo y memoria.
 */