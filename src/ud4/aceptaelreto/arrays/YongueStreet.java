package ud4.aceptaelreto.arrays;

public class YongueStreet {

    public static void main(String[] args) {
        // Usamos el scanner para leer la entrada de datos
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Leer la primera línea (estado inicial de la calle)
        System.out.println("Ingrese el estado de Yonge Street (ejemplo: A.|.B): ");
        String calle = scanner.nextLine(); // Leer la situación de Yonge Street

        // Leer la segunda línea (las consultas)
        System.out.println("Ingrese el número de consultas seguido de las posiciones (ejemplo: 5 1 2 3 4 5): ");
        String consultaLine = scanner.nextLine();
        String[] consulta = consultaLine.split(" "); // Separar la línea de consultas

        // Obtener el número de consultas (en este caso no se hace parseo explícito)
        String numeroDeConsultasStr = consulta[0]; // El primer valor es el número de consultas
        int numeroDeConsultas = 0;

        // Convertir el string del número de consultas a un entero de forma manual
        for (int i = 0; i < numeroDeConsultasStr.length(); i++) {
            numeroDeConsultas = numeroDeConsultas * 10 + (numeroDeConsultasStr.charAt(i) - '0');
        }

        // Crear un array para almacenar las posiciones de las consultas
        int[] posicionesConsultadas = new int[numeroDeConsultas];
        for (int i = 0; i < numeroDeConsultas; i++) {
            String consultaPosStr = consulta[i + 1]; // Tomamos cada posición como string
            int posicion = 0;

            // Convertir manualmente la posición a entero
            for (int j = 0; j < consultaPosStr.length(); j++) {
                posicion = posicion * 10 + (consultaPosStr.charAt(j) - '0');
            }

            // Almacenamos la posición ajustada a índice de array (base 0)
            posicionesConsultadas[i] = posicion - 1;
        }

        // Convertimos la calle a un array de caracteres para poder modificarla
        char[] calleArray = new char[calle.length()];
        for (int i = 0; i < calle.length(); i++) {
            calleArray[i] = calle.charAt(i); // Copiamos cada carácter de la calle
        }

        // Imprimir el estado inicial de la calle
        System.out.println("Estado inicial de Yonge Street: ");
        System.out.println(calle);

        // Procesar los vehículos
        for (int i = 0; i < calleArray.length; i++) {
            // Si encontramos un vehículo, lo movemos hacia el semáforo más cercano
            if (Character.isLetter(calleArray[i])) {
                // Buscamos el semáforo más cercano hacia la derecha
                int semaforoPos = -1;
                for (int j = i + 1; j < calleArray.length; j++) {
                    if (calleArray[j] == '|') {
                        semaforoPos = j;
                        break;
                    }
                }

                // Si encontramos un semáforo, el vehículo se coloca delante de él
                if (semaforoPos != -1) {
                    for (int k = semaforoPos - 1; k >= i; k--) {
                        // Si hay una posición libre, colocamos el vehículo allí
                        if (calleArray[k] == '.') {
                            calleArray[k] = calleArray[i];
                            calleArray[i] = '.'; // El vehículo deja su posición original
                            break;
                        }
                    }
                }
            }
        }

        // Imprimir el estado final de la calle
        System.out.println("Estado final de Yonge Street después de que los vehículos se detengan: ");
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < calleArray.length; i++) {
            resultado.append(calleArray[i]);
        }
        System.out.println(resultado.toString());

        // Para cada consulta, imprimimos el contenido de la posición indicada
        System.out.println("Resultados para las consultas:");

        for (int i = 0; i < numeroDeConsultas; i++) {
            // Para cada posición consultada, mostrar lo que hay en esa posición
            int posicion = posicionesConsultadas[i];
            char contenido = calleArray[posicion];
            System.out.print(contenido + " "); // Mostrar la respuesta de la consulta
        }

        // Cerrar el scanner después de usarlo
        scanner.close();
    }
}

/*
 * 
 * Yonge Street
 * Tiempo máximo: 1,000-4,000 s Memoria máxima: 4096 KiB
 * Señal de Yonge Street, Toronto, Canadá
 * Aunque no es su capital, Toronto es la ciudad más grande de Canadá y su
 * centro financiero. Además, está dentro del Libro Guiness de los Récords por
 * tener la calle más larga del mundo, llamada Yonge Street, con una longitud
 * total de 86 kilómetros.
 * 
 * Todavía está por incorporar a ese mismo libro el nombre de la primera persona
 * que consiga recorrerla entera sin que le pille ningún semáforo en rojo. Y,
 * con semejante tamaño, es poco probable que alguien lo consiga antes de que se
 * invente el teletransporte.
 * 
 * Aun así, es espectacular ver, desde un extremo, como todos los semáforos
 * cambian de color hasta donde alcanza la vista; y como todos los coches pisan
 * el freno, llenando 86 kilómetros de luces rojas.
 * 
 * Dadas las posiciones de todos los vehículos y de los semáforos en el momento
 * en el que éstos se ponen en rojo, ¿eres capaz de saber dónde terminará parado
 * cada uno haciendo cola hasta que los semáforos vuelvan a estar verdes?
 * 
 * Entrada
 * Cada caso de prueba comienza con una línea con hasta 200.000 caracteres
 * representando la situación de Yonge Street en el momento en el que todos sus
 * semáforos se cierran. Un carácter '|' indica la posición de un semáforo, un
 * carácter '.' indica una posición libre, y las letras del alfabeto inglés
 * representan vehículos de diferente tipo (automóvil, furgoneta, camión,
 * tractor… amigo que vas en burro).
 * 
 * Tras esa línea aparece otra, con consultas sobre el estado final de la calle.
 * El primer número, n, indica cuántas consultas vienen a continuación, en esa
 * misma línea, separadas por espacio. Cada una consiste en el número de
 * posición por la que se pregunta. La primera posición de la calle, más a la
 * izquierda en la entrada, se corresponde con el número 1.
 * 
 * Salida
 * Para cada consulta de los casos de prueba se escribirá el contenido de esa
 * posición una vez que todos los vehículos han parado en sus posiciones a la
 * espera de que se abran los semáforos. Las respuestas de cada caso de prueba
 * se darán todas en la misma línea, separadas por espacio. No debe aparecer un
 * espacio tras la última respuesta.
 * 
 * Los vehículos se mueven de izquierda a derecha hasta llegar a un semáforo,
 * momento en el que se detendrán, delante de él, formando una fila. Canadá es
 * un país tranquilo, y nadie se adelanta mientras conduce.
 * 
 * Entrada de ejemplo
 * A.|.B
 * 5 1 2 3 4 5
 * AB..C|
 * 5 6 5 4 3 1
 * Salida de ejemplo
 * . A | . .
 * | C B A .
 */
