package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class Diagoland {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Leer dimensiones de la hoja de cuadros
            int ancho = scanner.nextInt();
            int alto = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            // Si ambos son 0, terminamos la entrada
            if (ancho == 0 && alto == 0) {
                break;
            }

            System.out.println("Leyendo el dibujo...");
            char[][] hoja = new char[alto][ancho];

            // Leer la hoja de cuadros
            for (int i = 0; i < alto; i++) {
                String linea = scanner.nextLine();
                hoja[i] = linea.toCharArray();
            }

            // Calcular el área de los polígonos
            int areaTotal = calcularArea(hoja, alto, ancho);

            // Imprimir el área total
            System.out.println("Área total de los polígonos: " + areaTotal);
        }

        scanner.close();
    }

    private static int calcularArea(char[][] hoja, int alto, int ancho) {
        int area = 0;
        boolean dentroPoligono = false;

        for (int i = 0; i < alto; i++) {
            dentroPoligono = false;
            for (int j = 0; j < ancho; j++) {
                if (hoja[i][j] == '/' || hoja[i][j] == '\\') {
                    // Al encontrar una línea diagonal, cambiamos el estado
                    dentroPoligono = !dentroPoligono;
                } else if (dentroPoligono) {
                    // Si estamos dentro de un polígono, sumamos al área
                    area++;
                }
            }
        }
        return area;
    }
}

/*
 * Diagoland
 * Una figura dibujada con diagonales en una hoja de cuadros
 * En Diagoland los niños en el colegio aprenden a escribir en cursiva, les
 * cuesta mucho entender el concepto de ángulo recto, tienen mucha manía a
 * Pitágoras y prefieren los rombos a los rectángulos.
 * 
 * Curiosamente, sin embargo, utilizan hojas de cuadros. Pero cuando hacen
 * dibujos sobre ellos no utilizan líneas horizontales ni verticales, sino
 * diagonales.
 * 
 * Dada una hoja de cuadros con varios polígonos (que no se tocan), ¿cuál es su
 * área total?
 * 
 * Entrada
 * La entrada está compuesta por distintos casos de prueba terminados por una
 * línea con dos ceros.
 * 
 * Cada caso de prueba comienza con una línea con dos números que indican el
 * tamaño de la hoja de cuadros donde están los polígonos; el primero indica el
 * ancho y el segundo el alto. Ninguno de los dos números será superior a 100.
 * 
 * A continuación aparece el dibujo. Los caracteres posibles son las dos barras
 * diagonales que se utilizan para marcar los límites de cada polígono y el
 * punto (".") para indicar cuadrados vacíos.
 * 
 * Los polígonos nunca comparten lados ni vértices. Se garantiza, además, que
 * ningún polígono queda completa ni parcialmente contenido en otro.
 * 
 * Salida
 * Por cada caso de prueba se escribirá un único número con la suma del área de
 * todos los polígonos del dibujo medida en número de cuadrados.
 * 
 * Entrada de ejemplo
 * 6 3
 * /\/\/\
 * \..../
 * .\/\/.
 * 6 5
 * ../\..
 * /\\//\
 * \.\/./
 * .\../.
 * ..\/..
 * 0 0
 * Salida de ejemplo
 * 
 * 10
 * 12
 */