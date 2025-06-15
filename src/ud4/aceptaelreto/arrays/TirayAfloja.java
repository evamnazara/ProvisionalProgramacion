package ud4.aceptaelreto.arrays;

public class TirayAfloja {

    public static void main(String[] args) {
        // Usamos Scanner para recibir la entrada
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Leemos el número de casos de prueba
        System.out.print("Introduce el número de casos de prueba: ");
        int casosDePrueba = scanner.nextInt();

        // Iteramos por cada caso de prueba
        for (int caso = 1; caso <= casosDePrueba; caso++) {
            // Leemos el número de alumnos para este caso
            System.out.print("\nIntroduce el número de alumnos: ");
            int numAlumnos = scanner.nextInt();

            // Leemos los pesos de los alumnos
            System.out.print("Introduce los pesos de los alumnos: ");
            int[] pesos = new int[numAlumnos];
            for (int i = 0; i < numAlumnos; i++) {
                pesos[i] = scanner.nextInt();
            }

            // Variables para calcular el peso total a la izquierda y a la derecha
            int pesoIzquierda = 0, pesoDerecha = 0;
            int alumnosIzquierda = 0;
            boolean hayDiferenciaUnica = false;

            // Empezamos calculando el peso total de todo el equipo (todos los alumnos)
            for (int i = 0; i < numAlumnos; i++) {
                pesoDerecha += pesos[i];
            }

            // Ahora vamos a intentar encontrar la línea divisoria
            for (int i = 0; i < numAlumnos - 1; i++) {
                // Transferimos un alumno de la derecha a la izquierda
                pesoIzquierda += pesos[i];
                pesoDerecha -= pesos[i];

                // Comprobamos si el peso de la izquierda es mayor que el de la derecha
                if (pesoIzquierda == pesoDerecha) {
                    alumnosIzquierda = i + 1; // Los alumnos a la izquierda son i+1
                    hayDiferenciaUnica = true;
                    break;
                }
            }

            // Imprimimos el resultado dependiendo de si encontramos una división válida
            if (hayDiferenciaUnica) {
                System.out.println(alumnosIzquierda + " " + pesoIzquierda + " " + pesoDerecha);
            } else {
                System.out.println("NO JUEGAN");
            }
        }

        // Cerramos el scanner para liberar recursos
        scanner.close();
    }
}

/*
 * Tira y afloja
 * Tiempo máximo: 2,000-3,000 s Memoria máxima: 8192 KiB
 * Niños jugando al 'Tira y afloja'
 * El tira y afloja se jugaba mucho en las ferias y fiestas populares. También
 * lo jugaban los niños en el patio del colegio, o por las tardes en la plaza.
 * Se forman dos equipos, y cada uno se situa a un lado de una línea marcada en
 * el suelo sujetando una cuerda. La cuerda se mantiene estirada y a una señal
 * del árbitro cada equipo tira de la cuerda hacia su campo. El juego termina
 * cuando algún equipo consigue que el contrario suelte la cuerda o que algún
 * oponente traspase la línea que separa los dos campos.
 * 
 * En mi colegio se jugaba durante la clase de educación física. La profesora
 * nos colocaba en fila y nos daba la cuerda. Para hacer los equipos lo más
 * equilibrados posible, marcaba la línea central en el punto en el que el peso
 * de los alumnos que quedaban en la parte izquierda era lo más parecido posible
 * al peso de los alumnos que quedaban en la parte derecha. Como todos los niños
 * sabíamos, para ganar es mucho más importante el peso del equipo que el número
 * de jugadores. Había algunos días en los que la línea divisoria se podía
 * colocar en varios sitios, siendo la diferencia de peso entre los dos equipos
 * que se forman al colocar la línea en un sitio o en otro la misma. Esto ponía
 * a la profesora de mal humor y decidía finalizar la clase sin dejarnos jugar.
 * 
 * Entrada
 * La entrada consta de una serie de casos de prueba. Cada uno de ellos tiene de
 * dos líneas. La primera indica el número de alumnos de la clase (entre 2 y
 * 300.000), y la segunda el peso de cada uno (un número entero entre 1 y 70)
 * siguiendo el orden en que están colocados en la fila, de izquierda a derecha.
 * Ten en cuenta que la fila no puede reordenarse.
 * 
 * Salida
 * Para cada caso de prueba se indicará el número de alumnos que quedan en el
 * equipo de la izquierda seguido del peso total de dicho equipo y el peso total
 * del equipo de la derecha. Si no es posible determinar la posición de la línea
 * de forma única, se escribirá "NO JUEGAN".
 * 
 * Entrada de ejemplo
 * 7
 * 45 32 41 37 28 39 32
 * 8
 * 41 43 35 32 31 47 57 62
 * 3
 * 20 25 20
 * Salida de ejemplo
 * 
 * 3 118 136
 * 5 182 166
 * NO JUEGAN
 * 
 */