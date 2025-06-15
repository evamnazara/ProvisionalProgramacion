package junio;

/*
1.2. Cifrado César

Uno de los métodos más antiguos para codificar mensajes es el conocido como cifrado César. Su funcionamiento es simple: cada una de las letras del mensaje original es sustituida por otra letra que se encuentra un número fijo de posiciones más adelante (o más atrás) en el alfabeto.

Así, si utilizamos un desplazamiento de 2, las apariciones de la letra 'a' se sustituyen por la 'c', todas las apariciones de la 'b' por 'd', etc. El método tradicional comienza de nuevo al llegar al final del alfabeto, de forma que, con el desplazamiento de 2, la 'y' se sustituye por la 'a' y la 'z' se sustituye por la 'b'. Los desplazamientos también pueden ser negativos; si utilizamos un desplazamiento de -1, la 'E' se convertirá en 'D', mientras que la 'a' pasará a ser 'z'.

Nuestro cifrado Cesar no codifica los caracteres que no sean letras anglosajonas. Así, por ejemplo, los espacios, vocales con tildes o diéresis o los símbolos de puntuación no sufrirán cambio alguno.

Realiza y prueba dos funciones para encriptar y desencriptar mensajes utilizando este cifrado siguiendo los siguientes prototipos:

String encriptarCesar(String cadena, int desplazamiento);
Encripta la cadena que se le pasa como parámetro usando el desplazamiento indicado, que puede ser positivo o negativo.


String desencriptarCesar(String cadena, int desplazamiento);
Desencripta la cadena que se le pasa como parámetro usando el desplazamiento indicado, que puede ser positivo o negativo.


Nota: Ten en cuenta que, en función de la versión del JDK, el método isLetter() de la clase Character puede considerar o no como letras las vocales acentuadas.

Nota2: Códigos ASCII/Unicode de las siguientes letras: ‘A’=65, ‘Z’=90, ‘a’=97, ‘z’=122.  Solicita la tabla ASCII si es necesario.

Ideas:
Variable auxiliar: String textoCifrado;
Podemos usar la aritmética de caracteres o un índice numérico de un posible  array o string de letras cifrables.
Fíjate que descifrar es igual a cifrar con el desplazamiento invertido. Desde una función podemos llamar a la otra.
Implementa un array int[] letrasCifrables; cuyo contenido son las letras anglosajonas en mayúscula.
Módulo: boolean esLetraCifrable(char ch); que devuelva true si el caracter se encuentra en el array anterior, independientemente de que sea mayúscula minúscula.
Módulo: char cifrarLetra(char ch, int desplazamiento);
Recorremos el array original con un bucle controlado por contador, concatenando en el texto cifrado cada caracter, tal cual si no es cifrable, o cifrado si sí lo es.

 */
public class CifradoCesar {
    public static void main(String[] args) {
        // Responde descifrando a frase: Zkcklóxd! Dfzockmrod k zkceo zcëmesmk nk
        // FN3!!!!
        desencriptarCesar("Zkcklóxd! Dfzockmrod k zkceo zcëmesmk nk FN3!!!!", 0);

    }

    public static String encriptarCesar(String cadena, int desplazamiento) {
        String textoCifrado = ""; // Empezamos con una cadena vacía

        for (int i = 0; i < cadena.length(); i++) {
            char letra = cadena.charAt(i); // Obtenemos el carácter en la posición i

            // Comprobamos si es una letra mayúscula
            if (letra >= 'A' && letra <= 'Z') {
                // Calculamos la nueva letra con desplazamiento circular
                char nuevaLetra = (char) ((letra - 'A' + desplazamiento + 26) % 26 + 'A');
                textoCifrado = textoCifrado + nuevaLetra; // Concatenamos al texto
            }
            // Comprobamos si es una letra minúscula
            else if (letra >= 'a' && letra <= 'z') {
                // Calculamos la nueva letra con desplazamiento circular
                char nuevaLetra = (char) ((letra - 'a' + desplazamiento + 26) % 26 + 'a');
                textoCifrado = textoCifrado + nuevaLetra; // Concatenamos al texto
            }
            // Si no es letra, lo dejamos igual
            else {
                textoCifrado = textoCifrado + letra; // Concatenamos el carácter original
            }
        }

        return textoCifrado;
    }

    // desencriptar, simplemente ciframos con el desplazamiento negativo
    public static String desencriptarCesar(String cadena, int desplazamiento) {
        return encriptarCesar(cadena, -desplazamiento);
    }

}
