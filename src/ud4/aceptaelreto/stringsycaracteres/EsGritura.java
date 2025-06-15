package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class EsGritura {

    public static void main(String[] args) {
        // Crear un scanner para leer la entrada
        Scanner sc = new Scanner(System.in);

        // Leer y procesar cada línea de entrada
        while (sc.hasNextLine()) {
            // Leer la línea de entrada
            String input = sc.nextLine();

            // Si la línea está vacía, continuar con la siguiente
            if (input.isEmpty()) {
                continue;
            }

            // Contadores para las letras y los signos de exclamación
            int letraCount = 0;
            int exclamacionCount = 0;

            // Iterar sobre cada caracter de la línea
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);

                // Si el carácter es una letra (a-z o A-Z), contar como letra
                if (Character.isLetter(c)) {
                    letraCount++;
                }

                // Si el carácter es un signo de exclamación, contar como exclamación
                if (c == '!') {
                    exclamacionCount++;
                }
            }

            // Comparar los contadores y determinar si es un "esgrito" o no
            if (exclamacionCount > letraCount) {
                System.out.println("ESGRITO");
            } else {
                System.out.println("escrito");
            }
        }

        // Cerrar el scanner
        sc.close();
    }
}

/*
 * Esgritura
 * Tiempo máximo: 1,000 s Memoria máxima: 4096 KiB
 * Montaje que recuerda al cuadro de Edvard Munch
 * Hoy en día se está perdiendo el uso del signo de exclamación al inicio de las
 * frases. Quizá por el deseo de rapidez al escribir, por la influencia de otros
 * idiomas (principalmente el inglés) o, simplemente, por pereza, mucha gente ha
 * dejado de usar un símbolo único de nuestra lengua.
 * 
 * Resulta irónico que, por el contrario, a veces parezca que se compensa esta
 * ausencia de los símbolos de apertura repitiendo el de cierre más allá de toda
 * lógica.
 * 
 * Luis Piedrahita está siempre preocupado por encontrar palabras para dar
 * nombre a los nuevos conceptos. Tras poner su atención en estos textos
 * pródigos en signos de exclamación y parcos en contenido, ha propuesto para
 * ellos la palabra esgritura, que define tal que así:
 * "La esgritura es la acción o efecto de esgritar. Es la representación de conceptos o ideas, con más signos de exclamación que letras. Es un texto entusiasta; un grito escrito"
 * .
 * 
 * Estás desarrollando un nuevo sistema de mensajería instantánea y quieres
 * detectar esgritos para ponerles un tamaño de fuente mayor, de acuerdo a su
 * énfasis implícito. ¿Eres capaz de detectarlos?
 * 
 * Entrada
 * El programa deberá leer, de la entrada estándar, los mensajes recibidos desde
 * el servidor por la aplicación de mensajería instantánea, cada uno en una
 * línea. Estarán compuestos de entre 1 y 1.000 caracteres, formados únicamente
 * por letras del alfabeto inglés, espacios, signos de exclamación (solo de
 * cierre, por supuesto), y otros signos ortográficos.
 * 
 * Salida
 * Por cada línea de la entrada, el programa escribirá ESGRITO si el texto tiene
 * más signos de exclamación que letras (del abecedario inglés), y escrito en
 * caso contrario.
 * 
 * Entrada de ejemplo
 * Hola!!!!!
 * No puedo ir :(
 * 22!
 * Uau!!!
 * Si!! Si!!!
 * :-O!!
 * Salida de ejemplo
 * 
 * ESGRITO
 * escrito
 * ESGRITO
 * escrito
 * ESGRITO
 * ESGRITO
 */