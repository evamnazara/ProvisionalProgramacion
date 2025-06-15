
package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class YoLoColoco {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leemos el número de casos de prueba
        System.out.println("Introduce el número de casos:");
        int numeroDeCasos = sc.nextInt();
        sc.nextLine(); // Limpiamos el buffer para que no interfiera con la siguiente entrada

        // Procesamos cada caso de prueba
        for (int i = 0; i < numeroDeCasos; i++) {
            System.out.println("Introduce las dos frases para el caso " + (i + 1) + ":");

            // Leemos las dos frases
            String frase1 = sc.nextLine();
            String frase2 = sc.nextLine();

            // Limpiamos las frases para eliminar los espacios y signos de puntuación
            String fraseLimpiada1 = limpiarFrase(frase1);
            String fraseLimpiada2 = limpiarFrase(frase2);

            // Comparar las frases
            if (fraseLimpiada1.equals(fraseLimpiada2)) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        }

        sc.close(); // Cerramos el scanner
    }

    // Función para limpiar las frases
    public static String limpiarFrase(String frase) {
        // Convertimos la frase a minúsculas para no distinguir entre mayúsculas y
        // minúsculas
        frase = frase.toLowerCase();

        // Creamos un StringBuilder para almacenar solo las letras
        String resultado = "";

        // Recorremos cada carácter de la frase
        for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);

            // Comprobamos si el carácter es una letra (de a-z)
            if (c >= 'a' && c <= 'z') {
                resultado += c; // Lo añadimos al resultado
            }
        }

        return resultado;
    }
}

/*
 * Yo lo coloco
 * Colocando cubiertos en la mesa
 * El calambur es un artificio lingüístico utilizado de vez en cuando por
 * escritores y humoristas para provocar la sonrisa de los lectores o
 * espectadores. Consiste en aprovechar que una misma frase puede tener dos
 * significados dependiendo de cómo se agrupen las sílabas pronunciadas.
 * 
 * Un ejemplo muy conocido es la frase "Yo lo coloco y ella ¡lo quita!" que,
 * estableciendo la separación entre palabras de forma distinta puede
 * interpretarse como "Yo loco, loco. Y ella… loquita".
 * 
 * Es posible, eso sí, que el calambur más famoso de la lengua española sea uno
 * atribuido a Quevedo que aprovechó el recurso fonético para llamar coja a la
 * reina doña Isabel de Borbón. Parece ser que se presentó ante la reina con un
 * ramo de flores en cada mano y dijo
 * "Entre el clavel blanco y la rosa roja, su majestad escoja".
 * 
 * El calambur suele basarse en la forma en la que las palabras suenen por lo
 * que en ocasiones las letras en ambas interpretaciones no coinciden. Por
 * ejemplo ocurre con "¿Por qué lavó la rueda?" frente a
 * "¿Por qué la bola rueda?". Otras veces (las menos) las dos interpretaciones
 * tienen exactamente las mismas letras pero al leerlos suenan de forma muy
 * distinta, como "Servil, letal, impía" y "Servilleta límpia".
 * 
 * ¿Eres capaz de ver si dos frases forman un calambur? Para hacerlo sencillo,
 * solo consideraremos el último grupo: aquel que, aunque la pronunciación sea
 * muy distinta, tenga exactamente las mismas letras.
 * 
 * Entrada
 * La entrada comienza con una línea con un número que indica el número de casos
 * de prueba que vendrán a continuación.
 * 
 * Por cada caso de prueba aparecerán dos líneas, una con cada frase. Las líneas
 * estarán formadas exclusivamente por letras del alfabeto inglés (no habrá eñes
 * ni vocales acentuadas, por ejemplo), espacios y signos de puntuación (puntos,
 * comas, dos puntos o punto y coma).
 * 
 * Cada línea tendrá un máximo de 500.000 caracteres.
 * 
 * Salida
 * Por cada caso de prueba se escribirá una línea con un SI si a la vista de las
 * dos líneas forman un calambur (con exactamente las mismas letras) y NO en
 * caso contrario. Dos frases exactamente iguales las consideraremos también
 * calambur.
 * 
 * Entrada de ejemplo
 * 2
 * Yo lo coloco y ella lo quita.
 * Yo loco, loco. Y ella... loquita.
 * El pan esta blando
 * El pan esta hablando
 * Salida de ejemplo
 * SI
 * NO
 * 
 */