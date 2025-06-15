package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class CodificacionLimite {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leemos las líneas de entrada hasta que no haya más
        System.out.println("Introduce el mensaje cifrado:");

        // Vamos a leer múltiples líneas de entrada
        while (scanner.hasNextLine()) {
            String mensaje = scanner.nextLine().trim(); // Leemos la línea y eliminamos espacios extra
            if (mensaje.isEmpty())
                break; // Si la línea está vacía, terminamos la entrada

            // Procesamos el mensaje cifrado para obtener la cadena descifrada
            String resultado = obtenerFrontal(mensaje);

            // Imprimimos el resultado descifrado
            System.out.println(resultado);
        }

        scanner.close();
    }

    // Función que obtiene las "hojas" del árbol binario representado por el mensaje
    public static String obtenerFrontal(String mensaje) {
        StringBuilder resultado = new StringBuilder(); // Para almacenar la cadena de salida
        recorrerArbol(mensaje, 0, resultado); // Llamamos a la función recursiva para recorrer el árbol
        return resultado.toString(); // Devolvemos el mensaje final
    }

    // Función recursiva que recorre el árbol y extrae las hojas
    // `mensaje`: el mensaje cifrado que representa el árbol
    // `index`: índice actual en el mensaje
    // `resultado`: StringBuilder que contiene la salida con las hojas
    public static int recorrerArbol(String mensaje, int index, StringBuilder resultado) {
        // Si encontramos un punto (.), es un árbol vacío, retornamos inmediatamente
        if (mensaje.charAt(index) == '.') {
            return index + 1; // El índice avanza uno para saltarse el punto
        }

        // Si encontramos un nodo válido (letra), lo agregamos a la lista de resultados
        if (Character.isLetter(mensaje.charAt(index))) {
            // Recursivamente recorrermos el hijo izquierdo
            index = recorrerArbol(mensaje, index + 1, resultado); // Avanzamos al siguiente carácter (hijo izquierdo)
            // Luego recorrermos el hijo derecho
            index = recorrerArbol(mensaje, index, resultado); // El hijo derecho se recorre
            // Finalmente agregamos la letra (hoja) al resultado
            resultado.append(mensaje.charAt(index - 1)); // Agregamos la letra encontrada
        }

        return index; // Devolvemos el índice actualizado
    }
}

/*
 * Codificación límite
 * El envío de mensajes cifrados para evitar miradas indiscretas se lleva
 * estudiando desde la antigüedad. El método más simple consiste en manejar
 * tablas de traducción que contienen, para cada letra, por qué otra letra se
 * sustituirá en el mensaje cifrado.
 * 
 * Existe otro mecanismo simple que consiste en simplemente añadir caracteres
 * aleatorios entre las letras del mensaje. El método que hoy proponemos utiliza
 * este sistema. Además, requiere un pequeño esfuerzo adicional por parte del
 * lector pues el mensaje recompuesto no contiene espacios separando las
 * palabras, por lo que deberá ser él el que infiera, en el momento de leer,
 * dónde empieza y termina cada una.
 * 
 * El procedimiento comienza con un mensaje cifrado como el siguiente:
 * "xb..zu..t.u..". Ese mensaje lo interpretaremos como un árbol binario de
 * caracteres donde el primer carácter simboliza la raíz y a continuación
 * aparecen el hijo izquierdo y el hijo derecho, teniendo en cuenta que el árbol
 * vacío está representado por un punto '.'. El mensaje del ejemplo representa
 * el siguiente árbol (donde se han omitido los árboles vacíos):
 * 
 * Árbol correspondiente al mensaje 'xb..zu..t.u..'
 * El mecanismo de codificación límite lo que hace es quedarse con el límite o
 * frontera del árbol (las hojas de izquierda a derecha), y escribirlas.
 * 
 * Entrada
 * La entrada consiste en diversas líneas, cada una con un mensaje codificado
 * utilizando la codificación límite. Se garantiza que el mensaje será un árbol
 * binario válido, que no tendrá más de 5.000 caracteres y cuya altura no será
 * mayor de 3.000. Los nodos del árbol contienen caracteres de la 'a' a la 'z'.
 * 
 * Salida
 * Para cada caso de prueba, escribir una línea con el mensaje descifrado.
 * 
 * Entrada de ejemplo
 * abh...ko..nl..a..
 * xb..zu..t.u..
 * Salida de ejemplo
 * 
 * hola
 * buu
 */