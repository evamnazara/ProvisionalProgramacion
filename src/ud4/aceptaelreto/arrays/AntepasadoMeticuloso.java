package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class AntepasadoMeticuloso {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer la cantidad de casos de prueba
        int casos = scanner.nextInt();

        for (int i = 0; i < casos; i++) {
            // Leer L (máximo número de caracteres por línea) y N (cantidad de palabras)
            int maxLargo = scanner.nextInt();
            int numPalabras = scanner.nextInt();

            // Array para almacenar las longitudes de las palabras
            int[] palabras = new int[numPalabras];
            int totalCaracteres = 0;

            // Leer las longitudes de las palabras y calcular el total de caracteres
            for (int j = 0; j < numPalabras; j++) {
                palabras[j] = scanner.nextInt();
                totalCaracteres += palabras[j];
            }

            // Determinar la mayor longitud de línea posible
            int mejorLongitud = -1;

            for (int longitud = maxLargo; longitud >= 1; longitud--) {
                int suma = 0;
                int lineas = 1;

                for (int j = 0; j < numPalabras; j++) {
                    if (suma == 0) {
                        suma = palabras[j];
                    } else if (suma + palabras[j] + 1 <= longitud) {
                        suma += palabras[j] + 1; // Agregar palabra con su espacio
                    } else {
                        lineas++;
                        suma = palabras[j];
                    }
                }

                // Verificar si es posible usar esta longitud
                if (suma <= longitud) {
                    mejorLongitud = longitud;
                    break;
                }
            }

            // Imprimir el resultado
            if (mejorLongitud == -1) {
                System.out.println("IMPOSIBLE");
            } else {
                System.out.println(mejorLongitud);
            }
        }

        scanner.close();
    }
}

/*
 * El antepasado meticuloso
 * Tiempo máximo: 1,000-3,000 s Memoria máxima: 4096 KiB
 * Tipos de una máquina de escribir antigua
 * Al hacer limpieza en la vieja casa del pueblo, han aparecido unos papeles
 * amarillentos dentro de un carcomido baúl. Debieron ser escritos muchos años
 * atrás por alguien de la familia a quien ya nadie recuerda. Pero, fuera quien
 * fuese, debió ser una persona adelantada a su tiempo, porque estaban escritos
 * a máquina en una época en la que la mayoría de la gente del pueblo apenas era
 * capaz de escribir su nombre, y con dificultad.
 * 
 * Lo más increíble de esos papeles era la delicadeza de la maquetación: salvo
 * la última, todas las líneas de cada párrafo tenían la misma longitud. Dado
 * que las letras y el espacio de la máquina de escribir tenían todos el mismo
 * ancho, eso significaba que todas las líneas de un mismo párrafo tenían el
 * mismo número de elementos. Además, quien escribiera estos viejos folios, ni
 * siquiera se permitió poner dos espacios consecutivos. Por ejemplo, en uno de
 * los folios estaba escrita la primera frase del Quijote ocupando tres líneas,
 * las dos primeras con una longitud exacta de 80 letras:
 * 
 * En un lugar de la Mancha, de cuyo nombre no quiero acordarme, no ha mucho
 * tiempo
 * que vivía un hidalgo de los de lanza en astillero, adarga antigua, rocín
 * flaco y
 * galgo corredor.
 * Hoy estamos acostumbrados a la justificación completa, pero conseguirla
 * artesanalmente es toda una demostración de paciencia. Especialmente en esas
 * viejas máquinas, donde no se cuenta con la elasticidad de los espacios para
 * ajustar el ancho.
 * 
 * Entrada
 * La entrada comienza con una línea con un único número que indica la cantidad
 * de casos de prueba que habrá que procesar.
 * 
 * Cada uno de los casos de prueba ocupa dos líneas. La primera contiene dos
 * números, el máximo número de letras y espacios que entran en una línea, 1 ≤ L
 * ≤ 100, y el número de palabras que tenemos que añadir en el párrafo, 1 ≤ N ≤
 * 5.000.
 * 
 * En la segunda línea aparecen N números separados por un espacio con la
 * longitud, en letras, de cada palabra (como mucho 50).
 * 
 * Salida
 * Por cada caso de prueba el programa escribirá la mayor longitud de línea que
 * podemos usar, menor o igual que L, de modo que todas las líneas tengan la
 * misma longitud. Solo la última puede ser distinta, siempre que no supere la
 * longitud de las demás.
 * 
 * Ninguna palabra puede cortarse en dos líneas. Además, entre cada par de
 * palabras consecutivas se deberá contar el hueco ocupado por un único espacio.
 * 
 * Entrada de ejemplo
 * 3
 * 10 4
 * 3 4 4 3
 * 10 4
 * 3 4 4 4
 * 85 33
 * 2 2 5 2 2 7 2 4 6 2 6 10 2 2 5 6 3 5 2 7 2 3 2 5 2 10 6 8 5 5 1 5 9
 * Salida de ejemplo
 * 8
 * IMPOSIBLE
 * 80
 * 
 */
