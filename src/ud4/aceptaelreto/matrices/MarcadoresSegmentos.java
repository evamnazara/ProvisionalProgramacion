package ud4.aceptaelreto.matrices;

import java.util.Scanner;

public class MarcadoresSegmentos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Representación de los números del 0 al 9 en un marcador de 7 segmentos
        // Cada número se representa como un entero de 7 bits donde 1 indica encendido y
        // 0 apagado
        int[] segmentos = {
                0b1111110, // 0
                0b0110000, // 1
                0b1101101, // 2
                0b1111001, // 3
                0b0110011, // 4
                0b1011011, // 5
                0b1011111, // 6
                0b1110000, // 7
                0b1111111, // 8
                0b1111011 // 9
        };

        while (true) {
            // Leer la secuencia de números para el marcador
            System.out.println("Ingresa una secuencia de números para el marcador (termina con -1):");
            String input = sc.nextLine();
            String[] numeros = input.split(" ");

            // Si la secuencia contiene solo "-1", terminamos
            if (numeros[0].equals("-1")) {
                break;
            }

            // Convertir los números en enteros, excluyendo el -1
            int[] mensaje = new int[numeros.length - 1];
            for (int i = 0; i < mensaje.length; i++) {
                mensaje[i] = Integer.parseInt(numeros[i]);
            }

            // Inicializar las variables para contar los cambios de luz
            int cambios = 0;
            int[] estadoActual = new int[mensaje.length]; // Estado inicial de todos los dígitos (todos apagados)

            // Procesar cada dígito que entra y sale
            for (int i = 0; i < mensaje.length; i++) {
                // Obtener el número que entra (el nuevo estado)
                int nuevoEstado = segmentos[mensaje[i]];

                // Contar los cambios de encendido y apagado para este dígito
                for (int j = 0; j < 7; j++) {
                    // Comparamos el bit correspondiente del estado actual y el nuevo
                    if (((nuevoEstado >> j) & 1) != ((estadoActual[i] >> j) & 1)) {
                        cambios++; // Si el bit cambió, contamos el cambio
                    }
                }

                // Actualizamos el estado del dígito actual
                estadoActual[i] = nuevoEstado;
            }

            // Imprimir el número total de cambios de luz para este mensaje
            System.out.println("Número total de cambios de luces: " + cambios);
        }

        sc.close();
    }
}

/*
 * Marcadores de 7 segmentos
 * Tiempo máximo: 1,000-5,000 s Memoria máxima: 4096 KiB
 * Los paneles informativos están en todos los sitios. Cuando la tecnología se
 * abarató, los carteles de papel se transformaron en letreros luminosos que
 * muestran palabras que van apareciendo por un lado y saliendo por el otro,
 * como el de la figura:
 * 
 * Rótulo del metro en Asia
 * Cuando uno de estos rótulos se pone en marcha, suele empezar vacío y el texto
 * sale desde el lateral derecho hacia el izquierdo, desplazándose hasta
 * desaparecer.
 * 
 * Su funcionamiento consiste en ir encendiendo y apagando las pequeñas
 * bombillas (LEDs) para dar la sensación de movimiento.
 * 
 * Si en vez de texto necesitamos únicamente mostrar números, el cartel puede
 * ser mucho menos sofisticado utilizando los llamados marcadores de siete
 * segmentos como el siguiente:
 * 
 * Cartel de 7 segmentos
 * En este caso cada número se representa gracias a la combinación
 * encendido/apagado de únicamente 7 segmentos luminosos que permiten
 * representar todos los números:
 * 
 * Todos los números en 7 segmentos
 * La pregunta que nos hacemos es ¿cuántos cambios de luces (cuántos encendidos
 * y apagados) deberán hacerse para hacer pasar por uno de estos carteles un
 * número determinado?
 * 
 * Por ejemplo, para mostrar el 123 en un cartel de 3 dígitos que comienza con
 * todos los leds apagados tendremos:
 * 
 * Ejemplo de cambios al mostar '123' en un panel de 3 dígitos
 * Inicialmente todos los segmentos están apagados.
 * Cuanto entra por la izquierda el 1, se encienden dos segmentos.
 * Al desplazarse el 1 y entrar el 2 se encienden seis segmentos y se apaga
 * otro, lo que hacen un total de 7 cambios.
 * En el siguiente desplazamiento, al entrar el 3, se encienden siete segmentos
 * y se apagan dos.
 * Al desaparecer el 1, el dígito de más a la derecha queda por completo
 * apagado; hay cinco leds que se encienden y siete que se apagan.
 * La desaparición del 2 provoca otro dígito más apagado por completo y un led
 * que se enciende y 6 que se apagan.
 * En el último paso se apagan cinco leds quedándose el marcador completo
 * apagado.
 * Eso hace un total de 42 cambios de luces.
 * 
 * Entrada
 * La entrada contendrá una línea por cada caso de prueba. En cada línea
 * aparecerá una secuencia de enteros (0 ≤ n ≤ 9) separados por espacios que
 * tendrán el mensaje que se quiere mostrar en el marcador; el fin del mensaje
 * se marca con un -1. El ancho del marcador varía con cada caso de prueba y
 * coincide con el número de dígitos total del mensaje, de forma que todos los
 * mensajes serán completamente visibles durante un instante.
 * 
 * La entrada termina cuando nos encontramos ante un marcador en el que no
 * entrará ningún dígito; este marcador no debe generar ninguna salida.
 * 
 * Salida
 * Para cada caso de prueba se mostrará en una línea independiente el número de
 * cambios de estado de las luces del marcador.
 * 
 * Entrada de ejemplo
 * 1 2 3 -1
 * 3 0 5 -1
 * 1 -1
 * -1
 * Salida de ejemplo
 * 42
 * 48
 * 4
 */