
package ud4.aceptaelreto.arrays;

public class ParrillaDeSalida {

    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada
        java.util.Scanner sc = new java.util.Scanner(System.in);

        // Mientras haya casos de prueba
        while (true) {
            // Leer el número de pilotos
            int n = sc.nextInt();

            // Si n es 0, terminamos la entrada
            if (n == 0) {
                break;
            }

            // Arreglo para almacenar la parrilla de salida (inicialmente de 1 a 26)
            String[] parrillaSalida = new String[26];
            boolean[] ocupado = new boolean[26]; // Para verificar si la posición está ocupada

            // Inicializamos las posiciones de salida con "vacío"
            for (int i = 0; i < 26; i++) {
                parrillaSalida[i] = "Vacío";
            }

            // Procesar los pilotos
            boolean imposible = false; // Flag para verificar si es imposible
            for (int i = 0; i < n; i++) {
                int cambio = sc.nextInt(); // Cambio de posición
                sc.nextLine(); // Consumir el salto de línea
                String nombrePiloto = sc.nextLine(); // Nombre del piloto

                // Calcular la posición de salida original (1 a 26)
                int posicionSalida = 1 + cambio; // Posición inicial de 1 a 26

                // Si la posición de salida es inválida (fuera de los límites 1-26), es
                // imposible
                if (posicionSalida < 1 || posicionSalida > 26 || ocupado[posicionSalida - 1]) {
                    imposible = true;
                    break;
                }

                // Si la posición es válida, colocamos al piloto en esa posición
                parrillaSalida[posicionSalida - 1] = nombrePiloto;
                ocupado[posicionSalida - 1] = true; // Marcamos la posición como ocupada
            }

            // Si encontramos que es imposible, imprimir "IMPOSIBLE"
            if (imposible) {
                System.out.println("IMPOSIBLE");
            } else {
                // Si no es imposible, imprimimos la parrilla de salida
                for (int i = 0; i < 26; i++) {
                    if (!parrillaSalida[i].equals("Vacío")) {
                        System.out.println((i + 1) + " " + parrillaSalida[i]);
                    }
                }
            }

            // Imprimir los separadores
            System.out.println("-----");
        }
    }
}

/*
 * Parrilla de salida
 * 
 * En las retransmisiones de carreras de motociclismo o de automovilismo, es
 * habitual que, junto con la posición de cada piloto, se indique cuánto ha
 * avanzado, o retrocedido, respecto a su posición en la parrilla de salida. Por
 * ejemplo, en el Gran Premio de Montecarlo de Fórmula 1 de 1987, el primero de
 * los seis que ganó Ayrton Senna, la clasificación final fue:
 * 
 * Pos Piloto Salida
 * 1 Ayrton Senna ⇑ 1
 * 2 Nelson Piquet ⇑ 1
 * 3 Michele Alboreto ⇑ 2
 * 4 Gerhard Berger ⇑ 4
 * 5 Jonathan Palmer ⇑ 10
 * 6 Ivan Capelli ⇑ 13
 * 7 Martin Brundle ⇑ 7
 * 8 Teo Fabi ⇑ 4
 * 9 Alain Prost ⇓− 5
 * 10 Satoru Nakajima ⇑ 7
 * 11 René Arnoux ⇑ 11
 * 12 Piercarlo Ghinzani ⇑ 8
 * 13 Pascal Fabre ⇑ 11
 * Hubo además 11 abandonos, un piloto (el español Adrián Campos) que no llegó a
 * salir, y un alemán que fue excluído.
 * 
 * 
 * A partir de la clasificación, ¿eres capaz de reconstruir la parrilla de
 * salida?
 * 
 * Entrada
 * La entrada estará compuesta de múltiples casos de prueba. Cada uno comienza
 * con un número n, indicando el número de pilotos que terminaron la carrera. A
 * continuación vendrán n líneas, con los corredores por orden de llegada. Cada
 * una tendrá un primer número indicando los puestos mejorados (positivos), o
 * empeorados (negativos), respecto a la posición de salida (un 0 indica que la
 * posición no cambió). Después vendrá un único espacio, y el nombre del piloto,
 * que nunca superará las 80 letras, aunque podría contener espacios.
 * 
 * La entrada termina con una carrera sin pilotos.
 * 
 * Salida
 * Para cada caso de prueba el programa escribirá la parrilla de salida que
 * pueda ser reconstruída con los datos disponibles. Se mostrarán los corredores
 * que terminaron la carrera, uno por línea, ordenados de mejor puesto de salida
 * a peor. Para cada uno, se indicará primero la posición en la salida, seguida
 * de su nombre. Las posiciones de salida de pilotos que hayan abandonado no
 * generarán salida. Todas las carreras tenían 26 pilotos en su inicio.
 * 
 * Si los datos del caso de prueba son incoherentes y no se puede reconstruir la
 * parrilla de salida, se escribirá "IMPOSIBLE" (sin las comillas).
 * 
 * Tras cada caso de prueba se escribirá una línea con cinco guiones ("-----").
 * 
 * Entrada de ejemplo
 * 13
 * 1 Ayrton Senna
 * 1 Nelson Piquet
 * 2 Michele Alboreto
 * 4 Gerhard Berger
 * 10 Jonathan Palmer
 * 13 Ivan Capelli
 * 7 Martin Brundle
 * 4 Teo Fabi
 * -5 Alain Prost
 * 7 Satoru Nakajima
 * 11 Rene Arnoux
 * 8 Piercarlo Ghinzani
 * 11 Pascal Fabre
 * 1
 * 100 Pierre Nodoyuna
 * 0
 * Salida de ejemplo
 * 
 * 2 Ayrton Senna
 * 3 Nelson Piquet
 * 4 Alain Prost
 * 5 Michele Alboreto
 * 8 Gerhard Berger
 * 12 Teo Fabi
 * 14 Martin Brundle
 * 15 Jonathan Palmer
 * 17 Satoru Nakajima
 * 19 Ivan Capelli
 * 20 Piercarlo Ghinzani
 * 22 Rene Arnoux
 * 24 Pascal Fabre
 * -----
 * IMPOSIBLE
 * -----
 * 
 */