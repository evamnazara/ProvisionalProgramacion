/*Montaña Rusa 
MontanaRusa.java 
En una montaña rusa, llamamos "pico" a un punto del recorrido que está más alto que el 
inmediatamente anterior y el inmediatamente siguiente.  
 
Implementa la siguiente función que acepta como parámetro de entrada un array con el 
registro de las alturas en metros del recorrido de una montaña rusa y devuelve el número de 
picos.  

Ten en cuenta que las montañas rusas son circulares, y el punto de inicio de la entrada 
¡podría ser un pico! 
 
Ejemplos: 
●  [4, 10, 3, 2] => 1 pico 
●  [10, 3, 2, 4] => 1 pico 
●  [4, 10, 10, 3, 2] => 0 picos 
 */

package ud4.aceptaelreto.arrays;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class MontanaRusa {

    public static void main(String[] args) {
        int[] alturas = { 4, 10, 10, 3, 2 };
        System.out.println("Número de picos: " + contarPicos(alturas)); // Imprime el número de picos
    }

    /**
     * Esta función cuenta el número de picos en el recorrido de la montaña rusa.
     * Un pico es un punto más alto que el punto anterior y el siguiente.
     * La montaña es circular, por lo que se considera que el primer y último punto
     * están conectados.
     * 
     * @param alturas Un array de enteros que representan las alturas en el
     *                recorrido.
     * @return El número de picos en el recorrido.
     */
    public static int contarPicos(int[] alturas) {
        int picos = 0;
        int n = alturas.length;

        // Recorrer todo el array, considerando la montaña como circular
        for (int i = 0; i < n; i++) {
            // Índices anteriores y siguientes, considerando la circularidad
            int anterior = alturas[(i - 1 + n) % n]; // El anterior de 0 es n-1
            int siguiente = alturas[(i + 1) % n]; // El siguiente de n-1 es 0

            // Verificar si el punto actual es un pico
            if (alturas[i] > anterior && alturas[i] > siguiente) {
                picos++; // Incrementar contador de picos
            }
        }

        return picos; // Retorna el número total de picos
    }

    // Pruebas unitarias para verificar la función contarPicos

    @Test
    void testContarPicos_CasoBase() {
        int[] alturas = { 1, 2, 3, 2, 1 };
        assertEquals(1, contarPicos(alturas));
    }

    @Test
    void testContarPicos_MultiplesPicos() {
        int[] alturas = { 1, 2, 3, 2, 1, 0, 1, 2, 3, 2, 1 };
        assertEquals(2, contarPicos(alturas));
    }

    @Test
    void testContarPicos_PicoAlFinal() {
        int[] alturas = { 1, 2, 3, 4, 5 };
        assertEquals(1, contarPicos(alturas));
    }

    @Test
    void testContarPicos_PicoEnInicio() {
        int[] alturas = { 5, 4, 3, 2, 3, 4, 4 };
        assertEquals(1, contarPicos(alturas));
    }

    @Test
    void testContarPicos_MontañaCircularSinPicos() {
        int[] alturas = { 3, 2, 1, 2, 3 };
        assertEquals(0, contarPicos(alturas));
    }

    @Test
    void testContarPicos_MontañaCircularConVariosPicos() {
        int[] alturas = { 3, 2, 1, 2, 1, 2, 1, 2, 3 };
        assertEquals(2, contarPicos(alturas));
    }
}
