package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class ConjugarVerbos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Introduce el verbo que quieras conjugar (o 'fin' para terminar):");
            String verboInfinitivo = scanner.nextLine();

            // Finalizar si el usuario ingresa "fin"
            if (verboInfinitivo.equalsIgnoreCase("fin")) {
                System.out.println("Programa finalizado.");
                break;
            }

            // Verificar que el verbo termine en "ar", "er" o "ir"
            if (!verboInfinitivo.endsWith("ar") && !verboInfinitivo.endsWith("er") && !verboInfinitivo.endsWith("ir")) {
                System.out.println(
                        "Verbo inválido, por favor introduce un verbo en infinitivo con terminación 'ar', 'er' o 'ir'.");
                continue;
            }

            // Conjugar el verbo en presente
            String[] conjugaciones = conjugarPresente(verboInfinitivo);

            // Imprimir las conjugaciones
            if (conjugaciones != null) {
                System.out.println("Conjugación del verbo " + verboInfinitivo + " en presente:");
                for (String conjugacion : conjugaciones) {
                    System.out.println(conjugacion);
                }
            } else {
                System.out.println("Error en la conjugación.");
            }
        }

        scanner.close();
    }

    public static String[] conjugarPresente(String verbo) {
        // Identificar la raíz del verbo
        String raiz = "";
        String terminacion = "";

        if (verbo.endsWith("ar")) {
            raiz = verbo.substring(0, verbo.length() - 2);
            terminacion = "ar";
        } else if (verbo.endsWith("er")) {
            raiz = verbo.substring(0, verbo.length() - 2);
            terminacion = "er";
        } else if (verbo.endsWith("ir")) {
            raiz = verbo.substring(0, verbo.length() - 2);
            terminacion = "ir";
        }

        // Conjugar el verbo dependiendo de su terminación
        String[] conjugaciones = new String[6];

        if (terminacion.equals("ar")) {
            conjugaciones[0] = "Yo " + raiz + "o";
            conjugaciones[1] = "Tú " + raiz + "as";
            conjugaciones[2] = "Él/ella " + raiz + "a";
            conjugaciones[3] = "Nosotros " + raiz + "amos";
            conjugaciones[4] = "Vosotros " + raiz + "áis";
            conjugaciones[5] = "Ellos " + raiz + "an";
        } else if (terminacion.equals("er")) {
            conjugaciones[0] = "Yo " + raiz + "o";
            conjugaciones[1] = "Tú " + raiz + "es";
            conjugaciones[2] = "Él/ella " + raiz + "e";
            conjugaciones[3] = "Nosotros " + raiz + "emos";
            conjugaciones[4] = "Vosotros " + raiz + "éis";
            conjugaciones[5] = "Ellos " + raiz + "en";
        } else if (terminacion.equals("ir")) {
            conjugaciones[0] = "Yo " + raiz + "o";
            conjugaciones[1] = "Tú " + raiz + "es";
            conjugaciones[2] = "Él/ella " + raiz + "e";
            conjugaciones[3] = "Nosotros " + raiz + "imos";
            conjugaciones[4] = "Vosotros " + raiz + "ís";
            conjugaciones[5] = "Ellos " + raiz + "en";
        }

        return conjugaciones;
    }
}

/*
 * 1. (2) Implementa una función que dado un verbo en infinitivo lo conjugue en
 * presente y
 * devuelva un array de String con los resultados de la conjugación para cada
 * una de las 6
 * personas verbales.
 * 
 * String[] conjugarPresente(String verbo);
 * 
 * Si el parámetro verbo no tiene una terminación válida la función devolverá
 * null.
 * 
 * 2. (1) Crea un programa principal que acepte por teclado verbos en infinitivo
 * y muestre por
 * pantalla su conjugación en tiempo presente, añadiendo al inicio los
 * pronombres adecuados.
 * Si el verbo introducido no corresponde a un infinitivo con una terminación
 * adecuada el
 * programa mostrará el mensaje de error correspondiente.
 * 
 * El programa finalizará cuando se introduzca la palabra “fin”.
 */