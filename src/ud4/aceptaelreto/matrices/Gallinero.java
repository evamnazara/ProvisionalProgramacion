package ud4.aceptaelreto.matrices;

import java.util.Scanner;

public class Gallinero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leer el número de casos de prueba
        int numCasosDePrueba = sc.nextInt();

        // Para cada caso de prueba
        for (int caso = 0; caso < numCasosDePrueba; caso++) {
            // Leer las dimensiones del gallinero (filas y columnas) y el número de pollitos
            int filasGallinero = sc.nextInt();
            int columnasGallinero = sc.nextInt();
            int numPollitos = sc.nextInt();

            // Crear la matriz del gallinero, inicializada con 0 (sin granos)
            int[][] gallinero = new int[filasGallinero][columnasGallinero];

            // Procesar cada pollito
            for (int i = 0; i < numPollitos; i++) {
                // Leer la posición inicial del pollito, su dirección y el número máximo de
                // pasos
                int filaInicio = sc.nextInt() - 1; // Convertimos a índice 0-basado
                int columnaInicio = sc.nextInt() - 1; // Convertimos a índice 0-basado
                char direccionInicio = sc.next().charAt(0); // Dirección: N, S, E, W
                int pasosMaximos = sc.nextInt();

                // Dirección de los movimientos en la espiral: (Norte, Este, Sur, Oeste)
                int[] desplazamientoFila = { -1, 0, 1, 0 }; // Movimiento en filas (N, E, S, O)
                int[] desplazamientoColumna = { 0, 1, 0, -1 }; // Movimiento en columnas (N, E, S, O)

                // Determinar la dirección inicial del pollito (N=0, E=1, S=2, O=3)
                int direccionActual = 0; // 0 = Norte, 1 = Este, 2 = Sur, 3 = Oeste
                if (direccionInicio == 'S')
                    direccionActual = 2;
                if (direccionInicio == 'E')
                    direccionActual = 1;
                if (direccionInicio == 'W')
                    direccionActual = 3;

                // Empezamos el recorrido desde la posición inicial
                int filaActual = filaInicio;
                int columnaActual = columnaInicio;

                // Colocamos el primer grano en la posición inicial
                gallinero[filaActual][columnaActual]++;

                // Realizar el movimiento en espiral
                for (int paso = 0; paso < pasosMaximos; paso++) {
                    // Mover a la siguiente baldosa en la dirección actual
                    filaActual += desplazamientoFila[direccionActual];
                    columnaActual += desplazamientoColumna[direccionActual];

                    // Si el pollito se sale del gallinero, se detiene
                    if (filaActual < 0 || filaActual >= filasGallinero || columnaActual < 0
                            || columnaActual >= columnasGallinero) {
                        break; // Salimos del ciclo si el pollito se sale del gallinero
                    }

                    // Colocar un grano en la nueva posición
                    gallinero[filaActual][columnaActual]++;

                    // Cambiar de dirección en sentido horario (espiral)
                    direccionActual = (direccionActual + 1) % 4;
                }
            }

            // Imprimir el resultado para este caso de prueba
            for (int i = 0; i < filasGallinero; i++) {
                for (int j = 0; j < columnasGallinero; j++) {
                    System.out.print(gallinero[i][j] + " ");
                }
                System.out.println(); // Nueva línea después de cada fila
            }

            // Imprimir la línea separadora
            System.out.println("---");
        }

        // Cerrar el scanner después de la lectura
        sc.close();
    }
}

/*
 * Los pollitos pasan todo el día picoteando el suelo del gallinero para comer
 * los granos que van encontrando. Has estado varios días observando sus
 * movimientos y has descubierto que todos ellos siguen un curioso patrón basado
 * en las baldosas que hay en el suelo. Se despiertan mirando en una dirección
 * (norte, sur, este, oeste) y comienzan a andar en esa dirección siguiendo un
 * movimiento en espiral en el sentido de las agujas del reloj. El paseo termina
 * cuando se cansan (cada pollito tiene un aguante distinto) o en su recorrido
 * se topan con el borde del gallinero, momento en el que quedan aturdidos y se
 * duermen hasta el día siguiente.
 * 
 * Además, en cada baldosa que pisan (incluída la que ocupan al despertarse)
 * miran si hay pienso y si lo hay, comen un grano antes de dar el siguiente
 * paso. Si no hay, simplemente siguen avanzando. Como son pequeños, cuando
 * coinciden en un punto comen al mismo tiempo sin molestarse y a veces incluso
 * duermen en el mismo sitio.
 * 
 * Para conseguir que tus pollitos crezcan lo más rápidamente posible sin gastar
 * de más, has decidido distribuir los granos en el gallinero de forma que en
 * cada paso cada pollito se encuentre un grano y pueda comerlo. Conoces la
 * dirección en que se despiertan los pollitos, y el número de pasos que pueden
 * dar en la espiral antes de cansarse y parar hasta el día siguiente. Ahora
 * debes averiguar los granos que tienes que colocar en cada punto para que, al
 * acabar el día, no quede ninguno y todos los pollitos hayan comido el máximo
 * posible.
 * 
 * Entrada
 * La entrada comienza con una línea con el número de casos de prueba que
 * deberán procesarse. Cada caso comienza con una línea con tres números, f, c y
 * n indicando, respectivamente, el tamaño del gallinero en la dirección
 * norte-sur, el tamaño en la dirección oeste-este y el número de pollitos (1 ≤
 * f, c ≤ 50; 0 ≤ n ≤ 500). Las n líneas siguientes contienen la información de
 * cada pollito. El primer número, v, indica la posición en la dirección
 * norte-sur (1 ≤ v ≤ f), el segundo, h, la posición en la dirección oeste-este
 * (1 ≤ h ≤ c), después se indica la dirección en la que empieza a moverse el
 * pollito (N, S, E, W) y finalmente el número máximo de pasos que aguanta antes
 * de dormirse a descansar (al menos uno).
 * 
 * Salida
 * Para cada caso de prueba se escribirán f líneas. En cada una se escribirán c
 * valores, separados por un espacio en blanco, con el número de granos que hay
 * que poner en cada punto. Tras cada caso de prueba se escribirá una línea con
 * tres guiones (---).
 * 
 * Entrada de ejemplo
 * 2
 * 7 8 3
 * 1 2 E 2
 * 6 3 N 25
 * 4 6 E 21
 * 4 3 2
 * 1 1 N 3
 * 4 2 W 3
 * Salida de ejemplo
 * 
 * 0 1 1 0 0 0 0 0
 * 0 0 1 1 1 0 0 0
 * 0 0 0 1 1 1 1 1
 * 0 1 1 2 2 1 1 1
 * 0 1 1 2 2 1 1 1
 * 0 1 1 2 2 1 1 1
 * 0 1 1 1 1 0 0 0
 * ---
 * 1 0 0
 * 0 0 0
 * 1 1 0
 * 1 1 0
 * ---
 */

/*
 * Explicación del código:
 * Entrada de datos:
 * 
 * Usamos un Scanner para leer la entrada.
 * El primer valor leído es el número de casos de prueba (t).
 * Luego, para cada caso de prueba, leemos las dimensiones del gallinero (f
 * filas, c columnas) y el número de pollitos (n).
 * Matriz de granos:
 * 
 * Creamos una matriz de tamaño f x c inicializada con ceros. Esta matriz
 * representará el gallinero, donde cada celda contendrá el número de granos en
 * esa posición.
 * Simulación de cada pollito:
 * 
 * Para cada pollito, leemos su posición inicial (v, h), su dirección de inicio
 * (N, S, E, W), y el número máximo de pasos que puede dar (pasos).
 * Usamos dos arreglos dx y dy para representar el movimiento en las direcciones
 * Norte, Este, Sur y Oeste, y calculamos cómo debe moverse el pollito en la
 * matriz.
 * Aseguramos que si el pollito se sale del gallinero, se detenga.
 * Colocación de los granos:
 * 
 * Cada vez que el pollito pisa una baldosa, incrementamos el valor de esa
 * posición en la matriz gallinero.
 * Impresión del resultado:
 * 
 * Después de simular todos los pollitos, imprimimos la matriz con los granos
 * colocados en cada celda. Al final de cada caso de prueba, imprimimos --- para
 * separar los resultados.
 */