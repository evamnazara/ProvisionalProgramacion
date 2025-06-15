package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class ElGanadorEs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Número de equipos:");
            int numeroEquipos = sc.nextInt();
            System.out.println("Número de globos entregados:");
            int numeroGlobos = sc.nextInt();
            sc.nextLine(); // bufer

            if (numeroEquipos == 0 && numeroGlobos == 0) {
                System.out.println("¡Fin del concurso!");
                break;
            }

            int[] globosPorEquipo = new int[numeroEquipos + 1]; // Índices 1 a numeroEquipos

            // Pedir los globos entregados a cada equipo
            System.out.println("\n Introduce los datos de globos entregados:");
            System.out.println("Por ejemplo: 3 Rojo");
            for (int i = 0; i < numeroGlobos; i++) {
                System.out.print("Ingrese el número de equipo (1 a " + numeroEquipos + ") y el color de los globos: ");
                int equipo = sc.nextInt();
                // String color = sc.nextLine(); // Leer el color (no se usa en el cálculo)
                globosPorEquipo[equipo]++; // Incrementar el conteo de globos para ese equipo
            }

            int maxGlobos = 0;
            int equipoGanador = -1;
            boolean hayEmpate = false;

            for (int i = 1; i <= numeroEquipos; i++) {
                if (globosPorEquipo[i] > maxGlobos) {
                    maxGlobos = globosPorEquipo[i];
                    equipoGanador = i;
                    hayEmpate = false; // Si un equipo tiene más globos, no hay empate
                } else if (globosPorEquipo[i] == maxGlobos) {
                    hayEmpate = true; // Si hay un empate en la cantidad de globos
                }
            }

            if (hayEmpate) {
                System.out.println("EMPATE");
            } else {
                System.out.println("El equipo ganador es el: " + equipoGanador);
            }
        }

        sc.close();
    }
}

/*
 * En muchos de los concursos de programación, como en el que hoy participas,
 * cada vez que un equipo resuelve correctamente un problema recibe un globo del
 * color asociado a ese problema. Al final, quien más globos consigue no sólo
 * tiene su ordenador más colorido, sino que será el ganador del concurso.
 * 
 * Dada la lista de los globos colocados a cada equipo, ¿eres capaz de decir
 * quién es el ganador?
 * 
 * Entrada
 * La entrada estará compuesta de múltiples casos de prueba, cada uno de ellos
 * simulando un concurso.
 * Cada caso de prueba comienza con una línea con dos números, el primero de
 * ellos indicando el número de equipos participantes (entre 1 y 20) y el
 * segundo el número de globos entregados.
 * 
 * A continuación aparecerá una línea por cada globo entregado, con el número
 * del equipo que lo ha recibido (entre 1 y el número de equipos) y el color
 * (una palabra de un máximo de 20 letras).
 * Un equipo nunca recibirá dos veces el mismo color de globo.
 * 
 * La entrada terminará cuando se llegue a un concurso sin equipos ni globos.
 * 
 * Salida
 * Para cada caso de prueba se debe escribir el número del equipo ganador en una
 * línea. En caso de empate, se escribirá EMPATE.
 * 
 * Entrada de ejemplo
 * 4 3
 * 2 Rojo
 * 3 Amarillo
 * 3 Azul
 * 4 4
 * 2 Rojo
 * 3 Amarillo
 * 3 Azul
 * 2 Verde
 * 0 0
 * Salida de ejemplo
 * 3
 * EMPATE
 */