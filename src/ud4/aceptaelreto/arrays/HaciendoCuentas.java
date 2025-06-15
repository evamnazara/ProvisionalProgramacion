package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class HaciendoCuentas {

    public static void main(String[] args) {
        Scanner entradaUsuario = new Scanner(System.in);

        System.out.println("Bienvenido al programa de cuentas de Diana.");

        while (true) {
            // Leer el saldo inicial y el número de movimientos
            System.out.println("\nIntroduce el saldo inicial y el número de movimientos:");
            int saldoInicial = entradaUsuario.nextInt();
            int numeroMovimientos = entradaUsuario.nextInt();

            // Si el número de movimientos es 0, terminamos el programa
            if (numeroMovimientos == 0) {
                System.out.println("Fin de los casos de prueba.");
                break;
            }

            // Crear un array para almacenar los saldos de cada mes
            int[] saldoPorMes = new int[12];

            // Inicializar los saldos con el saldo inicial
            for (int i = 0; i < 12; i++) {
                saldoPorMes[i] = saldoInicial;
            }

            // Leer los movimientos y actualizar el saldo
            System.out.println("Introduce los movimientos (fecha + cantidad + concepto):");
            entradaUsuario.nextLine(); // Limpiar el buffer de la línea anterior
            for (int i = 0; i < numeroMovimientos; i++) {
                // Leer cada movimiento (fecha, cantidad y concepto)
                String movimiento = entradaUsuario.nextLine();

                // Analizar la fecha, la cantidad y el concepto del movimiento
                int dia = (movimiento.charAt(0) - '0') * 10 + (movimiento.charAt(1) - '0'); // Día del movimiento
                int mes = (movimiento.charAt(3) - '0') * 10 + (movimiento.charAt(4) - '0'); // Mes del movimiento
                int cantidad = 0;

                // Revisar si es ingreso (+) o gasto (-)
                if (movimiento.charAt(6) == '+') {
                    cantidad = 0; // Ingreso, inicialmente el valor será positivo
                    for (int j = 7; j < movimiento.length() && movimiento.charAt(j) != ' '; j++) {
                        cantidad = cantidad * 10 + (movimiento.charAt(j) - '0');
                    }
                } else {
                    cantidad = 0; // Gasto, inicialmente el valor será negativo
                    for (int j = 7; j < movimiento.length() && movimiento.charAt(j) != ' '; j++) {
                        cantidad = cantidad * 10 + (movimiento.charAt(j) - '0');
                    }
                    cantidad = -cantidad; // Convertimos a negativo si es gasto
                }

                // Actualizamos el saldo en el mes correspondiente
                saldoPorMes[mes - 1] += cantidad; // Restamos 1 porque los meses en el array son 0-indexados
            }

            // Mostrar el saldo estimado al finalizar cada mes
            System.out.println("Saldo estimado al final de cada mes:");
            for (int i = 0; i < 12; i++) {
                System.out.print(saldoPorMes[i] + " ");
            }
            System.out.println("\n---"); // Separador entre casos de prueba
        }

        entradaUsuario.close();
    }
}

/*
 * Haciendo cuentas
 * Hucha con forma de cerdito, con monedas al lado
 * Diana es una chica muy organizada y cada Navidad analiza sus cuentas para el
 * año siguiente. Aprovechando las vacaciones escolares, dedica algunos ratos a
 * anotar en un cuaderno los ingresos y gastos que cree que tendrá durante el
 * año que está a punto de empezar (ir al cine, cenar un día con sus amigos, su
 * paga mensual, el dinero que su tío le da,…).
 * 
 * Eso sí, el resultado final en su cuaderno es un poco caótico. Los ingresos y
 * gastos le van viniendo a la cabeza en cualquier orden y como los apunta
 * inmediatamente según los va recordando no quedan anotados por orden
 * cronológico. Es normal entonces que sea difícil tener clara la evolución de
 * sus ahorros y cuánto dinero tendrá disponible en cada momento.
 * 
 * Sabiendo cuánto dinero tendrá al empezar el año, ¿cuánto estima que tendrá al
 * terminar cada mes?
 * 
 * Entrada
 * Cada caso de prueba comienza con una primera línea con la cantidad de dinero
 * con la que Diana comienza el año y el número de movimientos que ha anotado en
 * su libreta. A continuación, aparecen los movimientos previstos que tiene para
 * todo el año.
 * 
 * Cada movimiento se especifica en una línea que comienza con la fecha en
 * formato DD-MM con el día y mes en el que tendrán lugar (puedes asumir que el
 * año no es bisiesto). Después aparece la cantidad, empezando con un + si es un
 * ingreso o con - si es un gasto. Finalmente aparece el concepto.
 * 
 * Se garantiza que todos los números serán enteros, que los fondos de Diana
 * nunca serán mayores que 109 ni negativos, y que no habrá más de un movimiento
 * diario. El concepto de cada movimiento es una frase con letras mayúsculas y
 * minúsculas del alfabeto inglés, números y espacios de no más de 100
 * caracteres.
 * 
 * Salida
 * Por cada caso de prueba se escribirán doce números separados por espacio
 * indicando la cantidad estimada de dinero que tendrá Diana al acabar cada mes
 * del año tras aplicar todos los movimientos.
 * 
 * Entrada de ejemplo
 * 150 17
 * 01-01 +30 Regalo tio
 * 01-02 -10 Cenar con mis amigos
 * 05-02 -12 Ir al cine
 * 02-02 +45 Paga
 * 03-03 -12 Ir al cine
 * 04-04 -45 Invitar a mis amigos
 * 05-05 +45 Paga
 * 06-06 -12 Ir al cine
 * 01-09 -30 De compras
 * 02-10 -10 Comprar un libro
 * 02-11 -12 Ir al cine
 * 12-12 -20 Comprar un libro
 * 11-12 -35 Ropa
 * 01-11 -45 Gimnasio
 * 01-10 +45 Paga
 * 03-02 -12 Ir al cine
 * 01-03 +45 Paga
 * Salida de ejemplo
 * 
 * 180 191 224 179 224 212 212 212 182 217 160 105
 * 
 */