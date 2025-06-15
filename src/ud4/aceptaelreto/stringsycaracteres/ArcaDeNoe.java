package ud4.aceptaelreto.stringsycaracteres;

import java.util.Scanner;

public class ArcaDeNoe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bucle para procesar los casos de prueba
        while (true) {
            // Leemos la cantidad de animales
            String linea = scanner.nextLine().trim();

            // Si la línea es "0", terminamos el programa
            if (linea.equals("0")) {
                break;
            }

            // Convertimos la línea en una lista de animales
            String[] animales = linea.split(" ");
            int N = animales.length; // El número de animales en esta línea

            // Inicializamos los contadores de las parejas
            int parejasCompletas = 0;
            int parejasIncompletas = 0;
            int animalesSobrantes = 0;

            // Bucle para procesar los animales
            for (int i = 0; i < N; i++) {
                String animal = animales[i];
                boolean encontradoPareja = false;

                // Comprobamos si ya hay un animal de la misma especie con sexo opuesto
                for (int j = 0; j < N; j++) {
                    if (i != j) {
                        String otroAnimal = animales[j];
                        // Comprobamos si los nombres son iguales, pero el sexo es diferente
                        if (esPareja(animal, otroAnimal)) {
                            encontradoPareja = true;
                            // Marcamos los animales como emparejados (los hacemos vacíos)
                            animales[i] = "";
                            animales[j] = "";
                            break;
                        }
                    }
                }

                // Si encontramos una pareja completa
                if (encontradoPareja) {
                    parejasCompletas++;
                } else {
                    // Si no encontramos pareja
                    if (animal.equals("")) {
                        animalesSobrantes++;
                    } else {
                        parejasIncompletas++;
                    }
                }
            }

            // Imprimimos los resultados
            System.out.println(parejasCompletas + " " + parejasIncompletas + " " + animalesSobrantes);
        }

        scanner.close(); // Cerramos el scanner
    }

    // Función que verifica si dos animales forman una pareja válida
    public static boolean esPareja(String animal1, String animal2) {
        // Comprobamos si los nombres coinciden sin la letra final
        if (animal1.length() == animal2.length()
                && animal1.substring(0, animal1.length() - 1).equals(animal2.substring(0, animal2.length() - 1))) {
            // Comprobamos si uno termina en "o" (macho) y el otro en "a" (hembra)
            if ((animal1.charAt(animal1.length() - 1) == 'o' && animal2.charAt(animal2.length() - 1) == 'a') ||
                    (animal1.charAt(animal1.length() - 1) == 'a' && animal2.charAt(animal2.length() - 1) == 'o')) {
                return true;
            }
        }
        return false;
    }
}

/*
 * Arca de Noé
 * 
 * Con el cielo amenazando lluvia, el caos alrededor del arca de Noé está
 * llegando a unos límites inquietantes. Se han ido embarcando animales de
 * muchas especies y el lío es tremendo. Ya no se sabe si se ha dejado subir a
 * individuos de la misma especie y sexo, si hay una pareja de cada especie, si
 * hay animales sin pareja… ¡El reinicio del mundo tras el diluvio corre grave
 * peligro!
 * 
 * Afortunadamente Noé es una persona organizada y ha ido apuntando
 * religiosamente en una lista a cada animal que subía a su arca. Además, en su
 * antiguo idioma los nombres de los animales macho acaban en -o, los nombres de
 * los animales hembra terminan en -a, y tienen el resto de las letras
 * exactamente iguales entre sí.
 * 
 * Entrada
 * El programa deberá procesar múltiples casos de prueba leídos de la entrada
 * estándar. Cada uno comienza con un número 1 ≤ N ≤ 10.000 indicando cuántos
 * animales se han embarcado en el arca hasta ahora. A continuación aparecen N
 * palabras, de como mucho 20 letras minúsculas, indicando el nombre de cada
 * uno.
 * 
 * La entrada termina con un 0.
 * 
 * Salida
 * Por cada caso de prueba el programa escribirá el número de parejas de
 * animales que están completas (hay un ejemplar macho y otro hembra), cuántas
 * parejas están incompletas (falta el ejemplar macho o hembra) y cuántos
 * animales sobran, por haber ya algún otro de la misma especie y sexo. Los tres
 * valores se escribirán en la misma línea separados por un espacio.
 * 
 * Entrada de ejemplo
 * 4
 * gato perra gata perro
 * 4
 * gato perra gato perro
 * 6
 * coneja perro perra gata mono perro
 * 0
 * Salida de ejemplo
 * 2 0 0
 * 1 1 1
 * 1 3 1
 */