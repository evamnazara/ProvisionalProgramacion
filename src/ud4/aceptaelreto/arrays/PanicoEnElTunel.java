package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class PanicoEnElTunel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al sistema de ayuda en el túnel.");

        while (scanner.hasNext()) {
            // Leer la descripción del túnel
            System.out.println("\nIntroduce la descripción del túnel:");
            String tunel = scanner.next();
            long longitudTunel = tunel.length();

            // Leer el número de consultas
            System.out.println("Introduce el número de consultas:");
            long consultas = scanner.nextLong();

            // Arrays para almacenar las posiciones de los teléfonos más cercanos a la
            // izquierda y derecha
            long[] izquierda = new long[(int) longitudTunel];
            long[] derecha = new long[(int) longitudTunel];

            // Llenar el array de distancias a los teléfonos desde la izquierda
            long ultimaIzquierda = -1; // No hay teléfono a la izquierda inicialmente
            for (long i = 0; i < longitudTunel; i++) {
                if (tunel.charAt((int) i) == 'T') {
                    ultimaIzquierda = i;
                }
                izquierda[(int) i] = ultimaIzquierda;
            }

            // Llenar el array de distancias a los teléfonos desde la derecha
            long ultimaDerecha = -1; // No hay teléfono a la derecha inicialmente
            for (long i = longitudTunel - 1; i >= 0; i--) {
                if (tunel.charAt((int) i) == 'T') {
                    ultimaDerecha = i;
                }
                derecha[(int) i] = ultimaDerecha;
            }

            // Procesar las consultas
            System.out.println("Introduce las posiciones de los accidentados:");
            for (long i = 0; i < consultas; i++) {
                long posicion = scanner.nextLong() - 1; // Convertimos a índice base 0

                // Si la posición actual tiene un teléfono
                if (tunel.charAt((int) posicion) == 'T') {
                    System.out.println("AQUI");
                    continue;
                }

                // Obtener distancia al teléfono más cercano por la izquierda
                long distanciaIzquierda = (izquierda[(int) posicion] == -1) ? longitudTunel
                        : posicion - izquierda[(int) posicion];
                // Obtener distancia al teléfono más cercano por la derecha
                long distanciaDerecha = (derecha[(int) posicion] == -1) ? longitudTunel
                        : derecha[(int) posicion] - posicion;

                // Obtener distancia a las salidas
                long distanciaPenínsula = posicion; // Desde la posición hasta el inicio (índice 0)
                long distanciaIslas = longitudTunel - 1 - posicion; // Desde la posición hasta el final

                // Decidir hacia dónde correr
                if (distanciaIzquierda == longitudTunel && distanciaDerecha == longitudTunel) {
                    // No hay teléfonos en el túnel, ir hacia la salida más cercana
                    if (distanciaPenínsula <= distanciaIslas) {
                        System.out.println("PENINSULA");
                    } else {
                        System.out.println("ISLAS");
                    }
                } else if (distanciaIzquierda < distanciaDerecha) {
                    System.out.println("PENINSULA");
                } else if (distanciaDerecha < distanciaIzquierda) {
                    System.out.println("ISLAS");
                } else { // Si ambas distancias son iguales
                    // Decidir por proximidad a la salida más cercana
                    if (distanciaPenínsula < distanciaIslas) {
                        System.out.println("PENINSULA");
                    } else if (distanciaIslas < distanciaPenínsula) {
                        System.out.println("ISLAS");
                    } else {
                        System.out.println("PENINSULA"); // En caso de empate total, ir a la península
                    }
                }
            }
        }

        // Cerrar el scanner
        scanner.close();
        System.out.println("Fin del programa.");
    }
}

/*
 * 
 * Pánico en el túnel
 * Tiempo máximo: 1,000-4,000 s Memoria máxima: 10240 KiB
 * En el último Consejo de Ministros se ha decidido que se va a poner en marcha
 * la construcción de un túnel que va a unir la península ibérica con las islas
 * Baleares. Si se pudo unir Europa con Inglaterra el siglo pasado, el gobierno
 * tiene claro que nosotros podremos hacer un túnel similar, como experiencia
 * piloto para un proyecto aún más ambicioso que uniría también las islas
 * Canarias.
 * 
 * Uno de los temas que más preocupan es la seguridad, por lo que se instalarán
 * un número aún por determinar de teléfonos de emergencia (eso sí, nunca serán
 * más de 500) de forma que ante algún accidente la gente pueda salir
 * rápidamente de sus coches y notificarlo en el teléfono más cercano.
 * 
 * No obstante existe el problema de que los accidentados, a la hora de salir de
 * sus vehículos y echar a correr hacia ese teléfono, duden sobre hacia qué lado
 * ir pues en esos momentos de pánico se pierde la capacidad de decisión y no se
 * tiene la agilidad mental suficiente para elegir bien.
 * 
 * De lo que se trata, pues, es de hacer una pequeña aplicación para móvil que
 * se pueda usar dentro del túnel y que, dada la localización actual de la
 * persona, le diga hacia qué lado tiene que correr, si hacia el lado que le
 * acerca hacia la península o hacia el lado que le acerca a las islas.
 * 
 * Como el túnel está aún por construir, crearemos y probaremos el núcleo del
 * sistema utilizando distintas descripciones de túneles. Cada descripción
 * consiste en discretizar el túnel en distintas secciones en las que puede (o
 * no) haber un teléfono de emergencia.
 * 
 * Entrada
 * La entrada estará compuesta por varios casos de prueba. Cada caso de prueba
 * tendrá una primera línea con la descripción del túnel. Esa línea tendrá un
 * carácter por cada sección del túnel (que puede ser de hasta 1.000.000
 * secciones) donde 'T' indica que en esa sección hay un teléfono, y '.' indica
 * ausencia de teléfono. El primer carácter de la línea se corresponde con la
 * sección "del lado de la península".
 * 
 * Tras la descripción del túnel, aparecerá un número n
 * con la cantidad de consultas que vienen a continuación. Le siguen n
 * líneas, cada una con un entero que indica en qué sección se encuentra el
 * accidentado (entre 1 y el número de secciones total, siendo 1 la primera
 * sección en la ruta desde la península hacia las islas).
 * 
 * Salida
 * Por cada caso de prueba se escribirán n
 * líneas, una por consulta, donde se indicará "PENINSULA" si el accidentado
 * debe correr hacia el lado de la península o "ISLAS" si debe ir en la
 * dirección contraria. Si no hace falta correr porque estamos en una sección
 * con teléfono, se escribirá "AQUI". Ten en cuenta que:
 * 
 * Si se está más cerca de una de las salidas que de un teléfono, se preferirá
 * correr hacia la salida.
 * Si los teléfonos más próximos de ambos lados están a la misma distancia,
 * preferiremos ir hacia aquel que esté más cerca de una de las salidas del
 * túnel.
 * Si en el escenario anterior vuelve a haber empate, se irá hacia la península.
 * Entrada de ejemplo
 * .T...T.T.
 * 4
 * 2
 * 3
 * 4
 * 7
 * ...
 * 1
 * 2
 * Salida de ejemplo
 * 
 * AQUI
 * PENINSULA
 * PENINSULA
 * ISLAS
 * PENINSULA
 */