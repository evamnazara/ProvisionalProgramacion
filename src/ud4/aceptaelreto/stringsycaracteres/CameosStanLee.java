package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class CameosStanLee {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leemos el número de casos
        System.out.println("Introduce el número de casos:");
        int numeroDeCasos = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        // Procesamos cada caso de prueba
        for (int i = 0; i < numeroDeCasos; i++) {
            System.out.println("Introduce la frase:");
            String frase = scanner.nextLine();

            // Llamamos a la función que cuenta los cameos
            int numeroDeCameos = contarCameos(frase);

            // Imprimimos el resultado para este caso
            System.out.println(numeroDeCameos);
        }

        scanner.close(); // Cerramos el scanner
    }

    // Función que cuenta cuántos cameos de "Stan Lee" aparecen en la frase
    public static int contarCameos(String frase) {
        // Convertir la frase a minúsculas para no diferenciar mayúsculas de minúsculas
        frase = frase.toLowerCase();

        // El nombre a buscar es "stan lee", que se debe encontrar en la frase con
        // caracteres intermedios
        String cameo = "stanlee";

        int cameosContados = 0;
        int indice = 0;

        // Vamos a recorrer la frase buscando "stan lee"
        while (indice < frase.length()) {
            // Intentamos encontrar "stan lee" desde la posición actual
            int pos = buscarCameoEnFrase(frase, indice, cameo);

            if (pos != -1) {
                // Si encontramos un cameo, incrementamos el contador
                cameosContados++;
                // Nos movemos a la posición después del cameo encontrado
                indice = pos + 1;
            } else {
                break; // Si no encontramos más cameos, salimos del ciclo
            }
        }

        return cameosContados;
    }

    // Función que busca "stan lee" en la frase a partir de un índice dado
    public static int buscarCameoEnFrase(String frase, int inicio, String cameo) {
        int cameoIndice = 0;

        // Recorremos la frase a partir del índice indicado
        for (int i = inicio; i < frase.length(); i++) {
            char c = frase.charAt(i);

            // Si encontramos una letra, la comparamos con la letra correspondiente en "stan
            // lee"
            if (Character.isLetter(c)) {
                // Comparar la letra en minúscula
                if (c == cameo.charAt(cameoIndice)) {
                    cameoIndice++;
                    if (cameoIndice == cameo.length()) {
                        // Si hemos encontrado todas las letras de "stanlee", devolvemos la posición
                        return i - cameo.length() + 1;
                    }
                } else {
                    // Si la letra no coincide, reiniciamos la búsqueda del cameo
                    cameoIndice = 0;
                }
            }
        }

        // Si no encontramos el cameo, devolvemos -1
        return -1;
    }
}

/*
 * Cameos de Stan Lee
 * Múltiles fotogramas de Stan Lee en varias películas de sus superhéroes
 * Aparte de por haber creado infinidad de superhéroes, Stan Lee es recordado
 * por los cameos cinematográficos que hizo en mutitud de películas y series.
 * 
 * Quizá por estar más escondidos, son menos conocidos sus cameos en los comics
 * de los que era autor. Por ejemplo, en una determinada viñeta podía leerse
 * "¡Que me diga dónde están, le exijo!" Un ojo entrenado, detecta su aparición
 * sin ningún tipo de indicación.
 * 
 * Algunas veces se camuflaba más, partiendo su nombre con letras arbitrarias,
 * como en "¡Eres tan lento que te ganaría una oruga!" o incluso en
 * "Salta, no le temas".
 * Los aficionados a los superhéroes releen sus comics una y otra vez buscando
 * todos esos cameos, pero es mucho más práctico automatizar la tarea.
 * 
 * Entrada
 * La entrada comenzará con una línea con el número de casos de prueba que hay
 * que procesar.z
 * 
 * Cada caso de prueba es una línea de texto de hasta 10.000 letras, incluyendo
 * mayúsculas, minúsculas y símbolos de puntuación. Por simplicidad, no
 * aparecerán vocales acentuadas.
 * 
 * Salida
 * Por cada caso de prueba, el programa escribirá el número de cameos de Stan
 * Lee, es decir, el número de veces que aparece su nombre, sin tener en cuenta
 * las mayúsculas ni los espacios, y con la posibilidad de que haya letras,
 * símbolos y espacios separando las letras originales.
 * 
 * Stan Lee era único, por lo que antes de empezar a buscarle una segunda vez
 * ¡tiene que haber terminado de salir la primera!
 * 
 * Entrada de ejemplo
 * 5
 * Que me diga donde estan, le exijo!
 * Eres tan lento que te ganaria una oruga. Calla y salta, no le temas.
 * Esto es canela, verdad que si?
 * Stan Stan Lee Lee
 * Stan Loo
 * Salida de ejemplo
 * 
 * 1
 * 2
 * 1
 * 1
 * 0
 */
