package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class Matriculas {
    public static void main(String[] args) {
        // Definir las letras válidas en el abecedario sin las vocales y la Ñ
        char[] letrasValidas = { 'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V',
                'W', 'X', 'Y', 'Z' };

        // Scanner para leer los casos de prueba
        Scanner sc = new java.util.Scanner(System.in);

        // Bucle para procesar cada caso de prueba
        while (true) {
            // Leer la matrícula
            System.out.println("Introduce una matrícula (o '9999 ZZZ' para terminar):");
            String matricula = sc.nextLine();

            // Si encontramos la última matrícula "9999 ZZZ", detenemos la ejecución
            if (matricula.equals("9999 ZZZ")) {
                System.out.println("Fin de los casos de prueba.");
                break; // Termina si la matrícula es "9999 ZZZ"
            }

            // Separar la matrícula en la parte numérica y la parte alfabética
            String[] partes = matricula.split(" ");
            int numero = Integer.parseInt(partes[0]); // Parte numérica
            String letras = partes[1]; // Parte alfabética

            // Incrementar el número
            numero++;
            if (numero > 9999) {
                numero = 0; // Si pasa de 9999, reiniciamos a 0000
            }

            // Incrementar las letras
            char letra1 = letras.charAt(0);
            char letra2 = letras.charAt(1);
            char letra3 = letras.charAt(2);

            // Incrementar la tercera letra
            letra3 = getNextLetter(letra3, letrasValidas);

            if (letra3 == letrasValidas[0]) { // Si llegamos a 'B', reiniciamos y avanzamos la segunda letra
                letra2 = getNextLetter(letra2, letrasValidas);
                if (letra2 == letrasValidas[0]) { // Si llegamos a 'B' de nuevo, reiniciamos y avanzamos la primera
                                                  // letra
                    letra1 = getNextLetter(letra1, letrasValidas);
                }
            }

            // Mostrar la siguiente matrícula
            System.out.printf("%04d %c%c%c\n", numero, letra1, letra2, letra3);
        }

        sc.close();
    }

    // Función que obtiene la siguiente letra válida en el abecedario sin vocales ni
    // Ñ
    public static char getNextLetter(char currentLetter, char[] letrasValidas) {
        for (int i = 0; i < letrasValidas.length; i++) {
            if (letrasValidas[i] == currentLetter) {
                if (i == letrasValidas.length - 1) {
                    return letrasValidas[0]; // Si llegamos a la última letra, volvemos a la primera
                } else {
                    return letrasValidas[i + 1]; // De lo contrario, obtenemos la siguiente letra
                }
            }
        }
        return currentLetter; // En caso de error (no debería ocurrir), devolvemos la misma letra
    }
}

/*
 * ¿Cuál es la siguiente matrícula?
 * Las matrículas de los automóviles en España están compuestas por dos partes.
 * La primera consiste en un número decimal de 4 dígitos que se va incrementando
 * de uno en uno. Cuando se llega al último valor (9999), se reinicia la cuenta
 * (en 0000) y se incrementa la segunda parte, que contiene letras.
 * 
 * Esta segunda parte consiste en tres letras consecutivas, excluyendo las
 * vocales y la letra Ñ. Cuando, tras recorrer todos los números, se incrementa
 * la letra, se pasa a la siguiente en el abecedario en la letra situada más a
 * la derecha, saltándose las vocales y la Ñ. Si para ella se acaba el
 * abecedario, se vuelve al principio (B) y se incrementa la anterior con este
 * mismo procedimiento.
 * 
 * ¿Eres capaz de pasar de una matrícula a la siguiente?
 * 
 * Entrada
 * La entrada consta de una serie de casos de prueba. Cada uno aparece en una
 * línea, conteniendo una combinación de números y letras (en mayúscula)
 * correspondiente a una matrícula. Consulta el ejemplo para más información. El
 * último caso de prueba, que no deberá procesarse, contendrá la última
 * matrícula posible, 9999 ZZZ.
 * 
 * Salida
 * Para cada caso de prueba se mostrará una línea en la que aparecerá la
 * matrícula que va a continuación de la dada, con las letras en mayúscula.
 * 
 * Entrada de ejemplo
 * 1234 BBB
 * 9999 BBZ
 * 9999 BBD
 * 9999 ZZZ
 * Salida de ejemplo
 * 
 * 1235 BBB
 * 0000 BCB
 * 0000 BBF
 */