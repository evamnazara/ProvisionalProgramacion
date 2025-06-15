package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class PrimoDeRiesgo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el número de casos de prueba:");
        int numCasos = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < numCasos; i++) {
            System.out.println("Introduce una palabra:");
            String palabra = sc.nextLine().trim();

            int sumaAscii = calcularSumaAscii(palabra);
            int primoInferior = encontrarPrimoInferior(sumaAscii);

            System.out.println(primoInferior);
        }

        sc.close();
    }

    private static int calcularSumaAscii(String palabra) {
        int suma = 0;
        for (int i = 0; i < palabra.length(); i++) {
            suma += (int) palabra.charAt(i);
        }
        return suma;
    }

    private static int encontrarPrimoInferior(int numero) {
        while (!esPrimo(numero)) {
            numero--;
        }
        return numero;
    }

    private static boolean esPrimo(int numero) {
        if (numero < 2)
            return false;
        for (int i = 2; i * i <= numero; i++) {
            if (numero % i == 0)
                return false;
        }
        return true;
    }
}

/*
 * Primo de riesgo
 * Para las máquinas, las palabras no son más que sucesiones de caracteres. Esos
 * caracteres, a su vez, no son más que números que, gracias a la codificación
 * utilizada, son interpretados como letras, signos de puntuación o cualquier
 * otro símbolo. Una de las codificaciones más extendidas y que sigue
 * utilizándose hoy en día (aunque sea como subconjunto de las codificaciones
 * utilizadas) es la codificación ASCII. De hecho, en la mayoría de los
 * lenguajes de programación actuales, todas las letras del alfabeto inglés y
 * los símbolos más utilizados (espacio, punto, coma, ...) cuando están
 * almacenadas en una variable de tipo carácter pueden convertirse a un número
 * entero, consiguiendo así su código ASCII.
 * 
 * Dado, pues, que las letras de una cadena pueden convertirse a números,
 * podemos hacer la suma de todos los caracteres para obtener el número de la
 * cadena completa.
 * 
 * Así, la codificación de cada carácter de, por ejemplo, la palabra "riesgo" es
 * 
 * Carácter Código ASCII
 * r 114
 * i 105
 * e 101
 * s 115
 * g 103
 * o 111
 * Lo que hace que la codificación completa de riesgo sea:
 * 
 * 114 + 105 + 101 + 115 + 103 + 111 = 649
 * 
 * Lo que nos preguntamos es, dado ese número, ¿cuál es el número primo inferior
 * más cercano?1
 * 
 * Entrada
 * La entrada comienza con un número que indica la cantidad de casos de prueba
 * que siguen. Cada uno de estos casos de prueba es una palabra con letras del
 * alfabeto inglés de no más de 50 caracteres.
 * 
 * Salida
 * Para cada caso de prueba se mostrará una única línea en la que se indicará el
 * número primo inferior más cercano al número obtenido a partir de la palabra
 * según la descripción anterior.
 * 
 * Entrada de ejemplo
 * 3
 * A
 * i
 * riesgo
 * Salida de ejemplo
 * 
 * 61
 * 103
 * 647
 */