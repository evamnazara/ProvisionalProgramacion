package ud4.aceptaelreto.arrays;

public class ElHombreCon6Dedos {

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        // Procesamos múltiples casos de prueba
        while (true) {
            // Leemos N y A
            int N = sc.nextInt();
            int A = sc.nextInt();

            // Si N y A son ambos cero, terminamos la entrada
            if (N == 0 && A == 0) {
                break;
            }

            // Arreglo para almacenar los nacimientos por año
            int[] nacimientos = new int[200001]; // Solo usamos hasta el año 200000

            // Leemos los N años de nacimiento
            for (int i = 0; i < N; i++) {
                int año = sc.nextInt();
                nacimientos[año]++; // Incrementamos el contador para ese año
            }

            // Ahora buscamos el máximo número de nacimientos en un periodo de A años
            int maxNacimientos = 0;

            // Usamos una ventana deslizante para contar los nacimientos en los periodos de
            // A años
            int ventana = 0;
            // Inicializamos la primera ventana de A años
            for (int i = 0; i < A; i++) {
                if (i < nacimientos.length) {
                    ventana += nacimientos[i];
                }
            }
            maxNacimientos = ventana;

            // Movemos la ventana a lo largo de los años y calculamos los nacimientos
            for (int i = A; i <= 200000; i++) {
                ventana -= nacimientos[i - A]; // Restamos el valor que sale de la ventana
                ventana += nacimientos[i]; // Sumamos el valor que entra en la ventana
                maxNacimientos = Math.max(maxNacimientos, ventana); // Actualizamos el máximo
            }

            // Imprimimos el resultado para el caso actual
            System.out.println(maxNacimientos);
        }

        sc.close();
    }
}

/*
 * El hombre con seis dedos
 * Tiempo máximo: 1,000-2,000 s Memoria máxima: 4096 KiB
 * Mano con seis dedos
 * El otro día me presentaron a un hombre y al darnos la mano noté algo extraño.
 * ¡Luego me di cuenta de que tenía seis dedos! La cosa me sorprendió tanto que
 * he estado investigando y resulta que no es tan extraño que una persona nazca
 * con más de cinco dedos en una mano o un pie. La anomalía genética se denomina
 * polidactilia y se estima que 1 de cada 500 bebés nace con ella. Lo que ocurre
 * es que normalmente el dedo extra es muy pequeño y termina siendo extirpado
 * sin más consecuencias. Lo que sí es más extraño es que el dedo se encuentre
 * completo y sea funcional. Eso es lo que le ocurría a este hombre.
 * 
 * Continuando mi investigación he dado con una página web donde se han
 * recopilado los años donde se conoce que nació una persona con algún dedo de
 * más, completo y funcional. Y estoy interesado en construir un programa para
 * averiguar en qué siglo nacieron más personas así. Ya puestos, sería mejor
 * tener un programa más general, que sirviera también para averiguar la decada
 * con más nacimientos, o el lustro, etc.
 * 
 * Entrada
 * El programa recibirá por la entrada estándar una serie de casos de prueba.
 * Cada caso consta de dos líneas. En la primera aparecen dos números: el número
 * N de nacimientos de los que tenemos constancia (entre 1 y 200.000) y el
 * número A de años del periodo en el que estamos interesados (un número mayor
 * que cero). En la segunda aparecen, separados por espacios y ordenados
 * cronológicamente, los N años de nacimiento (si en un mismo año nació más de
 * una persona, el año aparecerá repetido).
 * 
 * Detrás del último caso aparece una línea con dos ceros.
 * 
 * Salida
 * Para cada caso de prueba el programa escribirá una línea con el mayor número
 * de personas que ha nacido en un periodo de A años. Ten en cuenta que si un
 * periodo de A años comienza en el año D entonces abarca hasta el año D + A −
 * 1, inclusive.
 * 
 * 
 * 
 * Entrada de ejemplo
 * 10 5
 * 1 1 4 4 5 6 6 7 10 11
 * 10 6
 * 1 1 4 4 5 6 6 7 10 11
 * 0 0
 * Salida de ejemplo
 * 6
 * 7
 * 
 */
