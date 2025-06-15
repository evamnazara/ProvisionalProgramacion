package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class SumaleUno {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce números hexadecimales (FIN para terminar):");

        while (true) {
            String numeroHex = scanner.nextLine().trim();

            if (numeroHex.equals("FIN")) {
                System.out.println("Fin del programa.");
                break;
            }

            String siguienteHex = sumarUnoHexadecimal(numeroHex);
            System.out.println("Siguiente número hexadecimal: " + siguienteHex);
        }

        scanner.close();
    }

    private static String sumarUnoHexadecimal(String hex) {
        char[] hexArray = hex.toCharArray();
        int longitud = hexArray.length;
        boolean carry = true;

        for (int i = longitud - 1; i >= 0 && carry; i--) {
            char actual = hexArray[i];
            char siguienteCaracter = siguienteDigitoHex(actual);
            hexArray[i] = siguienteCaracter;

            if (siguienteCaracter != '0') {
                carry = false;
            }
        }

        if (carry) {
            return "1" + new String(hexArray);
        } else {
            return new String(hexArray);
        }
    }

    private static char siguienteDigitoHex(char digito) {
        if (digito == '9')
            return 'A';
        if (digito == 'F')
            return '0';
        return (char) (digito + 1);
    }
}

/*
 * Súmale uno
 * Cuando escribimos un número en decimal, usamos como dígitos los valores del 0
 * al 9. La posición de cada dígito indica el peso que tiene en el valor total
 * del número.
 * 
 * Los números escritos en hexadecimal, por su parte, utilizan dígitos del 0 al
 * 15. Para representar los que superan el 9, necesitamos símbolos nuevos. Para
 * eso, se utilizan las letras de la A a la F, de manera que, en hexadecimal, el
 * número 9 es seguido por el A, o el BF por C0.
 * 
 * ¿Eres capaz de dar el siguiente número hexadecimal a uno dado?
 * 
 * Entrada
 * La entrada estará compuesta de múltiples casos de prueba. Cada uno consistirá
 * en un número escrito en notación hexadecimal, hasta un máximo de 100 dígitos.
 * Ninguno de los casos de prueba contendrá ceros superfluos a la izquierda, y
 * usarán, en su caso, letras mayúsculas. Un caso de prueba con la cadena FIN
 * marca el final.
 * 
 * Salida
 * Para cada caso de prueba se mostrará una línea en la que aparecerá el número
 * siguiente al dado, escrito en notación hexadecimal sin ceros superfluos a la
 * izquierda y con las letras en mayúscula.
 * 
 * Entrada de ejemplo
 * 9
 * 12
 * FF
 * FIN
 * Salida de ejemplo
 * A
 * 13
 * 100
 */