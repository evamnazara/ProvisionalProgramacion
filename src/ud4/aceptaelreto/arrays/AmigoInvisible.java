package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class AmigoInvisible {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Leer el número de participantes y el número de asignaciones conocidas
            System.out.println("Numero de participantes:");
            int participantes = scanner.nextInt();
            System.out.println("Numero asignaciones:");
            int asignaciones = scanner.nextInt();

            // Si el número de participantes es 0, terminamos la ejecución
            if (participantes == 0)
                break;

            // Matriz de asignaciones (-1 indica que no se conoce aún)
            int[] regalos = new int[participantes + 1];
            for (int i = 1; i <= participantes; i++) {
                regalos[i] = -1;
            }

            // Leer las asignaciones conocidas
            for (int i = 0; i < asignaciones; i++) {
                int quienRegala = scanner.nextInt();
                int aQuienRegala = scanner.nextInt();
                regalos[quienRegala] = aQuienRegala;
            }

            // Verificar si es posible conocer todas las asignaciones
            boolean[] recibido = new boolean[participantes + 1];
            boolean posibleDeterminar = true;

            for (int i = 1; i <= participantes; i++) {
                if (regalos[i] != -1) {
                    if (recibido[regalos[i]]) {
                        posibleDeterminar = false;
                        break;
                    }
                    recibido[regalos[i]] = true;
                }
            }

            // Imprimir el resultado
            if (posibleDeterminar) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        }

        scanner.close();
    }
}

/*
 * Amigo invisible
 * Tiempo máximo: 1,000-2,000 s Memoria máxima: 4096 KiB
 * Paquete de regalo
 * El amigo invisible es un modo muy popular de que un grupo de personas se haga
 * regalos entre sí en fechas señaladas, como por ejemplo en Navidad. El
 * organizador escribe los nombres de cada participante en una papeleta y los
 * introduce en una bolsa. Uno a uno, todos van sacando uno de los papelillos,
 * que contendrá el nombre de la persona a la que deberán hacer el regalo. Si
 * una persona extrae su propio nombre, el proceso tendrá que repetirse desde el
 * principio: ser el amigo invisible de uno mismo hace que el juego pierda todo
 * el interés.
 * 
 * Los padres del pequeño Samuel le han propuesto organizar un amigo invisible
 * familiar, y le ha tocado regalar a su madre. Lleva varios días un poco
 * desconcertado, porque, aunque no es capaz de explicar por qué, tiene la
 * sospecha de que a su madre le ha tocado su padre, y a su padre le ha tocado
 * regalarle a él. Esto del amigo invisible no parece tener ninguna gracia
 * cuando juegan tres.
 * 
 * Le ha contado su preocupación a su prima Alana, que ha jugado también al
 * amigo invisible en casa, con sus padres y su hermana Irene. A ella le tocó su
 * madre… que le pidió ayuda para elegir algún juguete que pudiera gustarle a
 * Irene, que le había tocado a ella. Alana tampoco supo explicar cómo, pero
 * también supo quién era el amigo invisible de todos en su familia.
 * 
 * Está claro que esto del amigo invisible no tiene ninguna gracia. ¿Por qué lo
 * llaman invisible si se puede sacar la asignación tan fácilmente?
 * 
 * Entrada
 * El programa deberá leer, de la entrada estándar, múltiples casos de prueba,
 * cada uno relativo a la realización de un amigo invisible entre un grupo de
 * personas.
 * 
 * La primera línea del caso de prueba contiene dos números. El primero 2 ≤ p ≤
 * 50 indica el número de participantes en el amigo invisible. El segundo 1 ≤ a
 * ≤ 50 indica el número de asignaciones conocidas por uno de los participantes,
 * por su propia papeleta y por suposiciones o confesiones directas de los
 * demás.
 * 
 * A continuación vendrán a líneas, cada una indicando una de las asignaciones
 * conocidas. Cada asignación se proporciona con dos números, el primero
 * indicando la persona que regala, y el segundo a quién lo hace. Los
 * participantes se numeran de 1 a p.
 * 
 * La entrada termina con un caso de prueba sin participantes, que no deberá
 * procesarse.
 * 
 * Salida
 * Para cada caso de prueba, el programa deberá escribir "SI" si es posible
 * conocer, sin posibilidad de error, la asignación de todos los participantes
 * en el amigo invisible, y "NO" en otro caso.
 * 
 * Entrada de ejemplo
 * 3 1
 * 1 2
 * 4 2
 * 1 2
 * 2 3
 * 4 2
 * 1 2
 * 4 3
 * 0 0
 * Salida de ejemplo
 * 
 * SI
 * SI
 * NO
 * 
 */