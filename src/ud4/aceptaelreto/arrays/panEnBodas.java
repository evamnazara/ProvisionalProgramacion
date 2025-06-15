package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class panEnBodas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            // Leer el número de sillas
            System.out.println("Introduce el número de sillas (0 para terminar):");
            int numSillas = sc.nextInt();
            if (numSillas == 0) {
                break; // Si es 0, terminamos
            }

            // Leer la configuración de la mesa como una cadena
            System.out.println("Introduce la configuración de la mesa (I, D, o . para cada silla):");
            String mesa = sc.next();

            // Array para marcar qué panes han sido tomados
            boolean[] panTomado = new boolean[numSillas];

            // Recorrer la mesa y marcar los panes que han sido tomados
            for (int i = 0; i < numSillas; i++) {
                if (mesa.charAt(i) == 'I') {
                    // El comensal toma el pan de su izquierda
                    int izquierda = (i - 1 + numSillas) % numSillas;
                    panTomado[izquierda] = true;
                } else if (mesa.charAt(i) == 'D') {
                    // El comensal toma el pan de su derecha
                    int derecha = (i + 1) % numSillas;
                    panTomado[derecha] = true;
                }
            }

            // Verificar si hay alguna persona sin pan
            boolean todosComen = true;
            for (int i = 0; i < numSillas; i++) {
                // Si hay un comensal (no es '.') y ninguno de sus panes fue tomado, no puede
                // comer
                if (mesa.charAt(i) != '.' && !panTomado[i]) {
                    todosComen = false;
                    break;
                }
            }

            // Imprimir el resultado
            if (todosComen) {
                System.out.println("TODOS COMEN");
            } else {
                System.out.println("ALGUNO NO COME");
            }
        }

        sc.close();
    }
}

/*
 * El pan en las bodas
 * Tiempo máximo: 2,000-3,000 s Memoria máxima: 4096 KiB
 * Mesa de una boda, con un pan a cada lado
 * A Jack Dauson le cuesta mucho aprenderse las normas de etiqueta cuando se
 * sienta en una mesa. ¿Cuál es el cuchillo de la carne? ¿Y el tenedor del
 * pescado? Pero lo que más le incomoda es no saber cuál es el pan que le
 * pertenece. Cuando se sienta a la mesa se encuentra que tanto a la izquierda
 * como a la derecha hay un platito con una barrita de pan. Uno de los dos es el
 * suyo, y el otro es el de la persona que se sienta a su lado pero… ¿a qué
 * lado? Si el suyo es el de la izquierda, el de la derecha será para el
 * comensal que se siente a la derecha. Si la barrita que hay a la derecha es la
 * suya, será justo al contrario.
 * 
 * Normalmente lo que hace es esperar a que algún otro comensal coma algo de pan
 * para deducir cuál es el suyo y así no confundirse (o al menos poder echar la
 * culpa a otro sobre su confusión). Y es que es importante no confundirse de
 * lado porque es posible que eso provoque que haya alguien que se quede sin
 * comer pan.
 * 
 * Hoy Jack está de invitado en una boda donde hay mesas redondas. Cuando se
 * acerca a la suya se da cuenta de que ya hay varias personas que han empezado
 * a comer barritas. ¿Podrán comer pan todos, o hay ya alguien que no podrá
 * porque sus dos vecinos se comerán las dos barritas que él tenía a sus dos
 * lados?
 * 
 * Entrada
 * La entrada contiene distintos casos de prueba. Cada uno de ellos contiene, en
 * una línea, la descripción de la configuración (válida) de una mesa. La línea
 * comienza con un número positivo que indica el número de asientos (como mucho
 * 1000 sillas). Tras un espacio, aparece un carácter por cada una de las sillas
 * que hay en la mesa. El carácter I indica que en esa silla el comensal ha
 * empezado la barrita de su izquierda; una D indica que ha comido de la barrita
 * de la derecha. Por último un . indica que en esa silla aún no se ha sentado
 * nadie (o que, quién lo ha hecho, aún no ha probado el pan). Los invitados a
 * la boda son personas decentes y no se roban el pan los unos a los otros, por
 * lo que si un comensal ya ha empezado una barrita, la persona de al lado no la
 * probará.
 * 
 * Ten en cuenta que la mesa es circular, por lo tanto se considera que el
 * último carácter tiene a su derecha el primero.
 * 
 * El último caso de prueba, que no deberá ser procesado, contiene una mesa sin
 * sillas.
 * 
 * Salida
 * Para cada caso de prueba se mostrará una única línea indicando si, una vez
 * llena la mesa, todos los comensales podrán comer pan (TODOS COMEN) o hay al
 * menos uno que no podrá (ALGUNO NO COME).
 * 
 * 
 * 
 * Entrada de ejemplo
 * 6 .I....
 * 6 .D.I..
 * 4 ....
 * 0
 * Salida de ejemplo
 * 
 * TODOS COMEN
 * ALGUNO NO COME
 * TODOS COMEN
 */