package ud4.aceptaelreto.arrays;

public class ReinaDelSuper {

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        // Leer múltiples casos de prueba
        while (true) {
            // Leemos el número de cajas (n) y el número de clientes (c)
            int n = sc.nextInt();
            int c = sc.nextInt();

            // Si encontramos un caso con 0 0, terminamos la entrada
            if (n == 0 && c == 0) {
                break;
            }

            // Arreglo que almacenará el tiempo de espera acumulado en cada caja
            int[] cajas = new int[n];

            // Leemos los tiempos que tardarán los clientes
            int[] clientes = new int[c];
            for (int i = 0; i < c; i++) {
                clientes[i] = sc.nextInt();
            }

            // Asignamos los clientes a las cajas
            for (int i = 0; i < c; i++) {
                // Buscar la caja con el tiempo más bajo de atención
                int cajaAsignada = 0;
                for (int j = 1; j < n; j++) {
                    if (cajas[j] < cajas[cajaAsignada]) {
                        cajaAsignada = j;
                    }
                }

                // Asignamos al cliente a esa caja
                cajas[cajaAsignada] += clientes[i];

                // Si es el último cliente (Ismael), mostramos la caja en la que fue asignado
                if (i == c - 1) {
                    System.out.println(cajaAsignada + 1); // Las cajas están numeradas de 1 a n
                }
            }
        }

        sc.close();
    }
}

/*
 * Reina del súper
 * Tiempo máximo: 1,000 s Memoria máxima: 4096 KiB
 * Carros de la compra multicolor
 * Hace tiempo, Ismael se enamoró perdidamente de una cajera del supermercado.
 * No se cansa de espiarla entre la sección de ofertas y menaje del hogar.
 * 
 * Tiene la tarjeta echando humo, porque aunque tenga la nevera llena, todas las
 * tardes baja a comprar cualquier cosa con tal de volver a verla. Y da igual
 * cuánta gente haya; él siempre se pone a esperar en la fila de su caja.
 * 
 * Pero al llegar hoy al súper se ha llevado una desagradable sorpresa. Al
 * cerebrito de turno que gestiona el supermercado le ha dado por instaurar la
 * "fila única". Ahora en lugar de haber filas independientes para cada caja,
 * hay una única fila para todas y cuando una caja se queda vacía, el primero
 * que ocupa la fila va a ella.
 * 
 * El gerente del súper seguramente piense que ahora los clientes quedarán más
 * satisfechos con el servicio proporcionado porque saben que nunca esperarán de
 * más, pero a Ismael le han destrozado la vida. Ya no tiene la garantía de que
 * le atienda su reina del súper particular cuando le toca pagar.
 * 
 * Sólo le queda una alternativa. Cuando se aproxima a la fila única, puede
 * estimar cuánto tardará cada cliente en pasar por la caja en base a la
 * cantidad de productos en el carrito y averiguar entonces en qué caja le
 * tocará para ver si es la de su amada o no.
 * 
 * Entrada
 * La entrada estará compuesta por distintos casos de prueba, cada uno de ellos
 * representando el estado del supermercado uno de los días en los que Ismael va
 * a comprar.
 * 
 * Cada caso de prueba consta de dos líneas. La primera contiene el número n de
 * cajas abiertas en ese momento (1 ≤ n ≤ 5) y el número c de clientes esperando
 * (1 ≤ c ≤ 1.000). A continuación viene una línea con c números positivos que
 * indican el número de segundos que tardará cada cliente en ser atendido. El
 * primer número se corresponde con el tiempo de la primera persona de la fila
 * única.
 * 
 * Salida
 * Para cada caso de prueba se escribirá una línea con el número de la caja en
 * la que será atendido Ismael si se pone a esperar en ese momento.
 * 
 * Ten en cuenta que las cajas están numeradas de la 1 a la n y que en caso de
 * quedar dos cajas libres a la vez, el primer cliente irá a la caja con menor
 * número.
 * 
 * Entrada de ejemplo
 * 2 2
 * 10 5
 * 2 2
 * 5 10
 * 3 2
 * 5 10
 * Salida de ejemplo
 * 
 * 2
 * 1
 * 3
 * 
 */
