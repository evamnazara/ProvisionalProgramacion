package ud4.aceptaelreto.matrices;

import java.util.Scanner;

public class OvejasNegras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // PASO 1: Leer las dimensiones de la imagen
            System.out.print("Ingresa el ancho y alto de la imagen (0 0 para terminar): ");
            int anchoImagen = scanner.nextInt();
            int altoImagen = scanner.nextInt();

            // Si el ancho y alto son 0, terminamos el programa
            if (anchoImagen == 0 && altoImagen == 0) {
                System.out.println("Fin del programa.");
                break;
            }

            // PASO 2: Crear la matriz para almacenar la imagen
            char[][] imagen = new char[altoImagen][anchoImagen];

            // Leer la imagen
            System.out.println("Ingresa la imagen:");
            for (int i = 0; i < altoImagen; i++) {
                imagen[i] = scanner.next().toCharArray();
            }

            // PASO 3: Variable para detectar si encontramos alguna oveja blanca
            boolean ovejaBlancaEncontrada = false;

            // PASO 4: Recorrer la imagen buscando ovejas blancas
            for (int i = 1; i < altoImagen - 1; i++) { // Empezamos en 1 y terminamos en altoImagen-1 porque las ovejas
                                                       // no tocan los bordes
                for (int j = 1; j < anchoImagen - 1; j++) { // Lo mismo para las columnas
                    // Si encontramos una parte de una oveja negra ('X')
                    if (imagen[i][j] == 'X') {
                        // Verificamos si esta parte de la oveja tiene un espacio blanco dentro
                        // Comprobamos las 4 direcciones alrededor de la 'X'
                        if (imagen[i - 1][j] == '.' || imagen[i + 1][j] == '.' || imagen[i][j - 1] == '.'
                                || imagen[i][j + 1] == '.') {
                            ovejaBlancaEncontrada = true;
                            break;
                        }
                    }
                }
                if (ovejaBlancaEncontrada) {
                    break;
                }
            }

            // PASO 5: Imprimir el resultado
            if (ovejaBlancaEncontrada) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        }

        scanner.close();
    }
}

/*
 * OVEJAS NEGRAS
 * 
 * Ovejas negras
 * Tiempo máximo: 1,000-4,000 s Memoria máxima: 4096 KiB
 * Parece ser que en cierta ocasión estaban de viaje por Escocia un abogado, un
 * físico y un matemático. Por la ventanilla del tren en el que viajaban vieron
 * un campo con ovejas negras. Ninguno de los tres había visto ovejas negras
 * nunca, por lo que se estableció un curioso diálogo entre ellos:
 * 
 * — ¡Vaya! ¡En Escocia las ovejas son negras! — dijo el abogado.
 * 
 * — Querrás decir que en Escocia algunas ovejas son negras... — corrigió el
 * físico.
 * 
 * — Bueno, — no pudo evitar decir el matemático — con lo que hemos visto lo
 * único que podemos decir es que en Escocia algunas ovejas son negras... ¡por
 * un lado!
 * 
 * Para comprobar si el abogado tenía razón, tenemos fotografías de todas las
 * ovejas de Escocia, y hay que analizarlas para ver si en alguna sale alguna
 * oveja blanca (al menos por un lado) o no.
 * 
 * Entrada
 * 
 * La entrada estará compuesta por distintos casos de prueba, cada uno siendo
 * una instantánea de una o más ovejas escocesas.
 * 
 * Cada foto comienza con una línea con dos números indicando el ancho y el alto
 * (en píxeles) de la imagen (ambos menores o iguales que 50). A continuación
 * viene la imagen en blanco y negro en donde el carácter '.' representa el
 * color blanco y 'X' el negro. Se puede asumir que:
 * 
 * El fondo de la imagen es siempre blanco.
 * Todas las ovejas tienen la silueta negra. Las ovejas blancas tienen algo
 * blanco dentro de su silueta.
 * Las ovejas nunca se solapan (es decir, en las fotos las ovejas nunca se
 * tocan).
 * Ninguna oveja entra en contacto con los bordes de la foto (es decir, en todas
 * las fotos la primera y última fila y la primera y última columna son '.').
 * En la foto sólo aparecen ovejas.
 * Salida
 * 
 * Para cada caso de prueba se escribirá SI si en la foto hay alguna oveja
 * blanca y NO en caso contrario.
 * 
 * Entrada de ejemplo
 * 
 * Para resolver este problema, vamos a trabajar con una imagen que consiste en
 * caracteres que representan un campo donde se encuentran las ovejas negras y
 * blancas. El objetivo es detectar si alguna oveja blanca (que tiene una zona
 * blanca dentro de su silueta) aparece en la foto. Para hacerlo, necesitamos
 * procesar las filas y las columnas de la imagen y buscar la presencia de algún
 * ‘X’ rodeado por ‘.’ (blanco), lo cual indicaría una oveja blanca.
 * 
 * Pasos de la solución:
 * 1. Leer la entrada:
 * • Primero, leemos las dimensiones de la imagen, es decir, el ancho y alto.
 * • Luego, leemos la imagen que consiste en una serie de caracteres ‘.’ y ‘X’.
 * El carácter ‘X’ representa una parte de la oveja (negra) y el carácter ‘.’
 * representa el fondo blanco.
 * 2. Detectar ovejas blancas:
 * • Una oveja blanca tiene una parte de su cuerpo interna blanca, es decir,
 * dentro de su silueta negra habrá una zona de píxeles con ‘.’. Debemos buscar
 * esos casos.
 * • Para identificar si una oveja es blanca, buscamos las zonas de ‘X’ que
 * tienen al menos un ‘.’ dentro de ellas (es decir, una oveja que tiene una
 * parte interna blanca).
 * 3. Recorrer la imagen:
 * • Recorremos cada píxel de la imagen. Si encontramos una ‘X’, verificamos las
 * celdas adyacentes (arriba, abajo, izquierda, derecha) para ver si hay alguna
 * celda que sea un ‘.’ dentro de la silueta.
 * 4. Salida:
 * • Si encontramos alguna oveja blanca, imprimimos “SI”. Si no, imprimimos
 * “NO”.
 * 
 * Implementación en Java:
 * 
 * 
 * 
 * Explicación del código:
 * 1. Entrada:
 * • Usamos un Scanner para leer la entrada de la consola.
 * • Leemos los valores de ancho y alto, que nos dicen las dimensiones de la
 * imagen.
 * • Si ancho y alto son 0, significa que hemos llegado al final de los casos de
 * prueba, por lo que rompemos el ciclo while.
 * 2. Matriz de la imagen:
 * • Usamos una matriz de caracteres imagen para almacenar la imagen. Cada fila
 * de la matriz es una línea de la imagen que leemos usando scanner.next(), y
 * luego la convertimos a un array de caracteres (toCharArray()).
 * 3. Detección de ovejas blancas:
 * • Recorremos la imagen de forma que no lleguemos a los bordes (ya que las
 * ovejas nunca tocan los bordes). Comenzamos en el índice 1 y terminamos en
 * alto - 1 y ancho - 1 respectivamente.
 * • Cuando encontramos un ‘X’, verificamos las celdas adyacentes (arriba,
 * abajo, izquierda, derecha) para ver si alguna es un ‘.’. Si es así, significa
 * que esa oveja tiene una parte blanca en su interior, y por lo tanto es una
 * oveja blanca.
 * 4. Salida:
 * • Si encontramos alguna oveja blanca, imprimimos “SI”, de lo contrario
 * imprimimos “NO”.
 * 
 * 
 * Explicación del ejemplo:
 * 1. En el primer caso de prueba, la imagen contiene una oveja blanca (en una
 * de las ‘X’ hay un espacio en blanco dentro), por lo que la salida es “SI”.
 * 2. En el segundo caso de prueba, no se encuentran ovejas blancas, por lo que
 * la salida es “NO”.
 * 
 * Conclusión:
 * 
 * El algoritmo recorre la imagen para buscar ovejas que tengan una parte
 * interna blanca. Al verificar las celdas adyacentes a una oveja, podemos
 * determinar si es blanca o no. Este enfoque es eficiente y cumple con los
 * límites establecidos en el problema.
 * 
 * ===
 * Para resolver este problema, vamos a trabajar con una imagen que consiste en
 * caracteres que representan un campo donde se encuentran las ovejas negras y
 * blancas. El objetivo es detectar si alguna oveja blanca (que tiene una zona
 * blanca dentro de su silueta) aparece en la foto. Para hacerlo, necesitamos
 * procesar las filas y las columnas de la imagen y buscar la presencia de algún
 * ‘X’ rodeado por ‘.’ (blanco), lo cual indicaría una oveja blanca.
 * 
 * Pasos de la solución:
 * 1. Leer la entrada:
 * • Primero, leemos las dimensiones de la imagen, es decir, el ancho y alto.
 * • Luego, leemos la imagen que consiste en una serie de caracteres ‘.’ y ‘X’.
 * El carácter ‘X’ representa una parte de la oveja (negra) y el carácter ‘.’
 * representa el fondo blanco.
 * 2. Detectar ovejas blancas:
 * • Una oveja blanca tiene una parte de su cuerpo interna blanca, es decir,
 * dentro de su silueta negra habrá una zona de píxeles con ‘.’. Debemos buscar
 * esos casos.
 * • Para identificar si una oveja es blanca, buscamos las zonas de ‘X’ que
 * tienen al menos un ‘.’ dentro de ellas (es decir, una oveja que tiene una
 * parte interna blanca).
 * 3. Recorrer la imagen:
 * • Recorremos cada píxel de la imagen. Si encontramos una ‘X’, verificamos las
 * celdas adyacentes (arriba, abajo, izquierda, derecha) para ver si hay alguna
 * celda que sea un ‘.’ dentro de la silueta.
 * 4. Salida:
 * • Si encontramos alguna oveja blanca, imprimimos “SI”. Si no, imprimimos
 * “NO”.
 */