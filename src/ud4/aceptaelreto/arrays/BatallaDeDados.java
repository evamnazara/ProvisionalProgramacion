package ud4.aceptaelreto.arrays;

public class BatallaDeDados {

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        while (true) {
            // Leer los parámetros de la batalla
            int td = scanner.nextInt(); // tropas del defensor
            int ta = scanner.nextInt(); // tropas del atacante
            int dd = scanner.nextInt(); // máximo dados del defensor
            int da = scanner.nextInt(); // máximo dados del atacante
            int no = scanner.nextInt(); // número de oleadas

            // Si el número de tropas del defensor es 0, terminamos la entrada
            if (td == 0 || ta == 0) {
                break;
            }

            // Crear los arrays para las tiradas de dados
            int[] dadosDefensor = new int[dd];
            int[] dadosAtacante = new int[da];

            // Procesar cada oleada
            for (int i = 0; i < no; i++) {
                // Leer las tiradas de dados de la oleada
                for (int j = 0; j < dd && j < td && scanner.hasNextInt(); j++) {
                    dadosDefensor[j] = scanner.nextInt();
                }

                for (int j = 0; j < da && j < ta && scanner.hasNextInt(); j++) {
                    dadosAtacante[j] = scanner.nextInt();
                }

                // Ordenar los dados de mayor a menor
                java.util.Arrays.sort(dadosDefensor, 0, dd);
                java.util.Arrays.sort(dadosAtacante, 0, da);

                // Contar las bajas para el defensor y el atacante
                int bajasDefensor = 0;
                int bajasAtacante = 0;

                // Comparar los dados emparejados
                for (int j = 0; j < Math.min(dadosDefensor.length, dadosAtacante.length); j++) {
                    if (dadosDefensor[j] >= dadosAtacante[j]) {
                        bajasAtacante++; // Defensor gana
                    } else {
                        bajasDefensor++; // Atacante gana
                    }
                }

                // Actualizar las tropas
                ta -= bajasAtacante;
                td -= bajasDefensor;

                // Si ya no hay tropas de uno de los bandos, terminar la batalla
                if (ta == 0 || td == 0) {
                    break;
                }
            }

            // Imprimir el resultado final
            System.out.println(td + " " + ta);
        }

        // Cerrar el scanner
        scanner.close();
    }
}

/*
 * Pequeña batalla de dados
 * Tiempo máximo: 1,000-2,000 s Memoria máxima: 4096 KiB
 * Silueta de soldados
 * En el juego del Risk se conquistan territorios con una estrategia basada en
 * dados. Las batallas empiezan cuando el atacante mueve un determinado número
 * de tropas al territorio que desea conquistar. A continuación, la batalla se
 * divide en oleadas. Para cada oleada, el atacante y el defensor lanzan un
 * determinado número de dados. El número de dados que tira cada contrincante no
 * puede ser mayor que el número de tropas disponibles, ni mayor que el número
 * de dados disponibles. Tras tirar los dados cada bando ordena sus dados de
 * mayor a menor y luego se alinean con los dados del enemigo. Finalmente, para
 * cada par de dados defensor-atacante el atacante pierde una tropa si el valor
 * de su dado es igual o menor que el valor del dado del defensor. En caso
 * contrario, es el defensor quien pierde una tropa. Después de cada oleada, y
 * si quedan tropas en ambos bandos, el atacante decide si retirarse o continuar
 * con la batalla.
 * 
 * Veamos un ejemplo en el que el defensor tiene 2 tropas y el atacante tiene 3.
 * El defensor tira dos dados y saca 4 y 5. El atacante tira tres dados y
 * obtiene 3, 4 y 2. Tras ordenarlos y emparejarlos, los dados quedan como en la
 * figura:
 * 
 * Ejemplo de jugada de dados en el Risk
 * En este caso, en la primera y segunda pareja de dados el defensor tiene un
 * valor mayor o igual que el atacante, por lo que este último pierde dos
 * tropas. El tercer dado del atacante se descarta ya que no está emparejado con
 * ninguno del defensor. Si el atacante continua para una segunda oleada,
 * entonces el defensor lanza dos dados y el atacante uno. Si, por ejemplo,
 * obtuvieran el defensor 1 y 5 y el atacante 6 entonces, dado que 6 es mayor
 * que 5, el defensor perdería una tropa. En una tercera oleada cada bando lanza
 * un único dado. Si ambos sacaran 5, entonces el defensor ganaría y la batalla
 * terminaría con una tropa sobreviviente en el bando defensor y ninguna en el
 * bando atacante.
 * 
 * Entrada
 * Cada batalla se describe en dos líneas. La primera línea tiene cinco números
 * enteros con la información siguiente: número de tropas de defensa (td),
 * número de tropas de ataque (ta), máximo número de dados a usar por la defensa
 * (dd), máximo número de dados a usar por el ataque (da) y número de oleadas
 * (no). Los límites para estos valores son: 1 ≤ td ≤ 100.000, 1 ≤ ta ≤ 100.000,
 * 1 ≤ dd ≤ 1.000 y 1 ≤ da ≤ 1.000. La segunda línea incluye toda la secuencia
 * de tiradas de dados en la batalla como: valores obtenidos por la defensa en
 * la primera oleada, valores obtenidos por el ataque en la primera oleada
 * (siempre se tira el máximo número de dados posible), y a continuación de
 * forma equivalente para las sucesivas oleadas. Las oleadas están siempre
 * completas, pero el atacante puede retirarse antes del final de la batalla sin
 * que haya un ganador. Siempre hay al menos una oleada. El máximo número de
 * lanzamientos de dados en una batalla es 200.000.
 * 
 * Salida
 * Para cada batalla, el programa debe imprimir una línea con el número de
 * tropas que sobreviven para el defensor y el número de tropas que sobreviven
 * para el atacante.
 * 
 * Entrada de ejemplo
 * 2 3 3 3 3
 * 4 5 3 4 2 1 5 6 5 5
 * 10 10 5 5 2
 * 1 1 1 1 1 1 1 1 1 1 2 2 2 2 2 3 3 3 3 3
 * 4 4 1 4 5
 * 1 1 1 1 1 2 2 2 3 3 1 2 4 4 2 5 5 5 5 6 2
 * Salida de ejemplo
 * 
 * 1 0
 * 5 5
 * 0 3
 * 
 */