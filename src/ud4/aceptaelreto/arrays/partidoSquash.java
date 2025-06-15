/* Como programador novato, vamos a resolver este problema utilizando arrays y estructuras básicas en Java.

El problema se basa en simular un partido de squash donde:

El jugador A siempre empieza sacando.
Solo suma puntos el jugador que saca.
Si el jugador sin saque gana un punto, solo recupera el saque.
Los sets se ganan con 9 puntos, pero si hay empate a 8, se sigue hasta que uno tenga 2 puntos de ventaja.
El primero en ganar 3 sets, gana el partido.
El carácter F marca el final del partido.
📖 Pasos de la solución
Leer cada línea de entrada (representa un partido).
Inicializar variables para el marcador de los sets y los puntos actuales.
Recorrer cada punto (A o B) y actualizar los valores:
Si el jugador con el saque gana, suma puntos.
Si el otro jugador gana, solo cambia el saque.
Verificar si se gana un set:
Si un jugador tiene 9 puntos y el otro tiene menos de 8 → gana el set.
Si hay empate a 8, sigue hasta que uno tenga 2 de ventaja.
El que gana un set comienza sacando el siguiente.
Cuando se lee F, imprimir el resultado final en el formato correcto. */

package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class partidoSquash {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            // Leer la línea de entrada (un partido)
            String partido = sc.nextLine();

            // Si la entrada es solo "F", terminamos
            if (partido.equals("F")) {
                break;
            }

            // Variables para llevar la puntuación
            int setsA = 0, setsB = 0;
            int puntosA = 0, puntosB = 0;
            boolean saqueA = true; // A siempre comienza sacando
            String resultado = "";

            for (char punto : partido.toCharArray()) {
                if (punto == 'F') {
                    break;
                }

                if (punto == 'A') {
                    if (saqueA) {
                        puntosA++; // Si A tiene el saque, suma punto
                    } else {
                        saqueA = true; // B pierde el punto, A recupera el saque
                    }
                } else if (punto == 'B') {
                    if (!saqueA) {
                        puntosB++; // Si B tiene el saque, suma punto
                    } else {
                        saqueA = false; // A pierde el punto, B recupera el saque
                    }
                }

                // Verificar si alguien gana el set
                if ((puntosA >= 9 || puntosB >= 9) && Math.abs(puntosA - puntosB) >= 2) {
                    // Agregar el set al resultado
                    resultado += (setsA + setsB > 0 ? " " : "") + puntosA + "-" + puntosB;

                    // Actualizar sets ganados
                    if (puntosA > puntosB) {
                        setsA++;
                        saqueA = true; // Quien gana el set empieza sacando el siguiente
                    } else {
                        setsB++;
                        saqueA = false;
                    }

                    // Reiniciar la puntuación del set
                    puntosA = 0;
                    puntosB = 0;

                    // Si alguien gana 3 sets, el partido termina
                    if (setsA == 3 || setsB == 3) {
                        break;
                    }
                }
            }

            // Si el partido terminó sin un ganador, agregar el último set en curso
            if (puntosA > 0 || puntosB > 0 || resultado.isEmpty()) {
                resultado += (setsA + setsB > 0 ? " " : "") + puntosA + "-" + puntosB;
            }

            // Imprimir resultado final del partido
            System.out.println(resultado);
        }

        sc.close();
    }

}

/*
 * Es curioso esto de los marcadores en los deportes. En deportes de equipo,
 * como el fútbol o el baloncesto, el que marca el último gol o la última
 * canasta no tiene por qué ser el ganador. Para saber quién gana hay que seguir
 * el sencillo procedimiento de sumar todos los tantos y el equipo que más haya
 * conseguido es el vencedor.
 * 
 * Sin embargo, en muchos deportes individuales como el tenis, frontón o squash
 * es fácil saber quién gana. Basta con ver el último tanto del partido y el que
 * lo gane es el que se llevó la victoria final. Sin embargo recomponer el
 * marcador es más difícil.
 * 
 * Pongamos el caso del squash. Aunque hay distintas formas de puntuar, una de
 * las más utilizadas por los jugadores amateur es jugar al mejor de cinco sets.
 * El jugador que antes gane tres sets gana el partido (y en ese momento,
 * obviamente, éste termina). Los sets se juegan a 9 puntos con tres
 * matizaciones:
 * 
 * Es necesario ganar con una ventaja de al menos dos puntos, por lo tanto, si
 * se llega a un empate a 8, ganará el que llegue a 10. Si al intentarlo se
 * empata a 9, se jugará a 11, etc.
 * Los puntos sólo suben al marcador si el que ganó el tanto tenía el saque. Es
 * decir, se utiliza lo que se conoce como "recuperación del saque". Si el
 * jugador A saca y gana el punto, éste sube a su marcador. Pero si el tanto lo
 * gana B, dado que no fue él el que puso la bola en juego, recupera el saque
 * pero no puntúa.
 * El jugador que gana un set comienza sacando en el siguiente.
 * Nos piden averiguar el marcador final de un partido de squash conociendo los
 * ganadores de todos los puntos. Es posible que el partido no termine debido a
 * que el alquiler de la pista llega a su fin. En ese caso se presentará el
 * resultado parcial.
 * 
 * 
 * Entrada
 * La entrada contendrá una sucesión de partidos de squash. Cada partido
 * aparecerá en una línea distinta y será una sucesión de A's y B's que
 * indicarán que el jugador A o el jugador B ganó ese tanto. Todos los partidos
 * terminarán con el carácter F que indica que, o bien el partido terminó con un
 * ganador, o bien dejaron de jugar debido a que terminó el alquiler de la
 * pista.
 * 
 * Asume que en todos los partidos empieza sacando el jugador A.
 * 
 * La entrada termina con un partido sin tantos (es decir únicamente con una F),
 * partido que no deberá ser procesado.
 * 
 * Salida
 * Para cada partido muestra su resultado con el formato que aparece en el
 * ejemplo. Para cada set empezado aparecerá los puntos conseguidos por el
 * jugador A y tras un - los puntos conseguidos por el jugador B. Separa el
 * resultado de cada set con un espacio. No añadas un espacio tras el último
 * set.
 * 
 * Entrada de ejemplo
 * AAAAAAAAAF
 * BBBBBBBBBBF
 * AAAAAAAABBBBBBBBBBAABBBABBF
 * BF
 * F
 * Salida de ejemplo
 * 
 * 9-0
 * 0-9
 * 9-11 0-1
 * 0-0
 */