package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class CartasAbuelo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Introduce la cadena escrita por el abuelo (o '0' para terminar):");
            String cadena = sc.nextLine(); // Leer la cadena
            if (cadena.equals("0")) {
                break; // Si la cadena es "0", terminamos la entrada
            }

            // Preprocesamos la cadena para obtener el array de igualdades
            boolean[] igual = cadenaIgual(cadena);

            System.out.println("¿Cuántos intervalos quieres verificar?");
            int n = Integer.parseInt(sc.nextLine()); // Leer número de intervalos
            if (n == 0) {
                System.out.println("No hay intervalos que verificar. Fin del caso de prueba.");
                continue;
            }

            // Procesamos los intervalos
            for (int i = 0; i < n; i++) {
                System.out.println("Introduce el intervalo " + (i + 1) + " (dos índices separados por espacio):");
                String[] interval = sc.nextLine().split(" ");
                int iPos = Integer.parseInt(interval[0]);
                int jPos = Integer.parseInt(interval[1]);

                // Aseguramos que iPos es siempre el menor y jPos el mayor
                if (iPos > jPos) {
                    int temp = iPos;
                    iPos = jPos;
                    jPos = temp;
                }

                // Comprobamos si todos los caracteres entre iPos y jPos son iguales
                if (checkEqual(igual, iPos, jPos)) {
                    System.out.println("SI");
                } else {
                    System.out.println("NO");
                }
            }

            System.out.println(); // Línea en blanco al final de cada caso de prueba
        }

        sc.close();
    }

    // Función para preprocesar la cadena y construir el array de igualdad
    public static boolean[] cadenaIgual(String s) {
        int n = s.length();
        boolean[] igual = new boolean[n]; // Igual[i] será true si s[i] == s[i-1]

        for (int i = 1; i < n; i++) {
            igual[i] = (s.charAt(i) == s.charAt(i - 1)); // Verifica si el carácter actual es igual al anterior
        }

        return igual;
    }

    // Función para verificar si todos los caracteres entre i y j son iguales
    public static boolean checkEqual(boolean[] igual, int i, int j) {
        if (i == j) {
            return true; // Si i == j, siempre son iguales
        }

        // Comprobamos los valores de igual en el rango entre i y j
        for (int k = i + 1; k <= j; k++) {
            if (!igual[k]) {
                return false; // Si encontramos una diferencia, no son iguales
            }
        }

        return true;
    }
}

/*
 * Las cartas del abuelo
 * El abuelo lleva toda la vida escribiendo cartas a máquina. Aún recuerda con
 * nostalgia aquella vieja máquina de escribir en la que metía el folio y lo
 * colocaba centrándolo con mimo, para después pulsar las duras teclas que
 * terminaban moviendo de forma mecánica los tipos que golpeaban el papel.
 * "En relación a tu misiva del..." decía el abuelo. TAC, TAC, TAC, TAC...
 * contestaba la máquina de escribir. Sus dedos han desplazado miles y miles de
 * veces los tipos de su vieja máquina de escribir desde su posición estática
 * hasta los folios que luego terminaban siendo leídos por familiares en
 * distintas partes del mundo. La hoy silenciosa máquina, ha sido testigo
 * ruidosa de alegrías y penas, nacimientos y despedidas, felicitaciones
 * navideñas y lamentos por los tiempos que quedaron atrás.
 * Pero llegó el día en el que la vieja máquina de escribir no pudo trabajar
 * más. A la creciente dificultad en encontrar cintas de tinta para ella, se
 * unió la falta del necesario mantenimiento de sus diferentes elementos
 * (limpieza y lubricado), que terminaron desencadenando la rotura de piezas
 * internas descatalogadas hacía décadas.
 * 
 * Hoy, guiado por sus nietos, el abuelo intenta acostumbrarse a la escritura de
 * cartas en un ordenador. Pero le cuesta mucho. Los teclados modernos son mucho
 * más delicados y los dedos del abuelo insisten en presionar las teclas con
 * fuerza y lentitud. Para su desesperación, el ordenador se empeña en repetir
 * las letras, algo que su vieja amiga nunca habría hecho. El resultado es que
 * cuando intenta escribir:
 * 
 * Querido hermano, te ...
 * 
 * lo que obtiene son cosas como:
 * 
 * Quuueeriiiiiiido hermaaaanooooo,, ttte ...
 * 
 * La pregunta que nos hacemos es ¿serías capaz de saber si entre dos posiciones
 * del texto que ha escrito todas las letras son iguales? Dicho más formalmente,
 * dada la cadena escrita por el abuelo y dos posiciones i y j de esa cadena,
 * queremos que nos digas si todos los caracteres entre la posición i y la j son
 * iguales o no, ambas inclusive.
 * 
 * Entrada
 * La entrada estará compuesta por distintos casos de prueba. Para cada caso de
 * prueba la primera línea contendrá la cadena (de hasta un millón de
 * caracteres) escrita por el abuelo. Posteriormente vendrá un número n que
 * indica el número de intervalos que vienen a continuación. Siguen los n
 * intervalos en líneas independientes, expresados como dos enteros que siempre
 * estarán en el intervalo 0..l-1, siendo l la longitud de la cadena.
 * 
 * La entrada termina cuando el número de intervalos de un caso de prueba es 0.
 * 
 * Salida
 * Cada intervalo de números i, j genera una línea en la salida. Si todos los
 * caracteres entre min(i,j) y max(i,j) (ambos incluídos) son iguales, se
 * escribirá SI; si hay caracteres distintos, se escribirá NO. Al terminar el
 * conjunto de intervalos de cada caso de prueba se añadirá una línea en blanco
 * adicional.
 * 
 * Entrada de ejemplo
 * Hooolaa
 * 4
 * 0 6
 * 1 3
 * 3 2
 * 1 2
 * Adios
 * 1
 * 1 2
 * Y con esto, Dios te de salud, y a mi no olvide. Vale.
 * 0
 * Salida de ejemplo
 * 
 * NO
 * SI
 * SI
 * SI
 * 
 * NO
 * 
 */