package ud4.aceptaelreto.arrays;

public class BuscandoElNivel {

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        while (true) {
            // Leemos el número de niveles
            int n = scanner.nextInt();

            // Si el número de niveles es 0, terminamos el programa
            if (n == 0) {
                break;
            }

            // Leemos los tamaños de los niveles en la cinta
            int[] niveles = new int[n];
            for (int i = 0; i < n; i++) {
                niveles[i] = scanner.nextInt();
            }

            // Leemos el número de consultas
            int q = scanner.nextInt();

            // Procesamos cada consulta
            for (int i = 0; i < q; i++) {
                int a = scanner.nextInt(); // Último nivel cargado
                int b = scanner.nextInt(); // Siguiente nivel a cargar

                // Calculamos el desplazamiento, recordando que los niveles están indexados
                // desde 1
                int desplazamiento = sum(niveles, a, b);

                // Mostramos el resultado para esta consulta
                System.out.println(desplazamiento);
            }

            // Imprimimos los tres guiones al final de cada caso
            System.out.println("---");
        }

        // Cerramos el scanner
        scanner.close();
    }

    // Función para calcular el desplazamiento entre los niveles
    public static int sum(int[] niveles, int a, int b) {
        // El nivel `a` y el nivel `b` están indexados desde 1, pero los arreglos en
        // Java son desde 0
        int desplazamiento = 0;

        // Sumamos los tamaños de los niveles entre `a` y `b`
        if (a < b) {
            // Avanzamos hacia adelante
            for (int i = a; i < b; i++) {
                desplazamiento += niveles[i];
            }
        } else {
            // Retrocedemos hacia atrás
            for (int i = a - 2; i >= b - 1; i--) {
                desplazamiento -= niveles[i];
            }
        }

        return desplazamiento;
    }
}

/*
 * Buscando el nivel
 * Tiempo máximo: 1,000-2,000 s Memoria máxima: 4096 KiB
 * Lector de cassettes con el inicio del outrun en la posición de la cinta
 * Los ordenadores domésticos de los 80 guardaban los datos en cintas de
 * cassette, que son un soporte secuencial. El ordenador no podía elegir qué
 * datos leer, sino que el usuario pulsaba el botón Play, la cinta comenzaba a
 * girar, y si los datos que pasaban por debajo del lector eran los esperados,
 * el ordenador los leía y, si no, los descartaba y seguía esperando a que
 * llegaran los correctos. Como la búsqueda de los datos era manual, los
 * lectores solían disponer de un contador, que avanzaba con la cinta. Al
 * rebobinarla, el usuario podía usar el contador para saber dónde parar,
 * siempre que hubiera anotado con antelación las posiciones de cada cosa.
 * 
 * Normalmente los programas tenían todos los datos seguidos en la cinta y no
 * había que hacer nada especial. Pero algunos juegos necesitaban más
 * información de la que entraba en memoria y, al superar un nivel, había que
 * pulsar Play y esperar a que se cargara el siguiente. Al acabar la partida
 * había que rebobinar la cinta hasta la posición donde estaba guardado el nivel
 * 1 para que el programa lo leyera y se pudiera jugar otra vez. En juegos como
 * "Out Run", donde al acabar un nivel se podía ir a dos distintos, era
 * necesario buscar también al avanzar y no solo al acabar la partida.
 * 
 * Entrada
 * Cada caso de prueba comienza con un número 1 ≤ n ≤ 100 indicando la cantidad
 * de niveles que tiene un determinado juego. A continuación aparecen n números
 * indicando lo que ocupa en la cinta la información de cada uno de esos
 * niveles. Los niveles aparecen guardados uno detrás de otro en orden.
 * 
 * El caso de prueba continúa con un número 1 ≤ q ≤ 10.000 indicando cuántas
 * subconsultas se harán sobre los datos anteriores. Cada una está compuesta por
 * dos números 1 ≤ a,b ≤ n, indicando el último nivel que se ha cargado (la
 * cinta está colocada al final de sus datos) y el siguiente que se tiene que
 * cargar.
 * 
 * La entrada termina con un caso de un juego sin niveles, que no deberá
 * procesarse.
 * 
 * Salida
 * Por cada subconsulta, el programa escribirá el desplazamiento que hay que
 * realizar sobre la cinta para colocarla al principio de los datos del nuevo
 * nivel a cargar (un número positivo significará avanzar y uno negativo
 * retroceder). Después de cada caso de prueba se escribirán tres guiones (---).
 * 
 * Entrada de ejemplo
 * 5 10 20 40 7 3
 * 3
 * 1 2
 * 2 5
 * 4 1
 * 0
 * Salida de ejemplo
 * 
 * 0
 * 47
 * -77
 * ---
 * 
 */