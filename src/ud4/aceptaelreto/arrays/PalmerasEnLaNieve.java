package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class PalmerasEnLaNieve {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leer el número de casos de prueba
        System.out.println("Casos de prueba: ");
        int casosDePrueba = sc.nextInt();

        for (int caso = 0; caso < casosDePrueba; caso++) {
            // Leer el peso de la nieve
            System.out.println("Peso de la nieve: ");
            int pesoNieve = sc.nextInt();

            // Leer el número de palmeras
            System.out.println("Número de palmeras: ");
            int numeroPalmeras = sc.nextInt();

            // Leer los pesos que pueden soportar las palmeras
            int[] palmeras = new int[numeroPalmeras];
            for (int i = 0; i < numeroPalmeras; i++) {
                System.out.println("Peso que soporta la palmera " + (i + 1));
                palmeras[i] = sc.nextInt();
            }

            // Variables para la ventana deslizante
            int inicioTramo = 0;
            int maxLongitud = 0;
            int palmerasEnPie = 0;

            // Recorremos las palmeras con la ventana deslizante
            for (int finVentana = 0; finVentana < numeroPalmeras; finVentana++) {
                // Si la palmera actual es capaz de resistir la nieve, se mantiene en pie
                if (palmeras[finVentana] >= pesoNieve) {
                    palmerasEnPie++;
                }

                // Si tenemos más de 5 palmeras en pie, movemos la ventana
                while (palmerasEnPie > 5) {
                    if (palmeras[inicioTramo] >= pesoNieve) {
                        palmerasEnPie--;
                    }
                    inicioTramo++;
                }

                // Actualizamos la longitud máxima de la ventana que cumple la condición
                maxLongitud = Math.max(maxLongitud, finVentana - inicioTramo + 1);
            }

            // Imprimimos el resultado para este caso de prueba
            System.out.println("La longitud de la franja más afectada (con máximo 5 palmeras en pie) es: " + maxLongitud
                    + " palmeras.");
        }

        sc.close();
    }
}

/*
 * EXPLICACION DE SOLUCION
 * 
 * Enfoque
 * La idea es usar el concepto de ventana deslizante (o sliding window), que es
 * una técnica común para problemas en los que necesitamos analizar
 * subsecuencias de un array. La ventana será una secuencia de palmeras en la
 * que vamos a contar cuántas palmeras permanecen en pie (es decir, aquellas
 * cuyo peso máximo soportado es mayor que el peso de la nieve). Si el número de
 * palmeras en pie es más de 5, desplazamos la ventana hacia la derecha.
 * 
 * Pasos:
 * Por cada caso de prueba, tomamos el peso de la nieve y la lista de palmeras.
 * 
 * Usamos una ventana deslizante para recorrer la lista de palmeras y contar
 * cuántas se mantienen en pie.
 * 
 * Si el número de palmeras en pie es más de 5, movemos la ventana hacia la
 * derecha (eliminamos la primera palmera de la ventana).
 * 
 * Si el número de palmeras en pie es menor o igual a 5, tratamos de expandir la
 * ventana.
 * 
 * Guardamos la longitud de la ventana más grande que cumple con la condición de
 * tener 5 o menos palmeras en pie.
 * 
 * Explicación paso a paso:
 * Entrada de datos:
 * 
 * Primero leemos el número de casos de prueba (casosDePrueba).
 * 
 * Para cada caso de prueba, leemos el peso de la nieve que puede caer sobre
 * cada palmera (pesoNieve), luego el número de palmeras (numeroPalmeras) y
 * finalmente los pesos que pueden soportar cada una de las palmeras.
 * 
 * Ventana deslizante:
 * 
 * Usamos dos índices: inicioVentana (el inicio de la sublista actual) y
 * finVentana (el final de la sublista actual). A medida que recorremos la lista
 * de palmeras con finVentana, vamos actualizando cuántas palmeras permanecen en
 * pie (es decir, cuántas tienen un peso soportable mayor o igual al peso de la
 * nieve).
 * 
 * Si en algún momento la cantidad de palmeras en pie supera 5, movemos el
 * índice inicioVentana hacia la derecha hasta que tengamos 5 o menos palmeras
 * en pie en la ventana actual.
 * 
 * Actualizamos la longitud de la ventana cuando encontramos una sublista válida
 * con 5 o menos palmeras en pie.
 * 
 * Salida:
 * 
 * Después de procesar cada caso de prueba, imprimimos la longitud de la ventana
 * más larga que cumple con la condición.
 * 
 * Ejemplo de ejecución:
 * Entrada:
 * Copiar
 * 2
 * 30
 * 10
 * 10 30 50 20 40 60 30 40 50 36
 * 40
 * 10
 * 10 30 50 20 40 20 10 10 20 36
 * 20
 * Salida:
 * Copiar
 * 7
 * 10
 * Descripción de la solución:
 * En el primer caso, la franja más larga con 5 o menos palmeras en pie tiene
 * una longitud de 7. Es la subsecuencia de palmeras que puede soportar la nieve
 * que cae.
 * 
 * En el segundo caso, la longitud de la franja con 5 o menos palmeras en pie es
 * 10, ya que todas las palmeras pueden soportar el peso de la nieve.
 * 
 * Complejidad:
 * Tiempo: O(n) para cada caso de prueba, donde n es el número de palmeras. Esto
 * se debe a que recorremos las palmeras una vez con el índice finVentana y
 * movemos el índice inicioVentana solo cuando es necesario.
 * 
 * Espacio: O(n) para almacenar los pesos que las palmeras pueden soportar.
 * 
 * Esta solución es eficiente y cumple con los límites de tiempo establecidos
 * para el problema.
 */