package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class CogeElSobre {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Leer el número total de sobres y la cantidad de sobres a seleccionar
            int totalSobres = scanner.nextInt();
            int sobresASeleccionar = scanner.nextInt();

            // Condición de terminación
            if (totalSobres == 0 && sobresASeleccionar == 0)
                break;

            // Array para almacenar las cantidades de dinero en los sobres
            int[] valoresSobres = new int[totalSobres];

            // Leer los valores de los sobres
            for (int i = 0; i < totalSobres; i++) {
                valoresSobres[i] = scanner.nextInt();
            }

            // Array para almacenar los valores máximos de cada conjunto de sobres
            // seleccionados
            int[] maximosPorGrupo = new int[totalSobres - sobresASeleccionar + 1];

            // Inicializar el máximo de la primera ventana de sobres seleccionados
            int maximoActual = valoresSobres[0];
            for (int i = 1; i < sobresASeleccionar; i++) {
                if (valoresSobres[i] > maximoActual) {
                    maximoActual = valoresSobres[i];
                }
            }
            maximosPorGrupo[0] = maximoActual;

            // Deslizar la ventana sobre los sobres para encontrar los máximos en cada grupo
            for (int inicio = 1; inicio <= totalSobres - sobresASeleccionar; inicio++) {
                // Si el máximo anterior sigue en la nueva ventana, solo comparar el nuevo
                // elemento
                if (valoresSobres[inicio + sobresASeleccionar - 1] > maximoActual) {
                    maximoActual = valoresSobres[inicio + sobresASeleccionar - 1];
                } else if (valoresSobres[inicio - 1] == maximoActual) { // Si el máximo anterior se sale, recalcular
                    maximoActual = valoresSobres[inicio];
                    for (int j = inicio; j < inicio + sobresASeleccionar; j++) {
                        if (valoresSobres[j] > maximoActual) {
                            maximoActual = valoresSobres[j];
                        }
                    }
                }
                maximosPorGrupo[inicio] = maximoActual;
            }

            // Imprimir los valores máximos por cada conjunto de sobres seleccionados
            for (int i = 0; i < maximosPorGrupo.length; i++) {
                System.out.print(maximosPorGrupo[i] + (i < maximosPorGrupo.length - 1 ? " " : "\n"));
            }
        }
        scanner.close();
    }
}

/*
 * Coge el sobre y corre
 * Tiempo máximo: 2,000-6,000 s Memoria máxima: 10240 KiB
 * ...
 * Pedro Franqueza fue nombrado tesorero hace unos años. Desde entonces sus
 * distintos chanchullos le han hecho una persona muy influyente. En la cajonera
 * que tiene debajo de su mesa guarda una hilera de sobres, cada uno con una
 * cantidad de dinero conseguido de manera dudosa.
 * 
 * Hoy tiene una cena de negocios en el bar Cenás a la que irá el presidente y
 * otros nueve compañeros. Para mantenerlos contentos, justo antes de salir del
 * despacho mete la mano en el cajón y coge diez sobres consecutivos para
 * repartirlos allí mismo. No ha tenido tiempo de mirar cuánto dinero hay en
 * cada sobre, así que habrá que repartirlos sobre la marcha. Eso sí, el
 * presidente se quedará con el sobre que más dinero tenga.
 * 
 * En el coche yendo hacia el bar va pensando en cómo podría averiguar
 * rápidamente cuánto dinero le correspondería al presidente en base al grupo de
 * 10 sobres consecutivos seleccionados. Y como tiene aires de grandeza, se
 * plantea si sería capaz de hacerlo si guardara hasta 500.000 sobres en su
 * cajonera.
 * 
 * Entrada
 * La entrada está compuesta por distintos casos de prueba que representan días
 * distintos en la vida de Pedro Franqueza.
 * 
 * Cada caso aparece en dos líneas consecutivas. La primera de ellas contiene
 * dos enteros, el primero con el número de sobres que guarda en el cajón (1 ≤ n
 * ≤ 500.000) y el segundo el número de sobres que tiene que coger para ir a la
 * cena, o lo que es lo mismo, el número de comensales que se llevarán un sobre,
 * incluído el presidente (1 ≤ k ≤ min(n, 200.000)). La segunda línea contiene n
 * números mayores o iguales a 1 con el dinero que hay en cada uno de los
 * sobres.
 * 
 * La entrada termina con un caso sin sobres, que no debe procesarse.
 * 
 * Salida
 * Para cada caso de prueba se escribirá una única línea con n − k + 1 números
 * que indicarán la cantidad de dinero que se llevará esa noche el presidente
 * dependiendo de qué sobres coja Pedro. En particular, el primer número será el
 * dinero para el presidente si coge los k primeros sobres; el segundo si se
 * salta el primer sobre y coge los k siguientes, etc. En general, el número
 * i-ésimo indica la cantidad que se llevará el presidente si coge los k sobres
 * desde el sobre i hasta el sobre i + k − 1.
 * 
 * 
 * 
 * Entrada de ejemplo
 * 6 1
 * 3 8 5 12 15 9
 * 6 3
 * 3 8 5 12 15 9
 * 0 0
 * Salida de ejemplo
 * 3 8 5 12 15 9
 * 8 12 15 15
 * 
 */