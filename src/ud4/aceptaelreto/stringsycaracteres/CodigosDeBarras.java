package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class CodigosDeBarras {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Ingrese un código de barras (0 para salir):");
            String codigoDeBarras = scanner.nextLine().trim();

            // Si el usuario ingresa "0", terminamos el programa
            if (codigoDeBarras.equals("0")) {
                System.out.println("Programa finalizado.");
                break;
            }

            // Validar longitud y procesar el código
            if (codigoDeBarras.length() < 8 || codigoDeBarras.length() > 13) {
                System.out.println("El largo del código es inválido");
            } else if (codigoDeBarras.length() == 8) {
                System.out.println(validarEAN8(codigoDeBarras) ? "SI" : "NO");
            } else if (codigoDeBarras.length() == 13) {
                System.out.println(validarEAN13(codigoDeBarras));
            } else {
                System.out.println("El largo del código es inválido");
            }
        }

        scanner.close();
    }

    // Método para validar un código EAN-8
    static boolean validarEAN8(String codigoEAN) {
        int suma = 0;

        // Recorrer los primeros 7 dígitos (sin contar el dígito de control)
        for (int i = 0; i < 7; i++) {
            int digito = Character.getNumericValue(codigoEAN.charAt(i));
            if ((i % 2) == 0) { // Posiciones impares (desde la derecha) multiplicadas por 3
                suma += digito * 3;
            } else { // Posiciones pares multiplicadas por 1
                suma += digito;
            }
        }

        // Calcular el dígito de control esperado
        int digitoControlCalculado = (10 - (suma % 10)) % 10;
        int digitoControlReal = Character.getNumericValue(codigoEAN.charAt(7));

        return digitoControlCalculado == digitoControlReal;
    }

    // Método para validar un código EAN-13
    static String validarEAN13(String codigoEAN) {
        int suma = 0;

        // Recorrer los primeros 12 dígitos (sin contar el dígito de control)
        for (int i = 0; i < 12; i++) {
            int digito = Character.getNumericValue(codigoEAN.charAt(i));
            if ((i % 2) == 0) { // Posiciones impares multiplicadas por 1
                suma += digito;
            } else { // Posiciones pares multiplicadas por 3
                suma += digito * 3;
            }
        }

        // Calcular el dígito de control esperado
        int digitoControlCalculado = (10 - (suma % 10)) % 10;
        int digitoControlReal = Character.getNumericValue(codigoEAN.charAt(12));

        if (digitoControlCalculado != digitoControlReal) {
            return "NO";
        }

        // Obtener el país a partir de los primeros dígitos (sin usar Map)
        String codigoPais = obtenerPais(codigoEAN);
        return "SI " + codigoPais;
    }

    // Método para determinar el país en un código EAN-13 sin usar Map
    static String obtenerPais(String codigoEAN) {
        // Arrays de códigos de países y sus nombres
        String[] codigosPais = { "0", "380", "50", "539", "560", "70", "759", "850", "890" };
        String[] paises = { "EEUU", "Bulgaria", "Inglaterra", "Irlanda", "Portugal", "Noruega", "Venezuela", "Cuba",
                "India" };

        // Extraer los primeros 3, 2 o 1 dígitos para encontrar el país
        for (int i = 3; i > 0; i--) {
            String codigo = codigoEAN.substring(0, i);
            for (int j = 0; j < codigosPais.length; j++) {
                if (codigosPais[j].equals(codigo)) {
                    return paises[j];
                }
            }
        }

        return "Desconocido";
    }
}

// VERSION MATRICES
/*
 * public class CodigosDeBarras {
 * 
 * public static void main(String[] args) {
 * Scanner scanner = new Scanner(System.in);
 * 
 * while (true) {
 * System.out.println("Ingrese un código de barras (0 para salir):");
 * String codigoDeBarras = scanner.nextLine().trim();
 * 
 * // Si el usuario ingresa "0", terminamos el programa
 * if (codigoDeBarras.equals("0")) {
 * System.out.println("Programa finalizado.");
 * break;
 * }
 * 
 * // Validar longitud y procesar el código
 * if (codigoDeBarras.length() < 8 || codigoDeBarras.length() > 13) {
 * System.out.println("El largo del código es inválido");
 * } else if (codigoDeBarras.length() == 8) {
 * System.out.println(validarEAN8(codigoDeBarras) ? "SI" : "NO");
 * } else if (codigoDeBarras.length() == 13) {
 * System.out.println(validarEAN13(codigoDeBarras));
 * } else {
 * System.out.println("El largo del código es inválido");
 * }
 * }
 * 
 * scanner.close();
 * }
 * 
 * // Método para validar un código EAN-8
 * static boolean validarEAN8(String codigoEAN) {
 * int suma = 0;
 * 
 * // Recorrer los primeros 7 dígitos (sin contar el dígito de control)
 * for (int i = 0; i < 7; i++) {
 * int digito = Character.getNumericValue(codigoEAN.charAt(i));
 * if ((i % 2) == 0) { // Posiciones impares (desde la derecha) multiplicadas
 * por 3
 * suma += digito * 3;
 * } else { // Posiciones pares multiplicadas por 1
 * suma += digito;
 * }
 * }
 * 
 * // Calcular el dígito de control esperado
 * int digitoControlCalculado = (10 - (suma % 10)) % 10;
 * int digitoControlReal = Character.getNumericValue(codigoEAN.charAt(7));
 * 
 * return digitoControlCalculado == digitoControlReal;
 * }
 * 
 * // Método para validar un código EAN-13
 * static String validarEAN13(String codigoEAN) {
 * int suma = 0;
 * 
 * // Recorrer los primeros 12 dígitos (sin contar el dígito de control)
 * for (int i = 0; i < 12; i++) {
 * int digito = Character.getNumericValue(codigoEAN.charAt(i));
 * if ((i % 2) == 0) { // Posiciones impares multiplicadas por 1
 * suma += digito;
 * } else { // Posiciones pares multiplicadas por 3
 * suma += digito * 3;
 * }
 * }
 * 
 * // Calcular el dígito de control esperado
 * int digitoControlCalculado = (10 - (suma % 10)) % 10;
 * int digitoControlReal = Character.getNumericValue(codigoEAN.charAt(12));
 * 
 * if (digitoControlCalculado != digitoControlReal) {
 * return "NO";
 * }
 * 
 * // Obtener el país a partir de los primeros dígitos (sin usar Map)
 * String codigoPais = obtenerPais(codigoEAN);
 * return "SI " + codigoPais;
 * }
 * 
 * // Método para determinar el país en un código EAN-13 sin usar Map
 * static String obtenerPais(String codigoEAN) {
 * // Tabla de países con sus códigos de prefijo
 * String[][] paises = {
 * {"0", "EEUU"},
 * {"380", "Bulgaria"},
 * {"50", "Inglaterra"},
 * {"539", "Irlanda"},
 * {"560", "Portugal"},
 * {"70", "Noruega"},
 * {"759", "Venezuela"},
 * {"850", "Cuba"},
 * {"890", "India"}
 * };
 * 
 * // Extraer los primeros 3, 2 o 1 dígitos para encontrar el país
 * for (int i = 3; i > 0; i--) {
 * String codigo = codigoEAN.substring(0, i);
 * for (int j = 0; j < paises.length; j++) {
 * if (paises[j][0].equals(codigo)) {
 * return paises[j][1];
 * }
 * }
 * }
 * 
 * return "Desconocido";
 * }
 * }
 */

/*
 * En el lejano 1952, tres norteamericanos patentaron lo que terminó llamándose
 * código de barras. Consiste en una técnica para representar números (y, en
 * menos ocasiones, letras) mediante una serie de líneas verticales paralelas,
 * con diferentes grosores y separaciones entre ellas. Si bien el primer uso
 * sirvió para identificar de manera automática los vagones de un ferrocarril,
 * hoy los códigos de barras se utilizan en infinidad de lugares, siendo la
 * catalogación de productos la más habitual.
 * 
 * La manera concreta de codificar mediante barras los números y las letras
 * puede ser muy variada, lo que ha llevado a la aparición de diferentes
 * estándares. De todos ellos, el EAN (European Article Number) resulta ser el
 * más extendido. De éste, hay principalmente dos formatos, que se diferencian
 * en el ancho. Existe así el llamado EAN-8, que codifica 8 números, y el
 * EAN-13, que, naturalmente, codifica 13.
 * 
 * 
 * (a) EAN-8
 * 
 * (b) EAN-13
 * Figura 1: Códigos de barras EAN
 * El último dígito del código se utiliza para detección de errores, y se
 * calcula a partir de los demás. Para eso:
 * 
 * Empezando por la derecha (sin contar el dígito de control que se está
 * calculando), se suman los dígitos individuales, multiplicados por un factor:
 * Los dígitos en posiciones impares (empezando a contar por la derecha
 * saltándonos el de control) se multiplican por 3.
 * Los dígitos en posiciones pares se multiplican por 1.
 * Por ejemplo, para el código EAN-8 de la figura la operación a realizar es:
 * 
 * 2 · 3 + 5 · 1 + 9 · 3 + 3 · 1 + 8 · 3 + 5 · 1 + 6 · 3 = 88
 * 
 * El dígito de comprobación es el número que hay que sumar al resultado
 * anterior para llegar a un valor múltiplo de 10. En el ejemplo de EAN-8, para
 * llegar al múltiplo de 10 más cercano por encima del número 88 hay que sumar 2
 * (y llegar al 90). Ten en cuenta que si la suma resulta ser ya múltiplo de 10,
 * el dígito de control será 0.
 * En EAN-13, los primeros dígitos se usan además para identificar al país. A
 * continuación se indica una tabla (parcial) de esos códigos de país.
 * 
 * Código País Código País Código País
 * 0 EEUU 539 Irlanda 759 Venezuela
 * 380 Bulgaria 560 Portugal 850 Cuba
 * 50 Inglaterra 70 Noruega 890 India
 * Entrada
 * La entrada estará formada por una serie de casos de prueba. Cada uno
 * contendrá una sucesión de números pertenecientes a un código de barras EAN-8
 * o EAN-13, incluyendo el dígito de control. Si el número de dígitos es
 * inferior a 8, se asumirá que es un código EAN-8; si es superior a 8 pero
 * inferior a 13, se asumirá EAN-13. En ambos casos, se completarán el resto de
 * dígitos colocando ceros a la izquierda.
 * 
 * El último caso de prueba es seguido por una línea con un 0 que no provoca
 * salida.
 * 
 * Salida
 * Para cada caso de prueba, el programa indicará si el dígito de control es
 * correcto o no. Si lo es, escribirá "SI". En otro caso, escribirá "NO".
 * 
 * Si el código de barras es EAN-13 y correcto, el programa escribirá además el
 * país al que pertenece utilizando la tabla anterior (separado por un espacio).
 * Si el código no aparece en la tabla, el programa mostrará "Desconocido". Ten
 * cuidado al escribir los países; deberás respetar el uso de mayúsculas y
 * minúsculas de la tabla.
 * 
 * Entrada de ejemplo
 * 65839522
 * 65839521
 * 8414533043847
 * 5029365779425
 * 5129365779425
 * 0
 * Salida de ejemplo
 * SI
 * NO
 * SI Desconocido
 * SI Inglaterra
 * NO
 */
