package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class Potitos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce los casos de prueba (0 para finalizar):");

        while (true) {
            String numeroPotitos = sc.nextLine().trim();

            if (numeroPotitos.equals("0")) {
                System.out.println("Fin del programa.");
                break;
            }

            int cantidadPotitos = obtenerNumero(numeroPotitos);
            String[] ingredientesRechazados = new String[100];
            int contadorRechazados = 0;

            for (int i = 0; i < cantidadPotitos; i++) {
                String linea = sc.nextLine().trim();

                if (linea.startsWith("NO:")) {
                    String[] ingredientes = obtenerIngredientes(linea);
                    for (String ingrediente : ingredientes) {
                        if (!existeEnLista(ingrediente, ingredientesRechazados, contadorRechazados)) {
                            ingredientesRechazados[contadorRechazados++] = ingrediente;
                        }
                    }
                }
            }

            ordenarLista(ingredientesRechazados, contadorRechazados);
            imprimirLista(ingredientesRechazados, contadorRechazados);
        }

        sc.close();
    }

    private static int obtenerNumero(String texto) {
        int numero = 0;
        for (int i = 0; i < texto.length(); i++) {
            numero = numero * 10 + (texto.charAt(i) - '0');
        }
        return numero;
    }

    private static String[] obtenerIngredientes(String linea) {
        String[] partes = linea.split(" ");
        String[] ingredientes = new String[partes.length - 1];
        int index = 0;

        for (int i = 1; i < partes.length; i++) {
            if (partes[i].equals("FIN"))
                break;
            ingredientes[index++] = partes[i];
        }

        String[] resultado = new String[index];
        for (int i = 0; i < index; i++) {
            resultado[i] = ingredientes[i];
        }

        return resultado;
    }

    private static boolean existeEnLista(String ingrediente, String[] lista, int tamaño) {
        for (int i = 0; i < tamaño; i++) {
            if (lista[i].equals(ingrediente)) {
                return true;
            }
        }
        return false;
    }

    private static void ordenarLista(String[] lista, int tamaño) {
        for (int i = 0; i < tamaño - 1; i++) {
            for (int j = i + 1; j < tamaño; j++) {
                if (lista[i].compareTo(lista[j]) > 0) {
                    String temp = lista[i];
                    lista[i] = lista[j];
                    lista[j] = temp;
                }
            }
        }
    }

    private static void imprimirLista(String[] lista, int tamaño) {
        for (int i = 0; i < tamaño; i++) {
            if (i > 0)
                System.out.print(" ");
            System.out.print(lista[i]);
        }
        System.out.println();
    }
}

/*
 * Potitos
 * "¡Javi! ¡Parece que éste tampoco le gusta!" se convirtió en cantinela
 * habitual a la hora de la comida, antes de que el pequeño dejara
 * definitivamente de comer potitos una tarde. Darle de comer era misión
 * imposible; pese a la paciencia de sus padres, el niño había heredado el
 * carácter cabezón del padre y mantenía la boca cerrada, inmune a los vuelos de
 * la cucharita y a las monerías de quienes le rodeaban. Era necesario encontrar
 * una solución.
 * 
 * Se les ocurrió que, quizá, el aparentemente caprichoso rechazo a los potitos
 * se debía a algún ingrediente concreto. Comenzaron a anotar, cuidadosamente,
 * todos los ingredientes de cada potito que le daban, junto con un comentario
 * de si el pequeño se lo había tomado o no. Tras varios días, estaban
 * convencidos de que podrían averiguar cuáles eran los ingredientes que no le
 * gustaban, y así comprar aquellos potitos que fuera a comerse. ¿Puedes
 * ayudarles a encontrarlos?
 * 
 * Entrada
 * La entrada estará compuesta de múltiples casos de prueba. Cada uno comienza
 * con un número indicando el número de potitos que se han intentado dar al bebé
 * (como máximo 25).
 * 
 * A continuación aparece una línea por cada potito. La línea comienza por SI: o
 * NO: dependiendo de si el pequeño se comió o no el potito. Después aparece la
 * lista de los ingredientes del potito separados por espacios. La lista se
 * cierra con la palabra FIN, que no debe considerarse un ingrediente. Ningún
 * potito tiene más de 10 ingredientes, y todos los ingredientes están
 * compuestos por una única palabra de hasta 20 letras minúsculas.
 * 
 * La entrada acaba con un caso de prueba sin potitos.
 * 
 * Salida
 * Para cada caso de prueba se deben mostrar, en una línea, los ingredientes que
 * no le gustan al niño, ordenados alfabéticamente y separados por espacio. Si
 * todos los ingredientes le gustan, se dejará la linea en blanco.
 * 
 * Entrada de ejemplo
 * 3
 * SI: patata maiz tomate FIN
 * NO: patata puerro guisantes pollo FIN
 * SI: tomate zanahoria puerro pollo calabacin arroz FIN
 * 2
 * SI: tomate zanahoria pollo calabacin arroz FIN
 * NO: tomate ternera puerro FIN
 * 0
 * Salida de ejemplo
 * guisantes
 * puerro ternera
 */