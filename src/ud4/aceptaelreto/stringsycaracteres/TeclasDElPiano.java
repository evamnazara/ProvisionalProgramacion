package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class TeclasDElPiano {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Mapeo de notas a índice de teclas (0 = Do, 1 = Do#, 2 = Re, ..., 11 = Si)
        String[] notas = {
                "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"
        };

        // Leer canciones
        while (true) {
            // Leer el número de notas
            String line = sc.nextLine();
            if (line.equals("0")) {
                break; // Si el número de notas es 0, terminamos
            }

            // Número de notas (no lo vamos a usar directamente)
            int numNotas = line.length(); // Solo para la estructura, no lo usaremos.

            // Leer la segunda línea que contiene las notas
            String[] canciones = sc.nextLine().split(" ");

            // Crear un array para contar las pulsaciones de cada tecla (12 teclas por 7
            // octavas)
            int[] teclas = new int[84]; // 12 teclas por 7 octavas

            // Contar las pulsaciones
            for (String nota : canciones) {
                // Extraemos la nota base (Do, Re, etc.) y la octava
                String notaBase = "";
                String octava = "";

                // Extraer la base de la nota (ejemplo: "Do" de "Do4")
                for (int i = 0; i < nota.length(); i++) {
                    if (nota.charAt(i) >= 'A' && nota.charAt(i) <= 'Z') {
                        notaBase = nota.substring(0, i + 1); // Lo que está antes del número es la base
                        octava = nota.substring(i + 1); // El número después es la octava
                        break;
                    }
                }

                // Encontrar el índice de la nota base (Do, Re, etc.)
                int index = -1;
                for (int i = 0; i < 12; i++) {
                    if (notas[i].equals(notaBase)) {
                        index = i;
                        break;
                    }
                }

                // Si la nota es válida, incrementamos el contador de esa tecla en la octava
                // correcta
                if (index != -1) {
                    // Ahora, con la octava como string, determinamos a qué octava pertenece.
                    int octavaIndex = 0;
                    if (octava.equals("1"))
                        octavaIndex = 0;
                    else if (octava.equals("2"))
                        octavaIndex = 1;
                    else if (octava.equals("3"))
                        octavaIndex = 2;
                    else if (octava.equals("4"))
                        octavaIndex = 3;
                    else if (octava.equals("5"))
                        octavaIndex = 4;
                    else if (octava.equals("6"))
                        octavaIndex = 5;
                    else if (octava.equals("7"))
                        octavaIndex = 6;

                    // El índice de la tecla en el piano
                    int teclaIndex = (octavaIndex) * 12 + index;
                    teclas[teclaIndex]++;
                }
            }

            // Imprimir los resultados de la canción
            boolean inicio = false;
            for (int i = 0; i < teclas.length; i++) {
                if (teclas[i] > 0) {
                    if (inicio) {
                        System.out.print(" ");
                    }
                    System.out.print(teclas[i]);
                    inicio = true;
                }
            }
            System.out.println();
        }

        // Cerrar el scanner
        sc.close();
    }
}

/*
 * Teclas del piano
 * Tiempo máximo: 1,000-2,000 s Memoria máxima: 4096 KiB
 * ¡Qué ilusionado está Iker con su nuevo piano! Por fin va a poder tocar todas
 * las canciones que le gustan. El vendedor le ha dicho que es un piano de muy
 * buena calidad que le durará mucho tiempo, pero Iker no se fía del todo y ha
 * decidido llevar la cuenta de cuántas veces toca cada tecla.
 * 
 * El teclado del piano está compuesto por 7 octavas1 y cada octava consta de 12
 * notas (7 blancas y 5 negras) cada una a medio tono de distancia de la
 * siguiente. Las teclas blancas corresponden a las notas Do, Re, Mi, Fa, Sol,
 * La y Si (y a continuación vendrá el Do de la siguiente octava). Entre las
 * notas Do y Re hay un tono de distancia por lo que hay una tecla negra en
 * medio, mientras que entre Mi y Fa sólo hay medio tono de distancia. Las
 * teclas negras corresponden precisamente a esos medios tonos y se nombran
 * usando dos símbolos especiales: sostenido (♯) y bemol (♭). El sostenido
 * aumenta medio tono mientras que el bemol disminuye medio tono.
 * 
 * De esta forma, la primera tecla negra de la octava corresponde a la nota Do ♯
 * pero también a Re ♭. Para liar un poco más las cosas la nota Mi ♯ está en la
 * misma tecla que Fa, y un Do ♭ es lo mismo que el Si de la octava anterior.
 * 
 * Teclas de un piano
 * ¿Puedes ayudar a Iker a contar cuántas veces se pulsa cada tecla?
 * 
 * Entrada
 * El programa deberá leer, por la entrada estándar, múltiples canciones, cada
 * una descrita mediante dos líneas. La primera línea indica el número de notas
 * de la canción, y la segunda línea contiene las notas que la componen. Las
 * notas aparecen separadas por espacios y siempre tienen el mismo formato:
 * nombre de la nota, alteración (#, b o nada), y el número de octava. La octava
 * más grave es la 1 y la más aguda la 7.
 * 
 * La entrada termina con una canción con 0 notas que no se debe procesar.
 * 
 * Salida
 * El programa deberá escribir una línea por cada canción que aparezca en la
 * entrada, indicando cuántas veces se pulsó cada tecla del piano ordenadas
 * desde la nota más grave hasta la más aguda. El primer número corresponderá al
 * número de pulsaciones de la tecla más grave que aparece en la canción y el
 * último a la más aguda. Es decir, la solución no debe empezar ni terminar por
 * ceros.
 * 
 * Entrada de ejemplo
 * 6
 * Do4 Do4 Re4 Do4 Fa4 Mi4
 * 9
 * Mi5 Re#5 Mi5 Re#5 Mi5 Si4 Re5 Do5 La4
 * 10
 * Do4 Do#4 Reb4 Re4 Re#4 Mib4 Mi4 Fab4 Mi#4 Fa4
 * 0
 * Salida de ejemplo
 * 
 * 3 0 1 0 1 1
 * 1 0 1 1 0 1 2 3
 * 1 2 1 2 2 2
 */

/*
 * Para resolver este problema, necesitamos contar cuántas veces se pulsa cada
 * tecla de un piano, dado un conjunto de notas de una canción. Las teclas del
 * piano están distribuidas en octavas, y las notas pueden ser blancas (sin
 * alteración) o negras (con alteración de sostenido o bemol). Las octavas van
 * de la 1 a la 7 y las notas son representadas en un formato como "Do4",
 * "Re#5", etc.
 * 
 * Pasos para la solución:
 * Entender la estructura del teclado del piano:
 * Las notas son: Do, Re, Mi, Fa, Sol, La, Si.
 * Las teclas negras son: Do# (o Reb), Re# (o Mib), Fa# (o Solb), Sol# (o Lab),
 * La# (o Sib).
 * Las notas pueden ir acompañadas de un número de octava (1 a 7).
 * Entrada:
 * Cada canción tiene un número de notas y una lista de esas notas.
 * La entrada termina cuando el número de notas es 0.
 * Salida:
 * Para cada canción, debemos contar cuántas veces se ha tocado cada tecla del
 * piano, desde la más grave hasta la más aguda.
 * Plan de solución:
 * Inicializar un array para contar las pulsaciones:
 * Un piano tiene 12 teclas por octava, por lo que necesitamos contar las teclas
 * de todas las octavas (de la octava 1 a la octava 7).
 * Convertir las notas a índices del teclado:
 * Cada nota, por ejemplo, "Do4", debe ser convertida en un índice que
 * corresponda a su tecla específica. "Do4" será la primera tecla de la octava
 * 4.
 * Contar las pulsaciones:
 * Vamos a recorrer las notas y contar cuántas veces aparece cada una.
 * Salida:
 * Para cada canción, imprimir las pulsaciones de las teclas, desde la más grave
 * a la más aguda.
 */