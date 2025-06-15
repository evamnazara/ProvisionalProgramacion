package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class ElMejorDia {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leer el número de casos de prueba
        int casosPrueba = sc.nextInt();

        // Procesar cada caso de prueba
        for (int i = 0; i < casosPrueba; i++) {
            // Leer el número de días
            int N = sc.nextInt();

            // Leer las valoraciones de los días
            int[] valoraciones = new int[N];
            for (int j = 0; j < N; j++) {
                valoraciones[j] = sc.nextInt();
            }

            // Llamar a la función que resuelve el problema
            calcularMejorPeorDia(valoraciones);
        }

        sc.close();
    }

    /**
     * Esta función calcula el valor dado por los optimistas al "mejor peor día de
     * su vida"
     * para cada día de la serie de días.
     * 
     * @param valoraciones Arreglo con las valoraciones de los días.
     */
    public static void calcularMejorPeorDia(int[] valoraciones) {
        int N = valoraciones.length;

        // Creamos un arreglo para almacenar el máximo desde cada día hasta el final.
        int[] maxFuturo = new int[N];

        // Llenamos el arreglo maxFuturo desde el último día hacia atrás
        maxFuturo[N - 1] = valoraciones[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            maxFuturo[i] = Math.max(valoraciones[i], maxFuturo[i + 1]);
        }

        // Calculamos la diferencia para cada día
        for (int i = 0; i < N; i++) {
            int diferencia = maxFuturo[i] - valoraciones[i];
            System.out.print(diferencia + " ");
        }
        System.out.println(); // Salto de línea después de imprimir todas las diferencias
    }
}

/*
 * El mejor peor día de tu vida
 * Tiempo máximo: 1,000-2,000 s Memoria máxima: 8192 KiB
 * Personajes Alegría y Tristeza, de Inside Out (Pixar, 2015)
 * Dicen que el día de tu boda es el mejor momento de tu vida. Eso puede
 * interpretarse como que a partir de ese momento no se levanta cabeza. Si lo
 * ponemos con números significa que podemos representar cada día de nuestra
 * vida con una cifra y el máximo de la serie numérica de tu vida estaría
 * precisamente en ese día.
 * 
 * Si damos por cierto el dicho anterior, los pesimistas no se casarán nunca. A
 * fin de cuentas, sería imposible que levantaran el ánimo sabiendo que nunca
 * nada superará esas fugaces horas en las que te comprometiste para siempre.
 * 
 * Los optimistas, no obstante, no ven las cosas de forma tan horrible. Que el
 * día de tu boda sea el mejor no significa que luego las cosas vayan decayendo
 * continuamente. Muy al contrario, habrá días malos a los que seguirán días
 * buenos que se podrán disfrutar. Es cierto que nunca superarán el máximo
 * alcanzado el día de tu enlace matrimonial, pero no por eso hay que dejar de
 * valorarlos.
 * 
 * Esos optimistas empedernidos encuentran un motivo de alegría incluso los días
 * más horribles. Se conforman con pensar que cuanto peor es un día, mayor será
 * la diferencia con el mejor día que aún les queda por vivir, y el contraste
 * hará que cuando llegue lo disfruten más.
 * 
 * Entrada
 * La entrada estará compuesta por distintos casos de prueba, cada uno
 * representando la serie de números que condensan la vida de una persona.
 * 
 * Cada caso de prueba ocupa dos líneas. La primera contiene un único número N
 * con el número de días para el que hay valoración (2 ≤ N ≤ 200.000). A
 * continuación aparecerá una segunda línea con las valoraciones de esos N días,
 * que estarán siempre entre 0 y 109.
 * 
 * Salida
 * Para cada caso de prueba se escribirá una única línea con un número,
 * indicando el valor que los optimistas dan al mejor peor día de su vida. El
 * valor dado a cada día es la diferencia entre la valoración del mejor día que
 * aún queda por vivir (incluido él) menos su propio valor.
 * 
 * Entrada de ejemplo
 * 3
 * 1 4 2
 * 3
 * 2 4 1
 * 3
 * 4 2 1
 * Salida de ejemplo
 * 3
 * 2
 * 0
 * 
 */
