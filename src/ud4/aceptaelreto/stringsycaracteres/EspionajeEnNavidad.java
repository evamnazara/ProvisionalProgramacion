package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class EspionajeEnNavidad {

    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada
        Scanner sc = new Scanner(System.in);

        // Leer líneas hasta que encontremos "FIN"
        while (true) {
            String linea = sc.nextLine();

            // Si la línea es "FIN", terminamos el proceso
            if (linea.equals("FIN")) {
                break;
            }

            // Encriptar la línea
            String lineaEncriptada = encriptar(linea);

            // Imprimir la línea encriptada
            System.out.println(lineaEncriptada);
        }

        // Cerrar el scanner
        sc.close();
    }

    // Función que encripta la línea
    public static String encriptar(String linea) {
        // Crear un StringBuilder para construir la línea encriptada
        String encriptada = "";

        // Recorrer cada carácter de la línea
        for (int i = 0; i < linea.length(); i++) {
            char c = linea.charAt(i);

            // Si es un espacio, lo agregamos tal cual
            if (c == ' ') {
                encriptada += ' ';
            } else {
                // Si es una letra, la desplazamos una posición
                // Si la letra es 'Z', la convertimos a 'A'
                if (c == 'Z') {
                    encriptada += 'A';
                } else {
                    encriptada += (char) (c + 1); // Desplazamos una posición hacia adelante
                }
            }
        }

        return encriptada;
    }
}

/*
 * Espionaje en Navidad
 * Los Reyes Magos han detectado que Papá Noel tiene renos espía para averiguar
 * qué han pedido los niños a los Reyes Magos y traerles él antes el regalo.
 * 
 * Para contrarestarlo, los Reyes Magos, que son grandes sabios de Oriente, han
 * pedido a sus niños que envíen las cartas encriptadas. Para facilitarles la
 * tarea, te han encargado hacer un programa que los pequeños puedan usar para
 * encriptar sus cartas.
 * 
 * El mecanismo de encriptación es sencillo; al fin y al cabo los renos no son
 * muy inteligentes y casi cualquier cosa será suficiente para que no entiendan
 * nada. Consistirá en desplazar cada letra una posición en el alfabeto hacia
 * delante. Por ejemplo, allí donde haya una letra A se pondrá una B, donde haya
 * una letra B se pondrá una C… y donde haya una letra Z se pondrá una A.
 * 
 * Como queremos que el programa sirva para niños que están todavía aprendiendo
 * a leer y a escribir, sólo tendrá que admitir letras mayúsculas y espacios,
 * que se quedarán sin ningún cambio.
 * 
 * Entrada
 * El programa deberá leer múltiples casos de prueba, cada uno compuesto por una
 * línea de no más de 100 caracteres.
 * 
 * Las líneas contendrán únicamente letras del alfabeto inglés en mayúsculas,
 * por lo que no contendrá ni la letra Ñ ni vocales con tilde. También podrán
 * aparecer espacios (aunque no al principio ni al final), y no habrá ningún
 * otro símbolo de puntuación.
 * 
 * La entrada terminará con una línea con, exactamente, el texto "FIN", que no
 * deberá procesarse.
 * 
 * Salida
 * Por cada caso de prueba el programa deberá escribir la línea correspondiente
 * encriptada.
 * 
 * Entrada de ejemplo
 * QUERIDOS REYES MAGOS
 * HE SIDO MUY PERO QUE MUY BUENO
 * Y QUIERO QUE ME TRAIGAIS UNA ZAMBOMBA
 * FIN
 * Salida de ejemplo
 * RVFSJEPT SFZFT NBHPT
 * IF TJEP NVZ QFSP RVF NVZ CVFOP
 * Z RVJFSP RVF NF USBJHBJT VOB ABNCPNCB
 */