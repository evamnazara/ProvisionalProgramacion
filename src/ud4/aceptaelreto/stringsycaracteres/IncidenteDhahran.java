package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class IncidenteDhahran {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leemos el número de casos a procesar
        System.out.println("Introduce el número de casos:");
        int numeroDeCasos = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        // Procesamos cada caso de prueba
        for (int i = 0; i < numeroDeCasos; i++) {
            System.out.println("Introduce el número:");
            String numero = scanner.nextLine();

            // Llamamos a la función que elimina ceros sobrantes
            String resultado = procesarNumero(numero);

            // Imprimimos el resultado
            System.out.println(resultado);
        }

        scanner.close(); // Cerramos el scanner
    }

    // Función que procesa el número para eliminar ceros sobrantes
    public static String procesarNumero(String numero) {
        // 1. Dividimos el número en parte entera y parte fraccionaria
        String[] partes = numero.split("\\."); // Usamos split para dividir en parte entera y fraccionaria

        String parteEntera = partes[0]; // Parte entera
        String parteFraccionaria = partes.length > 1 ? partes[1] : ""; // Parte fraccionaria (si existe)

        // 2. Eliminamos los ceros a la izquierda de la parte entera
        parteEntera = parteEntera.replaceFirst("^0+(?!$)", ""); // Remover ceros a la izquierda, pero aseguramos que no
                                                                // se quede vacío

        // 3. Eliminamos los ceros a la derecha de la parte fraccionaria, si existe
        // parte fraccionaria
        if (!parteFraccionaria.isEmpty()) {
            parteFraccionaria = parteFraccionaria.replaceAll("0+$", ""); // Eliminar ceros al final
        }

        // 4. Si la parte fraccionaria está vacía después de eliminar ceros, no la
        // añadimos
        if (parteFraccionaria.isEmpty()) {
            return parteEntera; // Solo devolvemos la parte entera
        }

        // 5. Si queda parte fraccionaria, devolvemos la parte entera + "." + parte
        // fraccionaria
        return parteEntera + "." + parteFraccionaria;
    }
}

/*
 * El incidente de Dhahran
 * El 25 de febrero de 1991, durante la operación Tormenta del Desierto, un
 * misil Patriot fracasó en su intento de interceptar y destruir un misil
 * balístico de tipo Scud, que terminó ocasionando 28 bajas entre las filas
 * norteamericanas de la base de Dhahran. La investigación del incidente
 * determinó que el problema había sido una pérdida de significancia por culpa
 * del modo en el que se representan los números reales en los ordenadores, que
 * utilizan aritmética de precisión finita.
 * 
 * Esta falta de precisión de los ordenadores es uno de los secretos más
 * vergonzosos de los informáticos. Restas tan sencillas como 1'2 − 1'0 pueden
 * dar como resultado valores humillantes como 0'19999999999999996.
 * 
 * Cuando te enteraste, decidiste que no querías formar parte de semejante
 * engaño y te propusiste crear una librería de cálculo con números reales de
 * precisión infinita. Has recorrido desde entonces un largo camino, conociendo
 * a Karatsuba o descubriendo el método de Newton-Raphson, pero ya casi lo
 * tienes.
 * 
 * El único problema es la salida. Algunas veces los números finales que
 * escribes tienen ceros superfluos a la izquierda o a la derecha, y esa
 * pequeñez tira por tierra la percepción de la calidad que tiene lo que has
 * construído.
 * 
 * Entrada
 * Cada caso de prueba es un número no negativo potencialmente con decimales y
 * con ceros sobrantes a la izquierda en la parte entera, o a la derecha de la
 * parte fraccionaria. Todos los números tienen parte entera, pero la parte
 * fraccionaria es opcional. El tamaño total nunca supera los 1000 caracteres, y
 * como separador decimal se utiliza la notación anglosajona con un punto que no
 * aparecerá salvo que haya parte fraccionaria.
 * 
 * Salida
 * Por cada caso de prueba el programa escribirá el mismo número eliminando los
 * ceros sobrantes.
 * 
 * Entrada de ejemplo
 * 100.10
 * 0038.33
 * 00.000
 * Salida de ejemplo
 * 100.1
 * 38.33
 * 0
 */
