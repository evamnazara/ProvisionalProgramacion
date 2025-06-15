package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class MichaelPatoDonald {
    public static void main(String[] args) {
        Scanner entradaUsuario = new Scanner(System.in);

        System.out.println("Bienvenido al programa de coincidencia de cumpleaños.");

        while (true) {
            // Leer el número de personas en el grupo
            System.out.println("\nIntroduce el número de personas en el grupo:");
            int cantidadPersonas = entradaUsuario.nextInt();

            // Si el número de personas es 0, terminamos el programa
            if (cantidadPersonas == 0) {
                System.out.println("Fin de los casos de prueba.");
                break;
            }

            // Crear un array para almacenar las fechas de nacimiento (solo día y mes)
            String[] fechasNacimiento = new String[cantidadPersonas];

            // Leer las fechas de nacimiento
            System.out.println("Introduce las fechas de nacimiento en formato día/mes/año:");
            for (int i = 0; i < cantidadPersonas; i++) {
                String fechaCompleta = entradaUsuario.next(); // Leemos la fecha como String
                fechasNacimiento[i] = extraerDiaMes(fechaCompleta); // Extraemos solo día/mes
            }

            // Mostrar las fechas de nacimiento procesadas
            System.out.print("Fechas registradas (día/mes): ");
            for (int i = 0; i < cantidadPersonas; i++) {
                System.out.print(fechasNacimiento[i] + " ");
            }
            System.out.println();

            // Verificar si hay cumpleaños repetidos
            boolean hayCoincidencia = verificarCoincidencias(fechasNacimiento, cantidadPersonas);

            // Imprimir el resultado según haya coincidencias o no
            if (hayCoincidencia) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        }

        entradaUsuario.close();
    }

    /**
     * Extrae el día y mes de una fecha en formato "día/mes/año".
     * 
     * @param fechaCompleta Fecha completa en formato "día/mes/año".
     * @return String con solo "día/mes".
     */
    public static String extraerDiaMes(String fechaCompleta) {
        int longitud = fechaCompleta.length();
        String diaMes = "";

        // Recorremos la cadena hasta el segundo '/'
        for (int i = 0; i < longitud; i++) {
            char caracter = fechaCompleta.charAt(i);
            if (caracter == '/') {
                // Encontramos el primer '/', seguimos agregando hasta el segundo '/'
                diaMes += caracter;
                for (int j = i + 1; j < longitud; j++) {
                    diaMes += fechaCompleta.charAt(j);
                    if (fechaCompleta.charAt(j) == '/') {
                        break; // Al encontrar el segundo '/', terminamos
                    }
                }
                break;
            } else {
                diaMes += caracter;
            }
        }

        return diaMes; // Retornamos solo "día/mes"
    }

    /**
     * Verifica si hay coincidencias en las fechas de nacimiento del grupo.
     * 
     * @param fechasNacimiento Array con las fechas en formato "día/mes".
     * @param cantidadPersonas Número total de personas en el grupo.
     * @return true si hay coincidencias, false si todas son únicas.
     */
    public static boolean verificarCoincidencias(String[] fechasNacimiento, int cantidadPersonas) {
        // Comparar cada fecha con todas las demás
        for (int i = 0; i < cantidadPersonas - 1; i++) {
            for (int j = i + 1; j < cantidadPersonas; j++) {
                if (fechasNacimiento[i].equals(fechasNacimiento[j])) {
                    return true; // Hay coincidencia
                }
            }
        }
        return false; // No hay coincidencias
    }
}

/*
 * Michael J. Fox y el Pato Donald
 * Tiempo máximo: 1,000-2,000 s Memoria máxima: 4096 KiB
 * El pato Donald junto a un DeLorean
 * Si cogemos a los actores protagonistas de una película como la emblemática
 * Regreso al Futuro y analizamos sus fechas de cumpleaños, vemos que ninguna de
 * ellas coincide. Es decir, aunque durante el rodaje celebraron algún que otro
 * cumpleaños, no hubo ningún día en el que soplaran las velas dos actores.
 * 
 * La cosa cambia si a ese elenco añadimos, por ejemplo, los personajes clásicos
 * de Disney. Resulta que tanto Michael J. Fox (que interpretaba a Marty McFly)
 * como el pato Donald celebran su cumpleaños el día 9 de junio1.
 * 
 * En realidad, no es tan raro que cuando se junta un grupo de gente haya dos
 * personas que cumplan años el mismo día. Es lo que se conoce como la paradoja
 * del cumpleaños. Con un sencillo cálculo se puede comprobar que si juntamos a
 * 23 personas elegidas al azar, la probabilidad de que haya dos que coincidan
 * es de más del 50%. Si subimos a 57 personas, la probabilidad se dispara hasta
 * el 99%.
 * 
 * Entrada
 * La entrada está formada por distintos casos de prueba, cada uno en dos
 * líneas.
 * 
 * La primera línea de cada caso de prueba contiene el número de personas en el
 * grupo. La segunda contiene las fechas de nacimiento de cada uno de ellos, con
 * el formato día/mes/año. Todas las fechas serán válidas y estarán comprendidas
 * entre el año 1600 y el 2000.
 * 
 * La entrada termina con una línea con un 0 que no debe procesarse.
 * 
 * Salida
 * Por cada caso de prueba se escribirá SI si hay algún cumpleaños repetido y NO
 * en caso contrario.
 * 
 * Entrada de ejemplo
 * 4
 * 9/6/1961 22/10/1938 31/5/1961 20/4/1964
 * 5
 * 9/6/1961 22/10/1938 31/5/1961 20/4/1964 9/6/1934
 * 0
 * Salida de ejemplo
 * 
 * NO
 * SI
 * 
 */