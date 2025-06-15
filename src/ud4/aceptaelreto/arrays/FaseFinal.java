package ud4.aceptaelreto.arrays;

import java.util.*;

public class FaseFinal {

    public static void main(String[] args) {
        // Crear un scanner para leer la entrada
        Scanner sc = new Scanner(System.in);

        // Leer el número de elementos en el arreglo
        int n = sc.nextInt();

        // Crear un arreglo para los números
        int[] nums = new int[n];

        // Leer los números en el arreglo
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Llamar a la función para calcular los múltiplos
        int resultado = contarMultiples(nums, n);

        // Imprimir el resultado
        System.out.println(resultado);

        // Cerrar el scanner
        sc.close();
    }

    // Función para contar cuántos números son múltiplos de otros
    public static int contarMultiples(int[] nums, int n) {
        // Contador de múltiplos
        int contador = 0;

        // Recorrer todos los números
        for (int i = 0; i < n; i++) {
            // Comprobar si el número nums[i] es múltiplo de algún otro
            for (int j = 0; j < n; j++) {
                // Nos aseguramos de no comparar un número consigo mismo
                if (i != j && nums[i] % nums[j] == 0) {
                    // Si nums[i] es múltiplo de nums[j], incrementamos el contador
                    contador++;
                    break; // No es necesario seguir buscando más múltiplos para nums[i]
                }
            }
        }

        return contador;
    }
}

/*
 * Fase final
 * Tiempo máximo: 3,000 s Memoria máxima: 4096 KiB
 * El formato de la competición de un mundial deportivo tiene normalmente dos
 * fases. La primera es la llamada fase de grupos. En ella los equipos se
 * organizan en varios grupos de pocos equipos, en los que juegan todos contra
 * todos en pequeñas liguillas que determinan qué equipos pasan a la segunda
 * ronda.
 * 
 * La segunda ronda, o fase final, se organiza como un torneo clásico
 * eliminatorio, desde octavos de final hasta la final. El ganador de cada
 * partido pasa a la siguiente fase y el perdedor queda eliminado. Gana el
 * equipo que más goles marca y si el partido termina empatado, se juega un
 * tiempo suplementario o incluso una ronda de tiros desde el punto de penalty.
 * Por ejemplo, en la Copa Mundial Femenina de Fútbol de 2023 hubo 16 equipos en
 * la fase final, que compitieron en octavos, cuartos, semifinal y final. El
 * equipo español ganó sus cuatro partidos (uno de ellos durante el tiempo
 * suplementario), y se alzó con el campeonato.
 * 
 * Cuadro clasificatorio de la fase final del Mundial de Fútbol Femenino de 2023
 * Dados los equipos clasificados a la fase final y el resultado de todos los
 * encuentros, ¿quién gana?
 * 
 * Entrada
 * Cada caso de prueba comienza con un número 2 ≤ N ≤ 64, siempre potencia
 * exacta de 2, con el número de equipos clasificados a la fase final de un
 * torneo. A continuación aparecen, quizá en varias líneas, los nombres de los N
 * equipos. Cada nombre es una única palabra de no más de 30 letras inglesas
 * mayúsculas y minúsculas.
 * 
 * Tras los nombres vienen los resultados de los N/2 encuentros de la primera
 * fase, en el mismo orden que los equipos, de manera que, por ejemplo, el
 * primer resultado se corresponde con el enfrentamiento de los dos primeros
 * equipos. Tras los resultados de la primera fase, se proporcionan los N/4
 * resultados de la segunda fase, siguiendo el mismo orden, hasta llegar al
 * resultado de la final. Se garantiza que ningún equipo marca más de 20 goles y
 * que nunca hay empate.
 * 
 * La entrada termina con un torneo sin equipos, que no debe procesarse.
 * 
 * Salida
 * Por cada caso de prueba el programa escribirá el nombre del equipo ganador.
 * 
 * Entrada de ejemplo
 * 16
 * Switzerland Spain Netherlands SouthAfrica Japan Norway Sweden UnitedStates
 * Australia Denmark France Morocco England Nigeria Colombia Jamaica
 * 1 5 2 0 3 1 5 4 2 0 4 0 4 2 1 0 2 1 1 2 7 6 2 1 2 1 1 3 1 0
 * 0
 * Salida de ejemplo
 * 
 * Spain
 */