package ud4.aceptaelreto.stringsycaracteres;

public class Verdugo {

    public static void main(String[] args) {
        String[] palabras = {
                "ahorcado",
                "jazz",
                "abc"
        };

        String[] propuestas = {
                "ioaelmnps",
                "aeiiiiii",
                "abcdefghijklmnopqrstuvwxyz"
        };

        // Procesamos cada caso de prueba
        for (int i = 0; i < palabras.length; i++) {
            // Llamamos a la función que simula el juego de ahorcado
            String resultado = ahorcado(palabras[i], propuestas[i]);
            System.out.println(resultado); // Imprimimos el resultado
        }
    }

    public static String ahorcado(String palabra, String propuestas) {
        int fallos = 0; // Contador de fallos
        boolean[] descubiertas = new boolean[palabra.length()]; // Array que marca las letras descubiertas
        int letrasDescubiertas = 0; // Número de letras correctamente adivinadas

        // Recorremos cada letra propuesta
        for (int i = 0; i < propuestas.length(); i++) {
            char letraPropuesta = propuestas.charAt(i);

            // Si ya ha sido resuelto o se ha alcanzado el límite de fallos, ignoramos más
            // propuestas
            if (fallos >= 7 || letrasDescubiertas == palabra.length()) {
                break;
            }

            // Comprobamos si la letra propuesta está en la palabra secreta
            boolean acierto = false;
            for (int j = 0; j < palabra.length(); j++) {
                // Si encontramos la letra propuesta en la palabra y no se ha descubierto antes
                if (palabra.charAt(j) == letraPropuesta && !descubiertas[j]) {
                    descubiertas[j] = true; // Marcamos esta letra como descubierta
                    letrasDescubiertas++; // Incrementamos el número de letras descubiertas
                    acierto = true;
                }
            }

            // Si no hemos acertado, es un fallo
            if (!acierto) {
                fallos++;
            }
        }

        // Determinamos el estado del juego
        if (fallos >= 7) {
            return "AHORCADO";
        } else if (letrasDescubiertas == palabra.length()) {
            return "SALVADO";
        } else {
            return "COLGANDO";
        }
    }
}

// VERSION POR TECLADO

/*
 * package strings;
 * 
 * import java.util.Scanner;
 * 
 * public class Verdugo {
 * 
 * public static void main(String[] args) {
 * // Creamos un objeto Scanner para leer desde el teclado
 * Scanner sc = new Scanner(System.in);
 * 
 * // Leemos el número de casos de prueba
 * int casos = sc.nextInt();
 * sc.nextLine(); // Limpiamos el buffer después de leer el número
 * 
 * // Procesamos cada caso de prueba
 * for (int i = 0; i < casos; i++) {
 * System.out.println("Ingrese la palabra secreta:");
 * String palabra = sc.nextLine(); // Leemos la palabra secreta
 * System.out.println("Ingrese las letras propuestas:");
 * String propuestas = sc.nextLine(); // Leemos las letras propuestas
 * 
 * // Llamamos a la función que simula el juego de ahorcado
 * String resultado = ahorcado(palabra, propuestas);
 * System.out.println(resultado); // Imprimimos el resultado
 * }
 * 
 * // Cerramos el Scanner
 * sc.close();
 * }
 * 
 * public static String ahorcado(String palabra, String propuestas) {
 * int fallos = 0; // Contador de fallos
 * boolean[] descubiertas = new boolean[palabra.length()]; // Array que marca
 * las letras descubiertas
 * int letrasDescubiertas = 0; // Número de letras correctamente adivinadas
 * 
 * // Recorremos cada letra propuesta
 * for (int i = 0; i < propuestas.length(); i++) {
 * char letraPropuesta = propuestas.charAt(i);
 * 
 * // Si ya ha sido resuelto o se ha alcanzado el límite de fallos, ignoramos
 * más propuestas
 * if (fallos >= 7 || letrasDescubiertas == palabra.length()) {
 * break;
 * }
 * 
 * // Comprobamos si la letra propuesta está en la palabra secreta
 * boolean acierto = false;
 * for (int j = 0; j < palabra.length(); j++) {
 * // Si encontramos la letra propuesta en la palabra y no se ha descubierto
 * antes
 * if (palabra.charAt(j) == letraPropuesta && !descubiertas[j]) {
 * descubiertas[j] = true; // Marcamos esta letra como descubierta
 * letrasDescubiertas++; // Incrementamos el número de letras descubiertas
 * acierto = true;
 * }
 * }
 * 
 * // Si no hemos acertado, es un fallo
 * if (!acierto) {
 * fallos++;
 * }
 * }
 * 
 * // Determinamos el estado del juego
 * if (fallos >= 7) {
 * return "AHORCADO";
 * } else if (letrasDescubiertas == palabra.length()) {
 * return "SALVADO";
 * } else {
 * return "COLGANDO";
 * }
 * }
 * }
 * 
 */

/*
 * El verdugo
 * 
 * 
 * El ahorcado es un conocido juego de adivinanzas de lápiz y papel para dos
 * jugadores. Uno de ellos piensa una palabra (a veces una frase completa) y el
 * oponente trata de adivinarla. Para eso, el jugador adivinador va proponiendo
 * letras, que el otro debe ir colocando en la palabra secreta. Si alguna de las
 * letras no aparece en ella, cuenta como un fallo.
 * 
 * Para anotar el número de fallos acumulados, se va completando la figura de un
 * hombre ahorcado, lo que da nombre al juego. Cuando está completamente
 * formada, se considera que el número de fallos es excesivo y el adivinador
 * pierde la partida. La imagen es de un gusto cuestionable, por lo que en
 * algunos contextos se utilizan figuras alternativas, como manzanos a los que
 * se le caen las manzanas.
 * 
 * El número de oportunidades para el adivinador también varía, dependiendo de
 * los detalles que se añadan a la figura. Es habitual que al séptimo fallo el
 * juego se considere terminado.
 * 
 * Dada una palabra secreta y las letras propuestas para descubrir, tu labor es
 * hacer de verdugo y decidir si finalmente el hombre es o no ahorcado.
 * 
 * Entrada
 * Cada caso de prueba está formado por dos líneas, cada una con una secuencia
 * de no más de 100 letras minúsculas del alfabeto inglés sin espacios. La
 * primera representa la palabra oculta. La segunda contiene las letras
 * propuestas por el adivinador, entre las que podría haber algunas repetidas.
 * 
 * Un punto (".") marca el final.
 * 
 * Salida
 * Para cada caso de prueba, el programa escribirá "AHORCADO" si el número de
 * letras falladas es mayor o igual que 7. En otro caso, se escribirá "SALVADO"
 * si la palabra secreta ha sido desvelada completamente, y "COLGANDO" si la
 * partida está aún a medias.
 * 
 * El adivinador podría repetir algunas letras. En ese caso, las segundas
 * apariciones no contarán como fallo (lo fueran o no en su primera aparición).
 * Además, en la entrada podrían aparecer letras posteriores dadas por el
 * adivinador después de haberse salvado o de haber sido condenado, que deben
 * ignorarse.
 * 
 * Entrada de ejemplo
 * ahorcado
 * ioaelmnps
 * jazz
 * aeiiiiii
 * abc
 * abcdefghijklmnopqrstuvwxyz
 * .
 * Salida de ejemplo
 * AHORCADO
 * COLGANDO
 * SALVADO
 */