package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class ElPijote {

    public static void main(String[] args) {
        // Crear un scanner para leer la entrada
        Scanner sc = new Scanner(System.in);

        // Leer y procesar cada línea de entrada
        while (sc.hasNextLine()) {
            // Leer la secuencia de dígitos
            String input = sc.nextLine();

            // Variable para almacenar si es subnormal o no
            boolean isSubnormal = true;

            // Recorrer todos los dígitos del 0 al 9
            for (char digit = '0'; digit <= '9'; digit++) {
                int count = 0;

                // Contar cuántas veces aparece el dígito actual
                for (int i = 0; i < input.length(); i++) {
                    if (input.charAt(i) == digit) {
                        count++;
                    }
                }

                // Verificar si el primer dígito tiene el mismo número de repeticiones
                if (count != input.length() / 10) {
                    isSubnormal = false;
                    break;
                }
            }

            // Imprimir el resultado
            if (isSubnormal) {
                System.out.println("subnormal");
            } else {
                System.out.println("no subnormal");
            }
        }

        // Cerrar el scanner
        sc.close();
    }
}

/*
 * El Pijote
 * Tiempo máximo: 1,000 s Memoria máxima: 4096 KiB
 * El Quijote sobre el número pi
 * ¿Se puede encontrar El Quijote entre los decimales del número π? La pregunta
 * puede parecer extraña, expliquémonos. Ya sabes que los caracteres se pueden
 * codificar con números, por ejemplo utilizando el código ASCII o UTF-8 o
 * cualquier otro. Pues bien, si escribimos el número (bien largo) que consiste
 * en la concatenación de los códigos de cada caracter del texto de El Quijote
 * en ese mismo orden, ¿podríamos encontrar dicho número dentro de la lista de
 * decimales del número π? Lo mismo podríamos preguntarnos con cualquier otro
 * texto, como el del programa que resuelve este problema, o la concatenación de
 * todos los programas que resuelven este problema.
 * 
 * Pues la respuesta es que no se sabe. Y dirás tú, "Ya me imaginaba". Pero el
 * asunto no termina ahí. Los matemáticos han determinado las tres condiciones
 * que debería cumplir la lista de decimales de π para que cualquier texto
 * aparezca en algún lugar de esa lista. La primera es que sea tan grande como
 * queramos. Eso es fácil, π tiene infinitos decimales. La segunda es que los
 * decimales no tengan un patrón que se repita. Eso también es fácil, ya que π
 * es un número irracional, que significa justamente eso. La tercera condición
 * pide que la lista de decimales sea un número normal, que significa que
 * cualquier número (de 1, 2, 3,… cifras) aparezca dentro de la lista de
 * decimales el mismo número de veces (es decir, que no hay preferencia por
 * ningún número). Pues bien, no se sabe si los decimales de π son un número
 * normal o no (hay bastantes indicios de que sí, pero aún no se ha demostrado).
 * 
 * Si estás un poco decepcionado con la conclusión, no te preocupes, sí hay
 * números que cumplen las tres condiciones. Por ejemplo, el número de
 * Champernowne, que es el 0 seguido de los decimales formados concatenando
 * todos los números naturales, 0,1234567891011121314151617…
 * 
 * Tranquilo, no te vamos a pedir que demuestres que los decimales de π son un
 * número normal. Por ahora estamos interesados en una propiedad más sencilla:
 * saber si una secuencia de esos decimales es subnormal, es decir, que aparecen
 * en ella los dígitos del 0 al 9 el mismo número de veces. ¿Nos ayudas?
 * 
 * Entrada
 * La entrada está formada por una serie de casos de prueba. Cada caso consiste
 * en una secuencia no vacía de hasta 1.000 dígitos del 0 al 9.
 * 
 * Salida
 * El programa escribirá una línea por cada caso de prueba. Si la secuencia dada
 * es subnormal se escribirá subnormal y, en caso contrario, se escribirá no
 * subnormal.
 * 
 * Entrada de ejemplo
 * 
 * 314159
 * 9876543210
 * 00112233554466779898
 * Salida de ejemplo
 * no subnormal
 * subnormal
 * subnormal
 */