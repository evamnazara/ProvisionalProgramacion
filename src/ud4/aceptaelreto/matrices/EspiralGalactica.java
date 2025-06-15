package ud4.aceptaelreto.matrices;

import java.util.Scanner;

public class EspiralGalactica {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Leer el tamaño N de la porción del universo (número de filas y columnas de la
            // matriz)
            System.out.print("Ingrese el tamaño de la matriz (N) de la porción del universo: ");
            int tamañoUniverso = scanner.nextInt();

            // Si N es 0, terminamos el programa
            if (tamañoUniverso == 0) {
                break;
            }

            // Leer la matriz de estrellas
            int[][] universo = new int[tamañoUniverso][tamañoUniverso];
            System.out.println("Ingrese los valores de la matriz de estrellas:");
            for (int i = 0; i < tamañoUniverso; i++) {
                for (int j = 0; j < tamañoUniverso; j++) {
                    universo[i][j] = scanner.nextInt();
                }
            }

            // Empezar la simulación de la espiral
            int totalEstrellas = 0;
            int x = tamañoUniverso / 2; // Centro de la matriz (coordenadas iniciales)
            int y = tamañoUniverso / 2;
            totalEstrellas += universo[x][y]; // Sumamos las estrellas del centro

            // Direcciones de movimiento en la espiral: arriba, derecha, abajo, izquierda
            int[] deltaX = { -1, 0, 1, 0 }; // Movimientos en el eje X: arriba, derecha, abajo, izquierda
            int[] deltaY = { 0, 1, 0, -1 }; // Movimientos en el eje Y: arriba, derecha, abajo, izquierda
            int direccion = 0; // Empezamos con la dirección "arriba"
            int pasosPorDireccion = 1; // El número de pasos a dar en una dirección
            int pasosDados = 0; // Contador de pasos dados en una dirección
            int ciclosCompletados = 0; // Número de ciclos completos de 4 direcciones

            // Recorremos la espiral
            while (ciclosCompletados < tamañoUniverso - 1) {
                // Recorremos cada dirección en el ciclo
                for (int i = 0; i < pasosPorDireccion; i++) {
                    // Actualizamos la posición del movimiento
                    x += deltaX[direccion];
                    y += deltaY[direccion];

                    // Sumamos las estrellas de la nueva casilla
                    totalEstrellas += universo[x][y];
                }

                // Cambiar de dirección en sentido horario (arriba, derecha, abajo, izquierda)
                direccion = (direccion + 1) % 4;

                // Aumentamos el contador de pasos dados en la dirección actual
                pasosDados++;

                // Cuando hemos dado suficientes pasos en 2 direcciones, aumentamos el número de
                // pasos
                if (pasosDados == 2) {
                    pasosPorDireccion++;
                    pasosDados = 0;
                    ciclosCompletados++;
                }
            }

            // Imprimir el total de estrellas de la espiral
            System.out.println("Total de estrellas en la espiral: " + totalEstrellas);
        }

        // Cerrar el scanner
        scanner.close();
    }
}

/*
 * 
 * =======
 * ESPIRAL GALACTICA
 * 
 * Espiral galáctica
 * Tiempo máximo: 1,000-2,000 s Memoria máxima: 4096 KiB
 * Nuestra galaxia, la Vía Láctea, tiene forma de espiral. Se estima que hay
 * entre cien mil y cuatrocientos mil millones de estrellas en ella.
 * 
 * No te asustes, que no te vamos a mandar contarlas todas una a una. Resulta
 * que hemos inventado un artilugio que, al enfocarlo al cielo, nos divide la
 * porción de firmamento que vemos en casillas y nos cuenta las estrellas que
 * hay en cada una de ellas. El artilugio se puede regular y podemos elegir el
 * tamaño de la zona de cielo a examinar. Eso sí, esa zona siempre ha de ser
 * cuadrada y con el lado de longitud impar.
 * 
 * Solo nos falta programarlo para que sea capaz de contar las estrellas que
 * pertenecen a nuestra galaxia, es decir, las que están en la espiral. La
 * espiral siempre comienza en la casilla central y sus brazos van avanzando y
 * creciendo en la dirección de las agujas del reloj (arriba, derecha, abajo,
 * izquierda).
 * 
 * Por ejemplo, supongamos que estamos viendo una porción de firmamento con lado
 * de tamaño 5. Esta porción está dividida en 25 casillas y tenemos anotadas la
 * cantidad de estrellas que hay en cada una de ellas. En la siguiente figura, a
 * la izquierda, las casillas correspondientes a la espiral aparecen resaltadas
 * en amarillo, y en total suman 41 estrellas.
 * 
 * Galaxia de lado 5
 * En la figura a la derecha aparece una porción con lado de tamaño 7, dividida
 * en 49 casillas. En este caso las estrellas de la espiral son 54.
 * 
 * Entrada
 * 
 * Cada caso de prueba son varias líneas.
 * 
 * La primera es un número N impar y menor que 100, que indica el tamaño del
 * lado de la porción del universo que estamos viendo. Recuerda que esta porción
 * siempre es un cuadrado. A continuación, aparecen N líneas, cada una con N
 * números entre 0 y 100.000 y separados por espacios, indicando el número de
 * estrellas que se ven en cada casilla.
 * 
 * El último caso de prueba tiene N igual a 0 y no se debe procesar.
 * 
 * Salida
 * 
 * Para cada caso de prueba el programa escribirá el número de estrellas que
 * pueden verse en la espiral galáctica.
 * 
 * Entrada de ejemplo
 * 
 * 3
 * 3 3 4
 * 2 2 7
 * 1 3 5
 * 5
 * 2 4 4 4 4
 * 2 3 3 4 5
 * 5 2 2 7 1
 * 2 1 3 5 3
 * 2 4 3 1 2
 * 7
 * 2 1 2 2 3 2 3
 * 4 2 4 4 4 4 4
 * 3 2 3 3 4 5 3
 * 4 5 2 2 7 1 2
 * 5 2 1 3 5 3 6
 * 4 2 4 3 1 2 0
 * 3 9 9 9 9 2 9
 * 0
 * 
 * ======
 * 
 * Este problema requiere que simulemos un movimiento en espiral dentro de una
 * cuadrícula de tamaño , sumando las estrellas en cada casilla que cae dentro
 * de la trayectoria de la espiral. El movimiento de la espiral siempre empieza
 * desde el centro de la cuadrícula y sigue un patrón específico: arriba,
 * derecha, abajo, izquierda. Este patrón de dirección se repite a medida que
 * avanzamos en la espiral.
 * 
 * Pasos para resolver el problema:
 * 1. Leer los datos de entrada:
 * • El primer número nos da el tamaño , que siempre es impar.
 * • Luego, leemos la matriz que contiene el número de estrellas en cada
 * casilla.
 * • Continuamos procesando casos hasta que encontramos un .
 * 2. Simular el movimiento en espiral:
 * • Empezamos desde el centro de la cuadrícula.
 * • Movemos primero hacia arriba, luego hacia la derecha, luego hacia abajo, y
 * luego hacia la izquierda. Este patrón se repite.
 * • Cada vez que nos movemos a una nueva casilla de la espiral, sumamos las
 * estrellas de esa casilla.
 * 3. Contar las estrellas en la espiral:
 * • Sumamos las estrellas de las casillas que pertenecen a la espiral.
 * • Una vez que terminamos de recorrer todas las direcciones en espiral,
 * obtenemos el total de las estrellas de la espiral.
 * 
 * Estrategia paso a paso:
 * 1. Obtener la posición inicial:
 * • La espiral comienza en el centro de la cuadrícula, que tiene las
 * coordenadas .
 * 2. Definir las direcciones del movimiento:
 * • Usamos un ciclo de direcciones: arriba, derecha, abajo, izquierda. Este
 * ciclo se repite continuamente mientras avanzamos en la espiral.
 * 3. Simular el movimiento en espiral:
 * • Empezamos desde el centro y vamos moviéndonos a lo largo de las
 * direcciones, sumando las estrellas en cada casilla de la espiral.
 * • La longitud de cada “brazo” de la espiral aumenta a medida que completamos
 * un ciclo de las cuatro direcciones.
 * 4. Controlar los límites:
 * • Asegúrate de no salirte de los límites de la matriz.
 * 
 * Implementación en Java:
 * 
 * 
 * Explicación del código:
 * 1. Leer los datos:
 * • Usamos un Scanner para leer la entrada. Leemos el tamaño de la cuadrícula y
 * luego los valores de las estrellas en cada casilla.
 * 2. Inicialización de la espiral:
 * • Comenzamos desde el centro de la matriz, es decir, . Sumamos las estrellas
 * de esa casilla.
 * 3. Definir las direcciones:
 * • Usamos dos arreglos dx y dy para definir los movimientos en las
 * direcciones: arriba, derecha, abajo, izquierda. Los índices de estos arreglos
 * nos indican cómo cambiar las coordenadas y al movernos en una de esas
 * direcciones.
 * 4. Simulación del movimiento en espiral:
 * • Recorremos la espiral moviéndonos por las direcciones y sumando las
 * estrellas de las casillas que cubre el matamoscas.
 * • Aumentamos la longitud del brazo de la espiral después de cada ciclo de 4
 * direcciones (arriba, derecha, abajo, izquierda).
 * 5. Salida:
 * • Después de calcular el total de estrellas en la espiral, lo imprimimos para
 * cada caso de prueba.
 * 
 * Entrada de ejemplo:
 * 
 * 3
 * 3 3 4
 * 2 2 7
 * 1 3 5
 * 5
 * 2 4 4 4 4
 * 2 3 3 4 5
 * 5 2 2 7 1
 * 2 1 3 5 3
 * 2 4 3 1 2
 * 7
 * 2 1 2 2 3 2 3
 * 4 2 4 4 4 4 4
 * 3 2 3 3 4 5 3
 * 4 5 2 2 7 1 2
 * 5 2 1 3 5 3 6
 * 4 2 4 3 1 2 0
 * 3 9 9 9 9 2 9
 * 0
 * 
 * Salida esperada:
 * 
 * 41
 * 54
 * 
 * Explicación de la salida:
 * • En el primer caso, el número total de estrellas que caen dentro de la
 * espiral es 41.
 * • En el segundo caso, el número total de estrellas que caen dentro de la
 * espiral es 54.
 * 
 * Este algoritmo es eficiente para los límites dados (N hasta 99), ya que
 * recorre la espiral de manera sistemática, y no necesita hacer cálculos
 * complejos para cada casilla más allá de simplemente recorrer la espiral y
 * contar las estrellas en las posiciones correspondientes.
 * 
 * 
 */