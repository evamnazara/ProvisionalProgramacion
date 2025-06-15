package ud4.aceptaelreto.stringsycaracteres;

public class PistasAterrizaje {

    public static void main(String[] args) {
        // Definimos algunos casos de prueba
        String[] pistas = { "09", "09L", "09R", "09C" };

        // Procesamos cada pista
        for (String pista : pistas) {
            // Llamamos a la función para obtener el otro extremo de la pista
            String otroExtremo = obtenerOtroExtremo(pista);
            // Imprimimos el resultado
            System.out.println(otroExtremo);
        }
    }

    // Función que recibe el nombre de la pista y devuelve el nombre del otro
    // extremo
    public static String obtenerOtroExtremo(String pista) {
        // Separamos la letra (si la hay) del número de la pista
        String letra = "";
        int numeroPista = Integer.parseInt(pista.substring(0, 2));

        // Si la pista tiene letra (L, C, R), la separamos
        if (pista.length() > 2) {
            letra = pista.substring(2);
        }

        // Calculamos el número de la pista en el otro extremo
        int numeroOpuesto = (numeroPista + 18) % 36;
        if (numeroOpuesto == 0) {
            numeroOpuesto = 36; // El número 0 no es válido, lo cambiamos por 36
        }

        // Convertimos el número de la pista a dos dígitos
        String numeroPistaOpuesta = String.format("%02d", numeroOpuesto);

        // Convertimos la letra si es necesario
        String letraOpuesta = obtenerLetraOpuesta(letra);

        // Concatenamos el número de la pista opuesta con la letra
        return numeroPistaOpuesta + letraOpuesta;
    }

    // Función que convierte la letra (L, C, R) a la opuesta
    public static String obtenerLetraOpuesta(String letra) {
        if (letra.equals("L")) {
            return "R";
        } else if (letra.equals("R")) {
            return "L";
        } else {
            return "C"; // Si es "C" o no tiene letra, se mantiene como "C"
        }
    }
}

// número_opuesto = (número_pista + 18) % 36

/*
 * Pistas de aterrizaje
 * 
 * Las pistas de aterrizaje sirven para que los aviones tomen tierra y frenen o
 * aceleren para despegar1. Todos los pilotos de aeronaves saben de la
 * importancia de la dirección y velocidad del viento en esos dos momentos
 * críticos. Prueba de ello es, por ejemplo, que para que los aviones puedan
 * despegar de los portaviones, el barco se orienta en contra del viento y
 * avanza a la máxima velocidad para conseguir que la velocidad aparente del
 * viento supere un cierto umbral de seguridad.
 * 
 * En los aeropuertos, las pistas de aterrizaje y despegue no se pueden girar
 * para que su orientación sea la correcta. Eso significa que dependiendo de la
 * dirección del viento de cada momento, una pista orientada al sur puede ser
 * muy adecuada o insegura.
 * 
 * Tanto es así que las numeraciones de las pistas de un aeropuerto, lejos de
 * ser consecutivas por fecha de construcción o algo parecido, codifican la
 * orientación que tienen, para que a los controladores y pilotos les sea fácil
 * saber con qué viento contarán en el momento del aterrizaje y despegue.
 * 
 * En concreto, las pistas se nombran con un número entre 01 y 362, que divide
 * los 360 grados en 36 bloques de 10 grados. Así, en la pista 09 se aterriza
 * viniendo desde el este (90 grados), mientras que en la pista 36 se hace desde
 * el norte (360 grados).
 * 
 * Dado que las pistas pueden utilizarse en ambos sentidos, la orientación
 * depende del lado por el que se aproxime. Es por esto que la pista 09 es
 * numerada en el otro extremo como 27, y la 36 es la 18.
 * 
 * Por otro lado, si un aeropuerto tiene varias pistas en la misma orientación,
 * a cada una se le añade una letra indicando su posición relativa cuando nos
 * aproximamos a ella. Así, se puede añadir una L para indicar que es la pista
 * más a la izquierda, una C para la pista central o la R para la pista más a la
 * derecha3 (en nuestro caso, ignoraremos la posibilidad de que haya más de 3
 * pistas con la misma orientación). Como es lógico, la pista que está a la
 * izquierda aproximándonos por un lado se convierte en la pista más a la
 * derecha viniendo desde el lado contrario. Es por esto que 18L se convierte en
 * 36R, por ejemplo.
 * 
 * Dada la codificación de una pista en uno de sus extremos, ¿cuál es en el
 * otro?
 * 
 * Entrada
 * La entrada estará compuesta por varias líneas, cada una con el nombre válido
 * de un extremo de una pista de aterrizaje. Los números siempre tendrán dos
 * dígitos y la letra, de aparecer, estará en mayúscula.
 * 
 * Salida
 * Para cada línea de la entrada se escribirá una línea con el nombre del otro
 * extremo de la pista de aterrizaje.
 * 
 * Entrada de ejemplo
 * 09
 * 09L
 * 09R
 * 09C
 * Salida de ejemplo
 * 27
 * 27R
 * 27L
 * 27C
 * 
 */
