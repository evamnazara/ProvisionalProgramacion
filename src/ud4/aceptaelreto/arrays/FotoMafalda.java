package ud4.aceptaelreto.arrays;

import java.util.Scanner;

public class FotoMafalda {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // El ciclo principal que continuará hasta que se ingrese un '0' como entrada
        while (true) {
            // Leer el número de personas en la cola
            System.out.println("Introduce el número de personas que quieren hacerse una foto:");
            int numPersonas = entrada.nextInt();

            // Si el número de personas es 0, terminamos el programa
            if (numPersonas == 0) {
                System.out.println("Fin del programa.");
                break;
            }

            // Leer los personajes que cada persona quiere representar
            String[] cola = new String[numPersonas];
            System.out.println("Introduce los personajes en la cola:");
            for (int i = 0; i < numPersonas; i++) {
                cola[i] = entrada.next();
            }

            // Inicializamos las variables para contar las fotos y la gente que queda sin
            // foto
            int fotosRealizadas = 0;
            int personasSinFoto = 0;

            // Array para controlar si un personaje ya ha sido utilizado o no
            boolean[] personajesOcupados = new boolean[7]; // Mafalda, Felipe, Manolito, Susanita, Miguelito, Libertad,
                                                           // Guille

            // Procesar la cola de personas
            for (int i = 0; i < numPersonas; i++) {
                String personaje = cola[i];

                // Si el personaje es Mafalda y no está ocupado, se hace la foto
                if (personaje.equals("Mafalda") && !personajesOcupados[0]) {
                    System.out.println("Se hace la foto con Mafalda.");
                    personajesOcupados[0] = true; // Mafalda ocupa su lugar
                    int personasEnFoto = 1; // Al menos Mafalda está en la foto

                    // Intentamos llenar la foto con 2 personas más
                    for (int j = i + 1; j < numPersonas && personasEnFoto < 3; j++) {
                        String siguientePersonaje = cola[j];
                        int indicePersonaje = getIndicePersonaje(siguientePersonaje);
                        if (!personajesOcupados[indicePersonaje]) {
                            personajesOcupados[indicePersonaje] = true;
                            personasEnFoto++;
                        }
                    }

                    // Si hay suficientes personas para la foto, la contamos
                    if (personasEnFoto >= 3) {
                        fotosRealizadas++;
                    } else {
                        // Si no, las personas que intentaron tomar la foto se quedan sin foto
                        for (int j = i; j < i + personasEnFoto; j++) {
                            if (j < numPersonas) {
                                personasSinFoto++;
                            }
                        }
                    }
                } else if (!personajesOcupados[getIndicePersonaje(personaje)]) {
                    // Si el personaje no es Mafalda, pero no está ocupado, lo ocupamos
                    personajesOcupados[getIndicePersonaje(personaje)] = true;
                } else {
                    // Si el personaje está ocupado, se queda en la cola esperando
                    personasSinFoto++;
                }
            }

            // Mostrar el resultado de cada caso de prueba
            System.out.println(fotosRealizadas + " " + personasSinFoto);
        }

        entrada.close();
    }

    // Método auxiliar para obtener el índice de un personaje en el array de
    // personajes
    public static int getIndicePersonaje(String personaje) {
        switch (personaje) {
            case "Mafalda":
                return 0;
            case "Felipe":
                return 1;
            case "Manolito":
                return 2;
            case "Susanita":
                return 3;
            case "Miguelito":
                return 4;
            case "Libertad":
                return 5;
            case "Guille":
                return 6;
            default:
                return -1; // Esto no debería ocurrir si los personajes están correctamente definidos
        }
    }
}

/*
 * Foto con Mafalda
 * Tiempo máximo: 1,000-2,000 s Memoria máxima: 8192 KiB
 * Personajes de Mafalda con la cara borrada para hacerse fotos como si fueran
 * ellos
 * Para homenajear a Quino y su Universo Mafalda, en una feria de Comics
 * pusieron un mural de los personajes con las cabezas huecas, para que los
 * asistentes pudieran ponerse detrás y fotografiarse con sus caras sustituyendo
 * a las de los famosos personajes.
 * 
 * Se montó una enorme cola de gente esperando, cada uno queriendo ponerse en la
 * posición de su personaje favorito. El caos fue tal que desde entonces los
 * organizadores han puesto unas reglas muy estrictas para el uso del mural
 * cuando lo han llevado a otros eventos:
 * 
 * Todos los retratados en una foto deben representar a un personaje diferente
 * del mural.
 * Para que no queden demasiado vacías, al menos debe haber 3 personas en cada
 * foto.
 * No se hacen fotos si no hay alguien en el puesto de Mafalda. Cuando llega
 * alguien que quiere aparecer como ella, se hace inmediatamente la foto,
 * siempre que se cumpla la condición anterior.
 * Si cuando llega alguien por Mafalda no hay gente suficiente en la foto, se
 * espera hasta que lo haya.
 * Si cuando le toca el turno a alguien su personaje está ocupado, espera,
 * dejando pasar a los siguientes de la cola, hasta que su puesto queda libre.
 * Estas normas han generado algo de descontento entre los usuarios, que
 * querrían salir en las fotos con sus amigos en lugar de con desconocidos. Pero
 * son muy efectivas, porque las colas se han reducido mucho.
 * 
 * Entrada
 * Cada caso de prueba comienza con un número 1 ≤ n ≤ 200.000 indicando cuánta
 * gente quiere hacerse una foto en el mural.
 * 
 * A continuación aparecen los personajes del Universo Mafalda que cada una de
 * esas n personas quiere ser (Mafalda, Felipe, Manolito, Susanita, Miguelito,
 * Libertad o Guille).
 * 
 * La entrada termina con un 0, que no debe procesarse.
 * 
 * Salida
 * Por cada caso de prueba se escribirá una línea con dos números, indicando
 * cuántas fotos se han hecho, y cuánta gente finalmente se queda sin aparecer
 * en ninguna.
 * 
 * Entrada de ejemplo
 * 5 Felipe Manolito Mafalda Susanita Miguelito
 * 4 Mafalda Susanita Miguelito Felipe
 * 10 Felipe Felipe Felipe Susanita Miguelito Libertad Guille Mafalda Mafalda
 * Susanita
 * 0
 * Salida de ejemplo
 * 
 * 1 2
 * 1 1
 * 2 1
 * 
 */