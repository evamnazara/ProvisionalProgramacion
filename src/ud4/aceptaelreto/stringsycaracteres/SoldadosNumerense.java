package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class SoldadosNumerense {

    // Función principal que maneja la entrada y salida
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leemos las líneas de números romanos
        System.out.println("Introduce los números romanos:");
        while (sc.hasNextLine()) {
            String romano = sc.nextLine().trim();

            if (romano.isEmpty()) {
                break; // Terminamos si no hay más entradas
            }

            // Convertimos el número romano a decimal
            int decimal = romanoARomano(romano);

            // Sumamos 1 al valor decimal
            decimal++;

            // Convertimos el nuevo número decimal de vuelta a romano
            String romanoSiguiente = decimalARomano(decimal);

            // Mostramos el resultado
            System.out.println(romanoSiguiente);
        }

        sc.close();
    }

    // Función que convierte un número romano a decimal
    public static int romanoARomano(String romano) {
        // Definimos un mapa de los valores de los símbolos romanos
        int[] valores = { 1000, 500, 100, 50, 10, 5, 1 };
        String simbolos = "MDCLXVI";

        int resultado = 0;

        // Iteramos sobre cada símbolo del número romano
        for (int i = 0; i < romano.length(); i++) {
            char simbolo = romano.charAt(i);
            // Buscamos el valor del símbolo romano
            int valor = valores[simbolos.indexOf(simbolo)];

            // Si no es el último carácter y el valor siguiente es mayor, restamos este
            // valor
            if (i + 1 < romano.length()) {
                int siguienteValor = valores[simbolos.indexOf(romano.charAt(i + 1))];
                if (valor < siguienteValor) {
                    resultado -= valor; // Restamos el valor si es menor que el siguiente
                } else {
                    resultado += valor; // Sumamos el valor si no es menor
                }
            } else {
                resultado += valor; // Si es el último carácter, siempre sumamos
            }
        }

        return resultado;
    }

    // Función que convierte un número decimal a romano
    public static String decimalARomano(int numero) {
        // Definimos los valores y símbolos romanos correspondientes
        int[] valores = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] simbolos = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        StringBuilder romano = new StringBuilder();

        // Recorremos los valores romanos de mayor a menor
        for (int i = 0; i < valores.length; i++) {
            // Mientras el número sea mayor o igual al valor, sumamos el símbolo romano
            while (numero >= valores[i]) {
                romano.append(simbolos[i]);
                numero -= valores[i];
            }
        }

        return romano.toString();
    }
}

/*
 * ¡Soldados! ¡Numérense!
 * Tiempo máximo: 1,000 s Memoria máxima: 4096 KiB
 * Foto de un soldado del ejército romano
 * Antes de cada batalla era habitual que los centuriones romanos pidieran a
 * todos sus soldados que se numeraran, para confirmar que no faltaba ninguno
 * que hubiera desertado ante el riesgo inminente de la lucha. El primer soldado
 * decía su número y, a continuación, todos sabían quién debía decir el suyo
 * después.
 * 
 * Este proceso es habitual hoy en otros contextos, pero en la Antigua Roma, dar
 * el número siguiente a otro no era tan fácil como ahora porque los números
 * romanos no eran especialmente cómodos para sumar.
 * 
 * Los números romanos son un sistema aditivo/sustractivo, donde se utilizan
 * algunas letras para representar valores, y el uso de varias de ellas suma o
 * resta al acumulado total. La tabla siguiente indica los símbolos válidos en
 * los números romanos y su valor en nuestra notación decimal:
 * 
 * I 1 V 5 X 10 L 50 C 100 D 500 M 1000
 * Las reglas de la notación moderna de números romanos son:
 * 
 * Los símbolos se escriben de izquierda a derecha, empezando por los de mayor
 * valor.
 * Un símbolo seguido por otro de valor igual o menor, suma (XI es 11), mientras
 * que un símbolo seguido por uno de mayor valor, resta (IX es 9).
 * La unidad (I) y demás potencias de 10 (X, C y M) se pueden repetir tres veces
 * seguidas sumando.
 * El resto (V, L y D) no pueden repetirse (su suma daría un símbolo de las
 * potencias de 10) ni usarse restando.
 * La unidad (I) y resto de potencias de 10 pueden aparecer restando, sin
 * repetirse, a los dos símbolos inmediatamente superiores (es válido IV y IX
 * pero no IL o IC).
 * Entrada
 * La entrada está compuesta de un conjunto de líneas, cada una con un número
 * romano (con letras mayúsculas) siguiendo las reglas descritas, entre I (1) y
 * MMMCMXCVIII (3998).
 * 
 * Salida
 * Por cada caso de prueba el programa escribirá el valor siguiente al de la
 * entrada, en números romanos en mayúscula siguiendo las reglas de la notación
 * moderna.
 * 
 * Entrada de ejemplo
 * I
 * III
 * XXXIX
 * MCDXCIX
 * Salida de ejemplo
 * II
 * IV
 * XL
 * MD
 */