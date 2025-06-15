package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class LosNinosPrimero {

    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada
        Scanner sc = new Scanner(System.in);

        // Leer el número de casos de prueba
        while (true) {
            // Leer el número de personas que salen (n)
            int n = sc.nextInt();

            // Si el número de personas es 0, terminar el programa
            if (n == 0) {
                break;
            }

            // Crear un arreglo para almacenar las alturas de las personas
            int[] alturas = new int[n];

            // Leer las alturas
            for (int i = 0; i < n; i++) {
                alturas[i] = sc.nextInt();
            }

            // Encontrar la altura mínima
            int alturaMinima = alturas[0];
            for (int i = 1; i < n; i++) {
                if (alturas[i] < alturaMinima) {
                    alturaMinima = alturas[i];
                }
            }

            // Contar cuántos niños (con la altura mínima) hay al principio
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (alturas[i] == alturaMinima) {
                    count++;
                } else {
                    break; // Si encontramos una persona más alta, dejamos de contar
                }
            }

            // Imprimir el resultado para este caso de prueba
            System.out.println(count);
        }

        // Cerrar el scanner
        sc.close();
    }
}

/*
 * ¡Los niños primero!
 * Tiempo máximo: 2,000-4,000 s Memoria máxima: 8192 KiB
 * Imagen de un circo con aros de fuego y tigres
 * En muchos espectáculos circenses con animales es habitual que las fieras
 * terminen pasando por aros ardiendo. Aunque no es algo que entrañe mucho
 * peligro para el animal, pues pasan muy rápido y sin apenas rozar las llamas,
 * sí refleja el buen hacer de los domadores que gracias a su tesón consiguen
 * que una bestia que teme al fuego lo atraviese.
 * 
 * Algo con lo que esos domadores deben ser muy cuidadosos, eso sí, es con la
 * forma de manejar esos aros ardiendo durante el espectáculo. Al fin y al cabo,
 * "jugar con fuego" es una actividad peligrosa que puede terminar en tragedia.
 * 
 * La normativa de Cirburgo establece que cada cierto tiempo hay que hacer un
 * simulacro de evacuación del circo. De vez en cuando se presentan inspectores
 * del gobierno a las funciones y hacen desalojar a la gente midiendo el tiempo
 * que se tarda en vaciar el circo y si todos los niños salen primero.
 * 
 * Los dueños del circo saben que sus trabajadores están perfectamente
 * instruidos para reaccionar en situaciones de emergencia y están seguros de
 * que por la puerta salen primero todos los niños y luego los adultos. Lejos de
 * estar hartos de los simulacros, han terminado por usarlos en su propio
 * beneficio. Han puesto en la salida de emergencia un medidor de altura que les
 * permite posteriormente analizar los datos y averiguar cuántos niños había
 * entre el público (asumiendo que los niños son más bajitos que los adultos).
 * De esta forma podrán estudiar tarifas de precios distintas dependiendo de la
 * edad.
 * 
 * Dada la lista de alturas de las personas que salen, ¿cuántos niños como
 * mínimo habían entrado? Teniendo en cuenta que se trata de un circo, se
 * garantiza que al menos habrá uno.
 * 
 * Entrada
 * La entrada estará compuesta de distintos casos de prueba, cada uno
 * representando los datos leídos durante un simulacro.
 * 
 * Cada caso de prueba consta de dos líneas, la primera indica el número de
 * gente que abandona el circo (1 ≤ n ≤ 200.000). La segunda contiene n números
 * positivos con las alturas leídas por el sensor. Ten en cuenta que las
 * unidades en las que el sensor mide la altura no está clara. Lo único que
 * garantiza la medición es que si una persona es más alta que otra, su medición
 * será también mayor.
 * 
 * El último simulacro es seguido por una línea con un 0.
 * 
 * Salida
 * Para cada caso de prueba se escribirá una única línea con el número mínimo de
 * niños que había en el circo.
 * 
 * Entrada de ejemplo
 * 4
 * 1 1 7 8
 * 4
 * 100 700 100 800
 * 8
 * 3 4 2 4 5 12 13 10
 * 0
 * Salida de ejemplo
 * 
 * 2
 * 3
 * 4
 * 
 */