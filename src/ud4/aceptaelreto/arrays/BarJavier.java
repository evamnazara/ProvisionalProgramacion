package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class BarJavier {

    public static void main(String[] args) {

        double[] ventas = new double[5]; // Para las categorías: D, A, M, I, C
        String[] categorias = { "DESAYUNOS", "COMIDAS", "MERIENDAS", "CENAS", "COPAS" };

        Scanner sc = new Scanner(System.in);

        // bucle hasta que llegue "N 0"
        while (true) {
            System.out.println("CAJA DEL DÍA:");
            // Leer la categoría y el valor de la venta
            System.out.println("Categoría de la venta: (D, A, M, I, C)");
            String categoria = sc.nextLine();
            System.out.println("Caja hecha: ");
            double venta = sc.nextDouble();

            sc.nextLine(); // buffer

            // cierre de caja: si categoría es "N" y el valor es 0
            if (categoria.equals("N") && venta == 0) {
                // calculo de la media de ventas
                double sumaVentas = 0;
                int numVentas = 0;

                // suma de todas las ventas para calcular la media
                for (int i = 0; i < 5; i++) {
                    sumaVentas += ventas[i];
                    if (ventas[i] > 0) {
                        numVentas++;
                    }
                }

                double mediaVentas = sumaVentas / numVentas;

                // máximo y el mínimo de las ventas
                // inicialización de valores de las variables
                double maxVenta = 0;
                double minVenta = 0;
                String maxCategoria = "";
                String minCategoria = "";
                boolean empateMax = false;
                boolean empateMin = false;

                // Determinar las categorías con la máxima y mínima venta
                for (int i = 0; i < 5; i++) {
                    if (ventas[i] > maxVenta) {
                        maxVenta = ventas[i];
                        maxCategoria = categorias[i];
                        empateMax = false;
                    } else if (ventas[i] == maxVenta) {
                        empateMax = true;
                    }

                    if (ventas[i] < minVenta) {
                        minVenta = ventas[i];
                        minCategoria = categorias[i];
                        empateMin = false;
                    } else if (ventas[i] == minVenta) {
                        empateMin = true;
                    }
                }

                // Si hay empate en el máximo o el mínimo
                if (empateMax) {
                    maxCategoria = "EMPATE";
                }
                if (empateMin) {
                    minCategoria = "EMPATE";
                }

                // Verificar si las ventas de COMIDAS superan la media
                String respuestaComidas = ventas[1] > mediaVentas ? "SI" : "NO";

                // resultado de cada día
                System.out.println(maxCategoria + "#" + minCategoria + "#" + respuestaComidas);

                // Reiniciar las ventas para el siguiente día
                for (int i = 0; i < 5; i++) {
                    ventas[i] = 0;
                }

            } else {
                // Almacenar la venta en la categoría correspondiente
                switch (categoria) {
                    case "D":
                        ventas[0] += venta;
                        break;
                    case "A":
                        ventas[1] += venta;
                        break;
                    case "M":
                        ventas[2] += venta;
                        break;
                    case "I":
                        ventas[3] += venta;
                        break;
                    case "C":
                        ventas[4] += venta;
                        break;
                    default:
                        System.out.println("Categoría no válida.");

                        sc.close();
                }
            }
        }
    }
}
/*
 * De nuevo en el bar de Javier
 * Tiempo máximo: 2,000 s Memoria máxima: 4096 KiB
 * Tras las medidas tomadas, Javier ha visto que las ventas de su bar han
 * mejorado bastante, así que ha decidido seguir adelante con su estudio. Ahora
 * le gustaría investigar con qué productos gana más dinero y con cuáles gana
 * menos. Además, también le gustaría saber si las ventas en comidas superan la
 * media. Para ello ha establecido varias categorías:
 * 
 * Código Categoría
 * D Desayunos
 * A Comidas
 * M Meriendas
 * I Cenas
 * C Copas
 * Javier encuadra cada venta que realiza dentro de una de esas categorías.
 * Cuando tiene un momento, pasa los datos de todas las ventas al ordenador, y
 * le gustaría que le devolviese los siguientes valores: la categoría que más
 * dinero ha recaudado, la que menos, y si el dinero conseguido con las comidas
 * supera la media. No es demasiado constante registrando datos, pero nunca deja
 * un día a medias de introducir.
 * 
 * Realiza un programa que ayude a Javier en su cometido.
 * 
 * Entrada
 * El programa recibirá una lista de ventas realizadas. Cada una constará de una
 * categoría (D, A, M, I o C) y un valor (real). Cuando el día termina, Javier
 * introduce una categoría inexistente (N) con valor cero (es decir, N 0).
 * 
 * Salida
 * Para cada día, el programa generará una línea que contendrá tres valores
 * separados por la almohadilla ("#"). Los dos primeros indicarán el nombre de
 * las categorías que han supuesto más y menos beneficios respectivamente (ten
 * en cuenta que si de una categoría no se ha vendido nada, su beneficio es
 * cero); las categorías se indicarán con sus nombres, DESAYUNOS, COMIDAS,
 * MERIENDAS, CENAS o COPAS. El tercer valor de la línea indicará "SI" si la
 * media gastada por los clientes en las comidas superó a la media de ventas del
 * día, y "NO" en caso contrario.
 * 
 * En caso de que existan varias categorías que hayan conseguido el máximo o
 * mínimo de ventas, se especificará "EMPATE".
 * 
 * Entrada de ejemplo
 * D 2.80
 * C 48.00
 * A 8.00
 * N 0
 * D 15.33
 * A 60.00
 * M 12.00
 * I 25.00
 * N 0
 * Salida de ejemplo
 * 
 * COPAS#EMPATE#NO
 * COMIDAS#COPAS#SI
 */