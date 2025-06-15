package ud4.aceptaelreto.arrays;

public class CuentasParalelas {

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        while (true) {
            // Leer el número de movimientos
            int n = scanner.nextInt();

            // Si el número de movimientos es 0, terminamos el proceso
            if (n == 0) {
                break;
            }

            // Leer los movimientos de la cuenta
            int[] movimientos = new int[n];
            for (int i = 0; i < n; i++) {
                movimientos[i] = scanner.nextInt();
            }

            // Llamar a la función para calcular los puntos de singularidad
            encontrarSingularidades(movimientos);
        }

        // Cerrar el scanner
        scanner.close();
    }

    // Función para encontrar los puntos de singularidad
    public static void encontrarSingularidades(int[] movimientos) {
        // Calcular la suma total de los movimientos
        int sumaTotal = 0;
        for (int i = 0; i < movimientos.length; i++) {
            sumaTotal += movimientos[i];
        }

        // Si la suma total es impar, no puede haber puntos de singularidad
        if (sumaTotal % 2 != 0) {
            System.out.println(0);
            return;
        }

        // La mitad de la suma total
        int mitadSumaTotal = sumaTotal / 2;

        // Variable para el saldo acumulado
        int saldoAcumulado = 0;

        // Contador para los puntos de singularidad
        int singularidades = 0;

        // Recorrer los movimientos y verificar si en algún punto el saldo acumulado es
        // igual a la mitad de la suma total
        for (int i = 0; i < movimientos.length; i++) {
            saldoAcumulado += movimientos[i];

            // Verificar si el saldo acumulado es igual a la mitad de la suma total
            if (saldoAcumulado == mitadSumaTotal) {
                singularidades++;
            }
        }

        // Imprimir el número de puntos de singularidad encontrados
        System.out.println(singularidades);
    }
}

/*
 * Cuentas paralelas
 * Tiempo máximo: 1,000-3,000 s Memoria máxima: 8192 KiB
 * Tras terminar sus estudios hace un par de meses, Consuelo se abrió una cuenta
 * bancaria para empezar a recibir ahí el sueldo de su primer trabajo
 * remunerado. Desde entonces la cuenta ha tenido unos pocos movimientos. En
 * concreto, la ingresaron 1000 euros del primer sueldo con los que pagó una
 * cena en la que invitó a sus padres (150 euros), una compra en un conocido
 * supermercado (80 euros) y una reserva de una casa rural para el siguiente
 * puente (200). El mes terminó y la volvieron a pagar (1040 euros, un poco más
 * que el mes anterior) y ayer mismo se gastó otros 70 euros en el supermercado.
 * 
 * Hoy revisándolos se ha dado cuenta de que si tras pagar los primeros 80 euros
 * en el supermercado se hubiera creado una segunda cuenta y hubiera dejado
 * congelada la primera, ambas tendrían exactamente el mismo saldo:
 * 
 * 1000−150−80suma=770−2001040−70suma=770
 * Le ha resultado tan curioso que le gustaría poder seguir averiguando si los
 * movimientos de su cuenta y las de sus amigos tienen estos puntos de
 * singularidad también o no.
 * 
 * Entrada
 * La entrada estará compuesta por distintos casos de prueba, cada uno ocupando
 * dos líneas.
 * 
 * La primera línea de cada caso de prueba contiene un número que indica la
 * cantidad de movimientos de una de las cuentas analizadas por Consuelo (nunca
 * será mayor que 100.000). En la segunda línea aparece un número entero por
 * cada movimiento de la cuenta. Cada cantidad no superará el 1.000.000 en valor
 * absoluto. Se garantiza, además, que la suma de los valores absolutos de todos
 * los movimientos no superará 2×109.
 * 
 * La entrada termina con una línea conteniendo un 0.
 * 
 * Salida
 * Para cada caso de prueba se escribirá un número indicando la cantidad de
 * instantes de tiempo en los que el dueño de la cuenta bancaria podría haber
 * creado una segunda cuenta de forma que ambas tuvieran el mismo saldo final.
 * 
 * Entrada de ejemplo
 * 6
 * 1000 -150 -80 -200 1040 -70
 * 2
 * 100 -100
 * 0
 * Salida de ejemplo
 * 1
 * 2
 * 
 */
