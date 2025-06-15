package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class YoSoyTu {

    public static void main(String[] args) {
        // Crear un scanner para leer la entrada
        Scanner sc = new Scanner(System.in);

        // Leer el número de casos de prueba
        int numCasos = sc.nextInt();
        sc.nextLine(); // Para consumir el salto de línea después del número de casos

        // Procesar cada caso de prueba
        for (int i = 0; i < numCasos; i++) {
            // Leer el nombre del personaje
            String nombre = sc.nextLine();
            // Leer el parentesco
            String parentesco = sc.nextLine();

            // Comprobar si es el caso "Luke, padre" exactamente
            if (nombre.equals("Luke") && parentesco.equals("padre")) {
                System.out.println("TOP SECRET");
            } else {
                // Si no es el caso especial, generar la frase normal
                System.out.println(nombre + ", yo soy tu " + parentesco);
            }
        }

        sc.close();
    }
}

/*
 * 
 * Darth Vader
 * El estreno de las películas de la saga La Guerra de las Galaxias ha generado
 * siempre mucha expectación. Cuando se supo que en El Imperio Contraataca se
 * desvelaría un importante parentesco, se dispararon los rumores y las noticias
 * falsas.
 * 
 * Para confundir a los especuladores (y crear más interés), la productora
 * decidió filtrar infinidad de frases del estilo "A, yo soy tu B", donde "A"
 * era un nombre, y "B" un parentesco.
 * 
 * Para conseguir crear a tiempo una magnitud considerable de noticias falsas,
 * se recurrió a programadores para automatizar la tarea. Éstos recibían listas
 * de los nombres y parentescos, y tenían que generar la frase correspondiente
 * de acuerdo a la plantilla.
 * 
 * Por miedo a que en aquellas listas se filtrara la pareja real de la película,
 * "Luke" y "padre", los programas escribían TOP SECRET si se la encontraban.
 * Pero en 1980 no había tanta preocupación por la seguridad como hay hoy, y
 * solo hacían el cambio si ambas palabras coincidían exactamente, incluídas las
 * mayúsculas y minúsculas.
 * 
 * Entrada
 * El programa deberá leer, de la entrada estándar, un primer número indicando
 * cuántos casos de prueba vendrán a continuación.
 * 
 * Cada caso de prueba constará de dos líneas, ambas de no más de 100 caracteres
 * sin espacios. La primera contendrá el nombre del personaje y la segunda el
 * parentesco.
 * 
 * Salida
 * Para cada caso de prueba, el programa generará la frase que se debía filtrar
 * a la prensa siguiendo el esquema descrito, salvo que el personaje y el
 * parentesco sean, exactamente, "Luke" y "padre" respectivamente. En ese caso
 * se escribirá "TOP SECRET". Esta comparación será sensible a mayúsculas.
 * 
 * Entrada de ejemplo
 * 4
 * C-3PO
 * creador
 * Luke
 * padre
 * Princesa
 * Principe
 * Luke
 * Padre
 * Salida de ejemplo
 * C-3PO, yo soy tu creador
 * TOP SECRET
 * Princesa, yo soy tu Principe
 * Luke, yo soy tu Padre
 */