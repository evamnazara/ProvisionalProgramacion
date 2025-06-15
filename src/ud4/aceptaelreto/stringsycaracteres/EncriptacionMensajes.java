package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class EncriptacionMensajes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ciclo infinito para leer múltiples casos de prueba
        while (true) {
            System.out.println("Ingrese un mensaje cifrado (termina con un mensaje que se decodifique como 'FIN'):");
            // Leer la línea completa que incluye la letra codificada y el mensaje cifrado
            String entrada = scanner.nextLine();

            // El primer carácter indica cómo se ha cifrado la letra 'p'
            char primeraLetraCifrada = entrada.charAt(0);
            String mensajeCifrado = entrada.substring(1); // El resto es el mensaje cifrado

            // Calcular el desplazamiento usado en el cifrado
            int desplazamiento = calcularDesplazamiento(primeraLetraCifrada, 'p');

            // Decodificar el mensaje
            String mensajeOriginal = decodificarMensaje(mensajeCifrado, desplazamiento);

            // Si el mensaje original es "FIN", terminamos el programa
            if (mensajeOriginal.equals("FIN")) {
                System.out.println("Programa finalizado.");
                break;
            }

            // Contar el número de vocales en el mensaje cifrado
            int cantidadVocales = contarVocales(mensajeCifrado);

            // Imprimir el número de vocales
            System.out.println("Número de vocales en el mensaje cifrado: " + cantidadVocales);
        }

        scanner.close();
    }

    // Calcula el desplazamiento que se ha utilizado para cifrar
    public static int calcularDesplazamiento(char letraCodificada, char letraOriginal) {
        int codigoCodificado = letraCodificada; // Convertir el carácter a su código ASCII
        int codigoOriginal = letraOriginal; // Convertir la letra 'p' a su código ASCII
        int desplazamiento = codigoCodificado - codigoOriginal; // Calcular la diferencia

        return desplazamiento;
    }

    // Decodifica el mensaje aplicando el cifrado César en sentido inverso
    public static String decodificarMensaje(String mensaje, int desplazamiento) {
        String resultado = "";

        // Recorrer cada carácter del mensaje cifrado
        for (int i = 0; i < mensaje.length(); i++) {
            char caracter = mensaje.charAt(i);
            char caracterDecodificado = descifrarCaracter(caracter, desplazamiento);
            resultado += caracterDecodificado; // Concatenar el carácter decodificado al resultado
        }

        return resultado;
    }

    // Desplaza un carácter en sentido inverso según el desplazamiento dado
    public static char descifrarCaracter(char caracter, int desplazamiento) {
        if (esLetra(caracter)) {
            int base = (esMayuscula(caracter)) ? 'A' : 'a'; // Determina si la letra es mayúscula o minúscula
            int posicionOriginal = (caracter - base - desplazamiento + 26) % 26; // Calcular nueva posición
            return (char) (base + posicionOriginal); // Convertir la posición a un carácter
        }
        return caracter; // Si no es una letra, no hacer cambios
    }

    // Verifica si un carácter es una letra del alfabeto inglés
    public static boolean esLetra(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    // Verifica si un carácter es una letra mayúscula
    public static boolean esMayuscula(char c) {
        return (c >= 'A' && c <= 'Z');
    }

    // Cuenta las vocales en un mensaje
    public static int contarVocales(String mensaje) {
        int contador = 0;
        for (int i = 0; i < mensaje.length(); i++) {
            char c = mensaje.charAt(i);
            if (esVocal(c)) {
                contador++; // Si es vocal, incrementar el contador
            }
        }
        return contador;
    }

    // Verifica si un carácter es una vocal (sin acentos)
    public static boolean esVocal(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}

/*
 * 
 * ENCRIPTACION MENSAJES
 * 
 * Encriptación de mensajes
 * Tiempo máximo: 1,000 s Memoria máxima: 4096 KiB
 * Uno de los métodos más antiguos para codificar mensajes es el conocido como
 * cifrado Cesar. Su funcionamiento es simple: cada una de las letras del
 * mensaje original es sustituida por otra letra que se encuentra un número fijo
 * de posiciones más adelante en el alfabeto.
 * 
 * Así, si utilizamos un desplazamiento de 2, las apariciones de la letra 'a' se
 * sustituyen por la 'c', todas las apariciones de la 'b' por 'd', etc. El
 * método tradicional comienza de nuevo al llegar al final del alfabeto, de
 * forma que, con el desplazamiento de 2, la 'y' se sustituye por la 'a' y la
 * 'z' se sustituye por la 'b'.
 * 
 * Los desplazamientos también pueden ser negativos; si utilizamos un
 * desplazamiento de -1, la 'E' se convertirá en 'D', mientras que la 'a' pasará
 * a ser 'z'.
 * 
 * Nuestro cifrado Cesar no codifica los caracteres que no sean letras
 * anglosajonas. Así, por ejemplo, los espacios o los símbolos de puntuación no
 * sufrirán cambio alguno.
 * 
 * Entrada
 * 
 * La entrada está formada por un número indeterminado de casos de prueba.
 * 
 * Cada caso de prueba consiste en una única línea cuyo primer carácter es el
 * código de la letra 'p', seguido de un mensaje codificado con el método Cesar
 * descrito antes utilizando el desplazamiento adecuado para que la letra 'p' se
 * codifique con ese primer carácter.
 * 
 * Los casos de prueba terminan con un mensaje codificado que, una vez
 * traducido, contiene exactamente la cadena "FIN". Cuando se lee este mensaje
 * codificado el programa debe terminar sin generar ninguna otra salida más.
 * 
 * Salida
 * 
 * Para cada caso de prueba, el programa indicará el número de vocales no
 * acentuadas que contiene el mensaje codificado.
 * 
 * Entrada de ejemplo
 * 
 * pEsta cadena esta sin codificar
 * pfin
 * qbfjpvBFJPV
 * ozdhntZDHNT
 * xXzwoziui-Um
 * qGJO
 */