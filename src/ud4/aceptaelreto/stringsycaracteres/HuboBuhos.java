package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class HuboBuhos {

    public static void main(String[] args) {
        // Crear un scanner para leer la entrada
        Scanner sc = new Scanner(System.in);

        // Leer casos de prueba hasta que se encuentre XXX"
        while (true) {
            // Leer una línea de entrada
            String frase = sc.nextLine();

            // Si encontramos "XXX", terminamos el programa
            if (frase.equals("XXX")) {
                break;
            }

            // Paso 1: Eliminar los espacios y convertir la frase a minúsculas
            // Usamos un array de caracteres para ir ignorando espacios
            String fraseLimpia = "";
            for (int i = 0; i < frase.length(); i++) {
                char c = frase.charAt(i);
                if (c != ' ') {
                    fraseLimpia += Character.toLowerCase(c); // Convertimos a minúsculas
                }
            }

            // Paso 2: Verificar si la frase es un palíndromo
            // Comprobamos si la frase es igual a su reverso
            boolean esPalindromo = true;
            int len = fraseLimpia.length();
            for (int i = 0; i < len / 2; i++) {
                if (fraseLimpia.charAt(i) != fraseLimpia.charAt(len - i - 1)) {
                    esPalindromo = false; // Si encontramos una diferencia, no es palíndromo
                    break;
                }
            }

            // Paso 3: Imprimir el resultado
            if (esPalindromo) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        }

        // Cerrar el scanner
        sc.close();
    }
}

/*
 * ¿Acaso hubo búhos acá?
 * Tiempo máximo: 1,000 s Memoria máxima: 2048 KiB
 * Dos búhos en imágen especular
 * Juan Filloy, un escritor argentino nacido en 1894, se autoproclamó el
 * "recordman mundial de palindromía" pues gracias a él hoy conocemos más de
 * 8.000 palíndromos españoles.
 * 
 * En justicia, sin embargo, debemos decir que ese título hoy día debería
 * llevárselo Victor Carbajo, un músico y compositor español que en su web1
 * mantiene una colección de más de 100.001 palíndromos que amplía regularmente.
 * 
 * Un palíndromo es una palabra o frase que, tras unificar mayúsculas y quitarle
 * tildes, espacios y signos de puntuación, se lee igual de izquierda a derecha
 * que de derecha a izquierda. Un ejemplo es el título de este problema, uno de
 * los palíndromos más famosos de Juan Filloy.
 * 
 * Asociada a los palíndromos, existe la pregunta casi filosófica de si éstos se
 * inventan o se descubren. Nosotros nos quedaremos con la segunda opción e
 * intentaremos descubrir, dada una frase, si es o no palíndroma.
 * 
 * Entrada
 * La entrada estará compuesta por múltiples casos de prueba. Cada caso de
 * prueba es una única línea con una palabra o frase de no más de 100
 * caracteres. En ella puede haber tanto letras mayúsculas como minúsculas del
 * alfabeto inglés y uno o varios espacios separando palabras (eso sí, las
 * líneas empezarán y terminarán siempre con letra, nunca con espacios). A
 * riesgo de comprometer la ortografía y la semántica, las palabras no
 * contendrán tildes y los signos de puntuación se omiten.
 * 
 * El último caso de prueba va seguido de una línea con XXX que marca el final y
 * no debe ser procesada.
 * 
 * Salida
 * Por cada caso de prueba se escribirá SI si la palabra o frase es palíndroma y
 * NO en caso contrario.
 * 
 * Entrada de ejemplo
 * Acaso hubo buhos aca
 * Querido muerto esta tarde llegamos
 * XXX
 * Salida de ejemplo
 * SI
 * NO
 * Notas
 * El segundo caso de prueba, claramente no palíndromo, es una modificación
 * (cambiando Señor por Querido para evitar caracteres fuera del alfabeto
 * inglés) de un ejemplo famoso en el que se pone de manifiesto la importancia
 * de los signos de puntuación y las tildes:
 * "Señor muerto, esta tarde llegamos." frente a
 * "¡Señor! ¡Muerto está! ¡Tarde llegamos!".
 * 
 * 
 * 
 */
